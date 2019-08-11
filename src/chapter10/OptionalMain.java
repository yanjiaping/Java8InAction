package chapter10;

import java.util.Optional;

public class OptionalMain {

	public static void main(String[] args) {
		new OptionalMain().getCarInsuranceName(Optional.of(new Person()));
	}

	public String getCarInsuranceName(Optional<Person> optPerson) {
		return optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
	}

}
