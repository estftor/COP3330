// Arup Guha
// 2/9/06
// A small example that utilizes an array of arrays.
/*** Edited on 2/8/2026 for video game example. ***/

import java.util.*;


public class VideoGameScores {

	public static void main(String[] args) {
	  
		Scanner stdin = new Scanner(System.in);
		System.out.println("How many players data are you entering?");
		int numPlayers = stdin.nextInt();

		// Create the 2D array for scores and 1D array for names.
		int[][] playerScores = new int[numPlayers][];
		String[] playerNames = new String[numPlayers]; // array of objects automatically initialized to null
		
		if (playerScores[0] == null) System.out.println("yes init to null.");
		
		// Loop through the players.
		for (int i=0; i<numPlayers; i++) {
			
			// Get player name.
			System.out.println("Player "+(i+1)+", what is your name?");
			playerNames[i] = stdin.next();
			
			// Get the number of times they played.
			System.out.println(playerNames[i]+", how many times did you play the game?");
			int numTimes = stdin.nextInt();
			
			// Allocate the space for the scores.
			playerScores[i] = new int[numTimes];
			
			System.out.println("Please enter the scores, separated by spaces.");
			for (int j=0; j<numTimes; j++)
				playerScores[i][j] = stdin.nextInt();
		}
		
		// Print chart of player averages and standard deviations.
		System.out.println("Name\tGames Played\tAverage Score\tStandard Deviation");
		System.out.println("----\t------------\t-------------\t------------------");
		for (int i=0; i<numPlayers; i++) {
			double average = avg(playerScores[i]);
			double standardDev = stddev(playerScores[i]);
			System.out.println(playerNames[i]+"\t"+playerScores[i].length+"\t\t"+average+"\t\t"+standardDev);
		}
		for (int i=0; i<numPlayers; i++) {
			
			sortArray(playerScores[i]);
			printPlayer(playerNames[i], playerScores[i]);

		}

		
		
   

	}

	// Returns the average of the values stored in data.
	public static double avg(int[] data) {
    
		int sum = 0;

		// Add up the sum of the values in data.
		for (int i=0; i<data.length; i++) 
			sum += data[i];

		// Return the average by dividing this by the length of the array.
		return (double)sum/data.length;
	}

	// Calculates the standard deviation of all of the values in data.
	public static double stddev(int[] data) {

		// Calculate the average of all the values.
		double average = avg(data);
		double sum=0;

		// Add up the difference each term and the average squared.
		for (int i=0; i<data.length; i++)
			sum = sum + Math.pow((data[i]-average),2);

		// Divide by the number of terms.
		sum /= data.length;

		// The standard deviation is the square root of that value.
		return Math.sqrt(sum);
	}

	static void sortArray(int[] data) {
		int len = data.length -1 ;
		Arrays.sort(data);
		for( int i = 0; i <len; i++){
			if(len > i){
				int temp = data[i];
				data[i] = data[len];
				data[len] = temp;
				len--;
			}
			
		}
	}

	public static void printPlayer(String name, int[] scoreList){
		System.out.printf("Player: %s\n", name);
		System.out.println("Scores: " + Arrays.toString(scoreList));
	}

	
}



// Tasks 
// --> sort player scores lowest to highest 
// ---> when printing, print out all the scores for each