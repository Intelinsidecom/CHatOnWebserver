package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityManageAccounts;
import com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment;

/* loaded from: classes.dex */
public class FacebookSubMenuFragment extends SnsSubMenuFragment {

    /* renamed from: g */
    private static final String f10047g = FacebookSubMenuFragment.class.getSimpleName();

    /* renamed from: h */
    private View f10048h;

    /* renamed from: i */
    private Activity f10049i;

    /* renamed from: j */
    private C2733aj f10050j;

    /* renamed from: k */
    private InterfaceC2731ah f10051k = new C2810d(this);

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f10050j = new C2733aj(activity);
        super.onAttach(activity);
        this.f10049i = activity;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10049i = null;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10048h = super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f10048h;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m9992i();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f10050j.mo9767a();
        m9990g();
        super.onDestroy();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment
    /* renamed from: a */
    public void mo9717a() {
        if (this.f10050j.mo9774d()) {
            m9986a(this.f10050j.m9798e());
            m9720c();
        } else {
            m9991h();
            if (this.f10249a != null) {
                this.f10249a.setVisibility(0);
            }
            this.f10050j.mo9771a(new C2777c(this));
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment
    /* renamed from: b */
    public void mo9719b() {
        m9988e().setText(R.string.tellfriends_facebook_submenu_list_invitation_card);
    }

    /* renamed from: c */
    public void m9720c() {
        if (this.f10249a != null) {
            this.f10249a.setVisibility(0);
        }
        this.f10050j.mo9770a(this.f10254f);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2791g
    /* renamed from: a */
    public void mo9718a(C2732ai c2732ai) {
        this.f10050j.m9796a(c2732ai.m9783a(), this.f10051k);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sns_account_layout /* 2131165844 */:
                Intent intent = new Intent(this.f10049i, (Class<?>) FacebookMessageActivity.class);
                intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", "");
                startActivity(intent);
                break;
            case R.id.sns_invitation_layout /* 2131166282 */:
                startActivity(new Intent(this.f10049i, (Class<?>) ActivityManageAccounts.class));
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3001) {
            if (!this.f10050j.mo9774d()) {
                this.f10049i.finish();
                return;
            }
            return;
        }
        this.f10050j.mo9768a(i, i2, intent);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
    }
}
