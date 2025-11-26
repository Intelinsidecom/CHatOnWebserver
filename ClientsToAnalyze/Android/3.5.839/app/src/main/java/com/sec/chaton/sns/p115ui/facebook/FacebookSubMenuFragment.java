package com.sec.chaton.sns.p115ui.facebook;

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
import com.sec.chaton.sns.p114b.C4380af;
import com.sec.chaton.sns.p114b.InterfaceC4378ad;
import com.sec.chaton.sns.p115ui.SnsSubMenuFragment;

/* loaded from: classes.dex */
public class FacebookSubMenuFragment extends SnsSubMenuFragment {

    /* renamed from: g */
    private static final String f16169g = FacebookSubMenuFragment.class.getSimpleName();

    /* renamed from: h */
    private View f16170h;

    /* renamed from: i */
    private Activity f16171i;

    /* renamed from: j */
    private C4380af f16172j;

    /* renamed from: k */
    private InterfaceC4378ad f16173k = new C4484c(this);

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f16172j = new C4380af(activity);
        super.onAttach(activity);
        this.f16171i = activity;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16171i = null;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16170h = super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f16170h;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m16920g();
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f16172j.mo16639a();
        m16918e();
        super.onDestroy();
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment
    /* renamed from: b */
    public void mo16915b() {
        if (this.f16172j.mo16650e()) {
            m16913a(this.f16172j.m16651f());
            m16994j();
        } else {
            m16919f();
            if (this.f16051a != null) {
                this.f16051a.setVisibility(0);
            }
            this.f16172j.mo16641a(new C4483b(this));
        }
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment
    /* renamed from: a */
    public void mo16912a() {
        m16916c().setText(R.string.tellfriends_facebook_submenu_list_invitation_card);
    }

    /* renamed from: j */
    public void m16994j() {
        if (this.f16051a != null) {
            this.f16051a.setVisibility(0);
        }
        this.f16172j.mo16644a(this.f16056f);
    }

    @Override // com.sec.chaton.sns.p115ui.InterfaceC4511t
    /* renamed from: a */
    public void mo16888a(C4379ae c4379ae) {
        this.f16172j.m16645a(c4379ae.m16625a(), this.f16173k);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sns_account_layout /* 2131166261 */:
                Intent intent = new Intent(this.f16171i, (Class<?>) FacebookMessageActivity.class);
                intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", "");
                startActivity(intent);
                break;
            case R.id.sns_invitation_layout /* 2131166262 */:
                startActivity(new Intent(this.f16171i, (Class<?>) ActivityManageAccounts.class));
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3001) {
            if (!this.f16172j.mo16650e()) {
                this.f16171i.finish();
                return;
            }
            return;
        }
        this.f16172j.mo16640a(i, i2, intent);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
    }
}
