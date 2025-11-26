package com.sec.vip.cropimage;

import android.content.DialogInterface;
import com.sec.chaton.p055d.C2134o;
import java.io.File;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC5125l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC5123j f18698a;

    DialogInterfaceOnClickListenerC5125l(HandlerC5123j handlerC5123j) {
        this.f18698a = handlerC5123j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        File file = new File(this.f18698a.f18696a.f18621N);
        C2134o.m9573a(this.f18698a.f18696a.f18628U, file.getPath(), file.getName(), this.f18698a.f18696a.f18624Q);
        this.f18698a.f18696a.m19532m();
    }
}
