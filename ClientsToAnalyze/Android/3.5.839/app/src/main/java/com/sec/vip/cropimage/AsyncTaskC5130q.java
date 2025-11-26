package com.sec.vip.cropimage;

import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.q */
/* loaded from: classes.dex */
class AsyncTaskC5130q extends AsyncTask<String, Integer, EnumC5129p> {

    /* renamed from: a */
    final /* synthetic */ ImageModify f18709a;

    /* renamed from: b */
    private ImageModify f18710b;

    /* synthetic */ AsyncTaskC5130q(ImageModify imageModify, ImageModify imageModify2, ViewOnClickListenerC5116c viewOnClickListenerC5116c) {
        this(imageModify, imageModify2);
    }

    private AsyncTaskC5130q(ImageModify imageModify, ImageModify imageModify2) {
        this.f18709a = imageModify;
        this.f18710b = null;
        this.f18710b = imageModify2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC5129p doInBackground(String... strArr) {
        return (this.f18710b == null || this.f18710b.isFinishing()) ? EnumC5129p.ERROR : this.f18710b.m19544i();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (this.f18710b != null && !this.f18710b.isFinishing()) {
            this.f18710b.m19532m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(EnumC5129p enumC5129p) {
        if (this.f18710b != null && !this.f18710b.isFinishing()) {
            this.f18710b.m19534n();
            switch (enumC5129p) {
                case SUCCESS:
                    this.f18710b.m19530l();
                    break;
                case ERROR:
                    C5179v.m19810a(this.f18709a.getApplicationContext(), R.string.toast_error, 1).show();
                    this.f18710b.setResult(0);
                    this.f18710b.finish();
                    break;
                case OOM:
                    C5179v.m19810a(this.f18709a.getApplicationContext(), R.string.chat_view_memory_error, 1).show();
                    this.f18710b.setResult(0);
                    this.f18710b.finish();
                    break;
            }
        }
    }
}
