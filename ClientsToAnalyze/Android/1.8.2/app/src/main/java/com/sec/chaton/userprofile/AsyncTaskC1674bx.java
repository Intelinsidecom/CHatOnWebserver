package com.sec.chaton.userprofile;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1791w;
import java.io.File;
import java.io.IOException;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.bx */
/* loaded from: classes.dex */
class AsyncTaskC1674bx extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ File f6170a;

    /* renamed from: b */
    final /* synthetic */ UserProfileDetail f6171b;

    AsyncTaskC1674bx(UserProfileDetail userProfileDetail, File file) {
        this.f6171b = userProfileDetail;
        this.f6170a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        Bitmap bitmapM6100b;
        try {
            if (this.f6170a.length() <= 0 || (bitmapM6100b = C1791w.m6100b(this.f6171b.f6028K, Uri.parse(this.f6171b.f6074u + "/myprofile.png_"), 208)) == null) {
                return null;
            }
            return Bitmap.createScaledBitmap(bitmapM6100b, 208, 208, true);
        } catch (IOException e) {
            C1786r.m6056a(e, this.f6171b.f6070q);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f6171b.f6018A.setImageBitmap(C1746bb.m5942a(bitmap));
        } else {
            this.f6171b.f6018A.setImageBitmap(C1746bb.m5940a(this.f6171b.f6028K, R.drawable.mypage_noimage));
        }
    }
}
