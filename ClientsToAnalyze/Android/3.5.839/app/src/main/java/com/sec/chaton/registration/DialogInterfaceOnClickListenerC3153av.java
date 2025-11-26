package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.AdminMenu;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.av */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3153av implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11905a;

    DialogInterfaceOnClickListenerC3153av(C3134ac c3134ac) {
        this.f11905a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (C4904y.m18637a(this.f11905a.f11885u.getText().toString())) {
            if (this.f11905a.f11879o > 13) {
                Intent intent = new Intent(this.f11905a.f11876l, (Class<?>) AdminMenu.class);
                intent.putExtra("operation", false);
                intent.putExtra("mapping_mode", false);
                intent.putExtra("general_tab", true);
                this.f11905a.f11876l.startActivity(intent);
                this.f11905a.f11879o = 0;
            }
            C4904y.m18632a(1);
            C5179v.m19811a(this.f11905a.f11876l, "Log On", 1).show();
            if (this.f11905a.f11880p != null && this.f11905a.f11880p.isShowing()) {
                this.f11905a.f11880p.dismiss();
                return;
            }
            return;
        }
        if (!C4904y.m18643c(this.f11905a.f11885u.getText().toString())) {
            if (C4904y.m18640b(this.f11905a.f11885u.getText().toString())) {
                if (this.f11905a.f11879o > 13) {
                    Intent intent2 = new Intent(this.f11905a.f11876l, (Class<?>) AdminMenu.class);
                    intent2.putExtra("operation", false);
                    intent2.putExtra("mapping_mode", false);
                    intent2.putExtra("general_tab", true);
                    this.f11905a.f11876l.startActivity(intent2);
                    this.f11905a.f11879o = 0;
                }
                C4904y.m18632a(2);
                C5179v.m19811a(this.f11905a.f11876l, "Log On With Save", 1).show();
                if (this.f11905a.f11880p != null && this.f11905a.f11880p.isShowing()) {
                    this.f11905a.f11880p.dismiss();
                    return;
                }
                return;
            }
            return;
        }
        Intent intent3 = new Intent(this.f11905a.f11876l, (Class<?>) AdminMenu.class);
        intent3.putExtra("operation", true);
        intent3.putExtra("mapping_mode", false);
        intent3.putExtra("general_tab", false);
        this.f11905a.f11876l.startActivity(intent3);
    }
}
