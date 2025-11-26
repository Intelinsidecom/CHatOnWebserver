package com.sec.vip.amschaton;

import android.content.DialogInterface;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import java.io.IOException;

/* renamed from: com.sec.vip.amschaton.cr */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0698cr implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4320a;

    DialogInterfaceOnClickListenerC0698cr(AMSComposerActivity aMSComposerActivity) {
        this.f4320a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws IOException {
        if (!this.f4320a.f3831G.m3838a(AMSActivity.f3810g + this.f4320a.m3749a("A", System.currentTimeMillis(), "") + ".jpg")) {
            Toast.makeText(this.f4320a.m3735G(), C0062R.string.ams_error_ams_file_save, 0).show();
            return;
        }
        Toast.makeText(this.f4320a.m3735G(), C0062R.string.ams_msg_saved, 0).show();
        dialogInterface.dismiss();
        this.f4320a.m3728C();
    }
}
