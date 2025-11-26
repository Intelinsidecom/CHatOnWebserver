package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: ImageEffectFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.h */
/* loaded from: classes.dex */
public class AsyncTaskC2848h extends AsyncTask<String, Integer, Object> {

    /* renamed from: a */
    final /* synthetic */ ImageEffectFragment f10460a;

    /* renamed from: b */
    private View f10461b;

    /* renamed from: c */
    private Bitmap f10462c;

    /* synthetic */ AsyncTaskC2848h(ImageEffectFragment imageEffectFragment, View view, Bitmap bitmap, ViewOnFocusChangeListenerC2846f viewOnFocusChangeListenerC2846f) {
        this(imageEffectFragment, view, bitmap);
    }

    private AsyncTaskC2848h(ImageEffectFragment imageEffectFragment, View view, Bitmap bitmap) {
        this.f10460a = imageEffectFragment;
        this.f10461b = view;
        this.f10462c = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object doInBackground(String... strArr) {
        return this.f10460a.m11768a(EnumC2850j.m11945a(this.f10461b.getId()), this.f10462c);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        try {
            this.f10460a.f10195m.show();
            this.f10460a.m11776d();
            ((TextView) this.f10461b.findViewById(R.id.filter_name)).setTextColor(this.f10460a.f10194l);
            ((ImageView) this.f10461b.findViewById(R.id.filter_image_view)).setImageResource(R.drawable.gridview_selector_focused);
        } catch (Exception e) {
            C4904y.m18635a(e, ImageEffectFragment.f10183a);
        } catch (OutOfMemoryError e2) {
            C4904y.m18635a(e2, ImageEffectFragment.f10183a);
        }
        super.onPreExecute();
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        try {
            this.f10460a.f10195m.hide();
            if ((obj instanceof Bitmap) && !((Bitmap) obj).isRecycled()) {
                this.f10460a.f10187e = (Bitmap) obj;
                this.f10460a.f10185c.setImageBitmap((Bitmap) obj);
            } else if (obj instanceof OutOfMemoryError) {
                this.f10460a.f10191i.show();
            } else {
                C5179v.m19810a(this.f10460a.f10192j, R.string.toast_error, 0).show();
            }
        } catch (Exception e) {
            C4904y.m18635a(e, ImageEffectFragment.f10183a);
        } catch (OutOfMemoryError e2) {
            C4904y.m18635a(e2, ImageEffectFragment.f10183a);
        }
    }
}
