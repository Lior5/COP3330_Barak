public class TaskItem {
    private String title, description, dueDate;
    private boolean completed = false;
    public TaskItem(String title, String description,String dueDate){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }
    public boolean get_completed(){
        return this.completed;
    }
    public String get_title(){
        return this.title;
    }
    public String get_description(){
        return this.description;
    }
    public String get_dueDate(){
        return this.dueDate;
    }
    public void set_title(String title){
        this.title = title;
    }
    public void set_description(String description){
        this.description = description;
    }
    public void set_dueDate(String dueDate){
        this.dueDate = dueDate;
    }
    public void mark_completed(){
        this.completed = true;
    }
    public void mark_uncompleted(){
        this.completed = false;
    }
    public void is_valid_title(String in) throws InvalidTitleException {
        if(in.length()==0) {
            throw new InvalidTitleException();
        }
    }
    public void is_valid_date(String in) throws InvalidDateException {
        //months are 1-indexed
        int[] days_in_month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        boolean good = true;
        if (in.charAt(4) != '-' || in.charAt(7) != '-') good = false;
        if (count_hyphen(in) > 2) good = false;
        String[] split = in.split("-");
        int[] lengths = {4, 2, 2};
        for (int i = 0; i < split.length; i++) {
            String now = split[i];
            if (!all_numbers(now)) good = false;
            if (now.length() != lengths[i]) good = false;
        }
        if(good) {
            int year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);
            if (month > 12 || month < 1) good = false;
            int cap = days_in_month[month];
            //if it's a leap year and we are on february, there are 29 days
            if (is_leap_year(year) && month == 2) cap = 29;
            if (day < 1 || day > cap) good = false;
        }
        if(!good){
            throw new InvalidDateException();
        }
    }
    public boolean is_leap_year(int in){
        if(in%400==0) return true;
        if(in%100==0)return false;
        if(in%4==0)return true;
        return false;
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
}
class InvalidDateException extends Exception{
    public InvalidDateException(){
        super();
    }
}

class InvalidTitleException extends Exception{
    public InvalidTitleException(){
        super();
    }
}
