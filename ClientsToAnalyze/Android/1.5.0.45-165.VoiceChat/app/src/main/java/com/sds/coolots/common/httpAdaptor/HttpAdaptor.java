package com.sds.coolots.common.httpAdaptor;

import android.content.Intent;
import android.os.Handler;
import android.os.Process;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ChatOnJoinAsk;
import com.coolots.p2pmsg.model.DeviceIDAsk;
import com.coolots.p2pmsg.model.Error;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.util.EventSender;
import com.sds.coolots.common.util.Log;
import java.security.PrivateKey;

/* loaded from: classes.dex */
public abstract class HttpAdaptor extends Thread {
    public static final int HTTP = 0;
    public static final int HTTPS = 1;
    public static final String HTTPS_DO_PATH = "/xml3/pb.do";
    public static final String HTTP_DO_PATH = "/xml3/pb3.do";
    public static final boolean USE_DEBUG_LOG = true;
    public static final String UTF8 = "UTF-8";
    protected int HTTP_CONNECTION_TIMEOUT;

    /* renamed from: a */
    private int f3022a;

    /* renamed from: b */
    private final EventSender f3023b;

    /* renamed from: c */
    private int f3024c;
    protected String mClassName;
    protected Short mDeviceID;
    protected MessageInfo mDispathInfo;
    protected Handler mHandler;
    protected String mHost;
    protected HttpClientInterface mHttpClient;
    protected MsgBody mMsgBody;
    protected MsgHeader mMsgHeader;
    protected Object mObject;
    protected String mPasswd;
    protected String mPath;
    protected PrivateKey mPrivateKey;
    protected int mUriScheme;
    protected String mUserID;
    protected long mUserNo;
    protected boolean mbCheckNonce;

    public HttpAdaptor(MessageInfo messageInfo, MsgBody msgBody, Handler handler, int i) throws Exception {
        this.mClassName = "[HttpsAdaptor]";
        this.HTTP_CONNECTION_TIMEOUT = 6000;
        this.mUriScheme = 0;
        this.mHost = "";
        this.mPath = "";
        this.mUserID = null;
        this.mUserNo = 0L;
        this.mDeviceID = null;
        this.mPasswd = null;
        this.mDispathInfo = null;
        this.mMsgHeader = null;
        this.mMsgBody = null;
        this.mHandler = null;
        this.mObject = null;
        this.f3022a = 1;
        this.mbCheckNonce = true;
        this.f3023b = new EventSender();
        this.f3024c = 0;
        this.HTTP_CONNECTION_TIMEOUT = i;
        if (messageInfo != null) {
            this.mClassName = String.valueOf(this.mClassName) + "[" + messageInfo.name() + "]";
        }
        this.mDispathInfo = messageInfo;
        this.mMsgBody = msgBody;
        this.mHandler = handler;
        setServerInfo();
        setUserInfo();
        setHeaderInformation();
    }

    public HttpAdaptor(MessageInfo messageInfo, MsgBody msgBody, Handler handler, Object obj, int i) {
        this(messageInfo, msgBody, handler, i);
        this.mObject = obj;
    }

    /* renamed from: a */
    private String m2921a(String str, String str2, HttpClientInterface httpClientInterface) {
        int iHttpsTransaction = httpClientInterface.httpsTransaction(str, str2, (this.mUriScheme == 0 ? "http://" : "https://") + this.mHost + this.mPath, this.HTTP_CONNECTION_TIMEOUT);
        if (iHttpsTransaction == 0) {
            printAdaptorKind();
            return (String) httpClientInterface.getTransactionResult();
        }
        if (iHttpsTransaction == -10) {
            processTimeOutError();
        } else {
            handleNetworkError(iHttpsTransaction);
        }
        return null;
    }

    /* renamed from: a */
    private byte[] m2922a(String str, HttpClientInterface httpClientInterface) {
        int iHttpTransaction = httpClientInterface.httpTransaction(str, (this.mUriScheme == 0 ? "http://" : "https://") + this.mHost + this.mPath, this.HTTP_CONNECTION_TIMEOUT);
        if (iHttpTransaction == 0) {
            printAdaptorKind();
            return (byte[]) httpClientInterface.getTransactionResult();
        }
        if (iHttpTransaction == -10) {
            processTimeOutError();
        } else {
            handleNetworkError(iHttpTransaction);
        }
        return null;
    }

    public void cancelTrnasaction() {
        if (this.mHttpClient != null) {
            this.mHttpClient.cancelTransaction();
        }
    }

    protected final MsgBody getMsgBody() {
        return this.mMsgBody;
    }

    protected void handleFinishEncode() {
    }

    protected void handleNetworkError(int i) {
        if (i == -4) {
            processTimeOutError();
        } else {
            sendEvent(i, 0, null);
        }
    }

    protected void handleNormalError(P2PMsg p2PMsg) {
        sendEvent(-1, 0, null);
    }

    protected void handleOldVersionError(P2PMsg p2PMsg) {
        logE("ErrorCode.ERR_MSG_OLD_VERSION");
        if (MainApplication.mInformationActivityGenerator != null) {
            MainApplication.mInformationActivityGenerator.showInformationActivityForCriticalUpdate();
        }
        sendEvent(-1, 0, null);
    }

    public void logD(String str) {
        Log.m2954d(String.valueOf(this.mClassName) + str);
    }

    public void logE(String str) {
        Log.m2958e(String.valueOf(this.mClassName) + str);
    }

    public void logI(String str) {
        Log.m2963i(String.valueOf(this.mClassName) + str);
    }

    protected void onReceive(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            handleNetworkError(-4);
            return;
        }
        StringBuilder sb = new StringBuilder();
        logD("RCV MsgHeader.length=" + bArr.length);
        logD("RCV MsgBody.length=" + bArr2.length);
        try {
            P2PMsg p2PMsgM2946a = C1258h.m2946a(bArr, bArr2, sb);
            if (p2PMsgM2946a == null) {
                handleNetworkError(-5);
            } else {
                logD("RCV <" + p2PMsgM2946a.getMsgBody().getClass().getSimpleName() + "> " + sb.toString());
                if (p2PMsgM2946a.getMsgBody() instanceof Error) {
                    processErrorMessage(p2PMsgM2946a);
                } else {
                    processRecvMessage(p2PMsgM2946a);
                }
            }
        } catch (Exception e) {
            logE("###############################################");
            logE("Input Value : " + sb.toString());
            logE("Detail exception explain" + e);
            logE("###############################################");
            handleNetworkError(-2);
        }
    }

    public void popupWithBlur(String str, String str2) {
        MainApplication.mPopupCreator.showMessage(str, str2);
    }

    protected abstract void printAdaptorKind();

    protected void processErrorMessage(P2PMsg p2PMsg) {
        Error error = (Error) p2PMsg.getMsgBody();
        logE("error code:" + error.getErrorCode() + ", msg:" + error.getErrorMsg());
        switch (error.getErrorCode()) {
            case ErrorCode.COMMON_PHONE_NO_AUTH_SMS_ERROR /* -9000 */:
                sendEvent(ErrorCode.COMMON_PHONE_NO_AUTH_SMS_ERROR, 0, Integer.valueOf(error.getErrorMsg()));
                break;
            case 10000:
            case 10007:
            case 10008:
            case ErrorCode.ERR_CENTER_INVALID_VALUE /* 10015 */:
            case ErrorCode.ERR_CENTER_DUPLICATE_VALUE /* 10072 */:
            case ErrorCode.ERR_CENTER_MALFORMED_MESSAGE /* 10080 */:
            case ErrorCode.ERR_CENTER_CONNECTION /* 10084 */:
            case ErrorCode.ERR_CENTER_AUTH_ERROR /* 10098 */:
            case ErrorCode.ERR_CENTER_PROTOCOL /* 10100 */:
                handleNormalError(p2PMsg);
                break;
            case 10002:
            case ErrorCode.ERR_CENTER_ENCRYPT /* 10078 */:
            case ErrorCode.ERR_CENTER_NONCE_REFRESH_NEEDED /* 10082 */:
                MainApplication.mConfig.setCipherKey("");
                MainApplication.mConfig.setSessionID("");
                MainApplication.mPhoneManager.getLoginManager().setNonce("");
                MainApplication.mPhoneManager.getLoginManager().logout(true);
                sendEvent(error.getErrorCode(), 0, null);
                break;
            case ErrorCode.ERR_CENTER_AUTH_TIMEOUT /* 10081 */:
                sendEvent(ErrorCode.ERR_CENTER_AUTH_TIMEOUT, 0, null);
                break;
            case ErrorCode.ERR_CENTER_DEVICEID_NEEDED /* 10083 */:
                MainApplication.mConfig.setProfileDeviceID(Short.valueOf("0"));
                MainApplication.mPhoneManager.getLoginManager().logout(true);
                break;
            case ErrorCode.ERR_CENTER_LOST_PHONE_NUMBER /* 10095 */:
                MainApplication.mPhoneManager.getLoginManager().logout(false);
                Process.killProcess(Process.myPid());
                break;
            case ErrorCode.ERR_CENTER_FORCE_BLOCKED /* 10097 */:
                MainApplication.mPhoneManager.getLoginManager().logout(false);
                popupWithBlur("직권정지고객", String.valueOf(MainApplication.mConfig.getProfileUserID()) + " 아이디가 직권정지 되었습니다.  웹 사이트에서 온라인 고객센터로 문의 하신 후 다시 로그인 하실 수 있습니다.");
                break;
            case ErrorCode.ERR_CENTER_ACCOUNT_DUPLICATE /* 10101 */:
                processRecvMessage(p2PMsg);
                break;
            case ErrorCode.ERR_MSG_OLD_VERSION /* 10103 */:
                handleOldVersionError(p2PMsg);
                break;
            case ErrorCode.ERR_CENTER_ACCOUNT_DELETED /* 10112 */:
                Log.m2958e("BUDDY_TRACE My Samsung Account Delete from WEB!!!!!!!!!!!!!!!!!!!!! HttpAdaptor");
                if (!PhoneManager.isSamsungAccountDeleted) {
                    Intent deleteAccountIntent = MainApplication.mDeleteAccountIntentGenerator.getDeleteAccountIntent();
                    deleteAccountIntent.addFlags(268435456);
                    deleteAccountIntent.addFlags(536870912);
                    deleteAccountIntent.addFlags(8388608);
                    MainApplication.mContext.startActivity(deleteAccountIntent);
                    PhoneManager.isSamsungAccountDeleted = true;
                    break;
                }
                break;
            case ErrorCode.ERR_CENTER_GROUP_EXCEED /* 10114 */:
                Log.m2958e("BUDDY_TRACE Group Count Exceeded!!!!!!!!!!!!!!!");
                sendEvent(ErrorCode.ERR_CENTER_GROUP_EXCEED, 0, null);
                break;
            case ErrorCode.ERR_CENTER_GROUPMEMBER_EXCEED /* 10115 */:
                Log.m2958e("BUDDY_TRACE Group Member Count Exceeded!!!!!!!!!!!!!!!");
                sendEvent(ErrorCode.ERR_CENTER_GROUPMEMBER_EXCEED, 0, null);
                break;
            case ErrorCode.ERR_CENTER_FAVORITE_EXCEED /* 10116 */:
                Log.m2958e("BUDDY_TRACE Favorite Count Exceeded!!!!!!!!!!!!!!!");
                sendEvent(ErrorCode.ERR_CENTER_FAVORITE_EXCEED, 0, null);
                break;
            case ErrorCode.ERR_MSGKEY_DUPLICATED /* 10120 */:
                Log.m2963i("ErrorCode.ERR_MSGKEY_DUPLICATED");
                MainApplication.mConfig.setCipherKey("");
                MainApplication.mConfig.setSessionID("");
                MainApplication.mPhoneManager.getLoginManager().sendCipherKeyAsk();
                sendEvent(ErrorCode.ERR_MSGKEY_DUPLICATED, 0, null);
                break;
            case ErrorCode.ERR_MSGKEY_TOO_OLD /* 10121 */:
                Log.m2963i("ErrorCode.ERR_MSGKEY_TOO_OLD");
                MainApplication.mConfig.setCipherKey("");
                MainApplication.mConfig.setSessionID("");
                MainApplication.mPhoneManager.getLoginManager().sendCipherKeyAsk();
                sendEvent(ErrorCode.ERR_MSGKEY_TOO_OLD, 0, null);
                break;
            default:
                handleNormalError(p2PMsg);
                break;
        }
    }

    protected abstract void processRecvMessage(P2PMsg p2PMsg);

    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE HTTPAdaptor's processTimeOutError call runProcess");
        if (this.f3024c >= 2) {
            processTimeOutErrorTreat();
            return;
        }
        this.f3024c++;
        this.mMsgHeader.setMsgKey(Integer.valueOf(MsgKeyGenerator.getInstance().getKey()));
        runProcess();
    }

    protected void processTimeOutErrorTreat() {
        logE("ADAPTOR_TRACE HTTPAdaptor's processTimeOutErrorTreat send HTTP_ERR_TIMEOUT");
        sendEvent(-10, 0, null);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        logD("START !!");
        runProcess();
        logD("END !!");
    }

    protected void runProcess() {
        if (this.mMsgHeader == null) {
            MainApplication.mPhoneManager.getLoginManager().logout(false);
            Process.killProcess(Process.myPid());
            return;
        }
        if (!PhoneManager.isNetworkConnected(MainApplication.mContext)) {
            sendEvent(-16, 0, null);
            return;
        }
        P2PMsg p2PMsg = new P2PMsg();
        if (!(this.mMsgBody instanceof DeviceIDAsk) && (!MainApplication.mPhoneManager.isPrivacyLogBlockVer() || !(this.mMsgBody instanceof ChatOnJoinAsk))) {
            logD(this.mMsgBody.toString());
        }
        p2PMsg.setMsgHeader(this.mMsgHeader);
        p2PMsg.setMsgBody(this.mMsgBody);
        byte[] decodedCipherKey = MainApplication.mConfig.getDecodedCipherKey();
        if (this.mUriScheme == 0 && this.mPrivateKey == null && (decodedCipherKey == null || decodedCipherKey.length == 0)) {
            handleNetworkError(-8);
            return;
        }
        C1256f c1256f = new C1256f(p2PMsg, this.mUriScheme, decodedCipherKey);
        int iM2934a = c1256f.m2934a();
        if (iM2934a != 0) {
            handleNetworkError(iM2934a);
            return;
        }
        handleFinishEncode();
        if (this.mUriScheme == 0) {
            String strM2941d = c1256f.m2941d();
            c1256f.m2942e();
            this.mHttpClient = new C1252b();
            byte[] bArrM2922a = m2922a(strM2941d, this.mHttpClient);
            this.mHttpClient = null;
            if (bArrM2922a == null) {
                return;
            }
            int iM2935a = c1256f.m2935a(bArrM2922a, decodedCipherKey, this.mPrivateKey);
            if (iM2935a != 0) {
                handleNetworkError(iM2935a);
                return;
            }
        } else {
            String strM2937b = c1256f.m2937b();
            String strM2940c = c1256f.m2940c();
            c1256f.m2942e();
            this.mHttpClient = new AndroidHttpClient();
            String strM2921a = m2921a(strM2937b, strM2940c, this.mHttpClient);
            this.mHttpClient = null;
            if (strM2921a == null) {
                return;
            }
            int iM2939c = c1256f.m2939c(strM2921a);
            if (iM2939c != 0) {
                handleNetworkError(iM2939c);
                return;
            }
        }
        onReceive(c1256f.m2943f(), c1256f.m2944g());
    }

    protected void sendEvent(int i, int i2, Object obj) {
        if (this.f3022a != 1) {
            return;
        }
        this.f3022a = i;
        if (this.f3022a < 0) {
            logE("EXCEPTION errorcode=" + i);
        }
        if (obj != null) {
            this.f3023b.sendEvent(this.mDispathInfo.getDispatchCode(), i, i2, obj, this.mHandler);
        } else {
            this.f3023b.sendEvent(this.mDispathInfo.getDispatchCode(), i, i2, this.mObject, this.mHandler);
        }
    }

    protected void setHeaderInformation() throws Exception {
        try {
            if (this.mDispathInfo == null) {
                throw new Exception(String.valueOf(getName()) + " mDispathInfo is null!!");
            }
            if (this.mUserID == null || this.mUserID.equals("")) {
                throw new Exception(String.valueOf(getClass().getSimpleName()) + " UserID is null!!");
            }
            this.mMsgHeader = new MsgHeader();
            this.mMsgHeader.setVersion("0.90");
            this.mMsgHeader.setSvcCode(this.mDispathInfo.getServiceCode());
            this.mMsgHeader.setMsgCode(this.mDispathInfo.getMessageCode());
            this.mMsgHeader.setFromID(this.mUserID);
            this.mMsgHeader.setToID("SVR");
            this.mMsgHeader.setFromDeviceID(this.mDeviceID);
            this.mMsgHeader.setPasswd(this.mPasswd);
            this.mMsgHeader.setDUKey(MainApplication.mConfig.getDeviceUniqueKey());
            this.mMsgHeader.setMsgKey(Integer.valueOf(MsgKeyGenerator.getInstance().getKey()));
            if (this.mUserNo != 0) {
                this.mMsgHeader.setUserNo(Long.valueOf(this.mUserNo));
            }
        } catch (Exception e) {
            logE(e.getMessage());
        }
    }

    protected void setServerInfo() {
        this.mUriScheme = 0;
        this.mHost = MainApplication.mConfig.getCenterDomain();
        this.mPath = this.mUriScheme == 1 ? HTTPS_DO_PATH : HTTP_DO_PATH;
    }

    protected void setUserInfo() {
        this.mUserID = MainApplication.mConfig.getProfileUserID();
        this.mDeviceID = MainApplication.mConfig.getProfileDeviceID();
        this.mPasswd = MainApplication.mConfig.getProfilePasswd();
        this.mUserNo = MainApplication.mConfig.getProfileUserNo();
    }
}
