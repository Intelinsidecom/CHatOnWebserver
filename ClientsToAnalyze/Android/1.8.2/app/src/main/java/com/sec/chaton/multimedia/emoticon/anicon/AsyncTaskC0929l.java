package com.sec.chaton.multimedia.emoticon.anicon;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.C2153y;
import java.io.IOException;

/* compiled from: AniconPackageDetailActivity.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.l */
/* loaded from: classes.dex */
public class AsyncTaskC0929l extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDetailActivity f3477a;

    /* renamed from: b */
    private Activity f3478b;

    /* renamed from: c */
    private ProgressDialogC1806j f3479c;

    /* renamed from: d */
    private String f3480d;

    public AsyncTaskC0929l(AniconPackageDetailActivity aniconPackageDetailActivity, Activity activity, String str) {
        this.f3477a = aniconPackageDetailActivity;
        this.f3478b = activity;
        this.f3480d = str;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f3479c = new ProgressDialogC1806j(this.f3478b, false);
        this.f3479c.setMessage(this.f3478b.getString(R.string.buddy_list_progress_dialog_message));
        this.f3479c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        try {
            C0921d.m3798d(this.f3478b, strArr[0]);
            return null;
        } catch (IOException e) {
            if (C1786r.f6455e) {
                C1786r.m6056a(e, AniconPackageDetailActivity.f3389a);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r5) throws Resources.NotFoundException {
        super.onPostExecute(r5);
        if (this.f3479c != null) {
            this.f3479c.dismiss();
        }
        C2153y.m7536a(this.f3478b, String.format(this.f3478b.getString(R.string.anicon_package_uninstall_complete), this.f3480d), 0).show();
        this.f3477a.m3700a();
    }
}
