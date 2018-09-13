package com.example.helloworld.core;
import java.util.HashMap;

public Class Converter throws Exception {
	String inputType;
	String direction;
	double inputNumber;
	static final Map<String, Float> map = new HashMap<>(3);
	map.put('LBS_KG', 0.453592);
	map.put('GAL_L', 3.78541);
	map.put('MI_KM', 1.60934);

	Converter(String queryString) {
		QueryParser queryParser = new QueryParser(queryString);
		queryParser.parse();
		inputType = queryParser.inputType;
		inputNumber = queryParser.inputNumber;
		direction = (queryParser.inputType == 'lbs' || queryParser.inputType == 'gal' || queryParser.inputType == 'mi');
	}

	double convertInput() {
		if (direction === 'forward') {
			return inputNumber*map.get(inputType);
		}
		return inputNumber/map.get(inputType);
	}
}
