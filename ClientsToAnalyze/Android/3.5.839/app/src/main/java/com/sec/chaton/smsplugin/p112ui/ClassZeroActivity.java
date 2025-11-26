package com.sec.chaton.smsplugin.p112ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class ClassZeroActivity extends Activity {

    /* renamed from: a */
    private static final int f14746a = "         ".length() * 2;

    /* renamed from: b */
    private static final String[] f14747b = {"_id", "address", "protocol"};

    /* renamed from: c */
    private SmsMessage f14748c = null;

    /* renamed from: d */
    private boolean f14749d = false;

    /* renamed from: e */
    private long f14750e = 0;

    /* renamed from: f */
    private AlertDialog f14751f = null;

    /* renamed from: g */
    private final Handler f14752g = new HandlerC4334j(this);

    /* renamed from: h */
    private final DialogInterface.OnClickListener f14753h = new DialogInterfaceOnClickListenerC4344k(this);

    /* renamed from: i */
    private final DialogInterface.OnClickListener f14754i = new DialogInterfaceOnClickListenerC4345l(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15741a() {
        if (this.f14748c.isReplace()) {
            m15743b(this.f14748c);
        } else {
            m15745c(this.f14748c);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(R.drawable.class_zero_background);
        this.f14748c = SmsMessage.createFromPdu(getIntent().getByteArrayExtra("pdu"), getIntent().getStringExtra("format"));
        String messageBody = this.f14748c.getMessageBody();
        String string = messageBody.toString();
        if (TextUtils.isEmpty(string)) {
            finish();
            return;
        }
        if (string.length() < f14746a) {
            messageBody = "         " + string + "         ";
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.f14751f = new AlertDialog.Builder(this).setMessage(messageBody).setPositiveButton(R.string.save, this.f14754i).setNegativeButton(android.R.string.cancel, this.f14753h).setCancelable(false).show();
        this.f14750e = jUptimeMillis + 300000;
        if (bundle != null) {
            this.f14750e = bundle.getLong("timer_fire", this.f14750e);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.f14750e <= SystemClock.uptimeMillis()) {
            this.f14752g.sendEmptyMessage(1);
        } else {
            this.f14752g.sendEmptyMessageAtTime(1, this.f14750e);
            C3890m.m14996b("display_00", "onRestart time = " + Long.toString(this.f14750e) + " " + toString());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("timer_fire", this.f14750e);
        C3890m.m14996b("display_00", "onSaveInstanceState time = " + Long.toString(this.f14750e) + " " + toString());
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f14752g.removeMessages(1);
        C3890m.m14996b("display_00", "onStop time = " + Long.toString(this.f14750e) + " " + toString());
    }

    /* renamed from: a */
    private ContentValues m15740a(SmsMessage smsMessage) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", smsMessage.getDisplayOriginatingAddress());
        contentValues.put("date", new Long(System.currentTimeMillis()));
        contentValues.put("protocol", Integer.valueOf(smsMessage.getProtocolIdentifier()));
        contentValues.put("read", Integer.valueOf(this.f14749d ? 1 : 0));
        contentValues.put("seen", Integer.valueOf(this.f14749d ? 1 : 0));
        if (smsMessage.getPseudoSubject().length() > 0) {
            contentValues.put("subject", smsMessage.getPseudoSubject());
        }
        contentValues.put("reply_path_present", Integer.valueOf(smsMessage.isReplyPathPresent() ? 1 : 0));
        contentValues.put("service_center", smsMessage.getServiceCenterAddress());
        return contentValues;
    }

    /* renamed from: b */
    private Uri m15743b(SmsMessage smsMessage) {
        ContentValues contentValuesM15740a = m15740a(smsMessage);
        contentValuesM15740a.put("body", smsMessage.getMessageBody());
        ContentResolver contentResolver = getContentResolver();
        Cursor cursorQuery = SqliteWrapper.query(this, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, f14747b, "address = ? AND protocol = ?", new String[]{smsMessage.getOriginatingAddress(), Integer.toString(smsMessage.getProtocolIdentifier())}, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, cursorQuery.getLong(0));
                    SqliteWrapper.update(this, contentResolver, uriWithAppendedId, contentValuesM15740a, (String) null, (String[]) null);
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return m15745c(smsMessage);
    }

    /* renamed from: c */
    private Uri m15745c(SmsMessage smsMessage) {
        ContentValues contentValuesM15740a = m15740a(smsMessage);
        contentValuesM15740a.put("body", smsMessage.getDisplayMessageBody());
        ContentResolver contentResolver = getContentResolver();
        C3890m.m14996b("display_00", "storeMessage " + toString());
        return SqliteWrapper.insert(this, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, contentValuesM15740a);
    }
}
