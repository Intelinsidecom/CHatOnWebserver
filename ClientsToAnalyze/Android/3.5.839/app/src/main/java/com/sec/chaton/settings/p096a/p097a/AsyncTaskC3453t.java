package com.sec.chaton.settings.p096a.p097a;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.settings.p096a.C3455ab;
import com.sec.chaton.shop.entrys.DeleteRequestEntry;
import com.sec.chaton.shop.entrys.DeleteResponseEntry;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.io.IOException;

/* compiled from: SoundUninstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.t */
/* loaded from: classes.dex */
public class AsyncTaskC3453t extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private static final String f12901a = AsyncTaskC3453t.class.getSimpleName();

    /* renamed from: b */
    private Activity f12902b;

    /* renamed from: c */
    private ProgressDialogC4926s f12903c;

    /* renamed from: d */
    private boolean f12904d;

    /* renamed from: e */
    private Handler f12905e;

    /* renamed from: f */
    private DeleteRequestEntry f12906f;

    /* renamed from: g */
    private Message f12907g;

    /* renamed from: a */
    public static AsyncTaskC3453t m13738a(Activity activity, boolean z, Handler handler, DeleteRequestEntry deleteRequestEntry) {
        return new AsyncTaskC3453t(activity, z, handler, deleteRequestEntry);
    }

    private AsyncTaskC3453t(Activity activity, boolean z, Handler handler, DeleteRequestEntry deleteRequestEntry) {
        this.f12902b = activity;
        this.f12904d = z;
        this.f12905e = handler;
        this.f12906f = deleteRequestEntry;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f12903c = new ProgressDialogC4926s(this.f12902b, false);
        this.f12903c.setMessage(this.f12902b.getString(R.string.buddy_list_progress_dialog_message));
        this.f12903c.show();
        DeleteResponseEntry deleteResponseEntry = new DeleteResponseEntry(this.f12906f.itemType, this.f12906f.itemId);
        this.f12907g = new Message();
        this.f12907g.what = 5;
        this.f12907g.obj = deleteResponseEntry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        String str = strArr[0];
        try {
            C3455ab.m13745a(this.f12902b, str);
            if (C3455ab.m13747a(str)) {
                C3455ab.m13751b();
                return null;
            }
            return null;
        } catch (IOException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f12901a);
            }
            Bundle bundle = new Bundle();
            bundle.putString("itemdelete_result", this.f12906f.error);
            this.f12907g.setData(bundle);
            this.f12905e.sendMessage(this.f12907g);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        if (this.f12903c != null) {
            this.f12903c.dismiss();
        }
        Bundle bundle = new Bundle();
        bundle.putString("itemdelete_result", this.f12906f.success);
        this.f12907g.setData(bundle);
        this.f12905e.sendMessage(this.f12907g);
        if (this.f12904d) {
            this.f12902b.finish();
        }
    }
}
