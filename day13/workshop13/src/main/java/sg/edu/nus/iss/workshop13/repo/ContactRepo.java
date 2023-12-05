package sg.edu.nus.iss.workshop13.repo;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop13.model.Contact;

// repository is to provide the mechanism for storage, retrieval, search, update & delete operations on objs

@Repository
public class ContactRepo {

    final String dirPath = "/Users/ruthie/Desktop/codes/vttp23/SSF/day13";
    final String fileName = "contactsss.txt";
    private List <Contact> contacts;

    public ContactRepo() throws ParseException {
        // creating a new list if there's no contacts yet
        if(contacts == null) {
            contacts = new ArrayList<>();
        }

        DateFormat bday = new SimpleDateFormat("yyyy-MM-dd");
        // Date bday = date.parse("yyyy-mm-dd");

        Contact newcon = new Contact("name", "phone", "email", bday);
        contacts.add(newcon);
    }

    // showing all contacts
    public List<Contact> findAll() {
        return contacts;
    }

    // save contacts
    public Boolean save(Contact contact) {
        Boolean result = false;

        result = contacts.add(contact);

        File f = new File(dirPath + "/" + fileName);
        

        return result;
    }

    // delete contact
    public void delete() {

    }

}
