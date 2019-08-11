package chapter4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {

	public static void main(String[] args) {
		List<Dish> menu = Dish.getMenu();
		
		// Java7
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for (Dish d : menu) {
			if (d.getCalories() < 400) {
				lowCaloricDishes.add(d);
			}
		}
		lowCaloricDishes.sort(new Comparator<Dish>() {
			@Override
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		List<String> lowCaloricDishesName = new ArrayList<>();
		for (Dish d : lowCaloricDishes) {
			lowCaloricDishesName.add(d.getName());
		}
		for (String s : lowCaloricDishesName) {
			System.out.println(s);
		}

		// Java8
		System.out.println("****************************************");
		List<String> lowCaloricDishesNameByJava8 = menu.stream()
				.filter(d -> d.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories))
				.map(dd -> dd.getName() + ":" + dd.getCalories())
				.collect(Collectors.toList());
		lowCaloricDishesNameByJava8.forEach(System.out::println);

	}

}
