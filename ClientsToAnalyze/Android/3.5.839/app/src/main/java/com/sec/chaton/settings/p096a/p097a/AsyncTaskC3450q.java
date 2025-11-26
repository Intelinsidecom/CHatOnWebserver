package com.sec.chaton.settings.p096a.p097a;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.shop.entrys.DeleteRequestEntry;
import com.sec.chaton.shop.entrys.DeleteResponseEntry;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.io.IOException;

/* compiled from: SkinUninstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.q */
/* loaded from: classes.dex */
public class AsyncTaskC3450q extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private static final String f12890a = AsyncTaskC3450q.class.getSimpleName();

    /* renamed from: b */
    private Activity f12891b;

    /* renamed from: c */
    private ProgressDialogC4926s f12892c;

    /* renamed from: d */
    private boolean f12893d;

    /* renamed from: e */
    private Handler f12894e;

    /* renamed from: f */
    private DeleteRequestEntry f12895f;

    /* renamed from: g */
    private Message f12896g;

    /* renamed from: a */
    public static AsyncTaskC3450q m13733a(Activity activity, boolean z, Handler handler, DeleteRequestEntry deleteRequestEntry) {
        return new AsyncTaskC3450q(activity, z, handler, deleteRequestEntry);
    }

    private AsyncTaskC3450q(Activity activity, boolean z, Handler handler, DeleteRequestEntry deleteRequestEntry) {
        this.f12891b = activity;
        this.f12893d = z;
        this.f12894e = handler;
        this.f12895f = deleteRequestEntry;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f12892c = new ProgressDialogC4926s(this.f12891b, false);
        this.f12892c.setMessage(this.f12891b.getString(R.string.buddy_list_progress_dialog_message));
        this.f12892c.show();
        DeleteResponseEntry deleteResponseEntry = new DeleteResponseEntry(this.f12895f.itemType, this.f12895f.itemId);
        this.f12896g = new Message();
        this.f12896g.what = 5;
        this.f12896g.obj = deleteResponseEntry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        String str = strArr[0];
        try {
            C3474r.m13842k(this.f12891b, str);
            C3474r.m13824b(str);
            return null;
        } catch (IOException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f12890a);
            }
            Bundle bundle = new Bundle();
            bundle.putString("itemdelete_result", this.f12895f.error);
            this.f12896g.setData(bundle);
            if (this.f12894e != null) {
                this.f12894e.sendMessage(this.f12896g);
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
        if (this.f12892c != null) {
            this.f12892c.dismiss();
        }
        Bundle bundle = new Bundle();
        bundle.putString("itemdelete_result", this.f12895f.success);
        this.f12896g.setData(bundle);
        if (this.f12894e != null) {
            this.f12894e.sendMessage(this.f12896g);
        }
        if (this.f12893d) {
            this.f12891b.finish();
        }
    }
}
