package com.sec.chaton.localbackup.p045a;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.localbackup.database.C1641a;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.p070a.C3338g;
import com.sec.widget.C3641ai;
import java.io.IOException;

/* compiled from: BackupFileDownloadHelperTask.java */
/* renamed from: com.sec.chaton.localbackup.a.b */
/* loaded from: classes.dex */
class HandlerC1611b extends Handler {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1610a f5999a;

    HandlerC1611b(AsyncTaskC1610a asyncTaskC1610a) {
        this.f5999a = asyncTaskC1610a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (this.f5999a.f5995j) {
                    int i = message.arg1;
                    C3250y.m11450b("file progress: " + i, AsyncTaskC1610a.f5986a);
                    this.f5999a.f5993h.m11483a(i);
                    break;
                }
                break;
            case 2:
                if (this.f5999a.f5993h != null) {
                    this.f5999a.f5993h.dismiss();
                }
                C1613d c1613d = (C1613d) ((C3338g) message.obj).m11768a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("message_download_uri", c1613d.f6003b);
                contentValues.put("message_type", (Integer) 4);
                if (c1613d.f6006e == EnumC1455w.AUDIO) {
                    String strM11423b = C3243r.m11423b(c1613d.f6003b);
                    if (!TextUtils.isEmpty(strM11423b)) {
                        contentValues.put("message_formatted", strM11423b);
                    }
                }
                this.f5999a.f5987b.getContentResolver().update(C1641a.m6918b(), contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(c1613d.f6002a), c1613d.f6004c, c1613d.f6005d});
                if (this.f5999a.f5994i != null) {
                    Message message2 = new Message();
                    message2.what = message.what;
                    message2.obj = message.obj;
                    this.f5999a.f5994i.sendMessage(message2);
                    break;
                }
                break;
            case 3:
            case 4:
                if (this.f5999a.f5994i != null) {
                    Message message3 = new Message();
                    message3.what = message.what;
                    message3.obj = message.obj;
                    this.f5999a.f5994i.sendMessage(message3);
                }
                if (this.f5999a.f5993h != null) {
                    this.f5999a.f5993h.dismiss();
                }
                C3641ai.m13210a(CommonApplication.m11493l(), R.string.media_download_fail, 0).show();
                break;
        }
    }
}
