package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C4812ad;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: BuddyProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.gv */
/* loaded from: classes.dex */
class AsyncTaskC1342gv extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ File f4921a;

    /* renamed from: b */
    final /* synthetic */ BuddyProfileImageViewFragment f4922b;

    AsyncTaskC1342gv(BuddyProfileImageViewFragment buddyProfileImageViewFragment, File file) {
        this.f4922b = buddyProfileImageViewFragment;
        this.f4921a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        Bitmap bitmapM18145a;
        if (this.f4921a.length() <= 0 || (bitmapM18145a = C4812ad.m18145a(this.f4922b.f4037P, this.f4921a.getAbsolutePath())) == null) {
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
            this.f4922b.f4046i.setImageBitmap(bitmap);
            return;
        }
        synchronized (BuddyProfileImageView.class) {
            if (this.f4922b.f4037P != null) {
                C5179v.m19810a(this.f4922b.f4037P, R.string.toast_error, 0).show();
                this.f4922b.f4046i.setImageResource(R.drawable.profile_photo_buddy_default);
            }
        }
    }
}
