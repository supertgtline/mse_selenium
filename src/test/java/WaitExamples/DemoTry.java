package WaitExamples;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoTry {
	
	public static void main(String[] args) {
		
		String s1= "I love you";
		String s = Stream.of(s1.split("")).map(w->new StringBuilder(s1).reverse()).collect(Collectors.joining(""));
		System.out.println(s);
	}

}
