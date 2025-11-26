package com.sec.chaton.facebook;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class FacebookInvitationCardSelectActivity extends BaseActivity {

    /* renamed from: a */
    public static final Integer[] f2686a = {Integer.valueOf(R.drawable.facebook_invitation_card_snackcar), Integer.valueOf(R.drawable.facebook_invitation_card_town), Integer.valueOf(R.drawable.facebook_invitation_card_snackcar_s)};

    /* renamed from: b */
    private ListView f2687b;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_invitation_card_select);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(798, 738);
        }
        this.f2687b = (ListView) findViewById(android.R.id.list);
        this.f2687b.setChoiceMode(1);
        this.f2687b.setAdapter((ListAdapter) new C0720a(this, R.layout.layout_facebook_invitation_card_list_item, android.R.id.text1, f2686a));
        this.f2687b.setItemChecked(0, true);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
        menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
        menu.removeItem(R.id.actionbar_title_next);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.actionbar_title_cancel /* 2131494128 */:
                finish();
                break;
            case R.id.actionbar_title_done /* 2131494130 */:
                C1786r.m6063c("Invitation Card " + this.f2687b.getCheckedItemPosition(), getClass().getSimpleName());
                Intent intent = new Intent(this, (Class<?>) FacebookInvitationCardWriteActivity.class);
                intent.putExtra("invitationCardResId", f2686a[this.f2687b.getCheckedItemPosition()]);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
