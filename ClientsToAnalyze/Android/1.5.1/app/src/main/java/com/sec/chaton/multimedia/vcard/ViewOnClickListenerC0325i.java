package com.sec.chaton.multimedia.vcard;

import android.view.View;
import com.sec.chaton.multimedia.vcard.ContactStruct;

/* renamed from: com.sec.chaton.multimedia.vcard.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0325i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactActivity f2385a;

    ViewOnClickListenerC0325i(VCardReadContactActivity vCardReadContactActivity) {
        this.f2385a = vCardReadContactActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        int i2 = 0;
        while (this.f2385a.f2356k.size() > i) {
            if (((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2296d == 9 && !((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2298f) {
                this.f2385a.f2357l.f2284d = null;
            }
            if (((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2298f) {
                i2++;
                if (((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2296d == 5) {
                    this.f2385a.f2357l.m2616a(((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2293a, ((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2294b, ((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2295c, true);
                } else if (((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2296d == 1) {
                    this.f2385a.f2357l.m2617b(((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2293a, ((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2294b, ((ContactStruct.ContactMethod) this.f2385a.f2356k.get(i)).f2295c, true);
                }
            }
            i++;
            i2 = i2;
        }
        if (i2 <= 0) {
            this.f2385a.finish();
        } else {
            this.f2385a.showDialog(0);
            new Thread((ThreadGroup) null, this.f2385a.f2366u).start();
        }
    }
}
