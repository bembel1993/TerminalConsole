package entity;

import javax.persistence.*;

@Entity
@Table(name = "countsals")
public class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "person_id")
    private int personId;

    @Column
    private int price;

    @Column
    private String fname;

    @Column
    private String lname;

    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    public Person() {
    }

    public Person(int price, String fname, String lname) {
        this.price = price;
        this.fname = fname;
        this.lname = lname;
        user = new User();
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getAge() {
        return price;
    }

    public void setAge(int price) {
        this.price = price;
    }

    public String getSurname() {
        return fname;
    }

    public void setSurname(String fname) {
        this.fname = fname;
    }

    public String getName() {
        return lname;
    }

    public void setName(String lname) {
        this.lname = lname;
    }

    //------------for User bind----------------
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addUser(User newUser) {
        newUser.setPerson(this);
        user = newUser;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", price=" + price +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
