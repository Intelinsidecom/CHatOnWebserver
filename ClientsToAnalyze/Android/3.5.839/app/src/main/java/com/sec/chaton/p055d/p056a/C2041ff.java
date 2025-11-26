package com.sec.chaton.p055d.p056a;

import android.database.Cursor;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.account.C1004k;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.p081n.C2918d;
import com.sec.chaton.p081n.InterfaceC2917c;
import com.sec.chaton.util.C4904y;

/* compiled from: UploadAddressTask.java */
/* renamed from: com.sec.chaton.d.a.ff */
/* loaded from: classes.dex */
class C2041ff implements InterfaceC2917c {

    /* renamed from: a */
    final /* synthetic */ C2040fe f7468a;

    C2041ff(C2040fe c2040fe) {
        this.f7468a = c2040fe;
    }

    @Override // com.sec.chaton.p081n.InterfaceC2917c
    /* renamed from: a */
    public void mo9178a(Cursor cursor, Cursor cursor2) {
        String strM9808a;
        if (C4904y.f17872b) {
            C4904y.m18639b("onNumberInserted", "UploadAddressTask");
        }
        String strM9174c = C2040fe.m9174c(cursor.getString(1));
        C2918d c2918d = new C2918d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), strM9174c, cursor.getInt(4));
        this.f7468a.f7453e.add(c2918d);
        this.f7468a.f7451c.add(C2192f.m9874a(c2918d));
        if (strM9174c.length() >= 8 && (strM9808a = C2190d.m9808a(strM9174c)) != null && !TextUtils.isEmpty(strM9808a)) {
            this.f7468a.f7452d.add(C1004k.m6078a(strM9808a));
            this.f7468a.f7451c.add(C2190d.m9804a(strM9174c, cursor.getString(3), cursor.getInt(2)));
        }
    }

    @Override // com.sec.chaton.p081n.InterfaceC2917c
    /* renamed from: b */
    public void mo9179b(Cursor cursor, Cursor cursor2) {
        String strM9808a;
        if (C4904y.f17872b) {
            C4904y.m18639b("onNumberDeleted", "UploadAddressTask");
        }
        String strM9174c = C2040fe.m9174c(cursor2.getString(1));
        this.f7468a.f7454g.add(new C2918d(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3), strM9174c, cursor2.getInt(4)));
        this.f7468a.f7451c.add(C2192f.m9871a(cursor2.getInt(0)));
        this.f7468a.f7451c.add(C2192f.m9875a(strM9174c));
        if (strM9174c.length() >= 8 && (strM9808a = C2190d.m9808a(strM9174c)) != null && !TextUtils.isEmpty(strM9808a)) {
            this.f7468a.f7452d.add(C1004k.m6078a(strM9808a));
        }
    }

    @Override // com.sec.chaton.p081n.InterfaceC2917c
    /* renamed from: c */
    public void mo9180c(Cursor cursor, Cursor cursor2) {
        String strM9808a;
        if (C4904y.f17872b) {
            C4904y.m18639b("onNumberChanged", "UploadAddressTask");
        }
        String strM9174c = C2040fe.m9174c(cursor2.getString(1));
        String strM9174c2 = C2040fe.m9174c(cursor.getString(1));
        C2918d c2918d = new C2918d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), strM9174c2, cursor.getInt(4));
        C2918d c2918d2 = new C2918d(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3), strM9174c, cursor2.getInt(4));
        this.f7468a.f7453e.add(c2918d);
        this.f7468a.f7454g.add(c2918d2);
        if (C2349a.m10301a("sms_feature")) {
            if (strM9174c2.length() >= 8 || strM9174c.length() < 8) {
                this.f7468a.f7451c.add(C2192f.m9872a(cursor.getInt(0), "conatct_number", cursor.getString(1), strM9174c2));
            } else {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Contact number changed less 8 digits. Delete contact id = " + cursor2.getInt(4), "UploadAddressTask");
                }
                this.f7468a.f7451c.add(C2190d.m9800a(cursor2.getInt(4)));
            }
        }
        if (strM9174c.length() >= 8 && (strM9808a = C2190d.m9808a(strM9174c)) != null && !TextUtils.isEmpty(strM9808a)) {
            this.f7468a.f7452d.add(C1004k.m6078a(strM9808a));
        }
    }

    @Override // com.sec.chaton.p081n.InterfaceC2917c
    /* renamed from: d */
    public void mo9181d(Cursor cursor, Cursor cursor2) {
        String strM9808a;
        if (C4904y.f17872b) {
            C4904y.m18639b("onNameChanged", "UploadAddressTask");
        }
        String strM9174c = C2040fe.m9174c(cursor.getString(1));
        C2918d c2918d = new C2918d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), strM9174c, cursor.getInt(4));
        if (strM9174c.length() >= 8) {
            this.f7468a.f7451c.add(C2190d.m9804a(strM9174c, cursor.getString(3), cursor.getInt(2)));
        }
        this.f7468a.f7451c.add(C2192f.m9872a(cursor2.getInt(0), "contacts_name", cursor.getString(3), strM9174c));
        this.f7468a.f7453e.add(c2918d);
        if (C4904y.f17872b) {
            C4904y.m18639b("onNameChanged: buddy db has user of Contact rawid = " + cursor.getString(2) + ", buddyName = " + cursor.getString(3), "UploadAddressTask");
        }
        if (strM9174c.length() >= 8 && (strM9808a = C2190d.m9808a(strM9174c)) != null && !TextUtils.isEmpty(strM9808a)) {
            this.f7468a.f7452d.add(C1004k.m6078a(strM9808a));
        }
    }

    @Override // com.sec.chaton.p081n.InterfaceC2917c
    /* renamed from: e */
    public void mo9182e(Cursor cursor, Cursor cursor2) {
        String strM9808a;
        if (C4904y.f17872b) {
            C4904y.m18639b("onContactIdChanged", "UploadAddressTask");
        }
        String string = cursor.getString(cursor.getColumnIndex("data1"));
        String string2 = cursor2.getString(cursor2.getColumnIndex("conatct_number"));
        String string3 = cursor.getString(cursor.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
        String string4 = cursor2.getString(cursor2.getColumnIndex("contacts_name"));
        String strM9174c = C2040fe.m9174c(cursor.getString(cursor.getColumnIndex("data1")));
        String strM9174c2 = C2040fe.m9174c(cursor2.getString(cursor2.getColumnIndex("conatct_number")));
        C2918d c2918d = new C2918d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), strM9174c, cursor.getInt(4));
        C2918d c2918d2 = new C2918d(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3), strM9174c2, cursor2.getInt(4));
        if (!string.equals(string2)) {
            this.f7468a.f7453e.add(c2918d);
        }
        if (!string3.equals(string4) && strM9174c.length() >= 8) {
            this.f7468a.f7451c.add(C2190d.m9804a(strM9174c, cursor.getString(3), cursor.getInt(2)));
            this.f7468a.f7453e.add(c2918d);
        }
        this.f7468a.f7454g.add(c2918d2);
        this.f7468a.f7451c.add(C2192f.m9873a(cursor));
        if (strM9174c.length() >= 8 && (strM9808a = C2190d.m9808a(strM9174c)) != null && !TextUtils.isEmpty(strM9808a)) {
            this.f7468a.f7452d.add(C1004k.m6078a(strM9808a));
        }
    }
}
