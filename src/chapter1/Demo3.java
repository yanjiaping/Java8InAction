package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo3 {

	public static void main(String[] args) {
		Apple a1 = new Apple("green", 50.0);
		Apple a2 = new Apple("orange", 30.0);
		Apple a3 = new Apple("yellow", 151.0);
		List<Apple> inventory = Arrays.asList(a1, a2, a3);
		
		/**
		 * 方法引用
		 */
		List<Apple> inventory1 = Demo3.filterApples(inventory, Demo3::isGreenApple);
		inventory1.forEach(System.out::println);
		System.out.println();
		
		/**
		 * 方法引用
		 */
		List<Apple> inventory2 = Demo3.filterApples(inventory, Demo3::isHeavyApple);
		inventory2.forEach(System.out::println);
		System.out.println();
		
		/**
		 * lambda表达式
		 */
		List<Apple> inventory3 = Demo3.filterApples(inventory, (Apple a) -> "orange".equals(a.getColor()));
		inventory3.forEach(System.out::println);
		
		/**
		 * lambda表达式
		 */
		List<Apple> inventory4 = Demo3.filterApples(inventory, (Apple a) -> a.getWeight() > 30 && a.getColor().equals("yellow"));
		inventory4.forEach(System.out::println);
	}

	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
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
