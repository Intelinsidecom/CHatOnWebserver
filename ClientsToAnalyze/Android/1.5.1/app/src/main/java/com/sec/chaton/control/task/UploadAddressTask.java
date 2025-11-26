package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.BuddyDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.inner.Address;
import com.sec.chaton.sync.ContactComparator;
import com.sec.chaton.sync.ContactEntry;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnXmlParser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class UploadAddressTask extends AbstractHttpTask2 {

    /* renamed from: a */
    ArrayList f1674a;

    /* renamed from: b */
    ArrayList f1675b;

    /* renamed from: c */
    ContactComparator.ContactChangeAction f1676c;

    /* renamed from: d */
    private ArrayList f1677d;

    /* renamed from: e */
    private ArrayList f1678e;

    public UploadAddressTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
        this.f1676c = new C0198g(this);
        this.f1674a = new ArrayList();
        this.f1675b = new ArrayList();
        this.f1677d = new ArrayList();
        this.f1678e = new ArrayList();
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) throws RemoteException, OperationApplicationException {
        if (httpEntry.m1951b() != HttpResultCode.ERROR) {
            ContentResolver contentResolver = GlobalApplication.m2387e().getContentResolver();
            ChatONPref.m3521a("contact_version", Integer.valueOf(ContactComparator.m3293a()));
            Iterator it = this.f1675b.iterator();
            while (it.hasNext()) {
                ContactEntry contactEntry = (ContactEntry) it.next();
                Cursor cursorQuery = contentResolver.query(ChatONContract.BuddyTable.f1713a, null, "buddy_raw_contact_id = ?", new String[]{contactEntry.m3296b() + ""}, null);
                while (cursorQuery.moveToNext()) {
                    this.f1677d.add(BuddyDatabaseHelper.m2223b(String.valueOf(contactEntry.m3296b()), cursorQuery.getString(cursorQuery.getColumnIndex("buddy_push_name"))));
                }
                cursorQuery.close();
            }
            ChatONLogWriter.m3511e("Start making local Contact", getClass().getSimpleName());
            contentResolver.applyBatch("com.sec.chaton.provider", this.f1677d);
            contentResolver.applyBatch("com.android.contacts", this.f1678e);
            ChatONLogWriter.m3511e("End making local Contact", getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ChatONLogWriter.m3506b("Cotact Compare Start", getClass().getSimpleName());
        ContactComparator.m3294a(this.f1676c);
        ChatONLogWriter.m3506b("Cotact Compare End", getClass().getSimpleName());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f1674a.iterator();
        while (it.hasNext()) {
            ContactEntry contactEntry = (ContactEntry) it.next();
            if (contactEntry.m3295a().length() >= 8) {
                Address address = new Address();
                if (contactEntry.m3295a().length() > 64) {
                    ChatONLogWriter.m3511e("Number is too long : " + contactEntry.m3295a(), getClass().getSimpleName());
                } else {
                    if (contactEntry.m3297c().length() < 48) {
                        address.name = contactEntry.m3297c();
                    } else {
                        address.name = contactEntry.m3297c().substring(0, 24);
                    }
                    address.value = contactEntry.m3295a();
                    arrayList.add(address);
                }
            }
        }
        if (arrayList.size() == 0) {
            interrupt();
        }
        ChatONLogWriter.m3508c("Sent Contact Count : " + arrayList.size(), getClass().getSimpleName());
        String strM3552a = new ChatOnXmlParser().m3552a(arrayList);
        ChatONLogWriter.m3511e(strM3552a, getClass().getSimpleName());
        return strM3552a;
    }
}
