package com.sec.chaton.trunk;

import android.os.Bundle;
import android.support.v4.app.AbstractC0020af;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import com.p137vk.sdk.api.VKApiConst;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.cb */
/* loaded from: classes.dex */
public class C4644cb extends AbstractC0020af {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f16827a;

    /* synthetic */ C4644cb(TrunkPageActivity trunkPageActivity, AbstractC0069w abstractC0069w, C4630bv c4630bv) {
        this(trunkPageActivity, abstractC0069w);
    }

    @Override // android.support.v4.app.AbstractC0020af, android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo79a(ViewGroup viewGroup, int i, Object obj) {
        super.mo79a(viewGroup, i, obj);
        this.f16827a.f16584G.remove(Integer.valueOf(i));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4644cb(TrunkPageActivity trunkPageActivity, AbstractC0069w abstractC0069w) {
        super(abstractC0069w);
        this.f16827a = trunkPageActivity;
    }

    @Override // android.support.v4.app.AbstractC0020af
    /* renamed from: a */
    public Fragment mo86a(int i) {
        if (this.f16827a.f16603p.size() <= i || this.f16827a.f16603p.get(i) == null) {
            return null;
        }
        TrunkFullView trunkFullView = new TrunkFullView();
        Bundle bundle = new Bundle();
        bundle.putInt(VKApiConst.POSITION, i);
        trunkFullView.setArguments(bundle);
        this.f16827a.f16584G.put(Integer.valueOf(i), trunkFullView);
        return trunkFullView;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public int mo612b() {
        return this.f16827a.f16603p.size();
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public int mo607a(Object obj) {
        return -2;
    }
}
