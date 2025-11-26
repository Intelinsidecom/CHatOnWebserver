package com.sec.chaton.hugefiletransfer;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.provider.Telephony;
import android.support.v4.app.C0036av;
import android.widget.RemoteViews;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.transaction.BackgroundSenderService;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5103z;
import com.sec.widget.C5179v;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/* loaded from: classes.dex */
public class HugeFileUploadService extends IntentService {

    /* renamed from: a */
    private static final String f8481a = HugeFileUploadService.class.getSimpleName();

    /* renamed from: b */
    private C2397k f8482b;

    /* renamed from: c */
    private long f8483c;

    /* renamed from: d */
    private int f8484d;

    /* renamed from: e */
    private int f8485e;

    /* renamed from: f */
    private HashMap<Long, Intent> f8486f;

    /* renamed from: g */
    private C0036av f8487g;

    /* renamed from: h */
    private Notification f8488h;

    /* renamed from: i */
    private RemoteViews f8489i;

    /* renamed from: j */
    private Handler f8490j;

    /* renamed from: k */
    private final Handler f8491k;

    public HugeFileUploadService() {
        super(f8481a);
        this.f8490j = new HandlerC2395i(this);
        this.f8491k = new HandlerC2396j(this);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f8486f = new HashMap<>();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        if (C4904y.f17872b) {
            C4904y.m18639b("onHandleIntent", f8481a);
        }
        this.f8487g = null;
        this.f8488h = null;
        if (intent != null) {
            long longExtra = intent.getLongExtra("huge_file_request_id", 0L);
            if (intent.getBooleanExtra("huge_file_cancel", false) || this.f8486f.containsKey(Long.valueOf(longExtra))) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("requestId: ", Long.valueOf(longExtra), " cancelled"), f8481a);
                }
                this.f8486f.remove(Long.valueOf(longExtra));
                return;
            }
            long longExtra2 = intent.getLongExtra("huge_file_upload_id", 0L);
            Uri data = intent.getData();
            if (longExtra != 0 && data != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("requestId: ", Long.valueOf(longExtra), ", uploadUri: ", data, ", uploadId: ", Long.valueOf(longExtra2)), f8481a);
                }
                if (this.f8482b != null) {
                    this.f8482b.m10413a(false);
                }
                this.f8485e++;
                this.f8483c = longExtra;
                this.f8482b = new C2397k(this.f8490j, intent);
                this.f8482b.m10412a();
            }
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroy", f8481a);
        }
        if (this.f8482b != null) {
            this.f8482b.m10413a(false);
        }
        startService(new Intent(this, (Class<?>) HugeFileDbArrangeService.class));
        super.onDestroy();
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onStartCommand", f8481a);
        }
        if (intent != null) {
            long longExtra = intent.getLongExtra("huge_file_request_id", 0L);
            if (!intent.getBooleanExtra("huge_file_cancel", false)) {
                this.f8484d++;
                long jCurrentTimeMillis = System.currentTimeMillis();
                intent.putExtra("huge_file_upload_id", jCurrentTimeMillis);
                ContentValues contentValues = new ContentValues();
                contentValues.put("upload_id", Long.valueOf(jCurrentTimeMillis));
                contentValues.put("file_uri", intent.getData().toString());
                contentValues.put("request_id", Long.valueOf(longExtra));
                if (intent.getBooleanExtra("huge_file_from_chat", false)) {
                    contentValues.put("request_type", Integer.valueOf(EnumC2301u.NORMAL.m10212a()));
                } else if (C3847e.m14652aC()) {
                    contentValues.put("request_type", Integer.valueOf(EnumC2301u.SMS.m10212a()));
                }
                if (Build.VERSION.SDK_INT < 11) {
                    AsyncTaskC2389c.m10386a(3, contentValues).execute(new Void[0]);
                } else {
                    AsyncTaskC2389c.m10386a(3, contentValues).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }
            } else {
                this.f8484d--;
                if (this.f8486f != null) {
                    this.f8486f.put(Long.valueOf(longExtra), intent);
                }
                if (this.f8482b != null && this.f8483c == intent.getLongExtra("huge_file_request_id", 0L)) {
                    this.f8482b.m10413a(true);
                    this.f8485e--;
                }
                intent.setClass(getApplicationContext(), HugeFileUploadBroadcastReceiver.class);
                sendBroadcast(intent);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10375a(long j) {
        if (j == 0) {
            C3890m.m14996b(f8481a, "Large file message ID is invalid");
            return;
        }
        if (Uri.withAppendedPath(Telephony.Mms.CONTENT_URI, String.valueOf(j)) == null) {
            C3890m.m14996b(f8481a, "Large file message URI is invalid");
            return;
        }
        try {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("err_type", (Integer) 10);
            SqliteWrapper.update(this, getContentResolver(), Telephony.MmsSms.PendingMessages.CONTENT_URI, contentValues, "msg_id=" + j, (String[]) null);
        } catch (Exception e) {
            C3890m.m14995a(f8481a, "Failed to mark large file message as error: " + j, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Notification m10373a(C2402p c2402p) {
        if (Build.VERSION.SDK_INT >= 14) {
            if (this.f8487g == null) {
                this.f8487g = new C0036av(getApplicationContext());
                this.f8487g.m143a(c2402p.m10426b()).m146c(getString(R.string.hugefile_sending_message) + "\n" + c2402p.m10426b()).m140a(R.drawable.chaton_quick_icon).m142a(c2402p.m10429e());
            }
            this.f8487g.m145b("(" + this.f8485e + "/" + this.f8484d + ")");
            this.f8487g.m141a(c2402p.m10427c(), c2402p.m10428d(), false);
            return this.f8487g.m139a();
        }
        if (this.f8488h == null) {
            this.f8489i = new RemoteViews(getPackageName(), R.layout.hugefile_notification_layout);
            this.f8489i.setTextViewText(R.id.noti_title, c2402p.m10426b());
            this.f8488h = new Notification(R.drawable.chaton_quick_icon, getString(R.string.hugefile_sending_message) + "\n" + c2402p.m10426b(), System.currentTimeMillis());
            this.f8488h.flags |= 2;
            this.f8488h.contentIntent = c2402p.m10429e();
            this.f8488h.contentView = this.f8489i;
            this.f8488h.icon = R.drawable.chaton_quick_icon;
        }
        this.f8488h.contentView.setProgressBar(R.id.noti_progress, c2402p.m10427c(), c2402p.m10428d(), false);
        this.f8488h.contentView.setTextViewText(R.id.noti_text, "(" + this.f8485e + "/" + this.f8484d + ")");
        return this.f8488h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10376a(Intent intent) {
        if (intent != null) {
            long longExtra = intent.getLongExtra("huge_file_request_id", 0L);
            Uri data = intent.getData();
            long longExtra2 = intent.getLongExtra("huge_file_expired_time", 0L);
            int intExtra = intent.getIntExtra("huge_file_auth_code", 0);
            String stringExtra = intent.getStringExtra("huge_file_download_url");
            String stringExtra2 = intent.getStringExtra("inboxNO");
            if (longExtra == 0) {
                C3890m.m14996b(f8481a, "Large file message ID is invalid");
                return;
            }
            Uri uriWithAppendedPath = Uri.withAppendedPath(Telephony.Mms.CONTENT_URI, String.valueOf(longExtra));
            if (uriWithAppendedPath == null) {
                C3890m.m14996b(f8481a, "Large file message URI is invalid");
                return;
            }
            try {
                C3870p c3870pM14881a = C3870p.m14881a(this, uriWithAppendedPath);
                if (c3870pM14881a == null || c3870pM14881a.size() < 1) {
                    C3890m.m14996b(f8481a, "Load large file message URI. null");
                    return;
                }
                C3869o c3869o = c3870pM14881a.get(0);
                if (c3869o != null && c3869o.m14861d()) {
                    if (data == null) {
                        C3890m.m14996b(f8481a, "Large file URI is invalid");
                        return;
                    }
                    c3869o.m14874n().m14941a((CharSequence) String.format("[%s]\n%s (%.1f MB)\n%s: %s\n%s: %04d\n%s", getString(R.string.hugefile_large_file), new File(data.toString()).getName(), Float.valueOf(r12.length() / 1048576.0f), getString(R.string.hugefile_expiration_date), new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(longExtra2)), getString(R.string.hugefile_file_verification_code), Integer.valueOf(intExtra), stringExtra));
                    C5097t c5097tM19426a = C5097t.m19426a(this);
                    try {
                        c5097tM19426a.m19451a(uriWithAppendedPath, (C5103z) c5097tM19426a.m19449a(uriWithAppendedPath));
                        c5097tM19426a.m19450a(uriWithAppendedPath, c3870pM14881a.m14899a());
                        try {
                            ContentValues contentValues = new ContentValues(1);
                            contentValues.put("err_type", (Integer) 0);
                            SqliteWrapper.update(this, getContentResolver(), Telephony.MmsSms.PendingMessages.CONTENT_URI, contentValues, "msg_id=" + longExtra, (String[]) null);
                        } catch (Exception e) {
                            C3890m.m14995a(f8481a, "Failed to mark large file message as no error: " + longExtra, e);
                        }
                        BackgroundSenderService.m15512a(this, uriWithAppendedPath, Long.parseLong(stringExtra2), (int) longExtra, this.f8491k);
                    } catch (C5111c e2) {
                        C3890m.m14995a(f8481a, "Failed to update large file message URI", e2);
                    }
                }
            } catch (C5111c e3) {
                C3890m.m14995a(f8481a, "Failed to load large file message URI", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10381b(Intent intent) {
        if (intent != null) {
            long longExtra = intent.getLongExtra("huge_file_request_id", 0L);
            Uri data = intent.getData();
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("huge_file_pending_intent");
            int intExtra = intent.getIntExtra("huge_file_error_code", 0);
            String stringExtra = intent.getStringExtra("huge_file_error_message");
            String string = getString(R.string.hugefile_sending_failed);
            String string2 = getString(R.string.hugefile_failed_to_send_file);
            switch (intExtra) {
                case 39115:
                    try {
                        string2 = getString(R.string.hugefile_file_upload_count_error, new Object[]{Integer.valueOf(Integer.parseInt(stringExtra))});
                    } catch (NumberFormatException e) {
                        string2 = getString(R.string.hugefile_file_upload_count_error, new Object[]{5});
                    }
                    string = string2;
                    break;
                case 39116:
                    try {
                        string2 = getString(R.string.hugefile_file_size_error, new Object[]{Integer.valueOf(Integer.parseInt(stringExtra) / 1073741824)});
                    } catch (NumberFormatException e2) {
                        string2 = getString(R.string.hugefile_file_size_error, new Object[]{1});
                    }
                    string = string2;
                    break;
            }
            C5179v.m19811a(getApplicationContext(), string2, 0).show();
            if (data == null) {
                C3890m.m14996b(f8481a, "Large file URI is invalid");
                return;
            }
            File file = new File(data.toString());
            C0036av c0036av = new C0036av(getApplicationContext());
            c0036av.m143a(file.getName()).m145b(string).m140a(R.drawable.chaton_quick_icon).m142a(pendingIntent).m144a(true);
            ((NotificationManager) getSystemService("notification")).notify((int) longExtra, c0036av.m139a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e9  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m10380b(long r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r6 = 0
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L34
            android.net.Uri r1 = com.sec.chaton.p057e.C2218af.m10084a(r8)     // Catch: java.lang.Throwable -> L34
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto Le9
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> Le3
            if (r0 == 0) goto Le9
            java.lang.String r0 = "file_uri"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> Le3
        L24:
            if (r1 == 0) goto L29
            r1.close()
        L29:
            if (r0 != 0) goto L3b
            java.lang.String r0 = com.sec.chaton.hugefiletransfer.HugeFileUploadService.f8481a
            java.lang.String r1 = "Large file path is invalid"
            com.sec.chaton.smsplugin.p111h.C3890m.m14996b(r0, r1)
        L33:
            return
        L34:
            r0 = move-exception
        L35:
            if (r6 == 0) goto L3a
            r6.close()
        L3a:
            throw r0
        L3b:
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            android.net.Uri r0 = android.provider.Telephony.Mms.CONTENT_URI
            java.lang.String r1 = java.lang.String.valueOf(r8)
            android.net.Uri r0 = android.net.Uri.withAppendedPath(r0, r1)
            android.content.ContentResolver r1 = r7.getContentResolver()
            long r3 = com.sec.chaton.smsplugin.provider.C3947e.m15248a(r1, r0)
            boolean r0 = com.sec.chaton.util.C4822an.m18203M()
            if (r0 == 0) goto Le7
            android.content.ContentResolver r0 = r7.getContentResolver()
            java.lang.String r1 = java.lang.Long.toString(r3)
            com.sec.chaton.e.a.o r0 = com.sec.chaton.p057e.p058a.C2202p.m9994k(r0, r1)
            if (r0 == 0) goto Le7
            java.lang.String r0 = r0.f7839b
        L68:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto Lbb
            android.content.Intent r0 = com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity.m15925a(r7, r3)
        L72:
            android.content.Context r1 = com.sec.chaton.global.GlobalApplication.m18732r()
            r3 = 0
            r4 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r1, r3, r0, r4)
            android.support.v4.app.av r1 = new android.support.v4.app.av
            android.content.Context r3 = r7.getApplicationContext()
            r1.<init>(r3)
            java.lang.String r2 = r2.getName()
            android.support.v4.app.av r2 = r1.m143a(r2)
            r3 = 2131428944(0x7f0b0650, float:1.8479547E38)
            java.lang.String r3 = r7.getString(r3)
            android.support.v4.app.av r2 = r2.m145b(r3)
            r3 = 2130837809(0x7f020131, float:1.7280583E38)
            android.support.v4.app.av r2 = r2.m140a(r3)
            android.support.v4.app.av r0 = r2.m142a(r0)
            r2 = 1
            r0.m144a(r2)
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r7.getSystemService(r0)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            int r2 = (int) r8
            android.app.Notification r1 = r1.m139a()
            r0.notify(r2, r1)
            goto L33
        Lbb:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "chaton://chatroom?inboxNo="
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r1.setData(r0)
            java.lang.String r0 = "android.intent.action.SEND"
            r1.setAction(r0)
            r0 = r1
            goto L72
        Le3:
            r0 = move-exception
            r6 = r1
            goto L35
        Le7:
            r0 = r6
            goto L68
        Le9:
            r0 = r6
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.hugefiletransfer.HugeFileUploadService.m10380b(long):void");
    }
}
