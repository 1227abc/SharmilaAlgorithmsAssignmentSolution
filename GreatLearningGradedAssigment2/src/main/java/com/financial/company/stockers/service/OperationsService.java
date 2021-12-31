package com.financial.company.stockers.service;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


public class OperationsService  {

	public void printNaturalOrder(TreeMap map) {

		Map sortedMap = sortByValues(map);

		System.out.println("Stock prices in ascending order are :");
		System.out.println(sortedMap.values());
	}
	
	public void sortValuesbyDesc(TreeMap map) {

		Map ReversedOrderMap = sortByValuesDesc(map);
		System.out.println("Stock prices in descending order are :");
		System.out.println(ReversedOrderMap.values());

	}

	public void searchStockPrice(TreeMap map, double searchPrice) {

		if (map.containsValue(searchPrice))
			System.out.println("Stock of value " + searchPrice + " is present");
		else

			System.out.println("Stock of value " + searchPrice + " is not present");
	}

	
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {

		Comparator<K> valueComparator = new Comparator<K>() {

			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};

		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValuesDesc(final Map<K, V> map) {

		Comparator<K> valueComparator = new Comparator<K>() {

			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};

		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	

}
