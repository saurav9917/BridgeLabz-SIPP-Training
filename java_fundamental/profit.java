import java.util.*;

public class profit
{
    public static void main(String[] args)
{
    int cost_price = 129;
    int selling_price = 191;
    int profit = selling_price - cost_price;
    float profit_percentage = (profit * 100.0f) / cost_price;
        
    System.out.print("The Cost Price is INR " + cost_price + " and the Selling Price is INR " + selling_price + "\n" + "The Profit is INR " + profit + " and the Profit Percentage is " + profit_percentage + "%");
    }
}
