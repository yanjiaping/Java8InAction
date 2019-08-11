package chapter5;

public class Dish {

	private final String name;
	private final int calories;

	public Dish(String name, Integer calories) {
		this.name = name;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public Integer getCalories() {
		return calories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (calories != other.calories)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", calories=" + calories + "]";
	}

}
