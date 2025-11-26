package com.sec.chaton.userprofile;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.widget.C1619g;
import java.io.File;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ax */
/* loaded from: classes.dex */
class AsyncTaskC1227ax extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ File f4306a;

    /* renamed from: b */
    final /* synthetic */ MyPageFragment f4307b;

    AsyncTaskC1227ax(MyPageFragment myPageFragment, File file) {
        this.f4307b = myPageFragment;
        this.f4306a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            if (this.f4306a.length() > 0) {
                Bitmap bitmapM4511b = C1294aq.m4511b(this.f4307b.getActivity(), Uri.fromFile(this.f4306a));
                if (bitmapM4511b != null) {
                    return bitmapM4511b;
                }
            }
        } catch (Exception e) {
            C1341p.m4653a(e, MyPageFragment.f4102a);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f4307b.f4158t.setImageBitmap(C1348w.m4682a(bitmap));
        } else {
            C1619g.m5888a(this.f4307b.getActivity(), R.string.toast_error, 0).show();
            this.f4307b.f4158t.setImageBitmap(C1348w.m4680a(this.f4307b.f4116N, R.drawable.propile_default_image));
        }
    }
}
