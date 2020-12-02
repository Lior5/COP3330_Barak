import java.io.FileNotFoundException;
import java.util.*;
public class TaskApp {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        TaskList task_list= new TaskList();
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
                System.out.println("New task list has been created");
                task_list= new TaskList();
            }
            else if(operation==2){
                //load the list
                task_list = new TaskList();
                System.out.println("Input the file name to load:");
                String filename = scan.nextLine();
                task_list.load_list(filename);
            }
            else if(operation==3){
                System.out.println("Thank you for using The App today!");
                break;
            }
            task_menu:while(true){
                System.out.println("List Operation Menu");
                System.out.println("---------");
                System.out.println("(1) view the list");
                System.out.println("(2) add an item");
                System.out.println("(3) edit an item");
                System.out.println("(4) remove an item");
                System.out.println("(5) mark an item as completed");
                System.out.println("(6) unmark an item as completed");
                System.out.println("(7) save the current list");
                System.out.println("(8) quit to the main menu");
                operation = scan.nextInt();
                scan.nextLine();
                System.out.println("Selected "+operation);
                if(operation<0 || operation>8) {
                    System.out.println("Operation does not exist, please try again!");
                    continue;
                }
                if(operation == 1){
                    task_list.view_list();
                    continue task_menu;
                }
                else if(operation == 2){
                    String title = "", desc = "", date = "";
                    System.out.println("Please enter the task title: ");
                    title = scan.nextLine();
                    System.out.println("Would you like to enter a description? (Y|N): ");
                    String check = scan.nextLine();
                    if(check.toLowerCase().startsWith("y")){
                        System.out.println("Please enter a description: ");
                        desc = scan.nextLine();
                    }
                    while(true) {
                        System.out.println("Please enter a due date: ");
                        date = scan.nextLine();
                        if(!is_valid_date(date)){
                            System.out.println("Date entered is invalid, please try again: ");
                            continue;
                        }else{
                            break;
                        }
                    }
                    task_list.add_item(new TaskItem(title,desc,date));
                    continue task_menu;
                }
                else if(operation == 3){
                    int size = task_list.get_size();
                    if(size==0){
                        System.out.println("There are no items to edit! going back to list operation menu");
                        continue task_menu;
                    }
                    System.out.println("Which item would you like to edit? (0-"+(size-1)+"): ");
                    int item_idx = scan.nextInt();
                    scan.nextLine();
                    while(item_idx<0 || item_idx>=size){
                        System.out.println("item index does not exist, please try again: ");
                        item_idx = scan.nextInt();
                        scan.nextLine();
                    }
                    System.out.println("What would you like to edit? (1):Title, (2):Description, (3):Due Date: ");
                    int variable_idx = scan.nextInt();
                    scan.nextLine();
                    while(variable_idx<1 || variable_idx>3){
                        System.out.println("variable index does not exist, please try again: ");
                        variable_idx = scan.nextInt();
                        scan.nextLine();
                    }
                    if(variable_idx==2){
                        System.out.println("Would you like to clear the description? (Y|N): ");
                        String check = scan.nextLine();
                        if(check.toLowerCase().startsWith("y")){
                            task_list.edit_item(item_idx,variable_idx,"");
                            continue task_menu;
                        }
                    }
                    System.out.println("Please enter your change: ");
                    String change = "";
                    change = scan.nextLine();
                    if(variable_idx==3){
                        while(true){
                            if(!is_valid_date(change)){
                                System.out.println("Date entered is invalid, please try again: ");
                                change = scan.nextLine();
                                continue;
                            }else{
                                break;
                            }
                        }
                    }
                    task_list.edit_item(item_idx,variable_idx,change);
                    continue task_menu;
                }
                else if(operation == 4){
                    int size = task_list.get_size();
                    if(size==0){
                        System.out.println("There are no items to remove! going back to list operation menu");
                        continue task_menu;
                    }
                    System.out.println("Which item would you like to remove? (0-"+(size-1)+"): ");
                    int item_idx = scan.nextInt();
                    scan.nextLine();
                    while(item_idx<0 || item_idx>=size){
                        System.out.println("item index does not exist, please try again: ");
                        item_idx = scan.nextInt();
                        scan.nextLine();
                    }
                    task_list.remove_item(item_idx);
                    continue task_menu;
                }
                else if(operation == 5){
                    int size = task_list.get_size();
                    if(size==0){
                        System.out.println("The list is empty! going back to list operation menu");
                        continue task_menu;
                    }
                    System.out.println("Which item would you like to mark as completed? (0-"+(size-1)+"): ");
                    int item_idx = scan.nextInt();
                    scan.nextLine();
                    while(item_idx<0 || item_idx>=size){
                        System.out.println("item index does not exist, please try again: ");
                        item_idx = scan.nextInt();
                        scan.nextLine();
                    }
                    task_list.mark_completed(item_idx);
                    continue task_menu;
                }
                else if(operation == 6){
                    int size = task_list.get_size();
                    if(size==0){
                        System.out.println("The list is empty! going back to list operation menu");
                        continue task_menu;
                    }
                    System.out.println("Which item would you like to mark as uncompleted? (0-"+(size-1)+"): ");
                    int item_idx = scan.nextInt();
                    scan.nextLine();
                    while(item_idx<0 || item_idx>=size){
                        System.out.println("item index does not exist, please try again: ");
                        item_idx = scan.nextInt();
                        scan.nextLine();
                    }
                    task_list.mark_uncompleted(item_idx);
                    continue task_menu;
                }
                else if(operation == 7){
                    System.out.println("Enter the filename to save as: ");
                    String name = scan.nextLine();
                    task_list.save_list(name);
                    continue task_menu;
                }
                else if(operation == 8){
                    continue main_menu;
                }

            }
        }
    }
    public static boolean is_valid_date(String in) {
        //months are 1-indexed
        int[] days_in_month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (in.charAt(4) != '-' || in.charAt(7) != '-') return false;
        if (count_hyphen(in) > 2) return false;
        String[] split = in.split("-");
        int[] lengths = {4, 2, 2};
        for (int i = 0; i < split.length; i++) {
            String now = split[i];
            if (!all_numbers(now)) return false;
            if (now.length() != lengths[i]) return false;
        }
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        if(month>12 || month<1) return false;
        int cap = days_in_month[month];
        //if it's a leap year and we are on february, there are 29 days
        if(is_leap_year(year) && month==2)cap = 29;
        if(day<1 || day>cap)return false;
        return true;
    }
    public static boolean is_leap_year(int in){
        if(in%400==0) return true;
        if(in%100==0)return false;
        if(in%4==0)return true;
        return false;
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
}
