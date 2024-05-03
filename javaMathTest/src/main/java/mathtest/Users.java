package mathtest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String hashPassword;

    public Users() {
    }

    public Users(String firstName, String lastName, String hashPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashPassword = hashPassword;
    }

    public int getId() {return id;}

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHashPassword() {return hashPassword;}
    public void setHashPassword(String hashPassword) {this.hashPassword = hashPassword;}
}