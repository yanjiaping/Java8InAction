package chapter5;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BuildStreamDemo3 {

	public static void main(String[] args) {
		// ��ֵ������
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		// ����
		Stream<String> emptyStream = Stream.empty();

		// �����鴴����
		int[] numbers = { 2, 3, 5, 7, 11, 13 };
		int sum = Arrays.stream(numbers).sum();

		// ������iterate
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

		// 쳲�����Ԫ������
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
		.limit(20)
		.forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
		
		// ������generate
		Stream.generate(Math::random)
		.limit(5)
		.forEach(System.out::println);
	}

}
