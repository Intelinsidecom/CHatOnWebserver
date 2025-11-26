package com.sec.voiceservice.translatelib;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.coolotsinterface.ChatONNativeCallLog;
import com.sds.coolots.call.model.Call;
import com.sds.coolots.login.p018a.C1268d;
import com.sec.spp.push.Config;
import com.sec.voiceservice.sentencebreaker.SentenceBreaker;
import com.sec.voiceservice.sentencebreaker.SentenceListener;
import com.vlingo.sdk.internal.http.HttpUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Translate {
    private static String Access_Token = null;
    private static String Broad_ErrorMessage = null;
    private static String Client_ID = null;
    private static String Contry_Name = null;
    private static String Expired_AccessToken = null;
    private static final String TAG = "TransLib";
    private static String URL_OPTION = null;
    private static String URL_UID = null;
    private static final int timeout = 30000;
    private static final int totalthread = 1;
    private static String url = null;
    private static final int urlLength = 9;
    private static String VersionName = null;
    private static String URL_SERVER = null;
    private static String URL_SERVER_2th = null;
    private static String AUTH_SERVER = "http://global-auth.translation.samsungosp.com";
    private static String AuthFilePath = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + "/Android/data/.translator.dat";
    private static String File_Key = "samsungsec";
    private static TransErrors ExcuteException = null;
    private static boolean isExecuting = false;
    private static boolean isCanceling = false;
    static String[][] translateResult = (String[][]) Array.newInstance((Class<?>) String.class, 2, 3);
    private static HttpClient[] httpclientThread = new DefaultHttpClient[2];
    private static Thread TransThread = null;
    private static int sentence_number = 0;
    private static int threshold = Call.HANGUP_REASON_SIP_LOCAL_ERROR_NOT_CONNECTED;
    private static long auth_time = 0;

    public static void setToken(String access_token, String client_id, String country3name, String error_Message) {
        Broad_ErrorMessage = error_Message;
        Access_Token = access_token;
        Client_ID = client_id;
        if (country3name != null) {
            Contry_Name = country3name.toUpperCase();
        } else {
            Contry_Name = "";
        }
    }

    public static boolean isCanceling() {
        return isCanceling;
    }

    public static boolean isExecuting() {
        return isExecuting;
    }

    public static boolean cancel() {
        if (isCanceling) {
            return false;
        }
        Log.e(TAG, "cancel start!!");
        isCanceling = true;
        for (int i = 0; i < 2; i++) {
            if (httpclientThread != null && httpclientThread[i] != null) {
                httpclientThread[i].getConnectionManager().shutdown();
            }
        }
        if (TransThread != null) {
            TransThread.interrupt();
            TransThread = null;
        }
        Log.e(TAG, "cancel end!!");
        return true;
    }

    private static String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = null;
        try {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(is, "UTF8"));
            reader = reader2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        try {
                            break;
                        } catch (IOException e2) {
                        }
                    } else {
                        sb.append(String.valueOf(line) + "\n");
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    try {
                        is.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } finally {
                try {
                    is.close();
                } catch (IOException e22) {
                    e22.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    private static void setURL(String tranSourceLang, String tranTargetLang, String cid, String option) throws Exception {
        String sid = "q4h11v8aq6";
        if (cid == null || cid.equals("") || cid.equals("0")) {
            cid = "Ng727U3NMO";
        } else if (cid.equals("phzjud4a45")) {
            sid = "phzjud4a45";
        }
        if (option == null || option.equals("") || option.equals("0")) {
            URL_OPTION = "1";
        } else {
            URL_OPTION = option;
        }
        String URL_EncodingLang = String.valueOf(tranSourceLang) + "/" + tranTargetLang;
        url = String.valueOf(URL_SERVER) + "stp/v1/text/translate?option=" + URL_OPTION + "&language=" + URLEncoder.encode(URL_EncodingLang, "UTF-8") + "&sid=" + sid + "&cid=" + cid + "&access_token=" + Access_Token + "&uid=" + URL_UID;
        if (Access_Token == null || Client_ID == null || URL_UID == null || URL_SERVER == null) {
            Log.e(TAG, "setURL parameter is null!!");
            ExcuteException = TransErrors.ERROR_Server;
            throw new Exception(ExcuteException.getDesc());
        }
        if (Access_Token.equals("") || Client_ID.equals("") || URL_UID.equals("") || URL_SERVER.equals("")) {
            Log.e(TAG, "setURL parameter is blank!!");
            ExcuteException = TransErrors.ERROR_Server;
            throw new Exception(ExcuteException.getDesc());
        }
        if (URL_SERVER.length() > 9) {
            Log.e(TAG, "URL_SERVER: " + URL_SERVER.substring(0, 9));
        }
        if (Access_Token.length() > 2) {
            Log.e(TAG, "Access_Token: " + Access_Token.substring(0, 2));
        }
    }

    public static String[] sentenceBreaker(String str, int thsd) throws Exception {
        final List<String> sentenceList = new ArrayList<>();
        try {
            sentence_number = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes("UTF8")), "UTF8"));
            StringBuilder builder = new StringBuilder();
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line).append('\n');
            }
            reader.close();
            SentenceBreaker sb = new SentenceBreaker();
            sb.setThreshold(thsd);
            sb.setSentenceListener(new SentenceListener() { // from class: com.sec.voiceservice.translatelib.Translate.1
                @Override // com.sec.voiceservice.sentencebreaker.SentenceListener
                public void onSentence(String value) {
                    sentenceList.add(value);
                    Translate.sentence_number++;
                }
            });
            sb.breakSentense(Locale.ENGLISH, builder.toString());
            String[] sentences = new String[sentence_number];
            for (int i = 0; i < sentence_number; i++) {
                sentences[i] = sentenceList.get(i);
            }
            return sentences;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception: " + e.getMessage());
            ExcuteException = TransErrors.ERROR_Sentence;
            throw new Exception(ExcuteException.getDesc());
        }
    }

    private static void checkAuthen() throws IOException {
        try {
            String before_Access_Token = Access_Token;
            String before_Client_ID = Client_ID;
            String before_URL_UID = URL_UID;
            String before_URL_SERVER = URL_SERVER;
            InputStreamReader filereader = new InputStreamReader(new FileInputStream(AuthFilePath), "UTF8");
            BufferedReader in = new BufferedReader(filereader);
            new String();
            String buf = in.readLine();
            if ((buf == null || buf.replace(" ", "").equals("")) && ((buf = in.readLine()) == null || buf.replace(" ", "").equals(""))) {
                in.close();
                return;
            }
            String file_accessToken = decryptData(File_Key, buf);
            String buf2 = in.readLine();
            if ((buf2 == null || buf2.replace(" ", "").equals("")) && ((buf2 = in.readLine()) == null || buf2.replace(" ", "").equals(""))) {
                in.close();
                return;
            }
            String file_clientId = decryptData(File_Key, buf2);
            String buf3 = in.readLine();
            if ((buf3 == null || buf3.replace(" ", "").equals("")) && ((buf3 = in.readLine()) == null || buf3.replace(" ", "").equals(""))) {
                in.close();
                return;
            }
            String file_uid = decryptData(File_Key, buf3);
            String buf4 = in.readLine();
            if ((buf4 == null || buf4.replace(" ", "").equals("")) && ((buf4 = in.readLine()) == null || buf4.replace(" ", "").equals(""))) {
                in.close();
                return;
            }
            String file_url = decryptData(File_Key, buf4);
            if (!before_Access_Token.equals(file_accessToken)) {
                Log.e(TAG, "Exception: Access_Token error");
            }
            if (!before_Client_ID.equals(file_clientId)) {
                Log.e(TAG, "Exception: Client_ID error");
            }
            if (!before_URL_UID.equals(file_uid)) {
                Log.e(TAG, "Exception: URL_UID error");
            }
            if (!before_URL_SERVER.equals(file_url)) {
                Log.e(TAG, "Exception: URL_SERVER error");
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkParameter(String tranSourceLang, String tranTargetLang, String cid, String option, Context context) {
        if (tranSourceLang == null || tranSourceLang.equals("")) {
            Log.e(TAG, "Source Language error!! - " + tranSourceLang);
            return false;
        }
        if (tranTargetLang == null || tranTargetLang.equals("")) {
            Log.e(TAG, "Target Language error!! - " + tranTargetLang);
            return false;
        }
        Log.e(TAG, "Source Language: " + tranSourceLang + ", Target Language: " + tranTargetLang + ", option: " + option);
        if (context == null) {
            Log.e(TAG, "Context error!!");
            return false;
        }
        return true;
    }

    public static String parsingPureTextFromHtml(String html) {
        htmlText mPureHtmlText = new htmlText();
        String text = mPureHtmlText.HTMLTextParsing(html, false);
        return text;
    }

    public static String[] executeBrowser(String[] transText, String tranSourceLang, String tranTargetLang, Context context) {
        String[] resultArray = null;
        String[] result = new String[3];
        result[0] = "";
        result[1] = "";
        Log.e(TAG, "executeBrowser start!");
        if (transText == null) {
            Log.e(TAG, "Text is null!!");
            return result;
        }
        try {
            String InputtransText = "";
            Log.e(TAG, "transText.length: " + transText.length);
            for (int i = 0; i < transText.length; i++) {
                Log.e(TAG, transText[i]);
                transText[i] = transText[i].replace("\n", " --\n");
                if (i == 0) {
                    InputtransText = String.valueOf(InputtransText) + transText[i];
                } else {
                    InputtransText = String.valueOf(InputtransText) + " --\n++ --\n" + transText[i];
                }
            }
            result = executeMain(InputtransText, tranSourceLang, tranTargetLang, "Pg6dOPTW6D", "3", context);
            result[0] = result[0].replace("  ", " ");
            result[0] = result[0].replace("--\n++--\n", "+--+");
            result[0] = result[0].replace("--\n++ --\n", "+--+");
            result[0] = result[0].replace("--\n++  --\n", "+--+");
            result[0] = result[0].replace("--\n", "\n");
            String[] tempArrary = result[0].split("\\+\\-\\-\\+");
            if (tempArrary != null) {
                Log.e(TAG, "tempArrary.length: " + tempArrary.length);
                resultArray = new String[tempArrary.length + 2];
                resultArray[0] = result[2];
                resultArray[1] = result[1];
                System.arraycopy(tempArrary, 0, resultArray, 2, tempArrary.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultArray == null) {
            resultArray = new String[]{result[2], result[1], ""};
        }
        Log.w(TAG, "executeBrowser end!");
        return resultArray;
    }

    public static String[] executeHTML(String transText, String tranSourceLang, String tranTargetLang, String cid, String option, Context context) {
        String[] result = new String[3];
        result[0] = "";
        result[1] = "";
        Log.e(TAG, "executeHTML start!");
        try {
            String transText2 = transText.replace("\r\n", "\n");
            htmlText mhtmlText = new htmlText();
            String InputtransText = mhtmlText.HTMLTextParsing(transText2, true);
            Log.w(TAG, transText2);
            result = executeMain(InputtransText, tranSourceLang, tranTargetLang, cid, option, context);
            result[0] = result[0].replace("  ", " ");
            result[0] = result[0].replace("--\n++--\n", "+--+");
            result[0] = result[0].replace("--\n++ --\n", "+--+");
            result[0] = result[0].replace("--\n", "\n");
            result[0] = mhtmlText.ReplaceHTMLSCtoCode(result[0]);
            String result_html = mhtmlText.ChangeOtoT(result[0]).replace("++", " ");
            result[0] = result_html;
            Log.w(TAG, result_html);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.w(TAG, "executeHTML end!");
        return result;
    }

    public static String[] execute(String transText, String tranSourceLang, String tranTargetLang, String cid, String option, Context context) {
        String[] result = new String[3];
        result[0] = "";
        result[1] = "";
        Log.w(TAG, "execute start!");
        try {
            result = executeMain(transText.replace("\n", " --\n"), tranSourceLang, tranTargetLang, cid, option, context);
            if (result[0] != null) {
                result[0] = result[0].replace("  ", " ");
                result[0] = result[0].replace("--\n", "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.w(TAG, "execute end!");
        return result;
    }

    private static String[] executeMain(String transText, String tranSourceLang, String tranTargetLang, String cid, String option, Context context) {
        VersionName = "1.1.97";
        Log.e(TAG, "Translate version : " + VersionName);
        String sentens_result = "";
        String[] result = new String[3];
        ExcuteException = null;
        Expired_AccessToken = null;
        isCanceling = false;
        try {
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception(executeMain): " + e.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Exception;
            }
        } finally {
            isExecuting = false;
        }
        if (!checkParameter(tranSourceLang, tranTargetLang, cid, option, context)) {
            ExcuteException = TransErrors.ERROR_Parameter;
            result[0] = "";
            result[1] = "";
            result[2] = ExcuteException.getCode();
            return result;
        }
        if (isExecuting) {
            Log.e(TAG, "Translator is executing!!");
            result[0] = "";
            result[1] = "";
            return result;
        }
        isExecuting = true;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        boolean ret = setAuthen(context, false);
        if (!ret) {
            Log.e(TAG, "setAuthen error");
            ExcuteException = null;
            boolean ret2 = setAuthen(context, true);
            if (!ret2) {
                if (ExcuteException == null) {
                    ExcuteException = TransErrors.ERROR_Authen;
                }
                throw new Exception(ExcuteException.getDesc());
            }
        }
        boolean isSentenceBreaking = false;
        String[] sentence_str = null;
        Log.e(TAG, "executeMain transText.length(): " + transText.length());
        if (transText != null && transText.length() > threshold) {
            Log.e(TAG, "sentenceBreaker start!!");
            isSentenceBreaking = true;
            sentence_str = sentenceBreaker(transText, threshold - 100);
        }
        try {
            setURL(tranSourceLang, tranTargetLang, cid, option);
            if (!isSentenceBreaking) {
                result = TransControll(transText);
                if (ExcuteException != null && URL_SERVER_2th != null) {
                    if (ExcuteException == TransErrors.ERROR_Network || ExcuteException == TransErrors.ERROR_Server) {
                        ExcuteException = null;
                        URL_SERVER = URL_SERVER_2th;
                        setURL(tranSourceLang, tranTargetLang, cid, option);
                        result = TransControll(transText);
                    } else if (ExcuteException == TransErrors.ERROR_BadToken) {
                        ExcuteException = null;
                        setAuthen(context, true);
                        setURL(tranSourceLang, tranTargetLang, cid, option);
                        result = TransControll(transText);
                    }
                }
            } else {
                if (sentence_str == null) {
                    Log.e(TAG, "sentence_str is null");
                    if (ExcuteException == null) {
                        ExcuteException = TransErrors.ERROR_Sentence;
                    }
                    throw new Exception(ExcuteException.getDesc());
                }
                for (int i = 0; i < sentence_str.length; i++) {
                    Log.e(TAG, "sentence_str.length: " + sentence_str.length);
                    transText = sentence_str[i];
                    result = TransControll(transText);
                    if (ExcuteException != null && URL_SERVER_2th != null) {
                        if (ExcuteException == TransErrors.ERROR_Network || ExcuteException == TransErrors.ERROR_Server) {
                            ExcuteException = null;
                            URL_SERVER = URL_SERVER_2th;
                            setURL(tranSourceLang, tranTargetLang, cid, option);
                            result = TransControll(transText);
                        } else if (ExcuteException == TransErrors.ERROR_BadToken) {
                            ExcuteException = null;
                            setAuthen(context, true);
                            setURL(tranSourceLang, tranTargetLang, cid, option);
                            result = TransControll(transText);
                        }
                    }
                    if (result == null) {
                        result = new String[3];
                    }
                    if (result[0] == null) {
                        result[0] = "";
                        result[1] = "";
                    }
                    sentens_result = String.valueOf(sentens_result) + result[0];
                    if (i == 0 && tranSourceLang.equals("unknown")) {
                        tranSourceLang = result[1];
                        setURL(tranSourceLang, tranTargetLang, cid, option);
                    }
                    if (ExcuteException != null) {
                        break;
                    }
                }
                result[0] = sentens_result;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (ExcuteException != null && ExcuteException == TransErrors.ERROR_Json) {
            checkAuthen();
            setAuthen(context, true);
        }
        if (result == null) {
            Log.e(TAG, "result is null!");
            result = new String[3];
        }
        if (result[0] == null) {
            Log.e(TAG, "result[0] is null!");
            result[0] = "";
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Exception;
            }
        }
        if (ExcuteException != null && !isCanceling) {
            Log.e(TAG, "Exception: " + ExcuteException.getDesc());
            result[2] = ExcuteException.getCode();
            String print_source_text = transText;
            int source_length = print_source_text.length();
            if (source_length > 1) {
                Log.e(TAG, "Source first: " + print_source_text.substring(0, source_length / 2));
                Log.e(TAG, "Source second: " + print_source_text.substring(source_length / 2) + "\n");
            }
            Access_Token = null;
        }
        isCanceling = false;
        return result;
    }

    private static String[] TransControll(String transText) throws InterruptedException {
        long endTime;
        String[] result = new String[3];
        ThreadCount threadCount = new ThreadCount();
        try {
            if (httpclientThread != null && httpclientThread[0] != null) {
                httpclientThread[0].getConnectionManager().shutdown();
            }
            httpclientThread[0] = new DefaultHttpClient();
            translateResult[0] = null;
            TransThread = new Thread(new TransRunnable(transText, threadCount, httpclientThread[0], 0));
            TransThread.start();
            long startTime = System.currentTimeMillis();
            while (threadCount.count > 0) {
                try {
                    Thread.sleep(50L);
                    endTime = System.currentTimeMillis();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (endTime - startTime > Config.CONNECTION_TIMEOUT) {
                    Log.e(TAG, "time out!!");
                    cancel();
                    ExcuteException = TransErrors.ERROR_Network;
                    isCanceling = false;
                    break;
                }
                if (isCanceling) {
                    break;
                }
            }
            String[] result2 = translateResult[0];
            return result2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return result;
        }
    }

    public static String[] TransExecute(String transText, HttpClient httpclient, boolean detectLang) throws IllegalStateException, JSONException, IOException {
        String json_text;
        String[] result = new String[3];
        if (transText == null || transText.equals("")) {
            Log.e(TAG, "Text is null");
            result[0] = "";
            result[1] = "";
            return result;
        }
        ArrayList<NameValuePair> headers = new ArrayList<>();
        if (URL_OPTION.equals("101")) {
            headers.add(new BasicNameValuePair("Accept", "application/json;text/xml"));
            headers.add(new BasicNameValuePair("Content-Type", "application/json;charset=UTF-8"));
        } else {
            String UserAgent = String.valueOf(Build.MODEL) + "; " + Build.DISPLAY + "; Translate=" + VersionName;
            headers.add(new BasicNameValuePair(HttpUtil.HEADER_USER_AGENT, UserAgent));
            headers.add(new BasicNameValuePair("Accept", "application/octet-stream,application/json"));
            headers.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        }
        try {
            HttpPost httppost = new HttpPost(url);
            Iterator<NameValuePair> it = headers.iterator();
            while (it.hasNext()) {
                NameValuePair h = it.next();
                httppost.addHeader(h.getName(), h.getValue());
            }
            JSONObject transjson = new JSONObject();
            transjson.put("source_text", transText);
            if (URL_OPTION.equals("101")) {
                StringEntity reqEntity = new StringEntity(transjson.toString(), "UTF-8");
                httppost.setEntity(reqEntity);
            } else {
                byte[] dataBytes = encryptData(Access_Token, transjson.toString());
                InputStream req = new ByteArrayInputStream(dataBytes);
                InputStreamEntity reqEntity2 = new InputStreamEntity(req, dataBytes.length);
                httppost.setEntity(reqEntity2);
            }
            Log.e(TAG, "Token: " + Access_Token.substring(0, 2));
            HttpParams timeflag = httpclient.getParams();
            HttpConnectionParams.setConnectionTimeout(timeflag, 10000);
            HttpConnectionParams.setSoTimeout(timeflag, 30000);
            Log.e(TAG, "execute start!");
            HttpResponse response = httpclient.execute(httppost);
            Log.e(TAG, "execute end!");
            Log.e(TAG, response.getStatusLine().toString());
            int responseCode = response.getStatusLine().getStatusCode();
            Log.e(TAG, "responseCode: " + responseCode);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                if (URL_OPTION.equals("101") || responseCode != 200) {
                    json_text = convertStreamToString(instream);
                } else {
                    json_text = decryptData(Access_Token, instream);
                }
                if (responseCode == 400 || responseCode == 404 || responseCode == 408 || responseCode == 500 || responseCode == 502) {
                    Log.e(TAG, json_text);
                    ExcuteException = TransErrors.ERROR_Server;
                }
                if (!json_text.equals("")) {
                    result = jsonParsing(json_text, detectLang);
                } else {
                    Log.e(TAG, "json_text is null : " + instream);
                    ExcuteException = TransErrors.ERROR_Exception;
                }
                instream.close();
            } else {
                Log.e(TAG, "Entity is null");
                if (ExcuteException == null) {
                    ExcuteException = TransErrors.ERROR_Exception;
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            Log.e(TAG, "ClientProtocolException:" + e.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Protocol;
            }
        } catch (IOException e2) {
            String print_url = URL_SERVER.replace("http://", "");
            Log.e(TAG, "IOException:" + e2.getMessage().replace(print_url.replace("/", ""), ""));
            if (e2.getMessage().matches(".*Connection to http.*") || e2.getMessage().matches(".*timed out.*")) {
                ExcuteException = TransErrors.ERROR_Server;
            } else if (e2.getMessage().matches(".*Unable to resolve host.*")) {
                ExcuteException = TransErrors.ERROR_Network;
            } else if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_IO;
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
            Log.e(TAG, "JSONException:" + e3.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Json;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.e(TAG, "Exception:" + e4.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Exception;
            }
        }
        httpclient.getConnectionManager().shutdown();
        return result;
    }

    private static String[] jsonParsing(String json_text, boolean detectLang) throws Exception {
        String[] result = new String[3];
        try {
            JSONObject json = new JSONObject(json_text);
            String rmsg = json.getString("rmsg");
            if (rmsg != null && rmsg.equals("Success")) {
                if (!detectLang) {
                    String source_text = json.getString("source_text");
                    String target_text = json.getString("target_text");
                    String result_lang = json.getString("language");
                    String source_lang = result_lang.split("/")[0];
                    Log.e(TAG, "[result_lang: " + result_lang + "]");
                    if (target_text != null) {
                        if (target_text.equals("")) {
                            result[0] = source_text;
                        } else {
                            result[0] = target_text;
                        }
                    }
                    result[1] = source_lang;
                    int source_length = source_text.length();
                    int target_length = target_text.length();
                    if (source_length > 1) {
                        Log.e(TAG, "Source first: " + source_text.substring(0, source_length / 2));
                        Log.e(TAG, "Source second: " + source_text.substring(source_length / 2) + "\n");
                    }
                    if (target_length > 1) {
                        Log.e(TAG, "Target first: " + target_text.substring(0, target_length / 2));
                        Log.e(TAG, "Target second: " + target_text.substring(target_length / 2) + "\n");
                    }
                } else {
                    JSONArray valArray = new JSONArray(json.getString("detections"));
                    result = new String[valArray.length()];
                    for (int i = 0; i < valArray.length(); i++) {
                        result[i] = valArray.getJSONObject(i).getString("language");
                        Log.e(TAG, result[i]);
                    }
                }
            } else {
                Log.e(TAG, "[rmsg: " + rmsg + "]");
                String rcode = json.getString("rcode");
                if (rcode != null && rcode.equals("19008")) {
                    Log.e(TAG, "Bad access token - rcode: " + rcode);
                    Expired_AccessToken = Access_Token;
                    ExcuteException = TransErrors.ERROR_BadToken;
                } else if (rcode != null && rcode.equals("19031")) {
                    Log.e(TAG, "The selected language is not supported");
                    ExcuteException = TransErrors.ERROR_Language;
                    String source_lang2 = rmsg.split("/")[0];
                    if (source_lang2 != null) {
                        source_lang2 = source_lang2.substring(1);
                    }
                    result[0] = "";
                    result[1] = source_lang2;
                } else {
                    ExcuteException = TransErrors.ERROR_Server;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "JSONException:" + e.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Json;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e(TAG, "Exception:" + e2.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Exception;
            }
        }
        return result;
    }

    private static byte[] encryptData(String key, String data) throws Exception {
        try {
            byte[] keyData = key.getBytes("UTF-8");
            KeySpec keySpec = new DESKeySpec(keyData);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secret_key = secretKeyFactory.generateSecret(keySpec);
            Cipher encrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
            encrypt.init(1, secret_key);
            byte[] inputByte = data.getBytes("UTF-8");
            byte[] outputByte = encrypt.doFinal(inputByte);
            return outputByte;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private static String decryptData(String key, InputStream instream) throws Exception {
        try {
            byte[] keyData = Access_Token.getBytes("UTF-8");
            KeySpec keySpec = new DESKeySpec(keyData);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secret_key = secretKeyFactory.generateSecret(keySpec);
            Cipher decrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
            decrypt.init(2, secret_key);
            CipherInputStream cos = new CipherInputStream(instream, decrypt);
            String outputText = convertStreamToString(cos);
            return outputText;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private static String decryptData(String key, String dataString) throws Exception {
        try {
            byte[] keyData = key.getBytes("UTF-8");
            KeySpec keySpec = new DESKeySpec(keyData);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secret_key = secretKeyFactory.generateSecret(keySpec);
            Cipher decrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
            decrypt.init(2, secret_key);
            byte[] inputByte = Base64.decode(dataString, 0);
            byte[] outputByte = decrypt.doFinal(inputByte);
            String outputText = new String(outputByte);
            return outputText;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private static boolean FileAuthenWrite() throws IOException {
        BufferedWriter out;
        BufferedWriter out2 = null;
        try {
            File file = new File(AuthFilePath);
            if (file.exists()) {
                boolean ret = file.delete();
                Log.e(TAG, "file.delete: " + ret);
            }
            OutputStreamWriter filewriter = new OutputStreamWriter(new FileOutputStream(AuthFilePath), "UTF8");
            out = new BufferedWriter(filewriter);
        } catch (Exception e) {
            e = e;
        }
        try {
            byte[] dataBytes = encryptData(File_Key, Access_Token);
            String dataString = Base64.encodeToString(dataBytes, 0);
            out.write(dataString, 0, dataString.length());
            out.newLine();
            out.flush();
            byte[] dataBytes2 = encryptData(File_Key, Client_ID);
            String dataString2 = Base64.encodeToString(dataBytes2, 0);
            out.write(dataString2, 0, dataString2.length());
            out.newLine();
            out.flush();
            byte[] dataBytes3 = encryptData(File_Key, URL_UID);
            String dataString3 = Base64.encodeToString(dataBytes3, 0);
            out.write(dataString3, 0, dataString3.length());
            out.newLine();
            out.flush();
            byte[] dataBytes4 = encryptData(File_Key, URL_SERVER);
            String dataString4 = Base64.encodeToString(dataBytes4, 0);
            out.write(dataString4, 0, dataString4.length());
            out.newLine();
            out.flush();
            byte[] dataBytes5 = encryptData(File_Key, URL_SERVER_2th);
            String dataString5 = Base64.encodeToString(dataBytes5, 0);
            out.write(dataString5, 0, dataString5.length());
            out.newLine();
            out.newLine();
            out.flush();
            out.close();
            return true;
        } catch (Exception e2) {
            e = e2;
            out2 = out;
            e.printStackTrace();
            Log.e(TAG, "Exception: " + e.getMessage());
            try {
                out2.close();
                return false;
            } catch (Exception e3) {
                return false;
            }
        }
    }

    private static boolean FileAuthenRead() throws IOException {
        boolean z;
        BufferedReader in = null;
        try {
            if (Access_Token != null && Client_ID != null && URL_UID != null && URL_SERVER != null) {
                Log.e(TAG, "There exist datas!!");
                z = true;
            } else {
                InputStreamReader filereader = new InputStreamReader(new FileInputStream(AuthFilePath), "UTF8");
                BufferedReader in2 = new BufferedReader(filereader);
                try {
                    new String();
                    String buf = in2.readLine();
                    if ((buf == null || buf.replace(" ", "").equals("")) && ((buf = in2.readLine()) == null || buf.replace(" ", "").equals(""))) {
                        in2.close();
                        z = false;
                    } else {
                        String file_accessToken = decryptData(File_Key, buf);
                        String buf2 = in2.readLine();
                        if ((buf2 == null || buf2.replace(" ", "").equals("")) && ((buf2 = in2.readLine()) == null || buf2.replace(" ", "").equals(""))) {
                            in2.close();
                            z = false;
                        } else {
                            String file_clientId = decryptData(File_Key, buf2);
                            String buf3 = in2.readLine();
                            if ((buf3 == null || buf3.replace(" ", "").equals("")) && ((buf3 = in2.readLine()) == null || buf3.replace(" ", "").equals(""))) {
                                in2.close();
                                z = false;
                            } else {
                                String file_uid = decryptData(File_Key, buf3);
                                String buf4 = in2.readLine();
                                if ((buf4 == null || buf4.replace(" ", "").equals("")) && ((buf4 = in2.readLine()) == null || buf4.replace(" ", "").equals(""))) {
                                    in2.close();
                                    z = false;
                                } else {
                                    String file_url = decryptData(File_Key, buf4);
                                    String buf5 = in2.readLine();
                                    if ((buf5 == null || buf5.replace(" ", "").equals("")) && ((buf5 = in2.readLine()) == null || buf5.replace(" ", "").equals(""))) {
                                        in2.close();
                                        z = false;
                                    } else {
                                        String file_url_2th = decryptData(File_Key, buf5);
                                        Access_Token = file_accessToken;
                                        Client_ID = file_clientId;
                                        URL_UID = file_uid;
                                        URL_SERVER = file_url;
                                        URL_SERVER_2th = file_url_2th;
                                        in2.close();
                                        if (Access_Token == null || Access_Token.length() < 10) {
                                            Log.e(TAG, "file token error: " + Access_Token);
                                            z = false;
                                        } else if (Client_ID == null || Client_ID.length() < 10) {
                                            Log.e(TAG, "file cid error: " + Client_ID);
                                            z = false;
                                        } else if (URL_UID == null || URL_UID.length() < 10) {
                                            Log.e(TAG, "file uid error: " + URL_UID);
                                            z = false;
                                        } else if (URL_SERVER == null || URL_SERVER.length() < 15) {
                                            Log.e(TAG, "file server error: " + URL_SERVER);
                                            z = false;
                                        } else {
                                            if (URL_SERVER_2th == null || URL_SERVER_2th.length() < 15) {
                                                Log.e(TAG, "file server2 error: " + URL_SERVER);
                                            }
                                            if (URL_SERVER.length() > 9) {
                                                Log.e(TAG, "primary: " + URL_SERVER.substring(0, 9));
                                            }
                                            if (URL_SERVER_2th.length() > 9) {
                                                Log.e(TAG, "secondary: " + URL_SERVER_2th.substring(0, 9));
                                            }
                                            z = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    in = in2;
                    Log.e(TAG, "FileAuthenRead fail!!");
                    try {
                        in.close();
                    } catch (Exception e2) {
                    }
                    return false;
                }
            }
            return z;
        } catch (Exception e3) {
        }
    }

    public static boolean checkNetwork(Context context) {
        int[] networkTypeArray = {0, 1, 6};
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService("connectivity");
        for (int i : networkTypeArray) {
            NetworkInfo info = connManager.getNetworkInfo(i);
            if (info != null && info.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSamsungAccount(Context context) {
        AccountManager manager = AccountManager.get(context);
        Account[] accountArr = manager.getAccountsByType(VAppPhoneManager.SAMSUNGACCOUNT_TYPESTRING);
        if (accountArr.length > 0) {
            return true;
        }
        Intent intent = new Intent("android.settings.ADD_ACCOUNT_SETTINGS");
        intent.putExtra("account_types", new String[]{VAppPhoneManager.SAMSUNGACCOUNT_TYPESTRING});
        intent.setFlags(276824064);
        context.startActivity(intent);
        return false;
    }

    public static boolean setAuthen(Context context, boolean forceAuthen) throws Exception {
        AccountManager manager = AccountManager.get(context);
        Account[] accountArr = manager.getAccountsByType(VAppPhoneManager.SAMSUNGACCOUNT_TYPESTRING);
        if (accountArr.length <= 0) {
            ExcuteException = TransErrors.ERROR_Account;
            Log.e(TAG, "Exception: " + ExcuteException.getDesc());
            File file = new File(AuthFilePath);
            if (file.exists()) {
                boolean ret = file.delete();
                Log.e(TAG, "file.delete: " + ret);
            }
            throw new Exception(ExcuteException.getDesc());
        }
        if (!forceAuthen && FileAuthenRead()) {
            Log.e(TAG, "FileAuthenRead exist!!");
            return true;
        }
        Access_Token = null;
        Client_ID = null;
        Broad_ErrorMessage = null;
        File file2 = new File(AuthFilePath);
        if (file2.exists()) {
            boolean ret2 = file2.delete();
            Log.e(TAG, "file.delete: " + ret2);
        }
        IntentFilter filter = new IntentFilter("com.msc.action.ACCESSTOKEN_V02_RESPONSE");
        TransBroadcastReceiver transBroad = new TransBroadcastReceiver();
        context.registerReceiver(transBroad, filter);
        String packageName = context.getPackageName();
        String[] additional = {C1268d.f3197g};
        Intent intent = new Intent("com.msc.action.ACCESSTOKEN_V02_REQUEST");
        intent.putExtra("client_id", "q4h11v8aq6");
        intent.putExtra("client_secret", "FA98B86E69820E0131C284C71696AB1F");
        intent.putExtra("mypackage", packageName);
        intent.putExtra("OSP_VER", "OSP_02");
        intent.putExtra("MODE", "BACKGROUND");
        intent.putExtra("additional", additional);
        if (Expired_AccessToken != null) {
            intent.putExtra("expired_access_token", Expired_AccessToken);
            if (Expired_AccessToken.length() > 2) {
                Log.e(TAG, "Token reissue: " + Expired_AccessToken.substring(0, 2));
            }
        }
        context.sendBroadcast(intent);
        long startTime = System.currentTimeMillis();
        System.currentTimeMillis();
        while (true) {
            if (Access_Token == null || Client_ID == null) {
                long endTime = System.currentTimeMillis();
                if (Broad_ErrorMessage != null || endTime - startTime > 10000) {
                    break;
                }
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                context.unregisterReceiver(transBroad);
                if (Access_Token.length() < 10) {
                    Log.e(TAG, "auth token error: " + Access_Token);
                    return false;
                }
                Log.e(TAG, "token: " + Access_Token.substring(0, 2));
                boolean ret3 = getUserInfo(context);
                return ret3;
            }
        }
        ExcuteException = TransErrors.ERROR_Broadcast;
        Log.e(TAG, "Exception: BroadCast Error - " + Broad_ErrorMessage);
        context.unregisterReceiver(transBroad);
        Broad_ErrorMessage = null;
        return false;
    }

    private static boolean getUserInfo(Context context) throws Exception {
        String mcc;
        String mnc;
        String json_text;
        httpclientThread[1] = new DefaultHttpClient();
        HttpClient httpclient = httpclientThread[1];
        TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
        String simInfo = tm.getSimOperator();
        if (simInfo.length() == 5 || simInfo.length() == 6) {
            mcc = simInfo.substring(0, 3);
            mnc = simInfo.substring(3, simInfo.length());
        } else {
            mcc = "450";
            mnc = "06";
        }
        String simCountry = tm.getSimCountryIso().toUpperCase();
        Log.e(TAG, "simCountry: " + simCountry + ", Contry_Name: " + Contry_Name);
        if (Contry_Name != null && Contry_Name.equals("CHN")) {
            AUTH_SERVER = "http://cn-auth.translation.samsungosp.com";
        }
        String auth_url = String.valueOf(AUTH_SERVER) + "/stp/v1/getuserinfo?option=1&access_token=" + Access_Token + "&client_id=" + Client_ID + "&mcc=" + mcc + "&mnc=" + mnc;
        if (AUTH_SERVER.length() > 9) {
            Log.e(TAG, "AUTH_SERVER: " + AUTH_SERVER.substring(0, 9));
        }
        ArrayList<NameValuePair> headers = new ArrayList<>();
        String UserAgent = String.valueOf(Build.MODEL) + "; " + Build.DISPLAY + "; Translate=" + VersionName;
        headers.add(new BasicNameValuePair(HttpUtil.HEADER_USER_AGENT, UserAgent));
        headers.add(new BasicNameValuePair("Accept", "application/json;text/xml"));
        headers.add(new BasicNameValuePair("Content-Type", "application/json;charset=UTF-8"));
        HttpGet httpget = new HttpGet(auth_url);
        Iterator<NameValuePair> it = headers.iterator();
        while (it.hasNext()) {
            NameValuePair h = it.next();
            httpget.addHeader(h.getName(), h.getValue());
        }
        long start_Time = System.currentTimeMillis();
        System.currentTimeMillis();
        try {
            HttpParams params = httpclient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, 10000);
            HttpConnectionParams.setSoTimeout(params, 30000);
            long start_Time2 = System.currentTimeMillis();
            HttpResponse response = httpclient.execute(httpget);
            long end_Time = System.currentTimeMillis();
            auth_time = end_Time - start_Time2;
            Log.e(TAG, "auth_time: " + auth_time);
            Log.e(TAG, response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            int responseCode = response.getStatusLine().getStatusCode();
            Log.e(TAG, "responseCode: " + responseCode);
            if (entity != null) {
                InputStream instream = entity.getContent();
                if (responseCode != 200) {
                    json_text = convertStreamToString(instream);
                } else {
                    json_text = decryptData(Access_Token, instream);
                }
                if (responseCode == 400 || responseCode == 404 || responseCode == 408 || responseCode == 500 || responseCode == 502) {
                    Log.e(TAG, json_text);
                    ExcuteException = TransErrors.ERROR_Server;
                } else if (json_text.equals("")) {
                    Log.e(TAG, "json_text is null : " + instream);
                    ExcuteException = TransErrors.ERROR_Exception;
                    throw new Exception(ExcuteException.getDesc());
                }
                JSONObject json = new JSONObject(json_text);
                String rmsg = json.getString("rmsg");
                if (rmsg.equals("Success")) {
                    Log.e(TAG, "getUserInfo Success!!");
                    URL_UID = json.getString("uid");
                    String region = json.getString("gld_region");
                    JSONObject json_region = new JSONObject(region);
                    String primary = json_region.getString("primary");
                    JSONArray valArray1 = new JSONArray(primary);
                    String primary_address = valArray1.getJSONObject(0).getString(ChatONNativeCallLog.CHATON_CALLLOG_ADDRESS_TYPE);
                    URL_SERVER = "http://" + primary_address + "/";
                    String secondary = json_region.getString("secondary");
                    JSONArray valArray2 = new JSONArray(secondary);
                    String secondary_address = valArray2.getJSONObject(0).getString(ChatONNativeCallLog.CHATON_CALLLOG_ADDRESS_TYPE);
                    URL_SERVER_2th = "http://" + secondary_address + "/";
                    boolean ret = FileAuthenWrite();
                    if (!ret) {
                        Log.e(TAG, "Exception: FileAuthenWrite fail");
                        ExcuteException = TransErrors.ERROR_FileAuthen;
                    }
                    Expired_AccessToken = null;
                } else {
                    Log.e(TAG, json_text);
                    Log.e(TAG, "[rmsg: " + rmsg + "]");
                    String rcode = json.getString("rcode");
                    if (rcode.equals("49053")) {
                        Log.e(TAG, "Token expired!!");
                        ExcuteException = null;
                        Expired_AccessToken = Access_Token;
                        return false;
                    }
                    if (rcode.equals("49055") || rcode.equals("49057") || rcode.equals("49059")) {
                        Log.e(TAG, "Token error - rcode: " + rcode);
                        ExcuteException = null;
                        return false;
                    }
                    if (rcode.equals("19001")) {
                        Log.e(TAG, "Token certification error!!");
                        ExcuteException = TransErrors.ERROR_Authen;
                        throw new Exception(ExcuteException.getDesc());
                    }
                    if (ExcuteException == null) {
                        ExcuteException = TransErrors.ERROR_Exception;
                    }
                }
                instream.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            Log.e(TAG, "ClientProtocolException:" + e.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Protocol;
            }
        } catch (IOException e2) {
            String print_url = AUTH_SERVER.replace("http://", "");
            Log.e(TAG, "IOException:" + e2.getMessage().replace(print_url.replace("/", ""), ""));
            if (e2.getMessage().matches(".*Connection to http.*") || e2.getMessage().matches(".*timed out.*")) {
                ExcuteException = TransErrors.ERROR_Server;
            } else if (e2.getMessage().matches(".*Unable to resolve host.*")) {
                ExcuteException = TransErrors.ERROR_Network;
            } else if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_IO;
            }
            long end_Time2 = System.currentTimeMillis();
            auth_time = end_Time2 - start_Time;
            Log.e(TAG, "IOException auth_time: " + auth_time);
        } catch (JSONException e3) {
            e3.printStackTrace();
            Log.e(TAG, "JSONException:" + e3.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Json;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.e(TAG, "Exception:" + e4.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Exception;
            }
        }
        httpclient.getConnectionManager().shutdown();
        if (ExcuteException != null) {
            Log.e(TAG, "Exception: " + ExcuteException.getDesc());
            return false;
        }
        return true;
    }

    public static String[] getDetectLanguage(String transText, String cid, String option, Context context) {
        httpclientThread[1] = new DefaultHttpClient();
        HttpClient httpclient = httpclientThread[1];
        String[] lang_Array = new String[1];
        ExcuteException = null;
        isCanceling = false;
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
            boolean ret = setAuthen(context, false);
            if (!ret) {
                boolean ret2 = setAuthen(context, true);
                if (!ret2) {
                    ExcuteException = TransErrors.ERROR_Authen;
                    Log.e(TAG, "Exception: " + ExcuteException.getDesc());
                    lang_Array[0] = ExcuteException.getCode();
                    return lang_Array;
                }
            }
            String sid = "q4h11v8aq6";
            if (cid == null || cid.equals("") || cid.equals("0")) {
                cid = "Ng727U3NMO";
            } else if (cid.equals("phzjud4a45")) {
                sid = "phzjud4a45";
            }
            URL_OPTION = "1";
            url = String.valueOf(URL_SERVER) + "stp/v1/text/detect?option=" + URL_OPTION + "&sid=" + sid + "&cid=" + cid + "&access_token=" + Access_Token + "&uid=" + URL_UID;
            lang_Array = TransExecute(transText, httpclient, true);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception: " + e.getMessage());
            if (ExcuteException == null) {
                ExcuteException = TransErrors.ERROR_Exception;
            }
            lang_Array[0] = ExcuteException.getCode();
        }
        isCanceling = false;
        return lang_Array;
    }

    public static String[][] getSupportedLanguage() {
        String[] temp_Array = {"ko-KR/en-US", "ko-KR/ja-JP", "ko-KR/zh-CN", "ja-JP/ko-KR", "ja-JP/en-US", "ja-JP/zh-CN", "zh-CN/ko-KR", "zh-CN/en-US", "zh-CN/ja-JP", "en-US/ko-KR", "en-US/ja-JP", "en-US/zh-CN", "en-US/fr-FR", "en-US/es-ES", "en-US/de-DE", "en-US/it-IT", "en-US/pt-PT", "en-UK/fr-FR", "en-UK/de-DE", "en-UK/it-IT", "en-UK/es-ES", "en-UK/pt-PT", "fr-FR/en-US", "fr-FR/en-UK", "de-DE/en-US", "de-DE/en-UK", "it-IT/en-US", "it-IT/en-UK", "es-ES/en-US", "es-ES/en-UK", "pt-PT/en-US", "pt-PT/en-UK"};
        String[][] result_Array = (String[][]) Array.newInstance((Class<?>) String.class, temp_Array.length, 2);
        for (int i = 0; i < temp_Array.length; i++) {
            result_Array[i] = temp_Array[i].split("/");
        }
        return result_Array;
    }

    public static String[][] getSupportedLanguageOnNetwork() throws IllegalStateException, JSONException, IOException {
        httpclientThread[1] = new DefaultHttpClient();
        HttpClient httpclient = httpclientThread[1];
        String[][] result_Array = null;
        ExcuteException = null;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        url = String.valueOf(URL_SERVER) + "stp/v1/text/languages?&sid=sid0000001&cid=cid0000001&access_token=stptest000&uid=stptest000";
        ArrayList<NameValuePair> headers = new ArrayList<>();
        String UserAgent = String.valueOf(Build.MODEL) + "; " + Build.DISPLAY + "; Translate=" + VersionName;
        headers.add(new BasicNameValuePair(HttpUtil.HEADER_USER_AGENT, UserAgent));
        headers.add(new BasicNameValuePair("Accept", "application/json;text/xml"));
        headers.add(new BasicNameValuePair("Content-Type", "application/json;charset=UTF-8"));
        HttpGet httpget = new HttpGet(url);
        Iterator<NameValuePair> it = headers.iterator();
        while (it.hasNext()) {
            NameValuePair h = it.next();
            httpget.addHeader(h.getName(), h.getValue());
        }
        try {
            HttpParams params = httpclient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, 10000);
            HttpConnectionParams.setSoTimeout(params, 30000);
            HttpResponse response = httpclient.execute(httpget);
            Log.e(TAG, response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                String result = convertStreamToString(instream);
                Log.e(TAG, result);
                JSONObject json = new JSONObject(result);
                String rmsg = json.getString("rmsg");
                if (rmsg.equals("Success")) {
                    String target_text = json.getString("languages");
                    JSONArray valArray = new JSONArray(target_text);
                    String[] test_Array = new String[valArray.length()];
                    result_Array = (String[][]) Array.newInstance((Class<?>) String.class, valArray.length(), 2);
                    for (int i = 0; i < valArray.length(); i++) {
                        test_Array[i] = valArray.getJSONObject(i).getString("language");
                        Log.e(TAG, test_Array[i]);
                        result_Array[i] = test_Array[i].split("/");
                    }
                } else {
                    Log.e(TAG, "[rmsg: " + rmsg + "]");
                    ExcuteException = TransErrors.ERROR_Exception;
                }
                instream.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            Log.e(TAG, "ClientProtocolException:" + e.getMessage());
            ExcuteException = TransErrors.ERROR_Protocol;
        } catch (IOException e2) {
            e2.printStackTrace();
            Log.e(TAG, "IOException:" + e2.getMessage());
            ExcuteException = TransErrors.ERROR_IO;
        } catch (JSONException e3) {
            e3.printStackTrace();
            Log.e(TAG, "JSONException:" + e3.getMessage());
            ExcuteException = TransErrors.ERROR_Json;
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.e(TAG, "Exception:" + e4.getMessage());
            ExcuteException = TransErrors.ERROR_Exception;
        }
        httpclient.getConnectionManager().shutdown();
        return result_Array;
    }
}
