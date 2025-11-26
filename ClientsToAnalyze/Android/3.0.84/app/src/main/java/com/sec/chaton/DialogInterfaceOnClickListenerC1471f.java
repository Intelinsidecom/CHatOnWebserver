package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1471f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f5449a;

    DialogInterfaceOnClickListenerC1471f(AdminMenu adminMenu) {
        this.f5449a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5449a.m1131a(this.f5449a.f634G.getText().toString(), "50c732e69add6f31382fbaf36c09f977")) {
            if (this.f5449a.m1131a(this.f5449a.f635H.getText().toString(), "a9d196ea4bd5a0c3a71945f3ff3b0e09")) {
                this.f5449a.f633F.setCurrentTab(0);
                this.f5449a.f633F.getTabWidget().getChildTabViewAt(1).setVisibility(8);
                this.f5449a.f633F.getTabWidget().getChildTabViewAt(2).setVisibility(8);
            } else {
                dialogInterface.dismiss();
                this.f5449a.finish();
            }
        } else if (this.f5449a.m1131a(this.f5449a.f634G.getText().toString(), "ce7dd4fad0f9d5500d0f3768341419f5")) {
            if (this.f5449a.m1131a(this.f5449a.f635H.getText().toString(), "FAB2034039C257A78A426FB617D677FE")) {
                this.f5449a.f633F.setCurrentTab(1);
                this.f5449a.f633F.getTabWidget().getChildTabViewAt(2).setVisibility(8);
            } else {
                dialogInterface.dismiss();
                this.f5449a.finish();
            }
        } else if (this.f5449a.m1131a(this.f5449a.f634G.getText().toString(), "edae08599883ad01def5bd2fe22a6574") && this.f5449a.m1131a(this.f5449a.f635H.getText().toString(), "49284552e31f0d16b71f7504452d2488")) {
            this.f5449a.f633F.setCurrentTab(2);
        } else {
            dialogInterface.dismiss();
            this.f5449a.finish();
        }
        this.f5449a.f633F.setVisibility(0);
        dialogInterface.dismiss();
    }
}
