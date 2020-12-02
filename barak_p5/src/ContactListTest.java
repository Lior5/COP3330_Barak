import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
public class ContactListTest {
    ContactList init = new ContactList();

    @Test
    public void addingTaskItemsIncreasesSize() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        ContactList init = new ContactList();
        int oldSize = init.get_size();
        init.add_item(item);
        int newSize = init.get_size();
        assertTrue(oldSize == newSize - 1);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        ContactList init = new ContactList();
        init.add_item(item);
        try {
            init.edit_item(0,1,"");
            init.edit_item(0,2,"");
            init.edit_item(0,3,"");
            init.edit_item(0,4,"");
            assertTrue(false);
        } catch (InvalidEditException e) {
            assertTrue(true);
            return;
        }
    }
    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        ContactList init = new ContactList();
        init.add_item(item);
        try {
            init.edit_item(1,1,"waa");
            init.edit_item(0,2,"waaaaaat");
            init.edit_item(0,3,"123-321-456");
            init.edit_item(0,4,"hmm@ez.dublinski");
            assertTrue(false);
        } catch (InvalidEditException e) {
            assertTrue(true);
            return;
        } catch(IndexOutOfBoundsException o){
            assertTrue(true);
            return;
        }
    }
    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = item.getFirstName();
        String lname = item.getLastName();
        String phone = item.getPhoneNumber();
        String email = item.getEmailAddress();
        ContactList init = new ContactList();
        init.add_item(item);
        try {
            init.edit_item(0,1,"");
        } catch (InvalidEditException e) {
            assertTrue(false);
            return;
        } catch(IndexOutOfBoundsException o){
            assertTrue(false);
            return;
        }
        assertNotEquals(fname,init.get_list().get(0).getFirstName());
        assertEquals(lname,init.get_list().get(0).getLastName());
        assertEquals(phone,init.get_list().get(0).getPhoneNumber());
        assertEquals(email,init.get_list().get(0).getEmailAddress());
    }
    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = item.getFirstName();
        String lname = item.getLastName();
        String phone = item.getPhoneNumber();
        String email = item.getEmailAddress();
        ContactList init = new ContactList();
        init.add_item(item);
        try {
            init.edit_item(0,2,"");
        } catch (InvalidEditException e) {
            assertTrue(false);
            return;
        } catch(IndexOutOfBoundsException o){
            assertTrue(false);
            return;
        }
        assertEquals(fname,init.get_list().get(0).getFirstName());
        assertNotEquals(lname,init.get_list().get(0).getLastName());
        assertEquals(phone,init.get_list().get(0).getPhoneNumber());
        assertEquals(email,init.get_list().get(0).getEmailAddress());
    }
    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = item.getFirstName();
        String lname = item.getLastName();
        String phone = item.getPhoneNumber();
        String email = item.getEmailAddress();
        ContactList init = new ContactList();
        init.add_item(item);
        try {
            init.edit_item(0,3,"");
        } catch (InvalidEditException e) {
            assertTrue(false);
            return;
        } catch(IndexOutOfBoundsException o){
            assertTrue(false);
            return;
        }
        assertEquals(fname,init.get_list().get(0).getFirstName());
        assertEquals(lname,init.get_list().get(0).getLastName());
        assertNotEquals(phone,init.get_list().get(0).getPhoneNumber());
        assertEquals(email,init.get_list().get(0).getEmailAddress());
    }
    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = item.getFirstName();
        String lname = item.getLastName();
        String phone = item.getPhoneNumber();
        String email = item.getEmailAddress();
        ContactList init = new ContactList();
        init.add_item(item);
        try {
            init.edit_item(0,1,"wo");
            init.edit_item(0,2,"wa");
            init.edit_item(0,3,"593-291-3201");
            init.edit_item(0,4,"yoooyoyoyo@yooyoyyoyo.com");

        } catch (InvalidEditException e) {
            assertTrue(false);
            return;
        } catch(IndexOutOfBoundsException o){
            assertTrue(false);
            return;
        }
        assertNotEquals(fname,init.get_list().get(0).getFirstName());
        assertNotEquals(lname,init.get_list().get(0).getLastName());
        assertNotEquals(phone,init.get_list().get(0).getPhoneNumber());
        assertNotEquals(email,init.get_list().get(0).getEmailAddress());
    }
    @Test
    public void newListIsEmpty() {
        ContactList init = new ContactList();
        assertEquals(init.get_size(),0);
    }
    @Test
    public void removingItemsDecreasesSize() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        ContactList init = new ContactList();
        init.add_item(item);
        init.add_item(item);
        int oldSize = init.get_size();
        init.remove_item(1);
        int newSize = init.get_size();
        assertEquals(newSize,oldSize-1);
    }
    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        ContactList init = new ContactList();
        init.add_item(item);
        init.add_item(item);
        try {
            init.remove_item(2);
            assertTrue(false);
        }catch(IndexOutOfBoundsException e){
            assertTrue(true);
        }
    }
    @Test
    public void savedContactListCanBeLoaded() {
        ContactItem item = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = item.getFirstName();
        String lname = item.getLastName();
        String phone = item.getPhoneNumber();
        String email = item.getEmailAddress();
        ContactList init = new ContactList();
        init.add_item(item);
        init.save_list("saved.txt");
        init = new ContactList();
        init.load_list("saved.txt");
        assertEquals(fname,init.get_list().get(0).getFirstName());
        assertEquals(lname,init.get_list().get(0).getLastName());
        assertEquals(phone,init.get_list().get(0).getPhoneNumber());
        assertEquals(email,init.get_list().get(0).getEmailAddress());
    }
}