package com.example.helloworld.core;

public class QueryParser {
	String queryString;
	public String inputType;
	public float inputNumber;

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
		if (i == queryString.length()-1) {
			throw new Exception();
		}
		inputType = queryString.substring(i + 1).toString().toLowerCase();
		System.out.println(inputType);
		if (!inputType.equals("km") && !inputType.equals("mi") && !inputType.equals("gal") && !inputType.equals("l") && !inputType.equals("lbs") && !inputType.equals("kg")) {
			throw new Exception();
		}

		valueString = queryString.substring(0, i + 1).toString().toLowerCase();
		if (valueString.contains("/")) {
			String[] split = valueString.split("/");
			inputNumber = Float.parseFloat(split[0])/Float.parseFloat(split[1]);
		} else {
			inputNumber = Float.parseFloat(valueString);
		}
	}
}
