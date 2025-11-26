package com.sec.chaton.settings;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.base.InterfaceC0460e;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.downloads.InterfaceC2606cs;
import com.sec.chaton.settings.downloads.SkinListView;

/* loaded from: classes.dex */
public class ActivitySkinDownloads extends BaseSinglePaneActivity implements InterfaceC2606cs {

    /* renamed from: a */
    private InterfaceC0460e f9101a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        this.f9101a = new SkinListView();
        return (Fragment) this.f9101a;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f9101a == null || !this.f9101a.mo3095a(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2606cs
    /* renamed from: c */
    public void mo9073c() {
        Intent intent = new Intent(this, (Class<?>) ActivityBgBubbleChange.class);
        intent.putExtra("called_from_downloads", true);
        startActivity(intent);
    }
}
