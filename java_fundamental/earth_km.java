public class earth_km
{
    public static void main(String[]  args)
{
    int r = 6378;
    double vol_of_earth = 1.3 * 3.14 *r*r*r;
    double vol_of_earth_in_miles = vol_of_earth * 0.6;
        
    System.out.print(" The volume of earth in cubic kilometers is "+vol_of_earth+" and cubic miles is "+vol_of_earth_in_miles);
    }
}