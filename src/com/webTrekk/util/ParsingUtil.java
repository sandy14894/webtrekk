package com.webTrekk.util;

import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.web.util.HtmlUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ParsingUtil {
	

	public static List<Object> convertJSONStringToList(String jsonString2,
			Class<?> myClass) throws JSONException, JsonParseException,
			JsonMappingException, IOException, ClassNotFoundException {
		List<Object> l = new ArrayList<Object>();

		jsonString2 = validateString(Normalizer.normalize(jsonString2,
				Form.NFKC));

		StringBuilder jsonString = new StringBuilder();
		if (!jsonString2.startsWith("[")) {
			jsonString.append("[");
		}
		jsonString.append(jsonString2);
		if (!jsonString2.endsWith("]")) {
			jsonString.append("]");
		}

		JSONArray j = new JSONArray(jsonString.toString());

		if (j.length() != 0) {
			for (int i = 0; i < j.length(); i++) {

				ObjectMapper mapper = new ObjectMapper();

				Object o = mapper.readValue(j.get(i).toString(), myClass);
				l.add(o);
			}

		}

		return l;

	}

	public static String validateString(String string) {
		if (null == string) {
			return null;
		}

		// string = string.replaceAll("\r", "%0A");
		string = string.replaceAll("\n", "%XyZ");
		string = string.replaceAll("%XyZ", "\n");
		string = Normalizer.normalize(string, Form.NFKC);
		string = HtmlUtils.htmlEscape(string);
		string = HtmlUtils.htmlUnescape(string);

		return string;
	}

	
}
