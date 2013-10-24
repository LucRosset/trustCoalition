package trustCoalition;

import java.util.ArrayList;

import repast.simphony.space.grid.Grid;

public class Agent {
	
	private int ID;
	private int sizeX;
	private int sizeY;
	private int S;
	private int P;
	private int R;
	private int T;
	private int strategy;
	private int tax;
	private int startingTrust;
	private int deltaTrust;
	private int threshold;
	private int leaderID;
	private int numNeighbors;
	private int numDefectors;
	private boolean considerTrust;
	private boolean independent;
	private boolean leader;
	private boolean moore; 
	private boolean torus;
	private double payoff; 
	private ArrayList<Agent> neighbors; 
	private ArrayList<Agent> coalition;
	private Grid<Agent> grid;
	
	Agent (int ID, int sizeX, int sizeY, int S, int P, int R, int T, int strategy,
			int tax, int startingTrust, int deltaTrust, int threshold,
			boolean considerTrust, boolean moore, boolean torus, Grid<Agent> grid) {
		this.ID = ID;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.S = S;
		this.P = P;
		this.R = R;
		this.T = T;
		this.strategy = strategy;
		this.tax = tax;
		this.startingTrust = startingTrust;
		this.deltaTrust = deltaTrust;
		this.threshold = threshold;
		this.considerTrust = considerTrust;
		this.moore = moore;
		this.torus = torus;
		this.grid = grid;
		
		leaderID = -1; // Independent agents have leaderID = -1
		independent = true;
		leader = false;
		payoff = 0;
		coalition = null;
		
		// neighbors, numNeighbors and numDefectors to be set by Agent.neighborhoodSetup() 
	}
	
}
