package com.sec.chaton.settings.tellfriends;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.settings.tellfriends.common.C2804t;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2805u;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2806v;
import com.sec.chaton.settings.tellfriends.common.SnsMessageFragment;

/* loaded from: classes.dex */
public class WeiboMessageFragment extends SnsMessageFragment implements InterfaceC2805u, InterfaceC2806v {

    /* renamed from: b */
    private C2739ap f10064b = null;

    /* renamed from: c */
    private C2804t f10065c;

    protected WeiboMessageFragment() {
        this.f10065c = null;
        this.f10065c = new C2804t(this, Integer.parseInt("280"), "KSC5601");
        InputFilter[] inputFilterArr = {this.f10065c};
        m9968a(Integer.parseInt("280"));
        m9971a(inputFilterArr);
        m9970a((InterfaceC2806v) this);
        m9969a((InterfaceC2805u) this);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsMessageFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f10064b.mo9767a();
        super.onDestroy();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsMessageFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10064b = new C2739ap(this.f10235a);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2805u
    /* renamed from: a */
    public void mo9713a(String str, String str2) {
        m9974c();
        this.f10064b.m9822a(str2, new C2779cb(this));
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2806v
    /* renamed from: a */
    public void mo9712a(Editable editable) {
        if (editable != null) {
            m9973b(this.f10065c.m10025a(editable.toString()));
        }
    }
}
