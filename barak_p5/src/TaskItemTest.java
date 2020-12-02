import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TaskItemTest {


    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        TaskItem init = new TaskItem("heh","hah","1001-10-01");
        String title = init.get_title();
        String desc = init.get_description();
        String date = init.get_dueDate();
        try {
            init.is_valid_date("not_a_leap_year2019-02-29");
            init = new TaskItem("when","who","how");
            assertTrue(false);
        } catch (InvalidDateException e) {
            assertTrue(true);
        }
        assertEquals(title,init.get_title());
        assertEquals(desc,init.get_description());
        assertEquals(date,init.get_dueDate());
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem init = new TaskItem("heh","hah","1001-10-01");
        String title = init.get_title();
        String desc = init.get_description();
        String date = init.get_dueDate();
        try {
            init.is_valid_title("");
            init = new TaskItem("when","who","how");
            assertTrue(false);
        } catch (InvalidTitleException e) {
            assertTrue(true);
        }
        assertEquals(title,init.get_title());
        assertEquals(desc,init.get_description());
        assertEquals(date,init.get_dueDate());
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem init = new TaskItem("heh","hah","1001-10-01");
        String title = init.get_title();
        String desc = init.get_description();
        String date = init.get_dueDate();
        try {
            init.is_valid_date("9999-12-12");
            init = new TaskItem("when","who","how");
            assertTrue(true);
        } catch (InvalidDateException e) {
            assertTrue(false);
        }
        assertNotEquals(title,init.get_title());
        assertNotEquals(desc,init.get_description());
        assertNotEquals(date,init.get_dueDate());
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem init = new TaskItem("heh","hah","1001-10-01");
        String title = init.get_title();
        String desc = init.get_description();
        String date = init.get_dueDate();
        try {
            init.is_valid_title("valid title hurrah!");
            init = new TaskItem("when","who","how");
            assertTrue(true);
        } catch (InvalidTitleException e) {
            assertTrue(false);
        }
        assertNotEquals(title,init.get_title());
        assertNotEquals(desc,init.get_description());
        assertNotEquals(date,init.get_dueDate());
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem init = new TaskItem("heh","hah","1001-10-01");
        String date = init.get_dueDate();
        try {
            init.is_valid_date("not_a_leap_year2019-02-29");
            init.set_dueDate("not_a_leap_year2019-02-29");
            assertTrue(false);
        } catch (InvalidDateException e) {
            assertTrue(true);
        }
        assertEquals(date,init.get_dueDate());
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem init = new TaskItem("heh","hah","1001-10-01");
        String date = init.get_dueDate();
        try {
            init.is_valid_date("0001-01-01");
            init.set_dueDate("0001-01-01");
            assertTrue(true);
        } catch (InvalidDateException e) {
            assertTrue(false);
        }
        assertNotEquals(date,init.get_dueDate());
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem init = new TaskItem("heh","hah","1001-10-01");
        String title = init.get_title();
        try {
            init.is_valid_title("");
            init.set_title("oh what a beautiful title, it's a shame it will never be seen");
            assertTrue(false);
        } catch (InvalidTitleException e) {
            assertTrue(true);
        }
        assertEquals(title,init.get_title());
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem init = new TaskItem("heh","hah","1001-10-01");
        String title = init.get_title();
        try {
            init.is_valid_title("but this amazing title will be seen!! omggg:) :0 :))");
            init.set_title("but this amazing title will be seen!! omggg:) :0 :))");
            assertTrue(true);
        } catch (InvalidTitleException e) {
            assertTrue(false);
        }
        assertNotEquals(title,init.get_title());
    }


}
