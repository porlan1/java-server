package com.example.helloworld.core;
import java.util.HashMap;
import java.util.Map;

public class Converter {
	String inputType;
	String direction;
	double inputNumber;
	static Map<String, Float> map = new HashMap<String, Float>(3);
	static {
		map.put("LBS_KG", new Float(0.453592));
		map.put("GAL_L", new Float(3.78541));
		map.put("MI_KM", new Float(1.60934));
	}

	Converter(String queryString) throws Exception {
		QueryParser queryParser = new QueryParser(queryString);
		queryParser.parse();
		inputType = queryParser.inputType;
		inputNumber = queryParser.inputNumber;
		direction = (queryParser.inputType == "lbs" || queryParser.inputType == "gal" || queryParser.inputType == "mi")? "forward": "backward";
	}

	double convertInput() {
		if (direction == "forward") {
			return inputNumber*map.get(inputType);
		}
		return inputNumber/map.get(inputType);
	}
}
