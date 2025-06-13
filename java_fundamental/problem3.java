import java.util.*;
public class problem3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cel = sc.nextInt();
        float fah = (cel*1.8f) + 32f;
        System.out.print(fah);
    }
}