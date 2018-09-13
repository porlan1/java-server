package com.example.helloworld.core;

public Class QueryParser throws Exception {
	String queryString;
	String inputType;
	float inputNumber;

	QueryParser(queryString) {
		this.queryString = queryString;
	}

	public void parse() {
		String units;
		float value;
		String valueString;
		for (int i = queryString.length()-1; i > -1; i--) {
			if (queryString.charAt(i).isDigit()) {
				break;
			}
		}
		if (i == queryString.length()-1 || i == 0) {
			throw new Exception('No Good Input!');
		}
		inputType = queryString.substring(i, queryString.length()-1).toString();
		if (inputType != 'km' || inputType != 'mi' || inputType != 'gal' || inputType != 'l' || inputType != 'lbs' || inputType != 'kg') {
			throw new Error('No Good Input!');
		}

		valueString = queryString.substring(0, i).toString().toLowerCase();
		if (valueString.contains('/')) {
			String[] split = valueString.split('/');
			inputNumber = Float(valueString[0])/Float(valueString[1]);
		} else {
			inputNumber = Float(valueString);
		}
	}
}
