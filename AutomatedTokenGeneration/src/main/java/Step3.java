import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Step3 {
	public static String step3(String accounRequestId) throws InterruptedException {

		String url = Constants.STEP3_URL;
		MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
		paramsMap.add("grant_type", Constants.STEP3_GRANT_TYPE);
		paramsMap.add("client_id", Constants.STEP3_CLIENT_ID);
		paramsMap.add("brandId", Constants.STEP3_BRAND_ID);
		paramsMap.add("scope", Constants.STEP3_SCOPE);
		paramsMap.add("AccountRequestId", accounRequestId);
		paramsMap.add("redirect_uri", Constants.STEP3_REDIRECT_URI);
		paramsMap.add("response_type", Constants.STEP3_RESPONSE_TYPE);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParams(paramsMap);
		UriComponents finalUri = builder.build();
		System.out.println("url is: " + finalUri);

		// loading web driver for chrome and setting its path
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_WEB_DRIVE_PATH);
		WebDriver driver = new ChromeDriver();

		// 1) Url HIT
		driver.get(finalUri.toString());
		Thread.sleep(3000);
		// 2) Click on Login Button
		driver.findElement(By.className("btn-primary")).click();
		Thread.sleep(3000);
		// Login Page
		// 3) Enter "BOI888" in Username field
		WebElement xx = driver.findElement(By.id("username"));
		xx.sendKeys(Constants.STEP3_USERNAME);
		Thread.sleep(1000);
		// 4) Enter "8888" in OTP field
		WebElement pwd = driver.findElement(By.id("OTP"));
		pwd.sendKeys(Constants.STEP3_OTP);
		Thread.sleep(1000);
		// 5) Click on Login Button
		WebElement loginButton = driver.findElement(By.id("submitLogin"));
		loginButton.click();
		Thread.sleep(3000);
		// Conent Page
		// 6) Click on "select all" checkbox
		WebElement checkBox = driver.findElement(By.id("checkall"));
		checkBox.click();
		Thread.sleep(3000);
		// 7) Click on continue Button
		WebElement contButton = driver.findElement(By.className("btn-primary"));
		contButton.click();
		Thread.sleep(3000);
		// 8) Click on "I consent" checkbox
		WebElement consentChkBox = driver.findElement(By.id("accpt_cond"));
		consentChkBox.click();
		Thread.sleep(1000);
		// 9) Click on confirm Button
		WebElement finalContButton = driver.findElement(By.className("btn-primary"));
		finalContButton.click();
		Thread.sleep(3000);
		// 10) Store the Page URL.
		String pageURL = driver.getCurrentUrl();
		String code = pageURL.split("code=")[1];
		System.out.println("code is: " + code);
		driver.close();
		return code;
	}
}