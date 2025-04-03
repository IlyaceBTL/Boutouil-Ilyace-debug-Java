package com.hemebiotech.analytics;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private ISymptomReader symptomReader;
	
    public WriteSymptomDataToFile(ISymptomReader symptomReader) {
        this.symptomReader = symptomReader;
    }
    

	@Override
	public void writeSymptoms(Map<String, Integer> symptom) {
		if(symptom == null || symptom.isEmpty()) {
			System.out.println("Aucun Symptome");
			return;
		}
		
		Map<String, Integer> countedSymptoms = countSymptoms();
		
		try {
			StringBuilder result = new StringBuilder();
			for(String key : countedSymptoms.keySet()) {
				result.append(countedSymptoms.get(key) +",");
			}
			System.out.println("Ecriture des symptomes :\n" + result);
		} catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	public Map<String, Integer> countSymptoms(){
		Map<String, Integer> symptomCount = new HashMap<>();
		List<String> symptomList = symptomReader.GetSymptoms();
		for (String symptom : symptomList) {
		    symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
		}

		return symptomCount; 
	}

}
