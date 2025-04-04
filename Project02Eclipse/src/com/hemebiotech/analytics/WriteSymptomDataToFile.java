package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Besoin d'un trie alphabetique pour countSymptoms
 *
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoMap) {
		if (symptoMap == null || symptoMap.isEmpty()) {
			System.out.println("Aucun Symptome");
			return;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))) {
			for (String symptomKey : symptoMap.keySet()) {
				writer.write(symptomKey + " = " + symptoMap.get(symptomKey));
				writer.newLine();
			}
			System.out.println("result.out est ecrit");
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	// public Map<String, Integer> countSymptoms() {
	// List<String> symptomList = symptomReader.getSymptoms();
	// for (String symptom : symptomList) {
	// symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
	// }

	// return symptomCount;
	// }
}
