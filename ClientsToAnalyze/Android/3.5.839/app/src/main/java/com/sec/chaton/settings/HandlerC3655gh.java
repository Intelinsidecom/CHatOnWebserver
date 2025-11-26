package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.gh */
/* loaded from: classes.dex */
class HandlerC3655gh extends Handler {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f13229a;

    HandlerC3655gh(SuggestionsActivity suggestionsActivity) {
        this.f13229a = suggestionsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f13229a.f12828a != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (this.f13229a.f12833f != null && this.f13229a.f12829b != null) {
                this.f13229a.f12833f.setChecked(!this.f13229a.f12829b.m18119a("exclude_me", (Boolean) false).booleanValue());
            }
            if (this.f13229a.f12832e != null && this.f13229a.f12829b != null) {
                this.f13229a.f12832e.setChecked(this.f13229a.f12829b.m18119a("recomned_receive", (Boolean) true).booleanValue());
            }
            try {
                this.f13229a.f12834g.dismiss();
            } catch (Exception e) {
                C4904y.m18634a("Exception occurred while trying to dismiss progress dialog", getClass().getSimpleName());
            }
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                C5179v.m19810a(this.f13229a.f12828a, R.string.toast_network_unable, 0).show();
            } else {
                C5179v.m19811a(this.f13229a.f12828a, this.f13229a.getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
            }
        }
    }
}
