package com.sec.chaton.buddy;

import android.os.AsyncTask;
import com.sec.chaton.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ej */
/* loaded from: classes.dex */
class AsyncTaskC0672ej extends AsyncTask<String, Void, Boolean> {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f2894a;

    AsyncTaskC0672ej(BuddyInfoFragment buddyInfoFragment) {
        this.f2894a = buddyInfoFragment;
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
            calendar2.add(1, this.f2894a.f1971S);
            if (this.f2894a.m3517a(this.f2894a.f1978h, calendar.getTimeZone().getRawOffset() + calendar.getTimeInMillis(), calendar2.getTimeInMillis()).equals("Success")) {
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
        if (bool.booleanValue()) {
            this.f2894a.f1995y.setEnabled(false);
            this.f2894a.f1995y.setImageDrawable(this.f2894a.getResources().getDrawable(R.drawable.list_ic_add_disable));
        } else {
            this.f2894a.f1995y.setEnabled(true);
            this.f2894a.f1995y.setImageDrawable(this.f2894a.getResources().getDrawable(R.drawable.list_ic_add));
        }
    }
}
