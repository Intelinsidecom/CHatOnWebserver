package com.sec.vip.cropimage;

import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.ae */
/* loaded from: classes.dex */
class AsyncTaskC3599ae extends AsyncTask<String, Integer, EnumC3598ad> {

    /* renamed from: a */
    final /* synthetic */ ImageModify f13260a;

    /* renamed from: b */
    private ImageModify f13261b;

    public AsyncTaskC3599ae(ImageModify imageModify, ImageModify imageModify2) {
        this.f13260a = imageModify;
        this.f13261b = null;
        this.f13261b = imageModify2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC3598ad doInBackground(String... strArr) {
        return (this.f13261b == null || this.f13261b.isFinishing()) ? EnumC3598ad.ERROR : this.f13261b.m12959d();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (this.f13261b != null && !this.f13261b.isFinishing()) {
            this.f13261b.m12945h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(EnumC3598ad enumC3598ad) {
        if (this.f13261b != null && !this.f13261b.isFinishing()) {
            this.f13261b.m12947i();
            switch (enumC3598ad) {
                case SUCCESS:
                    this.f13261b.m12943g();
                    break;
                case ERROR:
                    C3641ai.m13210a(this.f13260a.getApplicationContext(), R.string.toast_error, 1).show();
                    this.f13261b.setResult(0);
                    this.f13261b.finish();
                    break;
                case OOM:
                    C3641ai.m13210a(this.f13260a.getApplicationContext(), R.string.chat_view_memory_error, 1).show();
                    this.f13261b.setResult(0);
                    this.f13261b.finish();
                    break;
            }
        }
    }
}
