import java.util.*;
public class distance_conversion
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        float feet = sc.nextFloat();
        float yards = feet / 3;
        float miles = yards / 1760;
        System.out.print("The distance in yards is " + yards + " while the distance in miles is " + miles);
    }
}
