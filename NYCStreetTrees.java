// Main program. Takes a .csv file input, splits each line into a string array, then categorizes into a searchable TreeList.

import java.io.*;
import java.util.*;

public class NYCStreetTrees {

	public static void main(String[] args) throws IOException {
		// File, scanner, and TreeList objects.
		File myFile = new File("csv/all.csv");
		Scanner fileInput = new Scanner(myFile);
		Scanner input = new Scanner(System.in);
		TreeList allTrees = new TreeList();
		int count = 0;
		
		while (fileInput.hasNext()) {
			// Split each line into an individual String[] array
			String[] splitLine = fileInput.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			// Skip over the first line
			if (!splitLine[0].equals("tree_id")) {
				
				// Convert the values in each line to a tree constructor and add into the TreeList.
				int id = Integer.parseInt(splitLine[0]);
				int diam = Integer.parseInt(splitLine[4]);
				String status = splitLine[6];
				String health = splitLine[7];
				String spc = splitLine[9];
				int zip = Integer.parseInt(splitLine[25]);
				String boro = splitLine[29];
				double x = Double.parseDouble(splitLine[37]);
				double y = Double.parseDouble(splitLine[38]);
				Tree currentTree = new Tree(id, diam, status, health, spc, zip, boro, x, y);
				allTrees.add(currentTree);
				
				// Use count variable to keep track of tree number
				System.out.println("Tree " + count + " was added!");
				count++;
			}
		}
		fileInput.close();
		
		// Prompt the user for an action.
		
		while (true) {
			System.out.println("Enter the tree species to learn more about it ('quit' to stop)");
			String species = input.nextLine();
			if (species.equals("quit")) {
				break;
			} else {
				// Now, search for matching trees in the ArrayList.
				ArrayList<String> matchingTrees = allTrees.getMatchingSpecies(species);
				System.out.println("All matching species: ");
				for (int i = 0; i < matchingTrees.size(); i++) {
					System.out.println("   " + matchingTrees.get(i));
				}
				
				// Find popularity
				
				int speciesNYC = allTrees.getCountByTreeSpecies(species);
				int speciesManhattan = allTrees.getCountByTreeSpeciesBorough(species, "Manhattan");
				int speciesBronx = allTrees.getCountByTreeSpeciesBorough(species, "Bronx");
				int speciesBrooklyn = allTrees.getCountByTreeSpeciesBorough(species, "Brooklyn");
				int speciesQueens = allTrees.getCountByTreeSpeciesBorough(species, "Queens");
				int speciesStatenIsland = allTrees.getCountByTreeSpeciesBorough(species, "Staten Island");
				
				int totalNYC = allTrees.getTotalNumberOfTrees();
				int totalManhattan = allTrees.getCountByBorough("Manhattan");
				int totalBronx = allTrees.getCountByBorough("Bronx");
				int totalBrooklyn = allTrees.getCountByBorough("Brooklyn");
				int totalQueens = allTrees.getCountByBorough("Queens");
				int totalStatenIsland = allTrees.getCountByBorough("Staten Island");
				
				double percentageNYC = 100 * ((double) (speciesNYC) / totalNYC);
				double percentageManhattan = 100 * ((double) (speciesManhattan) / totalManhattan);
				double percentageBronx = 100 * ((double) (speciesBronx) / totalBronx);
				double percentageBrooklyn = 100 * ((double) (speciesBrooklyn) / totalBrooklyn);
				double percentageQueens = 100 * ((double) (speciesQueens) / totalQueens);
				double percentageStatenIsland = 100 * ((double) (speciesStatenIsland) / totalStatenIsland);
				
				System.out.println();
				
				if (matchingTrees.size() == 0) {
					System.out.println("There are no records of " + species + " on NYC streets");
				} else {
					System.out.println("Popularity in the city: ");
					System.out.println("NYC: " + speciesNYC + "(" + totalNYC + ") " + String.format("%.2f", percentageNYC) + "%");
					System.out.println("Manhattan: " + speciesManhattan + " (" + totalManhattan + ") " + String.format("%.2f", percentageManhattan) + "%");
					System.out.println("Bronx: " + speciesBronx + " (" + totalBronx + ") " + String.format("%.2f", percentageBronx) + "%");
					System.out.println("Brooklyn: " + speciesBrooklyn + " (" + totalBrooklyn + ") " + String.format("%.2f", percentageBrooklyn) + "%");
					System.out.println("Queens: " + speciesQueens + " (" + totalQueens + ") " + String.format("%.2f", percentageQueens) + "%");
					System.out.println("Staten Island: " + speciesStatenIsland + " (" + totalStatenIsland + ") " + String.format("%.2f", percentageStatenIsland) + "%");
				}
				
			}
		}
		
		
	}
	
}
