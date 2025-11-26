package com.sec.chaton.multimedia.image;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.global.GlobalApplication;
import java.io.File;

/* compiled from: GifViewTask.java */
@TargetApi(14)
/* renamed from: com.sec.chaton.multimedia.image.c */
/* loaded from: classes.dex */
public class AsyncTaskC2843c extends AsyncTask<String, Integer, GifView> {

    /* renamed from: a */
    private String f10438a;

    /* renamed from: b */
    private ViewGroup f10439b;

    /* renamed from: c */
    private View f10440c;

    /* renamed from: d */
    private GifView f10441d;

    /* renamed from: e */
    private Handler f10442e;

    /* renamed from: f */
    private boolean f10443f;

    private AsyncTaskC2843c(String str, ViewGroup viewGroup, View view, Handler handler, boolean z) {
        this.f10438a = str;
        this.f10439b = viewGroup;
        this.f10440c = view;
        this.f10442e = handler;
        this.f10443f = z;
    }

    /* renamed from: a */
    public static AsyncTaskC2843c m11934a(String str, ViewGroup viewGroup, View view, Handler handler) {
        return new AsyncTaskC2843c(str, viewGroup, view, handler, true);
    }

    /* renamed from: a */
    public static AsyncTaskC2843c m11935a(String str, ViewGroup viewGroup, View view, Handler handler, boolean z) {
        return new AsyncTaskC2843c(str, viewGroup, view, handler, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GifView doInBackground(String... strArr) {
        GifView gifView = new GifView(GlobalApplication.m18732r(), new File(this.f10438a).getAbsolutePath(), this.f10442e, this.f10443f);
        if (isCancelled() && gifView != null) {
            m11937a();
        }
        return gifView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(GifView gifView) {
        if (gifView == null || !gifView.m11760b()) {
            if (this.f10442e != null) {
                Message messageObtainMessage = this.f10442e.obtainMessage();
                messageObtainMessage.obj = this.f10438a;
                this.f10442e.sendMessage(messageObtainMessage);
                return;
            }
            return;
        }
        if (this.f10439b != null) {
            this.f10441d = gifView;
            this.f10441d.setLayerType(1, null);
            if (this.f10440c != null) {
                if (!this.f10443f) {
                    ViewGroup.LayoutParams layoutParams = this.f10440c.getLayoutParams();
                    layoutParams.width = this.f10440c.getWidth();
                    layoutParams.height = this.f10440c.getHeight();
                    this.f10441d.setLayoutParams(layoutParams);
                }
                this.f10440c.setVisibility(4);
            }
            this.f10439b.addView(this.f10441d);
        }
    }

    /* renamed from: a */
    public void m11937a() {
        if (this.f10441d != null) {
            this.f10441d.m11759a();
            if (this.f10439b != null) {
                this.f10439b.removeView(this.f10441d);
            }
            this.f10441d = null;
        }
    }
}
