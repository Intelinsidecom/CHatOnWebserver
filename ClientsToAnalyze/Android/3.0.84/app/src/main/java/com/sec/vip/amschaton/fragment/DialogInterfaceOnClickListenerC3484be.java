package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.vip.amschaton.C3584q;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3484be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12851a;

    /* renamed from: b */
    final /* synthetic */ String f12852b;

    /* renamed from: c */
    final /* synthetic */ AMSListFragment f12853c;

    DialogInterfaceOnClickListenerC3484be(AMSListFragment aMSListFragment, int i, String str) {
        this.f12853c = aMSListFragment;
        this.f12851a = i;
        this.f12852b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean zM12808b;
        if (this.f12851a == 2002) {
            zM12808b = C3584q.m12778a().m12796a(this.f12853c.getActivity(), this.f12852b);
        } else if (this.f12851a == 2001) {
            zM12808b = C3584q.m12778a().m12802a(this.f12852b);
        } else {
            zM12808b = this.f12851a == 2000 ? C3584q.m12778a().m12808b(this.f12853c.getActivity(), this.f12852b) : false;
        }
        if (zM12808b) {
            this.f12853c.m12541a(this.f12852b);
            this.f12853c.m12524a(R.string.ams_msg_deleted);
            this.f12853c.m12561e(false);
        }
        this.f12853c.getActivity().supportInvalidateOptionsMenu();
        if (!zM12808b) {
            C3250y.m11442a("Selected item was not deleted!", getClass().getSimpleName());
        }
        dialogInterface.dismiss();
    }
}
