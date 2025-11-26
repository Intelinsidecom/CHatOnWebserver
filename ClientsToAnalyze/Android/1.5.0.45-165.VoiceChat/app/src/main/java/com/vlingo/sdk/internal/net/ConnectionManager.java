package com.vlingo.sdk.internal.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.deviceinfo.PhoneInfo;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.custom.AndroidVStreamConnection;
import com.vlingo.sdk.internal.http.custom.VConnectionFactory;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.StringUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes.dex */
public class ConnectionManager extends ConnectionProvider {
    public static final int CONNECTION_TYPE_BIS = 1;
    public static final int CONNECTION_TYPE_DIRECT = 0;
    public static final int CONNECTION_TYPE_MDS = 2;
    public static final int DEFAULT_TIMEOUT_FAST_NETWORK = 20000;
    public static final int DEFAULT_TIMEOUT_SLOW_NETWORK = 40000;
    private static final int RETRY_THRESHOLD_TIME_DEFAULT = 25000;
    private int cdmaSignal = 0;
    private int evdoSignal = 0;
    private int gsmSignal = 0;
    private static Logger log = Logger.getLogger(ConnectionManager.class);
    private static boolean sTimedOut = false;
    private static ConnectionManager instance = null;
    private static final String[] possibleParameters = {"deviceside=", "apn=", "interface=", "wapgatewayapn=", "wapsourceport=", "wapsourceip=", "wapgatewayport=", "wapgatewayip=", "wapenablewtls=", "tunnelauthusername=", "tunnelauthpassword=", "endtoendrequired"};

    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    protected ConnectionManager() {
    }

    @Override // com.vlingo.sdk.internal.net.ConnectionProvider
    public Connection getConnection(String url, int mode, boolean timeouts) throws IOException {
        ConnectionResult result = getConnectionWithDetails(url, mode, timeouts, RETRY_THRESHOLD_TIME_DEFAULT, false);
        return result.connection;
    }

    @Override // com.vlingo.sdk.internal.net.ConnectionProvider
    public ConnectionResult getConnectionWithDetails(String url, int mode, boolean timeouts) throws IOException {
        return getConnectionWithDetails(url, mode, timeouts, RETRY_THRESHOLD_TIME_DEFAULT, false);
    }

    public ConnectionResult getConnectionWithDetails(String url, int mode, boolean timeouts, boolean ignoreDirectTCP) throws IOException {
        return getConnectionWithDetails(url, mode, timeouts, RETRY_THRESHOLD_TIME_DEFAULT, ignoreDirectTCP);
    }

    public ConnectionResult buildConnectionUrl(int connectionType, String url, boolean useWiFi, boolean useApn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ConnectionResult getConnectionWithDetails(String urlStr, int mode, boolean timeouts, int retryThresholdTime, boolean ignoreDirectTCP) throws IOException {
        log.info("in getConnectionWithDetails url " + urlStr);
        AndroidVStreamConnection c = VConnectionFactory.createConnection(urlStr);
        ConnectionResult result = new ConnectionResult();
        log.info("Got connection " + c + " result " + result);
        result.connection = c;
        result.connectionType = 0;
        return result;
    }

    public boolean isConnectionTestRequired() {
        return false;
    }

    public void resetConnectionTest() {
    }

    public String getCurrentConnectionType() {
        return getConnectionTypeName(getConnectionTypeSetting());
    }

    public static String getConnectionTypeName(int conType) {
        switch (conType) {
            case 0:
                return "DirectTCP";
            case 1:
                return "BIS-B";
            case 2:
                return "MDS";
            default:
                return "Unknown";
        }
    }

    public int getConnectionTypeSetting() {
        return 0;
    }

    public static String DEBUG_fixLocalIPs(String url) {
        if (PhoneInfo.getInstance().isSimulator()) {
            return StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.replace(url, "server-dev2", "10.3.0.218"), "dev8.vlingo.com:80", "10.3.0.218:8080"), "dev8.vlingo.com", "10.3.0.218:8080"), "dev6.vlingo.com:80", "10.3.0.109:8080"), "dev7.vlingo.com:80", "10.3.0.109:8080"), "dev6.vlingo.com", "10.3.0.109:8080"), "dev7.vlingo.com", "10.3.0.109:8080"), "dev1.vlingo.com:8033", "10.3.0.109:8080"), "dev16.vlingo.com:80", "10.3.0.109:8080"), "qa01.vlingo.com:80", "10.3.0.125:8080"), "eng01.vlingo.com:80", "10.3.1.112:8080"), "eng01.vlingo.com", "10.3.1.112:8080"), "dev1.vlingo.com:80", "10.3.0.247:80"), "dev1.vlingo.com", "10.3.0.109:8080"), "https", "http"), "bls.vlingo.com/", "10.4.0.130:24880/"), "bls.vlingo.com:80", "10.4.0.130:24880");
        }
        return url;
    }

    protected boolean areConnectionParametersInUrl(String url) {
        if (url.indexOf(59) != -1) {
            String[] components = StringUtils.split(url.toLowerCase(), ';');
            for (int i = 1; i < components.length; i++) {
                for (int j = 0; j < possibleParameters.length; j++) {
                    if (components[i].indexOf(possibleParameters[j]) != -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isSlowNetwork() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
        int networkTypeId = tm.getNetworkType();
        return isTimedOut() || networkTypeId == 7 || networkTypeId == 2 || networkTypeId == 1 || networkTypeId == 0;
    }

    public static boolean isTimedOut() {
        return sTimedOut;
    }

    public static int getOptimalConnectTimeout() {
        if (isSlowNetwork()) {
            return DEFAULT_TIMEOUT_SLOW_NETWORK;
        }
        return 20000;
    }

    public static int getOptimalNetworkTimeout() {
        if (isSlowNetwork()) {
            return DEFAULT_TIMEOUT_SLOW_NETWORK;
        }
        return 20000;
    }

    public static synchronized void setTimedOut(boolean timedOut) {
        sTimedOut = timedOut;
    }

    public String getCarrierName() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
        return tm.getNetworkOperatorName();
    }

    public String getNetworkTypeName() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
        return getNetworkType(tm);
    }

    public NetworkInfo getNetworkInfo() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService("connectivity");
        return cm.getActiveNetworkInfo();
    }

    public boolean isAirplaneModeEnabled() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
    }

    public int getWifiLinkSpeed() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        WifiManager wm = (WifiManager) context.getSystemService("wifi");
        return wm.getConnectionInfo().getLinkSpeed();
    }

    public int getWifiSignalStrength() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        WifiManager wm = (WifiManager) context.getSystemService("wifi");
        return wm.getConnectionInfo().getRssi();
    }

    public int getGetResponseFromServer(String url) {
        int response;
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(RETRY_THRESHOLD_TIME_DEFAULT);
            connection.setReadTimeout(RETRY_THRESHOLD_TIME_DEFAULT);
            connection.setRequestMethod(HttpUtil.METHOD_HEAD);
            connection.setRequestMethod(HttpUtil.METHOD_GET);
            InputStream in = new BufferedInputStream(connection.getInputStream());
            in.close();
            response = connection.getResponseCode();
            if (connection != null) {
                connection.disconnect();
            }
        } catch (MalformedURLException e) {
            response = -3;
            if (connection != null) {
                connection.disconnect();
            }
        } catch (SocketTimeoutException e2) {
            response = -2;
            if (connection != null) {
                connection.disconnect();
            }
        } catch (ConnectTimeoutException e3) {
            response = -1;
            if (connection != null) {
                connection.disconnect();
            }
        } catch (IOException e4) {
            response = -4;
            if (connection != null) {
                connection.disconnect();
            }
        } catch (Throwable th) {
            if (connection != null) {
                connection.disconnect();
            }
            throw th;
        }
        return response;
    }

    public int getCdmaSignal() {
        return this.cdmaSignal;
    }

    public void setCdmaSignal(int cdmaSignal) {
        this.cdmaSignal = cdmaSignal;
    }

    public int getEvdoSignal() {
        return this.evdoSignal;
    }

    public void setEvdoSignal(int evdoSignal) {
        this.evdoSignal = evdoSignal;
    }

    public int getGsmSignal() {
        return this.gsmSignal;
    }

    public void setGsmSignal(int gsmSignal) {
        this.gsmSignal = gsmSignal;
    }

    public String generateTimeoutErrorString() {
        String wifi = null;
        if (getNetworkInfo() != null) {
            wifi = getNetworkInfo().getTypeName();
        }
        String errorMsg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf("") + "; cdmasiglev=" + getCdmaSignal()) + "; evdosiglev=" + getEvdoSignal()) + "; gsmsiglev=" + getGsmSignal()) + "; networkType=" + getNetworkTypeName()) + "; connType=" + wifi;
        if (wifi.equalsIgnoreCase("wifi")) {
            return String.valueOf(errorMsg) + "; wifilinkspd=" + getWifiLinkSpeed();
        }
        return errorMsg;
    }

    private String getNetworkType(TelephonyManager phonyManager) {
        int type = phonyManager.getNetworkType();
        switch (type) {
            case 0:
                return "NETWORK_TYPE_UNKNOWN";
            case 1:
                return "NETWORK_TYPE_GPRS";
            case 2:
                return "NETWORK_TYPE_EDGE";
            case 3:
                return "NETWORK_TYPE_UMTS";
            case 4:
                return "NETWORK_TYPE_CDMA";
            case 5:
                return "NETWORK_TYPE_EVDO_0";
            case 6:
                return "NETWORK_TYPE_EVDO_0";
            case 7:
                return "NETWORK_TYPE_1xRTT";
            case 8:
                return "NETWORK_TYPE_HSDPA";
            case 9:
                return "NETWORK_TYPE_HSUPA";
            case 10:
                return "NETWORK_TYPE_HSPA";
            case 11:
                return "NETWORK_TYPE_IDEN";
            case 12:
                return "NETWORK_TYPE_EVDO_B";
            default:
                return "unknown";
        }
    }
}
