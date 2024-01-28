/**
 * This package contains classes related to the user model for the application.
 */
package gr.aueb.cf.ch13;

/**
 * Represents a user with a unique ID, first name, and last name.
 */
public class User {
    private long id;
    private String firstname;
    private String lastname;

    /**
     * Default constructor for creating a new User instance.
     */
    public User() {
    }

    /**
     * Constructs a new User with the specified ID, first name, and last name.
     *
     * @param id The unique identifier for the user.
     * @param firstname The first name of the user.
     * @param lastname The last name of the user.
     */
    public User(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Gets the user's ID.
     *
     * @return The user's unique identifier.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     *
     * @param id The unique identifier to set for the user.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the user's first name.
     *
     * @return The first name of the user.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstname The first name to set for the user.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the user's last name.
     *
     * @return The last name of the user.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastname The last name to set for the user.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns a string representation of the user's data.
     *
     * @return A string containing the user's ID, first name, and last name.
     */
    public String userDataToString(){
        return "{User ID: " + id + "} " + "{User Firstname: " + firstname + "} "
                + "{User Lastname: " + lastname + "}" + "\n";
    }
}
