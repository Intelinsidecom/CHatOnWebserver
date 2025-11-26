package com.sec.chaton.userprofile;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnGraphics;
import java.io.File;
import java.io.IOException;

/* renamed from: com.sec.chaton.userprofile.y */
/* loaded from: classes.dex */
class AsyncTaskC0601y extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ File f3602a;

    /* renamed from: b */
    final /* synthetic */ UserProfileFragment f3603b;

    AsyncTaskC0601y(UserProfileFragment userProfileFragment, File file) {
        this.f3603b = userProfileFragment;
        this.f3602a = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            if (this.f3602a.length() > 0) {
                return Bitmap.createScaledBitmap(ChatOnGraphics.m3541b(this.f3603b.getActivity(), Uri.parse(this.f3603b.f3486l + "/myprofile.png_"), 138), 138, 138, true);
            }
        } catch (IOException e) {
            ChatONLogWriter.m3501a(e, UserProfileFragment.f3433a);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f3603b.f3496v.setImageBitmap(bitmap);
        } else {
            this.f3603b.f3496v.setImageResource(C0062R.drawable.co_default_image_add);
        }
    }
}
