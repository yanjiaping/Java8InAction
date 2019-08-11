package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateReuseDemo {

	public static void main(String[] args) {
		Apple a1 = new Apple("red", 50.0);
		Apple a2 = new Apple("orange", 30.0);
		Apple a3 = new Apple("yellow", 70.0);
		List<Apple> inventory = Arrays.asList(a1, a2, a3);
		
		Predicate<Apple> redApplesPredicate = a -> a.getColor().equals("red");
		List<Apple> redApples = PredicateReuseDemo.filterApples(inventory, redApplesPredicate.negate().and(a->a.getColor().equals("orange")));
		redApples.forEach(System.out::println);
		
	}

	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

}
