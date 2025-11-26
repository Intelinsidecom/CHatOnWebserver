package com.sec.vip.amschaton.fragment;

import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ck */
/* loaded from: classes.dex */
class C3517ck implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12915a;

    C3517ck(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12915a = aMSStampSelectionFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws Resources.NotFoundException {
        Cursor cursorM12117b;
        if (this.f12915a.f12763v == 5000) {
            if (this.f12915a.f12765x != null && (cursorM12117b = this.f12915a.f12765x.m12117b(j)) != null) {
                this.f12915a.m12617d(Integer.valueOf(cursorM12117b.getString(cursorM12117b.getColumnIndex("ams_index"))).intValue());
                return;
            }
            return;
        }
        if (this.f12915a.f12754m != 2002) {
            int iM12645m = this.f12915a.m12645m() + this.f12915a.m12647n() + this.f12915a.m12649o() + this.f12915a.m12651p();
            int i2 = i - 1;
            if (i2 >= 0 && i2 < iM12645m) {
                this.f12915a.f12751a = i2;
                this.f12915a.m12617d(this.f12915a.m12620e());
            } else if (i2 == -1) {
                this.f12915a.m12586a();
            }
            this.f12915a.m12625f();
        }
    }
}
