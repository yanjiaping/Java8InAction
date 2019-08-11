package chapter2;

public class Apple {

	String color;
	Double weight;
	
	

	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}

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

}
