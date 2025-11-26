package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.ChatONVUpgradeDialog;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC2690f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f9984a;

    /* renamed from: b */
    final /* synthetic */ AboutServiceFragment f9985b;

    ViewOnClickListenerC2690f(AboutServiceFragment aboutServiceFragment, int i) {
        this.f9985b = aboutServiceFragment;
        this.f9984a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (this.f9985b.getActivity() != null) {
            this.f9985b.f8930v = C3214cb.m11261b();
            this.f9985b.f8931w = C3214cb.m11264c();
            if (this.f9984a == AboutServiceFragment.f8910e) {
                if (!this.f9985b.f8931w) {
                    if (this.f9985b.f8930v) {
                        C3214cb.m11259b(2);
                        return;
                    } else {
                        C3214cb.m11270f(2);
                        return;
                    }
                }
                C3214cb.m11267d(2);
                return;
            }
            if (this.f9984a == 0) {
                if (!this.f9985b.f8930v) {
                    if (this.f9985b.f8931w) {
                        C3214cb.m11267d(this.f9984a);
                        return;
                    } else {
                        C3214cb.m11270f(this.f9984a);
                        return;
                    }
                }
                this.f9985b.f8932x = ProgressDialogC3265l.m11489a(this.f9985b.f8922m, null, this.f9985b.f8922m.getResources().getString(R.string.wait_sending));
                new C1324bj(this.f9985b.f8916g).m5695c();
                return;
            }
            if (this.f9984a == AboutServiceFragment.f8909d) {
                if (!this.f9985b.f8930v || !this.f9985b.f8931w) {
                    if (!this.f9985b.f8930v || this.f9985b.f8931w) {
                        if (!this.f9985b.f8930v && this.f9985b.f8931w) {
                            C3214cb.m11267d(1);
                            return;
                        } else {
                            C3214cb.m11270f(1);
                            return;
                        }
                    }
                    C3214cb.m11259b(1);
                    return;
                }
                Intent intent = new Intent(this.f9985b.f8922m, (Class<?>) ChatONVUpgradeDialog.class);
                intent.putExtra("isCritical", false);
                intent.putExtra("isFromHome", true);
                this.f9985b.startActivity(intent);
            }
        }
    }
}
