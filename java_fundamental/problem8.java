import java.util.*;
public class problem8
{
    public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    int bas = sc.nextInt();
    int exp = sc.nextInt();
    double power = Math.pow(bas , exp);
    System.out.print(power);
}
}