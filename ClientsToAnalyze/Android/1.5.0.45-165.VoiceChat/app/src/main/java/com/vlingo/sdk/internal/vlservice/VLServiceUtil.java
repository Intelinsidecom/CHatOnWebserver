package com.vlingo.sdk.internal.vlservice;

import android.text.format.DateFormat;
import com.sec.spp.push.Config;
import com.vlingo.sdk.VLSdk;
import com.vlingo.sdk.internal.audio.AudioDevice;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.http.cookies.CookieJar;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.internal.recognizer.ClientMeta;
import com.vlingo.sdk.internal.recognizer.SRContext;
import com.vlingo.sdk.internal.recognizer.SoftwareMeta;
import com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter;
import com.vlingo.sdk.internal.util.Screen;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.util.SDKDebugSettings;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class VLServiceUtil {
    public static final String VLINGO_PROTOCOL_VERSION = "3.8";
    static final String XVL_PROTOCOL_HEADER_VALUE = "Version=3.8; ResponseEncoding=";
    private static final Logger log = Logger.getLogger(VLServiceUtil.class);

    public static String getSpeakerID() {
        return VLServiceCookieManager.getInstance().getCookieValue("VLSPEAKER");
    }

    public static Hashtable<String, String> addVLServiceCookies(Hashtable<String, String> cookies, String domain, String path) {
        log.debug("** VLService.addVLServiceCookies " + cookies + " domain=" + domain + " path=" + path);
        if (cookies == null) {
            cookies = new Hashtable<>();
        }
        VLServiceCookieManager.getInstance().addAllCookiesToHashtable(cookies, domain, path);
        return cookies;
    }

    public static void handleResponseCookies(CookieJar cookies) {
        log.debug("** VLService.handleResponseCookies");
        VLServiceCookieManager.getInstance().mergeCookies(cookies);
    }

    public static void setProtocolHeader(Hashtable<String, String> headers, String responseEncoding) {
        headers.put("X-vlprotocol", XVL_PROTOCOL_HEADER_VALUE + responseEncoding);
    }

    public static void addStandardVlingoHttpHeaders(Hashtable<String, String> headers, ClientMeta client, SoftwareMeta software, SRContext srContext) {
        addStandardVlingoHttpHeaders(headers, client, software, null, srContext);
    }

    public static void addStandardVlingoHttpHeaders(Hashtable<String, String> headers, ClientMeta client, SoftwareMeta software, String language, SRContext srContext) {
        String location;
        headers.put("Cache-Control", "no-cache,no-store,max-age=0,no-transform");
        if (headers.get("X-vlprotocol") == null) {
            setProtocolHeader(headers, VLHttpServiceRequest.RESPONSE_ENCODING_XML);
        }
        Screen screen = Screen.getInstance();
        headers.put("X-vldisplaygeometry", "Width=" + Integer.toString(screen.getWidth()) + "; Mag=" + Float.toString(screen.getMagnification()));
        String languageLocale = StringUtils.isNullOrWhiteSpace(language) ? client.getLanguage() : language;
        StringBuffer sb = new StringBuffer();
        sb.append("DeviceMake=" + client.getDeviceMake());
        sb.append("; DeviceOSName=" + client.getDeviceOSName());
        sb.append("; DeviceModel=" + client.getDeviceModel());
        sb.append("; DeviceOS=" + client.getDeviceOS());
        sb.append("; Language=" + languageLocale);
        sb.append("; ConnectionType=" + ConnectionManager.getInstance().getCurrentConnectionType());
        sb.append("; Carrier=" + client.getCarrier());
        String carrierCountry = client.getCarrierCountry();
        if (carrierCountry != null && carrierCountry.length() > 0) {
            sb.append("; CarrierCountry=" + carrierCountry);
        }
        String deviceId = client.getDeviceID();
        if (deviceId != null && deviceId.length() > 0) {
            sb.append("; DeviceID=" + deviceId);
        }
        if (client.getPhoneNumber().length() > 0) {
            sb.append("; PhoneNumber=" + client.getPhoneNumber());
        }
        sb.append("; AudioDevice=" + AudioDevice.getInstance().getAudioDeviceName());
        String vlclient = sb.toString();
        headers.put("X-vlclient", vlclient);
        log.debug("** vlclient: " + vlclient);
        String xvlSoftware = "Name=" + software.getName() + "; Version=" + software.getVersion();
        String channel = software.getAppChannel();
        if (channel != null && channel.length() > 0) {
            xvlSoftware = String.valueOf(xvlSoftware) + "; AppChannel=" + channel;
        }
        headers.put("X-vlsoftware", xvlSoftware);
        String xvlSdk = "Name=" + software.getSdkName() + "; Version=" + software.getSdkVersion();
        headers.put("X-vlsdk", xvlSdk);
        if (VLSdk.getInstance().getLocationOn() && (location = client.getLocation()) != null && location.length() > 0) {
            headers.put("X-vllocation", location);
        }
        headers.put("X-vlsr", "AppID=" + software.getAppId());
        if (!headers.containsKey("Content-Type")) {
            headers.put("Content-Type", "application/octet-stream;boundary=" + HttpConnectionAdapter.ivBoundary);
        }
        headers.put("Accept-Charset", "utf-8,ISO-8859-1;q=0.5,*;q=0.5");
        String lang = languageLocale.substring(0, 2);
        headers.put("Accept-Language", String.valueOf(languageLocale) + "," + lang + ";q=0.7,en;q=0.5");
        if (srContext != null && srContext.isDMRequest()) {
            headers.put("X-vvs", "Version=2.0");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            String xvlclientdate = "Date=" + sdf.format(new Date());
            headers.put("X-vlclientdate", xvlclientdate);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz", Locale.US);
            StringBuilder xvldm = new StringBuilder();
            xvldm.append("ClientTime=").append(sdf2.format(new Date()));
            String username = srContext.getUsername();
            if (username == null) {
                username = "";
            }
            String username2 = username.replaceAll("(;|=)+", "");
            if (!StringUtils.isNullOrWhiteSpace(username2)) {
                xvldm.append("; UserName=").append(username2);
            }
            String dialogGUID = srContext.getDialogGUID();
            if (!StringUtils.isNullOrWhiteSpace(dialogGUID)) {
                xvldm.append("; DialogGUID=").append(dialogGUID);
            }
            int dialogTurn = srContext.getDialogTurnNumber();
            if (dialogTurn > -1) {
                xvldm.append("; TurnNumber=").append(dialogTurn);
            }
            SDKDebugSettings ds = VLSdk.getInstance().getDebugSettings();
            if (ds != null && ds.isForceNonDM()) {
                xvldm.append("; DisableDM=true");
            }
            xvldm.append("; Use24HourTime=").append(DateFormat.is24HourFormat(ApplicationAdapter.getInstance().getApplicationContext()));
            headers.put("X-vldm", xvldm.toString());
            StringBuilder xvlconfiguration = new StringBuilder();
            HashMap<String, String> dmHeaderCustomKVPairs = srContext.getDMHeaderKVPairs();
            for (String key : dmHeaderCustomKVPairs.keySet()) {
                xvlconfiguration.append(key).append("=").append(dmHeaderCustomKVPairs.get(key)).append("; ");
            }
            if (xvlconfiguration.length() > 0) {
                xvlconfiguration.delete(xvlconfiguration.lastIndexOf(Config.KEYVALUE_SPLIT), xvlconfiguration.length() - 1);
                headers.put("X-vlconfiguration", xvlconfiguration.toString());
            }
        } else {
            headers.put("X-vvs", "Version=1.0");
        }
        log.debug("** request headers: " + headers.toString());
    }
}
