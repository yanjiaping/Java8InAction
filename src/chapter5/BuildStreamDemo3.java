package chapter5;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BuildStreamDemo3 {

	public static void main(String[] args) {
		// 由值创建流
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		// 空流
		Stream<String> emptyStream = Stream.empty();

		// 由数组创建流
		int[] numbers = { 2, 3, 5, 7, 11, 13 };
		int sum = Arrays.stream(numbers).sum();

		// 无限流iterate
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

		// 斐波纳契元组序列
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
		.limit(20)
		.forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
		
		// 无限流generate
		Stream.generate(Math::random)
		.limit(5)
		.forEach(System.out::println);
	}

}
