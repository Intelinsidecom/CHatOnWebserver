package com.sec.chaton.multimedia.image;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: ImageEffectFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.k */
/* loaded from: classes.dex */
public class AsyncTaskC2851k extends AsyncTask<String, Integer, Object> {

    /* renamed from: a */
    final /* synthetic */ ImageEffectFragment f10483a;

    /* renamed from: b */
    private View f10484b;

    /* renamed from: c */
    private String f10485c;

    /* synthetic */ AsyncTaskC2851k(ImageEffectFragment imageEffectFragment, View view, String str, ViewOnFocusChangeListenerC2846f viewOnFocusChangeListenerC2846f) {
        this(imageEffectFragment, view, str);
    }

    private AsyncTaskC2851k(ImageEffectFragment imageEffectFragment, View view, String str) {
        this.f10483a = imageEffectFragment;
        this.f10484b = view;
        this.f10485c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object doInBackground(String... strArr) {
        if (this.f10483a.f10188f == null) {
            this.f10483a.f10188f = C4894o.m18598a(CommonApplication.m18732r(), new File(this.f10485c), true, false, false);
        }
        return this.f10483a.m11768a(EnumC2850j.m11945a(this.f10484b.getId()), this.f10483a.f10188f);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override // android.os.AsyncTask
    @SuppressLint({"NewApi"})
    protected void onPostExecute(Object obj) {
        try {
            if ((obj instanceof Bitmap) && !((Bitmap) obj).isRecycled()) {
                if (Build.VERSION.SDK_INT < 16) {
                    ((ImageView) this.f10484b.findViewById(R.id.filter_image_view)).setBackgroundDrawable(new BitmapDrawable(this.f10483a.getResources(), (Bitmap) obj));
                } else {
                    ((ImageView) this.f10484b.findViewById(R.id.filter_image_view)).setBackground(new BitmapDrawable(this.f10483a.getResources(), (Bitmap) obj));
                }
                if (this.f10483a.f10190h.containsKey(EnumC2850j.m11945a(this.f10484b.getId()))) {
                    this.f10483a.f10190h.remove(EnumC2850j.m11945a(this.f10484b.getId()));
                    return;
                }
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Failed PreviewFilterTask : " + EnumC2850j.m11945a(this.f10484b.getId()).name(), ImageEffectFragment.f10183a);
            }
            this.f10483a.f10190h.put(EnumC2850j.m11945a(this.f10484b.getId()), this.f10484b);
        } catch (Exception e) {
            C4904y.m18635a(e, ImageEffectFragment.f10183a);
        } catch (OutOfMemoryError e2) {
            C4904y.m18635a(e2, ImageEffectFragment.f10183a);
        }
    }
}
