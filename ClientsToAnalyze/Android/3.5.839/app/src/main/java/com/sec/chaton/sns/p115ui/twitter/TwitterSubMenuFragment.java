package com.sec.chaton.sns.p115ui.twitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityManageAccounts;
import com.sec.chaton.sns.p114b.C4379ae;
import com.sec.chaton.sns.p114b.C4386al;
import com.sec.chaton.sns.p115ui.SnsSubMenuFragment;

/* loaded from: classes.dex */
public class TwitterSubMenuFragment extends SnsSubMenuFragment {

    /* renamed from: g */
    private static final String f16248g = TwitterSubMenuFragment.class.getSimpleName();

    /* renamed from: h */
    private Activity f16249h;

    /* renamed from: i */
    private View f16250i;

    /* renamed from: j */
    private C4386al f16251j;

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f16251j = new C4386al(activity);
        super.onAttach(activity);
        this.f16249h = activity;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16249h = null;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16250i = super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f16250i;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m16920g();
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f16251j.mo16639a();
        m16918e();
        super.onDestroy();
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment
    /* renamed from: b */
    public void mo16915b() {
        if (this.f16251j.mo16650e()) {
            m16913a(this.f16251j.mo16647b());
            m17080j();
        } else {
            m16919f();
            if (this.f16051a != null) {
                this.f16051a.setVisibility(0);
            }
            this.f16251j.mo16641a(new C4513b(this));
        }
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment
    /* renamed from: a */
    public void mo16912a() {
        m16916c().setText(R.string.tellfriends_twitter_submenu_list_message_to_mine);
    }

    /* renamed from: j */
    public void m17080j() {
        if (this.f16051a != null) {
            this.f16051a.setVisibility(0);
        }
        m16914a(true);
        this.f16251j.mo16644a(this.f16056f);
    }

    @Override // com.sec.chaton.sns.p115ui.InterfaceC4511t
    /* renamed from: a */
    public void mo16888a(C4379ae c4379ae) {
        Intent intent = new Intent(this.f16249h, (Class<?>) TwitterMessageActivity.class);
        intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", c4379ae.m16627b());
        startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sns_account_layout /* 2131166261 */:
                Intent intent = new Intent(this.f16249h, (Class<?>) ActivityManageAccounts.class);
                intent.putExtra("INTENT_FROM", "TWITTER_SUB_MENU");
                startActivity(intent);
                break;
            case R.id.sns_invitation_layout /* 2131166262 */:
                Intent intent2 = new Intent(this.f16249h, (Class<?>) TwitterMessageActivity.class);
                intent2.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", "");
                startActivity(intent2);
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3001 && !this.f16251j.mo16650e()) {
            this.f16249h.finish();
        }
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= i3 - i2 && i3 != 0 && !m16917d() && this.f16251j.m16674f()) {
            m16914a(true);
            m17080j();
        }
    }
}
