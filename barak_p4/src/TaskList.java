import java.io.PrintWriter;
import java.util.*;
import java.io.*;
public class TaskList {
    private ArrayList<TaskItem> list;
    public TaskList() {
        list = new ArrayList<>();
    }
    public ArrayList<TaskItem> get_list(){
        return list;
    }
    public int get_size(){
        return list.size();
    }
    public void view_list(){
        if(list.size()==0){
            System.out.println("The list is empty!!!");
        }
        for(int i = 0;i<list.size();i++){
            TaskItem curr = list.get(i);
            System.out.println((i)+" ["+curr.get_dueDate()+"] "+curr.get_title()+": "+curr.get_description()+": "+curr.get_completed());
        }
    }
    public void add_item(TaskItem in){
        list.add(in);
    }
    public void edit_item(int itemIdx, int variable_idx, String replacement){
        TaskItem toReplace = list.get(itemIdx);
        if(variable_idx==1)toReplace.set_title(replacement);
        if(variable_idx==2)toReplace.set_description(replacement);
        if(variable_idx==3)toReplace.set_dueDate(replacement);
    }
    public void remove_item(int itemIdx){
        list.remove(itemIdx);
    }
    public void mark_completed(int itemIdx){
        TaskItem toReplace = list.get(itemIdx);
        toReplace.mark_completed();
    }
    public void mark_uncompleted(int itemIdx){
        TaskItem toReplace = list.get(itemIdx);
        toReplace.mark_uncompleted();
    }
    public void save_list(String filename) {
        try {
            PrintWriter out = new PrintWriter(new File(filename));
            out.println("Save format is as follows: First line is the item index, second line is the title, third line is the description, fourth line is the due date, fifth line is completion (true or false)");
            out.println("Number of items is " + list.size());
            for (int i = 0; i < list.size(); i++) {
                out.println(i);
                out.println(list.get(i).get_title());
                out.println(list.get(i).get_description());
                out.println(list.get(i).get_dueDate());
                out.println(list.get(i).get_completed());
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
                String title = scan.nextLine();
                String desc = scan.nextLine();
                String date = scan.nextLine();
                String completed = scan.nextLine();
                boolean comp = false;
                if (completed.equals("true")) comp = true;
                TaskItem curr_item = new TaskItem(title, desc, date);
                if (comp) curr_item.mark_completed();
                list.add(curr_item);
            }
            System.out.println("Task list has been loaded");
        }catch(FileNotFoundException e){
            System.out.println("File failed to load");
        }
    }
}
