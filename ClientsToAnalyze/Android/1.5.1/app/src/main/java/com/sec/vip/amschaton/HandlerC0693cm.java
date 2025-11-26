package com.sec.vip.amschaton;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;

/* renamed from: com.sec.vip.amschaton.cm */
/* loaded from: classes.dex */
class HandlerC0693cm extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4315a;

    HandlerC0693cm(AMSComposerActivity aMSComposerActivity) {
        this.f4315a = aMSComposerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IOException {
        switch (this.f4315a.f3831G.m3842b(this.f4315a.f3844T)) {
            case 1:
                Toast.makeText(this.f4315a.m3735G(), C0062R.string.ams_msg_minor_version_changed, 0).show();
                break;
            case 2:
                Toast.makeText(this.f4315a.m3735G(), C0062R.string.ams_msg_major_version_changed, 0).show();
                break;
            case 3:
                Toast.makeText(this.f4315a.m3735G(), C0062R.string.ams_msg_invalid_ams_file, 0).show();
                ChatONLogWriter.m3499a("Load Error", getClass().getSimpleName());
                break;
            default:
                if (!this.f4315a.f3831G.m3826A()) {
                    Toast.makeText(this.f4315a.m3735G(), C0062R.string.ams_msg_edit_protection, 0).show();
                    break;
                } else {
                    this.f4315a.f3831G.m3852j();
                    this.f4315a.f3831G.invalidate();
                    this.f4315a.m3799q();
                    this.f4315a.m3801r();
                    break;
                }
        }
    }
}
