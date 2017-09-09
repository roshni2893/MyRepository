import java.io.IOException;

public class Automation {
	public static void main(String[] args) throws IOException {
		// Step1
		String clientCredAccessToken = Step1.step1();

		// Step2
		String accounRequestId = Step2.step2(clientCredAccessToken);

		// Step3
		String code = Step3.step3(accounRequestId);

		// Step4
		String apiToken = Step4.step4(code);

		System.out.println("Bingo !!! FInal Token is: "+apiToken);
		System.exit(0);
	}

}
