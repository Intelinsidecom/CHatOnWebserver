package com.sec.chaton.buddy;

import android.content.Intent;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.Toast;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.R;
import com.sec.chaton.buddy.honeycomb.BuddySelectFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0678e;
import com.sec.chaton.p017e.p019b.C0680g;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ao */
/* loaded from: classes.dex */
class C0273ao implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1368a;

    C0273ao(BuddyFragment buddyFragment) {
        this.f1368a = buddyFragment;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) throws NumberFormatException {
        if (!z) {
            if (this.f1368a.f989az != null && this.f1368a.f989az.isShowing()) {
                this.f1368a.f989az.dismiss();
                return;
            }
            return;
        }
        if (i == 1) {
            Cursor cursor = (Cursor) obj;
            if (cursor.getCount() > 0) {
                cursor.close();
                C0668l.m3077a(new C0668l(), 2, new C0678e(this.f1368a.f1005g, this.f1368a.f978ao, 2, true));
                return;
            } else {
                C0668l.m3077a(new C0668l(), 2, new C0678e(this.f1368a.f1005g, this.f1368a.f978ao, 2, false));
                return;
            }
        }
        if (i == 2) {
            if (this.f1368a.getActivity() != null) {
                if (this.f1368a.f989az != null && this.f1368a.f989az.isShowing()) {
                    this.f1368a.f989az.dismiss();
                }
                Toast.makeText(this.f1368a.f1018t, this.f1368a.getResources().getString(R.string.buddy_profile_block_toast_success, this.f1368a.f978ao.m2324b()), 0).show();
                this.f1368a.f981ar.m2370a();
                return;
            }
            return;
        }
        if (i == 4) {
            if (GlobalApplication.m3265f()) {
                if (this.f1368a.f969af == 1) {
                    C1786r.m6067f(this.f1368a.f978ao.m2318a(), BuddyFragment.f908a);
                    C1786r.m6067f(this.f1368a.f980aq.m2463c(), BuddyFragment.f908a);
                    if (this.f1368a.f980aq.m2463c() != null && this.f1368a.f978ao.m2318a().equals(this.f1368a.f980aq.m2463c()) && (this.f1368a.getFragmentManager().findFragmentById(R.id.fragment_container) instanceof BuddySelectFragment)) {
                        this.f1368a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyBuddyFragment(), "container").commit();
                    }
                    Toast.makeText(this.f1368a.f1018t, this.f1368a.getResources().getString(R.string.trunk_toast_deleted), 0).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("ACTIVITY_PURPOSE_ARG", this.f1368a.getArguments().getString("ACTIVITY_PURPOSE_ARG"));
                intent.putExtra("ACTIVITY_PURPOSE_ARG2", "DELETE");
                this.f1368a.getActivity().setResult(-1, intent);
                this.f1368a.getActivity().finish();
                return;
            }
            return;
        }
        if (i == 3) {
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0) {
                if (this.f1368a.f969af == 10) {
                    HashSet hashSetM1927O = this.f1368a.m1927O();
                    String strTrim = ((EditText) this.f1368a.getActivity().findViewById(R.id.buddy_select_group_name_edit)).getText().toString().trim();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = hashSetM1927O.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                    arrayList.add(0, strTrim);
                    C0668l.m3077a(new C0668l(), 2, new C0680g(this.f1368a.f1007i, (String[]) arrayList.toArray(new String[0]), 2));
                    return;
                }
                if (this.f1368a.f969af == 11) {
                    HashSet hashSetM1927O2 = this.f1368a.m1927O();
                    C1786r.m6067f("************ MSC00049431 : " + ((EditText) this.f1368a.getActivity().findViewById(R.id.buddy_select_group_name_edit)), BuddyFragment.f908a);
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = hashSetM1927O2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(it2.next());
                    }
                    arrayList2.add(0, this.f1368a.f966ac.getString("ACTION_PURPOSE_ARG1"));
                    int i2 = Integer.parseInt(this.f1368a.getArguments().getString("ACTIVITY_PURPOSE_ARG"));
                    C0680g c0680g = new C0680g(this.f1368a.f1007i, (String[]) arrayList2.toArray(new String[0]), 10);
                    c0680g.m3100b(i2);
                    C0668l.m3077a(new C0668l(), 10, c0680g);
                    return;
                }
                return;
            }
            String strTrim2 = ((EditText) this.f1368a.getActivity().findViewById(R.id.buddy_select_group_name_edit)).getText().toString().trim();
            if (GlobalApplication.m3265f()) {
                Toast.makeText(this.f1368a.getActivity(), String.format(this.f1368a.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist_tablet), strTrim2), 0).show();
                this.f1368a.getActivity().findViewById(R.id.actionbar_menu_done).setEnabled(true);
                if (this.f1368a.f989az != null && this.f1368a.f989az.isShowing()) {
                    this.f1368a.f989az.dismiss();
                    return;
                }
                return;
            }
            Toast.makeText(this.f1368a.getActivity(), this.f1368a.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0).show();
        }
    }
}
