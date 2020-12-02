import java.io.PrintWriter;
import java.util.*;
import java.io.*;
public class ContactList {
    private ArrayList<ContactItem> list;
    public ContactList() {
        list = new ArrayList<>();
    }
    public ArrayList<ContactItem> get_list(){
        return list;
    }
    public int get_size(){
        return list.size();
    }
    public void view_list(){
        if(list.size()==0){
            System.out.println("The list is empty!!!");
        }
        System.out.println("Current Contacts:");
        System.out.println("--------------");
        for(int i = 0;i<list.size();i++){
            ContactItem curr = list.get(i);
            System.out.println(i+")");
            System.out.println("Name: "+curr.getFirstName()+" "+curr.getLastName());
            System.out.println("Phone: "+curr.getPhoneNumber());
            System.out.println("Email: "+curr.getEmailAddress());
        }
    }
    public void add_item(ContactItem in){
        list.add(in);
    }
    public void edit_item(int itemIdx, int variable_idx, String replacement) throws InvalidEditException {
        if(itemIdx<0 || itemIdx>=list.size()) throw new IndexOutOfBoundsException();
        ContactItem toReplace = list.get(itemIdx);
        if(variable_idx==1)toReplace.setFirstName(replacement);
        if(variable_idx==2)toReplace.setLastName(replacement);
        if(variable_idx==3)toReplace.setPhoneNumber(replacement);
        if(variable_idx==4)toReplace.setEmailAddress(replacement);
    }
    public void remove_item(int itemIdx){
        list.remove(itemIdx);
    }
    public void save_list(String filename) {
        try {
            PrintWriter out = new PrintWriter(new File(filename));
            out.println("Save format is as follows: First line is the item index, second line is the first name, third line is the last name, fourth line is the phone number, fifth line is email address");
            out.println("Number of items is " + list.size());
            for (int i = 0; i < list.size(); i++) {
                out.println(i);
                out.println(list.get(i).getFirstName());
                out.println(list.get(i).getLastName());
                out.println(list.get(i).getPhoneNumber());
                out.println(list.get(i).getEmailAddress());
            }
            out.flush();
            out.close();
            System.out.println("File saved as " + filename);
        }catch(FileNotFoundException e){
            System.out.println("File failed to save");
        }
    }
    public void load_list(String filename){
        try {
            Scanner scan = new Scanner(new File(filename));
            scan.nextLine();
            String[] split = scan.nextLine().split(" ");
            int size = Integer.parseInt(split[split.length - 1]);
            for (int i = 0; i < size; i++) {
                scan.nextLine();
                String firstName = scan.nextLine();
                String lastName = scan.nextLine();
                String phoneNumber = scan.nextLine();
                String emailAddress = scan.nextLine();
                if(emailAddress.equals("true") ||emailAddress.equals("false")) {
                    throw new FileNotFoundException();
                }
                ContactItem curr_item = new ContactItem(firstName, lastName, phoneNumber,emailAddress);
                list.add(curr_item);
            }
            System.out.println("Contact list has been loaded");
        }catch(FileNotFoundException e){
            System.out.println("File failed to load");
        }
    }
}
