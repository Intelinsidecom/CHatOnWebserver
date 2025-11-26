package com.sec.chaton.settings.downloads.p056a;

import android.app.Activity;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.widget.C3641ai;
import java.io.IOException;

/* compiled from: AniconUninstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.h */
/* loaded from: classes.dex */
public class AsyncTaskC2517h extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private static final String f9629a = AsyncTaskC2517h.class.getSimpleName();

    /* renamed from: b */
    private Activity f9630b;

    /* renamed from: c */
    private ProgressDialogC3265l f9631c;

    /* renamed from: d */
    private boolean f9632d;

    public AsyncTaskC2517h(Activity activity, boolean z) {
        this.f9630b = activity;
        this.f9632d = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f9631c = new ProgressDialogC3265l(this.f9630b, false);
        this.f9631c.setMessage(this.f9630b.getString(R.string.buddy_list_progress_dialog_message));
        this.f9631c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        try {
            C2646u.m9670f(this.f9630b, strArr[0]);
            return null;
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9629a);
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
        if (this.f9631c != null) {
            this.f9631c.dismiss();
        }
        C3641ai.m13211a(this.f9630b, this.f9630b.getString(R.string.download_uninstalled), 0).show();
        if (this.f9632d) {
            this.f9630b.finish();
        }
    }
}
