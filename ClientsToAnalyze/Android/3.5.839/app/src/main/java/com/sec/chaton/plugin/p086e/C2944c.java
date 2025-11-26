package com.sec.chaton.plugin.p086e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* compiled from: Task.java */
/* renamed from: com.sec.chaton.plugin.e.c */
/* loaded from: classes.dex */
public class C2944c implements InterfaceC2942a {

    /* renamed from: a */
    protected Handler f10835a;

    /* renamed from: b */
    protected Bundle f10836b;

    /* renamed from: c */
    final /* synthetic */ AbstractRunnableC2943b f10837c;

    public C2944c(AbstractRunnableC2943b abstractRunnableC2943b, Handler handler) {
        this.f10837c = abstractRunnableC2943b;
        this.f10835a = handler;
    }

    @Override // com.sec.chaton.plugin.p086e.InterfaceC2942a
    /* renamed from: a */
    public void mo12178a(int i) {
        Message messageObtainMessage = this.f10835a.obtainMessage(i);
        messageObtainMessage.arg1 = this.f10837c.f10834a;
        if (this.f10836b != null) {
            messageObtainMessage.setData(this.f10836b);
        }
        this.f10835a.sendMessage(messageObtainMessage);
    }

    @Override // com.sec.chaton.plugin.p086e.InterfaceC2942a
    /* renamed from: a */
    public void mo12180a(String str) {
        Message messageObtainMessage = this.f10835a.obtainMessage(0);
        messageObtainMessage.arg1 = this.f10837c.f10834a;
        messageObtainMessage.obj = this.f10837c.mo12183a(str);
        if (this.f10836b != null) {
            messageObtainMessage.setData(this.f10836b);
        }
        this.f10835a.sendMessage(messageObtainMessage);
    }

    @Override // com.sec.chaton.plugin.p086e.InterfaceC2942a
    /* renamed from: a */
    public void mo12179a(int i, int i2, String str, String str2) {
        Message messageObtainMessage = this.f10835a.obtainMessage(i);
        messageObtainMessage.arg1 = this.f10837c.f10834a;
        messageObtainMessage.obj = this.f10837c.mo12182a(i2, str, str2);
        if (this.f10836b != null) {
            messageObtainMessage.setData(this.f10836b);
        }
        this.f10835a.sendMessage(messageObtainMessage);
    }
}
