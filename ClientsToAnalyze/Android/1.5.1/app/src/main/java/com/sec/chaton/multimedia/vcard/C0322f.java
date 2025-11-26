package com.sec.chaton.multimedia.vcard;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.multimedia.vcard.ContactStruct;
import com.sec.chaton.util.account.AccountData;
import java.util.ArrayList;

/* renamed from: com.sec.chaton.multimedia.vcard.f */
/* loaded from: classes.dex */
class C0322f implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AddVCardDialog f2382a;

    C0322f(AddVCardDialog addVCardDialog) {
        this.f2382a = addVCardDialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) throws RemoteException, OperationApplicationException {
        ContactStruct contactStructM2618a = ReadVCardActivity.m2618a();
        if (contactStructM2618a == null) {
            Toast.makeText(AddVCardDialog.f2274a, C0062R.string.toast_contact_not_saved, 0).show();
            return;
        }
        this.f2382a.f2279f = (AccountData) this.f2382a.f2277d.get(i);
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", this.f2382a.f2279f.m3685b()).withValue("account_name", this.f2382a.f2279f.m3684a()).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", contactStructM2618a.f2281a).build());
        if (contactStructM2618a.f2282b != null) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data3", contactStructM2618a.f2282b).build());
        }
        if (contactStructM2618a.f2283c != null) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data1", contactStructM2618a.f2283c).build());
        }
        if (contactStructM2618a.f2284d != null) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data1", contactStructM2618a.f2284d).build());
        }
        if (contactStructM2618a.f2288h != null) {
            for (int i2 = 0; contactStructM2618a.f2288h.size() > i2; i2++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", ((ContactStruct.PhoneData) contactStructM2618a.f2288h.get(i2)).f2309b).withValue("data2", Integer.valueOf(((ContactStruct.PhoneData) contactStructM2618a.f2288h.get(i2)).f2308a)).withValue("data3", ((ContactStruct.PhoneData) contactStructM2618a.f2288h.get(i2)).f2310c).build());
            }
        }
        if (contactStructM2618a.f2289i != null) {
            for (int i3 = 0; contactStructM2618a.f2289i.size() > i3; i3++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", ((ContactStruct.EmailData) contactStructM2618a.f2289i.get(i3)).f2300b).withValue("data2", Integer.valueOf(((ContactStruct.EmailData) contactStructM2618a.f2289i.get(i3)).f2299a)).withValue("data3", ((ContactStruct.EmailData) contactStructM2618a.f2289i.get(i3)).f2301c).build());
            }
        }
        if (contactStructM2618a.f2290j != null) {
            for (int i4 = 0; contactStructM2618a.f2290j.size() > i4; i4++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data4", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i4)).f2314c).withValue("data5", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i4)).f2312a).withValue("data6", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i4)).f2313b).withValue("data7", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i4)).f2315d).withValue("data8", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i4)).f2316e).withValue("data9", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i4)).f2317f).withValue("data10", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i4)).f2318g).withValue("data2", Integer.valueOf(((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i4)).f2319h)).withValue("data3", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i4)).f2320i).build());
            }
        }
        if (contactStructM2618a.f2291k != null) {
            for (int i5 = 0; contactStructM2618a.f2291k.size() > i5; i5++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", ((ContactStruct.ImData) contactStructM2618a.f2291k.get(i5)).f2306d).withValue("data2", 3).withValue("data3", ((ContactStruct.ImData) contactStructM2618a.f2291k.get(i5)).f2304b).withValue("data5", Integer.valueOf(((ContactStruct.ImData) contactStructM2618a.f2291k.get(i5)).f2303a)).withValue("data6", ((ContactStruct.ImData) contactStructM2618a.f2291k.get(i5)).f2304b).build());
            }
        }
        try {
            AddVCardDialog.f2274a.getContentResolver().applyBatch("com.android.contacts", arrayList);
            Toast.makeText(AddVCardDialog.f2274a, AddVCardDialog.f2274a.getString(C0062R.string.toast_contact_create_success), 0).show();
        } catch (Exception e) {
            Toast.makeText(AddVCardDialog.f2274a, AddVCardDialog.f2274a.getString(C0062R.string.toast_contact_create_failed), 0).show();
        }
        this.f2382a.dismiss();
    }
}
