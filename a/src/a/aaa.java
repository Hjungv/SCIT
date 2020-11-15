package a;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class aaa {

	public static void main(String[] args) {
		
		Object ob = new Object();
		ArrayList<Integer> k = new ArrayList<Integer>();
		int a = 10;  int b = 20;
		k.add(a);		k.add(b);
		
		

		a = 30;
		
		for(int i : k) {
			System.out.println(i);
		}

		
		ArrayList<B> bb = new ArrayList<B>();
		B b1 = new B(); b1.setB(10);	B b2 = new B(); b2.setB(20);
		bb.add(b1);		bb.add(b2);

		b1.setB(30);
		
		System.out.println(b1);

		for(B i : bb) {
			System.out.println(i.getB());
		}

		





	}

}
