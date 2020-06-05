package SpecialConcepts;

class SuperClass2 {
	public void print() {
		System.out.println("Super Print");
	}
}

public class SubClass2 extends SuperClass2 {

	public void print() {
		System.out.println("Sub Print");
	}
	
	public static void main(String[] args) {
		SuperClass2 superClass1 = new SubClass2();
		superClass1.print();
	}
}
