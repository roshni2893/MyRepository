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

public class Step1 {

	public static String step1() throws IOException {
		String url = "https://psd2.apiboidev.com/openbanking-nOAuth/oauth/token";
		MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
		paramsMap.add("client_id", "d6b2db030fce4ef4b64eb2d38031e2e2");
		paramsMap.add("client_secret", "bf5b58ee0bbe473dA221DE7AA9D175A0");
		paramsMap.add("grant_type", "client_credentials");
		Map<String, String> headersMap = new HashMap<>();
		headersMap.put("x", "x");
		String clientCredAccessToken = getValueFromGetApiCall(url, paramsMap, headersMap, "access_token");
		return clientCredAccessToken;
	}
	
	static String getValueFromGetApiCall(String url, MultiValueMap<String, String> queryParamsMap,
			Map<String, String> queryHeaders, String requiredValue) throws IOException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParams(queryParamsMap);
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
