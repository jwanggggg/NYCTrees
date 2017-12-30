// The tree class used to categorize each NYC tree.

public class Tree implements Comparable<Tree> {

	// Datafields & Constructor
	
	private int id;
	private int diam;
	private String status;
	private String health;
	private String spc;
	private int zip;
	private String boro;
	private double x;
	private double y;
	
	public Tree (int id, int diam, String status, String health, String spc, int zip, String boro, double x, double y) throws IllegalArgumentException {
		this.id = id;
		this.diam = diam;
		this.status = status;
		this.health = health;
		this.spc = spc;
		this.zip = zip;
		this.boro = boro;
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) throws IllegalArgumentException {
		Tree tree2 = (Tree) (o);
		if (getId() == tree2.getId() && getSpc() == tree2.getSpc()) {
			return true;
		}
		else if (getId() == tree2.getId() && getSpc() != tree2.getSpc()) {
			throw new IllegalArgumentException("Cannot have 2 trees of same ID and different species.");
		}
		else {
			return false;
		}
	}

	@Override
	public int compareTo(Tree myTree) {
		
		if (getSpc().equals(myTree.getSpc())) {
			if (getId() == myTree.getId()) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "This is a " + spc + " with ID " + id + " and diameter " + diam + ". Its status is " + status + " and is in " + health + " health. It is located in " + boro + ", zip code " + zip + " at coordinates " + x + "," + y + ".";
	}

	// Getter methods

	public int getId() {
		return id;
	}

	public String getSpc() {
		return spc;
	}

	public String getBoro() {
		return boro;
	}
	
}
