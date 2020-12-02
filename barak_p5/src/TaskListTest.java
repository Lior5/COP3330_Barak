import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
public class TaskListTest {
    TaskList init = new TaskList();

    @Test
    public void addingTaskItemsIncreasesSize(){
        int oldSize = init.get_size();
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        int newSize = init.get_size();
        assertTrue(oldSize==newSize-1);
    }
    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        boolean status = init.get_list().get(0).get_completed();
        init.mark_completed(0);
        boolean newStatus = init.get_list().get(0).get_completed();
        assertTrue(status!=newStatus);
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        boolean status = init.get_list().get(0).get_completed();
        try {
            init.mark_completed(2);
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        boolean newStatus = init.get_list().get(0).get_completed();
        assertTrue(status==newStatus);
    }
    @Test
    public void editingTaskItemChangesValues(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        String oldT = item.get_title();
        String oldD = item.get_description();
        String oldDay = item.get_dueDate();
        init.edit_item(0,1,"hello");
        init.edit_item(0,2,"hello");
        init.edit_item(0,3,"hello");
        System.out.println(init.get_list().get(0).get_dueDate()+" "+oldDay);
        assertTrue(!init.get_list().get(0).get_title().equals(oldT));
        assertTrue(!init.get_list().get(0).get_description().equals(oldD));
        assertTrue(!init.get_list().get(0).get_dueDate().equals(oldDay));
    }
    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        String oldD = item.get_description();
        init.edit_item(0,2,"hello");
        assertTrue(!init.get_list().get(0).get_description().equals(oldD));

    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        String oldD = item.get_description();
        try {
            init.edit_item(2,2,"hello");
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        assertTrue(init.get_list().get(0).get_description().equals(oldD));
    }
    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        String oldD = item.get_dueDate();
        try {
            init.edit_item(2,3,"hello");
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        assertTrue(init.get_list().get(0).get_dueDate().equals(oldD));
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        String oldD = item.get_dueDate();
        try {
            init.edit_item(2,3,"hello");
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        assertTrue(init.get_list().get(0).get_dueDate().equals(oldD));
    }
    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        String oldD = item.get_title();
        init.edit_item(0,1,"hello");
        assertTrue(!init.get_list().get(0).get_title().equals(oldD));

    }@Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        String oldD = item.get_title();
        try {
            init.edit_item(2,1,"hello");
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        assertTrue(init.get_list().get(0).get_title().equals(oldD));

    }
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        try {
            init.get_list().get(2).get_description();
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        assertTrue(init.get_list().get(0).get_description().equals("yessir"));
    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        assertTrue(init.get_list().get(0).get_description().equals("yessir"));

    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        try {
            init.get_list().get(2).get_dueDate();
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        assertTrue(init.get_list().get(0).get_dueDate().equals("2222-11-11"));

    }
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        assertTrue(init.get_list().get(0).get_dueDate().equals("2222-11-11"));

    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        try {
            init.get_list().get(2).get_title();
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        assertTrue(init.get_list().get(0).get_title().equals("yessir"));

    }@Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        assertTrue(init.get_list().get(0).get_title().equals("yessir"));

    }@Test
    public void newTaskListIsEmpty(){
        init = new TaskList();
        assertTrue(init.get_size() == 0);
    }
    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        int oldSize = init.get_size();
        init.remove_item(0);
        int newSize = init.get_size();
        assertTrue(oldSize==newSize+1);
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        int oldSize = init.get_size();
        try {
            init.remove_item(5);
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
        int newSize = init.get_size();
        assertTrue(oldSize==newSize);
    }
    @Test
    public void savedTaskListCanBeLoaded() {
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        init.mark_completed(0);
        init.save_list("frog.txt");

        TaskList recovery_team = new TaskList();
        recovery_team.load_list("frog.txt");

        assertEquals(init.get_list().get(0).get_title(),recovery_team.get_list().get(0).get_title());
        assertEquals(init.get_list().get(0).get_description(),recovery_team.get_list().get(0).get_description());
        assertEquals(init.get_list().get(0).get_dueDate(),recovery_team.get_list().get(0).get_dueDate());
        assertEquals(init.get_list().get(0).get_completed(),recovery_team.get_list().get(0).get_completed());

    }
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);
        init.mark_completed(0);
        boolean status = init.get_list().get(0).get_completed();
        init.mark_uncompleted(0);
        boolean newStatus = init.get_list().get(0).get_completed();
        assertTrue(status!=newStatus);
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskItem item = new TaskItem("yessir","yessir","2222-11-11");
        init.add_item(item);

        init.mark_completed(0);
        boolean status = init.get_list().get(0).get_completed();
        try {
            init.mark_uncompleted(12);
            assertTrue(false);
        }catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }
        boolean newStatus = init.get_list().get(0).get_completed();
        assertTrue(status==newStatus);
    }
}
