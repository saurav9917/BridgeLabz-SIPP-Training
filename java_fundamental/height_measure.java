import java.util.*;
public class height_measure
{
    public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    double height = sc.nextDouble();
    double height_In_inches = height / 2.54 ; 
    double height_In_foot = height_In_inches / 12;
    System.out.print("Your Height in cm is "+height+" while in feet is "+height_In_foot + " and inches is "+height_In_inches);
    }
}