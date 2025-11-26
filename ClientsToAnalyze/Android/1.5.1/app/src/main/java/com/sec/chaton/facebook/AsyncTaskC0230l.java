package com.sec.chaton.facebook;

import android.os.AsyncTask;
import com.facebook.android.SessionStore;

/* renamed from: com.sec.chaton.facebook.l */
/* loaded from: classes.dex */
class AsyncTaskC0230l extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ FacebookManager f1862a;

    /* renamed from: b */
    private int f1863b;

    /* renamed from: c */
    private String f1864c;

    private AsyncTaskC0230l(FacebookManager facebookManager, int i) {
        this.f1862a = facebookManager;
        this.f1863b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(AbstractC0231m... abstractC0231mArr) {
        AbstractC0231m abstractC0231m;
        int i;
        int iMo2365a = -1;
        int i2 = 0;
        AbstractC0231m abstractC0231m2 = null;
        while (true) {
            if (i2 >= abstractC0231mArr.length) {
                abstractC0231m = abstractC0231m2;
                i = iMo2365a;
                break;
            }
            abstractC0231m2 = abstractC0231mArr[i2];
            iMo2365a = abstractC0231m2.mo2365a();
            FacebookManager.m2348c("Request:" + this.f1863b + " Task : " + abstractC0231m2);
            if (iMo2365a != -1) {
                abstractC0231m = abstractC0231m2;
                i = iMo2365a;
                break;
            }
            i2++;
        }
        if (abstractC0231m == null) {
            return -1000;
        }
        this.f1864c = abstractC0231m.m2369b();
        return Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        if (num.intValue() <= -1000) {
            FacebookManager.m2349d("Request:" + this.f1863b + ", Error. " + num + " " + this.f1864c);
            if (num.intValue() == -1001) {
                SessionStore.m254a(this.f1862a.f1837b);
                FacebookManager.f1836a.m239a((String) null);
                FacebookManager.f1836a.m235a(0L);
            }
        } else {
            FacebookManager.m2348c("Request:" + this.f1863b + " Done. " + num + " " + this.f1864c);
        }
        this.f1862a.f1838c.onResult(this.f1863b, num.intValue(), this.f1864c);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        FacebookManager.m2348c("Request:" + this.f1863b + " Canceled.");
        this.f1862a.f1838c.onResult(this.f1863b, 0, null);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        FacebookManager.m2348c("Request:" + this.f1863b + " Start.");
    }
}
