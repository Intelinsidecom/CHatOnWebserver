package com.sec.chaton.sync;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import com.sec.chaton.account.ContactManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class AsyncCheckVersion extends AsyncTask {

    /* renamed from: a */
    private Context f3306a;

    /* renamed from: b */
    private ContentResolver f3307b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        return Integer.valueOf(ContactComparator.m3293a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        this.f3306a = GlobalApplication.m2387e();
        this.f3307b = this.f3306a.getContentResolver();
        if (ChatONPref.m3519a().contains("uid") && ChatONPref.m3519a().contains("contact_version") && ChatONPref.m3519a().getInt("contact_version", 0) != num.intValue()) {
            ChatONLogWriter.m3508c("Need to perform Contact Sync Opeartion", getClass().getSimpleName());
            ContactManager.m403a();
        }
    }
}
