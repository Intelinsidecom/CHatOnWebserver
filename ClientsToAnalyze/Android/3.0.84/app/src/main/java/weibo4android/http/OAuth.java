package weibo4android.http;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import weibo4android.Configuration;

/* loaded from: classes.dex */
public class OAuth implements Serializable {
    private static final String HMAC_SHA1 = "HmacSHA1";
    static final long serialVersionUID = -4368426677157998618L;
    private String consumerKey = "";
    private String consumerSecret;
    private static final PostParameter OAUTH_SIGNATURE_METHOD = new PostParameter("oauth_signature_method", "HMAC-SHA1");
    private static final boolean DEBUG = Configuration.getDebug();
    private static Random RAND = new Random();

    public OAuth(String str, String str2) {
        setConsumerKey(str);
        setConsumerSecret(str2);
    }

    String generateAuthorizationHeader(String str, String str2, PostParameter[] postParameterArr, String str3, String str4, OAuthToken oAuthToken) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        if (postParameterArr == null) {
            postParameterArr = new PostParameter[0];
        }
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new PostParameter("oauth_consumer_key", this.consumerKey));
        arrayList.add(OAUTH_SIGNATURE_METHOD);
        arrayList.add(new PostParameter("oauth_timestamp", str4));
        arrayList.add(new PostParameter("oauth_nonce", str3));
        arrayList.add(new PostParameter("oauth_version", "1.0"));
        if (oAuthToken != null) {
            arrayList.add(new PostParameter("oauth_token", oAuthToken.getToken()));
        }
        List<PostParameter> arrayList2 = new ArrayList<>(arrayList.size() + postParameterArr.length);
        arrayList2.addAll(arrayList);
        arrayList2.addAll(toParamList(postParameterArr));
        parseGetParameters(str2, arrayList2);
        StringBuffer stringBufferAppend = new StringBuffer(str).append("&").append(encode(constructRequestURL(str2))).append("&");
        stringBufferAppend.append(encode(normalizeRequestParameters(arrayList2)));
        String string = stringBufferAppend.toString();
        log("OAuth base string:", string);
        String strGenerateSignature = generateSignature(string, oAuthToken);
        log("OAuth signature:", strGenerateSignature);
        arrayList.add(new PostParameter("oauth_signature", strGenerateSignature));
        return "OAuth " + encodeParameters(arrayList, ",", true);
    }

    private void parseGetParameters(String str, List<PostParameter> list) {
        int iIndexOf = str.indexOf("?");
        if (-1 != iIndexOf) {
            try {
                for (String str2 : str.substring(iIndexOf + 1).split("&")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length == 2) {
                        list.add(new PostParameter(URLDecoder.decode(strArrSplit[0], "UTF-8"), URLDecoder.decode(strArrSplit[1], "UTF-8")));
                    } else {
                        list.add(new PostParameter(URLDecoder.decode(strArrSplit[0], "UTF-8"), ""));
                    }
                }
            } catch (UnsupportedEncodingException e) {
            }
        }
    }

    String generateAuthorizationHeader(String str, String str2, PostParameter[] postParameterArr, OAuthToken oAuthToken) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        return generateAuthorizationHeader(str, str2, postParameterArr, String.valueOf(RAND.nextInt() + jCurrentTimeMillis), String.valueOf(jCurrentTimeMillis), oAuthToken);
    }

    String generateSignature(String str, OAuthToken oAuthToken) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec;
        byte[] bArrDoFinal = null;
        try {
            Mac mac = Mac.getInstance(HMAC_SHA1);
            if (oAuthToken == null) {
                secretKeySpec = new SecretKeySpec((encode(this.consumerSecret) + "&").getBytes(), HMAC_SHA1);
            } else {
                if (oAuthToken.getSecretKeySpec() == null) {
                    oAuthToken.setSecretKeySpec(new SecretKeySpec((encode(this.consumerSecret) + "&" + encode(oAuthToken.getTokenSecret())).getBytes(), HMAC_SHA1));
                }
                secretKeySpec = oAuthToken.getSecretKeySpec();
            }
            mac.init(secretKeySpec);
            bArrDoFinal = mac.doFinal(str.getBytes());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
        }
        return new BASE64Encoder().encode(bArrDoFinal);
    }

    String generateSignature(String str) {
        return generateSignature(str, null);
    }

    public static String normalizeRequestParameters(PostParameter[] postParameterArr) {
        return normalizeRequestParameters(toParamList(postParameterArr));
    }

    public static String normalizeRequestParameters(List<PostParameter> list) {
        Collections.sort(list);
        return encodeParameters(list);
    }

    public static String normalizeAuthorizationHeaders(List<PostParameter> list) {
        Collections.sort(list);
        return encodeParameters(list);
    }

    public static List<PostParameter> toParamList(PostParameter[] postParameterArr) {
        ArrayList arrayList = new ArrayList(postParameterArr.length);
        arrayList.addAll(Arrays.asList(postParameterArr));
        return arrayList;
    }

    public static String encodeParameters(List<PostParameter> list) {
        return encodeParameters(list, "&", false);
    }

    public static String encodeParameters(List<PostParameter> list, String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        for (PostParameter postParameter : list) {
            if (stringBuffer.length() != 0) {
                if (z) {
                    stringBuffer.append("\"");
                }
                stringBuffer.append(str);
            }
            stringBuffer.append(encode(postParameter.name)).append("=");
            if (z) {
                stringBuffer.append("\"");
            }
            stringBuffer.append(encode(postParameter.value));
        }
        if (stringBuffer.length() != 0 && z) {
            stringBuffer.append("\"");
        }
        return stringBuffer.toString();
    }

    public static String encode(String str) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        StringBuffer stringBuffer = new StringBuffer(strEncode.length());
        int i = 0;
        while (i < strEncode.length()) {
            char cCharAt = strEncode.charAt(i);
            if (cCharAt == '*') {
                stringBuffer.append("%2A");
            } else if (cCharAt == '+') {
                stringBuffer.append("%20");
            } else if (cCharAt == '%' && i + 1 < strEncode.length() && strEncode.charAt(i + 1) == '7' && strEncode.charAt(i + 2) == 'E') {
                stringBuffer.append('~');
                i += 2;
            } else {
                stringBuffer.append(cCharAt);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static String constructRequestURL(String str) {
        int iIndexOf = str.indexOf("?");
        if (-1 != iIndexOf) {
            str = str.substring(0, iIndexOf);
        }
        int iIndexOf2 = str.indexOf("/", 8);
        String lowerCase = str.substring(0, iIndexOf2).toLowerCase();
        int iIndexOf3 = lowerCase.indexOf(":", 8);
        if (-1 != iIndexOf3) {
            if (lowerCase.startsWith("http://") && lowerCase.endsWith(":80")) {
                lowerCase = lowerCase.substring(0, iIndexOf3);
            } else if (lowerCase.startsWith("https://") && lowerCase.endsWith(":443")) {
                lowerCase = lowerCase.substring(0, iIndexOf3);
            }
        }
        return lowerCase + str.substring(iIndexOf2);
    }

    public void setConsumerKey(String str) {
        if (str == null) {
            str = "";
        }
        this.consumerKey = str;
    }

    public void setConsumerSecret(String str) {
        if (str == null) {
            str = "";
        }
        this.consumerSecret = str;
    }

    private void log(String str) {
        if (DEBUG) {
            System.out.println("[" + new Date() + "]" + str);
        }
    }

    private void log(String str, String str2) {
        if (DEBUG) {
            log(str + str2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OAuth)) {
            return false;
        }
        OAuth oAuth = (OAuth) obj;
        if (this.consumerKey == null ? oAuth.consumerKey != null : !this.consumerKey.equals(oAuth.consumerKey)) {
            return false;
        }
        if (this.consumerSecret != null) {
            if (this.consumerSecret.equals(oAuth.consumerSecret)) {
                return true;
            }
        } else if (oAuth.consumerSecret == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.consumerKey != null ? this.consumerKey.hashCode() : 0) * 31) + (this.consumerSecret != null ? this.consumerSecret.hashCode() : 0);
    }

    public String toString() {
        return "OAuth{consumerKey='" + this.consumerKey + "', consumerSecret='" + this.consumerSecret + "'}";
    }
}
