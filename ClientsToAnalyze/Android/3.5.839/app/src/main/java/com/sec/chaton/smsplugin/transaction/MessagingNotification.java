package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Handler;
import android.provider.Telephony;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity;
import com.sec.chaton.smsplugin.p112ui.PluginConversationList;
import java.util.HashSet;
import java.util.TreeSet;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class MessagingNotification {

    /* renamed from: e */
    private static Intent f14570e;

    /* renamed from: a */
    private static final String[] f14566a = {"thread_id", "date", "address", "subject", "body"};

    /* renamed from: b */
    private static final C4080p f14567b = new C4080p(null);

    /* renamed from: c */
    private static final Uri f14568c = Uri.parse("content://mms-sms/undelivered");

    /* renamed from: d */
    private static OnDeletedReceiver f14569d = new OnDeletedReceiver();

    /* renamed from: f */
    private static Handler f14571f = new Handler();

    public class OnDeletedReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                C3890m.m14996b("MessagingNotification", "[MessagingNotification] clear notification: mark all msgs seen");
            }
            C3790i.m14335c(context);
        }
    }

    /* renamed from: a */
    public static void m15521a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.sec.chaton.smsplugin.NOTIFICATION_DELETED_ACTION");
        context.registerReceiver(f14569d, intentFilter);
        f14570e = new Intent("com.sec.chaton.smsplugin.NOTIFICATION_DELETED_ACTION");
    }

    /* renamed from: a */
    public static void m15527a(Context context, boolean z, boolean z2) {
        TreeSet treeSet = new TreeSet(f14567b);
        HashSet hashSet = new HashSet(4);
        m15522a(context, 500);
        if (!treeSet.isEmpty()) {
            if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                C3890m.m14996b("MessagingNotification", "blockingUpdateNewMessageIndicator: count=0, isNew=" + z);
            }
            ((C4079o) treeSet.first()).m15689a(context, z, 0, hashSet.size());
        }
        C4078n c4078nM15528b = m15528b(context);
        if (c4078nM15528b != null) {
            c4078nM15528b.m15687a(context, z2);
        }
    }

    /* renamed from: b */
    private static final C4078n m15528b(Context context) {
        C4078n c4078n = null;
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), Telephony.Sms.CONTENT_URI, f14566a, "(type = 2 AND status = 0)", (String[]) null, "date");
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToLast()) {
                    c4078n = new C4078n(String.format(context.getString(R.string.delivery_toast_body), cursorQuery.getString(2)), 3000L);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return c4078n;
    }

    /* renamed from: a */
    public static void m15522a(Context context, int i) {
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m15530b(Context context, boolean z, CharSequence charSequence, long j) {
        if (z) {
            f14571f.post(new RunnableC4077m(context, charSequence, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m15529b(Context context, Intent intent, String str, int i, boolean z, CharSequence charSequence, long j, String str2, int i2, int i3) {
        Notification notification = new Notification(i, charSequence, j);
        if (i3 > 1) {
            str2 = context.getString(R.string.notification_multiple_title);
            intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(872415232);
            intent.setType("vnd.android-dir/mms-sms");
        }
        if (i2 > 1) {
            str = context.getString(R.string.notification_multiple, Integer.toString(i2));
        }
        notification.setLatestEventInfo(context, str2, str, PendingIntent.getActivity(context, 0, intent, 134217728));
    }

    /* renamed from: a */
    public static void m15524a(Context context, boolean z) {
        m15525a(context, false, 0L, z);
    }

    /* renamed from: a */
    private static void m15525a(Context context, boolean z, long j, boolean z2) {
        String string;
        String string2;
        Intent intent;
        long[] jArr = {0, 1};
        int iM15520a = m15520a(context, jArr);
        if (iM15520a != 0 || z) {
            boolean z3 = jArr[1] != 0 || z;
            Notification notification = new Notification();
            if (iM15520a > 1) {
                string2 = context.getString(R.string.notification_failed_multiple, Integer.toString(iM15520a));
                string = context.getString(R.string.notification_failed_multiple_title);
            } else {
                string = z ? context.getString(R.string.message_download_failed_title) : context.getString(R.string.message_send_failed_title);
                string2 = context.getString(R.string.message_failed_body);
            }
            if (z3) {
                intent = new Intent(context, (Class<?>) PluginComposeMessageActivity.class);
                if (z) {
                    intent.putExtra("failed_download_flag", true);
                } else {
                    j = jArr[0];
                    intent.putExtra("undelivered_flag", true);
                }
                intent.putExtra("thread_id", j);
            } else {
                intent = new Intent(context, (Class<?>) PluginConversationList.class);
            }
            intent.setFlags(335544320);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
            notification.icon = R.drawable.stat_notify_sms_failed;
            notification.tickerText = string;
            notification.setLatestEventInfo(context, string, string2, activity);
        }
    }

    /* renamed from: a */
    private static int m15520a(Context context, long[] jArr) {
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), f14568c, new String[]{"thread_id"}, "read=0", (String[]) null, (String) null);
        if (cursorQuery == null) {
            return 0;
        }
        int count = cursorQuery.getCount();
        if (jArr != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    jArr[0] = cursorQuery.getLong(0);
                    if (jArr.length >= 2) {
                        long j = jArr[0];
                        while (true) {
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            if (cursorQuery.getLong(0) != j) {
                                j = 0;
                                break;
                            }
                        }
                        jArr[1] = j;
                    }
                }
            } finally {
                cursorQuery.close();
            }
        }
        return count;
    }
}
