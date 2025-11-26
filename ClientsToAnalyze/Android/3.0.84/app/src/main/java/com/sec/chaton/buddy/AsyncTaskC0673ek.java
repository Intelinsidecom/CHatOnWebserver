package com.sec.chaton.buddy;

import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ek */
/* loaded from: classes.dex */
class AsyncTaskC0673ek extends AsyncTask<String, Void, Uri> {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f2895a;

    AsyncTaskC0673ek(BuddyInfoFragment buddyInfoFragment) {
        this.f2895a = buddyInfoFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Uri doInBackground(String... strArr) {
        return this.f2895a.m3537d(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Uri uri) {
        if (uri == null) {
            C3641ai.m13211a(this.f2895a.f1963K, this.f2895a.getResources().getString(R.string.buddy_profile_calendar_toast_failed), 1).show();
            return;
        }
        if (Integer.parseInt(uri.getLastPathSegment()) > 0) {
            this.f2895a.f1995y.setEnabled(false);
            this.f2895a.f1995y.setImageDrawable(this.f2895a.getResources().getDrawable(R.drawable.list_ic_add_disable));
            this.f2895a.f1983m.setText(R.string.buddy_profile_dialog_calendar_message);
            this.f2895a.f1983m.setDuration(0);
            this.f2895a.f1983m.show();
            return;
        }
        C3641ai.m13211a(this.f2895a.f1963K, this.f2895a.getResources().getString(R.string.buddy_profile_calendar_toast_failed), 1).show();
    }
}
