package Retry;

public class Usages {

	public static void main(String[] args) {
		
		I1 i1 = new Imple();
		i1.find();
		i1.findAll();
		
		
		I2 i2 = new Imple();
		i2.find();
		i2.findAll();
		i2.findAny();
	}
}
