package savingsaccount;

import java.util.Date;
import java.text.DateFormat;

public class SavingsAccount {
    public static void main(String[] args)
    {
        Date my_date = new Date(101, 4, 3);
        String new_date = DateFormat.getDateInstance(DateFormat.MEDIUM).format(my_date);
        String date = String.valueOf(my_date);
        System.out.println(date);
        System.out.println(new_date);
        Date my_today = new Date();
        System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(my_today));
        
        Date display;
        try{
            DateFormat.getDateInstance(DateFormat.MEDIUM).parse(date);
        }
        catch(java.text.ParseException e){
            System.out.println("Exception Thrown : " + e);
        }
        
        
    }
}
