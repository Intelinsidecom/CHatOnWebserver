package com.sec.chaton.sns.p114b;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/* compiled from: OdnoklassnikiManager.java */
/* renamed from: com.sec.chaton.sns.b.l */
/* loaded from: classes.dex */
public final class AsyncTaskC4428l extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    final /* synthetic */ C4427k f15994a;

    protected AsyncTaskC4428l(C4427k c4427k) {
        this.f15994a = c4427k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        try {
            return C4427k.f15987e.m17032a("users.getCurrentUser", null, "get");
        } catch (Exception e) {
            Log.e("Odnoklassniki", "Failed to get current user info", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (str != null) {
            this.f15994a.m16771c(str);
        } else {
            Toast.makeText(this.f15994a.f15989d, "Get current user result: null", 0).show();
        }
    }
}
