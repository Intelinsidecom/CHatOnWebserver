package com.sec.vip.amschaton;

import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.vip.amschaton.af */
/* loaded from: classes.dex */
class C0632af implements OnApplyListener {

    /* renamed from: a */
    final /* synthetic */ TextInputDialog f4241a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f4242b;

    C0632af(AMSPlayerActivity aMSPlayerActivity, TextInputDialog textInputDialog) {
        this.f4242b = aMSPlayerActivity;
        this.f4241a = textInputDialog;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: a */
    public boolean mo4160a() {
        return false;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: b */
    public boolean mo4161b() {
        if (this.f4242b.m4019a(this.f4242b.f4026m, AMSActivity.f3810g + this.f4241a.m4179a() + ".jpg")) {
            Toast.makeText(this.f4242b.m4055w(), C0062R.string.ams_msg_saved, 0).show();
            return false;
        }
        Toast.makeText(this.f4242b.m4055w(), C0062R.string.ams_error_ams_file_save, 0).show();
        return false;
    }
}
