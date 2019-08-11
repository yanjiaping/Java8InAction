package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {

	public static void main(String[] args) {
		// 数值流求和
		System.out.println("数值流求和");
		List<Dish> menu = Arrays.asList(new Dish("a", 100), new Dish("a", 100), new Dish("a", 100), new Dish("b", 200), new Dish("b", 200));
		int CaloriesSum = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(CaloriesSum);

		// 转换回对象流
		System.out.println("转换回对象流");
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		intStream.sum();
//		Stream<Integer> stream = intStream.boxed();
//		stream.reduce(Integer::sum);
		
		// 数值流求最值
		System.out.println("数值流求最值");
		OptionalInt maxCalories = new ArrayList<Dish>().stream().mapToInt(Dish::getCalories).max();
		int max = maxCalories.orElse(1);
		System.out.println(max);
		
		// 数值范围
		System.out.println("数值范围");
//		IntStream evenNumbers = IntStream.range(1, 100).filter(n -> n % 2 == 0);
		IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
		System.out.println(evenNumbers.count());
		
		// 勾股数
		System.out.println("勾股数");
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
				.boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
						.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
						.mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
				);
		pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
		
		Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100)
				.boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
						.mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
						.filter(t -> t[2] % 1 == 0)
				);
		
	}

}
