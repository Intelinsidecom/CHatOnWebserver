package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C4812ad;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: GroupProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.hp */
/* loaded from: classes.dex */
class AsyncTaskC1363hp extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ File f4953a;

    /* renamed from: b */
    final /* synthetic */ GroupProfileImageViewFragment f4954b;

    AsyncTaskC1363hp(GroupProfileImageViewFragment groupProfileImageViewFragment, File file) {
        this.f4954b = groupProfileImageViewFragment;
        this.f4953a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        Bitmap bitmapM18145a;
        if (this.f4953a.length() <= 0 || (bitmapM18145a = C4812ad.m18145a(this.f4954b.f4120r, this.f4953a.getAbsolutePath())) == null) {
            return null;
        }
        return bitmapM18145a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f4954b.f4105c.setImageBitmap(bitmap);
            return;
        }
        synchronized (GroupProfileImageViewActivity.class) {
            if (this.f4954b.f4120r != null) {
                C5179v.m19810a(this.f4954b.f4120r, R.string.toast_error, 0).show();
                this.f4954b.f4105c.setImageResource(R.drawable.profile_photo_group_default);
            }
        }
    }
}
