import java.util.*;
public class triangle_area
{
   public static void main(String[] args)
   {
       Scanner sc = new Scanner(System.in);
       float base = sc.nextFloat();
       float height = sc.nextFloat();
       float area_cm = 0.5f * base * height;
       float area_inch = area_cm / (2.54f * 2.54f);
       System.out.print("The Area of the triangle in sq in is "+area_inch+" and sq cm is "+area_cm);
   }
}
