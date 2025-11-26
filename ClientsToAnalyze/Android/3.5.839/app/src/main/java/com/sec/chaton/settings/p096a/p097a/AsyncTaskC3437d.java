package com.sec.chaton.settings.p096a.p097a;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.shop.entrys.DeleteRequestEntry;
import com.sec.chaton.shop.entrys.DeleteResponseEntry;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: AniconUninstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.d */
/* loaded from: classes.dex */
public class AsyncTaskC3437d extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private static final String f12854a = AsyncTaskC3437d.class.getSimpleName();

    /* renamed from: b */
    private Activity f12855b;

    /* renamed from: c */
    private ProgressDialogC4926s f12856c;

    /* renamed from: d */
    private boolean f12857d;

    /* renamed from: e */
    private Handler f12858e;

    /* renamed from: f */
    private DeleteRequestEntry f12859f;

    /* renamed from: g */
    private Message f12860g;

    /* renamed from: a */
    public static AsyncTaskC3437d m13706a(Activity activity, boolean z, Handler handler, DeleteRequestEntry deleteRequestEntry) {
        return new AsyncTaskC3437d(activity, z, handler, deleteRequestEntry);
    }

    private AsyncTaskC3437d(Activity activity, boolean z, Handler handler, DeleteRequestEntry deleteRequestEntry) {
        this.f12855b = activity;
        this.f12857d = z;
        this.f12858e = handler;
        this.f12859f = deleteRequestEntry;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f12856c = new ProgressDialogC4926s(this.f12855b, false);
        this.f12856c.setMessage(this.f12855b.getString(R.string.buddy_list_progress_dialog_message));
        this.f12856c.show();
        DeleteResponseEntry deleteResponseEntry = new DeleteResponseEntry(this.f12859f.itemType, this.f12859f.itemId);
        this.f12860g = new Message();
        this.f12860g.what = 5;
        this.f12860g.obj = deleteResponseEntry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        String str = strArr[0];
        try {
            C3460d.m13770a(this.f12855b, str, EnumC2258bd.Anicon);
            return null;
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f12854a);
            }
            Bundle bundle = new Bundle();
            bundle.putString("itemdelete_result", this.f12859f.error);
            this.f12860g.setData(bundle);
            this.f12858e.sendMessage(this.f12860g);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        if (this.f12856c != null) {
            this.f12856c.dismiss();
        }
        Bundle bundle = new Bundle();
        bundle.putString("itemdelete_result", this.f12859f.success);
        this.f12860g.setData(bundle);
        this.f12858e.sendMessage(this.f12860g);
        if (this.f12857d) {
            this.f12855b.finish();
        }
    }
}
