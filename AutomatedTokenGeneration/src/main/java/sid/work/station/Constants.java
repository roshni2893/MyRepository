package sid.work.station;
public class Constants {

// Step1 properties...
public static final String STEP1_URL = "https://psd2.apiboitest.com/openbanking-nOAuth/oauth/token";
public static final String STEP1_CLIENT_ID = "6795ee9ca8e3407694f866725303db37";//"d6b2db030fce4ef4b64eb2d38031e2e2";//"6795ee9ca8e3407694f866725303db37";//
public static final String STEP1_CLIENT_SECRET = "bb169ffbe5c44a40B9AC1CA5A2720FA8";//"bf5b58ee0bbe473dA221DE7AA9D175A0";//"bb169ffbe5c44a40B9AC1CA5A2720FA8";//
public static final String STEP1_GRANT_TYPE = "client_credentials";
public static final String STEP1_SCOPE = "accounts";

// Step2 properties...
public static final String STEP2_URL = "https://psd2.apiboidev.com/1/api/open-banking/v1.0/account-requests";
public static final String STEP2_CLIENT_ID = "6795ee9ca8e3407694f866725303db37";//"6443e15975554bce8099e35b88b40465";//"6795ee9ca8e3407694f866725303db37";//
public static final String STEP2_CLIENT_SECRET = "bb169ffbe5c44a40B9AC1CA5A2720FA8";//"7ca382cf4dff4d2dBCF034DBBA34A653";//"bb169ffbe5c44a40B9AC1CA5A2720FA8";//
public static final String STEP2_X_FAPI = "1234";

// Step3 properties...
public static final String STEP3_URL = "https://psd2.apiboidev.com/openbanking-nOAuth/oauth/authorize";
public static final String STEP3_CLIENT_ID = "6443e15975554bce8099e35b88b40465";//"6795ee9ca8e3407694f866725303db37";//
public static final String STEP3_SCOPE = "accounts";
public static final String STEP3_USERNAME = "88888888";//"PROEN002";
public static final String STEP3_OTP = "888888";
public static final String STEP3_GRANT_TYPE = "authorization_code";
public static final String STEP3_BRAND_ID = "ROI";
public static final String STEP3_REDIRECT_URI = "https://www.getpostman.com/oauth2/callback";
public static final String STEP3_RESPONSE_TYPE = "code";

// Step4 properties...
public static final String STEP4_URL = "https://psd2.apiboidev.com/openbanking-nOAuth/oauth/token";
public static final String STEP4_CLIENT_ID = "6443e15975554bce8099e35b88b40465";//"6795ee9ca8e3407694f866725303db37";//
public static final String STEP4_CLIENT_SECRET = "7ca382cf4dff4d2dBCF034DBBA34A653";//"bb169ffbe5c44a40B9AC1CA5A2720FA8";//
public static final String STEP4_SCOPE = "accounts";
public static final String STEP4_STATE = "8768767";
public static final String STEP4_GRANT_TYPE = "authorization_code";
public static final String STEP4_REDIRECT_URI = "https://www.getpostman.com/oauth2/callback";

// Others...
public static final String CHROME_WEB_DRIVE_PATH = "D:\\selenium\\chromedriver.exe";
}
