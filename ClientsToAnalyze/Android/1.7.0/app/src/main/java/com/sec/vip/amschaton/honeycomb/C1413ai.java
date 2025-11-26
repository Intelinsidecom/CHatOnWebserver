package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1341p;
import java.io.File;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ai */
/* loaded from: classes.dex */
class C1413ai implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5042a;

    C1413ai(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5042a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int iM5662b = this.f5042a.f5026s.m5662b() + this.f5042a.f5026s.m5665c();
        int i2 = i - 1;
        if (this.f5042a.f5029v) {
            if (i2 >= 0 && i2 < iM5662b) {
                if (AMSStampSelectionActivity.f5018a) {
                    if (i2 < this.f5042a.f5026s.m5665c()) {
                        this.f5042a.f5019b = ((this.f5042a.f5026s.m5665c() - 1) - i2) + this.f5042a.f5026s.m5662b();
                    } else {
                        this.f5042a.f5019b = i2 - this.f5042a.f5026s.m5665c();
                    }
                } else {
                    this.f5042a.f5019b = i2;
                }
                this.f5042a.m5267m();
            } else if (i2 == -1) {
                this.f5042a.m5262j();
            }
        } else if (AMSStampSelectionActivity.f5018a) {
            if (i2 >= 0) {
                if (i2 < this.f5042a.f5026s.m5665c()) {
                    int iM5665c = (this.f5042a.f5026s.m5665c() - 1) - i2;
                    File file = new File(this.f5042a.f5026s.m5658a(iM5665c));
                    if (file.exists()) {
                        C1341p.m4658b("User stamp file is delete? : " + file.delete(), getClass().getSimpleName());
                    } else {
                        C1341p.m4658b("There is no user stamp file to delete!", getClass().getSimpleName());
                    }
                    this.f5042a.m4741d();
                    this.f5042a.m5257h();
                    this.f5042a.m5251c(iM5665c);
                } else if (i2 < iM5662b) {
                    this.f5042a.f5029v = this.f5042a.f5029v ? false : true;
                    this.f5042a.f5019b = i2 - this.f5042a.f5026s.m5665c();
                    this.f5042a.m5249b(true);
                    this.f5042a.m5267m();
                }
            }
        } else if (i2 >= 0) {
            if (i2 < this.f5042a.f5026s.m5662b()) {
                this.f5042a.f5029v = this.f5042a.f5029v ? false : true;
                this.f5042a.f5019b = i2;
                this.f5042a.m5249b(true);
                this.f5042a.m5267m();
            } else if (i2 < iM5662b) {
                int iM5662b2 = i2 - this.f5042a.f5026s.m5662b();
                File file2 = new File(this.f5042a.f5026s.m5658a(iM5662b2));
                if (file2.exists()) {
                    C1341p.m4658b("User stamp file is delete? : " + file2.delete(), getClass().getSimpleName());
                } else {
                    C1341p.m4658b("There is no user stamp file to delete!", getClass().getSimpleName());
                }
                this.f5042a.m4741d();
                this.f5042a.m5257h();
                this.f5042a.m5251c(iM5662b2);
            }
        }
        this.f5042a.m5266l();
    }
}
