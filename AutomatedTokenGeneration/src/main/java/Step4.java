import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Step4 {

	public static String step4(String code) throws IOException {
		
		// Step4
		//String code = "9OsCQH";
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
		String apiAccessToken = Step1.getValueFromGetApiCall(url4, params4Map, headers4Map, "access_token");
		System.out.println("Final Api Token is : " + apiAccessToken);

		
		return null;
	}

}
