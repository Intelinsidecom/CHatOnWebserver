package com.sec.chaton.buddy;

import android.content.res.Configuration;
import android.os.Bundle;
import android.sec.multiwindow.MultiWindow;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3241p;
import com.sec.common.actionbar.AbstractC3284a;

/* loaded from: classes.dex */
public class AddBuddyActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    AddBuddyFragment f1649a;

    /* renamed from: b */
    MultiWindow f1650b;

    /* renamed from: c */
    private Menu f1651c = null;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        if ("com.sec.chaton.action.ADD_BUDDY".equals(getIntent().getAction())) {
            C3241p.m11403b(true);
        }
        this.f1649a = new AddBuddyFragment();
        this.f1650b = null;
        if (GlobalApplication.m6457f()) {
            this.f1650b = MultiWindow.createInstance(this);
        }
        return this.f1649a;
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        super.onSupportPrepareOptionsMenu(menu);
        if (GlobalApplication.m6456e()) {
            getMenuInflater().inflate(R.menu.actionbar_addbuddy_cancel, menu);
            menu.findItem(R.id.actionbar_addbuddy_cancel).setVisible(true).setEnabled(true);
            this.f1651c = menu;
        }
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.actionbar_addbuddy_cancel /* 2131166530 */:
                if (this.f1649a != null) {
                    this.f1649a.getActivity().finish();
                    break;
                }
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f1649a != null && !z && GlobalApplication.m6456e() && GlobalApplication.m6457f()) {
            this.f1649a.m3197a();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (GlobalApplication.m6456e()) {
            AbstractC3284a abstractC3284aK = m11543k();
            if (abstractC3284aK != null) {
                abstractC3284aK.mo11584a(true);
                abstractC3284aK.mo11593d(true);
                abstractC3284aK.mo11580a((TextView) getLayoutInflater().inflate(R.layout.custom_navigation_layout_actionbar, (ViewGroup) null));
                ((TextView) abstractC3284aK.mo11598g()).setText(R.string.buddy_list_dialog_addbuddy_title);
                abstractC3284aK.mo11583a(getResources().getString(R.string.buddy_list_dialog_addbuddy_title));
            }
            if (GlobalApplication.m6456e()) {
                m3080a(this);
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            m3080a(this);
        }
    }
}
