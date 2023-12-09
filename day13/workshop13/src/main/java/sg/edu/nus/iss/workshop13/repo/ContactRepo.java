package sg.edu.nus.iss.workshop13.repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop13.model.Contact;

// repository is to provide the mechanism for storage, retrieval, search, update & delete operations on objs

@Repository
public class ContactRepo {

    final String dirPath = "/Users/ruthie/Desktop/codes/vttp23/SSF/day13/workshop13/data";
    final String fileName = "contactsss.txt";
    private List<Contact> contacts = new ArrayList<>();

    // public ContactRepo() throws ParseException {

    // check if the txt file exists in the data dir and create a new txt file if it doesnt
    public void checkFile() throws IOException {
        File f = new File(dirPath + "/" + fileName);
        if (!f.exists()){
            f.createNewFile();
        }
    }

    // save contacts
    public List<Contact> save(Contact contact) throws FileNotFoundException {

        // Contact contact = new Contact();
        contacts.add(contact);

        File f = new File(dirPath + "/" + fileName);
        OutputStream os = new FileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(os);
        /* flush ensures that the data is updated real time cos when you write data to an output stream, 
        it might not get sent immediately but get stored somewhereelse first */
        pw.write(contact.toString());
        pw.flush();
        pw.close();

        return contacts;
    }

    // delete contact
    public Boolean delete(Contact contact) {
        Boolean result = false;
        int contactIndex = contacts.indexOf(contact);

        if (contactIndex >= 0) {
            // index >= 0 means employee is present in list -> remove then result becomes true to indicate successful deletion
            contacts.remove(contactIndex);
            result = true;
        }

        return result;
    }

    public Contact findByEmail(String email) {
        // retrieve object from storage
        // iterate over each contact object in the list and call getEmail() method. map fn calls getEmail()  & retrieces email address 
        contacts.stream()
            .filter(contact -> contact.getEmail().equals(email))
            .findFirst()
            .get();

        return null;
    }

}
