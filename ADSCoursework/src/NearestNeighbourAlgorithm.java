import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class NearestNeighbourAlgorithm
{

	public static ArrayList<Point2D> NearestNeighbour(ArrayList<Point2D> inCities)
	{
		// This is the default nearest neighbour algorithm. The other methods are based on this. 
		
		ArrayList<Point2D> cities = new ArrayList<Point2D>(inCities);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		// Set current city.
		Point2D currentCity = cities.remove(0);
		
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

	public static ArrayList<Point2D> NearestNeighbourSQ(ArrayList<Point2D> inCities)
	{
		
		// This is a more optimised version of the original algorithm.
		
		ArrayList<Point2D> cities = new ArrayList<Point2D>(inCities);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		// Set current city.
		Point2D currentCity = cities.remove(0);
		
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
				double dist = Point2D.distanceSq(currentCity.getX(), currentCity.getY(), t.getX(), t.getY());  
				if(dist < distance)
				{
					closest = t;
					distance = dist;
				}
			
			}
			cities.remove(closest);
			currentCity = closest;
			
		}
		return result;	
	}
	
	public static ArrayList<Point2D> NearestNeighbourV2(ArrayList<Point2D> inCities)
	{
		// This method just randomises the starting point. 
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
		// This method randomises the list. Results are unpredictable.

		ArrayList<Point2D> cities = new ArrayList<Point2D>(inCities);
		Collections.shuffle(cities);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		// Set current city.
		Point2D currentCity = cities.remove(0);
		
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
	

	public static ArrayList<Point2D> NearestNeighbourV4(ArrayList<Point2D> inCities)
	{
		// This method is not efficient. In theory it is supposed to half the iterations of the for loop
		// at the cost of an additional check in 
		
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
			for(int i=0; i < cities.size(); i++)
			{
			
				Point2D t = cities.get(i);
				// Check if the current city 
				if(Point2D.distance(currentCity.getX(), currentCity.getY(), t.getX(), t.getY()) < distance)
				{
					closest = t;
					distance = Point2D.distance(currentCity.getX(), currentCity.getY(), t.getX(), t.getY());
				}
				// If there is another city after it check if that is closer.
				if (i+1 < cities.size())
				{
					Point2D n = cities.get(i+1);
					if(Point2D.distance(currentCity.getX(), currentCity.getY(), n.getX(), n.getY()) < distance)
					{
						closest = n;
						distance = Point2D.distance(currentCity.getX(), currentCity.getY(), n.getX(), n.getY());
						i++;
					}
					
				}	
			}
			cities.remove(closest);
			currentCity = closest;
			
		}
		return result;	
	}

	public static ArrayList<Point2D> NearestXNeighbour(ArrayList<Point2D> inCities)
	{
		// This method just checks along the x-axis.
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
				if( t.getX() < closestX)
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
		// This method just checks along the y-axis.
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
