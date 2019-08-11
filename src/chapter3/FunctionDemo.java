package chapter3;

import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		Function<Integer, Integer> f1 = x -> x + 1;
		Function<Integer, Integer> g1 = x -> x * 2;
		Function<Integer, Integer> h1 = f1.andThen(g1);
		
		Integer hValue1 = h1.apply(2);
		System.out.println(hValue1);
		
		
		Function<Integer, Integer> f2 = x -> x + 1;
		Function<Integer, Integer> g2 = x -> x * 2;
		Function<Integer, Integer> h2 = f2.compose(g2);
		
		Integer hValue2 = h2.apply(2);
		System.out.println(hValue2);
		
	}

}
