import java.awt.geom.Point2D;
import java.util.ArrayList;
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
		String data6 = "..//ADSCoursework//src//berlin52.tsp";
		

		
		// Load data points into array.
		ArrayList<Point2D> cities = new ArrayList<Point2D>(TsbLoader.loadTSPLib(data1));
		
		// Create arrayList for results to be stored in. Same size as in cities.
		// This should be slightly more efficient as there is no need to recalc size.
		ArrayList<Point2D> results = new ArrayList<Point2D>(cities.size());
		// Should I do a loop for all the results.
		for(int i =0; i <5; i++)
		{
			// Start time when algorithm is about to run.
		    long startTime = System.currentTimeMillis();
		
		    // ---- Only put method for algorithm below this or results are inaccurate! ---- \\
		   // results = NearestNeighbourAlgorithm.NearestNeighbour(cities);
		    //results = NearestNeighbourAlgorithm.NearestNeighbourRandStart(cities);
		  //  results = NearestNeighbourAlgorithm.NearestNeighbourShuffle(cities);
		   // results = NearestNeighbourAlgorithm.NearestNeighbourSQ(cities);
		   results = NearestNeighbourAlgorithm.NearestNeighbourRewrite(cities);
		  // results = NearestNeighbourAlgorithm.NearestXNeighbour(cities);
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
