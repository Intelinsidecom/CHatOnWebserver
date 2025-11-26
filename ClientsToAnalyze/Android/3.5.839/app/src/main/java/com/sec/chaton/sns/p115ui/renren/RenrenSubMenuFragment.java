package com.sec.chaton.sns.p115ui.renren;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityManageAccounts;
import com.sec.chaton.sns.p114b.C4379ae;
import com.sec.chaton.sns.p114b.C4384aj;
import com.sec.chaton.sns.p114b.InterfaceC4378ad;
import com.sec.chaton.sns.p115ui.SnsSubMenuFragment;

/* loaded from: classes.dex */
public class RenrenSubMenuFragment extends SnsSubMenuFragment {

    /* renamed from: g */
    private static final String f16235g = RenrenSubMenuFragment.class.getSimpleName();

    /* renamed from: h */
    private Activity f16236h;

    /* renamed from: i */
    private View f16237i;

    /* renamed from: j */
    private C4384aj f16238j;

    /* renamed from: k */
    private InterfaceC4378ad f16239k = new C4509d(this);

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16237i = super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f16237i;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f16238j = new C4384aj(activity);
        super.onAttach(activity);
        this.f16236h = activity;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16236h = null;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m16920g();
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f16238j.mo16639a();
        m16918e();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3001 && !this.f16238j.mo16650e()) {
            this.f16236h.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sns_account_layout /* 2131166261 */:
                startActivity(new Intent(this.f16236h, (Class<?>) ActivityManageAccounts.class));
                break;
            case R.id.sns_invitation_layout /* 2131166262 */:
                Intent intent = new Intent(this.f16236h, (Class<?>) RenrenMessageActivity.class);
                intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", "");
                startActivity(intent);
                break;
        }
    }

    @Override // com.sec.chaton.sns.p115ui.InterfaceC4511t
    /* renamed from: a */
    public void mo16888a(C4379ae c4379ae) {
        if (this.f16238j != null) {
            this.f16238j.m16665a(c4379ae.m16625a(), this.f16239k, (String) null);
        }
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment
    /* renamed from: a */
    public void mo16912a() {
        m16916c().setText(R.string.tellfriends_weibo_submenu_list_message_to_mine);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment
    /* renamed from: b */
    public void mo16915b() {
        if (this.f16238j.mo16650e()) {
            m16913a(this.f16238j.mo16647b());
            m17068j();
        } else {
            m16919f();
            if (this.f16051a != null) {
                this.f16051a.setVisibility(0);
            }
            this.f16238j.mo16641a(new C4507b(this));
        }
    }

    /* renamed from: j */
    public void m17068j() {
        if (this.f16051a != null) {
            this.f16051a.setVisibility(0);
        }
        this.f16238j.mo16644a(this.f16056f);
    }
}
