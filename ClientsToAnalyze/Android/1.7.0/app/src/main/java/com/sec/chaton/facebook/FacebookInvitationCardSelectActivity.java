package com.sec.chaton.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class FacebookInvitationCardSelectActivity extends BaseActivity {

    /* renamed from: a */
    public static final Integer[] f2345a = {Integer.valueOf(R.drawable.invitation_card_01), Integer.valueOf(R.drawable.invitation_card_02), Integer.valueOf(R.drawable.invitation_card_03)};

    /* renamed from: b */
    private GeneralHeaderView f2346b;

    /* renamed from: c */
    private ListView f2347c;

    /* renamed from: d */
    private View.OnClickListener f2348d = new ViewOnClickListenerC0703r(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_invitation_card_select);
        this.f2346b = (GeneralHeaderView) findViewById(R.id.headerView);
        this.f2346b.setButtonClickListener(this.f2348d);
        this.f2347c = (ListView) findViewById(android.R.id.list);
        this.f2347c.setChoiceMode(1);
        this.f2347c.setAdapter((ListAdapter) new C0689d(this, R.layout.layout_facebook_invitation_card_list_item, android.R.id.text1, f2345a));
        this.f2347c.setItemChecked(0, true);
    }
}
