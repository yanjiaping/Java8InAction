package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Demo4 {

	public static void main(String[] args) {
		Transaction t1 = new Transaction(1000.0, new Currency("人民币"));
		Transaction t2 = new Transaction(1500.0, new Currency("人民币"));
		Transaction t3 = new Transaction(2000.0, new Currency("美元"));
		List<Transaction> transactions = Arrays.asList(t1, t2, t3);

		Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
		for (Transaction transaction : transactions) {
			if (transaction.getPrice() > 1000) {
				Currency currency = transaction.getCurrency();
				List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
				if (transactionsForCurrency == null) {
					transactionsForCurrency = new ArrayList<>();
					transactionsByCurrencies.put(currency, transactionsForCurrency);
				}
				transactionsForCurrency.add(transaction);
			}
		}

		Set<Entry<Currency, List<Transaction>>> entrySet = transactionsByCurrencies.entrySet();
		for (Entry<Currency, List<Transaction>> entry : entrySet) {
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
		
	}

}

class Transaction {

	private Double price;
	private Currency currency;

	public Transaction(Double price, Currency currency) {
		super();
		this.price = price;
		this.currency = currency;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Transaction [price=" + price + ", currency=" + currency + "]";
	}

}

class Currency {
	private String name;

	public Currency(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + "]";
	}

}
