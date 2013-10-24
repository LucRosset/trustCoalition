package trustCoalition;

import repast.simphony.context.Context;
import repast.simphony.context.DefaultContext;
import repast.simphony.context.space.grid.GridFactory;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.StrictBorders;
import repast.simphony.space.grid.SimpleGridAdder;
import repast.simphony.space.grid.WrapAroundBorders;

public class TrustCoalitionBuilder extends DefaultContext<Agent> implements
		ContextBuilder<Agent> {

	@Override
	public Context<Agent> build(Context<Agent> context) {

		// THESE SHOULD NOT BE HARD-CODED...
		int S = 0;
		int P = 1;
		int R = 3;
		int T = 5;
		int sizeX = 64;
		int sizeY = 64;
		int considerTrustRatio = 100;
		int tax = 25;
		int deltaTrust = 5;
		int startingTrust = 15;
		int threshold = 25;
		boolean torus = true;
		boolean moore = true;

		context.setId("agents");

		GridFactory gridFactory = GridFactoryFinder.createGridFactory(null);
		Grid<Agent> grid;
		if (torus) {
			grid = gridFactory.createGrid("grid", context,
					new GridBuilderParameters<Agent>(new WrapAroundBorders(),
							new SimpleGridAdder<Agent>(), true, sizeX, sizeY));
		} else {
			grid = gridFactory.createGrid("grid", context,
					new GridBuilderParameters<Agent>(new StrictBorders(),
							new SimpleGridAdder<Agent>(), true, sizeX, sizeY));
		}

		boolean considerTrust;
		for (int i = 0, agentCount = sizeX * sizeY; i < agentCount; i++) {
			if (RandomHelper.nextIntFromTo(0, 100) < considerTrustRatio) {
				considerTrust = true;
			} else {
				considerTrust = false;
			}
			context.add(new Agent(i, sizeX, sizeY, S, P, R, T, RandomHelper
					.nextIntFromTo(0, 2), tax, startingTrust, deltaTrust,
					threshold, considerTrust, moore, torus, grid));
		}

		int i = 0;
		for (Agent ag : context) {
			grid.moveTo(ag, i % sizeY, i / sizeY);
			i++;
		}

		return context;
	}
}
