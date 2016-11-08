import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class NearestNeighbourAlgorithm
{

	public static ArrayList<Point2D> NearestNeighbour(ArrayList<Point2D> inCities)
	{
		ArrayList<Point2D> cities = new ArrayList<Point2D>(inCities);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		// Set current city.
		Point2D currentCity = cities.get(0);
		cities.remove(currentCity);
		
		// Closest city to the current city.
		Point2D closest = null;
		// While cities left in list.
		while (result.size() != inCities.size())
		{
			// Add current city to list.
			if(!result.contains(currentCity))
				result.add(currentCity);
			// Find closest city.
			double distance = Double.MAX_VALUE;
			for(Point2D t : cities)
			{
				if(Point2D.distance(currentCity.getX(), currentCity.getY(), t.getX(), t.getY()) < distance)
				{
					closest = t;
					distance = Point2D.distance(currentCity.getX(), currentCity.getY(), t.getX(), t.getY());
				}
			
			}
			cities.remove(closest);
			currentCity = closest;
			
		}
		return result;	
	}
	
	
	// THIS CAN BE WRITTEN IN A MORE OPTIMISED FASHION AND USE HASHMAP CORRECTLY.
	public static HashMap<Integer,Point2D> NearestNeighbourV1(HashMap<Integer,Point2D> inCities)
	{
		HashMap<Integer,Point2D> cities = new HashMap<Integer,Point2D>(inCities);
		HashMap<Integer,Point2D> result = new HashMap<Integer,Point2D>();
		// Set current city.
		Point2D currentCity = cities.get(0);
		// Closest city to the current city.
		Point2D closest = null;
		int k =0;
		int inumerator =0;
		// While cities left in list.
		while (!cities.isEmpty())
		{
			// Add current city to list.
			result.put(inumerator,currentCity);
			// Find closest city.
			double distance = Double.MAX_VALUE;
			for (int key : cities.keySet())
			{
				if(Point2D.distance(currentCity.getX(), currentCity.getY(), cities.get(key).getX(), cities.get(key).getY()) <= distance)
				{
					closest = cities.get(key);
					k= key;
					distance = Point2D.distance(currentCity.getX(), currentCity.getY(), cities.get(key).getX(), cities.get(key).getY());
				}
			}
			//cities.remove(closest);
			cities.remove(k, closest);
			currentCity = closest;
			inumerator++;
			System.out.println(inumerator);
		}
		return result;	
	}
	
	public static ArrayList<Point2D> NearestNeighbourV2(ArrayList<Point2D> inCities)
	{
		Random rand = new Random();
		
		ArrayList<Point2D> cities = new ArrayList<Point2D>(inCities);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		// Set current city.
		Point2D currentCity = cities.get(rand.nextInt(cities.size()-1));
		
		// Closest city to the current city.
		Point2D closest = null;
		// While cities left in list.
		while (result.size() !=inCities.size())
		{
			// Add current city to list.
			if(!result.contains(currentCity))
				result.add(currentCity);
			// Find closest city.
			double distance = Double.MAX_VALUE;
			for(Point2D t : cities)
			{
				if(Point2D.distance(currentCity.getX(), currentCity.getY(), t.getX(), t.getY()) <= distance)
				{
					closest = t;
					distance = Point2D.distance(currentCity.getX(), currentCity.getY(), t.getX(), t.getY());
				}
			}
			cities.remove(closest);
			currentCity = closest;
		}
		return result;	
	}
	
	public static ArrayList<Point2D> NearestNeighbourV3(ArrayList<Point2D> inCities)
	{
		Random rand = new Random();
		
		ArrayList<Point2D> cities = new ArrayList<Point2D>(inCities);
		Collections.shuffle(cities);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		// Set current city.
		Point2D currentCity = cities.get(rand.nextInt(cities.size()-1));
		
		// Closest city to the current city.
		Point2D closest = null;
		// While cities left in list.
		while (result.size() != inCities.size())
		{
			// Add current city to list.
			result.add(currentCity);
			// Find closest city.
			double distance = Double.MAX_VALUE;
			for(Point2D t : cities)
			{
				if(Point2D.distance(currentCity.getX(), currentCity.getY(), t.getX(), t.getY()) <= distance)
				{
					closest = t;
					distance = Point2D.distance(currentCity.getX(), currentCity.getY(), t.getX(), t.getY());
				}
			}
			cities.remove(closest);
			currentCity = closest;
		}
		return result;	
	}
	
	

	public static ArrayList<Point2D> NearestXNeighbour(ArrayList<Point2D> inCities)
	{
		ArrayList<Point2D> cities = new ArrayList<Point2D>(inCities);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		// Set current city.
		Point2D currentCity = cities.get(0);
		
		// Closest city to the current city.
		Point2D closest = null;
		// While cities left in list.
		while (result.size() != inCities.size())
		{
			// Add current city to list.
			if(!result.contains(currentCity))
				result.add(currentCity);
			// Find closest city.
			double closestX = Double.MAX_VALUE;
			for(Point2D t : cities)
			{
				if( t.getX() <= closestX)
				{
					closest = t;
					closestX = closest.getX();
				}
			}
			cities.remove(closest);
			currentCity = closest;
		}
		return result;	
	}
	
	public static ArrayList<Point2D> NearestYNeighbour(ArrayList<Point2D> inCities)
	{
		ArrayList<Point2D> cities = new ArrayList<Point2D>(inCities);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		// Set current city.
		Point2D currentCity = cities.get(0);
		
		// Closest city to the current city.
		Point2D closest = null;
		// While cities left in list.
		while (result.size() != inCities.size())
		{
			// Add current city to list.
			if(!result.contains(currentCity))
				result.add(currentCity);
			// Find closest city.
			double closestY = Double.MAX_VALUE;
			for(Point2D t : cities)
			{
				if( t.getY() <= closestY)
				{
					closest = t;
					closestY = closest.getY();
				}
			}
			cities.remove(closest);
			currentCity = closest;
		}
		return result;	
	}
	

}
