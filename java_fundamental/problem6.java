import java.util.*;
public class problem6
{
    public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    int Principal = sc.nextInt();
    int Rate = sc.nextInt();
    int Time = sc.nextInt();
    double SI = (Principal * Rate * Time) / 100;
    System.out.print(SI);
}
}