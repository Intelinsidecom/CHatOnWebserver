package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.os.AsyncTask;
import com.sec.chaton.util.C1786r;
import java.util.Timer;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ao */
/* loaded from: classes.dex */
class AsyncTaskC1360ao extends AsyncTask {

    /* renamed from: a */
    Activity f5183a;

    /* renamed from: b */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5184b;

    /* renamed from: c */
    private Boolean f5185c = false;

    /* renamed from: d */
    private Timer f5186d = null;

    public AsyncTaskC1360ao(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity, SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity2) {
        this.f5184b = snsFriendsUsingChatOnActivity;
        this.f5183a = snsFriendsUsingChatOnActivity2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(long[]... jArr) {
        try {
            m5093a();
            if (this.f5184b.f4993k.equals("facebook")) {
                this.f5184b.m4853h();
            } else if (!this.f5184b.f4993k.equals("twitter")) {
                if (this.f5184b.f4993k.equals("weibo")) {
                    this.f5184b.f4994l = this.f5184b.m4852g();
                }
            } else {
                this.f5184b.f4994l = this.f5184b.m4849f();
            }
            return null;
        } catch (RuntimeException e) {
            e.printStackTrace();
            C1786r.m6061b("Exception is occurred in doInBackground, GetFriendsWithSnsTask", getClass().getSimpleName());
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5184b.m4855i();
        m5093a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        if (!this.f5184b.f4993k.equals("facebook")) {
            if (this.f5184b.f4993k.equals("twitter") || this.f5184b.f4993k.equals("weibo")) {
                this.f5184b.m4846d();
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        m5094b();
        synchronized (this.f5185c) {
            if (this.f5185c.booleanValue()) {
                C1786r.m6054a("onError()", SnsFriendsUsingChatOnActivity.f4981d);
            } else {
                C1786r.m6061b("Request Canceled.", SnsFriendsUsingChatOnActivity.f4981d);
            }
            this.f5185c = false;
        }
    }

    /* renamed from: a */
    private void m5093a() {
        C1361ap c1361ap = new C1361ap(this);
        m5094b();
        C1786r.m6061b("startTimeOutCheckTask()", SnsFriendsUsingChatOnActivity.f4981d);
        this.f5186d = new Timer();
        this.f5186d.schedule(c1361ap, 30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5094b() {
        if (this.f5186d != null) {
            C1786r.m6061b("cancelTimeOutCheckTask()", SnsFriendsUsingChatOnActivity.f4981d);
            this.f5186d.cancel();
            this.f5186d = null;
        }
    }
}
