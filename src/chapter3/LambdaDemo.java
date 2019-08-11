package chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class LambdaDemo {

	public static void main(String[] args) {
		Apple a1 = new Apple("red", 50.0);
		Apple a2 = new Apple("orange", 30.0);
		Apple a3 = new Apple("yellow", 70.0);
		List<Apple> inventory = Arrays.asList(a1, a2, a3);

		// 1.���봫��
		inventory.sort(new AppleComparator());
		System.out.println("1.���봫��");
		inventory.forEach(System.out::println);

		// 2.ʹ��������
		inventory.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		}.reversed());
		System.out.println("2.ʹ��������");
		inventory.forEach(System.out::println);

		// 3.ʹ��Lambda���ʽ
//		inventory.sort((Apple o1, Apple o2) -> o1.getWeight().compareTo(o2.getWeight()));
//		inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
		inventory.sort(comparing(a -> a.getWeight()));
		System.out.println("3.ʹ��Lambda���ʽ");
		inventory.forEach(System.out::println);
		
		// 4.ʹ�÷�������
		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		System.out.println("3.ʹ�÷�������");
		inventory.forEach(System.out::println);

	}

}
