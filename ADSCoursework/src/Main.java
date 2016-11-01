import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


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
		System.out.println(result.size() + " " + cities.size());
		return result;	
	}
	
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
	
	
	// This method is here to ensure that all cities are included.
	public static Boolean CheckLists(ArrayList<Point2D> original, ArrayList<Point2D> results)
	{
	//	Boolean inList = false;
	//	for(Point2D x : original)
	//	{
	//		for(Point2D y : results)
	//		{
	//			if(x == y)
	//			{
	//				inList = true;
	//				break;
	//			}
	//			else
	//				inList = false;
	//		}
	//	}
	
		
		Set<Point2D> set = new HashSet<Point2D>(results);
		System.out.println(set.size());
		return (set.size() == original.size());
		
		//return inList;
	}
		
	public static void PrintResults(ArrayList<Point2D> original, ArrayList<Point2D> results, double elapsedTime)
	{
		  
		if (CheckLists(original,results))
		{
			double cityDist = routeLength(original);
			double resultDist = routeLength(results);
			System.out.println("Original size: " +original.size() + " | Result size: "+results.size());    
	      
			System.out.println("Original length: " +cityDist + " | Result length: "+resultDist);    
			System.out.println("Time taken: "+ elapsedTime + " milliseconds.");
			DrawRoute route = new DrawRoute();
			route.Route(original);
			DrawRoute route1 = new DrawRoute();
			route1.Route(results);
		}
		else
			System.out.println("Algorithm did not work. Missing cities.");
	}
	
	public static void main(String[] args)
	{
		String fName = "..//ADSCoursework//src//rl5915.tsp";
		ArrayList<Point2D> cities = new ArrayList<Point2D>(TsbLoader.loadTSPLib(fName));
		HashMap<Integer,Point2D> hCities = new HashMap<Integer,Point2D>(cities.size());
		for (int i=0; i< cities.size(); i++)
		{
			hCities.put(i,cities.get(i));
		}
		
		// Start time when algorithm is about to run.
	    long startTime = System.currentTimeMillis();
	
	    // INSERT WHAT ALGORITHM TO USE HERE:
	//	ArrayList<Point2D> results = NearestNeighbour(cities);
		ArrayList<Point2D> results = NearestNeighbourV2(cities);
	//  ArrayList<Point2D> results = NearestXNeighbour(cities);
    //	ArrayList<Point2D> results = NearestYNeighbour(cities);
    //	ArrayList<Point2D> results = NearestNeighbourV3(cities);
		
    //	HashMap<Integer,Point2D> results = NearestNeighbourV1(hCities);
				
		// Stop time once algorithm is finished.
	    long stopTime = System.currentTimeMillis();
	    // Calculate how long it took.
	    long elapsedTime = stopTime - startTime;
	    //ArrayList<Point2D> conversion = new ArrayList<Point2D>();
	    //for(int i =0; i < results.size();i++)
	    //	conversion.add(results.get(i));
	    //PrintResults(cities,conversion,elapsedTime);
	    
	    // Print result.
	    PrintResults(cities,results,elapsedTime);
	   

	}

}
