package com.sec.chaton.userprofile;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnGraphics;
import java.io.File;
import java.io.IOException;

/* renamed from: com.sec.chaton.userprofile.ac */
/* loaded from: classes.dex */
class AsyncTaskC0549ac extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ File f3527a;

    /* renamed from: b */
    final /* synthetic */ UserProfileDetail f3528b;

    AsyncTaskC0549ac(UserProfileDetail userProfileDetail, File file) {
        this.f3528b = userProfileDetail;
        this.f3527a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            if (this.f3527a.length() > 0) {
                return Bitmap.createScaledBitmap(ChatOnGraphics.m3541b(this.f3528b.f3412f, Uri.parse(this.f3528b.f3421o + "/myprofile.png_"), 138), 138, 138, true);
            }
        } catch (IOException e) {
            ChatONLogWriter.m3501a(e, "UserProfileDetail");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f3528b.f3430x.setImageBitmap(bitmap);
        } else {
            this.f3528b.f3430x.setImageResource(C0062R.drawable.co_default_image_add);
        }
    }
}
