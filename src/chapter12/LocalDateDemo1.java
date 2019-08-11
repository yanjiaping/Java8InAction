package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateDemo1 {

	public static void main(String[] args) {
		/**
		 * LocalDate
		 */
		LocalDate date = LocalDate.of(2014, 3, 18);
		int year = date.getYear();
		System.out.println(year);

		Month month = date.getMonth();
		System.out.println(month);

		int day = date.getDayOfMonth();
		System.out.println(day);

		DayOfWeek dow = date.getDayOfWeek();
		System.out.println(dow);

		int len = date.lengthOfMonth();
		System.out.println(len);

		boolean leap = date.isLeapYear();
		System.out.println(leap);
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		int year1 = date.get(ChronoField.YEAR);
		System.out.println(year1);
		int month1 = date.get(ChronoField.MONTH_OF_YEAR);
		System.out.println(month1);
		int day1 = date.get(ChronoField.DAY_OF_MONTH);
		System.out.println(day1);
		
		/**
		 * LocalTime
		 */
		LocalTime time = LocalTime.of(13, 45, 20);
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		
		/**
		 * parse
		 */
		LocalDate date1 = LocalDate.parse("2014-03-18");
		LocalTime time1 = LocalTime.parse("13:45:20");

	}

}
