package com.sec.chaton.settings.downloads.p056a;

import android.app.Activity;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.widget.C3641ai;
import java.io.IOException;

/* compiled from: SkinUninstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.u */
/* loaded from: classes.dex */
public class AsyncTaskC2530u extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private static final String f9657a = AsyncTaskC2530u.class.getSimpleName();

    /* renamed from: b */
    private Activity f9658b;

    /* renamed from: c */
    private ProgressDialogC3265l f9659c;

    /* renamed from: d */
    private boolean f9660d;

    public AsyncTaskC2530u(Activity activity, boolean z) {
        this.f9658b = activity;
        this.f9660d = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f9659c = new ProgressDialogC3265l(this.f9658b, false);
        this.f9659c.setMessage(this.f9658b.getString(R.string.buddy_list_progress_dialog_message));
        this.f9659c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        String str = strArr[0];
        try {
            C2591cd.m9587j(this.f9658b, str);
            if (C2591cd.m9575b(str)) {
                C2591cd.m9583f();
                return null;
            }
            return null;
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9657a);
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
        if (this.f9659c != null) {
            this.f9659c.dismiss();
        }
        C3641ai.m13211a(this.f9658b, this.f9658b.getString(R.string.download_uninstalled), 0).show();
        if (this.f9660d) {
            this.f9658b.finish();
        }
    }
}
