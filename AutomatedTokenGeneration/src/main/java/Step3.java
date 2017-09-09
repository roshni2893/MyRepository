import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Step3 {
	public static String step3(String accounRequestId) {

		String url = "https://psd2.apiboidev.com/openbanking-nOAuth/oauth/authorize";
		MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
		paramsMap.add("grant_type", "authorization_code");
		paramsMap.add("client_id", "6443e15975554bce8099e35b88b40465");
		paramsMap.add("brandId", "ROI");
		paramsMap.add("scope", "accounts");
		paramsMap.add("AccountRequestId", accounRequestId);
		paramsMap.add("redirect_uri", "https://www.getpostman.com/oauth2/callback");
		paramsMap.add("response_type", "code");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParams(paramsMap);
		UriComponents finalUri = builder.build();
		System.out.println("step 3 final uri is: " + finalUri);

		// 1) Url HIT
		// 2) Click on Login Button
		// 3) Enter "BOI888" in Username field
		// 4) Enter "8888" in OTP field
		// 5) Click on Login Button
		// 6) Click on "select all" checkbox
		// 7) Click on continue Button
		// 8) Click on "I consent" checkbox
		// 9) Click on confirm Button
		// 10) Store the Page URL.

		String pageURL = "https://app.getpostman.com/oauth2/callback?code=4sgTt2";
		String code = pageURL.split("code=")[1];
		return code;
	}
}