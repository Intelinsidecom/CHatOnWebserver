package com.sec.chaton.control.task;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Handler;
import android.provider.ContactsContract;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.database.DatabaseHelper;
import com.sec.chaton.facebook.FacebookManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.network.TcpClient;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseOpenHelper;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONNotificationManager;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.StorageStateInfoUtil;
import java.io.File;

/* loaded from: classes.dex */
public class DeRegistrationTask extends AbstractHttpTask2 {
    public DeRegistrationTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
            return;
        }
        Context contextM2387e = GlobalApplication.m2387e();
        ChatONNotificationManager.m3515a(contextM2387e).m3516a();
        contextM2387e.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "account_type='com.sec.chaton'", null);
        ChatONPref.m3519a().edit().clear().commit();
        contextM2387e.getSharedPreferences("BUDDY_ACTIVITY", 0).edit().clear().commit();
        TcpClient.m2762c();
        MessageControl.m2014a();
        DatabaseHelper.m2204a(contextM2387e).close();
        contextM2387e.deleteDatabase(DatabaseHelper.m2205a());
        File databasePath = contextM2387e.getDatabasePath(DatabaseHelper.m2205a());
        if (databasePath.exists()) {
            databasePath.delete();
        }
        new TrunkDatabaseOpenHelper(contextM2387e).close();
        contextM2387e.deleteDatabase(DatabaseConstant.TRUNK_DATABASE_NAME);
        File databasePath2 = contextM2387e.getDatabasePath(DatabaseConstant.TRUNK_DATABASE_NAME);
        if (databasePath2.exists()) {
            databasePath2.delete();
        }
        if (StorageStateInfoUtil.m3677a()) {
            ChatONFileUtil.m3481a();
            ChatONFileUtil.m3482a(new File(contextM2387e.getExternalFilesDir(null).toString()));
        }
        ChatONFileUtil.m3482a(contextM2387e.getFilesDir());
        AccountManager accountManager = AccountManager.get(GlobalApplication.m2387e());
        for (Account account : accountManager.getAccountsByType("com.sec.chaton")) {
            accountManager.removeAccount(account, null, null);
        }
        FacebookManager.m2342a(GlobalApplication.m2387e());
        GlobalApplication.m2390h().m3478b();
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
