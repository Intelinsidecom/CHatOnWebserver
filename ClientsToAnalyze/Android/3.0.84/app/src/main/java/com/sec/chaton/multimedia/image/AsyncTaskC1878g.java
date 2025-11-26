package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: ImageEffectFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.g */
/* loaded from: classes.dex */
public class AsyncTaskC1878g extends AsyncTask<String, Integer, Object> {

    /* renamed from: a */
    final /* synthetic */ ImageEffectFragment f7139a;

    /* renamed from: b */
    private View f7140b;

    /* renamed from: c */
    private Bitmap f7141c;

    public AsyncTaskC1878g(ImageEffectFragment imageEffectFragment, View view, Bitmap bitmap) {
        this.f7139a = imageEffectFragment;
        this.f7140b = view;
        this.f7141c = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object doInBackground(String... strArr) {
        return this.f7139a.m7563a(EnumC1880i.m7714a(this.f7140b.getId()), this.f7141c);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        try {
            this.f7139a.f6897n.show();
            this.f7139a.m7571d();
            ((TextView) this.f7140b.findViewById(R.id.filter_name)).setTextColor(this.f7139a.f6896m);
            ((ImageView) this.f7140b.findViewById(R.id.filter_image_view)).setImageResource(R.drawable.gridview_selector_focused);
        } catch (Exception e) {
            C3250y.m11443a(e, ImageEffectFragment.f6884a);
        } catch (OutOfMemoryError e2) {
            C3250y.m11443a(e2, ImageEffectFragment.f6884a);
        }
        super.onPreExecute();
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        try {
            this.f7139a.f6897n.hide();
            if ((obj instanceof Bitmap) && !((Bitmap) obj).isRecycled()) {
                this.f7139a.f6888e = (Bitmap) obj;
                this.f7139a.f6886c.setImageBitmap((Bitmap) obj);
            } else if (obj instanceof OutOfMemoryError) {
                this.f7139a.f6892i.show();
            } else {
                C3641ai.m13210a(this.f7139a.f6893j, R.string.toast_error, 0).show();
            }
        } catch (Exception e) {
            C3250y.m11443a(e, ImageEffectFragment.f6884a);
        } catch (OutOfMemoryError e2) {
            C3250y.m11443a(e2, ImageEffectFragment.f6884a);
        }
    }
}
