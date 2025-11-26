package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.PowerManager;
import android.provider.Telephony;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.p058a.C2202p;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p111h.C3875a;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.google.android.p134a.p135a.C5082e;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class MmsRecvCompleteReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f14572a = MmsRecvCompleteReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Throwable {
        String str;
        int i;
        long j;
        boolean zM18255w = C4822an.m18255w();
        boolean zM18201K = C4822an.m18201K();
        if (!zM18255w && !zM18201K) {
            C3896s.m15044b("This user does not agree to use SMS [didMappingSamsungAccout=" + zM18255w + " acceptedDisclaimer=" + zM18201K, f14572a);
            return;
        }
        if (C2349a.m10301a("sms_feature") && C4809aa.m18104a().m18119a("pref_key_using_sms_mms_mode", Boolean.valueOf(C3847e.m14688at())).booleanValue()) {
            if ((C3847e.m14678aj() || !C4809aa.m18104a().m18119a("Setting Notification", (Boolean) true).booleanValue()) && intent.getAction().equals("android.intent.action.TRANSACTION_COMPLETED_ACTION")) {
                C3896s.m15044b("Received TRANSACTION_COMPLETED_ACTION Intent: ", f14572a);
                ((PowerManager) context.getSystemService("power")).newWakeLock(1, "MMS MmsRecvCompleteReceiver").acquire(3000L);
                Uri uri = (Uri) intent.getParcelableExtra("uri");
                if (uri != null && uri.toString().startsWith(Telephony.Mms.CONTENT_URI.toString())) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Cursor cursorQuery = contentResolver.query(uri, new String[]{"thread_id", "date", "_id", "sub", "sub_cs", "msg_box"}, null, null, null);
                    long j2 = 0;
                    long j3 = 0;
                    long j4 = 0;
                    int i2 = -1;
                    String strM15531a = "";
                    if (cursorQuery == null) {
                        str = "";
                        i = -1;
                        j = 0;
                    } else {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                j2 = cursorQuery.getLong(0);
                                j3 = cursorQuery.getLong(1) * 1000;
                                j4 = cursorQuery.getLong(2);
                                strM15531a = m15531a(context, cursorQuery.getString(3), cursorQuery.getInt(4));
                                i2 = cursorQuery.getInt(5);
                            }
                            cursorQuery.close();
                            str = strM15531a;
                            i = i2;
                            j = j4;
                        } finally {
                        }
                    }
                    Uri.Builder builderAppendId = ContentUris.appendId(Telephony.Threads.CONTENT_URI.buildUpon(), j2);
                    builderAppendId.appendPath("subject");
                    Uri uriBuild = builderAppendId.build();
                    String[] strArr = new String[5];
                    strArr[0] = "date";
                    strArr[1] = "recipient_ids";
                    strArr[2] = "snippet";
                    strArr[3] = C3847e.m14628L() ? "unread_count" : "read";
                    strArr[4] = "snippet_cs";
                    cursorQuery = contentResolver.query(uriBuild, strArr, null, null, null);
                    long j5 = 0;
                    String string = null;
                    String string2 = null;
                    int i3 = 0;
                    int i4 = 0;
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                j5 = cursorQuery.getLong(0);
                                string = cursorQuery.getString(1);
                                string2 = cursorQuery.getString(2);
                                i3 = cursorQuery.getInt(3);
                                if (!cursorQuery.isNull(4)) {
                                    i4 = cursorQuery.getInt(4);
                                }
                            }
                        } finally {
                        }
                    }
                    if (C4822an.m18203M()) {
                        C3789h c3789hM14303a = null;
                        if (!TextUtils.isEmpty(string)) {
                            c3789hM14303a = C3789h.m14303a(string, true);
                        }
                        String strM15012a = C3892o.m15012a(context, contentResolver, c3789hM14303a);
                        if (!TextUtils.isEmpty(strM15012a)) {
                            C2202p.m9975a(context, contentResolver, true, strM15012a, c3789hM14303a, i3, string2, i4, j5, j2);
                            C0991aa.m6037a().m18961c(new C1015an(new String[0]));
                            return;
                        }
                    }
                    Uri uriWithAppendedPath = Uri.withAppendedPath(C2299s.f8209a, "sms");
                    if (i == 1) {
                        uriWithAppendedPath = uriWithAppendedPath.buildUpon().appendQueryParameter("incoming", "true").build();
                    }
                    ContentValues contentValuesM15251a = C3947e.m15251a(j5, j2, string2, i4, string);
                    contentValuesM15251a.put("inbox_unread_count", Integer.valueOf(i3));
                    contentResolver.insert(uriWithAppendedPath, contentValuesM15251a);
                    contentResolver.notifyChange(C2299s.f8209a, null);
                    if (C3847e.m14678aj() && i == 1) {
                        String strM14950a = C3875a.m14950a(context, uri);
                        boolean zM15264e = C3947e.m15264e(contentResolver, j2);
                        if (!C1813b.m8906b().m8931a(Long.toString(j2))) {
                            String string3 = null;
                            if (!TextUtils.isEmpty(strM14950a)) {
                                C3782a c3782aM14204a = C3782a.m14204a(strM14950a, true);
                                if (c3782aM14204a != null) {
                                    string3 = c3782aM14204a.m14264f();
                                }
                            } else {
                                string3 = context.getString(R.string.unknown_sender);
                            }
                            C1813b.m8906b().m8925a(strM14950a, str, j2, j, string3, zM15264e, j3, false);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static String m15531a(Context context, String str, int i) {
        return (TextUtils.isEmpty(str) || str.equals(context.getString(R.string.no_subject_view))) ? context.getString(R.string.pref_mms_settings_title) : new C5082e(i, str).m19308c();
    }
}
