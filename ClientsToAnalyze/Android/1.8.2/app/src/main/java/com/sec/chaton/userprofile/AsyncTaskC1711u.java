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

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.u */
/* loaded from: classes.dex */
class AsyncTaskC1711u extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ File f6224a;

    /* renamed from: b */
    final /* synthetic */ MyPageFragment f6225b;

    AsyncTaskC1711u(MyPageFragment myPageFragment, File file) {
        this.f6225b = myPageFragment;
        this.f6224a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            if (this.f6224a.length() > 0) {
                return Bitmap.createScaledBitmap(C1791w.m6100b(this.f6225b.getActivity(), Uri.parse(this.f6225b.f5844k + "/myprofile.png_"), 208), 208, 208, true);
            }
        } catch (IOException e) {
            C1786r.m6056a(e, MyPageFragment.f5812a);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f6225b.f5847n.setImageBitmap(C1746bb.m5942a(bitmap));
        } else {
            this.f6225b.f5847n.setImageBitmap(C1746bb.m5940a(this.f6225b.f5820H, R.drawable.co_default_image_add));
        }
    }
}
