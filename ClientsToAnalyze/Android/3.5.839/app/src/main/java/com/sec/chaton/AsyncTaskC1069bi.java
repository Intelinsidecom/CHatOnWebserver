package com.sec.chaton;

import android.os.AsyncTask;
import android.widget.Toast;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.p055d.p056a.C1907ag;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;

/* compiled from: ExitAppDialogActivity.java */
/* renamed from: com.sec.chaton.bi */
/* loaded from: classes.dex */
class AsyncTaskC1069bi extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    int f3364a;

    /* renamed from: b */
    final /* synthetic */ ExitAppDialogActivity f3365b;

    private AsyncTaskC1069bi(ExitAppDialogActivity exitAppDialogActivity) {
        this.f3365b = exitAppDialogActivity;
    }

    /* synthetic */ AsyncTaskC1069bi(ExitAppDialogActivity exitAppDialogActivity, DialogInterfaceOnClickListenerC1068bh dialogInterfaceOnClickListenerC1068bh) {
        this(exitAppDialogActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        try {
            C2472w.m10687a().m10694f();
        } catch (InterruptedException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, this.f3365b.f1936f);
            }
        }
        this.f3364a = C1907ag.m9089a(false);
        return null;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f3365b.f1935e = ProgressDialogC4926s.m18727a(this.f3365b.f1934d, null, this.f3365b.getResources().getString(R.string.wait_sending));
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f3365b.f1935e != null && this.f3365b.f1935e.isShowing()) {
            this.f3365b.f1935e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        if (this.f3365b.f1935e != null && this.f3365b.f1935e.isShowing()) {
            this.f3365b.f1935e.dismiss();
        }
        if (this.f3364a == 0) {
            if (C4809aa.m18104a().m18129b("exit_app_done")) {
                C4809aa.m18104a().m18123a("exit_app_done");
            }
        } else if (this.f3364a == 1) {
            Toast.makeText(CommonApplication.m18732r(), R.string.popup_not_enough_memory, 0).show();
        } else if (this.f3364a == 2) {
            Toast.makeText(CommonApplication.m18732r(), R.string.toast_dereg_failed, 0).show();
        }
        C2602p.m11022d();
        C0991aa.m6037a().m18962d(new C1058ba());
        this.f3365b.finish();
    }
}
