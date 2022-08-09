package authorization;

import entity.Person;
import entity.User;
import menu.Menu;
import service.PersonService;
import service.serviceImpl.PersonServiceImpl;

import java.util.List;
import java.util.Scanner;

public class LogIn {

    Scanner in = new Scanner(System.in);

    public void authorization() {

        PersonService personService = new PersonServiceImpl();
        List<Person> people = personService.showPeople();
        System.out.print("Enter name: ");
        String login = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();
        User currentUser = null;
        for(Person p : people) {
            if(p.getUser().getLogin().equals(login) && p.getUser().getPassword().equals(password)) {
                currentUser = p.getUser();
                p.setPersonId(people.size());
            }
            if (p.getUser().getLogin().equals(login) && !p.getUser().getPassword().equals(password)) {
                System.out.println("Verify the correct to the input!");
            }
        }
        if (currentUser != null) {
            System.out.println("Authorization completed is successful! Your welcome ! " +
                    currentUser.getPerson().getSurname() + " " + currentUser.getPerson().getName());
            Menu menu = new Menu();
            String role = currentUser.getRole();
            switch (role) {
                case "Admin":
                    menu.AdminMenu();
                    break;
          /*      case "User":
                    menu.UserMenu(currentUser);
                    break;*/
            }
        }
        else {
            System.out.println("Such user is not found");
        }
    }
}
