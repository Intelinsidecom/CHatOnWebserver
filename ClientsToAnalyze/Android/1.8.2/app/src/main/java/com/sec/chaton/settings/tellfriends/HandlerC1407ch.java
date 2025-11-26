package com.sec.chaton.settings.tellfriends;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.sec.chaton.util.C1786r;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ch */
/* loaded from: classes.dex */
class HandlerC1407ch extends Handler {

    /* renamed from: a */
    final /* synthetic */ TellFriendsWeiboActivity f5271a;

    HandlerC1407ch(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5271a = tellFriendsWeiboActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 9001:
                for (int i = 0; i < this.f5271a.f5061g.size(); i++) {
                    this.f5271a.f5060f.add(this.f5271a.f5061g.get(i));
                    this.f5271a.f5076v.add(this.f5271a.f5061g.get(i));
                }
                this.f5271a.f5061g.clear();
                if (this.f5271a.f5059e != null && this.f5271a.f5059e.getStatus() == AsyncTask.Status.RUNNING) {
                    this.f5271a.f5059e.cancel(true);
                    this.f5271a.f5059e = null;
                }
                this.f5271a.m4993c();
                break;
            case 9002:
                int i2 = message.getData().getInt("Key_Position");
                if (i2 >= 0 && message.obj != null) {
                    if (i2 >= this.f5271a.f5050A && i2 < this.f5271a.f5050A + this.f5271a.f5051B) {
                        ((ImageView) message.obj).setBackgroundDrawable(((C1417cr) this.f5271a.f5060f.get(i2)).f5287b);
                        break;
                    }
                } else {
                    C1786r.m6063c("handleMessage() \t- Thumbnail image downloading failed", TellFriendsWeiboActivity.f5049b);
                    break;
                }
                break;
        }
        super.handleMessage(message);
    }
}
