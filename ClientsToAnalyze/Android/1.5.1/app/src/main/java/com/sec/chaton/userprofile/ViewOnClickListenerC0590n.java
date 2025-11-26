package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.UserProfileEntry;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.userprofile.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC0590n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistStatusMessage f3587a;

    ViewOnClickListenerC0590n(ProfileRegistStatusMessage profileRegistStatusMessage) {
        this.f3587a = profileRegistStatusMessage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0062R.id.btnDone != view.getId()) {
            if (C0062R.id.btnCancel == view.getId()) {
                if (!ChatONLogWriter.m3503a(this.f3587a.f3356b.getText().toString())) {
                    this.f3587a.setResult(0);
                    this.f3587a.finish();
                    return;
                } else {
                    this.f3587a.f3356b.setText("");
                    ChatONLogWriter.m3496a(0);
                    Toast.makeText(this.f3587a.f3355a, "Log Off", 1).show();
                    return;
                }
            }
            return;
        }
        if (ChatONLogWriter.m3503a(this.f3587a.f3356b.getText().toString())) {
            this.f3587a.f3356b.setText("");
            ChatONLogWriter.m3496a(1);
            Toast.makeText(this.f3587a.f3355a, "Log On", 1).show();
        } else {
            UserProfileEntry userProfileEntry = new UserProfileEntry();
            if (this.f3587a.f3356b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                userProfileEntry.m1967b("");
            } else {
                userProfileEntry.m1967b(this.f3587a.f3356b.getText().toString());
            }
            this.f3587a.f3361g.m2065a(userProfileEntry, "");
            this.f3587a.f3362h.show();
        }
    }
}
