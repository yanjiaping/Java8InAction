package chapter1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {
		Apple a1 = new Apple("red", 50.0);
		Apple a2 = new Apple("orange", 30.0);
		Apple a3 = new Apple("yellow", 70.0);
		List<Apple> appleList = Arrays.asList(a1, a2, a3);
		
		Collections.sort(appleList, new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});
		appleList.forEach(System.out::println);
		
		System.out.println();
		
		Collections.sort(appleList, Collections.reverseOrder());
		appleList.forEach(System.out::println);
		
		System.out.println();

		Collections.sort(appleList, Collections.reverseOrder(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o2.getWeight().compareTo(o1.getWeight());
			}
		}));
		appleList.forEach(System.out::println);

	}

}

class Apple implements Comparable<Apple> {

	String color;
	Double weight;

	public Apple(String color, Double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Apple o) {
		return this.getWeight().compareTo(o.getWeight());
	}

}