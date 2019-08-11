package chapter12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeDemo2 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2014, 3, 18);
		LocalTime time = LocalTime.of(13, 45, 20);

		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
		System.out.println(dt1);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		System.out.println(dt2);
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		System.out.println(dt3);
		LocalDateTime dt4 = date.atTime(time);
		System.out.println(dt4);
		LocalDateTime dt5 = time.atDate(date);
		System.out.println(dt5);

	}

}
