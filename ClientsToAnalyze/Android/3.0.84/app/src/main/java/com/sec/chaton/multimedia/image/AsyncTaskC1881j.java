package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: ImageEffectFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.j */
/* loaded from: classes.dex */
public class AsyncTaskC1881j extends AsyncTask<String, Integer, Object> {

    /* renamed from: a */
    final /* synthetic */ ImageEffectFragment f7162a;

    /* renamed from: b */
    private View f7163b;

    /* renamed from: c */
    private String f7164c;

    public AsyncTaskC1881j(ImageEffectFragment imageEffectFragment, View view, String str) {
        this.f7162a = imageEffectFragment;
        this.f7163b = view;
        this.f7164c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object doInBackground(String... strArr) {
        if (this.f7162a.f6889f == null) {
            this.f7162a.f6889f = C3243r.m11414a(CommonApplication.m11493l(), new File(this.f7164c), true, false, false);
        }
        return this.f7162a.m7563a(EnumC1880i.m7714a(this.f7163b.getId()), this.f7162a.f6889f);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        try {
            if ((obj instanceof Bitmap) && !((Bitmap) obj).isRecycled()) {
                if (Build.VERSION.SDK_INT < 16) {
                    ((ImageView) this.f7163b.findViewById(R.id.filter_image_view)).setBackgroundDrawable(new BitmapDrawable(this.f7162a.getResources(), (Bitmap) obj));
                } else {
                    ((ImageView) this.f7163b.findViewById(R.id.filter_image_view)).setBackground(new BitmapDrawable(this.f7162a.getResources(), (Bitmap) obj));
                }
                if (this.f7162a.f6891h.containsKey(EnumC1880i.m7714a(this.f7163b.getId()))) {
                    this.f7162a.f6891h.remove(EnumC1880i.m7714a(this.f7163b.getId()));
                    return;
                }
                return;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("Failed PreviewFilterTask : " + EnumC1880i.m7714a(this.f7163b.getId()).name(), ImageEffectFragment.f6884a);
            }
            this.f7162a.f6891h.put(EnumC1880i.m7714a(this.f7163b.getId()), this.f7163b);
        } catch (Exception e) {
            C3250y.m11443a(e, ImageEffectFragment.f6884a);
        } catch (OutOfMemoryError e2) {
            C3250y.m11443a(e2, ImageEffectFragment.f6884a);
        }
    }
}
