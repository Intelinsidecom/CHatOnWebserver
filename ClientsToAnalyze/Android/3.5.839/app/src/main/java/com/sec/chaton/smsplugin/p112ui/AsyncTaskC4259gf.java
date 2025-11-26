package com.sec.chaton.smsplugin.p112ui;

import android.app.ProgressDialog;
import android.os.AsyncTask;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gf */
/* loaded from: classes.dex */
class AsyncTaskC4259gf extends AsyncTask<Runnable, Void, Void> {

    /* renamed from: a */
    final int f15623a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15624b;

    public AsyncTaskC4259gf(PluginComposeMessageActivity pluginComposeMessageActivity, int i) {
        this.f15624b = pluginComposeMessageActivity;
        this.f15623a = i;
        if (pluginComposeMessageActivity.f14999as == null) {
            pluginComposeMessageActivity.f14999as = m16470a();
        }
    }

    /* renamed from: a */
    private ProgressDialog m16470a() {
        ProgressDialog progressDialog = new ProgressDialog(this.f15624b);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(0);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(this.f15624b.getText(this.f15623a));
        return progressDialog;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f15624b.f15047bx.postDelayed(this.f15624b.f15007bA, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Runnable... runnableArr) {
        if (runnableArr != null) {
            for (Runnable runnable : runnableArr) {
                try {
                    runnable.run();
                } finally {
                    this.f15624b.f15047bx.removeCallbacks(this.f15624b.f15007bA);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        if (this.f15624b.f14999as != null && this.f15624b.f14999as.isShowing()) {
            this.f15624b.f14999as.dismiss();
        }
    }
}
