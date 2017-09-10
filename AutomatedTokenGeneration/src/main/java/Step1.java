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
		String url = Constants.STEP1_URL;
		MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
		paramsMap.add("client_id", Constants.STEP1_CLIENT_ID);
		paramsMap.add("client_secret", Constants.STEP1_CLIENT_SECRET);
		paramsMap.add("grant_type", Constants.STEP1_GRANT_TYPE);
		Map<String, String> headersMap = new HashMap<>();
		String clientCredAccessToken = getValueFromGetApiCall(url, paramsMap, headersMap, "access_token");
		return clientCredAccessToken;
	}
	
	static String getValueFromGetApiCall(String url, MultiValueMap<String, String> queryParamsMap,
			Map<String, String> queryHeaders, String requiredValue) throws IOException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParams(queryParamsMap);
		UriComponents finalUri = builder.build();
		System.out.println("url is: "+finalUri);
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
