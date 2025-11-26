package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2805u;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2806v;
import com.sec.chaton.settings.tellfriends.common.SnsMessageFragment;

/* loaded from: classes.dex */
public class FacebookMessageFragment extends SnsMessageFragment implements InterfaceC2805u, InterfaceC2806v {

    /* renamed from: b */
    private C2733aj f10046b;

    protected FacebookMessageFragment() {
        m9968a(Integer.parseInt("140"));
        m9970a((InterfaceC2806v) this);
        m9969a((InterfaceC2805u) this);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsMessageFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10046b = new C2733aj(this.f10235a);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsMessageFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsMessageFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f10046b.mo9767a();
        super.onDestroy();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsMessageFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2805u
    /* renamed from: a */
    public void mo9713a(String str, String str2) {
        m9974c();
        this.f10046b.m9797a((String) null, new C2750b(this), str2);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2806v
    /* renamed from: a */
    public void mo9712a(Editable editable) {
        if (editable == null) {
            m9973b(m9967a().length());
        }
    }
}
