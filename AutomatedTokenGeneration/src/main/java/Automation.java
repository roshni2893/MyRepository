import java.io.IOException;

public class Automation {
	public static void main(String[] args) throws IOException, InterruptedException {
		// Step1
		 //String clientCredAccessToken = Step1.step1();

		//String clientCredAccessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiY29uc2VudHMiLCJhY2NvdW50cyJdLCJ0cHBJbmZvcm1hdGlvbiI6eyJ0cHBMZWdhbEVudGl0eU5hbWUiOiJNb25leXdpc2UuY29tIiwidHBwUmVnaXN0ZXJlZElkIjoiMTIzNDU3MCIsInRwcFJvbGVzIjpbIklOVEVSTkFMLUFMTCJdfSwiZXhwIjoxNTIwNTA3MzU2LCJhdXRob3JpdGllcyI6WyJJTlRFUk5BTC1BTEwiXSwianRpIjoiNTUzNTg5M2UtMjAxYi00YzJhLThhYjMtMGNiYzM5YmViNTRiIiwiY2xpZW50X2lkIjoiZDZiMmRiMDMwZmNlNGVmNGI2NGViMmQzODAzMWUyZTIifQ.t6R1EGErpgKTDQrKP70DgvOx3pxPO79NiDWBzRiWgt4Ujof4qjfUnhKd-6og5tAzQThA5fJtn13UUoEb79V1UGpKzSGDhrW5EcMUd7YOw-Aa1EIsweo-wq2CTOTkAciW50TqKxaK1BctqTSgcICbiy0zWSxRP7AxUUyfti5uw82leSs06peIfx-3PkpbQzzGn1IBVrjXYGU40GmwLpPMUMgPCip0_x_JoxLKd2cK1UhDLG8FUu5_nABVnbpMJZr_8t2equNFW4cl9OkpS8m4CxbYQ7hqibPVTDcVCx0zuNjCWcA0Sad4WSD3HwvJzrMfl7QkG2rPtXQQZLbi31YgMw";
		// Step2
		//String accounRequestId = Step2.step2(clientCredAccessToken);
		String accounRequestId="abc";
		// Step3
		String code = Step3.step3(accounRequestId);

		// Step4
		String apiToken = Step4.step4(code);

		System.out.println("Bingo !!! FInal Token is: "+apiToken);
		System.exit(0);
	}

}
