package com.sec.chaton.localbackup.p075a;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.localbackup.database.C2543a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.p133a.C5023g;
import com.sec.widget.C5179v;

/* compiled from: BackupFileDownloadHelperTask.java */
/* renamed from: com.sec.chaton.localbackup.a.b */
/* loaded from: classes.dex */
class HandlerC2511b extends Handler {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC2510a f9041a;

    HandlerC2511b(AsyncTaskC2510a asyncTaskC2510a) {
        this.f9041a = asyncTaskC2510a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (this.f9041a.f9037j) {
                    int i = message.arg1;
                    C4904y.m18639b("file progress: " + i, AsyncTaskC2510a.f9028a);
                    this.f9041a.f9035h.m18719a(i);
                    break;
                }
                break;
            case 2:
                if (this.f9041a.f9035h != null) {
                    this.f9041a.f9035h.dismiss();
                }
                C2513d c2513d = (C2513d) ((C5023g) message.obj).m19082a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("message_download_uri", c2513d.f9045b);
                contentValues.put("message_type", (Integer) 4);
                if (c2513d.f9048e == EnumC2214ab.AUDIO) {
                    String strM18613b = C4894o.m18613b(c2513d.f9045b);
                    if (!TextUtils.isEmpty(strM18613b)) {
                        contentValues.put("message_formatted", strM18613b);
                    }
                }
                this.f9041a.f9029b.getContentResolver().update(C2543a.m10950c(), contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(c2513d.f9044a), c2513d.f9046c, c2513d.f9047d});
                if (this.f9041a.f9036i != null) {
                    Message message2 = new Message();
                    message2.what = message.what;
                    message2.obj = message.obj;
                    this.f9041a.f9036i.sendMessage(message2);
                    break;
                }
                break;
            case 3:
            case 4:
                if (this.f9041a.f9036i != null) {
                    Message message3 = new Message();
                    message3.what = message.what;
                    message3.obj = message.obj;
                    this.f9041a.f9036i.sendMessage(message3);
                }
                if (this.f9041a.f9035h != null) {
                    this.f9041a.f9035h.dismiss();
                }
                C5179v.m19810a(CommonApplication.m18732r(), R.string.media_download_fail, 0).show();
                break;
        }
    }
}
