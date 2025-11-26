package com.sec.chaton.settings.downloads.p056a;

import android.app.Activity;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.widget.C3641ai;
import java.io.IOException;

/* compiled from: AmsItemUninstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.d */
/* loaded from: classes.dex */
public class AsyncTaskC2513d extends AsyncTask<Object, Void, Void> {

    /* renamed from: a */
    private static final String f9620a = AsyncTaskC2513d.class.getSimpleName();

    /* renamed from: b */
    private Activity f9621b;

    /* renamed from: c */
    private ProgressDialogC3265l f9622c;

    /* renamed from: d */
    private boolean f9623d;

    public AsyncTaskC2513d(Activity activity) {
        this.f9621b = activity;
        this.f9623d = false;
    }

    public AsyncTaskC2513d(Activity activity, boolean z) {
        this.f9621b = activity;
        this.f9623d = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f9622c = new ProgressDialogC3265l(this.f9621b, false);
        this.f9622c.setMessage(this.f9621b.getString(R.string.buddy_list_progress_dialog_message));
        this.f9622c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Object... objArr) {
        try {
            C2642q.m9641c(this.f9621b, (EnumC1327e) objArr[0], (String) objArr[1]);
            return null;
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9620a);
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
        if (this.f9622c != null) {
            this.f9622c.dismiss();
        }
        C3641ai.m13211a(this.f9621b, this.f9621b.getString(R.string.download_uninstalled), 0).show();
        if (this.f9623d) {
            this.f9621b.finish();
        }
    }
}
