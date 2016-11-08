import java.awt.geom.Point2D;
import java.util.ArrayList;

// DIFFERENT KINDS OF AVERAGES? - CUT SHORTEST AND LONGEST TIMES?

public class Results
{
	// Store a list of all the times taken.
	private ArrayList<Long> times;
	private ArrayList<Point2D> resultList;
	Results()
	{
		times = new ArrayList<Long>();
		resultList = new ArrayList<Point2D>();
	}
	
	public Long CalculateAverageTime()
	{
		long average = 0;
		for(Long time : times)
			average+= time;
		average /=times.size();
		
		return average;
	}

	public Long CalculateShortestTime()
	{
		long quickest = Long.MAX_VALUE;
		for(long t : times)
			if (t < quickest)
				quickest = t;
		return quickest;
	}
	
	public Long CalculateLongestTime()
	{
		long slowest = 0;
		for(long t : times)
			if (t > slowest)
				slowest = t;
		return slowest;
	}
		
	public void AddTimeToArray(Long t)
	{
		times.add(t);
	}
	
	
	public ArrayList<Point2D> GetResults()
	{
		return resultList;
	}
	public void SetResults(ArrayList<Point2D> r)
	{
		resultList = r;
	}
	
	public void PrintResults(ArrayList<Point2D> original)
	{
		 // Check if results are valid. 
		if (Util.CheckLists(original,resultList))
		{
			double cityDist = Util.routeLength(original);
			double resultDist = Util.routeLength(resultList);
			System.out.println("Original size: " +original.size() + " | Result size: "+resultList.size());    
	      
			System.out.println("Original length: " +cityDist + " | Result length: "+resultDist);    
			System.out.println("Time taken: "+ CalculateAverageTime() + " milliseconds.");
			DrawRoute route = new DrawRoute();
			route.Route(original);
			DrawRoute route1 = new DrawRoute();
			route1.Route(resultList);
		}
		else
		{	
			System.out.println("Algorithm did not work. Number of input != number of output");
			System.out.println("Input: "+ original.size() + "| Output: " + resultList.size());
		}
	}
}
