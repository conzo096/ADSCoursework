import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* This utility class is here to provide helper methods*/
public class Util
{
	public static double routeLength(ArrayList<Point2D> cities)
	{
		//Calculate the length of a TSP route held in an ArrayList as a set of Points
		double result=0;//Holds the route length
		Point2D prev = cities.get(cities.size()-1);
		//Set the previous city to the last city in the ArrayList as we need
		// to measure the length of the entire loop
		for(Point2D city : cities)
		{
			//Go through each city in turn
			result += city.distance(prev);
			//get distance from the previous city
			prev = city;
			//current city will be the previous city next time
		}
		return result;
	}
	

	// This method is here to ensure that all cities are included.
	public static Boolean CheckLists(ArrayList<Point2D> original, ArrayList<Point2D> results)
	{
		// By turning the results into a set I can ensure that there are no duplicates by comparing to original size.
		Set<Point2D> set = new HashSet<Point2D>(results);
		if (set.size() != original.size())
		{
			System.out.println("Output size is not equal size to the input size.");
			return false;
		}
		else
		{
			// Create copies of original input and results to check.
			ArrayList<Point2D> o = new ArrayList<Point2D>(original);
			// Can use the instead of creating new arrayList to save memory/processing power.
			
			// Make sure each point in results are in original data set.
			for(Point2D r : original)
			{
				// point is in list. Remove to make search quicker
				if(o.contains(r) == false)
				{
					System.out.println("Results is missing: "+ r.toString());
					return false;
				}
				// r must be in list so remove it to speed comparison.
				o.remove(r);
			}
		}
		return true;
	}
		
}
