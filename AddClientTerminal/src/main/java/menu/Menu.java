package menu;

import authorization.LogIn;
import authorization.SignUp;
import entity.User;

import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    Scanner in = new Scanner(System.in);
    MenuFunctions menuFunctions = new MenuFunctions();

    public void IntroducingMenu() {
        LogIn logIn = new LogIn();
        SignUp signUp = new SignUp();
        String choice = "0";
        while (Integer.parseInt(choice) != 3) {
            String s = "Menu\n" +
                    "1. Enter password car of user\n" +
                    "2. Registration user\n" +
                    "3. Exite\n" +
                    "Choice: ";
            System.out.print(s);
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    logIn.authorization();
                    break;
                case "2":
                    signUp.registration();
                    break;
                case "3":
                    System.out.println("Good by !");
                    break;
                default:
                    System.out.println("Verify the correct of the input !");
                    choice = "0";
                    break;
            }
        }
    }

    public void AdminMenu() {
        String choice = "0";
        while (Integer.parseInt(choice) != 4) {
            String s = "Admin menu\n" +
                    "1. Work with users\n" +
                    "2. Exit\n" +
                    "Choice: ";
            System.out.print(s);
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    AdminMenuWithUsers();
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Проверьте корректность ввода!");
                    choice = "0";
                    break;
            }
        }
    }

   /* public void UserMenu(User currentUser) {
        String choice = "0";
        while (Integer.parseInt(choice) != 10) {
            String s = "Меню пользователя\n" +
                    "1. Просмотреть все компании\n" +
                    "11. Добавить компанию\n" +
                    "2. Просмотреть все модели машин\n" +
                    "22. Добавить модели машин\n" +
                    "3. Найти компанию по названию\n" +
                    "4. Найти модель машины по названию\n" +
                    "5. Отредактировать свой профиль\n" +
                    "6. Обновить компанию\n" +
                    "7. Удалить компанию\n" +
                    "8. Обновить автомобиль\n" +
                    "9. Удалить автомобиль\n" +
                    "10. Выход\n" +
                    "Выбор: ";
            System.out.print(s);
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    menuFunctions.showCompanies();
                    break;
                case "11":
                    menuFunctions.addCompany();
                    break;
                case "2":
                    menuFunctions.showCars();
                    break;
                case "22":
                    menuFunctions.addCar();
                    break;
                case "3":
                    menuFunctions.showOneCompany();
                    break;
                case "4":
                    menuFunctions.findCarByName();
                    break;
                case "5":
                    menuFunctions.updateLoginAndPassword(currentUser);
                    break;
                case "6":
                    menuFunctions.updateCompany();
                    break;
                case "7":
                    menuFunctions.deleteCompany();
                    break;
                case "8":
                    menuFunctions.updateCar();
                    break;
                case "9":
                    menuFunctions.deleteCar();
                    break;
                case "10":
                    break;
                default:
                    System.out.println("Проверьте корректность ввода!");
                    choice = "0";
                    break;
            }
        }
    }*/

    public void AdminMenuWithUsers() {
        String choice = "0";
        while (Integer.parseInt(choice) != 5) {
            String s = "Work with user\n" +
                    "1. Add user\n" +
                    "2. Change date user\n" +
                    "3. Delete user\n" +
                    "4. View all user\n" +
                    "5. Exit\n" +
                    "Choice: ";
            System.out.print(s);
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    menuFunctions.addPerson();
                    break;
                case "2":
                    menuFunctions.updatePerson();
                    break;
                case "3":
                    menuFunctions.deletePerson();
                    break;
                case "4":
                    menuFunctions.showPeople();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Verify the correct to the input!");
                    choice = "0";
                    break;
            }
        }
    }

}

