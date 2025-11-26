package com.sec.chaton.userprofile;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnGraphics;
import java.io.File;
import java.io.IOException;

/* renamed from: com.sec.chaton.userprofile.as */
/* loaded from: classes.dex */
class AsyncTaskC0565as extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ File f3544a;

    /* renamed from: b */
    final /* synthetic */ UserProfileImageView f3545b;

    AsyncTaskC0565as(UserProfileImageView userProfileImageView, File file) {
        this.f3545b = userProfileImageView;
        this.f3544a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            if (this.f3544a.length() > 0) {
                return Bitmap.createScaledBitmap(ChatOnGraphics.m3541b(this.f3545b.f3504d, Uri.parse(this.f3545b.f3518r + "/myprofile.png_"), 800), 800, 800, true);
            }
        } catch (IOException e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f3545b.f3508h.setImageBitmap(bitmap);
        } else {
            this.f3545b.f3508h.setImageResource(C0062R.drawable.co_default_image_add);
        }
    }
}
