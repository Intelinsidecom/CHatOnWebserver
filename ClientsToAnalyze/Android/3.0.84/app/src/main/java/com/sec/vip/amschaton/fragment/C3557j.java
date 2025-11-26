package com.sec.vip.amschaton.fragment;

import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.j */
/* loaded from: classes.dex */
class C3557j implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f12987a;

    C3557j(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f12987a = aMSBgSelectionFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws Resources.NotFoundException {
        Cursor cursorM12109b;
        if (this.f12987a.f12645u == 5000) {
            if (this.f12987a.f12640p != null && (cursorM12109b = this.f12987a.f12640p.m12109b(j)) != null) {
                int iIntValue = Integer.valueOf(cursorM12109b.getString(cursorM12109b.getColumnIndex("ams_index"))).intValue();
                this.f12987a.f12635b.setEnabled(false);
                if (iIntValue < 10000) {
                    this.f12987a.f12642r = 1003;
                    this.f12987a.f12643s = iIntValue;
                } else {
                    this.f12987a.f12642r = 1002;
                    this.f12987a.f12643s = iIntValue - 10000;
                }
                this.f12987a.m12392g();
                this.f12987a.m12385e(this.f12987a.f12642r);
                return;
            }
            return;
        }
        if (this.f12987a.f12646v != 3002) {
            if (i == 0) {
                this.f12987a.f12643s = 0;
                this.f12987a.f12642r = 1001;
                this.f12987a.m12384e();
                return;
            }
            if (i == 1) {
                this.f12987a.f12635b.setEnabled(false);
                this.f12987a.f12643s = 0;
                this.f12987a.f12642r = 1000;
                this.f12987a.m12392g();
                this.f12987a.m12385e(this.f12987a.f12642r);
                return;
            }
            if (i < this.f12987a.m12409n() + 2) {
                this.f12987a.f12635b.setEnabled(false);
                this.f12987a.f12643s = i - 2;
                this.f12987a.f12642r = 1002;
                this.f12987a.m12392g();
                this.f12987a.m12385e(this.f12987a.f12642r);
                return;
            }
            if (i < this.f12987a.m12409n() + this.f12987a.m12411o() + 2) {
                this.f12987a.f12635b.setEnabled(false);
                this.f12987a.f12643s = (i - this.f12987a.m12409n()) - 2;
                this.f12987a.f12642r = 1003;
                this.f12987a.m12392g();
                this.f12987a.m12385e(this.f12987a.f12642r);
                return;
            }
            if (i == this.f12987a.m12409n() + this.f12987a.m12411o() + 2) {
                this.f12987a.m12388f();
            }
        }
    }
}
