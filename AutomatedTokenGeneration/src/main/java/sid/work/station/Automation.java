package sid.work.station;
import java.io.IOException;

public class Automation {
	public static void main(String[] args) throws IOException, InterruptedException {
		long startTime = System.currentTimeMillis();
		// Step1
		String clientCredAccessToken = Step1.step1();

		// Step2
		// String clientCredAccessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiY29uc2VudHMiLCJhY2NvdW50cyJdLCJ0cHBJbmZvcm1hdGlvbiI6eyJ0cHBMZWdhbEVudGl0eU5hbWUiOiJNb25leXdpc2UuY29tIiwidHBwUmVnaXN0ZXJlZElkIjoiMTIzNDU3MCIsInRwcFJvbGVzIjpbIklOVEVSTkFMLUFMTCJdfSwiZXhwIjoxNTIwNTA3MzU2LCJhdXRob3JpdGllcyI6WyJJTlRFUk5BTC1BTEwiXSwianRpIjoiNTUzNTg5M2UtMjAxYi00YzJhLThhYjMtMGNiYzM5YmViNTRiIiwiY2xpZW50X2lkIjoiZDZiMmRiMDMwZmNlNGVmNGI2NGViMmQzODAzMWUyZTIifQ.t6R1EGErpgKTDQrKP70DgvOx3pxPO79NiDWBzRiWgt4Ujof4qjfUnhKd-6og5tAzQThA5fJtn13UUoEb79V1UGpKzSGDhrW5EcMUd7YOw-Aa1EIsweo-wq2CTOTkAciW50TqKxaK1BctqTSgcICbiy0zWSxRP7AxUUyfti5uw82leSs06peIfx-3PkpbQzzGn1IBVrjXYGU40GmwLpPMUMgPCip0_x_JoxLKd2cK1UhDLG8FUu5_nABVnbpMJZr_8t2equNFW4cl9OkpS8m4CxbYQ7hqibPVTDcVCx0zuNjCWcA0Sad4WSD3HwvJzrMfl7QkG2rPtXQQZLbi31YgMw";
		String accounRequestId = Step2.step2(clientCredAccessToken);

		// Step3
		// String accounRequestId="abc";
		String code = Step3.step3(accounRequestId);

		// Step4
		// String code = "3rsh2O";
		String apiToken = Step4.step4(code);

		long endTime = System.currentTimeMillis();
		System.out.println("Bingo !!! FInal Api Token is: ");
		System.out.println("---------------------------------");
		System.out.println(apiToken);
		System.out.println("---------------------------------");
		double timeTaken = (endTime - startTime) / 1000.0;
		System.out.println("Time taken " + timeTaken + "Seconds");
		System.out.println("Thank me later :)");
		System.exit(0);
	}
}
