package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class responsible for counting,sorting.
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieves the list of symptoms.
	 *
	 * @return a list of symptoms.
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * 
	 * Takes a list of symptoms, counts how many times each one appears, and returns
	 * a map.
	 * 
	 * @param A list of symptoms.
	 * @return A map containing symptoms (keys) and their number of occurrences
	 *         (values).
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCount = new HashMap<>();

		for (String symptom : symptoms) {
			symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
		}

		return symptomCount;
	}

	/**
	 * Takes a map of symptoms and returns it sorted alphabetically.
	 * 
	 * @param A map of symptoms.
	 * @return A TreeMap sorted alphabetically.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> symptomSort = new TreeMap<>(symptoms);

		return symptomSort;

	}

	/**
	 * Writes the symptoms and their occurrence counts.
	 *
	 * @param symptoms a map of symptoms and their counts
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
