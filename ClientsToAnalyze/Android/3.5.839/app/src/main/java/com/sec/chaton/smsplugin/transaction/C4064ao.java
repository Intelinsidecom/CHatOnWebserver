package com.sec.chaton.smsplugin.transaction;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.NetworkUtils;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.provider.C3954l;

/* compiled from: TransactionSettings.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.ao */
/* loaded from: classes.dex */
public class C4064ao {

    /* renamed from: d */
    private static final String[] f14647d = {"type", "mmsc", "mmsproxy", "mmsport"};

    /* renamed from: a */
    private String f14648a;

    /* renamed from: b */
    private String f14649b;

    /* renamed from: c */
    private int f14650c;

    public C4064ao(Context context, String str) {
        Cursor cursorQuery;
        this.f14650c = -1;
        String str2 = TextUtils.isEmpty(str) ? null : "apn='" + str.trim() + "'";
        C3896s.m15046d("query to carrier DB using selection = " + str2, "TransactionSettings");
        Cursor cursorQuery2 = SqliteWrapper.query(context, context.getContentResolver(), Uri.withAppendedPath(C3954l.f14242a, "preferapn"), f14647d, str2, (String[]) null, (String) null);
        if (cursorQuery2 == null || cursorQuery2.getCount() == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str2 = "numeric='" + (telephonyManager.getSimOperator() != null ? telephonyManager.getSimOperator() : "") + "' and apn='" + (str != null ? str.trim() : "") + "'";
            C3890m.m14994a("TransactionSettings", "query to carrier DB using new_selection = " + str2);
            if (cursorQuery2 != null && cursorQuery2.getCount() == 0) {
                cursorQuery2.close();
            }
            Cursor cursorQuery3 = context.getContentResolver().query(C3954l.f14242a, f14647d, str2, null, null);
            if (cursorQuery3 == null || cursorQuery3.getCount() == 0) {
                str2 = "numeric='" + (telephonyManager.getSimOperator() != null ? telephonyManager.getSimOperator() : "") + "'";
                C3890m.m14994a("TransactionSettings", "query to carrier DB using new_selection = " + str2);
                if (cursorQuery3 != null && cursorQuery3.getCount() == 0) {
                    cursorQuery3.close();
                }
                cursorQuery = context.getContentResolver().query(C3954l.f14242a, f14647d, str2, null, null);
                if (cursorQuery == null || cursorQuery.getCount() == 0) {
                    C3890m.m14999e("TransactionSettings", "Apn is not found in Database!");
                    if (cursorQuery != null) {
                    }
                    String strM14718x = C3847e.m14718x();
                    if (C3847e.m14657aH() && strM14718x != null && "XAR".equals(strM14718x)) {
                        this.f14648a = C3847e.m14720z();
                        C3890m.m14996b("TransactionSettings", "[TransactionSettings] Apn is not found in Database, but in Settings");
                        return;
                    }
                    return;
                }
            } else {
                cursorQuery = cursorQuery3;
            }
        } else {
            cursorQuery = cursorQuery2;
        }
        C3896s.m15046d("TransactionSettings looking for apn: " + str2 + " returned: " + (cursorQuery == null ? "null cursor" : cursorQuery.getCount() + " hits"), "TransactionSettings");
        boolean z = false;
        while (cursorQuery.moveToNext() && TextUtils.isEmpty(this.f14648a)) {
            try {
                if (m15636a(cursorQuery.getString(0), "mms")) {
                    this.f14648a = NetworkUtils.trimV4AddrZeros(cursorQuery.getString(1).trim());
                    this.f14649b = NetworkUtils.trimV4AddrZeros(cursorQuery.getString(2));
                    if (m15640d()) {
                        String string = cursorQuery.getString(3);
                        try {
                            this.f14650c = Integer.parseInt(string);
                        } catch (NumberFormatException e) {
                            if (TextUtils.isEmpty(string)) {
                                C3890m.m14997c("TransactionSettings", "mms port not set!");
                                C3896s.m15045c("mms port not set!", "TransactionSettings");
                            } else {
                                C3890m.m14995a("TransactionSettings", "Bad port number format: " + string, e);
                                C3896s.m15041a("Bad port number format: " + string, "TransactionSettings");
                                C3896s.m15042a(e, "TransactionSettings");
                            }
                        }
                        z = true;
                    } else {
                        z = true;
                    }
                }
            } finally {
                cursorQuery.close();
            }
        }
        cursorQuery.close();
        String strM14718x2 = C3847e.m14718x();
        if (C3847e.m14657aH() && strM14718x2 != null && "XAR".equals(strM14718x2)) {
            this.f14648a = C3847e.m14720z();
        }
        C3890m.m14994a("TransactionSettings", "APN setting: MMSC: " + this.f14648a + " looked for: " + str2);
        C3896s.m15046d("APN setting: MMSC: " + this.f14648a + " looked for: " + str2, "TransactionSettings");
        if (z && TextUtils.isEmpty(this.f14648a)) {
            C3890m.m14999e("TransactionSettings", "Invalid APN setting: MMSC is empty");
            C3896s.m15041a("Invalid APN setting: MMSC is empty", "TransactionSettings");
        }
    }

    public C4064ao(String str, String str2, int i) {
        this.f14650c = -1;
        this.f14648a = str != null ? str.trim() : null;
        this.f14649b = str2;
        this.f14650c = i;
        C3896s.m15046d("TransactionSettings: " + this.f14648a + " proxyAddress: " + this.f14649b + " proxyPort: " + this.f14650c, "TransactionSettings");
    }

    /* renamed from: a */
    public String m15637a() {
        return this.f14648a;
    }

    /* renamed from: b */
    public String m15638b() {
        return this.f14649b;
    }

    /* renamed from: c */
    public int m15639c() {
        return this.f14650c;
    }

    /* renamed from: d */
    public boolean m15640d() {
        return (this.f14649b == null || this.f14649b.trim().length() == 0) ? false : true;
    }

    /* renamed from: a */
    private static boolean m15636a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (String str3 : str.split(",")) {
            if (str3.equals(str2) || str3.equals("*")) {
                return true;
            }
        }
        return false;
    }
}
