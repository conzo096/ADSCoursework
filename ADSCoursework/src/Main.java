import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Main
{
		
	public static void main(String[] args)
	{
		Results result = new Results();
		
		// Sort these by bigger data sizes. 
		String data1 = "..//ADSCoursework//src//rl5915.tsp";
		String data2 = "..//ADSCoursework//src//rl1323.tsp";
		String data3 = "..//ADSCoursework//src//rl5934.tsp";
		String data4 = "..//ADSCoursework//src//rl1304.tsp";
		String data5 = "..//ADSCoursework//src//rl1889.tsp";
		
		// Load data points into array.
		ArrayList<Point2D> cities = new ArrayList<Point2D>(TsbLoader.loadTSPLib(data4));
		
		// Create arrayList for results to be stored in. Same size as in cities.
		// This should be slightly more efficient as there is no need to recalc size.
		ArrayList<Point2D> results = new ArrayList<Point2D>(cities.size());
		
		// Do I really want to include this - report?
		HashMap<Integer,Point2D> hCities = new HashMap<Integer,Point2D>(cities.size());
		for (int i=0; i< cities.size(); i++)
		{
			hCities.put(i,cities.get(i));
		}
		
		// Should I do a loop for all the results.
	//	for(int i =0; i <50; i++)
		{
			// Start time when algorithm is about to run.
		    long startTime = System.currentTimeMillis();
		
		    // ---- Only put method for algorithm below this or results are inaccurate! ---- \\
		    //results = NearestNeighbourAlgorithm.NearestNeighbour(cities);
		    // HASHMAP ONE.
		    //results = NearestNeighbourAlgorithm.NearestNeighbourV1(cities);
		    //results = NearestNeighbourAlgorithm.NearestNeighbourV2(cities);
		    //results = NearestNeighbourAlgorithm.NearestNeighbourV3(cities);	// BROKEN Size is same so error is checking each cities.
		    //results = NearestNeighbourAlgorithm.NearestXNeighbour(cities);
		    //results = NearestNeighbourAlgorithm.NearestYNeighbour(cities);
		    
		    // Stop time once algorithm is finished.
		    long stopTime = System.currentTimeMillis();
		    // Calculate how long it took.
		    long elapsedTime = stopTime - startTime;
		    result.AddTimeToArray(elapsedTime);
		    // ---- Timing is finished can check results now. ---- \\
		    
		}
		
		// This will take the final result and store it.
		result.SetResults(results);
		
		// Print results.
	   result.PrintResults(cities);
	   

	}

}
