package com.sec.chaton.sns.p115ui.vkontakte;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.sns.p114b.C4388an;
import com.sec.chaton.sns.p115ui.InterfaceC4450ad;
import com.sec.chaton.sns.p115ui.InterfaceC4451ae;
import com.sec.chaton.sns.p115ui.SnsMessageFragment;

/* loaded from: classes.dex */
public class VKontakteMessageFragment extends SnsMessageFragment implements InterfaceC4450ad, InterfaceC4451ae {

    /* renamed from: b */
    private C4388an f16260b;

    protected VKontakteMessageFragment() {
        m16895a(Integer.parseInt("140"));
        m16897a((InterfaceC4451ae) this);
        m16896a((InterfaceC4450ad) this);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16260b = new C4388an(this.f16037a);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f16260b.mo16639a();
        super.onDestroy();
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.sns.p115ui.InterfaceC4450ad
    /* renamed from: a */
    public void mo16936a(String str, String str2) {
        m16901c();
        this.f16260b.m16681a(str2, new C4516a(this));
    }

    @Override // com.sec.chaton.sns.p115ui.InterfaceC4451ae
    /* renamed from: a */
    public void mo16937a(Editable editable) {
        if (editable == null) {
            m16900b(m16894a().length());
        }
    }
}
