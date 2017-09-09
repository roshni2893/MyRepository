import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Step3 {

	public static String step3(String accounRequestId) {
		
		String url="https://psd2.apiboidev.com/openbanking-nOAuth/oauth/authorize";
		MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
		paramsMap.add("grant_type","authorization_code");
		paramsMap.add("client_id", "6443e15975554bce8099e35b88b40465");
		paramsMap.add("brandId","ROI");
		paramsMap.add("AccountRequestId",accounRequestId);
		paramsMap.add("redirect_uri", "https://www.getpostman.com/oauth2/callback");
		paramsMap.add("response_type","code");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParams(paramsMap);
		UriComponents finalUri = builder.build();
		System.out.println("step 3 final uri is: "+finalUri);
		
		
		return null;
		
		
		// https://psd2.apiboidev.com/openbanking-nOAuth/oauth/authorize?
//		grant_type=authorization_code&
//				client_id=6443e15975554bce8099e35b88b40465&scope=accounts&
//				brandId=ROI&
//				AccountRequestId=da36080f-7377-410f-97f2-f05ca03f179a&
//				redirect_uri=https://www.getpostman.com/oauth2/callback&
//				response_type=code
	}

}
