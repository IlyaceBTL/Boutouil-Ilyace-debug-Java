package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main class that runs the application to count, sort, read and write symptom
 * data.
 */
public class Main {

	public static void main(String[] args) {

		// Create a reader to read symptoms from a file
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse\\symptoms.txt");
		// Create a writer to write the symptom data to a file
		ISymptomWriter writer = new WriteSymptomDataToFile();
		// Create a counter that will process the symptoms
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

		// Retrieve the list of symptoms from the reader
		List<String> symptomList = counter.getSymptoms();
		// Count the occurrences of each symptom
		Map<String, Integer> symptomCounter = counter.countSymptoms(symptomList);
		// Sort the symptoms alphabetically
		Map<String, Integer> symptomCounterSort = counter.sortSymptoms(symptomCounter);
		// Write the sorted symptom counts to the output file
		counter.writeSymptoms(symptomCounterSort);

	}

}
