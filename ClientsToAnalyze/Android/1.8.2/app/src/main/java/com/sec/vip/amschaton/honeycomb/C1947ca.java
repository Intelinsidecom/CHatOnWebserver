package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1786r;
import java.io.File;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ca */
/* loaded from: classes.dex */
class C1947ca implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7091a;

    C1947ca(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7091a = aMSStampSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int iM6402b = this.f7091a.f7013u.m6402b() + this.f7091a.f7013u.m6405c();
        int i2 = i - 1;
        if (this.f7091a.f7016x) {
            if (i2 >= 0 && i2 < iM6402b) {
                if (AMSStampSelectionActivity.f7004l) {
                    if (i2 < this.f7091a.f7013u.m6405c()) {
                        this.f7091a.f7006n = ((this.f7091a.f7013u.m6405c() - 1) - i2) + this.f7091a.f7013u.m6402b();
                    } else {
                        this.f7091a.f7006n = i2 - this.f7091a.f7013u.m6405c();
                    }
                } else {
                    this.f7091a.f7006n = i2;
                }
                this.f7091a.m6839m();
            } else if (i2 == -1) {
                this.f7091a.m6833j();
            }
        } else if (AMSStampSelectionActivity.f7004l) {
            if (i2 >= 0) {
                if (i2 < this.f7091a.f7013u.m6405c()) {
                    int iM6405c = (this.f7091a.f7013u.m6405c() - 1) - i2;
                    File file = new File(this.f7091a.f7013u.m6398a(iM6405c));
                    if (file.exists()) {
                        C1786r.m6061b("User stamp file is delete? : " + file.delete(), getClass().getSimpleName());
                    } else {
                        C1786r.m6061b("There is no user stamp file to delete!", getClass().getSimpleName());
                    }
                    this.f7091a.m6264c();
                    this.f7091a.m6828h();
                    this.f7091a.m6822d(iM6405c);
                } else if (i2 < iM6402b) {
                    this.f7091a.f7016x = this.f7091a.f7016x ? false : true;
                    this.f7091a.f7006n = i2 - this.f7091a.f7013u.m6405c();
                    this.f7091a.m6817b(true);
                    this.f7091a.m6839m();
                }
            }
        } else if (i2 >= 0) {
            if (i2 < this.f7091a.f7013u.m6402b()) {
                this.f7091a.f7016x = this.f7091a.f7016x ? false : true;
                this.f7091a.f7006n = i2;
                this.f7091a.m6817b(true);
                this.f7091a.m6839m();
            } else if (i2 < iM6402b) {
                int iM6402b2 = i2 - this.f7091a.f7013u.m6402b();
                File file2 = new File(this.f7091a.f7013u.m6398a(iM6402b2));
                if (file2.exists()) {
                    C1786r.m6061b("User stamp file is delete? : " + file2.delete(), getClass().getSimpleName());
                } else {
                    C1786r.m6061b("There is no user stamp file to delete!", getClass().getSimpleName());
                }
                this.f7091a.m6264c();
                this.f7091a.m6828h();
                this.f7091a.m6822d(iM6402b2);
            }
        }
        this.f7091a.m6837l();
    }
}
