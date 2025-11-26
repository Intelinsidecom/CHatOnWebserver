package com.sec.vip.amschaton;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;

/* renamed from: com.sec.vip.amschaton.as */
/* loaded from: classes.dex */
class C0645as implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionDialog f4255a;

    C0645as(AMSStampSelectionDialog aMSStampSelectionDialog) {
        this.f4255a = aMSStampSelectionDialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int iM4063b = this.f4255a.f4057m.m4063b() + this.f4255a.f4057m.m4065c();
        int iM4063b2 = this.f4255a.f4057m.m4063b();
        if (this.f4255a.f4060p) {
            if (i >= 0 && i < iM4063b) {
                this.f4255a.f4050f = i;
                if (this.f4255a.f4085e != null) {
                    this.f4255a.f4085e.mo4161b();
                }
                this.f4255a.dismiss();
            } else if (i == iM4063b && this.f4255a.f4061q != null) {
                this.f4255a.f4061q.mo4231a(28673);
            }
        } else if (i < iM4063b2) {
            this.f4255a.f4060p = !this.f4255a.f4060p;
            this.f4255a.f4050f = i;
            this.f4255a.f4059o.setText(C0062R.string.ams_btn_delete);
            this.f4255a.m4086b();
        } else if (i < iM4063b) {
            int i2 = i - iM4063b2;
            File file = new File(this.f4255a.f4057m.m4066c(i2));
            if (file.exists()) {
                ChatONLogWriter.m3506b("User stamp file is delete? : " + file.delete(), getClass().getSimpleName());
            } else {
                ChatONLogWriter.m3506b("There is no user stamp file to delete!", getClass().getSimpleName());
            }
            if (this.f4255a.f4061q != null) {
                this.f4255a.f4061q.mo4231a(28674);
            }
            this.f4255a.m4073b(i2);
        }
        this.f4255a.m4086b();
    }
}
