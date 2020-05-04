package InheritanceExamples;

public class UpcastImplementation {
	
	public static void main(String[] args) {
		
		WhatAmodWantsButDontKnowHowToDo whatAmodWantsButDontKnowHowToDo;
		// Using John's Implementation
		whatAmodWantsButDontKnowHowToDo = new JohnKnowsImplementation();
		whatAmodWantsButDontKnowHowToDo.swapTwoIntVariables(10, 20);
		// Using Mukesh's Implementation
		whatAmodWantsButDontKnowHowToDo = new MukeshKnowsOptimalImplementation();
		whatAmodWantsButDontKnowHowToDo.swapTwoIntVariables(10, 20);
	}

}
