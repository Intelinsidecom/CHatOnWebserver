package com.sec.chaton.chat;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3348j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dj */
/* loaded from: classes.dex */
class AsyncTaskC1041dj extends AsyncTask<Bitmap, Void, File> {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4151a;

    /* renamed from: b */
    private boolean f4152b;

    public AsyncTaskC1041dj(ChatFragment chatFragment, boolean z) {
        this.f4151a = chatFragment;
        this.f4152b = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File doInBackground(Bitmap... bitmapArr) {
        try {
            return C3348j.m11792a(bitmapArr[0], GlobalApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f4151a.f3703r, String.valueOf(System.currentTimeMillis()) + ".jpg");
        } catch (FileNotFoundException e) {
            if (!C3250y.f11737e) {
                return null;
            }
            C3250y.m11443a(e, ChatFragment.f3484a);
            return null;
        } catch (IOException e2) {
            if (!C3250y.f11737e) {
                return null;
            }
            C3250y.m11443a(e2, ChatFragment.f3484a);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f4151a.f3694dn != null && !this.f4151a.f3694dn.isRecycled()) {
            this.f4151a.f3694dn.recycle();
        }
        this.f4151a.f3694dn = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(File file) {
        super.onPostExecute(file);
        if (this.f4151a.m4827ai()) {
            this.f4151a.m5022w();
            if (file != null) {
                if (this.f4152b) {
                    this.f4151a.m4766a(file, (String) null, (String) null, EnumC1455w.IMAGE, (String) null);
                } else {
                    this.f4151a.m4765a(file, EnumC1455w.IMAGE, (String) null, (String) null, false);
                }
            }
            this.f4151a.f3694dn = null;
        }
    }
}
