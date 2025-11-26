package com.sec.chaton.samsungaccount;

import android.app.Activity;
import android.content.Intent;
import com.sec.chaton.p055d.EnumC2111bq;
import com.sec.chaton.p055d.InterfaceC2113bs;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.aw */
/* loaded from: classes.dex */
class C3344aw implements InterfaceC2113bs {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12282a;

    C3344aw(MainActivity mainActivity) {
        this.f12282a = mainActivity;
    }

    @Override // com.sec.chaton.p055d.InterfaceC2113bs
    /* renamed from: a */
    public void mo9385a(int i, EnumC2111bq enumC2111bq) {
        switch (i) {
            case 1301:
                if (!((Activity) this.f12282a.f12192B).isFinishing()) {
                    this.f12282a.m13186w();
                }
                this.f12282a.setResult(6, new Intent());
                this.f12282a.finish();
                break;
            case 1302:
                ((Activity) this.f12282a.f12192B).runOnUiThread(new RunnableC3346ay(this));
                break;
            case 1303:
                ((Activity) this.f12282a.f12192B).runOnUiThread(new RunnableC3345ax(this));
                break;
            case 1304:
                this.f12282a.f12169w = true;
                this.f12282a.m13143l();
                break;
        }
    }
}
