package com.sec.vip.cropimage;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.k */
/* loaded from: classes.dex */
public class AsyncTaskC3615k extends AsyncTask<String, Integer, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ CropImage f13287a;

    /* renamed from: b */
    private View f13288b;

    /* renamed from: c */
    private Bitmap f13289c;

    public AsyncTaskC3615k(CropImage cropImage, View view, Bitmap bitmap) {
        this.f13287a = cropImage;
        this.f13288b = view;
        this.f13289c = bitmap;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f13287a.f13158M = false;
        this.f13287a.m12905i();
        ((TextView) this.f13288b.findViewById(R.id.text_filter_name)).setSelected(true);
        ((ImageView) this.f13288b.findViewById(R.id.image_filter_effect)).setSelected(true);
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) {
        return this.f13287a.m12879b(this.f13289c, this.f13288b.getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            this.f13287a.f13185x = this.f13287a.f13184w;
            this.f13287a.f13184w = bitmap;
            this.f13287a.m12884b(false);
        }
        this.f13287a.f13158M = true;
        super.onPostExecute(bitmap);
    }
}
