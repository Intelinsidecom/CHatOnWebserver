package com.sec.chaton.hugefiletransfer;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.C0036av;
import com.sec.chaton.R;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.util.C4809aa;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/* loaded from: classes.dex */
public class HugeFileSendingMessageService extends IntentService {

    /* renamed from: a */
    private static final String f8475a = HugeFileSendingMessageService.class.getSimpleName();

    /* renamed from: b */
    private HashMap<Long, Intent> f8476b;

    /* renamed from: c */
    private C2142w f8477c;

    /* renamed from: d */
    private Handler f8478d;

    /* renamed from: e */
    private Handler f8479e;

    public HugeFileSendingMessageService() {
        super(f8475a);
        this.f8478d = new HandlerC2391e(this);
        this.f8479e = new HandlerC2392f(this);
        this.f8476b = new HashMap<>();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        File file;
        long longExtra = intent.getLongExtra("huge_file_request_id", 0L);
        String stringExtra = intent.getStringExtra("inboxNO");
        EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(intent.getIntExtra("chatType", 0));
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("huge_file_pending_intent");
        if (intent.getData() == null) {
            file = null;
        } else {
            file = new File(intent.getData().toString());
        }
        if (file != null) {
            if (intent.getBooleanExtra("huge_file_result", false)) {
                long longExtra2 = intent.getLongExtra("huge_file_expired_time", 0L);
                int intExtra = intent.getIntExtra("huge_file_auth_code", 0);
                String stringExtra2 = intent.getStringExtra("huge_file_download_url");
                String str = String.format("[%s]\n%s (%.1f MB)\n%s: %s\n%s: %04d\n%s", getString(R.string.hugefile_large_file), file.getName(), Float.valueOf(file.length() / 1048576.0f), getString(R.string.hugefile_expiration_date), new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(longExtra2)), getString(R.string.hugefile_file_verification_code), Integer.valueOf(intExtra), stringExtra2);
                if (intent.getBooleanExtra("huge_file_from_chat", false)) {
                    this.f8476b.put(Long.valueOf(longExtra), intent);
                    String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                    String str2 = String.format("hugefile\n%s\n%s\n%s\n%s\n%s", null, stringExtra2, file.getName(), C4809aa.m18104a().m18121a("uid", ""), str);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("message_content", str2);
                    contentValues.put("message_is_failed", (Integer) 1);
                    contentValues.put("message_is_file_upload", (Integer) 1);
                    getContentResolver().update(C2306z.f8229a, contentValues, "_id=?", new String[]{String.valueOf(longExtra)});
                    this.f8477c = C2142w.m9593a(stringExtra, enumC2300tM10207a);
                    this.f8477c.m9246a(this.f8478d);
                    this.f8477c.m9620a(EnumC2214ab.HUGEFILE, stringArrayExtra, str2, EnumC2706n.f9699d, longExtra, EnumC2301u.NORMAL);
                    return;
                }
                return;
            }
            int intExtra2 = intent.getIntExtra("huge_file_error_code", 0);
            String stringExtra3 = intent.getStringExtra("huge_file_error_message");
            String string = getString(R.string.hugefile_sending_failed);
            String string2 = getString(R.string.hugefile_failed_to_send_file);
            if (intExtra2 > 0) {
                switch (intExtra2) {
                    case 39115:
                        try {
                            string2 = getString(R.string.hugefile_file_upload_count_error, new Object[]{Integer.valueOf(Integer.parseInt(stringExtra3))});
                        } catch (NumberFormatException e) {
                            string2 = getString(R.string.hugefile_file_upload_count_error, new Object[]{5});
                        }
                        string = string2;
                        break;
                    case 39116:
                        try {
                            string2 = getString(R.string.hugefile_file_size_error, new Object[]{Integer.valueOf(Integer.parseInt(stringExtra3) / 1073741824)});
                        } catch (NumberFormatException e2) {
                            string2 = getString(R.string.hugefile_file_size_error, new Object[]{1});
                        }
                        string = string2;
                        break;
                }
            }
            if (intent.getBooleanExtra("huge_file_from_chat", false)) {
                String str3 = String.format("[%s]\n%s (%.1f MB)\n%s", null, file.getName(), Float.valueOf(file.length() / 1048576.0f), string);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("message_content", String.format("hugefile\n%s\n%s\n%s\n%s\n%s", null, null, null, null, str3));
                contentValues2.put("message_type", (Integer) (-1));
                contentValues2.put("message_is_failed", (Integer) 2);
                getContentResolver().update(C2306z.f8229a, contentValues2, "_id=?", new String[]{String.valueOf(longExtra)});
            }
            C0036av c0036av = new C0036av(getApplicationContext());
            c0036av.m143a(file.getName()).m146c(string + "\n" + file.getName()).m145b(string).m140a(R.drawable.chaton_quick_icon).m142a(pendingIntent).m144a(true);
            ((NotificationManager) getSystemService("notification")).notify((int) longExtra, c0036av.m139a());
            this.f8479e.sendMessage(Message.obtain(this.f8479e, 1, string2));
        }
    }
}
