package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p017a.C0365c;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0638a;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.GeneralHeaderView;
import java.util.HashSet;

/* loaded from: classes.dex */
public class BuddyGroupMemberEditActivity extends BaseActivity implements InterfaceC0387av {

    /* renamed from: a */
    public static final String f1169a = BuddyGroupMemberEditActivity.class.getSimpleName();

    /* renamed from: c */
    private GeneralHeaderView f1171c;

    /* renamed from: d */
    private C0365c f1172d;

    /* renamed from: e */
    private int f1173e;

    /* renamed from: g */
    private ProgressDialog f1175g;

    /* renamed from: f */
    private View.OnClickListener f1174f = new ViewOnClickListenerC0384as(this);

    /* renamed from: b */
    InterfaceC0641d f1170b = new C0383ar(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1173e = getIntent().getIntExtra("ACTIVITY_PURPOSE", 1);
        C1341p.m4658b("onCreate() mPurpose=" + this.f1173e, f1169a);
        setContentView(R.layout.buddy_list_layout);
        if (bundle == null) {
            BuddyFragment buddyFragment = new BuddyFragment();
            buddyFragment.setArguments(m2042b(getIntent()));
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_controller, buddyFragment, "com.sec.chaton:single_pane_fragment").commit();
        }
        this.f1171c = (GeneralHeaderView) findViewById(R.id.headerView);
        this.f1172d = (C0365c) getIntent().getExtras().get("groupInfo");
        this.f1171c.setButtonClickListener(this.f1174f);
        m2213b();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1341p.m4658b("onDestroy()", f1169a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public BuddyFragment m2209a() {
        return (BuddyFragment) getSupportFragmentManager().findFragmentByTag("com.sec.chaton:single_pane_fragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2211a(HashSet hashSet) {
        if (hashSet.size() > 0) {
            m2214c();
            C0627g.m2858a(new C0627g(), 0, new C0638a(this.f1170b, this.f1172d.m2347a(), hashSet, true));
        }
    }

    /* renamed from: b */
    private void m2213b() {
        m2217d(-1);
    }

    /* renamed from: d */
    private void m2217d(int i) {
        C1341p.m4658b("setTitleView() : " + i, f1169a);
        String strM2349b = null;
        if (this.f1173e == 19) {
            strM2349b = this.f1172d.m2349b();
            i = -1;
        }
        if (strM2349b != null) {
            if (i >= 0) {
                strM2349b = strM2349b + " (" + i + ")";
            }
            this.f1171c.setText(strM2349b);
        }
    }

    /* renamed from: c */
    public void m2220c(int i) {
        if (i > 0) {
            this.f1171c.setButtonEnabled(true);
        } else {
            this.f1171c.setButtonEnabled(false);
        }
    }

    @Override // com.sec.chaton.buddy.InterfaceC0387av
    /* renamed from: a */
    public void mo2218a(int i) {
        m2217d(i);
        m2220c(i);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0387av
    /* renamed from: b */
    public void mo2219b(int i) {
    }

    /* renamed from: c */
    private void m2214c() {
        if (this.f1175g == null) {
            this.f1175g = ProgressDialogC1354a.m4724a(this, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f1175g.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m2216d() {
        if (this.f1175g != null) {
            this.f1175g.dismiss();
        }
    }
}
