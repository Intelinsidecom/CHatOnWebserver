package com.sec.chaton.settings.p096a.p097a;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.settings.p096a.C3471o;
import com.sec.chaton.shop.entrys.DeleteRequestEntry;
import com.sec.chaton.shop.entrys.DeleteResponseEntry;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.io.IOException;

/* compiled from: FontUninstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.g */
/* loaded from: classes.dex */
public class AsyncTaskC3440g extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private static final String f12865a = AsyncTaskC3440g.class.getSimpleName();

    /* renamed from: b */
    private Activity f12866b;

    /* renamed from: c */
    private ProgressDialogC4926s f12867c;

    /* renamed from: d */
    private boolean f12868d;

    /* renamed from: e */
    private Handler f12869e;

    /* renamed from: f */
    private DeleteRequestEntry f12870f;

    /* renamed from: g */
    private Message f12871g;

    /* renamed from: a */
    public static AsyncTaskC3440g m13711a(Activity activity, boolean z, Handler handler, DeleteRequestEntry deleteRequestEntry) {
        return new AsyncTaskC3440g(activity, z, handler, deleteRequestEntry);
    }

    private AsyncTaskC3440g(Activity activity, boolean z, Handler handler, DeleteRequestEntry deleteRequestEntry) {
        this.f12866b = activity;
        this.f12868d = z;
        this.f12869e = handler;
        this.f12870f = deleteRequestEntry;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f12867c = new ProgressDialogC4926s(this.f12866b, false);
        this.f12867c.setMessage(this.f12866b.getString(R.string.buddy_list_progress_dialog_message));
        this.f12867c.show();
        DeleteResponseEntry deleteResponseEntry = new DeleteResponseEntry(this.f12870f.itemType, this.f12870f.itemId);
        this.f12871g = new Message();
        this.f12871g.what = 5;
        this.f12871g.obj = deleteResponseEntry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        String str = strArr[0];
        try {
            C3471o.m13801a(this.f12866b, str);
            if (C3471o.m13803a(str)) {
                C3471o.m13800a();
                return null;
            }
            return null;
        } catch (IOException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f12865a);
            }
            Bundle bundle = new Bundle();
            bundle.putString("itemdelete_result", this.f12870f.error);
            this.f12871g.setData(bundle);
            this.f12869e.sendMessage(this.f12871g);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        if (this.f12867c != null) {
            this.f12867c.dismiss();
        }
        Bundle bundle = new Bundle();
        bundle.putString("itemdelete_result", this.f12870f.success);
        this.f12871g.setData(bundle);
        this.f12869e.sendMessage(this.f12871g);
        if (this.f12868d) {
            this.f12866b.finish();
        }
    }
}
