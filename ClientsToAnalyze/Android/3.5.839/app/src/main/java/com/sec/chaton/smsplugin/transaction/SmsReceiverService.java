package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.provider.Telephony;
import android.telephony.ServiceState;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.InterfaceC1762hh;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p057e.p058a.C2202p;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p111h.AbstractC3900w;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.p112ui.ClassZeroActivity;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.smsplugin.spam.C4012bp;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.google.android.p134a.C5111c;
import java.io.IOException;
import java.util.GregorianCalendar;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SmsReceiverService extends Service {

    /* renamed from: h */
    private static InterfaceC1762hh f14580h;

    /* renamed from: c */
    private HandlerC4055af f14583c;

    /* renamed from: d */
    private Looper f14584d;

    /* renamed from: e */
    private boolean f14585e;

    /* renamed from: g */
    private int f14586g;

    /* renamed from: b */
    private static final String f14578b = SmsReceiverService.class.getSimpleName();

    /* renamed from: f */
    private static final String[] f14579f = {"_id", "thread_id", "address", "body", "status"};

    /* renamed from: l */
    private static final String[] f14581l = {"_id", "address", "protocol"};

    /* renamed from: a */
    public Handler f14582a = new Handler();

    /* renamed from: i */
    private String f14587i = "sms_message_body";

    /* renamed from: j */
    private String f14588j = "sms_address";

    /* renamed from: k */
    private final String[] f14589k = {"type", VKApiConst.GROUP_ID};

    @Override // android.app.Service
    public void onCreate() {
        C3896s.m15044b(f14578b + " service thread created", f14578b);
        HandlerThread handlerThread = new HandlerThread(f14578b, 10);
        handlerThread.start();
        this.f14584d = handlerThread.getLooper();
        this.f14583c = new HandlerC4055af(this, this.f14584d);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.f14586g = intent != null ? intent.getIntExtra("result", 0) : 0;
        if (this.f14586g != 0) {
            C3890m.m14994a(f14578b, "onStart: #" + i2 + " mResultCode: " + this.f14586g + " = " + m15551a(this.f14586g));
        }
        if (intent != null && intent.hasExtra(this.f14587i)) {
            f14580h.mo8219a(1, intent.getStringExtra(this.f14587i), C3782a.m14204a(intent.getStringExtra(this.f14588j), false).m14269k(), EnumC2214ab.TEXT);
            Message messageObtain = Message.obtain(this.f14583c);
            messageObtain.arg1 = i2;
            this.f14583c.sendMessage(messageObtain);
        } else {
            Message messageObtain2 = Message.obtain(this.f14583c);
            messageObtain2.arg1 = i2;
            messageObtain2.obj = intent;
            this.f14583c.sendMessage(messageObtain2);
        }
        return 2;
    }

    /* renamed from: a */
    private static String m15551a(int i) {
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
        this.f14584d.quit();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15565b(Intent intent) {
        if (ServiceState.newFromBundle(intent.getExtras()).getState() == 0) {
            m15573a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15570c(Intent intent) {
        if (!this.f14585e) {
            m15573a(intent);
        }
    }

    /* renamed from: a */
    public synchronized void m15573a(Intent intent) {
        boolean z;
        Cursor cursorQuery = SqliteWrapper.query(this, getContentResolver(), Uri.parse("content://sms/queued"), f14579f, (String) null, (String[]) null, "date ASC");
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(3);
                    String string2 = cursorQuery.getString(2);
                    int i = cursorQuery.getInt(1);
                    int i2 = cursorQuery.getInt(4);
                    int i3 = cursorQuery.getInt(0);
                    Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, i3);
                    C3890m.m14994a(f14578b, "sendFirstQueuedMessage " + uriWithAppendedId + ", address: " + string2 + ", threadId: " + i);
                    if (C3847e.m14654aE()) {
                        try {
                            new C4072h(this, string2, string, i, uriWithAppendedId).mo15606a(-1L);
                            C4809aa.m18104a().m18126b("free_sms_reward_1st_regular_msgid_int", (Integer) (-1));
                        } catch (C5111c e) {
                            e.printStackTrace();
                        }
                        z = true;
                    } else {
                        int intExtra = -1;
                        Messenger messenger = null;
                        if (intent != null) {
                            intExtra = intent.getIntExtra("extra_bg_token", -1);
                            Messenger messenger2 = (Messenger) intent.getParcelableExtra("extra_bg_cb_messenger");
                            C3896s.m15045c("Send BG token == " + intExtra, f14578b);
                            messenger = messenger2;
                        }
                        try {
                            new C4058ai(this, string2, string, i, i2 == 32, uriWithAppendedId, intExtra, messenger).mo15606a(-1L);
                            if (-1 == C4809aa.m18104a().m18120a("free_sms_reward_1st_regular_msgid_int", (Integer) (-1)).intValue() && C4809aa.m18104a().m18120a("free_sms_remain_count", (Integer) 200).intValue() == 0) {
                                C4809aa.m18104a().m18126b("free_sms_reward_1st_regular_msgid_int", Integer.valueOf(i3));
                            }
                            this.f14585e = true;
                            z = true;
                        } catch (C5111c e2) {
                            C3890m.m14995a(f14578b, "sendFirstQueuedMessage: failed to send message " + uriWithAppendedId + ", caught ", e2);
                            this.f14585e = false;
                            if (C3847e.m14679ak()) {
                                m15557a(intent, uriWithAppendedId, 1, true);
                            } else {
                                m15557a(intent, uriWithAppendedId, 1, false);
                            }
                            z = false;
                        }
                    }
                } else {
                    z = true;
                }
            } finally {
                cursorQuery.close();
            }
        } else {
            z = true;
        }
        if (z) {
            m15572e();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m15562a(android.net.Uri r12, int r13) throws java.lang.Throwable {
        /*
            r11 = this;
            r8 = 0
            r9 = 0
            r7 = 1
            r0 = 6
            if (r13 != r0) goto L7
        L6:
            return r7
        L7:
            android.content.Context r0 = r11.getApplicationContext()
            if (r0 == 0) goto L6
            java.lang.String r1 = r12.getLastPathSegment()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "group_id=(SELECT group_id FROM sms WHERE _id="
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r3 = ") AND _id!="
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r4 = r1.toString()
            android.content.ContentResolver r1 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lad
            android.net.Uri r2 = android.provider.Telephony.Sms.CONTENT_URI     // Catch: java.lang.Throwable -> Lad
            java.lang.String[] r3 = r11.f14589k     // Catch: java.lang.Throwable -> Lad
            r5 = 0
            r6 = 0
            android.database.Cursor r2 = android.database.sqlite.SqliteWrapper.query(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lad
            if (r2 == 0) goto L4c
            int r1 = r2.getCount()     // Catch: java.lang.Throwable -> Lb5
            if (r1 >= r7) goto L52
        L4c:
            if (r2 == 0) goto L6
        L4e:
            r2.close()
            goto L6
        L52:
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Lb5
            if (r1 == 0) goto Laa
            r1 = 1
            long r4 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5
            r1 = r8
            r3 = r8
        L5f:
            r6 = 0
            int r6 = r2.getInt(r6)     // Catch: java.lang.Throwable -> Lb5
            switch(r6) {
                case 2: goto L7e;
                case 3: goto L67;
                case 4: goto L67;
                case 5: goto L7d;
                default: goto L67;
            }     // Catch: java.lang.Throwable -> Lb5
        L67:
            r10 = r1
            r1 = r3
            r3 = r10
        L6a:
            boolean r6 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lb5
            if (r6 != 0) goto Lb8
            int r6 = r2.getCount()     // Catch: java.lang.Throwable -> Lb5
            if (r1 >= r6) goto L84
            if (r2 == 0) goto L7b
            r2.close()
        L7b:
            r7 = r8
            goto L6
        L7d:
            r1 = r7
        L7e:
            int r3 = r3 + 1
            r10 = r1
            r1 = r3
            r3 = r10
            goto L6a
        L84:
            r1 = 5
            if (r3 != 0) goto L8b
            r3 = -1
            if (r13 != r3) goto L8b
            r1 = 2
        L8b:
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch: java.lang.Throwable -> Lb5
            r6 = 1
            r3.<init>(r6)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r6 = "group_type"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> Lb5
            r3.put(r6, r1)     // Catch: java.lang.Throwable -> Lb5
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lb5
            android.net.Uri r1 = android.provider.Telephony.Sms.CONTENT_URI     // Catch: java.lang.Throwable -> Lb5
            android.net.Uri r1 = android.content.ContentUris.withAppendedId(r1, r4)     // Catch: java.lang.Throwable -> Lb5
            r4 = 0
            r5 = 0
            r0.update(r1, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb5
        Laa:
            if (r2 == 0) goto L6
            goto L4e
        Lad:
            r0 = move-exception
            r1 = r9
        Laf:
            if (r1 == 0) goto Lb4
            r1.close()
        Lb4:
            throw r0
        Lb5:
            r0 = move-exception
            r1 = r2
            goto Laf
        Lb8:
            r10 = r3
            r3 = r1
            r1 = r10
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.SmsReceiverService.m15562a(android.net.Uri, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15556a(Intent intent, int i) throws RemoteException {
        Uri data = intent.getData();
        this.f14585e = false;
        boolean booleanExtra = intent.getBooleanExtra("SendNextMsg", false);
        if (!C3847e.m14657aH() || !C3847e.m14620D() || data != null) {
            boolean zM15562a = C3847e.m14679ak() ? m15562a(data, this.f14586g) : false;
            if (this.f14586g == -1) {
                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                    C3890m.m14994a(f14578b, "handleSmsSent move message to sent folder uri: " + data);
                }
                if (!Telephony.Sms.moveMessageToFolder(this, data, 2, i)) {
                    C3890m.m14999e(f14578b, "handleSmsSent: failed to move message " + data + " to sent folder");
                }
                if (booleanExtra) {
                    m15573a(intent);
                }
                int intExtra = intent.getIntExtra("extra_bg_token", -1);
                C3896s.m15045c("handle Sent BG token == " + intExtra, f14578b);
                if (intExtra != -1) {
                    BackgroundSenderService.m15511a(0, intExtra, (Messenger) intent.getParcelableExtra("extra_bg_cb_messenger"));
                    return;
                }
                return;
            }
            if (this.f14586g == 2 || this.f14586g == 4) {
                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                    C3890m.m14994a(f14578b, "handleSmsSent: no service, queuing message w/ uri: " + data);
                }
                m15571d();
                Telephony.Sms.moveMessageToFolder(this, data, 5, i);
                this.f14582a.post(new RunnableC4053ad(this));
                return;
            }
            if (this.f14586g == 6) {
                m15557a(intent, data, i, zM15562a);
                this.f14582a.post(new RunnableC4054ae(this));
            } else {
                m15557a(intent, data, i, zM15562a);
                if (booleanExtra) {
                    m15573a(intent);
                }
            }
        }
    }

    /* renamed from: a */
    private void m15557a(Intent intent, Uri uri, int i, boolean z) throws RemoteException {
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a(f14578b, "messageFailedToSend msg failed uri: " + uri + " error: " + i);
        }
        Telephony.Sms.moveMessageToFolder(this, uri, 5, i);
        int intExtra = intent != null ? intent.getIntExtra("extra_bg_token", -1) : -1;
        if (intExtra != -1) {
            BackgroundSenderService.m15511a(-1, intExtra, (Messenger) intent.getParcelableExtra("extra_bg_cb_messenger"));
        } else if (z) {
            MessagingNotification.m15524a(getApplicationContext(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15566b(Intent intent, int i) {
        String displayMessageBody;
        SmsMessage[] messagesFromIntent = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        SmsMessage smsMessage = messagesFromIntent[0];
        Uri uriM15548a = m15548a(this, messagesFromIntent, i, intent.getStringExtra("format"), intent.getBooleanExtra("extra_is_spam", false));
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a(f14578b, "handleSmsReceived" + (smsMessage.isReplace() ? "(replace)" : "") + " messageUri: " + uriM15548a + ", address: " + smsMessage.getOriginatingAddress() + ", body: " + smsMessage.getMessageBody());
        }
        if (C3847e.m14657aH() && C3847e.m14617A() != null && messagesFromIntent[0] != null && (displayMessageBody = messagesFromIntent[0].getDisplayMessageBody()) != null && displayMessageBody.startsWith(C3847e.m14617A())) {
            C3890m.m14996b(f14578b, "discard sms body by prefix");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15564b() {
        if (m15569c() > 0) {
        }
        m15573a((Intent) null);
    }

    /* renamed from: c */
    private int m15569c() {
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("type", (Integer) 5);
        contentValues.put(VKApiConst.ERROR_CODE, (Integer) 1);
        contentValues.put("read", (Integer) 0);
        int iUpdate = SqliteWrapper.update(getApplicationContext(), getContentResolver(), Telephony.Sms.Outbox.CONTENT_URI, contentValues, "type = 4", (String[]) null);
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a(f14578b, "moveOutboxMessagesToFailedBox messageCount: " + iUpdate);
        }
        return iUpdate;
    }

    /* renamed from: a */
    private Uri m15548a(Context context, SmsMessage[] smsMessageArr, int i, String str, boolean z) {
        SmsMessage smsMessage = smsMessageArr[0];
        if (smsMessage.getMessageClass() == SmsMessage.MessageClass.CLASS_0) {
            m15555a(context, smsMessage, str);
            return null;
        }
        if (smsMessage.isReplace()) {
            return m15549a(context, smsMessageArr, i, z);
        }
        return m15563b(context, smsMessageArr, i, z);
    }

    /* renamed from: a */
    private Uri m15549a(Context context, SmsMessage[] smsMessageArr, int i, boolean z) {
        SmsMessage smsMessage = smsMessageArr[0];
        ContentValues contentValuesM15547a = m15547a(smsMessage);
        contentValuesM15547a.put(VKApiConst.ERROR_CODE, Integer.valueOf(i));
        int length = smsMessageArr.length;
        if (length == 1) {
            contentValuesM15547a.put("body", m15552a(smsMessage.getDisplayMessageBody()));
        } else {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (i2 < length) {
                SmsMessage smsMessage2 = smsMessageArr[i2];
                if (smsMessage2.mWrappedSmsMessage != null) {
                    sb.append(smsMessage2.getDisplayMessageBody());
                }
                i2++;
                smsMessage = smsMessage2;
            }
            contentValuesM15547a.put("body", m15552a(sb.toString()));
        }
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {smsMessage.getOriginatingAddress(), Integer.toString(smsMessage.getProtocolIdentifier())};
        Uri uri = Telephony.Sms.Inbox.CONTENT_URI;
        if (z) {
            uri = C4012bp.f14471g;
        }
        Cursor cursorQuery = SqliteWrapper.query(context, contentResolver, uri, f14581l, "address = ? AND protocol = ?", strArr, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, cursorQuery.getLong(0));
                    SqliteWrapper.update(context, contentResolver, uriWithAppendedId, contentValuesM15547a, (String) null, (String[]) null);
                    return uriWithAppendedId;
                }
            } finally {
                cursorQuery.close();
            }
        }
        return m15563b(context, smsMessageArr, i, z);
    }

    /* renamed from: a */
    public static String m15552a(String str) {
        return str.replace('\f', '\n');
    }

    /* renamed from: a */
    private void m15554a(Context context, ContentResolver contentResolver, SmsMessage[] smsMessageArr, SmsMessage smsMessage, int i, C2201o c2201o, Long l, C3782a c3782a, String str, String str2, boolean z) throws IllegalStateException, Resources.NotFoundException, IOException, SecurityException, IllegalArgumentException {
        boolean zM8931a = C1813b.m8906b().m8931a(c2201o.f7839b);
        if (!zM8931a) {
            String strM15553a = m15553a(smsMessageArr, smsMessage, i);
            long timestampMillis = smsMessage.getTimestampMillis();
            long jCurrentTimeMillis = System.currentTimeMillis();
            C1813b.m8906b().m8928a(str2, strM15553a, c2201o.f7839b, c2201o.f7846i, c2201o.f7852o, c2201o.f7853p, m15546a(context, l.longValue(), timestampMillis), c3782a != null ? c3782a.m14264f() : str, C2198l.m9956i(contentResolver, c2201o.f7839b), jCurrentTimeMillis, z, true);
            return;
        }
        if (zM8931a && z && f14580h != null) {
            String messageBody = smsMessage.getMessageBody();
            Intent intent = new Intent();
            intent.setClass(context, SmsReceiverService.class);
            intent.putExtra(this.f14587i, messageBody);
            intent.putExtra(this.f14588j, str);
            SmsReceiver.m15544a(context, intent);
        }
    }

    /* renamed from: b */
    private Uri m15563b(Context context, SmsMessage[] smsMessageArr, int i, boolean z) throws Throwable {
        SmsMessage smsMessage;
        String strM15552a;
        SmsMessage smsMessage2 = smsMessageArr[0];
        ContentValues contentValuesM15547a = m15547a(smsMessage2);
        contentValuesM15547a.put(VKApiConst.ERROR_CODE, Integer.valueOf(i));
        int length = smsMessageArr.length;
        try {
            if (length == 1) {
                strM15552a = m15552a(smsMessage2.getDisplayMessageBody());
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < length; i2++) {
                    smsMessage2 = smsMessageArr[i2];
                    if (smsMessage2.mWrappedSmsMessage != null) {
                        sb.append(smsMessage2.getDisplayMessageBody());
                    }
                }
                strM15552a = m15552a(sb.toString());
            }
            contentValuesM15547a.put("body", strM15552a);
            smsMessage = smsMessage2;
        } catch (NullPointerException e) {
            C3890m.m14996b(f14578b, "sms.getDisplayMessageBody() is null");
            smsMessage = smsMessage2;
        }
        Long asLong = contentValuesM15547a.getAsLong("thread_id");
        String asString = contentValuesM15547a.getAsString("address");
        String string = null;
        C3782a c3782aM14204a = null;
        if (!TextUtils.isEmpty(asString)) {
            c3782aM14204a = C3782a.m14204a(asString, true);
            if (c3782aM14204a != null) {
                string = c3782aM14204a.m14262d();
            }
        } else {
            string = getString(R.string.unknown_sender);
            contentValuesM15547a.put("address", string);
        }
        if ((asLong == null || asLong.longValue() == 0) && string != null && !z) {
            asLong = Long.valueOf(Telephony.Threads.getOrCreateThreadId(context, string));
            contentValuesM15547a.put("thread_id", asLong);
        }
        Long l = asLong;
        ContentResolver contentResolver = context.getContentResolver();
        if (z) {
            return SqliteWrapper.insert(context, contentResolver, C4012bp.f14471g, contentValuesM15547a);
        }
        SqliteWrapper.insert(context, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, contentValuesM15547a);
        Uri.Builder builderAppendId = ContentUris.appendId(Telephony.Threads.CONTENT_URI.buildUpon(), l.longValue());
        builderAppendId.appendPath("subject");
        Uri uriBuild = builderAppendId.build();
        String[] strArr = new String[5];
        strArr[0] = "date";
        strArr[1] = "recipient_ids";
        strArr[2] = "snippet";
        strArr[3] = (C3847e.m14627K() && C3847e.m14628L()) ? "unread_count" : "-1";
        strArr[4] = "snippet_cs";
        Cursor cursorQuery = contentResolver.query(uriBuild, strArr, null, null, null);
        long j = 0;
        String string2 = null;
        String string3 = null;
        int i3 = 0;
        int i4 = 0;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    j = cursorQuery.getLong(0);
                    string2 = cursorQuery.getString(1);
                    string3 = cursorQuery.getString(2);
                    i3 = cursorQuery.getInt(3);
                    i4 = cursorQuery.getInt(4);
                }
            } finally {
                cursorQuery.close();
            }
        }
        if (C4822an.m18203M()) {
            C3789h c3789hM14303a = null;
            if (!TextUtils.isEmpty(string2)) {
                c3789hM14303a = C3789h.m14303a(string2, true);
            }
            String strM15012a = C3892o.m15012a(context, contentResolver, c3789hM14303a);
            if (strM15012a != null) {
                C2202p.m9975a(context, contentResolver, true, strM15012a, c3789hM14303a, i3, string3, i4, j, l.longValue());
                m15554a(context, contentResolver, smsMessageArr, smsMessage, length, C2202p.m9994k(getContentResolver(), Long.toString(l.longValue())), l, c3782aM14204a, string, strM15012a, true);
                AbstractC3900w.m15065a().m15068a(getApplicationContext(), l.longValue());
                C0991aa.m6037a().m18961c(new C1015an(new String[0]));
                C0991aa.m6037a().m18961c(new C1066bf(C1828q.f6913a, -1));
                return null;
            }
        }
        Uri uriBuild2 = Uri.withAppendedPath(C2299s.f8209a, "sms").buildUpon().appendQueryParameter("incoming", "true").build();
        ContentValues contentValuesM15251a = C3947e.m15251a(j, l.longValue(), string3, i4, string2);
        contentValuesM15251a.put("inbox_unread_count", Integer.valueOf(i3));
        Uri uriInsert = contentResolver.insert(uriBuild2, contentValuesM15251a);
        C3896s.m15044b("Inserted Uri" + uriInsert, f14578b);
        C2201o c2201o = new C2201o();
        c2201o.f7839b = String.valueOf(l);
        m15554a(context, contentResolver, smsMessageArr, smsMessage, length, c2201o, l, c3782aM14204a, string, asString, false);
        C0991aa.m6037a().m18961c(new C1015an(new String[0]));
        C0991aa.m6037a().m18961c(new C1066bf(C1828q.f6913a, -1));
        AbstractC3900w.m15065a().m15068a(getApplicationContext(), l.longValue());
        return uriInsert;
    }

    /* renamed from: a */
    private long m15546a(Context context, long j, long j2) {
        long j3;
        Cursor cursorQuery = context.getContentResolver().query(Telephony.Sms.Inbox.CONTENT_URI, new String[]{"_id"}, "thread_id = " + j + " AND date_sent = " + j2, null, null);
        if (cursorQuery == null) {
            return 0L;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                j3 = 0;
            } else {
                j3 = cursorQuery.getLong(0);
            }
            return j3;
        } finally {
            cursorQuery.close();
        }
    }

    /* renamed from: a */
    private String m15553a(SmsMessage[] smsMessageArr, SmsMessage smsMessage, int i) {
        if (i == 1) {
            return m15552a(smsMessage.getDisplayMessageBody());
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            SmsMessage smsMessage2 = smsMessageArr[i2];
            if (smsMessage2.mWrappedSmsMessage != null) {
                sb.append(smsMessage2.getDisplayMessageBody());
            }
        }
        return m15552a(sb.toString());
    }

    /* renamed from: a */
    private ContentValues m15547a(SmsMessage smsMessage) {
        ContentValues contentValues = new ContentValues();
        String displayMessageBody = smsMessage.getDisplayMessageBody();
        if (displayMessageBody.startsWith("#[")) {
            String[] strArrSplit = displayMessageBody.split("\\r?\\n");
            if (strArrSplit[0].endsWith("]#")) {
                contentValues.put("address", strArrSplit[0].substring("#[".length(), strArrSplit[0].length() - "]#".length()));
            } else {
                contentValues.put("address", smsMessage.getDisplayOriginatingAddress());
            }
        } else {
            contentValues.put("address", smsMessage.getDisplayOriginatingAddress());
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2011, 8, 18);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        long jCurrentTimeMillis = System.currentTimeMillis();
        gregorianCalendar2.setTimeInMillis(jCurrentTimeMillis);
        if (gregorianCalendar2.before(gregorianCalendar)) {
            jCurrentTimeMillis = smsMessage.getTimestampMillis();
        }
        contentValues.put("date", new Long(jCurrentTimeMillis));
        contentValues.put("date_sent", Long.valueOf(smsMessage.getTimestampMillis()));
        contentValues.put("protocol", Integer.valueOf(smsMessage.getProtocolIdentifier()));
        contentValues.put("read", (Integer) 0);
        contentValues.put("seen", (Integer) 0);
        if (smsMessage.getPseudoSubject().length() > 0) {
            contentValues.put("subject", smsMessage.getPseudoSubject());
        }
        contentValues.put("reply_path_present", Integer.valueOf(smsMessage.isReplyPathPresent() ? 1 : 0));
        contentValues.put("service_center", smsMessage.getServiceCenterAddress());
        return contentValues;
    }

    /* renamed from: a */
    private void m15555a(Context context, SmsMessage smsMessage, String str) {
        context.startActivity(new Intent(context, (Class<?>) ClassZeroActivity.class).putExtra("pdu", smsMessage.getPdu()).putExtra("format", str).setFlags(402653184));
    }

    /* renamed from: d */
    private void m15571d() {
        Context applicationContext = getApplicationContext();
        m15572e();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SERVICE_STATE");
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a(f14578b, "registerForServiceStateChanges");
        }
        applicationContext.registerReceiver(SmsReceiver.m15542a(), intentFilter);
    }

    /* renamed from: e */
    private void m15572e() {
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a(f14578b, "unRegisterForServiceStateChanges");
        }
        try {
            getApplicationContext().unregisterReceiver(SmsReceiver.m15542a());
        } catch (IllegalArgumentException e) {
        }
    }

    /* renamed from: a */
    public static void m15558a(ChatFragment chatFragment) {
        f14580h = chatFragment;
    }
}
