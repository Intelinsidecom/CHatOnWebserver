package com.sec.vip.cropimage;

import android.content.DialogInterface;
import com.sec.chaton.p025d.C1335m;
import java.io.File;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.z */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3630z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3628x f13340a;

    DialogInterfaceOnClickListenerC3630z(HandlerC3628x handlerC3628x) {
        this.f13340a = handlerC3628x;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        File file = new File(this.f13340a.f13338a.f13197B);
        C1335m.m5786a(this.f13340a.f13338a.f13204I, file.getPath(), file.getName(), this.f13340a.f13338a.f13200E);
        this.f13340a.f13338a.m12945h();
    }
}
