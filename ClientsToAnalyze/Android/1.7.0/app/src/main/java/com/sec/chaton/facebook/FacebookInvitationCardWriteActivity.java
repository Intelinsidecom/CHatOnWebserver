package com.sec.chaton.facebook;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class FacebookInvitationCardWriteActivity extends BaseActivity {

    /* renamed from: a */
    private GeneralHeaderView f2349a;

    /* renamed from: b */
    private EditText f2350b;

    /* renamed from: c */
    private C0700o f2351c;

    /* renamed from: d */
    private int f2352d;

    /* renamed from: e */
    private View.OnClickListener f2353e = new ViewOnClickListenerC0687b(this);

    /* renamed from: f */
    private InterfaceC0698m f2354f = new C0688c(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_invitation_card_write);
        this.f2352d = getIntent().getIntExtra("invitationCardResId", 0);
        this.f2349a = (GeneralHeaderView) findViewById(R.id.headerView);
        this.f2349a.setButtonClickListener(this.f2353e);
        this.f2350b = (EditText) findViewById(R.id.invitationMessage);
        if (this.f2351c == null) {
            this.f2351c = new C0700o(this, this.f2354f);
        }
        ((ImageView) findViewById(R.id.invitationCardImage)).setImageResource(this.f2352d);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialogC1354a progressDialogC1354a = new ProgressDialogC1354a(this, false);
                progressDialogC1354a.setMessage(getString(R.string.facebook_post_wait));
                progressDialogC1354a.setIndeterminate(true);
                return progressDialogC1354a;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3056a(int i) {
        C1619g.m5888a(this, i, 0).show();
    }
}
