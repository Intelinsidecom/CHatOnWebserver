package com.sec.chaton.settings.tellfriends.common;

import android.os.AsyncTask;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.Timer;

/* compiled from: SnsManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.q */
/* loaded from: classes.dex */
public class AsyncTaskC2801q extends AsyncTask<AbstractC2800p, Integer, Integer> {

    /* renamed from: a */
    final /* synthetic */ AbstractC2799o f10307a;

    /* renamed from: b */
    private int f10308b;

    /* renamed from: c */
    private Object f10309c;

    /* renamed from: d */
    private Boolean f10310d = false;

    /* renamed from: e */
    private Timer f10311e = null;

    public AsyncTaskC2801q(AbstractC2799o abstractC2799o, int i) {
        this.f10307a = abstractC2799o;
        this.f10308b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(AbstractC2800p... abstractC2800pArr) {
        AbstractC2800p abstractC2800p = null;
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            return -1006;
        }
        int i = 0;
        int iMo9862a = -1;
        while (true) {
            if (i >= abstractC2800pArr.length) {
                break;
            }
            abstractC2800p = abstractC2800pArr[i];
            this.f10307a.m10014b("Request:" + this.f10308b + " Task : " + abstractC2800p + "\t[" + (i + 1) + "/" + abstractC2800pArr.length + "]");
            m10021a();
            iMo9862a = abstractC2800p.mo9862a();
            m10022b();
            if (iMo9862a == -1) {
                i++;
            } else {
                this.f10307a.m10014b("Result : " + iMo9862a + "\t[" + (i + 1) + "/" + abstractC2800pArr.length + "]");
                break;
            }
        }
        if (abstractC2800p == null) {
            return Integer.valueOf(DlcApi.RC_SVC_NOT_CONNECTED);
        }
        this.f10309c = abstractC2800p.m10018b();
        return Integer.valueOf(iMo9862a);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        m10022b();
        synchronized (this.f10310d) {
            if (this.f10310d.booleanValue()) {
                this.f10307a.m10015c("onError()");
                this.f10307a.f10301c.mo9799a(this.f10308b, DlcApi.RC_SVC_NOT_CONNECTED, null);
            } else {
                this.f10307a.m10014b("Request:" + this.f10308b + " Canceled.");
                this.f10307a.f10301c.mo9799a(this.f10308b, 0, null);
            }
            this.f10310d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        this.f10307a.f10302d.remove(this);
        if (num.intValue() <= -1000) {
            this.f10307a.m10015c("Request:" + this.f10308b + ", Error. " + num + " " + this.f10309c);
        } else {
            this.f10307a.m10014b("Request:" + this.f10308b + " Done. " + num + " " + this.f10309c);
        }
        this.f10307a.f10301c.mo9799a(this.f10308b, num.intValue(), this.f10309c);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f10307a.m10014b("Request:" + this.f10308b + " Start.");
        m10021a();
        this.f10307a.f10302d.add(this);
    }

    /* renamed from: a */
    private void m10021a() {
        C2802r c2802r = new C2802r(this);
        m10022b();
        this.f10307a.m10015c("startTimeOutCheckTask()");
        this.f10311e = new Timer();
        this.f10311e.schedule(c2802r, 30000L);
    }

    /* renamed from: b */
    private void m10022b() {
        if (this.f10311e != null) {
            this.f10307a.m10015c("cancelTimeOutCheckTask()");
            this.f10311e.cancel();
            this.f10311e = null;
        }
    }
}
