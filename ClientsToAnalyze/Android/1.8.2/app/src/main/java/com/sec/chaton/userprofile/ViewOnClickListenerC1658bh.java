package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0107h;
import com.sec.chaton.util.C1786r;

/* compiled from: ProfileRegistStatusMessage.java */
/* renamed from: com.sec.chaton.userprofile.bh */
/* loaded from: classes.dex */
class ViewOnClickListenerC1658bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistStatusMessage f6149a;

    ViewOnClickListenerC1658bh(ProfileRegistStatusMessage profileRegistStatusMessage) {
        this.f6149a = profileRegistStatusMessage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R.id.btnDone == view.getId()) {
            if (C1786r.m6058a(this.f6149a.f5966b.getText().toString())) {
                this.f6149a.f5966b.setText("");
                C1786r.m6051a(1);
                Toast.makeText(this.f6149a.f5965a, "Log On", 1).show();
                return;
            } else {
                C0107h c0107h = new C0107h();
                if (this.f6149a.f5966b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                    c0107h.m685b("");
                } else {
                    c0107h.m685b(this.f6149a.f5966b.getText().toString());
                }
                this.f6149a.f5971j.m2963a(c0107h, "");
                this.f6149a.f5972k.show();
                return;
            }
        }
        if (R.id.btnCancel == view.getId()) {
            if (C1786r.m6058a(this.f6149a.f5966b.getText().toString())) {
                this.f6149a.f5966b.setText("");
                C1786r.m6051a(0);
                Toast.makeText(this.f6149a.f5965a, "Log Off", 1).show();
            } else {
                this.f6149a.setResult(0);
                this.f6149a.finish();
            }
        }
    }
}
