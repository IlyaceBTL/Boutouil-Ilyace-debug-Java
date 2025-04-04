package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCount = new HashMap<>();

		for (String symptom : symptoms) {
			symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
		}

		return symptomCount;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> symptomSort = new TreeMap<>(symptoms);

		return symptomSort;

	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}

//public static void main(String args[]) throws Exception {
//
//	ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse\\symptoms.txt");
//
//	WriteSymptomDataToFile writer = new WriteSymptomDataToFile(reader);
//
//	Map<String, Integer> countedSymptoms = writer.countSymptoms();
//
//	writer.writeSymptoms(countedSymptoms);