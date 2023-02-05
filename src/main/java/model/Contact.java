package model;

/**
 * This class contain constructor, getters, and setters  and toString method for Contact objects. Author: Joseph Bruening
 */
public class Contact {
   private int contactID;
   private String name;
   private String email;

    /**
     * This method is the constructor for the Contact object. When this method is called a new Contact object will be created.
      * @param contactID The contactID for the Contact object
     * @param name The name for the contact object
     * @param email The email for the contact object
     */
   public Contact(int contactID, String name, String email) {
        this.contactID = contactID;
        this.name = name;
        this.email = email;
    }

    /**
     * This is a getter method. This method will get the contactID for the Contact object.
     * @return Returns the contactID for the Contact object.
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * This is a setter method. This method will set the value of the contactID for a Contact object.
     * @param contactID The value of which to set the contactID of the Contact object to.
     */
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    /**
     * This is a getter method. This method will get the name for the Contact object.
     * @return Returns the name for the Contact object.
     */
    public String getName() {
        return name;
    }

    /**
     * This is a setter method. This method will set the value of the name for a Contact object.
     * @param name The value of which to set the name of the Contact object to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a getter method. This method will get the email for the Contact object.
     * @return Returns the email for the Contact object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * This is a setter method. This method will set the value of the email for a Contact object.
     * @param email The value of which to set the email of the Contact object to.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method overrides the toString() method. When this method is called a custom toString() of the Contact object
     * will be implemented.
     * @return Returns the custom string of the Contact object
     */
    @Override
    public String toString(){
       return(Integer.toString(contactID) + " " + name);
    }
}
