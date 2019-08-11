package chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartitioningBy {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("prawns", 100, Dish.Type.FISH, false),
				new Dish("salmon", 250, Dish.Type.FISH, false), new Dish("french fries", 240, Dish.Type.OTHER, true),
				new Dish("rice", 500, Dish.Type.OTHER, true), new Dish("season fruit", 1000, Dish.Type.OTHER, true),
				new Dish("pizza", 300, Dish.Type.OTHER, true), new Dish("pork", 800, Dish.Type.MEAT, false),
				new Dish("beef", 200, Dish.Type.MEAT, false), new Dish("chicken", 700, Dish.Type.MEAT, false));

		// 菜单按照素食和非素食分开
		Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
		System.out.println(partitionedMenu);

		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
		System.out.println(vegetarianDishesByType);

		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricPartitionedByVegetarian);
		
		// TODO 6.4.2 P128

	}

}
