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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Step2 {

	public static String step2(String clientCredAccessToken) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		// url
		String url = "https://psd2.apiboidev.com/1/api/open-banking/v1.0/account-requests";
		System.out.println("url is: " + url);
		// body
		String requestJson = "{\"Data\": {\"Permissions\": [\"ReadAccountsDetail\",\"ReadTransactionsCredits\",\"ReadTransactionsDetail\"],\"ExpirationDateTime\": \"2018-01-19T00:00:00.875\",\"TransactionFromDateTime\": \"2014-01-19T00:00:00.800\",\"TransactionToDateTime\": \"2017-01-19T00:00:00.345\"},\"Risk\": {} }";
		
		// Read from File to String
		JsonObject jsonObject = new JsonObject();
		try {
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(new FileReader("E:/jsonFile/json.txt"));
			requestJson = jsonElement.toString();
		} catch (FileNotFoundException e) {
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		
		
		
		// headers
		HttpHeaders headers = new HttpHeaders();
		Map<String, String> headersMap = new HashMap<>();
		headersMap.put("Content-Type", "application/json");
		headersMap.put("Authorization", "Bearer " + clientCredAccessToken);
		headersMap.put("x-fapi-financial-id", "1234");
		headersMap.put("client_id", "6443e15975554bce8099e35b88b40465");
		headersMap.put("client_secret", "7ca382cf4dff4d2dBCF034DBBA34A653");
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