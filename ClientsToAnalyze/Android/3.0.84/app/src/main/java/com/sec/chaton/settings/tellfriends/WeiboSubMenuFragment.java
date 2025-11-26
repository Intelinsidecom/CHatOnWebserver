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
public class WeiboSubMenuFragment extends SnsSubMenuFragment {

    /* renamed from: g */
    private static final String f10066g = WeiboSubMenuFragment.class.getSimpleName();

    /* renamed from: h */
    private View f10067h;

    /* renamed from: i */
    private Activity f10068i;

    /* renamed from: j */
    private C2739ap f10069j;

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f10069j = new C2739ap(activity);
        super.onAttach(activity);
        this.f10068i = activity;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10067h = super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f10067h;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10068i = null;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m9992i();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f10069j.mo9767a();
        m9990g();
        super.onDestroy();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment
    /* renamed from: a */
    public void mo9717a() {
        if (this.f10069j.mo9774d()) {
            m9986a(this.f10069j.mo9772b());
            m9756c();
        } else {
            m9991h();
            if (this.f10249a != null) {
                this.f10249a.setVisibility(0);
            }
            this.f10069j.mo9771a(new C2781cd(this));
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment
    /* renamed from: b */
    public void mo9719b() {
        m9988e().setText(R.string.tellfriends_weibo_submenu_list_message_to_mine);
    }

    /* renamed from: c */
    public void m9756c() {
        if (this.f10249a != null) {
            this.f10249a.setVisibility(0);
        }
        this.f10069j.mo9770a(this.f10254f);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2791g
    /* renamed from: a */
    public void mo9718a(C2732ai c2732ai) {
        Intent intent = new Intent(this.f10068i, (Class<?>) WeiboMessageActivity.class);
        intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", c2732ai.m9785b());
        startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sns_account_layout /* 2131165844 */:
                startActivity(new Intent(this.f10068i, (Class<?>) ActivityManageAccounts.class));
                break;
            case R.id.sns_invitation_layout /* 2131166282 */:
                Intent intent = new Intent(this.f10068i, (Class<?>) WeiboMessageActivity.class);
                intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", "");
                startActivity(intent);
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3001 && !this.f10069j.mo9774d()) {
            this.f10068i.finish();
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
