package menu;

import entity.Person;
import entity.User;
import service.PersonService;
import service.serviceImpl.PersonServiceImpl;
//import validator.Validator;

import java.util.List;
import java.util.Scanner;

public class MenuFunctions {

    Scanner in = new Scanner(System.in);
    PersonService personService = new PersonServiceImpl();
    //   CompanyService companyService = new CompanyServiceImpl();
    //   CarService carService = new CarServiceImpl();

    public MenuFunctions() {
    }

    //---PERSON AND USER---//

    public void addPerson() {
        System.out.println("---Add new user---");
        Person person = getPersonInfo();
        if (person != null) {
            if (personService.addPerson(person)) {
                System.out.println("---Add is performed successful!---");
            }
        }
    }

    private Person getPersonInfo() {
        Person person = null;
        System.out.print("Enter first name: ");
        String name = in.nextLine();
        System.out.print("Enter last name: ");
        String lastname = in.nextLine();
        System.out.print("Enter price: ");
        String price = in.nextLine();
        //    if (Validator.correctPerson(name, surname, age, phone, mail)) {
        User user = getUserInfo();
        if (user != null) {
            person = new Person(Integer.parseInt(price), name, lastname);
            user.setPerson(person);
            person.setUser(user);
        } else {
            System.out.println("Password or login not corrected!");
        }
        return person;
    }

    private User getUserInfo() {
        User user = null;
        System.out.print("Enter first name of user: ");
        String fname = in.nextLine();
        System.out.print("Enter last name of user: ");
        String lastname = in.nextLine();
        System.out.print("Enter password of user: ");
        String password = in.nextLine();
        //  if(Validator.correctUser(login, password)) {
        if (checkUniqueLogin(password)) {
            user = new User(fname, lastname, password);
        } else {
            System.out.println("This password already taken!");
        }
        //}
        return user;
    }

    private boolean checkUniqueLogin(String login) {
        boolean isUnique = true;
        for (Person p : getPeople()) {
            if (p.getUser().getLogin().equals(login)) {
                isUnique = false;
            }
        }
        return isUnique;
    }

    public void updatePerson() {
        System.out.println("---Change user---");
        showPeople();
        System.out.print("Choice ID user for change: ");
        String id = in.nextLine();
        if (getPersonId(id)) {
            Person person = findPersonById(Integer.parseInt(id));
            if (person != null) {
                changeDataFromPerson(person);
                changeDataFromUser(person);
                if (personService.updatePerson(person)) {
                    System.out.println("---Change is performed!---");
                }
            }
        }
    }

    private Person changeDataFromPerson(Person person) {
        System.out.print("Enter price of user: ");
        String price = in.nextLine();
        System.out.print("Enter first name: ");
        String fname = in.nextLine();
        System.out.print("Enter last name: ");
        String lname = in.nextLine();
        //  if (Validator.correctPerson(name, surname, age, phone, mail)) {
        person.setAge(Integer.parseInt(price));
        person.setName(fname);
        person.setSurname(lname);
       /* }
        else {
            System.out.println("Личные данные не корректны!");
        }*/
        return person;
    }

    private Person changeDataFromUser(Person person) {

        System.out.print("Enter name user: ");
        String login = in.nextLine();
        System.out.print("Enter password card of user: ");
        String password = in.nextLine();
        //   if(Validator.correctUser(login, password)) {
        person.getUser().setLogin(login);
        person.getUser().setPassword(password);
        // }
        return person;
    }

    public void updateLoginAndPassword(User user) {
        System.out.println("---Change name and password---");
        changeDataFromUser(user.getPerson());
        if (personService.updatePerson(user.getPerson())) {
            System.out.println("---Change is performed!---");
        }

    }

    public void deletePerson() {
        System.out.println("---Delete user---");
        showPeople();
        System.out.print("Choice ID user for change: ");
        String id = in.nextLine();
        if (getPersonId(id)) {
            if (personService.deletePerson(Integer.parseInt(id))) {
                System.out.println("---Delete is performed!---");
            }
        }
    }

    private boolean getPersonId(String id) {
        boolean isAppropriateNumber = false;
        //   if (Validator.correctId(id)) {
        if (!(Integer.parseInt(id) < 0)) {
            isAppropriateNumber = true;
        } else {
            System.out.println("Such ID is not!");
        }
       /* }
        else {
            System.out.println("ID не корректно!");
        }*/
        return isAppropriateNumber;
    }

    public void showPeople() {
        List<Person> people = getPeople();
        if (people.size() != 0) {
            System.out.format("%10s%20s%20s%20s%20s", "ID |", "Last Name |", "First Name |", "Price |", "Password |");
            for (Person p : people) {
                System.out.println(" ");
                System.out.format("%10s%20s%20s%20s%20s", p.getPersonId() + " |", p.getName() + " |",
                        p.getSurname() + " |", p.getAge() + " |", p.getUser().getRole() + " |");


            }
            System.out.println(" ");
        } else {
            System.out.println("Users is not!");
        }
    }

    private List<Person> getPeople() {
        List<Person> people = personService.showPeople();
        return people;
    }

    private Person findPersonById(int id) {
        Person person = personService.findPersonById(id);
        return person;
    }

}

