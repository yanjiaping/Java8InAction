package chapter12;

import java.time.Instant;
import java.time.temporal.ChronoField;

public class InstanceDemo3 {
	
	public static void main(String[] args) {
		Instant instant1 = Instant.ofEpochSecond(3);
		System.out.println(instant1);// 1970-01-01T00:00:03Z

		Instant instant2 = Instant.ofEpochSecond(3, 0);
		System.out.println(instant2);// 1970-01-01T00:00:03Z

		Instant instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
		System.out.println(instant3);// 1970-01-01T00:00:03Z

		Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);
		System.out.println(instant4);// 1970-01-01T00:00:03Z
		
		int day = Instant.now().get(ChronoField.DAY_OF_MONTH);

	}

}
