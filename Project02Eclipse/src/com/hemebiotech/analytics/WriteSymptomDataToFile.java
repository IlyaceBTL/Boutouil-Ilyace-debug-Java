package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Class responsible for writing symptoms and their occurrences in a file.
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	/**
	 * 
	 * Writes the symptoms and their number of occurrences to a file named
	 * "result.out".
	 *
	 * @param symptomMap a Map containing the symptoms (keys) and their number of
	 *                  occurrences (values).
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptomMap) {
		if (symptomMap == null || symptomMap.isEmpty()) {
			System.out.println("Aucun Symptome");
			return;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))) {
			for (String symptomKey : symptomMap.keySet()) {
				writer.write(symptomKey + " = " + symptomMap.get(symptomKey));
				writer.newLine();
			}
			System.out.println("result.out est ecrit");
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
