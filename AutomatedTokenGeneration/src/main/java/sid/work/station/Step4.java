package sid.work.station;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Step4 {

	public static String step4(String code) throws IOException {
		// Step4
		//String code = "9OsCQH";
		String url4 = Constants.STEP4_URL;
		MultiValueMap<String, String> params4Map = new LinkedMultiValueMap<>();
		params4Map.add("code", code);
		params4Map.add("state", Constants.STEP4_STATE);
		params4Map.add("scope", Constants.STEP4_SCOPE);
		params4Map.add("grant_type", Constants.STEP4_GRANT_TYPE);
		params4Map.add("client_id", Constants.STEP4_CLIENT_ID);
		params4Map.add("client_secret", Constants.STEP4_CLIENT_SECRET);
		params4Map.add("redirect_uri", Constants.STEP4_REDIRECT_URI);
		Map<String, String> headers4Map = new HashMap<>();
		String apiAccessToken = Step1.getValueFromGetApiCall(url4, params4Map, headers4Map, "access_token");
		return "Bearer "+apiAccessToken;
	}
}
