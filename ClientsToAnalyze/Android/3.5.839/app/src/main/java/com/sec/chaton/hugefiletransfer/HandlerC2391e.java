package com.sec.chaton.hugefiletransfer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.C0036av;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.util.C4904y;
import java.io.File;

/* compiled from: HugeFileSendingMessageService.java */
/* renamed from: com.sec.chaton.hugefiletransfer.e */
/* loaded from: classes.dex */
class HandlerC2391e extends Handler {

    /* renamed from: a */
    final /* synthetic */ HugeFileSendingMessageService f8502a;

    HandlerC2391e(HugeFileSendingMessageService hugeFileSendingMessageService) {
        this.f8502a = hugeFileSendingMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        File file;
        C0788l c0788l = (C0788l) ((C1770hp) message.obj).m8779a();
        if (this.f8502a.f8476b.containsKey(Long.valueOf(c0788l.m3153h()))) {
            if ((message.what == 0 || message.what == 4) && c0788l.f2172a) {
                Intent intent = (Intent) this.f8502a.f8476b.get(Long.valueOf(c0788l.m3153h()));
                PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("huge_file_pending_intent");
                long longExtra = intent.getLongExtra("huge_file_request_id", 0L);
                String stringExtra = intent.getStringExtra("inboxNO");
                int intExtra = intent.getIntExtra("huge_file_max_upload_count", 0);
                int intExtra2 = intent.getIntExtra("huge_file_upload_count", 0);
                if (intent.getData() == null) {
                    file = null;
                } else {
                    file = new File(intent.getData().toString());
                }
                if (file != null) {
                    C0036av c0036av = new C0036av(this.f8502a.getApplicationContext());
                    c0036av.m143a(file.getName()).m146c(this.f8502a.getString(R.string.hugefile_file_sended) + "\n" + file.getName()).m145b(this.f8502a.getString(R.string.hugefile_file_sended)).m140a(R.drawable.chaton_quick_icon).m142a(pendingIntent).m144a(true);
                    ((NotificationManager) this.f8502a.getSystemService("notification")).notify((int) longExtra, c0036av.m139a());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("message_inbox_no", stringExtra);
                    contentValues.put("message_content", String.format("%d,%d,%d", Integer.valueOf(EnumC2231as.HUGEFILE.m10100a()), Integer.valueOf(intExtra), Integer.valueOf(intExtra - intExtra2)));
                    contentValues.put("_id", Long.valueOf(longExtra));
                    AsyncTaskC2389c.m10386a(4, contentValues).execute(new Void[0]);
                    this.f8502a.f8476b.remove(Long.valueOf(longExtra));
                    if (this.f8502a.f8476b.isEmpty()) {
                        this.f8502a.f8477c.m9267b(this.f8502a.f8478d);
                        if (C4904y.f17872b) {
                            C4904y.m18639b("hugefile messageHandler removeHandler", HugeFileSendingMessageService.f8475a);
                        }
                    }
                }
            }
        }
    }
}
