package com.goeuro;


public class BusinessMainClass {
	private static final String OUTPUT_CSV = "output.csv";
	private static final String URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

	public static void main(String[] args) 
	{

		// input argument validation
		if (args.length != 1) {
			System.out.println("Incorrect Usage.");
			System.out.println("Usage: java -jar GoEuroTest.jar \"STRING\"");
			System.out.println("where\"STRING\" is API endpoint");
			return;
		}

		String endpoint = URL + args[0];
		String jsonString = IOUtil.getJsonString(endpoint);
		String csv = JsonToCsvConverter.convert(jsonString);
		IOUtil.writeCsvToFile(csv, OUTPUT_CSV);

	}
	
}
