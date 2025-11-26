package com.sec.chaton.smsplugin.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.common.util.C5052r;
import com.sec.spp.push.Config;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: MyTelephonyProvider.java */
/* renamed from: com.sec.chaton.smsplugin.provider.m */
/* loaded from: classes.dex */
class C3955m extends SQLiteOpenHelper {

    /* renamed from: a */
    private final Context f14245a;

    public C3955m(Context context) {
        super(context, "telephony.db", (SQLiteDatabase.CursorFactory) null, m15271a(context));
        this.f14245a = context;
    }

    /* renamed from: a */
    private static int m15271a(Context context) throws Resources.NotFoundException {
        String str;
        String str2;
        int i = 655360;
        Resources resources = context.getResources();
        XmlResourceParser xml = resources.getXml(R.xml.apns);
        try {
            try {
                xml = resources.getXml(R.xml.apns);
                XmlUtils.beginDocument(xml, "apns");
                i = 655360 | Integer.parseInt(xml.getAttributeValue(null, VKOpenAuthActivity.VK_EXTRA_API_VERSION));
            } catch (Throwable th) {
                Log.e("TelephonyProvider", "Can't get version of APN database", th);
                try {
                    xml.close();
                } catch (Exception e) {
                    e = e;
                    str = "TelephonyProvider";
                    str2 = "Can't get version of APN database parser.close()";
                    Log.e(str, str2, e);
                    return i;
                }
            }
            try {
                xml.close();
            } catch (Exception e2) {
                e = e2;
                str = "TelephonyProvider";
                str2 = "Can't get version of APN database parser.close()";
                Log.e(str, str2, e);
                return i;
            }
            return i;
        } catch (Throwable th2) {
            try {
                xml.close();
            } catch (Exception e3) {
                Log.e("TelephonyProvider", "Can't get version of APN database parser.close()", e3);
            }
            throw th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws Resources.NotFoundException, SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE carriers(_id INTEGER PRIMARY KEY,name TEXT,numeric TEXT,mcc TEXT,mnc TEXT,apn TEXT,user TEXT,server TEXT,password TEXT,proxy TEXT,port TEXT,mmsproxy TEXT,mmsport TEXT,mmsc TEXT,authtype INTEGER,type TEXT,current INTEGER,protocol TEXT,roaming_protocol TEXT,carrier_enabled BOOLEAN,bearer INTEGER);");
        m15273a(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15273a(SQLiteDatabase sQLiteDatabase) throws Resources.NotFoundException {
        String str;
        String str2;
        XmlResourceParser xml = this.f14245a.getResources().getXml(R.xml.apns);
        try {
            try {
                XmlUtils.beginDocument(xml, "apns");
                Integer.parseInt(xml.getAttributeValue(null, VKOpenAuthActivity.VK_EXTRA_API_VERSION));
                m15275a(sQLiteDatabase, xml);
                try {
                    xml.close();
                } catch (Exception e) {
                    e = e;
                    str = "TelephonyProvider";
                    str2 = "Can't load apns of APN database parser.close()";
                    Log.e(str, str2, e);
                }
            } catch (Throwable th) {
                Log.e("TelephonyProvider", "Got exception while loading APN database.", th);
                try {
                    xml.close();
                } catch (Exception e2) {
                    e = e2;
                    str = "TelephonyProvider";
                    str2 = "Can't load apns of APN database parser.close()";
                    Log.e(str, str2, e);
                }
            }
        } catch (Throwable th2) {
            try {
                xml.close();
            } catch (Exception e3) {
                Log.e("TelephonyProvider", "Can't load apns of APN database parser.close()", e3);
            }
            throw th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C3896s.m15044b(C5052r.m19199a("version old = ", Integer.valueOf(i), " new = ", Integer.valueOf(i2)), "TelephonyProvider");
    }

    /* renamed from: a */
    private ContentValues m15272a(XmlPullParser xmlPullParser) {
        if (!"apn".equals(xmlPullParser.getName())) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        String attributeValue = xmlPullParser.getAttributeValue(null, "mcc");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "mnc");
        contentValues.put("numeric", attributeValue + attributeValue2);
        contentValues.put("mcc", attributeValue);
        contentValues.put("mnc", attributeValue2);
        contentValues.put("name", xmlPullParser.getAttributeValue(null, "carrier"));
        contentValues.put("apn", xmlPullParser.getAttributeValue(null, "apn"));
        contentValues.put("user", xmlPullParser.getAttributeValue(null, "user"));
        contentValues.put("server", xmlPullParser.getAttributeValue(null, "server"));
        contentValues.put("password", xmlPullParser.getAttributeValue(null, "password"));
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "proxy");
        if (attributeValue3 != null) {
            contentValues.put("proxy", attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue(null, Config.COLUMN_PORT);
        if (attributeValue4 != null) {
            contentValues.put(Config.COLUMN_PORT, attributeValue4);
        }
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "mmsproxy");
        if (attributeValue5 != null) {
            contentValues.put("mmsproxy", attributeValue5);
        }
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "mmsport");
        if (attributeValue6 != null) {
            contentValues.put("mmsport", attributeValue6);
        }
        contentValues.put("mmsc", xmlPullParser.getAttributeValue(null, "mmsc"));
        String attributeValue7 = xmlPullParser.getAttributeValue(null, "type");
        if (attributeValue7 != null) {
            contentValues.put("type", attributeValue7);
        }
        String attributeValue8 = xmlPullParser.getAttributeValue(null, "authtype");
        if (attributeValue8 != null) {
            contentValues.put("authtype", Integer.valueOf(Integer.parseInt(attributeValue8)));
        }
        String attributeValue9 = xmlPullParser.getAttributeValue(null, "protocol");
        if (attributeValue9 != null) {
            contentValues.put("protocol", attributeValue9);
        }
        String attributeValue10 = xmlPullParser.getAttributeValue(null, "roaming_protocol");
        if (attributeValue10 != null) {
            contentValues.put("roaming_protocol", attributeValue10);
        }
        String attributeValue11 = xmlPullParser.getAttributeValue(null, "carrier_enabled");
        if (attributeValue11 != null) {
            contentValues.put("carrier_enabled", Boolean.valueOf(Boolean.parseBoolean(attributeValue11)));
        }
        String attributeValue12 = xmlPullParser.getAttributeValue(null, "bearer");
        if (attributeValue12 != null) {
            contentValues.put("bearer", Integer.valueOf(Integer.parseInt(attributeValue12)));
        }
        return contentValues;
    }

    /* renamed from: a */
    private void m15275a(SQLiteDatabase sQLiteDatabase, XmlPullParser xmlPullParser) {
        if (xmlPullParser == null) {
            return;
        }
        while (true) {
            try {
                XmlUtils.nextElement(xmlPullParser);
                ContentValues contentValuesM15272a = m15272a(xmlPullParser);
                if (contentValuesM15272a != null) {
                    m15274a(sQLiteDatabase, "carriers", contentValuesM15272a);
                } else {
                    return;
                }
            } catch (IOException e) {
                Log.e("TelephonyProvider", "Got execption while getting perferred time zone.", e);
                return;
            } catch (XmlPullParserException e2) {
                Log.e("TelephonyProvider", "Got execption while getting perferred time zone.", e2);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m15274a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        if (!contentValues.containsKey("authtype")) {
            contentValues.put("authtype", (Integer) (-1));
        }
        if (!contentValues.containsKey("protocol")) {
            contentValues.put("protocol", "IP");
        }
        if (!contentValues.containsKey("roaming_protocol")) {
            contentValues.put("roaming_protocol", "IP");
        }
        if (!contentValues.containsKey("carrier_enabled")) {
            contentValues.put("carrier_enabled", (Boolean) true);
        }
        if (!contentValues.containsKey("bearer")) {
            contentValues.put("bearer", (Integer) 0);
        }
        sQLiteDatabase.insert("carriers", null, contentValues);
    }
}
