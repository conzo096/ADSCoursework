import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main
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
	
	public static ArrayList<Point2D> NearestNeighbour(ArrayList<Point2D> cities)
	{
		ArrayList<Point2D> result = new ArrayList<Point2D>();
	
		// Current city to visit - set as first in array.
		Point2D currentCity = cities.remove(0);
		// Closest city to the current city.
		Point2D closest = null;
		// While cities left in list.
		while (cities.size() >0)
		{
			// Add current city to list.
			result.add(currentCity);
			// Find closest city.
			double distance = Float.MAX_VALUE;
			for(Point2D city : cities)
			{
				if(Point2D.distance(currentCity.getX(), currentCity.getY(), city.getX(), city.getY()) < distance)
				{
					closest = currentCity;
					distance = Point2D.distance(currentCity.getX(), currentCity.getY(), city.getX(), city.getY());
				}
			}
			cities.remove(closest);
			currentCity = closest;
		}
		return result;	
	}
	
	public static void main(String[] args)
	{
		String fName = "C:\\Users\\40167111\\Documents\\GitHub\\ADSCoursework\\ADSCoursework\\src\\a280.tsp";
		ArrayList<Point2D> cities = new ArrayList<Point2D>();
		cities = TsbLoader.loadTSPLib(fName);
		
		ArrayList<Point2D> result = NearestNeighbour(cities);
		for(int i =0; i < result.size();i++)
		{
			System.out.println(result.get(i).toString());
		}
	}

}
