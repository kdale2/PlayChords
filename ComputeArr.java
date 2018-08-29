package assignment1;
import stdlib.*;

public class ComputeArr {

	public static void main(String[] args) {

		algs31.BinarySearchST<String,Double> ratingSystem = new algs31.BinarySearchST<String,Double>(); 

		//insert key, value pairs
		ratingSystem.put("********", 4.0);
		ratingSystem.put("*******", 3.5);
		ratingSystem.put("******", 3.0);
		ratingSystem.put("*****",2.5);
		ratingSystem.put("****", 2.0);
		ratingSystem.put("***", 1.5);
		ratingSystem.put("**", 1.0);
		ratingSystem.put("*", 0.0);

		//read input from file 
		StdIn.fromFile("data/a1ratings.txt");

		String[] restauRatings = StdIn.readAllStrings();
		double totalRating=0.0;

		for (String restauRating: restauRatings) {
			double oneReview = ratingSystem.get(restauRating);
			totalRating += oneReview;
		}

		//compute final rating
		double finalRating = totalRating / restauRatings.length;
		StdOut.println("The restaurant rating is " + finalRating + ".");
	}
}
			