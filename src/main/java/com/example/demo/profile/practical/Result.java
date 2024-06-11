package com.example.demo.profile.practical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jboss.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

class Result {
	private final static Logger log = Logger.getLogger(Result.class.getName());

	public static void main(String[] args) {
		/*
		 * Complete the 'getPhoneNumbers' function below.
		 *
		 * The function is expected to return a STRING. The function accepts following
		 * parameters: 1. STRING country 2. STRING phoneNumber Base URL for copy/paste:
		 * https://jsonmock.hackerrank.com/api/countries?name=country
		 */
		log.info(getPhoneNumbers("Afghanistan", "97845215"));
		log.info(getPhoneNumbers("India", "97845215"));
		log.info(getPhoneNumbers("Nepal", "97845215"));
		log.info(getPhoneNumbers("America", "97845215"));
		log.info(getPhoneNumbers("SouthAfrica", "97845215"));

	}

	public static String getPhoneNumbers(String country, String phoneNumber) {
		// {"page":1,"per_page":10,"total":0,"total_pages":0,"data":[]}

		HttpURLConnection con = null;
		String callingCodes = "-1";
		try {
			URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=" + country);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			if (con.getResponseCode() == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				//log.info(content.toString());

				JSONObject obj = new JSONObject(content.toString());
				JSONArray objArray = ((JSONArray) obj.get("data"));
				JSONObject data = (JSONObject) objArray.get(0);
				JSONArray dataArray = (JSONArray) data.get("callingCodes");
				callingCodes = (String)dataArray.getString(0);
				//log.info(callingCodes);
				in.close();
				
				StringBuilder sb = new StringBuilder();
				callingCodes = sb.append(callingCodes).append(" ").append(phoneNumber).toString();
				//log.info(callingCodes);
				return  callingCodes;
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		return "-1";
	}
}
