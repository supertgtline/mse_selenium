package WaitExamples;

import java.util.ArrayList;

public class ListEx {
	
	public static void main(String[] args) {
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Amod");
		list.add("Mukesh");
		list.add("Selenium");
		
		System.out.println(list);
		
		list.add(10, "New");
		System.out.println(list);
		
		list.remove(0);
		
		System.out.println(list);
	}

}
