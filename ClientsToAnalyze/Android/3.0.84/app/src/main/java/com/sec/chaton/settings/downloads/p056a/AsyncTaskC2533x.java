package com.sec.chaton.settings.downloads.p056a;

import android.app.Activity;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.settings.downloads.C2620df;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.widget.C3641ai;
import java.io.IOException;

/* compiled from: SoundUninstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.x */
/* loaded from: classes.dex */
public class AsyncTaskC2533x extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private static final String f9664a = AsyncTaskC2533x.class.getSimpleName();

    /* renamed from: b */
    private Activity f9665b;

    /* renamed from: c */
    private ProgressDialogC3265l f9666c;

    /* renamed from: d */
    private boolean f9667d;

    public AsyncTaskC2533x(Activity activity, boolean z) {
        this.f9665b = activity;
        this.f9667d = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f9666c = new ProgressDialogC3265l(this.f9665b, false);
        this.f9666c.setMessage(this.f9665b.getString(R.string.buddy_list_progress_dialog_message));
        this.f9666c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        String str = strArr[0];
        try {
            C2620df.m9595a(this.f9665b, str);
            if (C2620df.m9599a(str)) {
                C2620df.m9603b();
                return null;
            }
            return null;
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9664a);
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
        if (this.f9666c != null) {
            this.f9666c.dismiss();
        }
        C3641ai.m13211a(this.f9665b, this.f9665b.getString(R.string.download_uninstalled), 0).show();
        if (this.f9667d) {
            this.f9665b.finish();
        }
    }
}
