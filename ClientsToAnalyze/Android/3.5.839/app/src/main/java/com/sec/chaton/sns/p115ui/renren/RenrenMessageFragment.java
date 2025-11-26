package com.sec.chaton.sns.p115ui.renren;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.sns.p114b.C4384aj;
import com.sec.chaton.sns.p115ui.C4449ac;
import com.sec.chaton.sns.p115ui.InterfaceC4450ad;
import com.sec.chaton.sns.p115ui.InterfaceC4451ae;
import com.sec.chaton.sns.p115ui.SnsMessageFragment;

/* loaded from: classes.dex */
public class RenrenMessageFragment extends SnsMessageFragment implements InterfaceC4450ad, InterfaceC4451ae {

    /* renamed from: b */
    private C4384aj f16233b = null;

    /* renamed from: c */
    private C4449ac f16234c;

    protected RenrenMessageFragment() {
        this.f16234c = null;
        this.f16234c = new C4449ac(this, Integer.parseInt("480"), "KSC5601");
        InputFilter[] inputFilterArr = {this.f16234c};
        m16895a(Integer.parseInt("480"));
        m16898a(inputFilterArr);
        m16897a((InterfaceC4451ae) this);
        m16896a((InterfaceC4450ad) this);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16233b = new C4384aj(this.f16037a);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsMessageFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f16233b.mo16639a();
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
        this.f16233b.m16664a(str2, new C4506a(this));
    }

    @Override // com.sec.chaton.sns.p115ui.InterfaceC4451ae
    /* renamed from: a */
    public void mo16937a(Editable editable) {
        if (editable != null) {
            m16900b(this.f16234c.m16935a(editable.toString()));
        }
    }
}
