package com.sec.chaton.chat;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5035l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.en */
/* loaded from: classes.dex */
class AsyncTaskC1687en extends AsyncTask<Bitmap, Void, File> {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6269a;

    /* renamed from: b */
    private final boolean f6270b;

    public AsyncTaskC1687en(ChatFragment chatFragment, boolean z) {
        this.f6269a = chatFragment;
        this.f6270b = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File doInBackground(Bitmap... bitmapArr) {
        try {
            return C5035l.m19110a(bitmapArr[0], GlobalApplication.m18732r().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f6269a.f5750v, String.valueOf(System.currentTimeMillis()) + ".jpg");
        } catch (FileNotFoundException e) {
            if (!C4904y.f17875e) {
                return null;
            }
            C4904y.m18635a(e, ChatFragment.f5461a);
            return null;
        } catch (IOException e2) {
            if (!C4904y.f17875e) {
                return null;
            }
            C4904y.m18635a(e2, ChatFragment.f5461a);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f6269a.f5677dP != null && !this.f6269a.f5677dP.isRecycled()) {
            this.f6269a.f5677dP.recycle();
        }
        this.f6269a.f5677dP = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(File file) {
        super.onPostExecute(file);
        if (this.f6269a.m8053ax()) {
            this.f6269a.m8275t();
            if (file != null) {
                if (this.f6270b) {
                    this.f6269a.m7936a(file, (String) null, (String) null, EnumC2214ab.IMAGE, (String) null);
                } else {
                    this.f6269a.m7934a(file, EnumC2214ab.IMAGE, (String) null, (String) null, false);
                }
            }
            if (this.f6269a.f5677dP != null && !this.f6269a.f5677dP.isRecycled()) {
                this.f6269a.f5677dP.recycle();
            }
            this.f6269a.f5677dP = null;
        }
    }
}
