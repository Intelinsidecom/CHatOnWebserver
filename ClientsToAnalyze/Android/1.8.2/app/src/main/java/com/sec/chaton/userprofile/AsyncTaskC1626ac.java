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

/* compiled from: MyPageFragmentTablet.java */
/* renamed from: com.sec.chaton.userprofile.ac */
/* loaded from: classes.dex */
class AsyncTaskC1626ac extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ File f6112a;

    /* renamed from: b */
    final /* synthetic */ MyPageFragmentTablet f6113b;

    AsyncTaskC1626ac(MyPageFragmentTablet myPageFragmentTablet, File file) {
        this.f6113b = myPageFragmentTablet;
        this.f6112a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            if (this.f6112a.length() > 0) {
                return Bitmap.createScaledBitmap(C1791w.m6100b(this.f6113b.getActivity(), Uri.parse(this.f6113b.f5890m + "/myprofile.png_"), 550), 240, 240, true);
            }
        } catch (IOException e) {
            C1786r.m6056a(e, MyPageFragmentTablet.f5861b);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f6113b.f5893p.setImageBitmap(C1746bb.m5942a(bitmap));
        } else {
            this.f6113b.f5893p.setImageBitmap(C1746bb.m5940a(this.f6113b.f5893p.getContext(), R.drawable.mypage_noimage));
        }
    }
}
