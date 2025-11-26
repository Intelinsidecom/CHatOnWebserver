package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C3162ad;
import com.sec.widget.C3641ai;
import java.io.File;

/* compiled from: GroupProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.hj */
/* loaded from: classes.dex */
class AsyncTaskC0753hj extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ File f3019a;

    /* renamed from: b */
    final /* synthetic */ GroupProfileImageViewFragment f3020b;

    AsyncTaskC0753hj(GroupProfileImageViewFragment groupProfileImageViewFragment, File file) {
        this.f3020b = groupProfileImageViewFragment;
        this.f3019a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        Bitmap bitmapM11000a;
        if (this.f3019a.length() <= 0 || (bitmapM11000a = C3162ad.m11000a(this.f3020b.f2262r, this.f3019a.getAbsolutePath())) == null) {
            return null;
        }
        return bitmapM11000a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f3020b.f2247c.setImageBitmap(bitmap);
            return;
        }
        synchronized (GroupProfileImageViewActivity.class) {
            if (this.f3020b.f2262r != null) {
                C3641ai.m13210a(this.f3020b.f2262r, R.string.toast_error, 0).show();
                this.f3020b.f2247c.setImageResource(R.drawable.contacts_default_group);
            }
        }
    }
}
