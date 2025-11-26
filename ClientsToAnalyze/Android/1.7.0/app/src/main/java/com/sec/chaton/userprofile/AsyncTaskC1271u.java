package com.sec.chaton.userprofile;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.userprofile.UserProfileImageView;
import com.sec.chaton.util.C1294aq;
import com.sec.widget.C1619g;
import java.io.File;

/* compiled from: UserProfileImageView.java */
/* renamed from: com.sec.chaton.userprofile.u */
/* loaded from: classes.dex */
class AsyncTaskC1271u extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ File f4371a;

    /* renamed from: b */
    final /* synthetic */ UserProfileImageView.UserProfileImageViewFragment f4372b;

    AsyncTaskC1271u(UserProfileImageView.UserProfileImageViewFragment userProfileImageViewFragment, File file) {
        this.f4372b = userProfileImageViewFragment;
        this.f4371a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        Bitmap bitmapM4502a;
        if (this.f4371a.length() <= 0 || (bitmapM4502a = C1294aq.m4502a(this.f4372b.getActivity(), this.f4371a.getAbsolutePath())) == null) {
            return null;
        }
        return bitmapM4502a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f4372b.f4261d.setImageBitmap(bitmap);
            return;
        }
        synchronized (UserProfileImageView.class) {
            if (this.f4372b.getActivity() != null) {
                C1619g.m5888a(this.f4372b.getActivity(), R.string.toast_error, 0).show();
                this.f4372b.f4261d.setImageResource(R.drawable.co_default_image_add);
            }
        }
    }
}
