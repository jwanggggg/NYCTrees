// TreeList ArrayList. Used to store each tree in the .csv file.

import java.util.*;

public class TreeList extends ArrayList<Tree>{
	// Default constructor
	
	public TreeList() {
		
	}
	
	// Getter method for all trees
	
	public int getTotalNumberOfTrees() {
		int treeCount = 0;
		for (int i = 0; i < size(); i++) {
			treeCount++;
		}
		return treeCount;
	}
	
	// Getter for tree species count. Inclusive ("linden" will give American Linden, etc.)
	
	public int getCountByTreeSpecies(String speciesName) {
		int treeSpeciesCount = 0;
		speciesName = speciesName.toLowerCase();
		for (int i = 0; i < size(); i++) {
			String currentTreeSpc = get(i).getSpc().toLowerCase();
			if (currentTreeSpc.contains(speciesName)) {
				treeSpeciesCount++;
			}
		}
		return treeSpeciesCount;
	}
	
	// Getter for tree in borough count
	
	public int getCountByBorough(String boroName) {
		int treeBoroCount = 0;
		boroName = boroName.toLowerCase();
		for (int i = 0; i < size(); i++) {
			String currentTreeBoro = get(i).getBoro().toLowerCase();
			if (currentTreeBoro.contains(boroName)) {
				treeBoroCount++;
			}
		}
		return treeBoroCount;
	}
	
	// Getter for species within borough
	
	public int getCountByTreeSpeciesBorough(String speciesName, String boroName) {
		int treeSpeciesBoroCount = 0;
		speciesName = speciesName.toLowerCase();
		boroName = boroName.toLowerCase();
		for (int i = 0; i < size(); i++) {
			String currentTreeSpc = get(i).getSpc().toLowerCase();
			String currentTreeBoro = get(i).getBoro().toLowerCase();
			if (currentTreeSpc.contains(speciesName) && boroName.equals(currentTreeBoro)) {
				treeSpeciesBoroCount++;
			}
		}
		return treeSpeciesBoroCount;
	}
	
	// Returns a matching String ArrayList for given species
	
	public ArrayList<String> getMatchingSpecies(String speciesName) {
		ArrayList<String> matchingSpecies = new ArrayList();
		speciesName = speciesName.toLowerCase();
		//Iterate through, add to matchingSpecies if it's a substring

		for (int i = 0; i < size(); i++) {
			String currentTreeSpc = get(i).getSpc().toLowerCase();
			if (currentTreeSpc.contains(speciesName) && !matchingSpecies.contains(currentTreeSpc)) {
				matchingSpecies.add(currentTreeSpc);
			}
		}
		return matchingSpecies;
	}

	
	@Override
	public String toString() {
		return "This is a list of your trees.";
	}
	
}
