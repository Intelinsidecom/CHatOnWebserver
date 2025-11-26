package com.sds.coolots;

import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;

/* loaded from: classes.dex */
public class EventTraceUtil {
    public static final int EVT_TRACE_3G_CONNECTED = 2;
    public static final int EVT_TRACE_3G_DISCONNECTED = 3;
    public static final int EVT_TRACE_INIT_ENGINE_ERROR = 13;
    public static final int EVT_TRACE_LOGIN = 0;
    public static final int EVT_TRACE_LOGOUT = 1;
    public static final int EVT_TRACE_MSGFROMCENTERSVR_ERROR = 8;
    public static final int EVT_TRACE_NETWORK_DISCONNECTED = 6;
    public static final int EVT_TRACE_NOTAVAILABLECENTERSVR_ERROR = 7;
    public static final int EVT_TRACE_NOTAVAILABLENETWORK_ERROR = 11;
    public static final int EVT_TRACE_NOTAVAILABLEP2PSESSION_ERROR = 9;
    public static final int EVT_TRACE_NOTAVAILABLERELAY_ERROR = 12;
    public static final int EVT_TRACE_P2PSENDDATA_ERROR = 10;
    public static final int EVT_TRACE_SET_RELAY_INFO_ERROR = 15;
    public static final int EVT_TRACE_SET_STUN_INFO_ERROR = 14;
    public static final int EVT_TRACE_WIFI_CONNECTED = 4;
    public static final int EVT_TRACE_WIFI_DISCONNECTED = 5;

    /* renamed from: a */
    public static HashMap f2309a = new HashMap();

    /* renamed from: b */
    public static SQLiteDatabase f2310b = null;

    public static void writeEventTrace(int i) {
    }
}
