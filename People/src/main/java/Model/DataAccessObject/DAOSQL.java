package Model.DataAccessObject;

import Model.Class.Person;
import Model.Class.PersonException;
import Start.Routes;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * This class implements the IDAO interface and completes the function code
 * blocks so that they can operate with a SQL DDBB. The NIF is used as the
 * primary key.
 *
 * @author Francesc Perez
 * @version 1.1.0
 */
public class DAOSQL implements IDAO {

    private final String SQL_SELECT_ALL = "SELECT * FROM " + Routes.DB.getDbServerDB() + "." + Routes.DB.getDbServerTABLE() + ";";
    private final String SQL_SELECT = "SELECT * FROM " + Routes.DB.getDbServerDB() + "." + Routes.DB.getDbServerTABLE() + " WHERE (nif = ?);";
    private final String SQL_INSERT = "INSERT INTO " + Routes.DB.getDbServerDB() + "." + Routes.DB.getDbServerTABLE() + " (nif, name, dateOfBirth, photo) VALUES (?, ?, ?, ?);";
    private final String SQL_UPDATE = "UPDATE " + Routes.DB.getDbServerDB() + "." + Routes.DB.getDbServerTABLE() + " SET name = ? dateOfBirth = ? SET photo = ? WHERE (nif = ?);";
    private final String SQL_DELETE = "DELETE FROM " + Routes.DB.getDbServerDB() + "." + Routes.DB.getDbServerTABLE() + " WHERE (nif = ";

    public Connection connect() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection(Routes.DB.getDbServerAddress() + Routes.DB.getDbServerComOpt(), Routes.DB.getDbServerUser(), Routes.DB.getDbServerPassword());
        return conn;
    }

    public void disconnect(Connection conn) throws SQLException {
        conn.close();
    }

    @Override
    public Person read(Person p) throws SQLException {
        Person pReturn = null;
        Connection conn;
        PreparedStatement instruction;
        ResultSet rs;
        conn = connect();
        instruction = conn.prepareStatement(SQL_SELECT);
        instruction.setString(1, p.getNif());
        rs = instruction.executeQuery();
        while (rs.next()) {
            String nif = rs.getString("nif");
            String name = rs.getString("name");
            Date date = rs.getDate("dateOfBirth");
            String photo = rs.getString("photo");
            if (photo != null) {
                pReturn = new Person(nif, name, date, new ImageIcon(photo));
            } else {
                pReturn = new Person(nif, name, date, null);
            }
        }
        rs.close();
        instruction.close();
        disconnect(conn);
        return pReturn;
    }

    @Override
    public void insert(Person p) throws IOException, SQLException {
        Connection conn;
        PreparedStatement instruction;
        conn = connect();
        instruction = conn.prepareStatement(SQL_INSERT);
        instruction.setString(1, p.getNif());
        instruction.setString(2, p.getName());
        instruction.setDate(3, new java.sql.Date((p.getDateOfBirth()).getTime()));
        if (p.getPhoto() != null) {
            String sep = File.separator;
            File photo = new File(Routes.DB.getFolderPhotos() + sep + p.getNif() + ".png");
            FileOutputStream out;
            BufferedOutputStream outB;
            out = new FileOutputStream(photo);
            outB = new BufferedOutputStream(out);
            BufferedImage bi = new BufferedImage(p.getPhoto().getImage().getWidth(null),
                    p.getPhoto().getImage().getHeight(null),
                    BufferedImage.TYPE_INT_ARGB);
            bi.getGraphics().drawImage(p.getPhoto().getImage(), 0, 0, null);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);
            byte[] img = baos.toByteArray();
            for (int i = 0; i < img.length; i++) {
                outB.write(img[i]);
            }
            outB.close();
            instruction.setString(4, photo.getPath());
        } else {
            instruction.setString(4, null);
        }
        instruction.executeUpdate();
        instruction.close();
        disconnect(conn);
    }

    @Override
    public ArrayList<Person> readAll() throws SQLException, PersonException {
        ArrayList<Person> people = new ArrayList<>();
        Connection conn;
        Statement instruction;
        ResultSet rs;
        conn = connect();
        instruction = conn.createStatement();
        rs = instruction.executeQuery(SQL_SELECT_ALL);
        while (rs.next()) {
            String nif = rs.getString("nif");
            String name = rs.getString("name");
            Date date = rs.getDate("dateOfBirth");
            String photo = rs.getString("photo");
            if (photo != null) {
                people.add(new Person(nif, name, date, new ImageIcon(photo)));
            } else {
                people.add(new Person(nif, name, date, null));
            }
        }
        rs.close();
        instruction.close();
        disconnect(conn);
        if (people.isEmpty()) {
            throw new PersonException("There aren't people registered.");
        }
        return people;
    }

    @Override
    public void update(Person person) throws FileNotFoundException, SQLException, IOException {
        Connection conn;
        PreparedStatement instruction;
        conn = connect();
        instruction = conn.prepareStatement(SQL_UPDATE);
        instruction.setString(1, person.getName());
        instruction.setDate(2, new java.sql.Date((person.getDateOfBirth()).getTime()));
        if (person.getPhoto() != null) {
            String sep = File.separator;
            String projectPath = System.getProperty("user.dir");
            String folderPath = projectPath + sep + "PeopleDDBB";
            String folderPhotoPath = folderPath + sep + "PhotosDDBB";
            File imagePerson = new File(folderPhotoPath + sep + person.getNif() + ".gif");
            FileOutputStream out;
            BufferedOutputStream outB;
            out = new FileOutputStream(imagePerson);
            outB = new BufferedOutputStream(out);
            BufferedImage bi = new BufferedImage(person.getPhoto().getImage().getWidth(null),
                    person.getPhoto().getImage().getHeight(null),
                    BufferedImage.TYPE_INT_ARGB);
            bi.getGraphics().drawImage(person.getPhoto().getImage(), 0, 0, null);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);
            byte[] img = baos.toByteArray();
            for (int i = 0; i < img.length; i++) {
                outB.write(img[i]);
            }
            outB.close();
            instruction.setString(3, imagePerson.getPath());
        } else {
            instruction.setString(3, null);
        }
        instruction.executeUpdate();
        instruction.close();
        disconnect(conn);
    }

    @Override
    public void delete(Person person) {
        Connection conn = null;
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            String query = SQL_DELETE + "'" + person.getNif() + "'" + ");";
            instruction = conn.prepareStatement(query);
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            //Decide what to do
        } finally {
            try {
                if (instruction != null) {
                    instruction.close();
                }
                disconnect(conn);
            } catch (SQLException ex) {
                //Decide what to do
            }
        }
//        return registers;
    }

}
