package com.sec.chaton.userprofile;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.userprofile.UserProfileImageView;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1791w;
import java.io.IOException;

/* compiled from: UserProfileImageView.java */
/* renamed from: com.sec.chaton.userprofile.cp */
/* loaded from: classes.dex */
class AsyncTaskC1693cp extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView.UserProfileImageViewFragment f6190a;

    AsyncTaskC1693cp(UserProfileImageView.UserProfileImageViewFragment userProfileImageViewFragment) {
        this.f6190a = userProfileImageViewFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            Bitmap bitmapM6100b = C1791w.m6100b(this.f6190a.getActivity(), Uri.parse(this.f6190a.f6102t + "/myprofile.png_"), 800);
            if (bitmapM6100b != null) {
                return Bitmap.createScaledBitmap(bitmapM6100b, 800, 800, true);
            }
            return null;
        } catch (IOException e) {
            C1786r.m6056a(e, getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f6190a.f6089g.setImageBitmap(bitmap);
        } else {
            this.f6190a.f6089g.setImageResource(R.drawable.mypage_noimage);
        }
    }
}
