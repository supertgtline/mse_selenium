package InheritanceExamples;

public class MukeshKnowsOptimalImplementation implements WhatAmodWantsButDontKnowHowToDo{

	@Override
	public void swapTwoIntVariables(int a, int b) {
		System.out.println("--------------Before swap------------");
		System.out.println("a :" + a);
		System.out.println("b :" + b);
		/// Swap logic without using temporary
		a = a+b;
		b = a -b;
		a = a-b;
		System.out.println("--------------Before swap------------");
		System.out.println("a :" + a);
		System.out.println("b :" + b);
	
	}

}
