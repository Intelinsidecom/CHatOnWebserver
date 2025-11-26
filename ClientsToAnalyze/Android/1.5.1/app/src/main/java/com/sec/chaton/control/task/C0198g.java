package com.sec.chaton.control.task;

import android.database.Cursor;
import com.sec.chaton.account.ContactOperation;
import com.sec.chaton.database.helper.BuddyDatabaseHelper;
import com.sec.chaton.database.helper.ContactDatabaseHelper;
import com.sec.chaton.sync.ContactComparator;
import com.sec.chaton.sync.ContactEntry;

/* renamed from: com.sec.chaton.control.task.g */
/* loaded from: classes.dex */
class C0198g implements ContactComparator.ContactChangeAction {

    /* renamed from: a */
    final /* synthetic */ UploadAddressTask f1691a;

    C0198g(UploadAddressTask uploadAddressTask) {
        this.f1691a = uploadAddressTask;
    }

    @Override // com.sec.chaton.sync.ContactComparator.ContactChangeAction
    /* renamed from: a */
    public void mo2160a(Cursor cursor, Cursor cursor2) {
        this.f1691a.f1674a.add(new ContactEntry(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
        this.f1691a.f1677d.add(ContactDatabaseHelper.m2234a(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
    }

    @Override // com.sec.chaton.sync.ContactComparator.ContactChangeAction
    /* renamed from: b */
    public void mo2161b(Cursor cursor, Cursor cursor2) {
        this.f1691a.f1675b.add(new ContactEntry(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3)));
        this.f1691a.f1677d.add(ContactDatabaseHelper.m2233a(cursor2.getInt(0)));
        this.f1691a.f1678e.add(ContactOperation.m410a(cursor2.getColumnName(1)));
    }

    @Override // com.sec.chaton.sync.ContactComparator.ContactChangeAction
    /* renamed from: c */
    public void mo2162c(Cursor cursor, Cursor cursor2) {
        this.f1691a.f1674a.add(new ContactEntry(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
        this.f1691a.f1675b.add(new ContactEntry(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3)));
        this.f1691a.f1677d.add(ContactDatabaseHelper.m2235a(cursor2.getInt(0), "conatct_number", cursor.getString(1)));
        this.f1691a.f1678e.add(ContactOperation.m410a(cursor.getString(1)));
    }

    @Override // com.sec.chaton.sync.ContactComparator.ContactChangeAction
    /* renamed from: d */
    public void mo2163d(Cursor cursor, Cursor cursor2) {
        this.f1691a.f1677d.add(BuddyDatabaseHelper.m2218a(cursor.getString(2), cursor.getString(3)));
        this.f1691a.f1677d.add(ContactDatabaseHelper.m2235a(cursor2.getInt(0), "contacts_name", cursor.getString(3)));
    }
}
