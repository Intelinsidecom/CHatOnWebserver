package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C3162ad;
import com.sec.widget.C3641ai;
import java.io.File;

/* compiled from: BuddyProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.fo */
/* loaded from: classes.dex */
class AsyncTaskC0704fo extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ File f2945a;

    /* renamed from: b */
    final /* synthetic */ BuddyProfileImageViewFragment f2946b;

    AsyncTaskC0704fo(BuddyProfileImageViewFragment buddyProfileImageViewFragment, File file) {
        this.f2946b = buddyProfileImageViewFragment;
        this.f2945a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        Bitmap bitmapM11000a;
        if (this.f2945a.length() <= 0 || (bitmapM11000a = C3162ad.m11000a(this.f2946b.f2141P, this.f2945a.getAbsolutePath())) == null) {
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
            this.f2946b.f2150i.setImageBitmap(bitmap);
            return;
        }
        synchronized (BuddyProfileImageView.class) {
            if (this.f2946b.f2141P != null) {
                C3641ai.m13210a(this.f2946b.f2141P, R.string.toast_error, 0).show();
                this.f2946b.f2150i.setImageResource(R.drawable.profile_photo_buddy_default);
            }
        }
    }
}
