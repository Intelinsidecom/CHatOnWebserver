package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1786r;
import java.io.File;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ca */
/* loaded from: classes.dex */
class C2032ca implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7320a;

    C2032ca(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7320a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int iM6402b = this.f7320a.f7239t.m6402b() + this.f7320a.f7239t.m6405c();
        int i2 = i - 1;
        if (this.f7320a.f7242w) {
            if (i2 >= 0 && i2 < iM6402b) {
                if (AMSStampSelectionActivity.f7231l) {
                    if (i2 < this.f7320a.f7239t.m6405c()) {
                        this.f7320a.f7232m = ((this.f7320a.f7239t.m6405c() - 1) - i2) + this.f7320a.f7239t.m6402b();
                    } else {
                        this.f7320a.f7232m = i2 - this.f7320a.f7239t.m6405c();
                    }
                } else {
                    this.f7320a.f7232m = i2;
                }
                this.f7320a.m7154m();
            } else if (i2 == -1) {
                this.f7320a.m7147j();
            }
        } else if (AMSStampSelectionActivity.f7231l) {
            if (i2 >= 0) {
                if (i2 < this.f7320a.f7239t.m6405c()) {
                    int iM6405c = (this.f7320a.f7239t.m6405c() - 1) - i2;
                    File file = new File(this.f7320a.f7239t.m6398a(iM6405c));
                    if (file.exists()) {
                        C1786r.m6061b("User stamp file is delete? : " + file.delete(), getClass().getSimpleName());
                    } else {
                        C1786r.m6061b("There is no user stamp file to delete!", getClass().getSimpleName());
                    }
                    this.f7320a.m6264c();
                    this.f7320a.m7143h();
                    this.f7320a.m7136c(iM6405c);
                } else if (i2 < iM6402b) {
                    this.f7320a.f7242w = this.f7320a.f7242w ? false : true;
                    this.f7320a.f7232m = i2 - this.f7320a.f7239t.m6405c();
                    this.f7320a.m7126a(true);
                    this.f7320a.m7154m();
                }
            }
        } else if (i2 >= 0) {
            if (i2 < this.f7320a.f7239t.m6402b()) {
                this.f7320a.f7242w = this.f7320a.f7242w ? false : true;
                this.f7320a.f7232m = i2;
                this.f7320a.m7126a(true);
                this.f7320a.m7154m();
            } else if (i2 < iM6402b) {
                int iM6402b2 = i2 - this.f7320a.f7239t.m6402b();
                File file2 = new File(this.f7320a.f7239t.m6398a(iM6402b2));
                if (file2.exists()) {
                    C1786r.m6061b("User stamp file is delete? : " + file2.delete(), getClass().getSimpleName());
                } else {
                    C1786r.m6061b("There is no user stamp file to delete!", getClass().getSimpleName());
                }
                this.f7320a.m6264c();
                this.f7320a.m7143h();
                this.f7320a.m7136c(iM6402b2);
            }
        }
        this.f7320a.m7152l();
    }
}
