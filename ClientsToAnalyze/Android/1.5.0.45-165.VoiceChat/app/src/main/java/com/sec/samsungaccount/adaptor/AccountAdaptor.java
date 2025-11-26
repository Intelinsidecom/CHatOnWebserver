package com.sec.samsungaccount.adaptor;

import android.os.Handler;
import com.sds.coolots.common.util.EventSender;
import com.sds.coolots.common.util.Log;
import com.sec.samsungaccount.msg.CreateAccessTokenRep;
import com.sec.samsungaccount.msg.CreateAuthCodeRep;
import com.sec.samsungaccount.msg.CreateAuthTokenRep;
import com.sec.samsungaccount.msg.DeleteAccessTokenRep;
import com.sec.samsungaccount.msg.DeleteUserAuthTokenRep;
import com.sec.samsungaccount.msg.JasonParser;
import com.sec.samsungaccount.msg.UpdateAccessTokenRep;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public abstract class AccountAdaptor extends Thread {
    public static final String DOMAIN_PRODUCTION = "auth.samsungosp.com";
    public static final String DOMAIN_STAGE = "stg-auth.samsungosp.com";
    static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() { // from class: com.sec.samsungaccount.adaptor.AccountAdaptor.1
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
    private static final String HTTP_REQUEST_METHOD_GET = "GET";
    private static final String HTTP_REQUEST_METHOD_POST = "POST";
    public static final int METHOD_GET = 1;
    public static final int METHOD_POST = 0;
    public static final boolean USE_DEBUG_LOG = true;
    protected Handler mHandler;
    protected int mMethod;
    protected int mMsgType;
    protected String mPath;
    public String mReceivedMessage;
    protected int mTimeout;
    protected String mClassName = "[AccountAdaptor]";
    protected String mHost = "";
    protected List<AccountParameter> mParams = null;
    private int mErrorCode = 1;
    private final EventSender mEventSender = new EventSender();
    private int retryCounter = 0;

    protected abstract void printAdaptorKind();

    protected abstract void processRecvMessage(JasonParser jasonParser);

    public void logE(String message) {
        Log.m2958e(String.valueOf(this.mClassName) + message);
    }

    public void logD(String message) {
        Log.m2954d(String.valueOf(this.mClassName) + message);
    }

    public AccountAdaptor(int msgType, String path, int method, int timeout, Handler handler) {
        this.mTimeout = 6000;
        this.mMethod = 0;
        this.mPath = "";
        this.mHandler = null;
        this.mMsgType = 0;
        this.mMsgType = msgType;
        this.mPath = path;
        this.mHandler = handler;
        this.mMethod = method;
        this.mTimeout = timeout;
        setHost();
    }

    protected void setParameters(List<AccountParameter> params) {
        this.mParams = params;
    }

    protected final void setHost() {
        this.mHost = DOMAIN_PRODUCTION;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        logD("START !!");
        runProcess();
        logD("END !!");
    }

    protected void runProcess() {
        String askMsg = makeSendMessage();
        String receivedMsg = sendMessage(askMsg);
        onReceive(receivedMsg);
    }

    private String makeSendMessage() {
        StringBuilder messageBuilder = new StringBuilder();
        for (AccountParameter param : this.mParams) {
            if (messageBuilder.length() > 0) {
                messageBuilder.append("&");
            }
            messageBuilder.append(param.name);
            messageBuilder.append("=");
            messageBuilder.append(URLEncoder.encode(param.parameter));
        }
        return messageBuilder.toString();
    }

    private String sendMessage(String ask) {
        this.mReceivedMessage = "";
        String url = "https://" + this.mHost + this.mPath;
        int result = httpTransaction(url, ask, this.mTimeout);
        if (result != 0) {
            if (result == -10) {
                processTimeOutError();
            } else {
                handleNetworkError(result);
            }
            return null;
        }
        printAdaptorKind();
        return this.mReceivedMessage;
    }

    private void onReceive(String receivedMsg) {
        JasonParser parser;
        logE("<<YHT99>> RECEIVED MSG: " + receivedMsg);
        if (receivedMsg == null || receivedMsg.isEmpty()) {
            logE("<<YHT99>> RECEIVED MSG IS NULL!!");
            return;
        }
        switch (this.mMsgType) {
            case 90001:
                parser = new CreateAuthTokenRep(receivedMsg);
                break;
            case 90002:
                parser = new CreateAuthCodeRep(receivedMsg);
                break;
            case JasonParser.CREATE_ACCESS_TOKEN /* 90003 */:
                parser = new CreateAccessTokenRep(receivedMsg);
                break;
            case JasonParser.UPDATE_ACCESS_TOKEN /* 90004 */:
                parser = new UpdateAccessTokenRep(receivedMsg);
                break;
            case JasonParser.DELETE_USER_AUTH_TOKEN /* 90005 */:
                parser = new DeleteUserAuthTokenRep(receivedMsg);
                break;
            case JasonParser.DELETE_ACCESS_TOKEN /* 90006 */:
                new DeleteAccessTokenRep(receivedMsg);
                return;
            default:
                return;
        }
        if (parser.isErrorMessage()) {
            processErrorMessage(parser);
        } else {
            processRecvMessage(parser);
        }
    }

    private int httpTransaction(String url, String ask, int timeout) {
        InputStream inputStream;
        HttpURLConnection httpURLCon = null;
        try {
            try {
                try {
                    logE("<<YHT99>> http transaction step 1");
                    if (this.mMethod == 0) {
                        URL httpUrl = new URL(url);
                        httpURLCon = (HttpURLConnection) httpUrl.openConnection();
                        logD("CONNECTING=" + httpUrl.toString());
                        httpURLCon.setConnectTimeout(timeout);
                        httpURLCon.setDefaultUseCaches(false);
                        httpURLCon.setDoInput(true);
                        httpURLCon.setDoOutput(true);
                        httpURLCon.setRequestMethod("POST");
                        httpURLCon.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                        BufferedWriter mBufferedWrither = new BufferedWriter(new OutputStreamWriter(httpURLCon.getOutputStream(), "UTF-8"));
                        mBufferedWrither.write(ask);
                        mBufferedWrither.flush();
                    } else {
                        URL httpUrl2 = new URL(String.valueOf(url) + "?" + ask);
                        httpURLCon = (HttpURLConnection) httpUrl2.openConnection();
                        logD("CONNECTING=" + httpUrl2.toString());
                        httpURLCon.setConnectTimeout(timeout);
                        httpURLCon.setDefaultUseCaches(false);
                        httpURLCon.setDoInput(true);
                        httpURLCon.setRequestMethod("GET");
                    }
                    if (httpURLCon.getResponseCode() == 200) {
                        inputStream = httpURLCon.getInputStream();
                    } else {
                        if (httpURLCon.getResponseCode() != 400) {
                            if (httpURLCon != null) {
                                httpURLCon.disconnect();
                                logE("A http connection cut");
                            }
                            return -1;
                        }
                        inputStream = httpURLCon.getErrorStream();
                    }
                    this.mReceivedMessage = readReceivedData(inputStream);
                    if (httpURLCon != null) {
                        httpURLCon.disconnect();
                        logE("A http connection cut");
                    }
                    return 0;
                } catch (MalformedURLException e1) {
                    logE(e1.getMessage());
                    if (httpURLCon != null) {
                        httpURLCon.disconnect();
                        logE("A http connection cut");
                    }
                    return -6;
                } catch (SocketException e12) {
                    logE(e12.getMessage());
                    if (httpURLCon != null) {
                        httpURLCon.disconnect();
                        logE("A http connection cut");
                    }
                    return -11;
                } catch (Exception e13) {
                    logE(e13.getMessage());
                    if (httpURLCon != null) {
                        httpURLCon.disconnect();
                        logE("A http connection cut");
                    }
                    return -1;
                }
            } catch (SocketTimeoutException e14) {
                logE(e14.getMessage());
                if (httpURLCon != null) {
                    httpURLCon.disconnect();
                    logE("A http connection cut");
                }
                return -10;
            } catch (IOException e15) {
                logE("<<IOEXCEPTION>>" + e15.getMessage());
                if (httpURLCon != null) {
                    httpURLCon.disconnect();
                    logE("A http connection cut");
                }
                return -7;
            }
        } catch (Throwable th) {
            if (httpURLCon != null) {
                httpURLCon.disconnect();
                logE("A http connection cut");
            }
            throw th;
        }
    }

    private String readReceivedData(InputStream inputStream) throws IOException {
        try {
            StringBuilder buff = new StringBuilder();
            logE("<<YHT99>> readReceivedData step 1");
            InputStreamReader isReader = new InputStreamReader(inputStream, "UTF-8");
            logE("<<YHT99>> readReceivedData step 2");
            BufferedReader mBufferedReader = new BufferedReader(isReader);
            logE("<<YHT99>> readReceivedData step 3");
            while (true) {
                String line = mBufferedReader.readLine();
                if (line != null) {
                    buff.append(line).append("\n");
                } else {
                    logE("<<YHT99>> readReceivedData received Message:" + buff.toString());
                    return buff.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    protected void sendEvent(int nArg1ErrorCode, int nArg2EventCode, Object obj) {
        if (this.mErrorCode == 1) {
            this.mErrorCode = nArg1ErrorCode;
            if (this.mErrorCode < 0) {
                logE("EXCEPTION errorcode=" + nArg1ErrorCode);
            }
            this.mEventSender.sendEvent(this.mMsgType, nArg1ErrorCode, nArg2EventCode, obj, this.mHandler);
        }
    }

    protected void processErrorMessage(JasonParser message) {
        String err_code = message.parseErrorCode();
        String err_desc = message.parseErrorDescription();
        logE("error code:" + err_code + ", msg:" + err_desc);
        handleNormalError(err_code, err_desc);
    }

    protected void handleNormalError(String errCode, String errMessage) {
        sendEvent(-1, 0, errCode);
    }

    protected void handleNetworkError(int errorCode) {
        sendEvent(errorCode, 0, null);
    }

    protected void processTimeOutErrorTreat() {
        logE("ADAPTOR_TRACE HTTPAdaptor's processTimeOutErrorTreat send HTTP_ERR_TIMEOUT");
        sendEvent(-10, 0, null);
    }

    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE HTTPAdaptor's processTimeOutError call runProcess");
        if (this.retryCounter >= 2) {
            processTimeOutErrorTreat();
        } else {
            this.retryCounter++;
            runProcess();
        }
    }
}
