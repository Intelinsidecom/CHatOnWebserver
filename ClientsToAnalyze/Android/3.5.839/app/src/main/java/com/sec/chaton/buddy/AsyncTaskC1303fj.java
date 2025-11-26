package com.sec.chaton.buddy;

import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.fj */
/* loaded from: classes.dex */
class AsyncTaskC1303fj extends AsyncTask<String, Void, Uri> {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4839a;

    AsyncTaskC1303fj(BuddyInfoFragment buddyInfoFragment) {
        this.f4839a = buddyInfoFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Uri doInBackground(String... strArr) {
        return this.f4839a.m6691d(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Uri uri) {
        if (uri == null) {
            C5179v.m19811a(this.f4839a.f3845O, this.f4839a.getResources().getString(R.string.buddy_profile_calendar_toast_failed), 1).show();
            return;
        }
        if (Integer.parseInt(uri.getLastPathSegment()) > 0) {
            this.f4839a.f3834D.setEnabled(false);
            this.f4839a.f3837G.setVisibility(8);
            this.f4839a.f3874t.setText(R.string.buddy_profile_dialog_calendar_message);
            this.f4839a.f3874t.setDuration(0);
            this.f4839a.f3874t.show();
            return;
        }
        C5179v.m19811a(this.f4839a.f3845O, this.f4839a.getResources().getString(R.string.buddy_profile_calendar_toast_failed), 1).show();
    }
}
