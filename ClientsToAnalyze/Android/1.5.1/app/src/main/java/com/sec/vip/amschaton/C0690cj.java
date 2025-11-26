package com.sec.vip.amschaton;

import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.vip.amschaton.cj */
/* loaded from: classes.dex */
class C0690cj implements OnApplyListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4312a;

    C0690cj(AMSComposerActivity aMSComposerActivity) {
        this.f4312a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: a */
    public boolean mo4160a() {
        return false;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: b */
    public boolean mo4161b() {
        if (!this.f4312a.f3831G.m3838a(AMSActivity.f3810g + this.f4312a.f3839O.m4179a() + ".jpg")) {
            Toast.makeText(this.f4312a.m3735G(), C0062R.string.ams_error_ams_file_save, 0).show();
            return false;
        }
        this.f4312a.f3853ac = this.f4312a.f3839O.m4179a();
        Toast.makeText(this.f4312a.m3735G(), C0062R.string.ams_msg_saved, 0).show();
        this.f4312a.f3846V = false;
        return false;
    }
}
