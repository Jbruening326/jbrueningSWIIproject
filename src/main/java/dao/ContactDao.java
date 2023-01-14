package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static helper.JDBC.connection;

/**
 * This abstract class contains methods to Create, Read, Update, and Delete Contact objects from the database.
 */
public abstract class ContactDao {

    /**
     * This method retrieves a single contact record. When this method is called a single record
     * from the contacts table will be returned.
     * @param id The Contact_ID value for the chosen contact record to return.
     * @return Returns the desired contact record.
     * @throws SQLException
     */
    public static Contact get(int id) throws SQLException {

        Contact contact = null;
        String sql = "SELECT Contact_ID, Contact_Name, Email FROM contacts WHERE Contact_ID = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int contactId = rs.getInt("Contact_Id");
            String contactName = rs.getString("Contact_Name");
            String email = rs.getString("Email");


            //Print statement to check Object visually
            System.out.println(contactId + "|" + contactName + "|" + email);

            contact = new Contact(contactId, contactName, email);
        }
        return contact;
    }


    /**
     * This method retrieves all contact records. When this method is called, all records from the contacts
     * table will be returned.
     * @return Returns an observable list of all contact records.
     * @throws SQLException
     */
    public static ObservableList<Contact> getAll() throws SQLException {
        String sql = "SELECT Contact_ID, Contact_Name, Email FROM contacts";
        ObservableList<Contact> allContacts = FXCollections.observableArrayList();

        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            int contactId = rs.getInt("Contact_ID");
            String contactName = rs.getString("Contact_Name");
            String email = rs.getString("Email");


            Contact contact = new Contact(contactId, contactName, email);

            allContacts.add(contact);

            //Print statement to test output
            System.out.println(contactId + "|" + contactName + "|" + email);
        }

        return allContacts;
    }


    /**
     * Method not implemented. At this time, project specifications restrict Contact objects to read only.
     * @param contact The Contact object to be inserted.
     * @return Returns 0 at this time.
     * @throws SQLException
     */
    public static int insert(Contact contact) throws SQLException {
        return 0;
    }


    /**
     * Method not implemented. At this time, project specifications restrict Contact objects to read only.
     * @param contact The Contact object to be updated.
     * @return Returns 0 at this time.
     * @throws SQLException
     */
    public static int update(Contact contact) throws SQLException {
        return 0;
    }


    /**
     * Method not implemented. At this time, project specifications restrict Contact objects to read only.
     * @param contact The Contact object to be deleted.
     * @return Returns 0 at this time.
     * @throws SQLException
     */
    public static int delete(Contact contact) throws SQLException {
        return 0;
    }
}
