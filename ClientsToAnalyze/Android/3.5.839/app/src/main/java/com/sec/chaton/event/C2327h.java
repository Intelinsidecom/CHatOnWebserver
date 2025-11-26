package com.sec.chaton.event;

import android.support.v4.app.AbstractC0020af;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import com.sec.chaton.event.UsingChatONDialogFragment;

/* compiled from: UsingChatONDialogFragment.java */
/* renamed from: com.sec.chaton.event.h */
/* loaded from: classes.dex */
public class C2327h extends AbstractC0020af {

    /* renamed from: a */
    final /* synthetic */ UsingChatONDialogFragment f8280a;

    /* synthetic */ C2327h(UsingChatONDialogFragment usingChatONDialogFragment, AbstractC0069w abstractC0069w, ViewOnClickListenerC2325f viewOnClickListenerC2325f) {
        this(usingChatONDialogFragment, abstractC0069w);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2327h(UsingChatONDialogFragment usingChatONDialogFragment, AbstractC0069w abstractC0069w) {
        super(abstractC0069w);
        this.f8280a = usingChatONDialogFragment;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public int mo612b() {
        return 3;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public int mo607a(Object obj) {
        return -2;
    }

    @Override // android.support.v4.app.AbstractC0020af
    /* renamed from: a */
    public Fragment mo86a(int i) {
        if (i >= 3) {
            return null;
        }
        UsingChatONDialogFragment.UsingChatONDialogContentPagerFragment usingChatONDialogContentPagerFragment = new UsingChatONDialogFragment.UsingChatONDialogContentPagerFragment(i);
        this.f8280a.f8267m.put(Integer.valueOf(i), usingChatONDialogContentPagerFragment);
        return usingChatONDialogContentPagerFragment;
    }
}
