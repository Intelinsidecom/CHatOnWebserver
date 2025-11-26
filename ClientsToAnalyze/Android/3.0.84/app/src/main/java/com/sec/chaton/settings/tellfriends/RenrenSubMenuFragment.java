package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityManageAccounts;
import com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment;

/* loaded from: classes.dex */
public class RenrenSubMenuFragment extends SnsSubMenuFragment {

    /* renamed from: g */
    private static final String f10054g = RenrenSubMenuFragment.class.getSimpleName();

    /* renamed from: h */
    private Activity f10055h;

    /* renamed from: i */
    private View f10056i;

    /* renamed from: j */
    private C2735al f10057j;

    /* renamed from: k */
    private InterfaceC2731ah f10058k = new C2830x(this);

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10056i = super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f10056i;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f10057j = new C2735al(activity);
        super.onAttach(activity);
        this.f10055h = activity;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10055h = null;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m9992i();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f10057j.mo9767a();
        m9990g();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3001 && !this.f10057j.mo9774d()) {
            this.f10055h.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sns_account_layout /* 2131165844 */:
                startActivity(new Intent(this.f10055h, (Class<?>) ActivityManageAccounts.class));
                break;
            case R.id.sns_invitation_layout /* 2131166282 */:
                Intent intent = new Intent(this.f10055h, (Class<?>) RenrenMessageActivity.class);
                intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", "");
                startActivity(intent);
                break;
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2791g
    /* renamed from: a */
    public void mo9718a(C2732ai c2732ai) {
        if (this.f10057j != null) {
            this.f10057j.m9805a(c2732ai.m9783a(), this.f10058k, (String) null);
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment
    /* renamed from: b */
    public void mo9719b() {
        m9988e().setText(R.string.tellfriends_weibo_submenu_list_message_to_mine);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment
    /* renamed from: a */
    public void mo9717a() {
        if (this.f10057j.mo9774d()) {
            m9986a(this.f10057j.mo9772b());
            m9732c();
        } else {
            m9991h();
            if (this.f10249a != null) {
                this.f10249a.setVisibility(0);
            }
            this.f10057j.mo9771a(new C2828v(this));
        }
    }

    /* renamed from: c */
    public void m9732c() {
        if (this.f10249a != null) {
            this.f10249a.setVisibility(0);
        }
        this.f10057j.mo9770a(this.f10254f);
    }
}
