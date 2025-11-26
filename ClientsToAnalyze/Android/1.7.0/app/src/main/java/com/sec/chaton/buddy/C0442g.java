package com.sec.chaton.buddy;

import android.database.Cursor;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0643f;
import com.sec.chaton.p025d.p027b.C0649l;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.g */
/* loaded from: classes.dex */
class C0442g implements InterfaceC0641d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1434a;

    C0442g(BuddyFragment buddyFragment) {
        this.f1434a = buddyFragment;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0641d
    /* renamed from: a */
    public void mo2364a(int i, boolean z, Object obj) throws NumberFormatException {
        if (!z) {
            this.f1434a.m2088E();
            return;
        }
        if (i == 1) {
            if (obj instanceof Cursor) {
                Cursor cursor = (Cursor) obj;
                if (cursor.getCount() > 0) {
                    cursor.close();
                    C0627g.m2858a(new C0627g(), 2, new C0643f(this.f1434a.f1148f, this.f1434a.f1112V, 2, true));
                    return;
                } else {
                    C0627g.m2858a(new C0627g(), 2, new C0643f(this.f1434a.f1148f, this.f1434a.f1112V, 2, false));
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            if (this.f1434a.getActivity() != null) {
                this.f1434a.m2088E();
                C1619g.m5889a(this.f1434a.f1153k, this.f1434a.getResources().getString(R.string.buddy_profile_block_toast_success, this.f1434a.f1112V.m2314b()), 0).show();
                this.f1434a.f1114X.m2351a();
                return;
            }
            return;
        }
        if (i == 3) {
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0) {
                if (this.f1434a.f1103M == 10) {
                    this.f1434a.m2141c(((EditText) this.f1434a.getActivity().findViewById(R.id.buddy_select_group_name_edit)).getText().toString().trim());
                    return;
                }
                if (this.f1434a.f1103M == 11) {
                    String[] strArrM5849c = this.f1434a.f1156n.m5849c();
                    C1341p.m4663f("************ MSC00049431 : " + ((EditText) this.f1434a.getActivity().findViewById(R.id.buddy_select_group_name_edit)), BuddyFragment.f1090a);
                    String strTrim = ((EditText) this.f1434a.getActivity().findViewById(R.id.buddy_select_group_name_edit)).getText().toString().trim();
                    int i2 = Integer.parseInt(this.f1434a.getArguments().getString("ACTIVITY_PURPOSE_ARG"));
                    C0649l c0649l = new C0649l(this.f1434a.f1150h, strTrim, strArrM5849c, 10);
                    c0649l.m2974b(i2);
                    C0627g.m2858a(new C0627g(), 10, c0649l);
                    return;
                }
                return;
            }
            C1619g.m5889a(this.f1434a.getActivity(), this.f1434a.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0).show();
        }
    }
}
