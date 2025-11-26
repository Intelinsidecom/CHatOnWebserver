package com.sec.chaton.buddy;

import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.widget.C1619g;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.at */
/* loaded from: classes.dex */
class AsyncTaskC0385at extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1354a;

    AsyncTaskC0385at(BuddyProfileActivity buddyProfileActivity) {
        this.f1354a = buddyProfileActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Uri doInBackground(String... strArr) {
        return this.f1354a.m2247a(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Uri uri) {
        if (uri == null) {
            C1619g.m5889a(this.f1354a.f1240k, this.f1354a.getResources().getString(R.string.buddy_profile_calendar_toast_failed), 1).show();
        } else {
            if (Integer.parseInt(uri.getLastPathSegment()) > 0) {
                this.f1354a.f1239j.setText(R.string.buddy_profile_dialog_calendar_message);
                this.f1354a.f1239j.setDuration(0);
                this.f1354a.f1239j.show();
                return;
            }
            C1619g.m5889a(this.f1354a.f1240k, this.f1354a.getResources().getString(R.string.buddy_profile_calendar_toast_failed), 1).show();
        }
    }
}
