package com.sec.chaton.control.task;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.account.ContactManager;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.database.helper.BuddyDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.p000io.entry.GetBuddyList;
import com.sec.chaton.p000io.entry.inner.Address;
import com.sec.chaton.p000io.entry.inner.Buddy;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnXmlParser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class AddBuddyTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private String f1461a;

    /* renamed from: b */
    private ContentResolver f1462b;

    public AddBuddyTask(Handler handler, HttpEnvelope httpEnvelope, String str) {
        super(handler, httpEnvelope);
        this.f1461a = str;
        this.f1462b = GlobalApplication.m2387e().getContentResolver();
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) throws RemoteException, OperationApplicationException {
        if (httpEntry.m1955d() != null) {
            Iterator it = ((GetBuddyList) httpEntry.m1955d()).buddy.iterator();
            while (it.hasNext()) {
                Buddy buddy = (Buddy) it.next();
                ChatONLogWriter.m3506b("Buddy NO : " + buddy.value + ", Name : " + buddy.name + ", StatusMessage : " + buddy.status + ", orgnum : " + buddy.orgnum + ", showphonenumber : " + buddy.showphonenumber, getClass().getSimpleName());
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                arrayList.add(BuddyDatabaseHelper.m2217a(buddy));
                this.f1462b.applyBatch("com.sec.chaton.provider", arrayList);
            }
            ContactManager.m404a(GlobalApplication.m2387e(), ((GetBuddyList) httpEntry.m1955d()).buddy);
            ContactManager.m403a();
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ArrayList arrayList = new ArrayList();
        Address address = new Address();
        address.value = this.f1461a;
        arrayList.add(address);
        String strM3552a = new ChatOnXmlParser().m3552a(arrayList);
        ChatONLogWriter.m3511e("\n" + strM3552a, getClass().getSimpleName());
        return strM3552a;
    }
}
