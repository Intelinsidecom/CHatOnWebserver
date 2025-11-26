package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.EnumC1730am;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.fr */
/* loaded from: classes.dex */
class RunnableC0414fr implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC1730am f1573a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f1574b;

    /* renamed from: c */
    final /* synthetic */ C0413fq f1575c;

    RunnableC0414fr(C0413fq c0413fq, EnumC1730am enumC1730am, Bitmap bitmap) {
        this.f1575c = c0413fq;
        this.f1573a = enumC1730am;
        this.f1574b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1573a == EnumC1730am.SUCCESS) {
            if (this.f1574b == null) {
                Toast.makeText(this.f1575c.f1572a.f1299c, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            } else {
                this.f1575c.f1572a.f1305l = this.f1574b;
                this.f1575c.f1572a.f1301e.setImageBitmap(this.f1575c.f1572a.f1305l);
                if (!GlobalApplication.m3265f()) {
                    this.f1575c.f1572a.f1302i.setEnabled(true);
                }
            }
        } else if (this.f1573a == EnumC1730am.ERROR) {
            Toast.makeText(this.f1575c.f1572a.f1299c, R.string.toast_network_unable, 0).show();
        }
        if (this.f1575c.f1572a.f1304k != null) {
            this.f1575c.f1572a.f1304k.dismiss();
        }
        if (!GlobalApplication.m3265f()) {
            this.f1575c.f1572a.f1303j.setEnabled(true);
        }
    }
}
