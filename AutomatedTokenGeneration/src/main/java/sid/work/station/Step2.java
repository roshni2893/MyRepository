package sid.work.station;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Step2 {

	public static String step2(String clientCredAccessToken) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		// url
		String url = Constants.STEP2_URL;
		System.out.println("url is: " + url);

		// body read from file
		String requestJson = null;
		try {
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(new FileReader("src/main/resources/Step2Body.json"));
			requestJson = jsonElement.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// headers
		HttpHeaders headers = new HttpHeaders();
		Map<String, String> headersMap = new HashMap<>();
		headersMap.put("Content-Type", "application/json");
		headersMap.put("Authorization", "Bearer " + clientCredAccessToken);
		headersMap.put("x-fapi-financial-id", Constants.STEP2_X_FAPI);
		headersMap.put("client_id", Constants.STEP2_CLIENT_ID);
		headersMap.put("client_secret", Constants.STEP2_CLIENT_SECRET);
		headers.setAll(headersMap);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

		Object finalResponse = restTemplate.postForObject(url, entity, Object.class);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(finalResponse);
		JsonNode rootNode = mapper.readTree(jsonString);
		JsonNode dataNode = rootNode.path("Data");
		JsonNode accReqNode = dataNode.path("AccountRequestId");
		return accReqNode.textValue();
	}
}