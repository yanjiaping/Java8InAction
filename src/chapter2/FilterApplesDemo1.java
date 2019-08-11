package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FilterApplesDemo1 {

	public static void main(String[] args) {
		Supplier<Apple> c1 = Apple::new;
		Apple apple = c1.get();
		
		Apple a1 = new Apple("red", 50.0);
		Apple a2 = new Apple("orange", 30.0);
		Apple a3 = new Apple("yellow", 70.0);
		List<Apple> inventory = Arrays.asList(a1, a2, a3);

		List<Apple> filterApples = FilterApplesDemo1.filterApples(inventory, new ApplePredicate() {

			@Override
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor()) && apple.getWeight() > 150;
			}
		});
		filterApples.forEach(System.out::println);

		List<Apple> filterApples2 = FilterApplesDemo1.filterApples(inventory, (Apple a) -> a.weight < 50);
		filterApples2.forEach(System.out::println);

		Thread t = new Thread(
				() -> System.out.println("Hello world")
		);
		t.start();
	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

}
