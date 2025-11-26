package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.provider.Telephony;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.p058a.C2202p;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.util.C4822an;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SmsRetrieveService extends Service {

    /* renamed from: b */
    private static final String f14590b = SmsRetrieveService.class.getSimpleName();

    /* renamed from: f */
    private static final String[] f14591f = {"message_count", "date", "recipient_ids", "snippet", "unread_count", "snippet_cs"};

    /* renamed from: g */
    private static final String[] f14592g = {"message_count", "date", "recipient_ids", "snippet", "read", "snippet_cs"};

    /* renamed from: a */
    public Handler f14593a = new Handler();

    /* renamed from: c */
    private HandlerC4057ah f14594c;

    /* renamed from: d */
    private Looper f14595d;

    /* renamed from: e */
    private int f14596e;

    @Override // android.app.Service
    public void onCreate() {
        C3896s.m15044b("=== SERVICE CREATED ===", f14590b);
        HandlerThread handlerThread = new HandlerThread(f14590b, 10);
        handlerThread.start();
        this.f14595d = handlerThread.getLooper();
        this.f14594c = new HandlerC4057ah(this, this.f14595d);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.f14596e = intent != null ? intent.getIntExtra("result", 0) : 0;
        if (this.f14596e != 0) {
            C3890m.m14994a(f14590b, "onStart: #" + i2 + " mResultCode: " + this.f14596e + " = " + m15575a(this.f14596e));
        }
        Message messageObtain = Message.obtain(this.f14594c);
        messageObtain.arg1 = i2;
        messageObtain.obj = intent;
        this.f14594c.sendMessage(messageObtain);
        return 2;
    }

    /* renamed from: a */
    private static String m15575a(int i) {
        switch (i) {
            case -1:
                return "Activity.RESULT_OK";
            case 0:
            default:
                return "Unknown error code";
            case 1:
                return "SmsManager.RESULT_ERROR_GENERIC_FAILURE";
            case 2:
                return "SmsManager.RESULT_ERROR_RADIO_OFF";
            case 3:
                return "SmsManager.RESULT_ERROR_NULL_PDU";
            case 4:
                return "SmsManager.RESULT_ERROR_NO_SERVICE";
            case 5:
                return "SmsManager.RESULT_ERROR_LIMIT_EXCEEDED";
            case 6:
                return "SmsManager.RESULT_ERROR_FDN_CHECK_FAILURE";
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        C3896s.m15044b("=== SERVICE DESTROY ===", f14590b);
        this.f14595d.quit();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15577a(Intent intent, int i, int i2) throws Throwable {
        C4056ag c4056ag = new C4056ag(this, this, intent, i, this.f14594c);
        getContentResolver().registerContentObserver(Telephony.Sms.CONTENT_URI, true, c4056ag);
        boolean zM15576a = m15576a(this, intent);
        if (zM15576a) {
            getContentResolver().unregisterContentObserver(c4056ag);
        }
        return zM15576a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15576a(Context context, Intent intent) throws Throwable {
        int i;
        String str;
        long j;
        int i2;
        int i3;
        String str2;
        ContentResolver contentResolver = getContentResolver();
        long longExtra = intent.getLongExtra("extra_thread_id", 0L);
        int intExtra = intent.getIntExtra("extra_recv_time", 0);
        Uri.Builder builderAppendId = ContentUris.appendId(Telephony.Threads.CONTENT_URI.buildUpon(), longExtra);
        builderAppendId.appendPath("subject");
        Cursor cursorQuery = contentResolver.query(builderAppendId.build(), (C3847e.m14627K() && C3847e.m14628L()) ? f14591f : f14592g, null, null, null);
        int i4 = 0;
        long j2 = 0;
        String string = null;
        String string2 = null;
        int i5 = 0;
        int i6 = 0;
        if (cursorQuery == null) {
            i = 0;
            str = null;
            j = 0;
            i2 = 0;
            i3 = 0;
            str2 = null;
        } else {
            try {
                if (cursorQuery.moveToFirst()) {
                    i4 = cursorQuery.getInt(0);
                    j2 = cursorQuery.getLong(1);
                    string = cursorQuery.getString(2);
                    string2 = cursorQuery.getString(3);
                    i5 = cursorQuery.getInt(4);
                    i6 = cursorQuery.getInt(5);
                }
                cursorQuery.close();
                i = i6;
                str = string;
                j = j2;
                i2 = i5;
                i3 = i4;
                str2 = string2;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        if (intExtra == i3) {
            C3896s.m15044b("Native not yet updated (message count Before = " + intExtra + " After = " + i3, f14590b);
            C3896s.m15044b("========= Observe Db Change", f14590b);
            return false;
        }
        if (intExtra > i3) {
            C3896s.m15041a("Oooops, how can the previous message count can be greater than after?", f14590b);
            return false;
        }
        C3896s.m15044b("MsgCntAfter = " + i3, f14590b);
        C3896s.m15044b("Timestamp = " + j, f14590b);
        C3896s.m15044b("snippet = " + str2, f14590b);
        if (C4822an.m18203M()) {
            C3789h c3789hM14303a = null;
            if (!TextUtils.isEmpty(str)) {
                c3789hM14303a = C3789h.m14303a(str, true);
            }
            String strM15012a = C3892o.m15012a(context, contentResolver, c3789hM14303a);
            if (!TextUtils.isEmpty(strM15012a)) {
                C2202p.m9975a(context, contentResolver, true, strM15012a, c3789hM14303a, i2, str2, i, j, longExtra);
                C0991aa.m6037a().m18961c(new C1015an(new String[0]));
                return true;
            }
        }
        Uri uriBuild = Uri.withAppendedPath(C2299s.f8209a, "sms").buildUpon().appendQueryParameter("incoming", "true").build();
        ContentValues contentValuesM15251a = C3947e.m15251a(j, longExtra, str2, i, str);
        contentValuesM15251a.put("inbox_unread_count", Integer.valueOf(i2));
        C3896s.m15044b("Inserted Uri" + contentResolver.insert(uriBuild, contentValuesM15251a), f14590b);
        C0991aa.m6037a().m18961c(new C1015an(new String[0]));
        return true;
    }
}
