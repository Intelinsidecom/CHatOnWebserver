package com.sec.vip.amschaton.fragment;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C3250y;
import com.sec.vip.amschaton.C3584q;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bj */
/* loaded from: classes.dex */
class C3489bj implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12859a;

    C3489bj(AMSListFragment aMSListFragment) {
        this.f12859a = aMSListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String strM12793a;
        Cursor cursorM12125b;
        int i2 = 2002;
        if (this.f12859a.f12739u == 4000) {
            if (this.f12859a.f12741w != null && (cursorM12125b = this.f12859a.f12741w.m12125b(j)) != null) {
                this.f12859a.m12552c(cursorM12125b.getString(cursorM12125b.getColumnIndex("ams_path")), Integer.valueOf(cursorM12125b.getString(cursorM12125b.getColumnIndex("ams_type"))).intValue());
                return;
            }
            return;
        }
        if (this.f12859a.f12728a != 2002) {
            if (i == 0) {
                this.f12859a.m12549b(false);
                this.f12859a.m12527a(null, false, false, false, true);
                return;
            }
            if (i <= 0 || i >= this.f12859a.m12571h() + 1) {
                if (i <= this.f12859a.m12571h() || i >= this.f12859a.m12571h() + this.f12859a.m12574i() + 1) {
                    if (i > this.f12859a.m12571h() + this.f12859a.m12574i() && i < this.f12859a.m12571h() + this.f12859a.m12574i() + this.f12859a.m12576j() + 1) {
                        strM12793a = C3584q.m12778a().m12793a(((i - this.f12859a.m12571h()) - this.f12859a.m12574i()) - 1);
                        i2 = 2000;
                    } else {
                        return;
                    }
                } else {
                    strM12793a = C3584q.m12778a().m12805b((i - this.f12859a.m12571h()) - 1);
                    i2 = 2001;
                }
            } else {
                strM12793a = C3584q.m12778a().m12794a(this.f12859a.getActivity(), i - 1);
            }
            if (strM12793a != null) {
                this.f12859a.m12552c(strM12793a, i2);
            } else {
                C3250y.m11442a("amsFile is NULL!", getClass().getSimpleName());
            }
        }
    }
}
