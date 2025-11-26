package com.sec.chaton.buddy;

import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.dg */
/* loaded from: classes.dex */
class AsyncTaskC0349dg extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1493a;

    AsyncTaskC0349dg(BuddyProfileFragment buddyProfileFragment) {
        this.f1493a = buddyProfileFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Uri doInBackground(String... strArr) {
        return this.f1493a.m2135b(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Uri uri) {
        if (this.f1493a.getActivity() != null && !this.f1493a.getActivity().isFinishing()) {
            if (this.f1493a.f1136at) {
                Toast.makeText(this.f1493a.f1157s, R.string.regist_already_regist, 0).show();
                return;
            }
            if ((uri != null ? Integer.parseInt(uri.getLastPathSegment()) : 0) > 0) {
                Toast.makeText(this.f1493a.f1157s, R.string.buddy_profile_dialog_calendar_message, 0).show();
            } else {
                Toast.makeText(this.f1493a.f1157s, this.f1493a.f1157s.getString(R.string.buddy_profile_calendar_toast_failed), 1).show();
            }
        }
    }
}
