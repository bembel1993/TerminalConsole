package entity;

import javax.persistence.*;

@Entity
@Table(name = "password")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column
    private String name;

    @Column
    private String lastname;
    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

   public User() {
    }

  /*  public User(String login, String password) {
        this.login = login;
        this.password = password;
    }*/

    public User(String name, String lastname, String password) {
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return name;
    }

    public void setLogin(String name) {
        this.name = name;
    }

    public String getPassword() {
        return lastname;
    }

    public void setPassword(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return password;
    }

    public void setRole(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

