package chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

import chapter6.Dish;
import chapter6.Dish.CaloricLevel;
import chapter6.Dish.Type;

public class CollectorsDemo1 {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("prawns", 100, Dish.Type.FISH, false),
				new Dish("salmon", 250, Dish.Type.FISH, false), new Dish("french fries", 240, Dish.Type.OTHER, true),
				new Dish("rice", 500, Dish.Type.OTHER, true), new Dish("season fruit", 1000, Dish.Type.OTHER, true),
				new Dish("pizza", 300, Dish.Type.OTHER, true), new Dish("pork", 800, Dish.Type.MEAT, false),
				new Dish("beef", 200, Dish.Type.MEAT, false), new Dish("chicken", 700, Dish.Type.MEAT, false));

		// 收集器数量
		Long howManyDishes1 = menu.stream().collect(Collectors.counting());
		System.out.println(howManyDishes1);

		long howManyDishes2 = menu.stream().count();
		System.out.println(howManyDishes2);

		// 最值
		Optional<Dish> maxCaloriesDish = menu.stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));
		System.out.println(maxCaloriesDish);

		// 汇总
		IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);

		String shortMenu1 = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println(shortMenu1);

		// reducing
		Integer collect = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
		System.out.println(collect);

		Optional<Dish> mostCalorieDish = menu.stream()
				.collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.println(mostCalorieDish);

		// groupBy
		Map<Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(dishesByType);

		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> {
			if (dish.getCalories() <= 400)
				return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		}));
		System.out.println(dishesByCaloricLevel);

		// groupBy传两个参数
		Map<Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, Collectors.counting()));
		System.out.println(typesCount);

		Map<Dish.Type, Optional<Dish>> mostCaloricByType1 = menu.stream()
				.collect(groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
		System.out.println(mostCaloricByType1);

		Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream().collect(groupingBy(Dish::getType, Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricByType2);

		Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
				.collect(groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
		System.out.println(totalCaloriesByType);

		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
				.collect(groupingBy(Dish::getType, Collectors.mapping(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				}, Collectors.toSet())));
		System.out.println(caloricLevelsByType);
	}

}
