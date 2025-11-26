package com.sds.coolots;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.view.Surface;
import com.coolots.p2pmsg.model.ChargeRep;
import com.coolots.p2pmsg.model.FeatureInfoAsk;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.NotifyBoardDataAsk;
import com.coolots.p2pmsg.model.NotifyCloseCallAsk;
import com.coolots.p2pmsg.model.NotifyConferenceCloseAsk;
import com.coolots.p2pmsg.model.NotifyConferenceEnterAsk;
import com.coolots.p2pmsg.model.NotifyConferenceStatusAsk;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.NotifyFinishShareCameraAsk;
import com.coolots.p2pmsg.model.NotifyStartShareScreenAsk;
import com.coolots.p2pmsg.model.NotifyStopShareScreenAsk;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.RecognitionAsk;
import com.coolots.p2pmsg.model.RecognitionRep;
import com.coolots.p2pmsg.model.RejectMessageAsk;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberAsk;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberRep;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.coolots.p2pmsg.model.Server;
import com.coolots.p2pmsg.model.TTSAsk;
import com.coolots.p2pmsg.model.TTSRep;
import com.coolots.p2pmsg.model.TranslationAsk;
import com.coolots.p2pmsg.model.TranslationRep;
import com.coolots.p2pmsg.parser.ProtoBufHandler;
import com.coolots.p2pmsg.parser.ProtoBufHandlerException;
import com.sds.coolots.call.model.C1189D;
import com.sds.coolots.call.model.Call;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import com.sds.coolots.common.controller.EngineChattingCallbackInterface;
import com.sds.coolots.common.controller.EngineContactCallbackInterface;
import com.sds.coolots.common.controller.EngineLoginCallbackInterface;
import com.sds.coolots.common.controller.EngineSettingCallbackInterface;
import com.sds.coolots.common.controller.P2P_EngineInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.controller.PushReceiveInterface;
import com.sds.coolots.common.controller.translation.TranslationNotificationCallbackInterface;
import com.sds.coolots.common.httpAdaptor.C1258h;
import com.sds.coolots.common.httpAdaptor.MsgKeyGenerator;
import com.sds.coolots.common.model.ConfFileName;
import com.sds.coolots.common.model.CoolotsWakeLockList;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.model.IntentName;
import com.sds.coolots.common.util.C1260a;
import com.sds.coolots.common.util.DateTimeUtil;
import com.sds.coolots.common.util.EncodingUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

/* loaded from: classes.dex */
public final class EngineInterface implements P2P_EngineInterface, PushReceiveInterface {

    /* renamed from: A */
    private static final int f2158A = 23;

    /* renamed from: B */
    private static final int f2159B = 24;

    /* renamed from: C */
    private static final int f2160C = 25;
    public static final int CONNECTION_SERVER_DEFAULT_SUB_PORT = 7080;

    /* renamed from: D */
    private static final int f2161D = 26;

    /* renamed from: E */
    private static final int f2162E = 27;
    public static final int EI_INT_INFO_AEC = 7;
    public static final int EI_INT_INFO_AUDIO_VOLUME = 19;
    public static final int EI_INT_INFO_BANDWIDTH = 3;
    public static final int EI_INT_INFO_CALL_DATA_SEND_INTERVAL = 39;
    public static final int EI_INT_INFO_CAMERA_HEIGHT = 1;
    public static final int EI_INT_INFO_CAMERA_WIDTH = 0;
    public static final int EI_INT_INFO_CELLUAR_NETWORK = 37;
    public static final int EI_INT_INFO_CENTER_MSG_KEY = 38;
    public static final int EI_INT_INFO_DELAY = 12;
    public static final int EI_INT_INFO_DISABLE_BILLING = 28;
    public static final int EI_INT_INFO_FEC = 13;
    public static final int EI_INT_INFO_FRAMERATE = 2;
    public static final int EI_INT_INFO_IS_MODEL_GALAXY_S2 = 24;
    public static final int EI_INT_INFO_MIC_VOLUME = 18;
    public static final int EI_INT_INFO_NORMAL_MODE_AGC_VALUE = 17;
    public static final int EI_INT_INFO_NORMAL_MODE_MIC_GAIN = 16;
    public static final int EI_INT_INFO_NORMAL_MODE_MIC_GAIN_AFTER_AEC = 20;
    public static final int EI_INT_INFO_NS = 6;
    public static final int EI_INT_INFO_P2P_RESEND_COUNT = 26;
    public static final int EI_INT_INFO_PERFORM_STUN_TEST = 33;
    public static final int EI_INT_INFO_Q_FACTOR = 4;
    public static final int EI_INT_INFO_RECORD_BUFFER_SIZE = 10;
    public static final int EI_INT_INFO_RELAY_RESEND_COUNT = 25;
    public static final int EI_INT_INFO_SAMPLE_RATE = 9;
    public static final int EI_INT_INFO_SIP_DEST_PORT = 36;
    public static final int EI_INT_INFO_SPEAKER_MODE_AGC_VALUE = 15;
    public static final int EI_INT_INFO_SPEAKER_MODE_MIC_GAIN = 14;
    public static final int EI_INT_INFO_SPEAKER_MODE_MIC_GAIN_AFTER_AEC = 21;
    public static final int EI_INT_INFO_SW_ENCODER_FLIP = 23;
    public static final int EI_INT_INFO_SW_ENCODER_ROTATION = 22;
    public static final int EI_INT_INFO_TRAC_BUFFER_SIZE = 11;
    public static final int EI_INT_INFO_USE_EYE_CONTACT = 35;
    public static final int EI_INT_INFO_USE_SIP_INFO_FROM_CONFIG = 34;
    public static final int EI_INT_INFO_USE_XML = 27;
    public static final int EI_INT_INFO_VAD = 8;
    public static final int EI_INT_INFO_VOICE_CODEC = 5;
    public static final int EI_LOGLEVEL_DEBUG = 4;
    public static final int EI_LOGLEVEL_ERROR = 1;
    public static final int EI_LOGLEVEL_FALTAL = 0;
    public static final int EI_LOGLEVEL_INFO = 3;
    public static final int EI_LOGLEVEL_WARNING = 2;
    public static final int EI_STRING_INFO_APPLICATION_ID = 9;
    public static final int EI_STRING_INFO_APP_VERSION = 10;
    public static final int EI_STRING_INFO_GET_ANI_CONF_PATH = 4;
    public static final int EI_STRING_INFO_GET_FACE_CONF_PATH = 5;
    public static final int EI_STRING_INFO_GET_HOST_BY_NAME = 0;
    public static final int EI_STRING_INFO_MCC = 7;
    public static final int EI_STRING_INFO_MNC = 8;
    public static final int EI_STRING_INFO_SIP_PROXY_ID = 2;
    public static final int EI_STRING_INFO_SIP_PROXY_IP = 1;
    public static final int EI_STRING_INFO_SIP_PROXY_PW = 3;
    public static final int EI_STRING_INFO_SSE_EVENT_ID = 6;
    public static final int ENGINE_STATE_DESTROYING = 3;
    public static final int ENGINE_STATE_INITIALIZING = 1;
    public static final int ENGINE_STATE_NULL = 0;
    public static final int ENGINE_STATE_RUNNING = 2;

    /* renamed from: F */
    private static final int f2163F = 28;

    /* renamed from: G */
    private static final int f2164G = 32;

    /* renamed from: H */
    private static final int f2165H = 33;

    /* renamed from: I */
    private static final int f2166I = 34;
    public static final int INVALID_CALL_ID = -1;

    /* renamed from: J */
    private static final int f2167J = 35;

    /* renamed from: K */
    private static final int f2168K = 36;

    /* renamed from: L */
    private static final int f2169L = 37;

    /* renamed from: M */
    private static final int f2170M = 38;

    /* renamed from: N */
    private static final int f2171N = 39;

    /* renamed from: O */
    private static final int f2172O = 40;

    /* renamed from: P */
    private static final int f2173P = 41;

    /* renamed from: Q */
    private static final int f2174Q = 42;

    /* renamed from: R */
    private static final int f2175R = 43;

    /* renamed from: S */
    private static final int f2176S = 44;
    public static final int SMPUI_ERROR_CENTERSENDDATA = -12;
    public static final int SMPUI_ERROR_CONNECTIONSERVER = -27;
    public static final int SMPUI_ERROR_ENGINE_STATE_MISMATCH = -28;
    public static final int SMPUI_ERROR_FAILEDINITAGENT = -11;
    public static final int SMPUI_ERROR_INVALIDCALLID = -30;
    public static final int SMPUI_ERROR_INVALIDPARAM = -5;
    public static final int SMPUI_ERROR_INVALIDPHONENUMBER = -19;
    public static final int SMPUI_ERROR_INVALIDSTATUS = -6;
    public static final int SMPUI_ERROR_MSGFROMCENTERSVR = -1;
    public static final int SMPUI_ERROR_NOPENDINGCALL = -16;
    public static final int SMPUI_ERROR_NOPENDINGINCOMINGCALL = -15;
    public static final int SMPUI_ERROR_NOTAVAILABLECENTERSVR = -3;
    public static final int SMPUI_ERROR_NOTAVAILABLENETWORK = -4;
    public static final int SMPUI_ERROR_NOTAVAILABLEP2PSESSION = -26;
    public static final int SMPUI_ERROR_NOTAVAILABLEP2PSESSION_NEED_CRITICAL_UPDATE = -200;
    public static final int SMPUI_ERROR_NOTAVAILABLEPHONECONTACT = -20;
    public static final int SMPUI_ERROR_NOTAVAILABLERELAY = -25;
    public static final int SMPUI_ERROR_NOTENOUGHMEMORY = -2;
    public static final int SMPUI_ERROR_NOTINITENGINE = -29;
    public static final int SMPUI_ERROR_NOTSUPPORT = -17;
    public static final int SMPUI_ERROR_NOTSUPPORTREQUESTEVENT = -18;
    public static final int SMPUI_ERROR_NOTSUPPORTRESPONSEEVENT = -21;
    public static final int SMPUI_ERROR_P2PHANDLERINIT = -24;
    public static final int SMPUI_ERROR_P2PSENDDATA = -13;
    public static final int SMPUI_ERROR_PRESENCESENDDATA = -14;
    public static final int SMPUI_ERROR_UNKNOWN = -22;
    public static final int SMPUI_ERROR_XMLPARSE = -23;
    public static final int SMPUI_SUCCESS = 1;

    /* renamed from: T */
    private static final int f2177T = 45;

    /* renamed from: U */
    private static final int f2178U = 46;

    /* renamed from: V */
    private static final int f2179V = 47;

    /* renamed from: W */
    private static final int f2180W = 48;

    /* renamed from: X */
    private static final int f2181X = 300;

    /* renamed from: Y */
    private static final int f2182Y = 303;

    /* renamed from: Z */
    private static final int f2183Z = 309;

    /* renamed from: a */
    private static final String f2184a = "[EngineInterface]";

    /* renamed from: aA */
    private static final int f2185aA = 510;

    /* renamed from: aB */
    private static final int f2186aB = 512;

    /* renamed from: aC */
    private static final int f2187aC = 513;

    /* renamed from: aD */
    private static final int f2188aD = 0;

    /* renamed from: aE */
    private static final int f2189aE = 1;

    /* renamed from: aF */
    private static final int f2190aF = 2;

    /* renamed from: aG */
    private static final int f2191aG = 10;

    /* renamed from: aH */
    private static final int f2192aH = 11;

    /* renamed from: aI */
    private static final int f2193aI = 12;

    /* renamed from: aJ */
    private static final int f2194aJ = 13;

    /* renamed from: aK */
    private static final int f2195aK = 14;

    /* renamed from: aL */
    private static final int f2196aL = 15;

    /* renamed from: aM */
    private static final int f2197aM = 16;

    /* renamed from: aN */
    private static final int f2198aN = 17;

    /* renamed from: aO */
    private static final int f2199aO = 18;

    /* renamed from: aP */
    private static final int f2200aP = 19;

    /* renamed from: aQ */
    private static final int f2201aQ = 20;

    /* renamed from: aR */
    private static final int f2202aR = 21;

    /* renamed from: aS */
    private static final int f2203aS = 22;

    /* renamed from: aT */
    private static final int f2204aT = 23;

    /* renamed from: aU */
    private static final int f2205aU = 24;

    /* renamed from: aV */
    private static final int f2206aV = 25;

    /* renamed from: aW */
    private static final int f2207aW = 26;

    /* renamed from: aX */
    private static final int f2208aX = 31;

    /* renamed from: aY */
    private static final int f2209aY = 32;

    /* renamed from: aZ */
    private static final int f2210aZ = 33;

    /* renamed from: aa */
    private static final int f2211aa = 310;

    /* renamed from: ab */
    private static final int f2212ab = 311;

    /* renamed from: ac */
    private static final int f2213ac = 399;

    /* renamed from: ad */
    private static final int f2214ad = 401;

    /* renamed from: ae */
    private static final int f2215ae = 402;

    /* renamed from: af */
    private static final int f2216af = 403;

    /* renamed from: ag */
    private static final int f2217ag = 405;

    /* renamed from: ah */
    private static final int f2218ah = 406;

    /* renamed from: ai */
    private static final int f2219ai = 407;

    /* renamed from: aj */
    private static final int f2220aj = 408;

    /* renamed from: ak */
    private static final int f2221ak = 409;

    /* renamed from: al */
    private static final int f2222al = 410;

    /* renamed from: am */
    private static final int f2223am = 411;

    /* renamed from: an */
    private static final int f2224an = 412;

    /* renamed from: ao */
    private static final int f2225ao = 413;

    /* renamed from: ap */
    private static final int f2226ap = 414;

    /* renamed from: aq */
    private static final int f2227aq = 416;

    /* renamed from: ar */
    private static final int f2228ar = 417;

    /* renamed from: as */
    private static final int f2229as = 418;

    /* renamed from: at */
    private static final int f2230at = 419;

    /* renamed from: au */
    private static final int f2231au = 420;

    /* renamed from: av */
    private static final int f2232av = 421;

    /* renamed from: aw */
    private static final int f2233aw = 422;

    /* renamed from: ax */
    private static final int f2234ax = 500;

    /* renamed from: ay */
    private static final int f2235ay = 501;

    /* renamed from: az */
    private static final int f2236az = 502;

    /* renamed from: bB */
    private static EngineInterface f2237bB = null;

    /* renamed from: bC */
    private static final int f2238bC = 1;

    /* renamed from: bD */
    private static final int f2239bD = 2;

    /* renamed from: bE */
    private static final String f2240bE = "1";

    /* renamed from: bF */
    private static final String f2241bF = "0";

    /* renamed from: bS */
    private static final int f2242bS = 10;

    /* renamed from: bT */
    private static final int f2243bT = 11;

    /* renamed from: ba */
    private static final int f2244ba = 34;

    /* renamed from: bb */
    private static final int f2245bb = 35;

    /* renamed from: bc */
    private static final int f2246bc = 36;

    /* renamed from: bd */
    private static final int f2247bd = 37;

    /* renamed from: be */
    private static final int f2248be = 38;

    /* renamed from: bf */
    private static final int f2249bf = 39;

    /* renamed from: bg */
    private static final int f2250bg = 40;

    /* renamed from: bh */
    private static final int f2251bh = 99;

    /* renamed from: bi */
    private static final int f2252bi = 200;

    /* renamed from: bj */
    private static final int f2253bj = 201;

    /* renamed from: bk */
    private static final int f2254bk = 202;

    /* renamed from: bl */
    private static final int f2255bl = 203;

    /* renamed from: bm */
    private static final int f2256bm = 212;

    /* renamed from: bn */
    private static final int f2257bn = 213;

    /* renamed from: bo */
    private static final int f2258bo = 214;

    /* renamed from: bp */
    private static final int f2259bp = 215;

    /* renamed from: bq */
    private static final int f2260bq = 216;

    /* renamed from: br */
    private static final int f2261br = 217;

    /* renamed from: bs */
    private static final int f2262bs = 218;

    /* renamed from: bt */
    private static final int f2263bt = 400;

    /* renamed from: bu */
    private static final int f2264bu = 500;

    /* renamed from: bv */
    private static final int f2265bv = 501;

    /* renamed from: bw */
    private static final int f2266bw = 502;

    /* renamed from: bx */
    private static final int f2267bx = 510;

    /* renamed from: by */
    private static final int f2268by = 999;

    /* renamed from: h */
    private static final int f2269h = 0;

    /* renamed from: i */
    private static final int f2270i = 1;

    /* renamed from: j */
    private static final int f2271j = 0;

    /* renamed from: k */
    private static final int f2272k = 1;

    /* renamed from: l */
    private static final int f2273l = 2;

    /* renamed from: m */
    private static final int f2274m = 3;

    /* renamed from: n */
    private static final int f2275n = 10;

    /* renamed from: o */
    private static final int f2276o = 11;

    /* renamed from: p */
    private static final int f2277p = 12;

    /* renamed from: q */
    private static final int f2278q = 13;

    /* renamed from: r */
    private static final int f2279r = 14;

    /* renamed from: s */
    private static final int f2280s = 15;

    /* renamed from: t */
    private static final int f2281t = 16;

    /* renamed from: u */
    private static final int f2282u = 17;

    /* renamed from: v */
    private static final int f2283v = 18;

    /* renamed from: w */
    private static final int f2284w = 19;

    /* renamed from: x */
    private static final int f2285x = 20;

    /* renamed from: y */
    private static final int f2286y = 21;

    /* renamed from: z */
    private static final int f2287z = 22;

    /* renamed from: bJ */
    private int f2293bJ;

    /* renamed from: c */
    private String f2304c;

    /* renamed from: d */
    private String f2305d;

    /* renamed from: f */
    private String f2307f;

    /* renamed from: g */
    private String f2308g;
    public static boolean isFrontCamera = true;
    public static boolean isConferenceCall = false;

    /* renamed from: b */
    private Context f2288b = MainApplication.mContext;

    /* renamed from: e */
    private String f2306e = "1234567890";
    public int engineState = 0;

    /* renamed from: bz */
    private boolean f2303bz = false;

    /* renamed from: bA */
    private AlarmManager f2289bA = null;

    /* renamed from: bG */
    private final HashMap f2290bG = new HashMap();

    /* renamed from: bH */
    private boolean f2291bH = false;

    /* renamed from: bI */
    private int f2292bI = 1;

    /* renamed from: bK */
    private boolean f2294bK = false;

    /* renamed from: bL */
    private EngineChattingCallbackInterface f2295bL = null;

    /* renamed from: bM */
    private EngineLoginCallbackInterface f2296bM = null;

    /* renamed from: bN */
    private EngineContactCallbackInterface f2297bN = null;

    /* renamed from: bO */
    private EngineSettingCallbackInterface f2298bO = null;

    /* renamed from: bP */
    private TranslationNotificationCallbackInterface f2299bP = null;

    /* renamed from: bQ */
    private EngineCallBackInterface f2300bQ = null;

    /* renamed from: bR */
    private PendingIntent f2301bR = null;

    /* renamed from: bU */
    private final Handler f2302bU = new HandlerC1132b(this);

    private EngineInterface() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m2028a() throws IOException {
        Log.m2967v("reqDestroyEngine()");
        if (this.engineState == 2 || this.engineState == 1) {
            m2057a(3);
            return m2037a(1, (Object) null, (Object) null, (Object) null, (Object) null);
        }
        Log.m2967v("reqDestroyEngine() : SMPUI_ERROR_ENGINE_STATE_MISMATCH. Just Return.");
        return -28;
    }

    /* renamed from: a */
    private int m2029a(int i, int i2, int i3) throws IOException {
        Log.m2967v("reqSetMicMute() : isMute = " + i);
        return m2037a(14, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), (Object) null);
    }

    /* renamed from: a */
    private int m2030a(int i, int i2, int i3, int i4) throws IOException {
        Log.m2967v("reqEmotionalAnimation() : nType = " + i);
        return m2037a(36, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    /* renamed from: a */
    private int m2031a(int i, int i2, int i3, int i4, int i5) {
        Log.m2958e("reqStartDualCamera() : callSessionID_arg = " + i + ", x:" + i2 + ", y:" + i3 + ", width:" + i4 + ", height:" + i5);
        return m2037a(f2219ai, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* renamed from: a */
    private int m2032a(int i, int i2, int i3, String str) throws IOException {
        Log.m2967v("reqHangUp()");
        return m2037a(12, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3));
    }

    /* renamed from: a */
    private int m2033a(int i, int i2, int i3, boolean z) throws IOException {
        Log.m2967v("reqStartShareScreen() : callSessionID_arg = " + i);
        return m2037a(405, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(z ? 1 : 0));
    }

    /* renamed from: a */
    private int m2034a(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        Log.m2967v("reqSendRotationInfo() : degree = " + i + " appRotate = " + z);
        return m2037a(25, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(((z2 ? 1 : 0) << 16) | (z ? 1 : 0)));
    }

    /* renamed from: a */
    private int m2035a(int i, int i2, String str) throws IOException {
        Log.m2967v("reqStartRecordCall() : callSessionID_arg = " + i + ", isVideo = " + i2);
        return m2037a(23, Integer.valueOf(i), Integer.valueOf(i2), str, (Object) null);
    }

    /* renamed from: a */
    private int m2036a(int i, int i2, boolean z, boolean z2) {
        byte[] byteArray;
        ProtoBufHandlerException e;
        m2071b("reqReceiveCall : isSIP : " + i + " callSessionID_arg : " + i2 + " useVideo : " + z);
        int i3 = z ? 2 : 1;
        byte[] bArr = (byte[]) null;
        try {
            byteArray = ProtoBufHandler.toByteArray(C1260a.m2985a());
        } catch (ProtoBufHandlerException e2) {
            byteArray = bArr;
            e = e2;
        }
        try {
            m2071b("<CIH> toByteArray() in reqReceiveCall()");
        } catch (ProtoBufHandlerException e3) {
            e = e3;
            e.printStackTrace();
            return m2037a(11, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), byteArray);
        }
        return m2037a(11, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), byteArray);
    }

    /* renamed from: a */
    private int m2037a(int i, Object obj, Object obj2, Object obj3, Object obj4) throws IOException {
        if (i != 0 && i != 1 && i != 27 && i != 28 && i != 32 && this.engineState != 2 && i != 41 && i != 42) {
            Log.m2967v("jniRequestEventWrapper : SMPUI_ERROR_ENGINE_STATE_MISMATCH : eventType = " + i);
            return -28;
        }
        this.f2293bJ = i;
        int iJniRequestEvent = jniRequestEvent(i, obj, obj2, obj3, obj4);
        if (i == 402 && iJniRequestEvent == -6) {
            iJniRequestEvent = 0;
        }
        if (iJniRequestEvent < 0) {
            Log.m2967v("jniRequestEventWrapper : eventType = " + i + ", result = " + iJniRequestEvent);
            if (i == 402) {
                notifyResponseEvent(f2259bp, 0, 0, -1, "", "", "", null, null, null);
            } else {
                notifyResponseEvent(20, iJniRequestEvent, 0, 0, null, null, null, null, null, null);
            }
        }
        return iJniRequestEvent;
    }

    /* renamed from: a */
    private int m2038a(int i, String str) {
        m2071b("reqRemoveP2PConfMember : callSessionID_arg : " + i + " userID : " + str);
        return m2037a(501, Integer.valueOf(i), str, (Object) null, (Object) null);
    }

    /* renamed from: a */
    private int m2039a(int i, String str, String str2) throws IOException {
        Log.m2967v("reqChangeToConference() sessionID:" + i + ", conferenceNo:" + str);
        return m2037a(401, Integer.valueOf(i), str, str2, (Object) null);
    }

    /* renamed from: a */
    private int m2040a(int i, String str, boolean z) throws IOException {
        Log.m2967v("reqSetReceivedPushMessage() : msg_len = " + str.length());
        return m2037a(33, Integer.valueOf(i), str, Integer.valueOf(z ? 1 : 0), (Object) null);
    }

    /* renamed from: a */
    private int m2041a(int i, ArrayList arrayList) throws IOException {
        Log.m2967v("reqStartFileTransfer() : callSessionID_arg = " + i + ", fileNameList.size = " + arrayList.size());
        Object[] objArr = new Object[arrayList.size() + 1];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            objArr[i2] = arrayList.get(i2);
        }
        return m2037a(21, Integer.valueOf(i), Integer.valueOf(arrayList.size()), objArr, (Object) null);
    }

    /* renamed from: a */
    private int m2042a(int i, boolean z) throws IOException {
        Log.m2967v("reqStopShareScreen() : callSessionID_arg = " + i);
        return m2037a(406, Integer.valueOf(i), Integer.valueOf(z ? 1 : 0), (Object) null, (Object) null);
    }

    /* renamed from: a */
    private int m2043a(int i, boolean z, int i2) {
        m2071b("haeri=reqSetModeChangeDuringShareScreen() : callSessionID_arg = " + i + "/remote?" + z + "/mode?" + i2);
        return m2037a(f2232av, Integer.valueOf(i), Integer.valueOf(z ? 1 : 0), Integer.valueOf(i2), (Object) null);
    }

    /* renamed from: a */
    private int m2044a(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) throws IOException {
        if (this.engineState != 0) {
            Log.m2967v("reqInitEngine() : SMPUI_ERROR_ENGINE_STATE_MISMATCH. Just Return.");
            return -28;
        }
        if (str.length() == 0 || str2.length() == 0) {
            Log.m2967v("reqInitEngine() : Invalid Argument");
            return -5;
        }
        Object[] objArr = {String.valueOf(j), str, String.valueOf(i), str2, str3, str4, str5, str6, str7, str8, str9, str10};
        m2057a(1);
        return m2037a(0, "Android", getInstance(), objArr, Integer.valueOf(MainApplication.mPhoneManager.getEngineLogLevelWithServerType()));
    }

    /* renamed from: a */
    private int m2046a(C1189D c1189d, String str, String str2, String str3, String str4, boolean z, String str5, int i, int i2, String str6, boolean z2) throws IOException {
        Log.m2967v("reqPlaceConferenceCall() : " + c1189d.f2598a + "," + c1189d.f2599b + "," + c1189d.f2600c + "," + c1189d.f2601d);
        Log.m2967v("reqPlaceConferenceCall() : " + str + "," + str2 + "," + str3 + "," + str4 + "," + z);
        Log.m2967v("reqPlaceConferenceCall() : " + str5 + "," + i + "," + i2 + ", " + z2);
        Object[] objArr = new Object[11];
        objArr[0] = c1189d.f2598a;
        objArr[1] = str2;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = str5;
        objArr[5] = str;
        objArr[6] = Integer.valueOf(c1189d.f2599b);
        objArr[7] = c1189d.f2600c;
        objArr[8] = Integer.valueOf(c1189d.f2601d);
        objArr[9] = str6;
        if (z2) {
            objArr[10] = 1;
        } else {
            objArr[10] = 0;
        }
        return m2037a(16, objArr, Integer.valueOf(z ? 2 : 1), Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: a */
    private int m2047a(String str, int i) throws IOException {
        Log.m2967v("reqSetStunInfo() : IP = " + str + ", Port = " + i);
        return m2037a(27, str, Integer.valueOf(i), (Object) null, (Object) null);
    }

    /* renamed from: a */
    private int m2048a(String str, int i, String str2, Object[] objArr) {
        return m2037a(402, str, Integer.valueOf(i), str2, objArr);
    }

    /* renamed from: a */
    private int m2049a(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, int i2) throws IOException {
        Log.m2967v("reqSetSipInfo()");
        return m2037a(3, new Object[]{str, str2, str3, str4, String.valueOf(i), str5, str6, str7, String.valueOf(i2)}, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: a */
    private int m2050a(String str, boolean z) throws IOException {
        Log.m2967v("reqPlaceSIPCall()");
        return m2037a(13, str, Integer.valueOf(z ? 2 : 1), (Object) null, (Object) null);
    }

    /* renamed from: a */
    private int m2051a(String str, boolean z, boolean z2, boolean z3, String str2) throws IOException {
        byte[] byteArray;
        ProtoBufHandlerException e;
        Log.m2967v("reqPlaceCall()");
        int i = z ? 2 : 1;
        String str3 = z2 ? "1" : "0";
        if (z3) {
            return m2037a(19, str, Integer.valueOf(i), str3, str2);
        }
        byte[] bArr = (byte[]) null;
        try {
            byteArray = ProtoBufHandler.toByteArray(C1260a.m2985a());
        } catch (ProtoBufHandlerException e2) {
            byteArray = bArr;
            e = e2;
        }
        try {
            m2071b("<CIH> toByteArray() in reqPlaceCall()");
        } catch (ProtoBufHandlerException e3) {
            e = e3;
            e.printStackTrace();
            return m2037a(10, str, Integer.valueOf(i), byteArray, str2);
        }
        return m2037a(10, str, Integer.valueOf(i), byteArray, str2);
    }

    /* renamed from: a */
    private int m2052a(List list, boolean z, boolean z2, List list2, String str, boolean z3) throws IOException {
        int i = 0;
        Log.m2967v("reqPlaceP2PCall()");
        int i2 = z ? 2 : 1;
        String str2 = z2 ? "1" : "0";
        Object[] objArr = new Object[list.size() + 1];
        objArr[0] = Integer.valueOf(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            objArr[i3 + 1] = list.get(i3);
        }
        if (z3) {
            Object[] objArr2 = new Object[list2.size() + 1];
            objArr2[0] = Integer.valueOf(list2.size());
            while (i < list2.size()) {
                objArr2[i + 1] = list2.get(i);
                i++;
            }
            return m2037a(502, objArr, Integer.valueOf(i2), str2, objArr2);
        }
        Object[] objArr3 = new Object[list2.size() + 2];
        objArr3[0] = Integer.valueOf(list2.size() + 1);
        objArr3[1] = str;
        while (i < list2.size()) {
            objArr3[i + 2] = list2.get(i);
            i++;
        }
        return m2037a(500, objArr, Integer.valueOf(i2), str2, objArr3);
    }

    /* renamed from: a */
    private int m2053a(boolean z) throws IOException {
        int i = z ? 1 : 0;
        Log.m2967v("reqSpeakerOn() : isOn = " + i);
        return m2037a(18, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: a */
    private int m2054a(boolean z, int i, int i2) throws IOException {
        int i3 = z ? 1 : 0;
        m2071b("<<YHT5>> reqHold!!!! isHold:" + i3);
        Log.m2967v("reqHold() : isHold = " + i3);
        return m2037a(17, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), (Object) null);
    }

    /* renamed from: a */
    private int m2055a(boolean z, int i, int i2, int i3) throws IOException {
        int i4 = z ? 1 : 0;
        m2071b("reqVideoHold!!!! isHold:" + i4 + " holdMode:" + i3);
        Log.m2967v("reqVideoHold() : isHold = " + i4 + " holdMode:" + i3);
        return m2037a(17, Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    /* renamed from: a */
    private int m2056a(boolean z, boolean z2, int i) {
        m2071b("reqRXMute: isMute:" + z);
        return m2037a(48, Integer.valueOf(z ? 1 : 0), Integer.valueOf(z2 ? 1 : 0), Integer.valueOf(i), (Object) null);
    }

    /* renamed from: a */
    private void m2057a(int i) {
        m2061a("setState() " + this.engineState + " >> " + i);
        this.engineState = i;
    }

    /* renamed from: a */
    private void m2058a(int i, int i2) throws IOException {
        if (i < 0) {
            return;
        }
        if (!m2092j(i)) {
            Log.m2967v("<handleResP2PConfInfo>Invalid call session id:" + i);
        } else if (this.f2300bQ != null) {
            m2061a("<<YHT10>> onP2PConfVoiceActivity callSessionID:" + i + ", activeID:" + i2);
            this.f2300bQ.onP2PConferenceVoiceActivity(i, i2);
        }
    }

    /* renamed from: a */
    private void m2059a(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) throws IOException {
        if (i < 0) {
            return;
        }
        if (!m2092j(i)) {
            Log.m2967v("<handleResP2PConfInfo>Invalid call session id:" + i);
            return;
        }
        if (this.f2300bQ != null) {
            m2071b("<<YHT10>> onP2PConfInfo callSessionID:" + i);
            ArrayList arrayList5 = new ArrayList();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                P2PUserInfo p2PUserInfo = new P2PUserInfo((String) arrayList2.get(i2), (String) arrayList3.get(i2), 1, 0, -1);
                if (i2 == 0) {
                    p2PUserInfo.userType = 0;
                }
                if (((Boolean) arrayList.get(i2)).booleanValue()) {
                    p2PUserInfo.userState = 1;
                }
                p2PUserInfo.surfaceID = ((Integer) arrayList4.get(i2)).intValue();
                arrayList5.add(p2PUserInfo);
            }
            this.f2300bQ.onP2PConferenceStatus(i, arrayList5);
        }
    }

    /* renamed from: a */
    private void m2060a(int i, boolean z, boolean z2, Date date, ArrayList arrayList, ArrayList arrayList2) throws IOException {
        Log.m2967v("----- handleResPlaceP2PConf ---------");
        Log.m2967v("callSessionID = " + i);
        Log.m2967v("video call = " + z2);
        Log.m2967v("membercount = " + arrayList.size());
        Log.m2967v("secure = " + z);
        Log.m2967v("callTime = " + date.toLocaleString());
        Log.m2967v("-------------------------------------");
        if (i < 0) {
            return;
        }
        if (!m2092j(i)) {
            m2093k(i);
        }
        if (this.f2300bQ != null) {
            m2071b("<<YHT10>> onIncomingP2PConfCall displayName:" + ((String) arrayList2.get(0)) + ", startTime:" + date.toLocaleString());
            if (this.f2300bQ.onIncomingP2PConfCall(i, z2, z, arrayList, arrayList2, date) != 0) {
                m2061a("<<YHT10>> onIncomingP2PConfCall ERROR!!!!!!");
                m2032a(0, i, 1001, "");
            }
        }
    }

    /* renamed from: a */
    private static void m2061a(String str) {
        Log.m2958e(f2184a + str);
    }

    /* renamed from: a */
    private void m2062a(byte[] bArr, byte[] bArr2) {
        StringBuilder sb = new StringBuilder();
        Log.m2958e("[CONSENT] receive handlePushProtocolBufferMessage");
        try {
            P2PMsg p2PMsgM2946a = C1258h.m2946a(bArr, bArr2, sb);
            Log.m2963i("<<YHT10>> handlePushProtocolBufferMessage step1");
            if (p2PMsgM2946a == null) {
                Log.m2958e("handlePushProtocolBufferMessage::p2pmsg is null");
                return;
            }
            Log.m2963i("<<YHT10>> handlePushProtocolBufferMessage step2");
            Log.m2967v("handlePushProtocolBufferMessage:svcCode = " + p2PMsgM2946a.getMsgHeader().getSvcCode() + ", msgCode = " + p2PMsgM2946a.getMsgHeader().getMsgCode());
            MsgBody msgBody = p2PMsgM2946a.getMsgBody();
            if (msgBody == null) {
                Log.m2958e("handlePushProtocolBufferMessage::MsgBody is null");
                return;
            }
            Log.m2963i("<<YHT10>> handlePushProtocolBufferMessage step3");
            if (this.f2298bO != null) {
                this.f2298bO.handleContactMessage(msgBody);
            }
            if (this.f2297bN != null) {
                this.f2297bN.handleContactMessage(msgBody);
            }
            if (this.f2295bL != null) {
                this.f2295bL.handleChattingMessage(msgBody);
            }
            if (msgBody instanceof NotifyConferenceEnterAsk) {
                Log.m2958e("Push message: NotifyConferenceEnterAsk");
                NotifyConferenceEnterAsk notifyConferenceEnterAsk = (NotifyConferenceEnterAsk) msgBody;
                String p2PKey = notifyConferenceEnterAsk.getP2PKey();
                if (notifyConferenceEnterAsk.getP2PKey() != null && !notifyConferenceEnterAsk.getP2PKey().isEmpty()) {
                    p2PKey = notifyConferenceEnterAsk.getP2PKey();
                }
                if (MainApplication.mPhoneManager.getClientType() != 2) {
                    this.f2300bQ.onConferenceEnterAsk(notifyConferenceEnterAsk.getConferenceNo(), p2PKey);
                    return;
                }
                if (notifyConferenceEnterAsk.getEventID().equals("") || notifyConferenceEnterAsk.getEventID() == null) {
                    Log.m2958e("[SSE] Event Id is Null ");
                    return;
                } else if (this.f2306e.equals(notifyConferenceEnterAsk.getEventID())) {
                    Log.m2958e("[SSE] Event Id check Success ");
                    this.f2300bQ.onConferenceEnterAsk(notifyConferenceEnterAsk.getConferenceNo(), p2PKey);
                    return;
                } else {
                    Log.m2958e("[SSE] Event Id check Fail ");
                    this.f2300bQ.onConferenceDenyEvent(notifyConferenceEnterAsk.getConferenceNo());
                    return;
                }
            }
            if (msgBody instanceof NotifyConferenceStatusAsk) {
                Log.m2958e("Push message: NotifyConferenceStatusAsk");
                this.f2300bQ.onConferenceStatusAsk(((NotifyConferenceStatusAsk) msgBody).getConferenceNo());
                return;
            }
            if (msgBody instanceof NotifyConferenceCloseAsk) {
                Log.m2958e("Push message: NotifyConferenceCloseAsk");
                this.f2300bQ.onConferenceCloseAsk(((NotifyConferenceCloseAsk) msgBody).getConferenceNo());
                return;
            }
            if (msgBody instanceof ChargeRep) {
                Log.m2958e("Push message: ChargeRep");
                return;
            }
            if (msgBody instanceof RejectMessageAsk) {
                RejectMessageAsk rejectMessageAsk = (RejectMessageAsk) msgBody;
                Log.m2958e("<<YHT10>> receive Reject Message!!!!!!!!");
                Log.m2958e("<<YHT10>> sender: " + rejectMessageAsk.getUserID());
                Log.m2958e("<<YHT10>> message: " + rejectMessageAsk.getRejectMessage());
                this.f2300bQ.onRejectMessage((RejectMessageAsk) msgBody);
                return;
            }
            if (msgBody instanceof NotifyStartShareScreenAsk) {
                Log.m2958e("Push message: NotifyStartShareScreenAsk");
                this.f2300bQ.onNotifyStartShareScreenAsk((NotifyStartShareScreenAsk) msgBody);
                return;
            }
            if (msgBody instanceof NotifyStopShareScreenAsk) {
                Log.m2958e("Push message: NotifyStopShareScreenAsk");
                this.f2300bQ.onNotifyStopShareScreenAsk((NotifyStopShareScreenAsk) msgBody);
                return;
            }
            if (msgBody instanceof NotifyBoardDataAsk) {
                Log.m2958e("Push message: NotifyBoardDataAsk");
                this.f2300bQ.onNotifyBoardDataAsk((NotifyBoardDataAsk) msgBody);
                return;
            }
            if (msgBody instanceof NotifyCloseCallAsk) {
                Log.m2958e("Push message: NotifyCloseCallAsk");
                this.f2300bQ.onNotifyCloseCallAsk((NotifyCloseCallAsk) msgBody);
                return;
            }
            if (msgBody instanceof ProposeConsentAsk) {
                Log.m2958e("[CONSENT] receive ProposeConsentAsk Engineinterface");
                this.f2300bQ.onProposeConsentAsk((ProposeConsentAsk) msgBody);
                return;
            }
            if (msgBody instanceof ProposeConsentRep) {
                Log.m2958e("[CONSENT] receive ProposeConsentRep Engineinterface");
                this.f2300bQ.onProposeConsentRep((ProposeConsentRep) msgBody);
                return;
            }
            if (msgBody instanceof RequestConsentAsk) {
                Log.m2958e("[CONSENT] receive RequestConsentAsk Engineinterface");
                this.f2300bQ.onRequestConsentAsk((RequestConsentAsk) msgBody);
                return;
            }
            if (msgBody instanceof RequestConsentRep) {
                Log.m2958e("[CONSENT] receive RequestConsentRep Engineinterface");
                this.f2300bQ.onRequestConsentRep((RequestConsentRep) msgBody);
            } else if (msgBody instanceof NotifyConsentAsk) {
                Log.m2958e("[CONSENT] receive NotifyConsentAsk Engineinterface");
                this.f2300bQ.onNotifyConsentAsk((NotifyConsentAsk) msgBody);
            } else {
                if (!(msgBody instanceof NotifyFinishShareCameraAsk)) {
                    Log.m2958e("Push message: none");
                    return;
                }
                Log.m2958e("[CONSENT] receive NotifyFinishShareCameraAsk Engineinterface");
                this.f2300bQ.onNotifyFinishShareCameraAsk((NotifyFinishShareCameraAsk) msgBody);
            }
        } catch (Exception e) {
            Log.m2958e("###############################################");
            Log.m2958e("Input Value : " + sb.toString());
            Log.m2958e("Detail exception explain" + e);
            Log.m2958e("###############################################");
        }
    }

    /* renamed from: b */
    private int m2063b(int i, int i2) {
        return m2037a(46, Integer.valueOf(i), Integer.valueOf(i2), (Object) null, (Object) null);
    }

    /* renamed from: b */
    private int m2064b(int i, int i2, int i3) throws IOException {
        Log.m2967v("reqNoiseReduction() : useNR = " + i);
        return m2037a(35, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), (Object) null);
    }

    /* renamed from: b */
    private int m2065b(int i, int i2, int i3, int i4) throws IOException {
        Log.m2967v("reqThemeShot() : nType = " + i);
        return m2037a(37, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    /* renamed from: b */
    private int m2066b(int i, int i2, int i3, int i4, int i5) {
        Log.m2958e("reqSwitchDualCamera() : callSessionID_arg = " + i + ", x:" + i2 + ", y:" + i3 + ", width:" + i4 + ", height:" + i5);
        return m2037a(f2228ar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* renamed from: b */
    private int m2067b(int i, String str) throws IOException {
        Log.m2967v("reqCaptureImageCall() : callSessionID_arg = " + i);
        return m2037a(300, Integer.valueOf(i), (Object) null, str, (Object) null);
    }

    /* renamed from: b */
    private int m2068b(int i, boolean z) throws IOException {
        Log.m2967v("reqPauseShareScreen() : callSessionID_arg = " + i + " isRemote : " + z);
        return m2037a(f2233aw, (Object) Integer.valueOf(i), (Object) Integer.valueOf(z ? 1 : 0), (Object) 1, (Object) null);
    }

    /* renamed from: b */
    private void m2069b() throws IOException {
        m2037a(34, (Object) null, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: b */
    private void m2070b(int i) {
        if (PhoneManager.mSupportTcp) {
            if (this.f2289bA == null) {
                this.f2289bA = (AlarmManager) MainApplication.mContext.getSystemService("alarm");
            }
            if (this.f2301bR != null) {
                this.f2289bA.cancel(this.f2301bR);
            }
            if (i > 1) {
                this.f2301bR = PendingIntent.getBroadcast(MainApplication.mContext, 0, new Intent(IntentName.ACTION_ALARM_GOES_OFF), 0);
                this.f2289bA.set(2, SystemClock.elapsedRealtime() + (i * 1000), this.f2301bR);
            }
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_KEEPALIVE);
        }
    }

    /* renamed from: b */
    private static void m2071b(String str) {
        Log.m2963i(f2184a + str);
    }

    /* renamed from: c */
    private int m2072c() {
        return m2037a(47, (Object) null, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: c */
    private int m2073c(int i) {
        return m2037a(f2220aj, (Object) 1, (Object) Integer.valueOf(i), (Object) null, (Object) null);
    }

    /* renamed from: c */
    private int m2074c(int i, int i2, int i3) throws IOException {
        Log.m2967v("reqCartoonView() : nType = " + i);
        return m2037a(40, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), (Object) null);
    }

    /* renamed from: c */
    private int m2075c(int i, int i2, int i3, int i4, int i5) {
        Log.m2958e("reqSetDualPosition() : callSessionID_arg = " + i + ", x:" + i2 + ", y:" + i3 + ", width:" + i4 + ", height:" + i5);
        return m2037a(f2229as, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* renamed from: c */
    private int m2076c(int i, String str) throws IOException {
        Log.m2967v("reqShareCaptureImageCall() : callSessionID_arg = " + i);
        return m2037a(f2212ab, Integer.valueOf(i), (Object) null, str, (Object) null);
    }

    /* renamed from: c */
    private int m2077c(int i, boolean z) throws IOException {
        Log.m2967v("reqResumeShareScreen() : callSessionID_arg = " + i + " isRemote : " + z);
        return m2037a(f2233aw, (Object) Integer.valueOf(i), (Object) Integer.valueOf(z ? 1 : 0), (Object) 0, (Object) null);
    }

    /* renamed from: c */
    private static void m2078c(String str) throws Throwable {
        Log.engine(str);
    }

    /* renamed from: d */
    private int m2079d(int i) {
        return m2037a(f2221ak, (Object) 1, (Object) Integer.valueOf(i), (Object) null, (Object) null);
    }

    /* renamed from: d */
    private int m2080d(int i, int i2, int i3) throws IOException {
        Log.m2967v("reqFaceEmotion() : nType = " + i);
        return m2037a(44, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), (Object) null);
    }

    /* renamed from: d */
    private int m2081d(int i, String str) throws IOException {
        Log.m2967v("reqCaptureMyImageCall() : callSessionID_arg = " + i);
        return m2037a(310, Integer.valueOf(i), (Object) null, str, (Object) null);
    }

    /* renamed from: d */
    private void m2082d(String str) {
        if (this.f2300bQ != null) {
            m2061a("<<YHT10>> onEngineDebugMsg msg:" + str);
            this.f2300bQ.onEngineDebugMsg(str);
        }
    }

    /* renamed from: e */
    private int m2083e(int i) {
        return m2037a(45, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: e */
    private int m2084e(int i, int i2, int i3) throws IOException {
        Log.m2967v("reqDtmf() : digitValue = " + i);
        return m2037a(15, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), (Object) null);
    }

    /* renamed from: e */
    private int m2085e(String str) throws IOException {
        Log.m2967v("reqSetPasswd()");
        return m2037a(2, str, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: f */
    private int m2086f(String str) {
        Log.m2958e("reqSetCipherKey()");
        return m2037a(41, str, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: f */
    private void m2087f(int i) throws IOException {
        m2037a(26, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: g */
    private int m2088g(int i) throws IOException {
        Log.m2967v("reqStopRecordCall() : callSessionID_arg = " + i);
        return m2037a(24, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: g */
    private int m2089g(String str) {
        Log.m2958e("reqSetSessionID()");
        return m2037a(42, str, (Object) null, (Object) null, (Object) null);
    }

    public static EngineInterface getInstance() {
        if (f2237bB == null) {
            f2237bB = new EngineInterface();
            MainApplication.mEngineLoader.loadEngine();
        }
        return f2237bB;
    }

    /* renamed from: h */
    private int m2090h(int i) {
        Log.m2958e("reqStopDualCamera() : callSessionID_arg = " + i);
        return m2037a(f2227aq, (Object) null, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: i */
    private int m2091i(int i) {
        Log.m2958e("reqEnablePreview");
        return m2037a(f2231au, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: j */
    private boolean m2092j(int i) {
        if (((Integer) this.f2290bG.get(new Integer(i))) != null) {
            return true;
        }
        m2071b("<<CALLID>> INVALID call id:" + i);
        return false;
    }

    private native void jniDeinitGlSurface();

    private native int jniGetCallDataTraffic(long[] jArr);

    private native int jniGetDecodedDataWithRGB565(int[] iArr, int i, int i2);

    private native void jniInitGlSurface(int i, int i2, int i3, int i4);

    private native int jniReleaseCamera();

    private native int jniRequestEvent(int i, Object obj, Object obj2, Object obj3, Object obj4);

    private native void jniSendRotationCmd(int i, int i2);

    private native int jniSetCamera(Camera camera);

    private native void jniSetMCUMode(int i);

    private native void jniSetRemoteSurface(Object obj);

    private native void jniSetStretchMode(int i);

    public static native void jniSetUseSECAudioEngine(int i);

    private native int jniSetVideoFormat(int i, int i2, int i3, int i4, int i5);

    private native int jniStartCameraRecord();

    private native void jniStepGlSurface();

    private native int jniStopCameraRecord();

    private native void jniUnSetRemoteSurface();

    /* renamed from: k */
    private void m2093k(int i) {
        m2071b("<<CALLID>> insert call id:" + i);
        this.f2290bG.put(new Integer(i), new Integer(i));
    }

    /* renamed from: l */
    private void m2094l(int i) {
        m2071b("<<CALLID>> remove call id:" + i);
        this.f2290bG.remove(new Integer(i));
    }

    /* renamed from: m */
    private void m2095m(int i) {
        switch (i) {
            case 0:
            case 2001:
                break;
            case 200:
                if (MainApplication.mInformationActivityGenerator != null) {
                    MainApplication.mInformationActivityGenerator.showInformationActivityForReceiverCallStateBusy();
                    break;
                }
                break;
            case 5003:
                MainApplication.mPopupCreator.authenticateFailurePPS();
                break;
            case 5006:
                MainApplication.mPopupCreator.needMoreMoney();
                break;
            case ErrorCode.PPS_BLOCKED_NUMBER /* 5020 */:
                MainApplication.mPopupCreator.tryBlockedNumber();
                break;
            case 10001:
                MainApplication.mPopupCreator.unableReachPPS();
                break;
            case 10006:
                MainApplication.mPopupCreator.unableGetSipNo();
                break;
            default:
                MainApplication.mPopupCreator.unknownError(i);
                break;
        }
    }

    /* renamed from: n */
    private int m2096n(int i) throws IOException {
        Log.m2967v("reqStopFileTransfer() : callSessionID_arg = " + i);
        return m2037a(22, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: o */
    private void m2097o(int i) throws IOException {
        if (i < 0 || i > 30) {
            return;
        }
        m2037a(43, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: p */
    private boolean m2098p(int i) {
        switch (i) {
            case 10:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 200:
            case 201:
            case 202:
            case 300:
            case 301:
            case 1000:
            case 1001:
            case 1002:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
            case Call.HANGUP_REASON_SIP_LOCAL_ERROR_NOT_CONNECTED /* 1100 */:
            case 1101:
            case 1200:
            case Call.HANGUP_REASON_SIP_SERVER_ERROR_CONNECTED /* 1201 */:
            case 10001:
            case 10005:
            case 10006:
            case 10007:
                return true;
            default:
                return false;
        }
    }

    public int EngineLog(int i, byte[] bArr) {
        return 0;
    }

    public String GetEventId() throws IOException {
        Log.m2967v("GetEventId");
        return this.f2306e;
    }

    public int GetIntInfo(int i) throws IOException {
        switch (i) {
            case 0:
            case 1:
                int callFrameSize = MainApplication.mConfig.getCallFrameSize(isFrontCamera);
                Log.m2967v("framesize = " + callFrameSize);
                return i == 0 ? MainApplication.mConfig.getFrameWidth(callFrameSize) : MainApplication.mConfig.getFrameHeight(callFrameSize);
            case 2:
                return MainApplication.mConfig.getCallFrameRate();
            case 3:
                return MainApplication.mConfig.getCallBandWidth();
            case 4:
                return MainApplication.mConfig.getQFactor();
            case 5:
                return MainApplication.mConfig.getVoiceCodec();
            case 6:
                return MainApplication.mConfig.getNS();
            case 7:
                return MainApplication.mConfig.getAEC();
            case 8:
                return MainApplication.mConfig.getVAD();
            case 9:
                return MainApplication.mConfig.getAudioSampleRate();
            case 10:
                return MainApplication.mConfig.getAudioRecordBufferSize();
            case 11:
                return MainApplication.mConfig.getAudioTrackBufferSize();
            case 12:
                return MainApplication.mConfig.getAudioDelay();
            case 13:
                return MainApplication.mConfig.getFEC();
            case 14:
                return (int) (MainApplication.mConfig.getSpeakerModeMicGain() * 100.0f);
            case 15:
                return MainApplication.mConfig.getSpeakerModeAgcValue();
            case 16:
                return (int) (MainApplication.mConfig.getNormalModeMicGain() * 100.0f);
            case 17:
                return MainApplication.mConfig.getNormalModeAgcValue();
            case 18:
                return MainApplication.mConfig.getMicVolume();
            case 19:
                return (int) (MainApplication.mConfig.getAudioVolume() * 100.0f);
            case 20:
                return (int) (MainApplication.mConfig.getNormalModeMicGainAfterAEC() * 100.0f);
            case 21:
                return (int) (MainApplication.mConfig.getSpeakerModeMicGainAfterAEC() * 100.0f);
            case 22:
                if (ModelInfoUtil.IS_MODEL_NEXUS_S || ModelInfoUtil.IS_MODEL_OPTIMUS2X) {
                    return 1;
                }
                if (ModelInfoUtil.IS_MODEL_GALAXY_S2) {
                    if (isConferenceCall) {
                        return 0;
                    }
                    return !isFrontCamera ? 3 : 1;
                }
                if (ModelInfoUtil.IS_MODEL_GALAXY_S && Build.VERSION.SDK_INT > 8) {
                    return !isFrontCamera ? 3 : 1;
                }
                return 0;
            case 23:
                return ((!ModelInfoUtil.IS_MODEL_GALAXY_S || Build.VERSION.SDK_INT > 8) && isFrontCamera) ? 1 : 0;
            case 24:
                return !ModelInfoUtil.IS_MODEL_GALAXY_S2 ? 0 : 1;
            case 25:
                return 16;
            case 26:
                return 48;
            case 27:
                return 0;
            case 28:
                return 1;
            case 29:
            case 30:
            case 31:
            case 32:
            default:
                return 100;
            case 33:
                return !PhoneManager.mSupportTcp ? 0 : 1;
            case 34:
                return 0;
            case 35:
                return !MainApplication.mConfig.isEmotionalEyeContact() ? 0 : 1;
            case 36:
                return MainApplication.mConfig.getSipDestPort();
            case 37:
                Log.m2967v("GetIntInfo() : EI_INT_INFO_CELLUAR_NETWORK : celluarNetwork = " + MainApplication.mPhoneManager.checkNetworkType(MainApplication.mContext));
                return MainApplication.mPhoneManager.checkNetworkType(MainApplication.mContext);
            case 38:
                int key = MsgKeyGenerator.getInstance().getKey();
                m2071b("EI_INT_INFO_CENTER_MSG_KEY----send key?" + key);
                return key;
            case 39:
                return MainApplication.mConfig.getCallDataSendInterval();
        }
    }

    public String GetLogDirectory() {
        return MainApplication.mContext.getFilesDir().getParent();
    }

    public int GetSAESVEConfigData(int i) {
        Log.m2958e("GetSAESVEConfigData called");
        return MainApplication.mConfig.setSAESVEConfigData(i);
    }

    public String GetStringInfo(int i, String str) throws IOException {
        Log.m2967v("GetStringInfo : type = " + i + ", arg1 = " + str);
        String networkOperator = ((TelephonyManager) this.f2288b.getSystemService("phone")).getNetworkOperator();
        switch (i) {
            case 0:
                String hostByName = getHostByName(str);
                Log.m2967v("EI_STRING_INFO_GET_HOST_BY_NAME : Host = " + hostByName);
                if (hostByName != null) {
                    return hostByName;
                }
                Log.m2967v("GetStringInfo() : Host is null");
                return "";
            case 1:
            case 2:
            case 3:
            default:
                Log.m2967v("default case in GetStringInfo()");
                return " ";
            case 4:
                Log.m2967v("EI_STRING_INFO_GET_ANI_CONF_PATH");
                String str2 = String.valueOf(MainApplication.mContext.getFilesDir().getAbsolutePath()) + "/" + ConfFileName.ANIMATION_CONFIG_DIR_PATH + "/" + ConfFileName.ANIMATION_CONFIG_FILE_NAME;
                Log.m2967v("EI_STRING_INFO_GET_ANI_CONF_PATH: " + str2);
                return str2;
            case 5:
                Log.m2967v("EI_STRING_INFO_GET_FACE_CONF_PATH");
                String str3 = String.valueOf(MainApplication.mContext.getFilesDir().getAbsolutePath()) + "/" + ConfFileName.FACE_EMOTION_CONFIG_DIR_PATH;
                Log.m2967v("EI_STRING_INFO_GET_FACE_CONF_PATH: " + str3);
                return str3;
            case 6:
                Log.m2967v("EI_STRING_INFO_SSE_EVENT_ID");
                if ("1234567890".equals(this.f2306e) || this.f2306e == null) {
                    Log.m2967v("EI_STRING_INFO_SSE_EVENT_ID is Default");
                    return "1234567890";
                }
                Log.m2967v("EI_STRING_INFO_SSE_EVENT_ID : " + this.f2306e);
                return this.f2306e;
            case 7:
                Log.m2967v("EI_STRING_INFO_MCC");
                if (networkOperator == null || networkOperator.isEmpty()) {
                    Log.m2967v("EI_STRING_INFO_MCC: null");
                    return "000";
                }
                if (networkOperator != null && networkOperator.length() > 3) {
                    String strSubstring = networkOperator.substring(0, 3);
                    this.f2307f = strSubstring;
                    return strSubstring;
                }
                return " ";
            case 8:
                Log.m2967v("EI_STRING_INFO_MNC");
                if (networkOperator == null || networkOperator.isEmpty()) {
                    Log.m2967v("EI_STRING_INFO_MNC: null");
                    return "00";
                }
                if (networkOperator != null && networkOperator.length() > 3) {
                    String strSubstring2 = networkOperator.substring(3);
                    this.f2308g = strSubstring2;
                    return strSubstring2;
                }
                return " ";
            case 9:
                Log.m2967v("EI_STRING_INFO_APPLICATION_ID");
                return MainApplication.mPhoneManager.getApplicationID();
            case 10:
                Log.m2967v("EI_STRING_INFO_APP_VERSION");
                return ModelInfoUtil.getAppVersion(MainApplication.mContext);
        }
    }

    public int NotifyAddressList(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.f2300bQ == null) {
            return 1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i3));
        arrayList.add(Integer.valueOf(i4));
        arrayList.add(Integer.valueOf(i5));
        arrayList.add(Integer.valueOf(i6));
        arrayList.add(Integer.valueOf(i7));
        this.f2300bQ.onRequestHipri(arrayList);
        return 1;
    }

    public void SetEventId(String str) throws IOException {
        Log.m2967v("SetEventId : " + str);
        this.f2306e = str;
    }

    public int captureImage(int i, boolean z, String str) {
        m2071b(" captureImage ");
        if (z || m2092j(i)) {
            this.f2305d = str;
            return m2067b(i, str);
        }
        m2061a(" captureImage Error!!! callID:" + i + " is invalid!!");
        return -1;
    }

    public void captureMyImage(int i, boolean z, String str) throws IOException {
        if (!z && !m2092j(i)) {
            m2061a(" captureImage Error!!! callID:" + i + " is invalid!!");
        } else {
            this.f2305d = str;
            m2081d(i, str);
        }
    }

    public void captureShareScreenImage(int i, boolean z, String str) throws IOException {
        m2071b(" captureShareImage ");
        if (!z && !m2092j(i)) {
            m2061a(" captureShareImage Error!!! callID:" + i + " is invalid!!");
        } else {
            this.f2305d = str;
            m2076c(i, str);
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int changeAvatarGlasses(boolean z, int i) {
        if (z || m2092j(i)) {
            return m2037a(414, Integer.valueOf(z ? 1 : 0), Integer.valueOf(i), (Object) null, (Object) null);
        }
        return -1;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int changeAvatarHair(boolean z, int i) {
        if (z || m2092j(i)) {
            return m2037a(413, Integer.valueOf(z ? 1 : 0), Integer.valueOf(i), (Object) null, (Object) null);
        }
        return -1;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void changeToConference(int i, String str, String str2) {
        if (m2092j(i)) {
            m2039a(i, str, str2);
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void changeToP2P(int i, String str, int i2, String str2, Object[] objArr) {
        m2071b("changeToP2P()  conferenc No : " + str + " p2p isCaller: " + i2);
        this.f2303bz = true;
        m2048a(str, i2, str2, objArr);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void clearAllPeerChannel() throws IOException {
        m2069b();
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int createCustomAvatar(boolean z, int i) {
        if (z || m2092j(i)) {
            return m2037a(412, Integer.valueOf(z ? 1 : 0), Integer.valueOf(i), (Object) null, (Object) null);
        }
        return -1;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void destrotyRenderer() {
        if (PhoneManager.getMediaEngineType() == 0) {
            jniDeinitGlSurface();
        } else {
            jniUnSetRemoteSurface();
        }
        C1131a.m2099a().m2100a(7);
    }

    public void destroy() {
        new Timer().schedule(new C1133c(this), 10L);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public long[] getCallDataTraffic() {
        long[] jArr = new long[7];
        jniGetCallDataTraffic(jArr);
        return jArr;
    }

    public String getCaptureImageName() {
        return this.f2305d;
    }

    public int getDecodedData(int[] iArr, int i, int i2) {
        return jniGetDecodedDataWithRGB565(iArr, i, i2);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public EngineCallBackInterface getEngineCallback() {
        return this.f2300bQ;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public TranslationNotificationCallbackInterface getEngineTranslationCallback() {
        return this.f2299bP;
    }

    public String getFileName() {
        return this.f2304c;
    }

    public String getHostByName(String str) throws UnknownHostException {
        try {
            InetAddress byName = InetAddress.getByName(str);
            Log.m2967v("getHostByName : " + byName.getHostName() + "=" + byName.getHostAddress());
            return byName.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getState() {
        m2061a("getState() return: " + this.engineState);
        return this.engineState;
    }

    public int handleP2PConfResponseEvent(C1263e c1263e) throws IOException {
        int i = 0;
        int i2 = c1263e.f3113a;
        int i3 = c1263e.f3114b;
        int i4 = c1263e.f3115c;
        int i5 = c1263e.f3116d;
        int i6 = c1263e.f3117e;
        int[] iArr = c1263e.f3118f;
        int[] iArr2 = c1263e.f3119g;
        String str = c1263e.f3120h;
        String[] strArr = c1263e.f3121i;
        String[] strArr2 = c1263e.f3122j;
        switch (i2) {
            case 500:
                if (strArr != null && strArr2 != null && strArr.length == i4 && strArr2.length == i4) {
                    boolean z = i5 == 1;
                    boolean z2 = i6 == 2;
                    Date date = new Date();
                    if (str != null && !str.isEmpty()) {
                        date = DateTimeUtil.toDate(str, "yyyy-MM-dd HH:mm:ss");
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (i < i4) {
                        arrayList.add(strArr[i]);
                        arrayList2.add(strArr2[i]);
                        i++;
                    }
                    m2060a(i3, z, z2, date, arrayList, arrayList2);
                    break;
                } else {
                    return 0;
                }
                break;
            case 501:
                if (iArr != null && iArr2 != null && strArr != null && strArr2 != null && iArr.length == i4 && iArr2.length == i4 && strArr.length == i4 && strArr2.length == i4) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    m2071b("size(intParam2) = " + i4);
                    while (i < i4) {
                        if (iArr[i] == 0) {
                            arrayList4.add(Boolean.FALSE);
                        } else {
                            arrayList4.add(Boolean.TRUE);
                        }
                        arrayList5.add(strArr[i]);
                        arrayList6.add(strArr2[i]);
                        arrayList3.add(Integer.valueOf(iArr2[i]));
                        m2071b("i = " + i + ", intArray[i] = " + iArr[i] + ", userList[i] = " + strArr[i] + ", nameList[i] = " + strArr2[i]);
                        i++;
                    }
                    m2059a(i3, arrayList4, arrayList5, arrayList6, arrayList3);
                    break;
                } else {
                    return 0;
                }
            case 502:
                m2071b("EI_RES_VOICE_ACTIVITY activeID = " + i4);
                m2058a(i3, i4);
                break;
        }
        return 1;
    }

    public void handlePushProtocolBuffermessageByPeer(int i, byte[] bArr, byte[] bArr2) {
        StringBuilder sb = new StringBuilder();
        Log.m2958e("[CONSENT] receive handlePushProtocolBuffermessageByPeer");
        try {
            P2PMsg p2PMsgM2946a = C1258h.m2946a(bArr, bArr2, sb);
            Log.m2958e("<<YHT10>> handlePushProtocolBuffermessageByPeer step1");
            if (p2PMsgM2946a == null) {
                Log.m2958e("handlePushProtocolBuffermessageByPeer::p2pmsg is null");
            } else {
                Log.m2958e("<<YHT10>> handlePushProtocolBuffermessageByPeer step2");
                Log.m2967v("handlePushProtocolBuffermessageByPeer svcCode = " + p2PMsgM2946a.getMsgHeader().getSvcCode() + ", msgCode = " + p2PMsgM2946a.getMsgHeader().getMsgCode());
                MsgBody msgBody = p2PMsgM2946a.getMsgBody();
                if (msgBody == null) {
                    Log.m2958e("handlePushProtocolBuffermessageByPeer::MsgBody is null");
                } else {
                    Log.m2958e("<<YHT10>> handlePushProtocolBuffermessageByPeer step3");
                    if (msgBody instanceof NotifyStartShareScreenAsk) {
                        Log.m2958e("Peer push message: NotifyStartShareScreenAsk");
                        NotifyStartShareScreenAsk notifyStartShareScreenAsk = (NotifyStartShareScreenAsk) msgBody;
                        notifyStartShareScreenAsk.setCallSessionID(i);
                        this.f2300bQ.onNotifyStartShareScreenAsk(notifyStartShareScreenAsk);
                    } else if (msgBody instanceof NotifyStopShareScreenAsk) {
                        Log.m2958e("Peer push message: NotifyStopShareScreenAsk");
                        NotifyStopShareScreenAsk notifyStopShareScreenAsk = (NotifyStopShareScreenAsk) msgBody;
                        notifyStopShareScreenAsk.setCallSessionID(i);
                        this.f2300bQ.onNotifyStopShareScreenAsk(notifyStopShareScreenAsk);
                    } else if (msgBody instanceof NotifyBoardDataAsk) {
                        Log.m2958e("Peer push message: NotifyBoardDataAsk");
                        NotifyBoardDataAsk notifyBoardDataAsk = (NotifyBoardDataAsk) msgBody;
                        notifyBoardDataAsk.setCallSessionID(i);
                        this.f2300bQ.onNotifyBoardDataAsk(notifyBoardDataAsk);
                    } else if (msgBody instanceof ReqAddConferenceMemberAsk) {
                        Log.m2958e("Peer push message: ReqAddConferenceMemberAsk");
                        ReqAddConferenceMemberAsk reqAddConferenceMemberAsk = (ReqAddConferenceMemberAsk) msgBody;
                        reqAddConferenceMemberAsk.setCallSessionID(i);
                        this.f2300bQ.onReqAddConferenceMemberAsk(reqAddConferenceMemberAsk);
                    } else if (msgBody instanceof ReqAddConferenceMemberRep) {
                        Log.m2958e("Peer push message: ReqAddConferenceMemberRep");
                        ReqAddConferenceMemberRep reqAddConferenceMemberRep = (ReqAddConferenceMemberRep) msgBody;
                        reqAddConferenceMemberRep.setCallSessionID(i);
                        this.f2300bQ.onReqAddConferenceMemberRep(reqAddConferenceMemberRep);
                    } else if (msgBody instanceof ProposeConsentAsk) {
                        Log.m2958e("[CONSENT] receive ProposeConsentAsk");
                        ProposeConsentAsk proposeConsentAsk = (ProposeConsentAsk) msgBody;
                        proposeConsentAsk.setCallSessionID(i);
                        this.f2300bQ.onProposeConsentAsk(proposeConsentAsk);
                    } else if (msgBody instanceof ProposeConsentRep) {
                        Log.m2958e("[CONSENT] receive ProposeConsentRep Engineinterface");
                        ProposeConsentRep proposeConsentRep = (ProposeConsentRep) msgBody;
                        proposeConsentRep.setCallSessionID(i);
                        this.f2300bQ.onProposeConsentRep(proposeConsentRep);
                    } else if (msgBody instanceof RequestConsentAsk) {
                        Log.m2958e("[CONSENT] receive RequestConsentAsk");
                        RequestConsentAsk requestConsentAsk = (RequestConsentAsk) msgBody;
                        requestConsentAsk.setCallSessionID(i);
                        this.f2300bQ.onRequestConsentAsk(requestConsentAsk);
                    } else if (msgBody instanceof RequestConsentRep) {
                        Log.m2958e("[CONSENT] receive RequestConsentRep");
                        RequestConsentRep requestConsentRep = (RequestConsentRep) msgBody;
                        requestConsentRep.setCallSessionID(i);
                        this.f2300bQ.onRequestConsentRep(requestConsentRep);
                    } else if (msgBody instanceof NotifyConsentAsk) {
                        Log.m2958e("[CONSENT] receive NotifyConsentAsk");
                        NotifyConsentAsk notifyConsentAsk = (NotifyConsentAsk) msgBody;
                        notifyConsentAsk.setCallSessionID(i);
                        this.f2300bQ.onNotifyConsentAsk(notifyConsentAsk);
                    } else if (msgBody instanceof RecognitionAsk) {
                        m2071b("Peer push message: RecognitionAsk");
                        this.f2299bP.onReceiveRecognitionAsk((RecognitionAsk) msgBody);
                    } else if (msgBody instanceof RecognitionRep) {
                        m2071b("Peer push message: RecognitionRep");
                        this.f2299bP.onReceiveRecognitionRep((RecognitionRep) msgBody);
                    } else if (msgBody instanceof TranslationAsk) {
                        m2071b("Peer push message: TranslationAsk");
                        this.f2299bP.onReceiveTranslationAsk((TranslationAsk) msgBody);
                    } else if (msgBody instanceof TranslationRep) {
                        m2071b("Peer push message: TranslationRep");
                        this.f2299bP.onReceiveTranslationRep((TranslationRep) msgBody);
                    } else if (msgBody instanceof TTSAsk) {
                        m2071b("Peer push message: TTSAsk");
                        this.f2299bP.onReceiveTTSAsk((TTSAsk) msgBody);
                    } else if (msgBody instanceof TTSRep) {
                        m2071b("Peer push message: TTSRep");
                        this.f2299bP.onReceiveTTSRep((TTSRep) msgBody);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.m2958e("###############################################");
            Log.m2958e("Input Value : " + sb.toString());
            Log.m2958e("Detail exception explain" + e);
            Log.m2958e("###############################################");
        }
    }

    public int handleResponseEvent(C1262d c1262d) throws IOException {
        int i = c1262d.f3103a;
        int i2 = c1262d.f3104b;
        int i3 = c1262d.f3105c;
        int i4 = c1262d.f3106d;
        String str = c1262d.f3107e;
        String str2 = c1262d.f3108f;
        String str3 = c1262d.f3109g;
        String str4 = c1262d.f3110h;
        byte[] bArr = c1262d.f3111i;
        byte[] bArr2 = c1262d.f3112j;
        if (i != 2) {
            Log.m2967v("notifyResponseEvent : eventType = " + i);
        }
        switch (i) {
            case 0:
                Log.m2967v("EI_RES_INIT_ENGINE");
                m2057a(2);
                MainApplication.mPhoneManager.setEngineLogLevelWithServerType();
                if (PhoneManager.isNetworkConnected(MainApplication.mContext)) {
                    if (this.f2296bM != null) {
                        this.f2296bM.onLoginSuccess();
                        break;
                    }
                } else if (this.f2296bM != null) {
                    this.f2296bM.onAbnormalLogout(EventCode.EVENT_LOGIN_HALF_FINISH);
                    break;
                }
                break;
            case 1:
                Log.m2967v("EI_RES_DESTROY_ENGINE");
                m2057a(0);
                if (this.f2296bM != null) {
                    this.f2296bM.onLogoutSuccess();
                    break;
                }
                break;
            case 2:
                m2070b(i2);
                break;
            case 10:
            case 18:
                int i5 = i2 == 0 ? 1 : 0;
                boolean z = i4 == 2;
                boolean z2 = i != 10;
                if (i5 != 1) {
                    String str5 = str3 == null ? "" : str3;
                    Log.m2967v("callSessionID = " + i3);
                    Log.m2967v("mediaType = " + i4);
                    Log.m2967v("callToID = " + str);
                    Log.m2967v("useVideo = " + z);
                    Log.m2967v("secure = " + str2);
                    Log.m2967v("displayName = " + str5);
                    Log.m2967v("callTime = " + str4);
                    if (i3 >= 0) {
                        if (!m2092j(i3)) {
                            m2093k(i3);
                        }
                        if (this.f2300bQ != null) {
                            boolean z3 = "1".equals(str2);
                            Date date = new Date();
                            if (str4 != null && !str4.isEmpty()) {
                                date = DateTimeUtil.toDate(str4, "yyyy-MM-dd HH:mm:ss");
                            }
                            m2071b("<<YHT10>> onIncomingCall displayName:" + str5 + ", startTime:" + date.toLocaleString());
                            if (this.f2300bQ.onIncomingCall(i3, str, (short) i2, z, true, z3, z2, str5, date) != 0) {
                                m2061a("<<YHT10>> onIncomingCall ERROR!!!!!!");
                                m2032a(i5, i3, 1001, "");
                            }
                            FeatureInfoAsk featureInfoAskM2986a = C1260a.m2986a(bArr);
                            m2071b("<CIH> EI_RES_PLACE_CALL");
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(featureInfoAskM2986a);
                            this.f2300bQ.onReceiveFeatureInfo(arrayList);
                            break;
                        }
                    }
                } else {
                    Log.m2967v("useVideo = " + z);
                    if (this.f2300bQ != null && this.f2300bQ.onIncomingCall(0, str, (short) i2, z, false, false, z2, "", new Date()) != 0) {
                        m2032a(i5, 0, 1001, "");
                        break;
                    }
                }
                break;
            case 11:
                if (m2092j(i2) && this.f2300bQ != null) {
                    this.f2300bQ.onReceiveP2PHandshaking(i2, true);
                    break;
                }
                break;
            case 12:
                int i6 = i2 == 0 ? 1 : 0;
                if (i2 == 0) {
                    i6 = 1;
                }
                Log.m2958e("isSIP = " + i6);
                Log.m2958e("callSessionID = " + i3);
                Log.m2958e("iUseVideo = " + i4);
                boolean z4 = i4 == 1;
                boolean z5 = false;
                if (i6 == 1) {
                    i3 = 0;
                } else if (i3 >= 0) {
                    boolean z6 = "1".equals(str2);
                    if (!m2092j(i3)) {
                        m2032a(0, i3, 1001, "");
                        break;
                    } else {
                        z5 = z6;
                    }
                }
                if (this.f2300bQ != null && this.f2300bQ.onReceiveCall(i3, (short) i2, z4, z5) == 0) {
                    FeatureInfoAsk featureInfoAskM2986a2 = C1260a.m2986a(bArr);
                    m2071b("<CIH> EI_RES_RECEIVE_CALL");
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(featureInfoAskM2986a2);
                    this.f2300bQ.onReceiveFeatureInfo(arrayList2);
                    break;
                }
                break;
            case 13:
                m2061a("EI_RES_RECEIVE_CALL_ACK");
                break;
            case 14:
                m2061a(" EI_RES_HANG_UP");
                m2061a("isSIP = " + i2);
                m2061a("callSessionID = " + i3);
                m2061a("errorCode = " + i4);
                if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording()) {
                    try {
                        MainApplication.mContext.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (i2 == 1) {
                    i3 = 0;
                } else if (!this.f2303bz) {
                    if (i3 >= 0 && m2092j(i3)) {
                        if (i4 == 301) {
                            m2061a("<<YHT>> THIS CALL IS BLOCKED CALL");
                            break;
                        } else {
                            m2094l(i3);
                        }
                    }
                }
                this.f2303bz = false;
                if ((this.f2300bQ != null ? m2098p(i4) ? this.f2300bQ.onHangUpCall(i3, i4, str) : this.f2300bQ.onHangUpCall(i3, -1, str) : -1002) == 0) {
                    m2095m(i4);
                    break;
                }
                break;
            case 15:
                Log.m2967v("EI_RES_SIP_CALL_STATE");
                Log.m2967v("msgCode = " + i2);
                Log.m2967v("role = " + i3);
                Log.m2967v("stateString = " + str);
                if (i3 != 1) {
                    switch (i2) {
                        case EngineCallBackInterface.SIP_RINGTONE_NONE /* 180 */:
                        case EngineCallBackInterface.SIP_RINGTONE_CUSTOM /* 183 */:
                            this.f2300bQ.onReceiveSipRingToneType(0, i2);
                            break;
                    }
                }
                break;
            case 16:
                Log.m2967v("EI_RES_HOLD");
                boolean z7 = i3 == 1;
                Log.m2967v("callSessionID = " + i2);
                Log.m2967v("isHold = " + z7);
                if (i2 >= 0) {
                    if (i2 != 0 && !m2092j(i2)) {
                        m2032a(0, i2, 1001, "");
                        break;
                    } else if (this.f2300bQ != null && this.f2300bQ.onP2pHoldReceived(i2, z7) == 0 && !z7) {
                        m2083e(i2);
                        m2029a(this.f2300bQ.isMuteCall(i2) ? 1 : 0, 0, i2);
                        break;
                    }
                }
                break;
            case 17:
                Log.m2967v("EI_RES_CALL_SET_MODE");
                break;
            case 19:
                if (i2 == 1) {
                    i3 = 0;
                }
                if (this.f2300bQ != null) {
                    this.f2300bQ.onCameraError(i3);
                    break;
                }
                break;
            case 20:
                m2061a("EI_RES_ERROR : ERROR CODE = " + i2 + ", LAST REQUEST = " + this.f2293bJ);
                if (i2 != -1 || (!str.equals(String.valueOf(ErrorCode.ERR_CENTER_ENCRYPT)) && !str.equals(String.valueOf(ErrorCode.ERR_CENTER_NONCE_REFRESH_NEEDED)) && !str.equals(String.valueOf(10002)))) {
                    if (this.f2293bJ != 0 && this.f2293bJ != 27 && this.f2293bJ != 28) {
                        if (this.f2293bJ == 300 && this.f2300bQ != null) {
                            this.f2300bQ.onPreviewCaptureError(i2, i4 >= 0);
                        }
                        switch (i2) {
                            case SMPUI_ERROR_NOTAVAILABLEP2PSESSION /* -26 */:
                            case -13:
                                if (i2 == -13) {
                                    EventTraceUtil.writeEventTrace(10);
                                } else if (i2 == -26) {
                                    EventTraceUtil.writeEventTrace(9);
                                }
                                if (this.f2293bJ == 10 || this.f2293bJ == 25 || this.f2293bJ == f2213ac) {
                                    m2061a("!!! EI_REQ_PLACE_CALL FAIL !!!");
                                    if (this.f2291bH) {
                                        this.f2292bI = -26;
                                        if (MainApplication.mInformationActivityGenerator != null) {
                                            MainApplication.mInformationActivityGenerator.showInformationActivityForNetworkError();
                                            break;
                                        }
                                    } else if ((this.f2300bQ != null ? this.f2300bQ.onError(i3, 0) : 0) == 0) {
                                        m2071b("critical update: " + i4);
                                        if (MainApplication.mInformationActivityGenerator != null) {
                                            if (i4 == -200) {
                                                MainApplication.mInformationActivityGenerator.showInformationActivityForCriticalUpdate();
                                                break;
                                            } else {
                                                MainApplication.mInformationActivityGenerator.showInformationActivityForNetworkError();
                                                break;
                                            }
                                        }
                                    }
                                } else if (i3 > 0 && m2092j(i3)) {
                                    m2094l(i3);
                                    this.f2303bz = false;
                                    if (this.f2300bQ != null) {
                                        this.f2300bQ.onError(i3, 1);
                                        break;
                                    }
                                }
                                break;
                            case SMPUI_ERROR_NOTAVAILABLERELAY /* -25 */:
                                EventTraceUtil.writeEventTrace(12);
                                m2061a("ERROR2. NOT AVAILABLE NETWORK DETECTED BY ENGINE");
                                if (this.f2296bM != null && PhoneManager.mSupportTcp) {
                                    this.f2296bM.onAbnormalLogout(EventCode.EVENT_LOGIN_ABNORMAL_TERMINATE);
                                }
                                if (this.f2300bQ != null) {
                                    this.f2300bQ.onError(ErrorCode.ERR_NOT_AVALIABLE_NETWORK, 0);
                                    break;
                                }
                                break;
                            case -4:
                                EventTraceUtil.writeEventTrace(11);
                                if (this.f2293bJ == 13 || this.f2293bJ == 25) {
                                    m2061a("!!! EI_REQ_PLACE_SIP_CALL FAIL !!!");
                                    if (this.f2296bM != null && PhoneManager.mSupportTcp) {
                                        this.f2296bM.onAbnormalLogout(EventCode.EVENT_LOGIN_ABNORMAL_TERMINATE);
                                    }
                                    if (this.f2300bQ != null) {
                                        this.f2300bQ.onError(ErrorCode.ERR_NOT_AVALIABLE_NETWORK, 0);
                                        break;
                                    }
                                }
                                break;
                            case -3:
                                EventTraceUtil.writeEventTrace(7);
                                m2061a("SLBY_logiN ERROR2. NOT AVAILABLE NETWORK DETECTED BY ENGINE");
                                if (this.f2296bM != null && PhoneManager.mSupportTcp) {
                                    this.f2296bM.onAbnormalLogout(EventCode.EVENT_LOGIN_ABNORMAL_TERMINATE);
                                }
                                if (this.f2300bQ != null) {
                                    this.f2300bQ.onError(ErrorCode.ERR_NOT_AVALIABLE_NETWORK, 0);
                                    break;
                                }
                                break;
                            case -1:
                                EventTraceUtil.writeEventTrace(8);
                                if (str.equals(String.valueOf(ErrorCode.ERR_CENTER_LOST_PHONE_NUMBER))) {
                                    m2061a("SLBY_logiN ERROR2. NOT AVAILABLE NETWORK DETECTED BY ENGINE");
                                    if (this.f2296bM != null && PhoneManager.mSupportTcp) {
                                        this.f2296bM.onAbnormalLogout(EventCode.EVENT_LOGIN_ABNORMAL_TERMINATE);
                                    }
                                    Process.killProcess(Process.myPid());
                                    break;
                                } else if (str.equals(String.valueOf(ErrorCode.ERR_MSGKEY_DUPLICATED))) {
                                    m2071b("ErrorCode.ERR_MSGKEY_DUPLICATED");
                                    MainApplication.mConfig.setCipherKey("");
                                    MainApplication.mConfig.setSessionID("");
                                    MainApplication.mPhoneManager.getLoginManager().sendCipherKeyAsk();
                                    break;
                                } else if (str.equals(String.valueOf(ErrorCode.ERR_MSGKEY_TOO_OLD))) {
                                    m2071b("ErrorCode.ERR_MSGKEY_TOO_OLD");
                                    MainApplication.mConfig.setCipherKey("");
                                    MainApplication.mConfig.setSessionID("");
                                    MainApplication.mPhoneManager.getLoginManager().sendCipherKeyAsk();
                                    break;
                                }
                                break;
                        }
                    } else {
                        if (this.f2293bJ == 0) {
                            EventTraceUtil.writeEventTrace(13);
                        } else if (this.f2293bJ == 27) {
                            EventTraceUtil.writeEventTrace(14);
                        } else if (this.f2293bJ == 28) {
                            EventTraceUtil.writeEventTrace(15);
                        }
                        m2061a("ERROR1. WHERE DOING logiN ");
                        m2057a(2);
                        if (this.f2296bM != null) {
                            this.f2296bM.onAbnormalLogout(EventCode.EVENT_LOGIN_ABNORMAL_TERMINATE);
                            break;
                        }
                    }
                } else {
                    MainApplication.mConfig.setCipherKey("");
                    MainApplication.mConfig.setSessionID("");
                    MainApplication.mPhoneManager.getLoginManager().setNonce("");
                    MainApplication.mPhoneManager.getLoginManager().logout(true);
                    break;
                }
                break;
            case 21:
                Log.m2967v("EI_RES_BYPASS");
                break;
            case 22:
                Log.m2967v("EI_RES_SIP_NUMBER_ASSIGN_INFO");
                Log.m2967v("assignType = " + i2);
                if (i2 != 0) {
                    MainApplication.mConfig.setSipIdSendOnly("");
                    break;
                } else if (str != null && !str.equals("")) {
                    MainApplication.mConfig.setSipIdSendOnly(str);
                    break;
                }
                break;
            case 23:
                Log.m2967v("EI_RES_FILE_TRANSFER_PROGRESS");
                byte b = bArr[0];
                byte b2 = bArr[1];
                byte b3 = bArr[2];
                Log.m2967v("callSessionID = " + i2 + "currentPacket = " + i3 + ", totalPacket = " + i4 + ", curFilePos = " + ((int) b2) + ", totalFileNum = " + ((int) b3));
                Log.m2967v("fileName1 = " + str + "fileName2 = " + str2 + ", fileName3 = " + str3);
                if (this.f2300bQ != null) {
                    if (i3 == 1 && b2 == 1) {
                        if (b == 1) {
                            this.f2300bQ.onSendFileStart(i2);
                            break;
                        } else {
                            this.f2300bQ.onRecvFileStart(i2, b3);
                            break;
                        }
                    } else if (i3 == i4 && b2 == b3) {
                        if (b == 1) {
                            this.f2300bQ.onSendFileDone(i2);
                            break;
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            if (b3 > 0) {
                                arrayList3.add(str);
                            }
                            if (b3 > 1) {
                                arrayList3.add(str2);
                            }
                            if (b3 > 2) {
                                arrayList3.add(str3);
                            }
                            this.f2300bQ.onRecvFileDone(i2, arrayList3);
                            break;
                        }
                    }
                }
                break;
            case 24:
                Log.m2967v("EI_RES_FILE_TRANSFER_STATUS");
                if (this.f2295bL != null) {
                    this.f2295bL.setFileCompleteInfo(str3, str, str2, i2);
                }
                Log.m2967v("transferStatus = " + i2 + ", peerID = " + str + ", filePath = " + str2 + ", key = " + str3);
                break;
            case 25:
                Log.m2967v("EI_RES_SET_STUN_INFO");
                ArrayList arrayListServerInfo = MainApplication.mPhoneManager.getLoginManager().serverInfo();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= arrayListServerInfo.size()) {
                        break;
                    } else {
                        Server server = (Server) arrayListServerInfo.get(i8);
                        if (server.getServerType().equals("ST")) {
                            m2047a(server.getIP(), server.getPort());
                            break;
                        } else {
                            i7 = i8 + 1;
                        }
                    }
                }
            case 26:
                Log.m2967v("EI_RES_SET_RELAY_INFO");
                int i9 = 0;
                ArrayList arrayListServerInfo2 = MainApplication.mPhoneManager.getLoginManager().serverInfo();
                int i10 = 0;
                while (true) {
                    int i11 = i10;
                    if (i11 >= arrayListServerInfo2.size()) {
                        int i12 = 0;
                        for (int i13 = 0; i13 < arrayListServerInfo2.size(); i13++) {
                            Server server2 = (Server) arrayListServerInfo2.get(i13);
                            String serverType = server2.getServerType();
                            if (serverType.equals("UR") || serverType.equals("TR")) {
                                reqSetRelayInfo(i9, i12, serverType, server2.getIP(), server2.getPort(), server2.getPriority(), server2.getCipherKey());
                                i12++;
                            }
                        }
                        break;
                    } else {
                        String serverType2 = ((Server) arrayListServerInfo2.get(i11)).getServerType();
                        if (serverType2.equals("UR") || serverType2.equals("TR")) {
                            i9++;
                        }
                        i10 = i11 + 1;
                    }
                }
                break;
            case 31:
                Log.m2967v("EI_RES_SET_CONNSERVER_INFO");
                int i14 = 0;
                ArrayList arrayListServerInfo3 = MainApplication.mPhoneManager.getLoginManager().serverInfo();
                int i15 = 0;
                while (true) {
                    int i16 = i15;
                    if (i16 >= arrayListServerInfo3.size()) {
                        int i17 = 0;
                        for (int i18 = 0; i18 < arrayListServerInfo3.size(); i18++) {
                            Server server3 = (Server) arrayListServerInfo3.get(i18);
                            if (server3.getServerType().equals("CN")) {
                                int iIntValue = CONNECTION_SERVER_DEFAULT_SUB_PORT;
                                if (server3.getSubPort() != null) {
                                    iIntValue = server3.getSubPort().intValue();
                                }
                                reqSetConnServerInfo(i14, i17, server3.getIP(), server3.getPort(), server3.getPriority(), iIntValue, server3.getCipherKey());
                                i17++;
                            }
                        }
                        break;
                    } else {
                        if (((Server) arrayListServerInfo3.get(i16)).getServerType().equals("CN")) {
                            i14++;
                        }
                        i15 = i16 + 1;
                    }
                }
            case 32:
                m2061a("EI_RES_CALL_START_TIME");
                if (!this.f2303bz && !m2092j(i2)) {
                    m2061a("callSessionID is invalid!!");
                    break;
                } else {
                    m2061a("callSessionID = " + i2 + " , callStartTime = " + str);
                    if (this.f2300bQ != null) {
                        this.f2300bQ.onReceiveCallTime(i2, DateTimeUtil.toDate(str, "yyyy-MM-dd HH:mm:ss"));
                        break;
                    }
                }
                break;
            case 33:
                m2061a("EI_RES_CALL_TRY_PUSH");
                if (this.f2300bQ != null) {
                    this.f2300bQ.onTryCallPush(i2);
                    break;
                }
                break;
            case 34:
                this.f2300bQ.onCallNotifyNetworkWeakReceive(i2);
                break;
            case 35:
                this.f2300bQ.onNotifyConfLayoutUserInformation(i2, i3, i4, str, str2, str3);
                break;
            case 36:
                Log.m2967v(" EI_RES_TAKE_PICTURE_DONE--->success");
                if (i2 == 1) {
                    i3 = 0;
                }
                if (this.f2300bQ != null) {
                    this.f2300bQ.onPreviewCaptureImage(i3, true);
                    break;
                }
                break;
            case 37:
                Log.m2967v(" EI_RES_TAKE_PICTURE_ERROR--->fail");
                if (i2 == 1) {
                    i3 = 0;
                }
                if (this.f2300bQ != null) {
                    this.f2300bQ.onPreviewCaptureImage(i3, false);
                    break;
                }
                break;
            case 38:
                if (i2 == 1) {
                    i3 = 0;
                }
                if (this.f2300bQ != null) {
                    this.f2300bQ.onShareScreenCaptureError(i3, false);
                    break;
                }
                break;
            case 39:
                if (i2 == 1) {
                    i3 = 0;
                }
                if (this.f2300bQ != null) {
                    this.f2300bQ.onShareScreenCaptureError(i3, true);
                    break;
                }
                break;
            case 40:
                m2071b("haeri=EI_RES_CAMERA_START_ERROR");
                if (this.f2300bQ != null) {
                    this.f2300bQ.onCameraStartErrorReceived();
                    break;
                }
                break;
            case f2251bh /* 99 */:
                Log.m2967v("EI_RES_BYPASS_PB_TEST");
                m2062a(bArr, bArr2);
                break;
            case 200:
                Log.m2967v("EI_RES_SET_REMOTEROTATION, rotation = " + i2 + ", surfID = " + i4);
                if (this.f2300bQ != null) {
                    this.f2300bQ.onRemoteRotationInfo(i3, i2, i4);
                    break;
                }
                break;
            case 201:
                Log.m2967v("EI_RES_SET_VIDEORECORD_START");
                if (this.f2300bQ != null) {
                    this.f2300bQ.onRemoteVideoRecrodInfo(i3, true);
                    break;
                }
                break;
            case 202:
                Log.m2967v("EI_RES_RECORD_ERROR, CallID: " + i3 + ", ErrorCode: " + i2);
                if (i2 == 0 || i2 == 4 || i2 == 1 || i2 == 5) {
                    this.f2300bQ.onError(i3, i2 == 0 ? 5 : (i2 == 1 || i2 == 5) ? 6 : i2);
                    break;
                }
                break;
            case 203:
                Log.m2967v("EI_RES_REMOTE_CAPTURE_IMAGE");
                if (this.f2300bQ != null) {
                    this.f2300bQ.onRemoteVideoCaptureImage(i3);
                    break;
                }
                break;
            case f2256bm /* 212 */:
                this.f2300bQ.onShareViewEndNotifyReceive(i2);
                break;
            case f2257bn /* 213 */:
                m2061a("EI_RES_CHANGE_TO_CONFERENCE");
                if (i2 >= 0 && m2092j(i2)) {
                    m2094l(i2);
                    boolean z8 = i3 == 1;
                    if (this.f2300bQ != null) {
                        this.f2300bQ.onSendChangeToConference(i2, z8);
                    }
                    m2071b("EI_RES_CHANGE_TO_CONFERENCE");
                    break;
                }
                break;
            case f2258bo /* 214 */:
                m2061a("EI_RES_NOTIFY_CHANGE_TO_CONFERENCE");
                if (i2 >= 0 && m2092j(i2)) {
                    m2071b("EI_RES_NOTIFY_CHANGE_TO_CONFERENCE key: " + str2);
                    String str6 = (str2 == null || str2.equals("")) ? "" : str2;
                    m2094l(i2);
                    if (this.f2300bQ != null) {
                        this.f2300bQ.onReceiveChangeToConference(i2, str, str6);
                    }
                    m2071b("EI_RES_NOTIFY_CHANGE_TO_CONFERENCE");
                    break;
                }
                break;
            case f2259bp /* 215 */:
                Log.m2967v("EI_RES_CHANGE_TO_P2P");
                m2071b("P2P : callSessionID: " + i2 + " changeResult: " + i4 + " devideID: " + i3);
                if (i2 >= 0) {
                    m2093k(i2);
                    this.f2303bz = false;
                    if (this.f2300bQ != null) {
                        m2071b("P2P EI_RES_CHANGE_TO_P2P : P2Presult: " + this.f2300bQ.onSendChangeToP2P(i2, i4, DateTimeUtil.toDate(str2, "yyyy-MM-dd HH:mm:ss")));
                        break;
                    }
                }
                break;
            case f2260bq /* 216 */:
                Log.m2967v("EI_RES_BYPASS_MSG_PEER");
                if (m2092j(i2)) {
                    handlePushProtocolBuffermessageByPeer(i2, bArr, bArr2);
                    break;
                } else {
                    m2061a("callSessionID is invalid!!");
                    break;
                }
            case f2261br /* 217 */:
                Log.m2967v("EI_RES_SET_VIDEORECORD_STOP");
                if (this.f2300bQ != null) {
                    this.f2300bQ.onRemoteVideoRecrodInfo(i3, false);
                    break;
                }
                break;
            case f2262bs /* 218 */:
                Log.m2967v("EI_RES_VERSION_RESULT");
                m2071b("EI_RES_VERSION_RESULT : versionResult = " + str + ", latestVersion = " + str2 + ", url: " + str3);
                MainApplication.mApkUpdateInterface.setDownLoadURL(MainApplication.mApkUpdateInterface.change2StringArrayEngine(str3));
                break;
            case 400:
                this.f2300bQ.onNotifyMuteReceive(i2, i3, i4);
                break;
            case 510:
                Log.m2967v("EI_RES_RECV_TRANSLATE_DATA");
                if (m2092j(i2)) {
                    this.f2300bQ.onTranslateDataReceive(i2, str, str2, i3);
                    break;
                } else {
                    m2061a("callSessionID is invalid!!");
                    break;
                }
            case 999:
                m2071b("EI_RES_DEBUG_MSG msg = " + str);
                m2082d(str);
                break;
        }
        return 1;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int hangUpCall(int i, int i2, String str) {
        if (!m2092j(i)) {
            if (this.f2300bQ == null) {
                return -30;
            }
            this.f2300bQ.onHangUpCall(i, i2, "");
            return -30;
        }
        int iM2032a = m2032a(0, i, i2, str);
        if (iM2032a == -30 && this.f2300bQ != null) {
            this.f2300bQ.onHangUpCall(i, i2, "");
        }
        return iM2032a;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int hangUpSIPCall(int i) {
        return m2032a(1, i, 10, "");
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int holdCall(int i, boolean z) {
        if (m2092j(i)) {
            return m2054a(z, 0, i);
        }
        return -30;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int holdSIPCall(int i, boolean z) throws IOException {
        m2054a(z, 1, i);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int holdVideoCall(int i, boolean z) {
        if (m2092j(i)) {
            return m2055a(z, 0, i, 2);
        }
        return -30;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int holdVideoSIPCall(int i, boolean z) throws IOException {
        m2055a(z, 1, i, 2);
        return 0;
    }

    public int initialize(long j, String str, int i, String str2, String str3, String str4, byte[] bArr) {
        String centerDomainIP = MainApplication.mConfig.getCenterDomainIP();
        String centerPath = MainApplication.mConfig.getCenterPath();
        String deviceUniqueKey = MainApplication.mConfig.getDeviceUniqueKey();
        String str5 = MainApplication.mContext.getApplicationInfo().packageName;
        m2061a("initialize : centerDomain = " + centerDomainIP + ", centerPath = " + centerPath + ", packageName = " + str5);
        if (MainApplication.mPhoneManager.getLoginManager().serverInfo().isEmpty()) {
            Log.m2967v("!!!!!!!!!!  initialize : servers.size() == 0 !!!!!!!!!");
            return -28;
        }
        try {
            return m2044a(j, str, i, str2, str3, centerDomainIP, "xml3/xml2.do", str4, EncodingUtil.encodeBase64(bArr), MainApplication.mConfig.getCenterDomain(), deviceUniqueKey, str5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return -22;
        }
    }

    public boolean is3GNetwork() {
        return PhoneManager.is3GNetworkConnected(MainApplication.mContext);
    }

    public void noticeVoipDisconnecting() {
        CallStatusData callStatusData = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callStatusData);
        if (callStatusData.isValidity()) {
            MainApplication.mNativeInterfaceCreator.createNativeCallInterface().noticeVoipDisconnecting(MainApplication.mContext.getApplicationInfo().packageName, callStatusData.getDestination().getPhoneNo());
        }
    }

    public void notifyCallSwitching(int i, int i2, int i3) throws IOException {
        m2037a(303, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), (Object) null);
    }

    public void notifyEndShareView(int i) throws IOException {
        m2037a(309, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    public int notifyP2PConfResponseEvent(int i, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2, String str, String[] strArr, String[] strArr2) {
        C1263e c1263e = new C1263e();
        c1263e.f3113a = i;
        c1263e.f3114b = i2;
        c1263e.f3115c = i3;
        c1263e.f3116d = i4;
        c1263e.f3117e = i5;
        c1263e.f3118f = iArr;
        c1263e.f3119g = iArr2;
        c1263e.f3120h = str;
        c1263e.f3121i = strArr;
        c1263e.f3122j = strArr2;
        Message message = new Message();
        message.what = 11;
        message.obj = c1263e;
        this.f2302bU.sendMessage(message);
        return 1;
    }

    public int notifyResponseEvent(int i, int i2, int i3, int i4, String str, String str2, String str3, String str4, byte[] bArr, byte[] bArr2) {
        C1262d c1262d = new C1262d();
        c1262d.f3103a = i;
        c1262d.f3104b = i2;
        c1262d.f3105c = i3;
        c1262d.f3106d = i4;
        c1262d.f3107e = str;
        c1262d.f3108f = str2;
        c1262d.f3109g = str3;
        c1262d.f3110h = str4;
        c1262d.f3111i = bArr;
        c1262d.f3112j = bArr2;
        Message message = new Message();
        message.what = 10;
        message.obj = c1262d;
        this.f2302bU.sendMessage(message);
        return 1;
    }

    @Override // com.sds.coolots.common.controller.PushReceiveInterface
    public void onReceivePushMessage(int i, String str, boolean z) throws IOException {
        m2061a("<<C2DM>> onReceivePushMessage!! type:" + i + ", message:" + str);
        if (i == 2) {
            return;
        }
        m2040a(i, str, z);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void onRender() {
        if (PhoneManager.getMediaEngineType() == 0) {
            jniStepGlSurface();
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void pauseShareScreen(int i, boolean z) throws IOException {
        m2068b(i, z);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int placeCall(String str, boolean z, boolean z2, boolean z3, String str2) throws IOException {
        Log.m2967v("placeCall : id = " + str + ", useVideo = " + z);
        if (this.engineState != 2) {
            return -1;
        }
        this.f2291bH = true;
        int iM2051a = m2051a(str, z, z2, z3, str2);
        this.f2291bH = false;
        if (iM2051a < 0) {
            if (this.f2292bI == 1) {
                return iM2051a;
            }
            int i = this.f2292bI;
            this.f2292bI = 1;
            return i;
        }
        if (iM2051a < 0 || m2092j(iM2051a)) {
            return iM2051a;
        }
        m2093k(iM2051a);
        m2061a(" get call session id for outgoing call!!! id:" + iM2051a);
        return iM2051a;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int placeP2PCall(List list, boolean z, boolean z2, List list2, String str, boolean z3) throws IOException {
        Log.m2967v("placeP2PCall()");
        if (list == null || list.isEmpty()) {
            return -1;
        }
        Log.m2967v("placeP2PCall : id = " + ((String) list.get(0)) + "(" + list.size() + "), useVideo = " + z);
        if (this.engineState != 2) {
            return -1;
        }
        this.f2291bH = true;
        int iM2052a = m2052a(list, z, z2, list2, str, z3);
        this.f2291bH = false;
        if (iM2052a < 0) {
            if (this.f2292bI == 1) {
                return iM2052a;
            }
            int i = this.f2292bI;
            this.f2292bI = 1;
            return i;
        }
        if (iM2052a < 0 || m2092j(iM2052a)) {
            return iM2052a;
        }
        m2093k(iM2052a);
        m2061a(" get call session id for outgoing call!!! id:" + iM2052a);
        return iM2052a;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int placeSIPCall(String str, boolean z) throws IOException {
        if (this.engineState != 2) {
            return -1;
        }
        m2050a(str, z);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int receiveCall(int i, boolean z, boolean z2) {
        m2071b("receiveCall : callID : " + i + " useVideo : " + z);
        if (m2092j(i)) {
            return m2036a(0, i, z, z2);
        }
        return -30;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int receiveSIPCall(int i, boolean z) {
        m2036a(1, i, z, false);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void releaseCamera(Camera camera) {
        m2061a("JNI RELEASE CAMERA!!!!");
        jniReleaseCamera();
        C1131a.m2099a().m2100a(4);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int removeP2PConfMember(int i, String str) {
        m2071b("removeP2PConfMember : callID : " + i + " userID : " + str);
        if (m2092j(i)) {
            return m2038a(i, str);
        }
        return -30;
    }

    public int reqNotifyStartVideoRecord(int i) {
        return m2037a(512, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int reqSendTranslateData(int i, String str, String str2, int i2) {
        return m2037a(510, Integer.valueOf(i), str, str2, Integer.valueOf(i2));
    }

    public int reqSetConnServerInfo(int i, int i2, String str, int i3, int i4, int i5, String str2) throws IOException {
        Log.m2967v("reqSetConnServerInfo() : totalCount = " + i + ", index = " + i2 + ", IP = " + str + ", Port = " + i3 + ", priority = " + i4 + ", subPort = " + i5 + ",cipherKey = " + str2);
        return m2037a(32, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), new Object[]{str, String.valueOf(i3), String.valueOf(i5), str2});
    }

    public int reqSetRelayInfo(int i, int i2, String str, String str2, int i3, int i4, String str3) throws IOException {
        Log.m2967v("reqSetRelayInfo() : totalCount = " + i + ",index = " + i2 + ", type = " + str + ",IP = " + str2 + ",Port = " + i3 + ",priority = " + i4 + ",cipherKey = " + str3);
        return m2037a(28, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), new Object[]{str, str2, String.valueOf(i3), str3});
    }

    public int reqTest(int i) {
        return m2037a(20, Integer.valueOf(i), (Object) null, (Object) null, (Object) null);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void resumeShareScreen(int i, boolean z) throws IOException {
        m2077c(i, z);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void sendCameraZoomInfo(int i, int i2) throws IOException {
        m2071b("sendCameraZoomInfo() : callID = " + i + " magnification: " + i2);
        m2097o(i2);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int sendDtmfTone(int i, int i2, int i3) throws IOException {
        m2084e(i, i2, i3);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void sendDummyPacket() {
        m2072c();
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int sendPushMessage(MsgHeader msgHeader, MsgBody msgBody) {
        try {
            return m2037a(39, ProtoBufHandler.toByteArray(msgHeader), ProtoBufHandler.toByteArray(msgBody), (Object) null, (Object) null);
        } catch (ProtoBufHandlerException e) {
            e.printStackTrace();
            return -22;
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int sendPushMessageByP2P(int i, MsgHeader msgHeader, MsgBody msgBody) {
        try {
            return m2037a(403, Integer.valueOf(i), ProtoBufHandler.toByteArray(msgHeader), ProtoBufHandler.toByteArray(msgBody), (Object) null);
        } catch (ProtoBufHandlerException e) {
            e.printStackTrace();
            return -22;
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int sendPushMessageByP2P(int i, MsgHeader msgHeader, MsgBody msgBody, String str) {
        try {
            return m2037a(403, Integer.valueOf(i), ProtoBufHandler.toByteArray(msgHeader), ProtoBufHandler.toByteArray(msgBody), str);
        } catch (ProtoBufHandlerException e) {
            e.printStackTrace();
            return -22;
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void sendRXMute(int i, boolean z, boolean z2) {
        m2056a(z, z2, i);
    }

    public void sendRotationCmd(int i, int i2) {
        jniSendRotationCmd(i, i2);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void sendRotationInfo(int i, int i2, boolean z, boolean z2) {
        if (m2092j(i)) {
            m2034a(i2, 0, i, z, z2);
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void sendRotationInfoForConferenceCall(int i, int i2, boolean z, boolean z2) throws IOException {
        m2034a(i2, 1, i, z, z2);
    }

    public int sendShareViewMessageByP2P(int i, MsgHeader msgHeader, MsgBody msgBody) {
        try {
            return m2037a(f2230at, Integer.valueOf(i), ProtoBufHandler.toByteArray(msgHeader), ProtoBufHandler.toByteArray(msgBody), (Object) null);
        } catch (ProtoBufHandlerException e) {
            e.printStackTrace();
            return -22;
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setCamera(Camera camera) {
        jniSetCamera(camera);
        C1131a.m2099a().m2100a(1);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int setCameraZoomAction(int i, int i2) {
        if (m2092j(i)) {
            return m2063b(i2, i);
        }
        m2061a("setFaceEmotion Error!!! callID:" + i + " is invalid!!");
        return -1;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int setCartoonView(int i, boolean z, int i2) {
        if (z || m2092j(i)) {
            return m2074c(i2, z ? 1 : 0, i);
        }
        m2061a("setCartoonView Error!!! callID:" + i + " is invalid!!");
        return -1;
    }

    public void setCipherKey(String str) {
        m2086f(str);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int setDualPosition(int i, int i2, int i3, int i4, int i5) {
        return m2075c(i, i2, i3, i4, i5);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int setEmotionalAnimation(int i, boolean z, int i2, boolean z2) {
        if (z || m2092j(i)) {
            return m2030a(i2, z ? 1 : 0, i, 0);
        }
        m2061a("setEmotionalAnimation Error!!! callID:" + i + " is invalid!!");
        return -1;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int setEmotionalEyeContact(boolean z) {
        return m2037a(38, Integer.valueOf(z ? 1 : 0), (Object) null, (Object) null, (Object) null);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int setEnablePreview(int i) {
        return m2091i(i);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setEngineCallback(EngineCallBackInterface engineCallBackInterface) {
        this.f2300bQ = engineCallBackInterface;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setEngineChattingCallback(EngineChattingCallbackInterface engineChattingCallbackInterface) {
        this.f2295bL = engineChattingCallbackInterface;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setEngineContactCallback(EngineContactCallbackInterface engineContactCallbackInterface) {
        this.f2297bN = engineContactCallbackInterface;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setEngineLoginCallback(EngineLoginCallbackInterface engineLoginCallbackInterface) {
        this.f2296bM = engineLoginCallbackInterface;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setEngineSettingCallback(EngineSettingCallbackInterface engineSettingCallbackInterface) {
        this.f2298bO = engineSettingCallbackInterface;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setEngineTranslationCallback(TranslationNotificationCallbackInterface translationNotificationCallbackInterface) {
        this.f2299bP = translationNotificationCallbackInterface;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int setFaceEmotion(int i, boolean z, int i2) {
        if (z || m2092j(i)) {
            return m2080d(i2, z ? 1 : 0, i);
        }
        m2061a("setFaceEmotion Error!!! callID:" + i + " is invalid!!");
        return -1;
    }

    public void setLogLevel(int i) {
        Log.m2958e("setLogLevel(" + i + ")");
        jniRequestEvent(513, Integer.valueOf(i), 0, 0, 0);
    }

    public void setMCUMode(boolean z) {
        jniSetMCUMode(z ? 1 : 0);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setMicMute(boolean z, boolean z2, int i) throws IOException {
        int i2 = z ? 1 : 0;
        int i3 = z2 ? 1 : 0;
        if (z2 || m2092j(i)) {
            m2029a(i2, i3, i);
        } else {
            m2061a("setMicMute Error!!! callID:" + i + " is invalid!!");
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setModeChangeDuringShareScreen(int i, boolean z, int i2) {
        m2043a(i, z, i2);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int setNoiseReduction(int i, boolean z, boolean z2) {
        if (z || m2092j(i)) {
            return m2064b(z2 ? 1 : 0, z ? 1 : 0, i);
        }
        m2061a("setNoiseReduction Error!!! callID:" + i + " is invalid!!");
        return -1;
    }

    public void setPasswd(String str) {
        m2085e(str);
    }

    public void setPreviewOutLineStatus(int i, int i2, int i3, int i4) throws IOException {
        m2071b(" setPreviewOutLineStatus path: previewStatus: " + i2 + " rgbValue: " + i3);
        m2037a(f2213ac, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void setRemoteSurface(Surface surface) {
        jniSetRemoteSurface(surface);
        C1131a.m2099a().m2100a(5);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setRenderer(int i, int i2) {
        if (MainApplication.mPhoneManager.getVersion() == 0) {
            jniInitGlSurface(i, i2, 0, 1);
        } else if (MainApplication.mPhoneManager.getVersion() == 3) {
            jniInitGlSurface(i, i2, 1, 0);
        } else {
            jniInitGlSurface(i, i2, 0, 0);
        }
        C1131a.m2099a().m2100a(6);
    }

    public int setSECAudioQoSData(int i, int i2, int i3, int i4) {
        return 0;
    }

    public int setSECVideoQoSData(int i, int i2, int i3, int i4, int i5) {
        return 0;
    }

    public void setSessionID(String str) {
        m2089g(str);
    }

    public void setSipInfo(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, int i2) throws IOException {
        if (str == null || str4 == null || str5 == null || str6 == null || str7 == null) {
            return;
        }
        m2049a(str, str2, str3, str4, i, str5, str6, str7, i2);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int setThemeShot(int i, boolean z, int i2, boolean z2) {
        if (z || m2092j(i)) {
            return m2065b(i2, z ? 1 : 0, i, z2 ? 1 : 0);
        }
        m2061a("setThemeShot Error!!! callID:" + i + " is invalid!!");
        return -1;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void setVideoFormat(int i, int i2, int i3) {
        jniSetVideoFormat(MainApplication.mConfig.getFrameWidth(i), MainApplication.mConfig.getFrameHeight(i), i3, i2, MainApplication.mConfig.getQFactor());
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int speakerOn(boolean z) {
        return m2053a(z);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int startAvatar(boolean z, int i) {
        if (z || m2092j(i)) {
            return m2037a(410, Integer.valueOf(z ? 1 : 0), Integer.valueOf(i), (Object) null, (Object) null);
        }
        return -1;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void startCamera() {
        jniStartCameraRecord();
        C1131a.m2099a().m2100a(2);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int startConference(C1189D c1189d, String str, String str2, String str3, String str4, boolean z, String str5, int i, int i2, String str6, boolean z2) throws IOException {
        if (this.engineState != 2) {
            return -1;
        }
        m2046a(c1189d, str, str2, str3, str4, z, str5, i, i2, str6, z2);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void startConferenceBilling(int i) throws IOException {
        if (this.engineState != 2) {
            return;
        }
        m2087f(i);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void startConferenceShareCameraParticipant(int i) {
        m2073c(i);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int startDualCamera(int i, int i2, int i3, int i4, int i5) {
        return m2031a(i, i2, i3, i4, i5);
    }

    public void startFileTransfer(int i, ArrayList arrayList) throws IOException {
        m2071b(" startFileTransfer ");
        if (m2092j(i)) {
            m2041a(i, arrayList);
        } else {
            m2061a(" startFileTransfer Error!!! callID:" + i + " is invalid!!");
        }
    }

    public void startHideMeVideoCall(int i, ByteBuffer byteBuffer, int i2, int i3, boolean z, int i4, int i5, boolean z2) {
        m2071b(" startHideMeVideoCall path:");
        if (!z && !m2092j(i)) {
            m2061a(" startHideMeVideoCall Error!!! callID:" + i + " is invalid!!");
            return;
        }
        int i6 = z2 ? 1 : 0;
        if (z) {
            MainApplication.mConfig.jniReplaceImage(-1, 1, byteBuffer, i2, i3, i4, i5, i6);
        } else {
            MainApplication.mConfig.jniReplaceImage(i, 1, byteBuffer, i2, i3, i4, i5, i6);
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void startRecordCall(int i, boolean z, boolean z2, String str) throws IOException {
        m2071b("startRecordCall");
        int i2 = z2 ? 1 : 0;
        if (!z && !m2092j(i)) {
            m2061a(" startRecordCall Error!!! callID:" + i + " is invalid!!");
        } else {
            m2035a(i, i2, str);
            this.f2304c = str;
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void startShareScreen(int i, int i2, int i3, boolean z) {
        m2033a(i, i2, i3, z);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int stopAvatar(boolean z, int i) {
        if (z || m2092j(i)) {
            return m2037a(411, Integer.valueOf(z ? 1 : 0), Integer.valueOf(i), (Object) null, (Object) null);
        }
        return -1;
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void stopCamera() {
        m2071b("JNI STOP CAMERA RECORD!!!!");
        jniStopCameraRecord();
        C1131a.m2099a().m2100a(3);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void stopConferenceShareCameraParticipant(int i) {
        m2079d(i);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int stopDualCamera(int i) {
        return m2090h(i);
    }

    public void stopFileTransfer(int i) throws IOException {
        m2071b(" stopFileTransfer ");
        if (m2092j(i)) {
            m2096n(i);
        } else {
            m2061a(" stopFileTransfer Error!!! callID:" + i + " is invalid!!");
        }
    }

    public void stopHideMeVideoCall(int i, boolean z) {
        m2071b(" stopHideMeVideoCall ");
        if (z || m2092j(i)) {
            MainApplication.mConfig.jniReplaceImage(i, 0, null, 0, 0, -1, 0, 0);
        } else {
            m2061a(" stopHideMeVideoCall Error!!! callID:" + i + " is invalid!!");
        }
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void stopRecordCall(int i, boolean z) throws IOException {
        m2071b("stopRecordCall");
        if (!z && !m2092j(i)) {
            m2061a(" stopRecordCall Error!!! callID:" + i + " is invalid!!");
            return;
        }
        try {
            MainApplication.mContext.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        m2088g(i);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public void stopShareScreen(int i, boolean z) {
        m2042a(i, z);
    }

    @Override // com.sds.coolots.common.controller.P2P_EngineInterface
    public int switchDualCamera(int i, int i2, int i3, int i4, int i5) {
        return m2066b(i, i2, i3, i4, i5);
    }

    public void toggleStretchMode() {
        if (this.f2294bK) {
            jniSetStretchMode(0);
            this.f2294bK = false;
        } else {
            jniSetStretchMode(1);
            this.f2294bK = true;
        }
    }
}
