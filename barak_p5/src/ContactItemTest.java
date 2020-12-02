import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        try {
            init.is_valid_contact("","","","");
            init = new ContactItem("a","b","101-101-1011","a@b.c");
            assertTrue(false);
        } catch (InvalidContactException e) {
            assertTrue(true);
        }
        assertEquals(fname, init.getFirstName());
        assertEquals(lname, init.getLastName());
        assertEquals(phone, init.getPhoneNumber());
        assertEquals(email, init.getEmailAddress());
    }
    @Test
    public void creationSucceedsWithBlankEmail() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        init = new ContactItem("a","b","322-222-2222","");
        assertNotEquals(fname, init.getFirstName());
        assertNotEquals(lname, init.getLastName());
        assertNotEquals(phone, init.getPhoneNumber());
        assertNotEquals(email, init.getEmailAddress());
    }
    @Test
    public void creationSucceedsWithBlankFirstName() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        init = new ContactItem("","b","101-101-1011","at@at.com");
        assertNotEquals(fname, init.getFirstName());
        assertNotEquals(lname, init.getLastName());
        assertNotEquals(phone, init.getPhoneNumber());
        assertNotEquals(email, init.getEmailAddress());
    }
    @Test
    public void creationSucceedsWithBlankLastName() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        init = new ContactItem("a","","101-101-1011","at@at.com");
        assertNotEquals(fname, init.getFirstName());
        assertNotEquals(lname, init.getLastName());
        assertNotEquals(phone, init.getPhoneNumber());
        assertNotEquals(email, init.getEmailAddress());
    }
    @Test
    public void creationSucceedsWithBlankPhone() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        init = new ContactItem("a","b","","at@at.com");
        assertNotEquals(fname, init.getFirstName());
        assertNotEquals(lname, init.getLastName());
        assertNotEquals(phone, init.getPhoneNumber());
        assertNotEquals(email, init.getEmailAddress());
    }
    @Test
    public void creationSucceedsWithNonBlankValues() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        init = new ContactItem("a","b","101-101-1011","ayayayay");
        assertNotEquals(fname, init.getFirstName());
        assertNotEquals(lname, init.getLastName());
        assertNotEquals(phone, init.getPhoneNumber());
        assertNotEquals(email, init.getEmailAddress());
    }
    @Test
    public void editingFailsWithAllBlankValues() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        try {
            init.setFirstName("");
            init.setLastName("");
            init.setPhoneNumber("");
            init.setEmailAddress("");
            assertTrue(false);
        } catch (InvalidEditException e) {
            assertTrue(true);
            return;
        }
        assertEquals(fname, init.getFirstName());
        assertEquals(lname, init.getLastName());
        assertEquals(phone, init.getPhoneNumber());
        assertEquals(email, init.getEmailAddress());
    }
    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        try {
            init.setEmailAddress("");
            assertTrue(true);
        } catch (InvalidEditException e) {
            assertTrue(false);
        }
        assertEquals(fname,init.getFirstName());
        assertEquals(lname,init.getLastName());
        assertEquals(phone,init.getPhoneNumber());
        assertNotEquals(email,init.getEmailAddress());
    }
    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        try {
            init.setFirstName("");
            assertTrue(true);
        } catch (InvalidEditException e) {
            assertTrue(false);
        }
        assertNotEquals(fname,init.getFirstName());
        assertEquals(lname,init.getLastName());
        assertEquals(phone,init.getPhoneNumber());
        assertEquals(email,init.getEmailAddress());
    }
    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        try {
            init.setLastName("");
            assertTrue(true);
        } catch (InvalidEditException e) {
            assertTrue(false);
        }
        assertEquals(fname,init.getFirstName());
        assertNotEquals(lname,init.getLastName());
        assertEquals(phone,init.getPhoneNumber());
        assertEquals(email,init.getEmailAddress());
    }
    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        try {
            init.setPhoneNumber("");
            assertTrue(true);
        } catch (InvalidEditException e) {
            assertTrue(false);
        }
        assertEquals(fname,init.getFirstName());
        assertEquals(lname,init.getLastName());
        assertNotEquals(phone,init.getPhoneNumber());
        assertEquals(email,init.getEmailAddress());
    }
    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        String fname = init.getFirstName();
        String lname = init.getLastName();
        String phone = init.getPhoneNumber();
        String email = init.getEmailAddress();
        try {
            init.setFirstName("thisname");
            init.setLastName("builtdifferent");
            init.setPhoneNumber("123-123-1234");
            init.setEmailAddress("thisemailistaken@emails.us");
            assertTrue(true);
        } catch (InvalidEditException e) {
            assertTrue(false);
        }
        assertNotEquals(fname,init.getFirstName());
        assertNotEquals(lname,init.getLastName());
        assertNotEquals(phone,init.getPhoneNumber());
        assertNotEquals(email,init.getEmailAddress());
    }
    @Test
    public void testToString() {
        ContactItem init = new ContactItem("harry", "potter", "123-456-7890","email@gmail.com");
        assertEquals(init.toString(),("ContactItem{firstName='harry', lastName='potter', phoneNumber='123-456-7890', emailAddress='email@gmail.com', count=4}"));
    }
}
