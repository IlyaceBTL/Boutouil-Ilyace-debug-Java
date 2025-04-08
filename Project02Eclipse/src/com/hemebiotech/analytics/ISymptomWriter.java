package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Writes the number of symptoms and must be sorted in alphabetical order.
 */

public interface ISymptomWriter {

	void writeSymptoms(Map<String, Integer> symptom);

}
