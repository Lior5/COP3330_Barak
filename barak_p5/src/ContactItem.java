public class ContactItem {
    private String firstName, lastName, phoneNumber, emailAddress;
    private int count = 0;
    public ContactItem(String a, String b, String c, String d){
        firstName = a;
        lastName = b;
        phoneNumber = c;
        emailAddress = d;
        if(firstName.length()!=0)count++;
        if(lastName.length()!=0)count++;
        if(phoneNumber.length()!=0)count++;
        if(emailAddress.length()!=0)count++;

    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    public void setFirstName(String in) throws InvalidEditException {
        if(firstName.length()==0 && in.length()!=0)count++;
        if(firstName.length()>0 && in.length()==0)count--;
        if(count==0)throw new InvalidEditException();
        firstName = in;
    }
    public void setLastName(String in) throws InvalidEditException {
        if(lastName.length()==0 && in.length()!=0)count++;
        if(lastName.length()>0 && in.length()==0)count--;
        if(count==0)throw new InvalidEditException();
        lastName = in;
    }
    public void setPhoneNumber(String in) throws InvalidEditException {
        if(phoneNumber.length()==0 && in.length()!=0)count++;
        if(phoneNumber.length()>0 && in.length()==0)count--;
        if(count==0)throw new InvalidEditException();
        phoneNumber = in;
    }
    public void setEmailAddress(String in) throws InvalidEditException {
        if(emailAddress.length()==0 && in.length()!=0)count++;
        if(emailAddress.length()>0 && in.length()==0)count--;
        if(count==0)throw new InvalidEditException();
        emailAddress = in;
    }
    public void is_valid_contact(String fname, String lname, String pnum, String email) throws InvalidContactException{
        if(fname.length()==0 && lname.length()==0 && pnum.length()==0 && email.length()==0){
            System.out.println("No contact details entered, going back to task menu");
            throw new InvalidContactException();
        }
    }
    public void is_valid_email (String in) throws InvalidEmailException {
        String[] split = in.split("@");
        boolean good = true;
        if(split.length!=2){
            throw new InvalidEmailException();
        }
        String[] right = split[1].split("\\.");
        if(right.length!=2){
            throw new InvalidEmailException();
        }
    }
    public void is_valid_Number(String in) throws InvalidNumberException {
        boolean good = true;
        if(in.length()!=12)throw new InvalidNumberException();
        if (in.charAt(3) != '-' || in.charAt(7) != '-') good = false;
        if (count_hyphen(in) > 2) good = false;
        String[] split = in.split("-");
        int[] lengths = {3, 3, 4};
        for (int i = 0; i < split.length; i++) {
            String now = split[i];
            if (!all_numbers(now)) good = false;
            if (now.length() != lengths[i]) good = false;
        }
        if(!good){
            throw new InvalidNumberException();
        }
    }
    public boolean all_numbers(String in){
        for(int i = 0;i<in.length();i++){
            if(in.charAt(i)<'0' || in.charAt(i)>'9')return false;
        }
        return true;
    }
    public int count_hyphen(String in){
        int count = 0;
        for(int i = 0;i<in.length();i++){
            if(in.charAt(i)=='-')count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return "ContactItem{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", count=" + count +
                '}';
    }
}
class InvalidNumberException extends Exception{
    public InvalidNumberException(){
        super();
    }
}
class InvalidEmailException extends Exception{
    public InvalidEmailException(){
        super();
    }
}
class InvalidContactException extends Exception{
    public InvalidContactException(){
        super();
    }
}
class InvalidEditException extends Exception{
    public InvalidEditException(){
        super();
    }
}


