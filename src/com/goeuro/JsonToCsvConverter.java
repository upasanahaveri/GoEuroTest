package com.goeuro;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonToCsvConverter {
	
	private static final String GEO_POSITION = "geo_position";
	private static final String TYPE = "type";
	private static final String NAME = "name";
	private static final String _TYPE = "_type";
	private static final String LATITUDE = "latitude";
	private static final String LONGITUDE = "longitude";
	private static final String _ID = "_id";

	public static String convert(String jsonString) 
	{
		if(null == jsonString)
		{
			return null;
		}
		
		String csv = null;
		JSONArray jsonArray;
		try {
			jsonArray = new JSONArray(jsonString);
			JSONArray newJsonArray = new JSONArray();
			for (int i = 0; i < jsonArray.length(); i++)
			{
				JSONObject newJson = new JSONObject();
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				newJson.put(_TYPE, jsonObject.get(_TYPE));
				newJson.put(_ID, jsonObject.get(_ID));
				newJson.put(NAME, jsonObject.get(NAME));
				newJson.put(TYPE, jsonObject.get(TYPE));
				JSONObject geoJson = jsonObject.getJSONObject(GEO_POSITION);
				newJson.put(LONGITUDE, geoJson.get(LONGITUDE));
				newJson.put(LATITUDE, geoJson.get(LATITUDE));
				newJsonArray.put(newJson);
				csv = CDL.toString(newJsonArray);
			}
		} catch (JSONException e) {
			System.err.println(e.getMessage());
			throw new BusinessException(e);
		}	
		return csv;
	}

}
