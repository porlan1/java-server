package com.example.helloworld.core;

public class QueryParser {
	String queryString;
	String inputType;
	float inputNumber;

	QueryParser(String queryString) {
		this.queryString = queryString;
	}

	public void parse() throws Exception {
		String valueString;
		int i;
		for (i = queryString.length()-1; i > -1; i--) {
			if (Character.isDigit(queryString.charAt(i))) {
				break;
			}
		}
		if (i == queryString.length()-1 || i == 0) {
			throw new Exception();
		}
		inputType = queryString.substring(i, queryString.length()-1).toString();
		if (inputType != "km" || inputType != "mi" || inputType != "gal" || inputType != "l" || inputType != "lbs" || inputType != "kg") {
			throw new Exception();
		}

		valueString = queryString.substring(0, i).toString().toLowerCase();
		if (valueString.contains("/")) {
			String[] split = valueString.split("/");
			inputNumber = Float.parseFloat(split[0])/Float.parseFloat(split[1]);
		} else {
			inputNumber = Float.parseFloat(valueString);
		}
	}
}
