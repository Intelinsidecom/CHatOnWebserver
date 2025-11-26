package com.sec.chaton.shop.inappbilling;

import android.content.Intent;
import android.content.IntentSender;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p057e.p058a.C2182ah;
import com.sec.chaton.shop.inappbilling.p100a.C3753p;
import com.sec.chaton.shop.inappbilling.p100a.C3756s;
import com.sec.chaton.shop.inappbilling.p100a.InterfaceC3748k;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;

/* compiled from: BillingDialogActivity.java */
/* renamed from: com.sec.chaton.shop.inappbilling.d */
/* loaded from: classes.dex */
class C3760d implements InterfaceC3748k {

    /* renamed from: a */
    final /* synthetic */ BillingDialogActivity f13496a;

    C3760d(BillingDialogActivity billingDialogActivity) {
        this.f13496a = billingDialogActivity;
    }

    @Override // com.sec.chaton.shop.inappbilling.p100a.InterfaceC3748k
    /* renamed from: a */
    public void mo14125a(C3756s c3756s, C3753p c3753p) throws IntentSender.SendIntentException {
        if (C4904y.f17872b) {
            C4904y.m18639b("Consumption finished. Purchase: " + c3756s + ", result: " + c3753p, BillingDialogActivity.f13419b);
        }
        if (c3753p.m14130b()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Consumption successful. Provisioning.", BillingDialogActivity.f13419b);
            }
            this.f13496a.m14091a();
        } else {
            this.f13496a.m14092a("Error while consuming: " + c3753p);
        }
        this.f13496a.m14093a(false);
        if ((this.f13496a.f13428j + this.f13496a.f13430l + this.f13496a.f13427i).equals(c3756s.m14139c())) {
            try {
                C4821am.m18189a(this.f13496a.f13420a, "com.sec.chaton.provider2", C2182ah.m9743a(this.f13496a.f13430l, this.f13496a.f13428j, this.f13496a.f13429k, c3756s, c3753p.m14130b()));
            } catch (OperationApplicationException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, BillingDialogActivity.f13419b);
                }
            } catch (RemoteException e2) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e2, BillingDialogActivity.f13419b);
                }
            }
            Intent intent = new Intent();
            intent.putExtra("purchase_data", c3756s.m14141e());
            intent.putExtra("signature", c3756s.m14142f());
            if (C4904y.f17872b) {
                C4904y.m18639b(c3756s.m14141e(), BillingDialogActivity.f13419b);
                C4904y.m18639b(c3756s.m14142f(), BillingDialogActivity.f13419b);
            }
            this.f13496a.m14083a(-1, intent);
        } else {
            this.f13496a.f13421c.m14109a(this.f13496a.f13422d, this.f13496a.f13427i, 10001, this.f13496a.f13424f, this.f13496a.f13428j);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("End consumption flow.", BillingDialogActivity.f13419b);
        }
    }
}
