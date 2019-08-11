package chapter6;

public class Dish {

	private final String name;
	private final int calories;
	private final Type type;
	private final Boolean vegetarian;

	public Dish(String name, Integer calories, Type type, Boolean vegetarian) {
		this.name = name;
		this.calories = calories;
		this.type = type;
		this.vegetarian = vegetarian;
	}

	public String getName() {
		return name;
	}

	public Integer getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	public Boolean isVegetarian() {
		return vegetarian;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((vegetarian == null) ? 0 : vegetarian.hashCode());
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
		if (type != other.type)
			return false;
		if (vegetarian == null) {
			if (other.vegetarian != null)
				return false;
		} else if (!vegetarian.equals(other.vegetarian))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", calories=" + calories + ", type=" + type + ", vegetarian=" + vegetarian + "]";
	}

	public enum Type {
		MEAT, FISH, OTHER
	}

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	}

}
