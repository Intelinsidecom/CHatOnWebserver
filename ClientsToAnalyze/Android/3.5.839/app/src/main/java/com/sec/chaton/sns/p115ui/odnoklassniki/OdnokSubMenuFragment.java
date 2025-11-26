package com.sec.chaton.sns.p115ui.odnoklassniki;

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
import com.sec.chaton.sns.p114b.C4382ah;
import com.sec.chaton.sns.p115ui.SnsSubMenuFragment;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class OdnokSubMenuFragment extends SnsSubMenuFragment {

    /* renamed from: g */
    private static final String f16202g = OdnokSubMenuFragment.class.getSimpleName();

    /* renamed from: h */
    private View f16203h;

    /* renamed from: i */
    private Activity f16204i;

    /* renamed from: j */
    private C4382ah f16205j;

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f16205j = new C4382ah(activity);
        super.onAttach(activity);
        this.f16204i = activity;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16203h = super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f16203h;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16204i = null;
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m16920g();
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f16205j.mo16639a();
        m16918e();
        super.onDestroy();
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment
    /* renamed from: b */
    public void mo16915b() throws NoSuchAlgorithmException {
        if (this.f16205j.mo16650e()) {
            m16913a(this.f16205j.mo16647b());
            m17020j();
        } else {
            m16919f();
            if (this.f16051a != null) {
                this.f16051a.setVisibility(0);
            }
            this.f16205j.mo16641a(new C4502b(this));
        }
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment
    /* renamed from: a */
    public void mo16912a() {
        m16916c().setText(R.string.tellfriends_weibo_submenu_list_message_to_mine);
    }

    /* renamed from: j */
    public void m17020j() throws NoSuchAlgorithmException {
        if (this.f16051a != null) {
            this.f16051a.setVisibility(0);
        }
        this.f16205j.mo16644a(this.f16056f);
    }

    @Override // com.sec.chaton.sns.p115ui.InterfaceC4511t
    /* renamed from: a */
    public void mo16888a(C4379ae c4379ae) {
        Intent intent = new Intent(this.f16204i, (Class<?>) OdnokMessageActivity.class);
        intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", c4379ae.m16627b());
        startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sns_account_layout /* 2131166261 */:
                startActivity(new Intent(this.f16204i, (Class<?>) ActivityManageAccounts.class));
                break;
            case R.id.sns_invitation_layout /* 2131166262 */:
                Intent intent = new Intent(this.f16204i, (Class<?>) OdnokMessageActivity.class);
                intent.putExtra("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", "");
                startActivity(intent);
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3001 && !this.f16205j.mo16650e()) {
            this.f16204i.finish();
        }
    }

    @Override // com.sec.chaton.sns.p115ui.SnsSubMenuFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
