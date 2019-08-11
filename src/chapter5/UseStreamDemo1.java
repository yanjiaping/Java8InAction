package chapter5;

import java.util.Arrays;
import java.util.List;

public class UseStreamDemo1 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

		System.out.println("************************");
		List<Dish> menu = Arrays.asList(new Dish("a", 100), new Dish("a", 100), new Dish("a", 100), new Dish("b", 200),
				new Dish("b", 200));
		menu.stream().skip(5).forEach(System.out::println);

	}

}
