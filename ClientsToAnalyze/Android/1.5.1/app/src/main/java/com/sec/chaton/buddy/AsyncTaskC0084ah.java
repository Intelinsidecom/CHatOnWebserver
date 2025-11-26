package com.sec.chaton.buddy;

import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.buddy.ah */
/* loaded from: classes.dex */
class AsyncTaskC0084ah extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f619a;

    AsyncTaskC0084ah(BuddyProfileActivity buddyProfileActivity) {
        this.f619a = buddyProfileActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Uri doInBackground(String... strArr) {
        return this.f619a.m603a(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Uri uri) {
        if (Integer.parseInt(uri.getLastPathSegment()) > 0) {
            Toast.makeText(this.f619a.f584i, C0062R.string.buddy_profile_dialog_calendar_message, 0).show();
        } else {
            Toast.makeText(this.f619a.f584i, this.f619a.getResources().getString(C0062R.string.buddy_profile_calendar_toast_failed), 1).show();
        }
    }
}
