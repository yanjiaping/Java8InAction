package chapter7;

import java.util.stream.Stream;

public class ParallelStreamDemo1 {

	public static void main(String[] args) {
		System.out.println(sequentialSum(5000000));
	}

	// 顺序流求和
	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
	}

	// 并行流求和
	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}
	
}
