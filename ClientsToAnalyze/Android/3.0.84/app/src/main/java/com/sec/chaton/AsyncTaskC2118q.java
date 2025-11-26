package com.sec.chaton;

import android.os.AsyncTask;
import android.widget.Toast;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;

/* compiled from: ExitAppDialogActivity.java */
/* renamed from: com.sec.chaton.q */
/* loaded from: classes.dex */
class AsyncTaskC2118q extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    int f8055a;

    /* renamed from: b */
    final /* synthetic */ ExitAppDialogActivity f8056b;

    private AsyncTaskC2118q(ExitAppDialogActivity exitAppDialogActivity) {
        this.f8056b = exitAppDialogActivity;
    }

    /* synthetic */ AsyncTaskC2118q(ExitAppDialogActivity exitAppDialogActivity, DialogInterfaceOnClickListenerC1947p dialogInterfaceOnClickListenerC1947p) {
        this(exitAppDialogActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        this.f8055a = C1156ak.m5507a(false);
        return null;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f8056b.f681e = ProgressDialogC3265l.m11489a(this.f8056b.f680d, null, this.f8056b.getResources().getString(R.string.wait_sending));
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f8056b.f681e != null && this.f8056b.f681e.isShowing()) {
            this.f8056b.f681e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        if (this.f8056b.f681e != null && this.f8056b.f681e.isShowing()) {
            this.f8056b.f681e.dismiss();
        }
        if (this.f8055a == 0) {
            if (C3159aa.m10962a().m10987b("exit_app_done")) {
                C3159aa.m10962a().m10981a("exit_app_done");
            }
        } else if (this.f8055a == 1) {
            Toast.makeText(CommonApplication.m11493l(), R.string.popup_not_enough_memory, 0).show();
        } else if (this.f8055a == 2) {
            Toast.makeText(CommonApplication.m11493l(), R.string.toast_dereg_failed, 0).show();
        }
        GlobalApplication.m6449a(this.f8056b);
        this.f8056b.finish();
    }
}
