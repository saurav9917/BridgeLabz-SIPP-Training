public class pens_distribution
{
    public static void main(String[] args)
{
    int pens = 14;
    int student = 3;
    int distributed = pens / student;
    int Non_distributed = pens % student;
    System.out.println("The Pen Per Student is "+distributed+" and the remaining pen not distributed is "+ Non_distributed);
    }
}