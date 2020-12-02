import java.io.FileNotFoundException;
import java.util.*;
public class ContactApp {

    public static void main(String[] args) throws FileNotFoundException, InvalidEditException {
        Scanner scan = new Scanner(System.in);
        ContactList contact_list= new ContactList();
        System.out.println("Welcome to the app! As you move along, please select the number associated with the operation you would like to make");
        System.out.println("---------");
        main_menu:while(true){
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");
            int operation = scan.nextInt();
            scan.nextLine();
            if(operation<0 || operation>4){
                System.out.println("Operation does not exist, please try again!");
                continue;
            }
            if(operation==1){
                System.out.println("New Contact list has been created");
                contact_list= new ContactList();
            }
            else if(operation==2){
                //load the list
                contact_list = new ContactList();
                System.out.println("Input the file name to load:");
                String filename = scan.nextLine();
                contact_list.load_list(filename);
            }
            else if(operation==3){
                System.out.println("Thank you for using The App today!");
                break;
            }
            contact_menu:while(true){
                System.out.println("List Operation Menu");
                System.out.println("---------");
                System.out.println("(1) view the list");
                System.out.println("(2) add an item");
                System.out.println("(3) edit an item");
                System.out.println("(4) remove an item");
                System.out.println("(5) save the current list");
                System.out.println("(6) quit to the main menu");
                operation = scan.nextInt();
                scan.nextLine();
                System.out.println("Selected "+operation);
                if(operation<0 || operation>8) {
                    System.out.println("Operation does not exist, please try again!");
                    continue;
                }
                if(operation == 1){
                    contact_list.view_list();
                    continue contact_menu;
                }
                else if(operation == 2){
                    String firstName = "", lastName = "", phoneNumber = "", emailAddress = "";
                    System.out.println("First name: ");
                    firstName = scan.nextLine();
                    System.out.println("Last name: ");
                    lastName = scan.nextLine();
                    while(true) {
                        System.out.println("Phone number: ");
                        phoneNumber = scan.nextLine();
                        if(!is_valid_Number(phoneNumber)){
                            System.out.println("Date entered is invalid, please try again: ");
                            continue;
                        }else{
                            break;
                        }
                    }
                    while(true){
                        System.out.println("Email Address: ");
                        emailAddress = scan.nextLine();
                        if(!is_valid_email(emailAddress)){
                            System.out.println("Email entered is invalid, please try again");
                            continue;
                        }else{
                            break;
                        }
                    }
                    if(firstName.length()==0 && lastName.length()==0 && phoneNumber.length()==0 && emailAddress.length()==0){
                        System.out.println("No contact details entered, going back to task menu");
                        continue contact_menu;
                    }
                    System.out.println("Contact added sucessfully");
                    contact_list.add_item(new ContactItem(firstName,lastName,phoneNumber,emailAddress));
                    continue contact_menu;
                }
                else if(operation == 3){
                    int size = contact_list.get_size();
                    if(size==0){
                        System.out.println("There are no items to edit! going back to list operation menu");
                        continue contact_menu;
                    }
                    System.out.println("Which item would you like to edit? (0-"+(size-1)+"): ");
                    int item_idx = scan.nextInt();
                    scan.nextLine();
                    while(item_idx<0 || item_idx>=size){
                        System.out.println("item index does not exist, please try again: ");
                        item_idx = scan.nextInt();
                        scan.nextLine();
                    }
                    System.out.println("What would you like to edit? (1):Firstname, (2):Lastname, (3):Phone number, (4):Email address ");
                    int variable_idx = scan.nextInt();
                    scan.nextLine();
                    while(variable_idx<1 || variable_idx>4){
                        System.out.println("variable index does not exist, please try again: ");
                        variable_idx = scan.nextInt();
                        scan.nextLine();
                    }
                    System.out.println("Please enter your change: ");
                    String change = "";
                    change = scan.nextLine();
                    if(variable_idx==3){
                        while(true){
                            if(!is_valid_Number(change)){
                                System.out.println("Number entered is invalid, please try again: ");
                                change = scan.nextLine();
                                continue;
                            }else{
                                break;
                            }
                        }
                    }
                    if(variable_idx==4){
                        while(true){
                            if(!is_valid_email(change)){
                                System.out.println("Email address entered is invalid, please try again: ");
                                change = scan.nextLine();
                                continue;
                            }else{
                                break;
                            }
                        }
                    }

                    contact_list.edit_item(item_idx,variable_idx,change);
                    continue contact_menu;
                }
                else if(operation == 4){
                    int size = contact_list.get_size();
                    if(size==0){
                        System.out.println("There are no items to remove! going back to list operation menu");
                        continue contact_menu;
                    }
                    System.out.println("Which item would you like to remove? (0-"+(size-1)+"): ");
                    int item_idx = scan.nextInt();
                    scan.nextLine();
                    while(item_idx<0 || item_idx>=size){
                        System.out.println("item index does not exist, please try again: ");
                        item_idx = scan.nextInt();
                        scan.nextLine();
                    }
                    contact_list.remove_item(item_idx);
                    continue contact_menu;
                }
                else if(operation == 5){
                    System.out.println("Enter the filename to save as: ");
                    String name = scan.nextLine();
                    contact_list.save_list(name);
                    continue contact_menu;
                }
                else if(operation == 6){
                    continue main_menu;
                }

            }
        }
    }
    public static boolean is_valid_Number(String in){
        boolean good = true;
        if(in.length()!=12)return false;
        if (in.charAt(3) != '-' || in.charAt(7) != '-') good = false;
        if (count_hyphen(in) > 2) good = false;
        String[] split = in.split("-");
        int[] lengths = {3, 3, 4};
        for (int i = 0; i < split.length; i++) {
            String now = split[i];
            if (!all_numbers(now)) good = false;
            if (now.length() != lengths[i]) good = false;
        }
        return good;
    }
    public static boolean all_numbers(String in){
        for(int i = 0;i<in.length();i++){
            if(in.charAt(i)<'0' || in.charAt(i)>'9')return false;
        }
        return true;
    }
    public static int count_hyphen(String in){
        int count = 0;
        for(int i = 0;i<in.length();i++){
            if(in.charAt(i)=='-')count++;
        }
        return count;
    }
    public static boolean is_valid_email (String in) {
        String[] split = in.split("@");
        if (split.length != 2) {
            return false;
        }

        String[] right = split[1].split("\\.");
        if (right.length != 2) {
            return false;
        }
        return true;
    }
}
