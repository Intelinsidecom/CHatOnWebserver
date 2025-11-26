package com.vlingo.sdk.internal.location;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.coolots.p2pmsg.model.EWalletAutoChargeRep;
import com.vlingo.sdk.VLSdk;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.logging.Logger;

/* loaded from: classes.dex */
public class LocationUtils {
    private static final Logger log = Logger.getLogger(LocationUtils.class);
    private static LocationUtils instance = null;
    private final double NO_LONG = 0.0d;
    private final double NO_LAT = 0.0d;
    private String lastMCC = null;
    private double lastLong = 0.0d;
    private double lastLat = 0.0d;

    public static synchronized LocationUtils getInstance() {
        if (instance == null) {
            instance = new LocationUtils();
        }
        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    public static String getCellTowerInfo() {
        return getInstance()._getCellTowerInfo();
    }

    public static String getMCC() {
        return getInstance()._getMCC();
    }

    public static double getLastLat() {
        return getInstance()._getLastLat();
    }

    public static double getLastLong() {
        return getInstance()._getLastLong();
    }

    public static String getCarrierCountry(Context context) {
        return getInstance()._getCarrierCountry(context);
    }

    private Context getCurrentContext() {
        return ApplicationAdapter.getInstance().getApplicationContext();
    }

    private String _getMCC() {
        if (!VLSdk.getInstance().getLocationOn()) {
            return "";
        }
        _getCellTowerInfo();
        String toReturn = this.lastMCC;
        return toReturn;
    }

    private String _getCellTowerInfo() {
        return _getCellTowerInfo(getCurrentContext());
    }

    private double _getLastLat() {
        if (!VLSdk.getInstance().getLocationOn()) {
            return 0.0d;
        }
        _getCellTowerInfo();
        double toReturn = this.lastLat;
        return toReturn;
    }

    private double _getLastLong() {
        if (!VLSdk.getInstance().getLocationOn()) {
            return 0.0d;
        }
        _getCellTowerInfo();
        double toReturn = this.lastLong;
        return toReturn;
    }

    private String _getCarrierCountry(Context context) {
        TelephonyManager mgr = (TelephonyManager) context.getSystemService("phone");
        return mgr.getNetworkCountryIso();
    }

    private String _getCellTowerInfo(Context context) {
        log.debug("Getting location");
        if (!VLSdk.getInstance().getLocationOn() || context == null) {
            return "";
        }
        LocationManager lm = (LocationManager) context.getSystemService("location");
        Criteria cr = new Criteria();
        cr.setAccuracy(2);
        cr.setAltitudeRequired(false);
        cr.setBearingRequired(false);
        cr.setCostAllowed(false);
        cr.setSpeedRequired(false);
        StringBuffer locationStringBuffer = new StringBuffer(50);
        String provider = lm.getBestProvider(cr, true);
        log.debug("Found provider : " + provider);
        if (provider != null) {
            Location loc = lm.getLastKnownLocation(provider);
            if (loc != null) {
                this.lastLat = loc.getLatitude();
                this.lastLong = loc.getLongitude();
                locationStringBuffer.append("Lat=" + this.lastLat + ";Long=" + this.lastLong + ";Alt=" + loc.getAltitude());
                log.debug("[debug] loc is not null & locationStringBuffer =" + locationStringBuffer.toString());
            } else {
                log.debug("[debug] loc is null");
            }
        }
        TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
        CellLocation cloc = tm.getCellLocation();
        String networkInfo = tm.getNetworkOperator();
        if (networkInfo == null || networkInfo.length() < 4 || networkInfo.contains("@")) {
            networkInfo = EWalletAutoChargeRep.RESULT_SUCCESS;
        }
        if (cloc instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaloc = (CdmaCellLocation) cloc;
            if (locationStringBuffer.length() > 0) {
                locationStringBuffer.append(';');
            }
            this.lastMCC = networkInfo.substring(0, 3);
            locationStringBuffer.append("CDMA_MCC=" + this.lastMCC + ";CDMA_MNC=" + networkInfo.substring(3) + ";BID=" + cdmaloc.getBaseStationId() + ";SID=" + cdmaloc.getSystemId() + ";NID=" + cdmaloc.getNetworkId());
        } else if (cloc instanceof GsmCellLocation) {
            GsmCellLocation gsmloc = (GsmCellLocation) cloc;
            if (locationStringBuffer.length() > 0) {
                locationStringBuffer.append(';');
            }
            this.lastMCC = networkInfo.substring(0, 3);
            locationStringBuffer.append("GSM_MCC=" + this.lastMCC + ";GSM_MNC=" + networkInfo.substring(3) + ";CID=" + gsmloc.getCid() + ";LAC=" + gsmloc.getLac() + ";RAC=0");
        }
        String locationString = locationStringBuffer.toString();
        log.debug("Got " + locationString);
        return locationString;
    }
}
