package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1058ba;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1735gh;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5033j;
import com.sec.widget.C5179v;

/* compiled from: DeregisterFragment.java */
/* renamed from: com.sec.chaton.settings.dz */
/* loaded from: classes.dex */
class ViewOnClickListenerC3589dz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeregisterFragment f13110a;

    ViewOnClickListenerC3589dz(DeregisterFragment deregisterFragment) {
        this.f13110a = deregisterFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f13110a.f12678o != null || C4822an.m18218a()) {
            if (this.f13110a.f12677n) {
                this.f13110a.f12670g = ProgressDialogC4926s.m18727a(this.f13110a.getActivity(), null, this.f13110a.getResources().getString(R.string.deregister_device));
            } else {
                this.f13110a.f12670g = ProgressDialogC4926s.m18727a(this.f13110a.getActivity(), null, this.f13110a.getResources().getString(R.string.delete_account));
            }
            this.f13110a.f12670g.setCancelable(false);
            if (this.f13110a.f12678o != null) {
                if (C4822an.m18255w()) {
                    this.f13110a.f12672i.m9391b(this.f13110a.f12678o);
                    return;
                } else {
                    this.f13110a.f12672i.m9393c(this.f13110a.f12678o);
                    return;
                }
            }
            if (C4859bx.m18386a((Context) this.f13110a.getActivity())) {
                this.f13110a.f12676m = new C0416a();
                if (this.f13110a.f12676m.m1495d(this.f13110a.getActivity())) {
                    this.f13110a.f12676m.m1491a(this.f13110a.getActivity(), this.f13110a);
                    if (C4859bx.m18388b(this.f13110a.getActivity(), this.f13110a.f12676m) != 0) {
                        this.f13110a.f12671h.mo9079b(this.f13110a.f12664a);
                        this.f13110a.f12664a.m18262a(30000);
                        return;
                    }
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("ChatONV was NOT registered", DeregisterFragment.f12663p);
                }
                this.f13110a.f12671h.mo9079b(this.f13110a.f12664a);
                this.f13110a.f12664a.m18262a(30000);
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("ChatONV was NOT installed", DeregisterFragment.f12663p);
            }
            this.f13110a.f12671h.mo9079b(this.f13110a.f12664a);
            this.f13110a.f12664a.m18262a(30000);
            return;
        }
        C2268bn.m10126a(CommonApplication.m18732r()).close();
        SharedPreferences.Editor editorEdit = CommonApplication.m18732r().getSharedPreferences("PASSWORD_LOCK", 0).edit();
        editorEdit.putString("LOCK_STATE", C4892m.m18588h());
        editorEdit.putString("PASSWORD", "0000");
        editorEdit.putString("PASSWORD_HINT", "");
        C5033j.m19087a(editorEdit);
        C4809aa.m18104a().m18122a();
        C4809aa.m18109b();
        C1735gh.m8621b();
        C4894o.m18606a(CommonApplication.m18732r().getApplicationInfo().dataDir);
        C1813b.m8906b().m8935c();
        C5179v.m19811a(this.f13110a.getActivity(), this.f13110a.getResources().getString(R.string.toast_service_terminated), 0).show();
        C0991aa.m6037a().m18962d(new C1058ba());
    }
}
