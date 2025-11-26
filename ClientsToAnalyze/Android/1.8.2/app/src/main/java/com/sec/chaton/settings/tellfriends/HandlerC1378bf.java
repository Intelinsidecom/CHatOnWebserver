package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.sec.chaton.util.C1786r;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bf */
/* loaded from: classes.dex */
class HandlerC1378bf extends Handler {

    /* renamed from: a */
    final /* synthetic */ TWFollowingsListActivity f5218a;

    HandlerC1378bf(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5218a = tWFollowingsListActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 9001:
                for (int i = 0; i < this.f5218a.f5020g.size(); i++) {
                    this.f5218a.f5019f.add(this.f5218a.f5020g.get(i));
                    this.f5218a.f5034u.add(this.f5218a.f5020g.get(i));
                }
                this.f5218a.f5020g.clear();
                if (this.f5218a.f5018e != null && this.f5218a.f5018e.getStatus() == AsyncTask.Status.RUNNING) {
                    this.f5218a.f5018e.cancel(true);
                    this.f5218a.f5018e = null;
                }
                this.f5218a.m4928c();
                break;
            case 9002:
                int i2 = message.getData().getInt("Key_Position");
                if (i2 >= 0 && message.obj != null) {
                    if (i2 >= this.f5218a.f5039z && i2 < this.f5218a.f5039z + this.f5218a.f5011A) {
                        ((ImageView) message.obj).setBackgroundDrawable(((C1383bk) this.f5218a.f5019f.get(i2)).f5223a);
                        break;
                    }
                } else {
                    C1786r.m6063c("handleMessage() \t- Thumbnail image downloading failed", TWFollowingsListActivity.f5010b);
                    break;
                }
                break;
        }
        super.handleMessage(message);
    }
}
