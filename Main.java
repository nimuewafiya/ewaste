import java.util.*;
import java.io.*;

public class Main{

    public static void main (String[] args) throws IOException{

        Scanner input = new Scanner(System.in);
        Boolean logout = false;
        String horizontalBorder = "* ===================================================== *\n";
        Database database = new Database();
        GeneralUser user = null;
        AdminUser admin = null;
        //MAIN LOGIN PAGE//
        System.out.println(horizontalBorder);
        System.out.println("                    E-WASTE MANAGEMENT\n");
        System.out.println(horizontalBorder);
        System.out.println("Please login or sign up to continue: \n");
        System.out.println("1. User login \n");
        System.out.println("2. Admin login \n");
        System.out.println("3. User sign-up (NEW USERS ONLY) \n");
        System.out.print("Please type in the corresponding number for your choice: ");
        int loginChoice = input.nextInt();

        switch (loginChoice) {
            case 1:
                System.out.println(horizontalBorder);
                System.out.println("                       USER LOGIN\n");
                System.out.println(horizontalBorder);
                System.out.println("Welcome user! Please enter your ID and password below!\n");
                System.out.print("ID: ");
                String id = input.next();
                System.out.print("Password: ");
                String password = input.next();  
                    ArrayList<GeneralUser> users = database.getUserInfo();
                    for (GeneralUser x: users){
                        if ( (id.equals(x.getUsername())) && (password.equals(x.getPassword()))){
                            System.out.println("\nHELLO " + x.getName());
                            user = x;
                            break;
                        }
                    }
                System.out.println(horizontalBorder);
                break;
            case 2: 
                System.out.println(horizontalBorder);
                System.out.println("                       ADMIN LOGIN\n");
                System.out.println(horizontalBorder);
                System.out.println("Welcome admin! Please enter your ID and password below!\n");
                System.out.print("ID: ");
                String id2 = input.next();
                System.out.print("Password: ");
                String password2 = input.next();  
                    ArrayList<AdminUser> ausers = database.getAdminInfo();
                    for (AdminUser x: ausers){
                        if ( (id2.equals(x.getUsername())) && (password2.equals(x.getPassword()))){
                            System.out.println("\nHELLO " + x.getName());
                            admin = x;
                            break;
                        }
                    }
                System.out.println(horizontalBorder);
                break;
            case 3:
                System.out.println(horizontalBorder);
                System.out.println("                       USER SIGN-UP\n");
                System.out.println(horizontalBorder);
                System.out.println("Welcome new user! Please enter your name, new ID and new password below!\n");
                System.out.print("Name: ");
                String name = input.next();
                System.out.print("ID: ");
                String id3 = input.next();
                System.out.print("Password: ");
                String password3 = input.next();
                GeneralUser g = new GeneralUser(name,id3,password3,"0");
                database.setNewUser(g);
                System.out.println("\nCongratulations " + g.getName() + "!" + " You are a new user! Get ready to recycle!");
                System.out.println(horizontalBorder);
                user = g;
                break;
        }

        //User Application Experience
        if ( (loginChoice == 1) || (loginChoice == 3) ){
            do {
                database.printUserMainMenu();
                int userOption = input.nextInt();
                switch (userOption){
                    case 1:
                        database.printWasteItemMenu();
                        break;
                    case 2:
                        database.printWasteItemMenu();
                        System.out.print("Enter item id: ");
                        String itemId = input.next();
                        System.out.print("Quantity of item: ");
                        String quantity = input.next();
                        String pointsEarned = database.userRecycles(user, itemId, quantity);
                        System.out.println("Points earned: " + pointsEarned);
                        int totalPoints = Integer.parseInt(user.getPoints()) + Integer.parseInt(pointsEarned);
                        user.setPoints(totalPoints);
                        System.out.println("Total points earned: " + String.valueOf(totalPoints));
                        break;
                    case 3:
                        database.printRedemptionItemMenu();
                        System.out.println("Current points: " + user.getPoints());
                        System.out.print("Enter item id to redeem: ");
                        String redemptionId = input.next();
                        String pointsDeducted = database.userRedeems(user,redemptionId);
                        System.out.println("Successfully redeemed item!");
                        int pointBalance = Integer.valueOf(user.getPoints()) - Integer.valueOf(pointsDeducted);
                        user.setPoints(pointBalance);
                        System.out.println("Point balance: " + user.getPoints());
                        break;
                    case 4:
                        ArrayList<LocationItem> case4 = database.getLocationItems();
                        database.printMainLocationMenu(case4);
                        System.out.print("\n" + "Select your area: ");
                        int areaChoice = input.nextInt();
                        database.printSpecificLocations(case4.get(areaChoice-1));
                        break;
                    case 5:
                        System.out.println("Thank you for using our application! You have been logged out!");
                        logout = true;
                        break;
                }

            } while (logout != true);
        //Admin Application Experience
        } else if (loginChoice == 2){
            do {
                database.printAdminMainMenu();
                int adminOption = input.nextInt();
                input.nextLine();
                switch (adminOption) {
                    case 1:
                        database.printWasteItemMenu();
                        System.out.print("Name of waste item: ");
                        String newWasteItem = input.nextLine();
                        System.out.print("Points: ");
                        String newWasteItemPoints = input.next();
                        database.addWasteItem(newWasteItem, newWasteItemPoints, admin);
                        System.out.println("Successfully added item!");
                        break;
                    case 2:
                        database.printWasteItemMenu();
                        System.out.print("Item ID to delete: ");
                        String wasteItemToDelete = input.next();
                        database.deleteWasteItem(wasteItemToDelete, admin);
                        System.out.println("Successfully deleted item!");
                        break;
                    case 3:
                        database.printRedemptionItemMenu();
                        System.out.print("Name of redemption: ");
                        String newRedemptionItem = input.nextLine();
                        System.out.print("Points: ");
                        String newRedemptionItemPoints = input.next();
                        database.addRedemptionItem(newRedemptionItem, newRedemptionItemPoints, admin);
                        System.out.println("Successfully added item!");
                        break;
                    case 4:
                        database.printRedemptionItemMenu();
                        System.out.print("Item ID to delete: ");
                        String redemptionItemToDelete = input.next();
                        database.deleteRedemptionItem(redemptionItemToDelete, admin);
                        System.out.println("Successfully deleted item!");
                        break;
                    case 5:
                        System.out.println("Thank you for using our application! You have been logged out!");
                        logout = true;
                        break;
                }
            } while (logout != true);
        }

        }

    }
