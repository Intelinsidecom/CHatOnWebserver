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
public class TwitterSubMenuFragment extends SnsSubMenuFragment {

    /* renamed from: g */
    private static final String f10060g = TwitterSubMenuFragment.class.getSimpleName();

    /* renamed from: h */
    private Activity f10061h;

    /* renamed from: i */
    private View f10062i;

    /* renamed from: j */
    private C2737an f10063j;

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f10063j = new C2737an(activity);
        super.onAttach(activity);
        this.f10061h = activity;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10061h = null;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10062i = super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f10062i;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m9992i();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f10063j.mo9767a();
        m9990g();
        super.onDestroy();
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment
    /* renamed from: a */
    public void mo9717a() {
        if (this.f10063j.mo9774d()) {
            m9986a(this.f10063j.mo9772b());
            m9744c();
        } else {
            m9991h();
            if (this.f10249a != null) {
                this.f10249a.setVisibility(0);
            }
            this.f10063j.mo9771a(new C2761bk(this));
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment
    /* renamed from: b */
    public void mo9719b() {
        m9988e().setText(R.string.tellfriends_twitter_submenu_list_message_to_mine);
    }

    /* renamed from: c */
    public void m9744c() {
        if (this.f10249a != null) {
            this.f10249a.setVisibility(0);
        }
        m9987a(true);
        this.f10063j.mo9770a(this.f10254f);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2791g
    /* renamed from: a */
    public void mo9718a(C2732ai c2732ai) {
        Intent intent = new Intent(this.f10061h, (Class<?>) TwitterMessageActivity.class);
        intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", c2732ai.m9785b());
        startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sns_account_layout /* 2131165844 */:
                Intent intent = new Intent(this.f10061h, (Class<?>) ActivityManageAccounts.class);
                intent.putExtra("INTENT_FROM", "TWITTER_SUB_MENU");
                startActivity(intent);
                break;
            case R.id.sns_invitation_layout /* 2131166282 */:
                Intent intent2 = new Intent(this.f10061h, (Class<?>) TwitterMessageActivity.class);
                intent2.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", "");
                startActivity(intent2);
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3001 && !this.f10063j.mo9774d()) {
            this.f10061h.finish();
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.SnsSubMenuFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !m9989f() && this.f10063j.m9814e()) {
            m9987a(true);
            m9744c();
        }
    }
}
