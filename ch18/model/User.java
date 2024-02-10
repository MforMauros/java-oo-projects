package gr.aueb.cf.ch18.model;

import java.util.Objects;

public class User extends AbstractEntity{
    private String firstname;
    private String lastname;
    private String ssn;

    public User() {
    }

    public User(String firstname, String lastname, String ssn) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    public User(User user) {
        this.firstname = user.getFirstname();
        this.lastname = user.getFirstname();
        this.ssn = user.getSsn();
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(ssn, user.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, ssn);
    }
}
