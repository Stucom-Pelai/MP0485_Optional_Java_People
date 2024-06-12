package Model.DataAccessObject;

import Model.Class.Person;
import Model.Class.PersonException;
import Start.Routes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This class implements the IDAO interface and completes the code of the
 * functions so that they can work with files to store objects. User data is
 * saved in the "dataFileS.ser" file and the associated photos, if any, are
 * saved with the name NIF.png in the "Photos" folder.
 *
 * @author Francesc Perez
 * @version 1.1.0
 */
public class DAOFileSerializable implements IDAO {

    @Override
    public Person read(Person p) throws IOException, ClassNotFoundException {
        Person personToRead = null;
        try {
            FileInputStream fIS = new FileInputStream(Routes.FILES.getDataFile());
            ObjectInputStream o = new ObjectInputStream(fIS);
            Person pr;
            while ((pr = (Person) o.readObject()) != null) {
                if (pr.getNif().equals(p.getNif())) {
                    personToRead = pr;
                    break;
                }
            }
            o.close();
        } catch (java.io.EOFException ex) {
            //Do nothing
//            System.out.println("El archivo está vacío y no se puede crear"
//                    + "el objeto ObjectInputStream");
        }
        return personToRead;
    }

    @Override
    public void insert(Person p) throws IOException, ClassNotFoundException {
        ArrayList<Person> personRead = new ArrayList<>();
        try {
            FileInputStream fIS = new FileInputStream(Routes.FILES.getDataFile());
            ObjectInputStream ois = new ObjectInputStream(fIS);
            Person pr;
            while ((pr = (Person) ois.readObject()) != null) {
                personRead.add(pr);
            }
            ois.close();
        } catch (java.io.EOFException ex) {
            //Do nothing
//            System.out.println("El archivo está vacío y no se puede crear"
//                   + "el objeto ObjectInputStream");
        }
        ObjectOutputStream oos;
        FileOutputStream fOS;
        fOS = new FileOutputStream(Routes.FILES.getDataFile());
        oos = new ObjectOutputStream(fOS);
        personRead.add(p);
        for (Person pf : personRead) {
            oos.writeObject(pf);
        }
        oos.flush();
        oos.close();
    }

    @Override
    public ArrayList<Person> readAll() throws IOException, ClassNotFoundException, PersonException {
        ArrayList<Person> people = new ArrayList<>();
        ObjectInputStream ois;
        FileInputStream fIS;
        fIS = new FileInputStream(Routes.FILES.getDataFile());
        ois = new ObjectInputStream(fIS);
        Person pr;
        while ((pr = (Person) ois.readObject()) != null) {
            people.add(pr);
        }
        ois.close();
        if (people.isEmpty()) {
            throw new PersonException("There aren't people registered "
                    + "yet.");
        }
        return people;
    }

    @Override
    public void update(Person p) throws FileNotFoundException, IOException, ClassNotFoundException, PersonException {
        ArrayList<Person> personRead = new ArrayList<>();
        ObjectInputStream ois;
        FileInputStream fIS;
        fIS = new FileInputStream(Routes.FILES.getDataFile());
        ois = new ObjectInputStream(fIS);
        Person pr;
        while ((pr = (Person) ois.readObject()) != null) {
            personRead.add(pr);
        }
        ois.close();
        try {
            personRead.set(personRead.indexOf(new Person(p.getNif())), p);
        } catch (IndexOutOfBoundsException ex) {
            throw new PersonException(p.getNif() + " is not registered and can "
                    + "not be UPDATED");
        }
        ObjectOutputStream oos;
        FileOutputStream fOS;
        fOS = new FileOutputStream(Routes.FILES.getDataFile());
        oos = new ObjectOutputStream(fOS);
        personRead.add(p);
        for (Person pf : personRead) {
            oos.writeObject(pf);
        }
        oos.flush();
        oos.close();
    }

    @Override
    public void delete(Person p) throws IOException, ClassNotFoundException, PersonException {
        ArrayList<Person> peopleRead = new ArrayList<>();
        FileInputStream fIS;
        ObjectInputStream ois;
        fIS = new FileInputStream(Routes.FILES.getDataFile());
        ois = new ObjectInputStream(fIS);
        Person pr;
        while ((pr = (Person) ois.readObject()) != null) {
            peopleRead.add(pr);
        }
        ois.close();
        if (!peopleRead.remove(p)) {
            throw new PersonException(p.getNif() + " is not registered and can "
                    + "not be DELETED");
        }
        ObjectOutputStream oos;
        FileOutputStream fOS;
        fOS = new FileOutputStream(Routes.FILES.getDataFile());
        oos = new ObjectOutputStream(fOS);
        peopleRead.add(p);
        for (Person pf : peopleRead) {
            oos.writeObject(pf);
        }
        oos.flush();
        oos.close();
    }

}
