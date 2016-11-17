import java.awt.geom.Point2D;
import java.util.ArrayList;
public class Main
{
		
	public static void main(String[] args)
	{
		Results result = new Results();
		
		//File path to tsp's . 
		String data1 = "..//ADSCoursework//src//rl5915.tsp";
		String data2 = "..//ADSCoursework//src//rl1323.tsp";
		String data3 = "..//ADSCoursework//src//rl5934.tsp";
		String data4 = "..//ADSCoursework//src//rl1304.tsp";
		String data5 = "..//ADSCoursework//src//rl1889.tsp";
		String data6 = "..//ADSCoursework//src//berlin52.tsp";
		

		
		// Load data points into arraylist.
		ArrayList<Point2D> cities = new ArrayList<Point2D>(TsbLoader.loadTSPLib(data1));
		
		// Create arrayList for results to be stored in. Same size as in cities.
		// This should be slightly as size is already known.
		
		ArrayList<Point2D> results = new ArrayList<Point2D>(cities.size());
		// Loop is for repeatability. When recording results remove slowest and fastest extremes for me accuracy.
		//for(int i =0; i <5; i++)
		{
			// Start time when algorithm is about to run.
		    long startTime = System.currentTimeMillis();
		
		    // ---- Only run one method for algorithm below this or results are inaccurate! ---- \\
		   
		    // results = NearestNeighbourAlgorithm.NearestNeighbour(cities);
		    // results = NearestNeighbourAlgorithm.NearestNeighbourRandStart(cities);
		    // results = NearestNeighbourAlgorithm.NearestNeighbourShuffle(cities);
		    // results = NearestNeighbourAlgorithm.NearestNeighbourSQ(cities);
		    // results = NearestNeighbourAlgorithm.NearestNeighbourRewrite(cities);
		     results = NearestNeighbourAlgorithm.NearestXNeighbour(cities);
		    // results = NearestNeighbourAlgorithm.NearestYNeighbour(cities);
		    
		    // Stop time once algorithm is finished.
		    long stopTime = System.currentTimeMillis();
		    // Calculate how long it took.
		    long elapsedTime = stopTime - startTime;
		    // Add result to list of times.
		    result.AddTimeToArray(elapsedTime);
		    // ---- Timing is finished can check results now. ---- \\
		    
		}
		
		/*	NOTE: because nearest neighbour will always return the same distance there is
		 *  no purpose of storing multiple results. 
		 *  When recording the results from Random start and Shuffle I stored and calculated the average by hand.
		 *  TO DO: Store each of the results and automatically calculate average.
		 */
		
		// This will take the final result and store it.
		result.SetResults(results);
		
		// Print results.
	   result.PrintResults(cities);
	   

	}

}
