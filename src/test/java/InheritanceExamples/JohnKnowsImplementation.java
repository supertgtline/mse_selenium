package InheritanceExamples;

public class JohnKnowsImplementation implements WhatAmodWantsButDontKnowHowToDo{

	@Override
	public void swapTwoIntVariables(int a, int b) {
		System.out.println("--------------Before swap------------");
		System.out.println("a :" + a);
		System.out.println("b :" + b);
		/// Swap logic using temporary
		int c = a;
		a = b;
		b = c;
		System.out.println("--------------Before swap------------");
		System.out.println("a :" + a);
		System.out.println("b :" + b);
	
	}

}
