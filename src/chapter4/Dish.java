package chapter4;

import java.util.Arrays;
import java.util.List;

public class Dish {

	public static List<Dish> getMenu() {
		return Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
	}

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	// public Dish(String name, Integer calories) {
	// this.name = name;
	// this.calories = calories;
	// }

	public Dish(String name, Boolean vegetarian, Integer calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public Integer getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", calories=" + calories + "]";
	}

	public enum Type {
		MEAT, FISH, OTHER
	}
}
