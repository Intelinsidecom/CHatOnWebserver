package com.sec.chaton.buddy;

import android.os.AsyncTask;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.fi */
/* loaded from: classes.dex */
class AsyncTaskC1302fi extends AsyncTask<String, Void, Boolean> {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4838a;

    AsyncTaskC1302fi(BuddyInfoFragment buddyInfoFragment) {
        this.f4838a = buddyInfoFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) {
        String str = strArr[0];
        try {
            Calendar calendar = Calendar.getInstance();
            String str2 = String.valueOf(calendar.get(1)) + "-" + str;
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str2));
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str2));
            calendar2.add(1, this.f4838a.f3855Y);
            if (this.f4838a.m6673a(this.f4838a.f3868n, calendar.getTimeZone().getRawOffset() + calendar.getTimeInMillis(), calendar2.getTimeInMillis()).equals("Success")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (this.f4838a.f3845O != null && this.f4838a.isAdded()) {
            if (bool.booleanValue()) {
                this.f4838a.f3834D.setEnabled(false);
                this.f4838a.f3837G.setVisibility(8);
            } else {
                this.f4838a.f3834D.setEnabled(true);
                this.f4838a.f3837G.setVisibility(0);
            }
        }
    }
}
