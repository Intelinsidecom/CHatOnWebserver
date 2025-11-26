package com.sec.chaton.multimedia.vcard;

import android.app.Dialog;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.multimedia.vcard.ContactStruct;
import com.sec.chaton.util.account.AccountData;
import com.sec.chaton.util.account.AccountMgr;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AddVCardDialog extends Dialog {

    /* renamed from: a */
    public static Context f2274a;

    /* renamed from: b */
    ListView f2275b;

    /* renamed from: c */
    private Dialog f2276c;

    /* renamed from: d */
    private ArrayList f2277d;

    /* renamed from: e */
    private C0317a f2278e;

    /* renamed from: f */
    private AccountData f2279f;

    public AddVCardDialog(Context context) {
        super(context);
        f2274a = context;
        this.f2276c = this;
    }

    /* renamed from: a */
    public static void m2610a() throws RemoteException, OperationApplicationException {
        ContactStruct contactStructM2618a = ReadVCardActivity.m2618a();
        if (contactStructM2618a == null) {
            Toast.makeText(f2274a, C0062R.string.toast_contact_not_saved, 0).show();
            return;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
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
            for (int i = 0; contactStructM2618a.f2288h.size() > i; i++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", ((ContactStruct.PhoneData) contactStructM2618a.f2288h.get(i)).f2309b).withValue("data2", Integer.valueOf(((ContactStruct.PhoneData) contactStructM2618a.f2288h.get(i)).f2308a)).withValue("data3", ((ContactStruct.PhoneData) contactStructM2618a.f2288h.get(i)).f2310c).build());
            }
        }
        if (contactStructM2618a.f2289i != null) {
            for (int i2 = 0; contactStructM2618a.f2289i.size() > i2; i2++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", ((ContactStruct.EmailData) contactStructM2618a.f2289i.get(i2)).f2300b).withValue("data2", Integer.valueOf(((ContactStruct.EmailData) contactStructM2618a.f2289i.get(i2)).f2299a)).withValue("data3", ((ContactStruct.EmailData) contactStructM2618a.f2289i.get(i2)).f2301c).build());
            }
        }
        if (contactStructM2618a.f2290j != null) {
            for (int i3 = 0; contactStructM2618a.f2290j.size() > i3; i3++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data4", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i3)).f2314c).withValue("data5", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i3)).f2312a).withValue("data6", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i3)).f2313b).withValue("data7", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i3)).f2315d).withValue("data8", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i3)).f2316e).withValue("data9", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i3)).f2317f).withValue("data10", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i3)).f2318g).withValue("data2", Integer.valueOf(((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i3)).f2319h)).withValue("data3", ((ContactStruct.PostalData) contactStructM2618a.f2290j.get(i3)).f2320i).build());
            }
        }
        if (contactStructM2618a.f2291k != null) {
            for (int i4 = 0; contactStructM2618a.f2291k.size() > i4; i4++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", ((ContactStruct.ImData) contactStructM2618a.f2291k.get(i4)).f2306d).withValue("data2", 3).withValue("data3", ((ContactStruct.ImData) contactStructM2618a.f2291k.get(i4)).f2304b).withValue("data5", Integer.valueOf(((ContactStruct.ImData) contactStructM2618a.f2291k.get(i4)).f2303a)).withValue("data6", ((ContactStruct.ImData) contactStructM2618a.f2291k.get(i4)).f2304b).build());
            }
        }
        try {
            f2274a.getContentResolver().applyBatch("com.android.contacts", arrayList);
            Toast.makeText(f2274a, f2274a.getString(C0062R.string.toast_contact_create_success), 0).show();
        } catch (Exception e) {
            Toast.makeText(f2274a, f2274a.getString(C0062R.string.toast_contact_create_failed), 0).show();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws RemoteException, OperationApplicationException {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0062R.layout.layout_contact_account);
        this.f2275b = (ListView) findViewById(C0062R.id.addContactList);
        this.f2277d = AccountMgr.m3689a(f2274a).m3690a(f2274a, true);
        if (this.f2277d.size() <= 0) {
            m2610a();
        }
        this.f2278e = new C0317a(this, f2274a, this.f2277d);
        this.f2275b.setAdapter((ListAdapter) this.f2278e);
        this.f2275b.setOnItemClickListener(new C0322f(this));
    }
}
