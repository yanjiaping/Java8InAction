package chapter4;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class StreamDemo2 {

	public static void main(String[] args) {
		List<Dish> menu = Dish.getMenu();
		
		List<String> names =
				menu.stream()
				.filter(d -> {
				System.out.println("filtering:" + d.getName());
				return d.getCalories() > 300;
				})
				.map(d -> {
				System.out.println("mapping:" + d.getName());
				return d.getName();
				})
				.limit(3)
				.collect(toList());
				System.out.println(names);
				
		menu.stream().forEach(System.out::println);
	}

}
