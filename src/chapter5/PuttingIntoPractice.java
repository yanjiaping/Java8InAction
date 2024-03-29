package chapter5;

import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );
		
		//(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）
		List<Transaction> tr2011 = transactions.stream()
				.filter(t -> t.getYear() == 2011)
				.sorted(comparing(Transaction::getValue))
				.collect(toList());
		System.out.println(tr2011);
		
		//(2) 交易员都在哪些不同的城市工作过？
		List<String> cities = transactions.stream()
				.map(t -> t.getTrader().getCity())
				.distinct()
				.collect(toList()/*toSet*/);
		System.out.println(cities);
		
		//(3) 查找所有来自于剑桥的交易员，并按姓名排序。
		List<Trader> traders = transactions.stream()
				.map(Transaction::getTrader)
				.filter(t -> t.getCity().equals("Cambridge"))
				.sorted(comparing(Trader::getName))
				.distinct()
				.collect(toList());
		System.out.println(traders);
		
		//(4) 返回所有交易员的姓名字符串，按字母顺序排序。
		String traderStr = transactions.stream()
				.map(t -> t.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (s1, s2) -> s1 + s2);
		System.out.println(traderStr);
		
		//(5) 有没有交易员是在米兰工作的？
		boolean milanBased = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(milanBased);
		
		//(6) 打印生活在剑桥的交易员的所有交易额。
		transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue)
				.forEach(System.out::println);
		
		
		//(7) 所有交易中，最高的交易额是多少？
		Integer highestValue = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);
		System.out.println(highestValue);
		
		//(8) 找到交易额最小的交易。
		transactions.stream().min(comparing(Transaction::getValue)).ifPresent(System.out::println);;

	}

}
