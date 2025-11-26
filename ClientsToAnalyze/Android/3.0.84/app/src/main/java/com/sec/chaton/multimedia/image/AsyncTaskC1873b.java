package com.sec.chaton.multimedia.image;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.global.GlobalApplication;
import java.io.File;

/* compiled from: GifViewTask.java */
/* renamed from: com.sec.chaton.multimedia.image.b */
/* loaded from: classes.dex */
public class AsyncTaskC1873b extends AsyncTask<String, Integer, GifView> {

    /* renamed from: a */
    private String f7126a;

    /* renamed from: b */
    private ViewGroup f7127b;

    /* renamed from: c */
    private View f7128c;

    /* renamed from: d */
    private GifView f7129d;

    /* renamed from: e */
    private Handler f7130e;

    public AsyncTaskC1873b(String str, ViewGroup viewGroup, View view, Handler handler) {
        this.f7126a = str;
        this.f7127b = viewGroup;
        this.f7128c = view;
        this.f7130e = handler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GifView doInBackground(String... strArr) {
        return new GifView(GlobalApplication.m11493l(), new File(this.f7126a).getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(GifView gifView) {
        if (gifView == null || gifView.m7554b()) {
            if (this.f7130e != null) {
                Message messageObtainMessage = this.f7130e.obtainMessage();
                messageObtainMessage.obj = this.f7126a;
                this.f7130e.sendMessage(messageObtainMessage);
                return;
            }
            return;
        }
        if (this.f7127b != null) {
            this.f7129d = gifView;
            this.f7129d.setLayerType(1, null);
            this.f7127b.addView(gifView);
        }
        if (this.f7128c != null) {
            this.f7128c.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m7709a() {
        if (this.f7129d != null) {
            this.f7129d.m7553a();
        }
    }
}
