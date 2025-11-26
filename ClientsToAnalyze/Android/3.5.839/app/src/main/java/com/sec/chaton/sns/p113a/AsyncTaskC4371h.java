package com.sec.chaton.sns.p113a;

import android.os.AsyncTask;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.Timer;

/* compiled from: SnsManager.java */
/* renamed from: com.sec.chaton.sns.a.h */
/* loaded from: classes.dex */
public class AsyncTaskC4371h extends AsyncTask<AbstractC4370g, Integer, Integer> {

    /* renamed from: a */
    final /* synthetic */ AbstractC4369f f15839a;

    /* renamed from: b */
    private int f15840b;

    /* renamed from: c */
    private Object f15841c;

    /* renamed from: d */
    private Boolean f15842d = false;

    /* renamed from: e */
    private Timer f15843e = null;

    public AsyncTaskC4371h(AbstractC4369f abstractC4369f, int i) {
        this.f15839a = abstractC4369f;
        this.f15840b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(AbstractC4370g... abstractC4370gArr) {
        AbstractC4370g abstractC4370g = null;
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            return -1006;
        }
        int i = 0;
        int iMo16575a = -1;
        while (true) {
            if (i >= abstractC4370gArr.length) {
                break;
            }
            abstractC4370g = abstractC4370gArr[i];
            this.f15839a.m16571a("Request:" + this.f15840b + " Task : " + abstractC4370g + "\t[" + (i + 1) + "/" + abstractC4370gArr.length + "]");
            m16577a();
            iMo16575a = abstractC4370g.mo16575a();
            m16578b();
            if (iMo16575a == -1) {
                i++;
            } else {
                this.f15839a.m16571a("Result : " + iMo16575a + "\t[" + (i + 1) + "/" + abstractC4370gArr.length + "]");
                break;
            }
        }
        if (abstractC4370g == null) {
            return Integer.valueOf(DlcApi.RC_SVC_NOT_CONNECTED);
        }
        this.f15841c = abstractC4370g.m16574b();
        return Integer.valueOf(iMo16575a);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        m16578b();
        synchronized (this.f15839a.f15833d) {
            if (this.f15842d.booleanValue()) {
                this.f15839a.m16572b("onError()");
                this.f15839a.f15831b.mo16563a(this.f15840b, DlcApi.RC_SVC_NOT_CONNECTED, null);
            } else {
                this.f15839a.m16571a("Request:" + this.f15840b + " Canceled.");
                this.f15839a.f15831b.mo16563a(this.f15840b, 0, null);
            }
            this.f15842d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        this.f15839a.f15834e.remove(this);
        if (num.intValue() <= -1000) {
            this.f15839a.m16572b("Request:" + this.f15840b + ", Error. " + num + " " + this.f15841c);
        } else {
            this.f15839a.m16571a("Request:" + this.f15840b + " Done. " + num + " " + this.f15841c);
        }
        this.f15839a.f15831b.mo16563a(this.f15840b, num.intValue(), this.f15841c);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f15839a.m16571a("Request:" + this.f15840b + " Start.");
        m16577a();
        this.f15839a.f15834e.add(this);
    }

    /* renamed from: a */
    private void m16577a() {
        C4372i c4372i = new C4372i(this);
        m16578b();
        this.f15839a.m16572b("startTimeOutCheckTask()");
        this.f15843e = new Timer();
        this.f15843e.schedule(c4372i, 30000L);
    }

    /* renamed from: b */
    private void m16578b() {
        if (this.f15843e != null) {
            this.f15839a.m16572b("cancelTimeOutCheckTask()");
            this.f15843e.cancel();
            this.f15843e = null;
        }
    }
}
