package org.exoplatform.training.Entity;
import org.exoplatform.commons.api.persistence.ExoEntity;


import javax.persistence.*;


@ExoEntity
@Entity
@Table(name = "users")
public class Users {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private  String firstname ;
    private String lastname ;
    private String email;
    private int age ;
    private String password ;
    public Users(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(long id, String firstname, String lastname, String email, int age, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.password = password;
    }
}
