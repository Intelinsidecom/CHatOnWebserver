package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.account.ContactManager;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ProfileImageLoader;

/* loaded from: classes.dex */
public class BlockTask extends AbstractHttpTask2 {

    /* renamed from: a */
    private int f1477a;

    /* renamed from: b */
    private String f1478b;

    public BlockTask(Handler handler, HttpEnvelope httpEnvelope, String str, int i) {
        super(handler, httpEnvelope);
        this.f1477a = i;
        this.f1478b = str;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (httpEntry.m1950a() && httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            ProfileImageLoader.m3610a(GlobalApplication.m2387e()).m3625a(this.f1478b);
            ContactManager.m405a(true);
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        this.msg.arg1 = this.f1477a;
        return null;
    }
}
