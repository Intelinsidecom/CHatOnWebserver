package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SqliteWrapper;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Telephony;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.google.android.p134a.p135a.C5081d;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5084g;
import com.sec.google.android.p134a.p135a.C5095r;
import com.sec.google.android.p134a.p135a.C5099v;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class PushReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && intent.getAction() != null) {
            if (C3847e.m14686ar() && intent.getAction().equals("android.provider.Telephony.WAP_PUSH_DELIVER") && "application/vnd.wap.mms-message".equals(intent.getType())) {
                C3896s.m15044b("Received PUSH Intent: " + intent, "PushReceiver");
                C3892o.m15031e();
                ((PowerManager) context.getSystemService("power")).newWakeLock(1, "MMS PushReceiver").acquire(5000L);
                new AsyncTaskC4087w(this, context).execute(intent);
                return;
            }
            if (!C3892o.m15023b() && intent.getAction().equals("android.provider.Telephony.WAP_PUSH_RECEIVED") && "application/vnd.wap.mms-message".equals(intent.getType())) {
                C3896s.m15044b("Received PUSH Intent: " + intent, "PushReceiver");
                boolean zM18255w = C4822an.m18255w();
                boolean zM18201K = C4822an.m18201K();
                if (!zM18255w && !zM18201K) {
                    C3896s.m15044b("This user does not agree to use SMS [didMappingSamsungAccout=" + zM18255w + " acceptedDisclaimer=" + zM18201K, "PushReceiver");
                    return;
                }
                if (C2349a.m10301a("sms_feature") && C4809aa.m18104a().m18119a("pref_key_using_sms_mms_mode", Boolean.valueOf(C3847e.m14688at())).booleanValue() && !C3847e.m14678aj() && C4809aa.m18104a().m18119a("Setting Notification", (Boolean) true).booleanValue()) {
                    ((PowerManager) context.getSystemService("power")).newWakeLock(1, "MMS PushReceiver").acquire(5000L);
                    new AsyncTaskC4087w(this, context).execute(intent);
                    abortBroadcast();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static long m15539b(Context context, C5095r c5095r, int i) {
        String str;
        if (i == 134) {
            str = new String(((C5081d) c5095r).m19301a());
        } else {
            str = new String(((C5099v) c5095r).m19453a());
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append("m_id");
        sb.append('=');
        sb.append(DatabaseUtils.sqlEscapeString(str));
        sb.append(" AND ");
        sb.append("m_type");
        sb.append('=');
        sb.append(128);
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, new String[]{"thread_id"}, sb.toString(), (String[]) null, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() == 1 && cursorQuery.moveToFirst()) {
                    return cursorQuery.getLong(0);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m15541b(Context context, C5084g c5084g) {
        byte[] bArrM19320a = c5084g.m19320a();
        if (bArrM19320a != null) {
            Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, new String[]{"_id"}, "ct_l = ?", new String[]{new String(bArrM19320a)}, (String) null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        return true;
                    }
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m15540b(Context context, String str, int i) {
        String string = context.getString(R.string.pref_mms_settings_title);
        if (TextUtils.isEmpty(str) || str.equals(context.getString(R.string.no_subject_view))) {
            return string;
        }
        return (Build.VERSION.SDK_INT < 19 || i != 106) ? new C5082e(i, str).m19308c() : string;
    }
}
