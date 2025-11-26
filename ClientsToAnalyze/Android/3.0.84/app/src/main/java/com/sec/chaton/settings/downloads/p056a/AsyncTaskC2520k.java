package com.sec.chaton.settings.downloads.p056a;

import android.app.Activity;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.settings.downloads.C2570bj;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.widget.C3641ai;
import java.io.IOException;

/* compiled from: FontUninstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.k */
/* loaded from: classes.dex */
public class AsyncTaskC2520k extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private static final String f9636a = AsyncTaskC2520k.class.getSimpleName();

    /* renamed from: b */
    private Activity f9637b;

    /* renamed from: c */
    private ProgressDialogC3265l f9638c;

    /* renamed from: d */
    private boolean f9639d;

    public AsyncTaskC2520k(Activity activity, boolean z) {
        this.f9637b = activity;
        this.f9639d = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f9638c = new ProgressDialogC3265l(this.f9637b, false);
        this.f9638c.setMessage(this.f9637b.getString(R.string.buddy_list_progress_dialog_message));
        this.f9638c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        String str = strArr[0];
        try {
            C2570bj.m9511a(this.f9637b, str);
            if (C2570bj.m9514a(str)) {
                C2570bj.m9518b();
                return null;
            }
            return null;
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9636a);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        if (this.f9638c != null) {
            this.f9638c.dismiss();
        }
        C3641ai.m13211a(this.f9637b, this.f9637b.getString(R.string.download_uninstalled), 0).show();
        if (this.f9639d) {
            this.f9637b.finish();
        }
    }
}
