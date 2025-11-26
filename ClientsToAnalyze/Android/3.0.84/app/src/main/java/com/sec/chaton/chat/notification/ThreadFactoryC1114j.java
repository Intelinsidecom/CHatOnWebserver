package com.sec.chaton.chat.notification;

import com.sec.chaton.settings.FragmentSkinChange3;
import java.util.concurrent.ThreadFactory;

/* compiled from: FragmentScreenNotification.java */
/* renamed from: com.sec.chaton.chat.notification.j */
/* loaded from: classes.dex */
class ThreadFactoryC1114j implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ FragmentScreenNotification f4524a;

    ThreadFactoryC1114j(FragmentScreenNotification fragmentScreenNotification) {
        this.f4524a = fragmentScreenNotification;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, FragmentSkinChange3.class.getSimpleName());
        thread.setPriority(1);
        return thread;
    }
}
