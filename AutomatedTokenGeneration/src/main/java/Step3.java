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

		// loading web driver for chrome and setting its path
		System.setProperty("webdriver.chrome.driver", "E:\\workspaces\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// 1) Url HIT
		driver.get(finalUri.toString());
		Thread.sleep(2000);
		// 2) Click on Login Button
		driver.findElement(By.className("btn-primary")).click();
		Thread.sleep(2000);
		// 3) Enter "BOI888" in Username field
		WebElement xx = driver.findElement(By.id("username"));
		xx.sendKeys("BOI888");
		Thread.sleep(2000);

		// List<WebElement> x =
		// driver.findElements(By.className("ng-pristine"));
		// System.out.println(x);
		// driver.findElement(By.id("username")).sendKeys("BOI888");
		// driver.findElement(By.tagName("username")).sendKeys("BOI888");
		// driver.findElement(By.className("form-control")).sendKeys("BOI888");
		// 4) Enter "8888" in OTP field
		WebElement pwd = driver.findElement(By.id("OTP"));
		pwd.sendKeys("8888");
		Thread.sleep(2000);
		// 5) Click on Login Button
		WebElement loginButton = driver.findElement(By.id("submitLogin"));
		loginButton.click();
		Thread.sleep(2000);
		// 6) Click on "select all" checkbox
		WebElement checkBox = driver.findElement(By.id("checkall"));
		checkBox.click();
		Thread.sleep(2000);
		// 7) Click on continue Button
		WebElement contButton = driver.findElement(By.className("btn-primary"));
		contButton.click();
		Thread.sleep(2000);
		// 8) Click on "I consent" checkbox
		WebElement consentChkBox = driver.findElement(By.id("accpt_cond"));
		consentChkBox.click();
		Thread.sleep(2000);
		// 9) Click on confirm Button
		WebElement finalContButton = driver.findElement(By.className("btn-primary"));
		finalContButton.click();
		Thread.sleep(2000);
		// 10) Store the Page URL.
		String pageURL = driver.getCurrentUrl();
		String code = pageURL.split("code=")[1];
		System.out.println("code is: " + code);
		driver.close();
		return code;
	}
}