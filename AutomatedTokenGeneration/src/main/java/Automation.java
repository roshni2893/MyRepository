import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Automation {
	public static void main(String[] args) throws IOException {
		// Step1
		String url = "https://psd2.apiboidev.com/openbanking-nOAuth/oauth/token";
		MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
		paramsMap.add("client_id", "d6b2db030fce4ef4b64eb2d38031e2e2");
		paramsMap.add("client_secret", "bf5b58ee0bbe473dA221DE7AA9D175A0");
		paramsMap.add("grant_type", "client_credentials");
		Map<String, String> headersMap = new HashMap<>();
		headersMap.put("x", "x");
		String clientCredAccessToken = getValueFromGetApiCall(url, paramsMap, headersMap, "access_token");

		
		
		// Step2
		
		// Step3
		
		
		// Step4
		String code = "9OsCQH";
		String url4 = "https://psd2.apiboidev.com/openbanking-nOAuth/oauth/token";
		MultiValueMap<String, String> params4Map = new LinkedMultiValueMap<>();
		params4Map.add("code", code);
		params4Map.add("state", "8768767");
		params4Map.add("scope", "accounts");
		params4Map.add("grant_type", "authorization_code");
		params4Map.add("client_id", "6443e15975554bce8099e35b88b40465");
		params4Map.add("client_secret", "7ca382cf4dff4d2dBCF034DBBA34A653");
		params4Map.add("redirect_uri", "https://www.getpostman.com/oauth2/callback");
		Map<String, String> headers4Map = new HashMap<>();
		headers4Map.put("x", "x");
		String apiAccessToken = getValueFromGetApiCall(url4, params4Map, headers4Map, "access_token");
		System.out.println("Final Api Token is : " + apiAccessToken);
		System.exit(0);
	}

	static String getValueFromGetApiCall(String url, MultiValueMap<String, String> queryParams,
			Map<String, String> queryHeaders, String requiredValue) throws IOException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParams(queryParams);
		UriComponents finalUri = builder.build();
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAll(queryHeaders);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> x = rt.exchange(finalUri.toUri(), HttpMethod.GET, entity, Object.class);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(x.getBody());
		JsonNode rootNode = mapper.readTree(jsonString);
		JsonNode requiredNode = rootNode.path(requiredValue);
		return requiredNode.textValue();
	}
}
