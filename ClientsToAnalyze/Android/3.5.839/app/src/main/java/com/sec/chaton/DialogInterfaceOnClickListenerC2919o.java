package com.sec.chaton;

import android.content.DialogInterface;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.o */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2919o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f10788a;

    DialogInterfaceOnClickListenerC2919o(AdminMenu adminMenu) {
        this.f10788a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!C4904y.m18637a(this.f10788a.f1888Y.getText().toString())) {
            if (!C4904y.m18640b(this.f10788a.f1888Y.getText().toString())) {
                if (this.f10788a.m2876a(this.f10788a.f1888Y.getText().toString(), "50c732e69add6f31382fbaf36c09f977")) {
                    if (this.f10788a.m2876a(this.f10788a.f1889Z.getText().toString(), "a9d196ea4bd5a0c3a71945f3ff3b0e09")) {
                        this.f10788a.f1887X.setCurrentTab(0);
                        this.f10788a.f1887X.getTabWidget().getChildTabViewAt(1).setVisibility(8);
                        this.f10788a.f1887X.getTabWidget().getChildTabViewAt(2).setVisibility(8);
                    } else {
                        dialogInterface.dismiss();
                        this.f10788a.finish();
                    }
                } else if (this.f10788a.m2876a(this.f10788a.f1888Y.getText().toString(), "ce7dd4fad0f9d5500d0f3768341419f5")) {
                    if (this.f10788a.m2876a(this.f10788a.f1889Z.getText().toString(), "FAB2034039C257A78A426FB617D677FE")) {
                        this.f10788a.f1887X.setCurrentTab(1);
                        this.f10788a.f1887X.getTabWidget().getChildTabViewAt(2).setVisibility(8);
                    } else {
                        dialogInterface.dismiss();
                        this.f10788a.finish();
                    }
                } else if (this.f10788a.m2876a(this.f10788a.f1888Y.getText().toString(), "edae08599883ad01def5bd2fe22a6574")) {
                    if (this.f10788a.m2876a(this.f10788a.f1889Z.getText().toString(), "49284552e31f0d16b71f7504452d2488")) {
                        this.f10788a.f1887X.setCurrentTab(2);
                    } else {
                        dialogInterface.dismiss();
                        this.f10788a.finish();
                    }
                } else if (this.f10788a.m2876a(this.f10788a.f1888Y.getText().toString(), "6F69F0EC41A4DE7E10F8C956A5B2A44F") && this.f10788a.m2876a(this.f10788a.f1889Z.getText().toString(), "F7235A61FDC3ADC78D866FD8085D44DB")) {
                    this.f10788a.m2865p();
                } else {
                    dialogInterface.dismiss();
                    this.f10788a.finish();
                }
            } else {
                C4904y.m18632a(2);
                C5179v.m19811a(this.f10788a.f1884U, "Log On With Save", 1).show();
                dialogInterface.dismiss();
                this.f10788a.finish();
            }
        } else {
            C4904y.m18632a(1);
            C5179v.m19811a(this.f10788a.f1884U, "Log On", 1).show();
            dialogInterface.dismiss();
            this.f10788a.finish();
        }
        this.f10788a.f1887X.setVisibility(0);
        dialogInterface.dismiss();
    }
}
