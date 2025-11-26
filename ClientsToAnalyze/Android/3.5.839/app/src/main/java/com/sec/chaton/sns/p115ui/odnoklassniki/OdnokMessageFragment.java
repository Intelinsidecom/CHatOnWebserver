package com.sec.chaton.sns.p115ui.odnoklassniki;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.sns.p114b.C4382ah;
import com.sec.chaton.sns.p115ui.InterfaceC4450ad;
import com.sec.chaton.sns.p115ui.InterfaceC4451ae;
import com.sec.chaton.sns.p115ui.SnsMessageFragment;

/* loaded from: classes.dex */
public class OdnokMessageFragment extends SnsMessageFragment implements InterfaceC4450ad, InterfaceC4451ae {

    /* renamed from: b */
    private C4382ah f16201b;

    protected OdnokMessageFragment() {
        m16895a(Integer.parseInt("140"));
        m16897a((InterfaceC4451ae) this);
        m16896a((InterfaceC4450ad) this);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16201b = new C4382ah(this.f16037a);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f16201b.mo16639a();
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
        this.f16201b.m16659a(str2, new C4494a(this));
    }

    @Override // com.sec.chaton.sns.p115ui.InterfaceC4451ae
    /* renamed from: a */
    public void mo16937a(Editable editable) {
        if (editable == null) {
            m16900b(m16894a().length());
        }
    }
}
