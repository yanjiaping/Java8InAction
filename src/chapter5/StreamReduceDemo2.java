package chapter5;

import java.util.Arrays;
import java.util.List;

public class StreamReduceDemo2 {

	public static void main(String[] args) {
		// Lambda
		List<Integer> numbers = Arrays.asList(1, 2, 4, 7, 11);
		Integer sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum1);

		// ��������
		System.out.println("************************************");
		Integer sum2 = numbers.stream().reduce(1, Integer::sum);
		System.out.println(sum2);

		// reduce�����ֵ����Сֵ
		System.out.println("************************************");
		numbers.stream().reduce(Integer::max).ifPresent(a -> System.out.println("���ֵ��" + a));
		numbers.stream().reduce(Integer::min).ifPresent(a -> System.out.println("��Сֵ��" + a));
		
	}

}
