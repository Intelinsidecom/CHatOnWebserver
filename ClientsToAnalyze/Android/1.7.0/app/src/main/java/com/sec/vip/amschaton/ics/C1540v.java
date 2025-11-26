package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1341p;
import java.io.File;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.v */
/* loaded from: classes.dex */
class C1540v implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5370a;

    C1540v(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5370a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int iM5662b = this.f5370a.f5271s.m5662b() + this.f5370a.f5271s.m5665c();
        int i2 = i - 1;
        if (this.f5370a.f5274v) {
            if (i2 >= 0 && i2 < iM5662b) {
                if (AMSStampSelectionActivity.f5263a) {
                    if (i2 < this.f5370a.f5271s.m5665c()) {
                        this.f5370a.f5264b = ((this.f5370a.f5271s.m5665c() - 1) - i2) + this.f5370a.f5271s.m5662b();
                    } else {
                        this.f5370a.f5264b = i2 - this.f5370a.f5271s.m5665c();
                    }
                } else {
                    this.f5370a.f5264b = i2;
                }
                this.f5370a.m5597m();
            } else if (i2 == -1) {
                this.f5370a.m5590j();
            }
        } else if (AMSStampSelectionActivity.f5263a) {
            if (i2 >= 0) {
                if (i2 < this.f5370a.f5271s.m5665c()) {
                    int iM5665c = (this.f5370a.f5271s.m5665c() - 1) - i2;
                    File file = new File(this.f5370a.f5271s.m5658a(iM5665c));
                    if (file.exists()) {
                        C1341p.m4658b("User stamp file is delete? : " + file.delete(), getClass().getSimpleName());
                    } else {
                        C1341p.m4658b("There is no user stamp file to delete!", getClass().getSimpleName());
                    }
                    this.f5370a.m4741d();
                    this.f5370a.m5586h();
                    this.f5370a.m5580c(iM5665c);
                } else if (i2 < iM5662b) {
                    this.f5370a.f5274v = this.f5370a.f5274v ? false : true;
                    this.f5370a.f5264b = i2 - this.f5370a.f5271s.m5665c();
                    this.f5370a.m5570a(true);
                    this.f5370a.m5597m();
                }
            }
        } else if (i2 >= 0) {
            if (i2 < this.f5370a.f5271s.m5662b()) {
                this.f5370a.f5274v = this.f5370a.f5274v ? false : true;
                this.f5370a.f5264b = i2;
                this.f5370a.m5570a(true);
                this.f5370a.m5597m();
            } else if (i2 < iM5662b) {
                int iM5662b2 = i2 - this.f5370a.f5271s.m5662b();
                File file2 = new File(this.f5370a.f5271s.m5658a(iM5662b2));
                if (file2.exists()) {
                    C1341p.m4658b("User stamp file is delete? : " + file2.delete(), getClass().getSimpleName());
                } else {
                    C1341p.m4658b("There is no user stamp file to delete!", getClass().getSimpleName());
                }
                this.f5370a.m4741d();
                this.f5370a.m5586h();
                this.f5370a.m5580c(iM5662b2);
            }
        }
        this.f5370a.m5595l();
    }
}
