package com.sec.chaton.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.base.InterfaceC0459d;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.specialbuddy.SpecialBuddyChatFragment;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChatActivity extends BaseSinglePaneActivity implements InterfaceC1027cw {

    /* renamed from: d */
    private static final String f3479d = ChatActivity.class.getSimpleName();

    /* renamed from: a */
    private ChatFragment f3480a;

    /* renamed from: b */
    private SpecialBuddyChatFragment f3481b;

    /* renamed from: c */
    private boolean f3482c = false;

    /* renamed from: e */
    private InterfaceC0459d f3483e;

    @Override // com.sec.chaton.chat.InterfaceC1027cw
    /* renamed from: c */
    public void mo4670c() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        Intent intent = getIntent();
        if (intent.hasExtra("disable")) {
            getWindow().addFlags(4194304);
            intent.removeExtra("disable");
        }
        this.f3482c = m4668c(intent);
        if (this.f3482c) {
            this.f3481b = new SpecialBuddyChatFragment();
            this.f3483e = this.f3481b;
            return this.f3481b;
        }
        this.f3480a = new ChatFragment();
        this.f3483e = this.f3480a;
        return this.f3480a;
    }

    /* renamed from: c */
    private boolean m4668c(Intent intent) {
        if (intent == null) {
            return false;
        }
        boolean booleanExtra = intent.getBooleanExtra("specialbuddy", false);
        boolean booleanExtra2 = intent.getBooleanExtra("eventpage", false);
        boolean booleanExtra3 = intent.getBooleanExtra("liveprofile", false);
        if (booleanExtra) {
            C3250y.m11450b("checkSpecialBuddy(), spbd_intent, specialbuddy flag : true", f3479d);
            return true;
        }
        if (booleanExtra2) {
            C3250y.m11450b("checkSpecialBuddy(), spbd_intent, eventPage flag : true", f3479d);
            return true;
        }
        if (booleanExtra3) {
            C3250y.m11450b("checkSpecialBuddy(), spbd_intent, liveBuddyProfile flag : true", f3479d);
            return true;
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
        return stringArrayExtra != null && stringArrayExtra.length > 0 && stringArrayExtra[0].startsWith("0999");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        boolean zMo3094a = false;
        if (this.f3483e != null) {
            zMo3094a = this.f3483e.mo3094a();
        }
        if (!zMo3094a) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C3250y.m11453c("[LIFE] onNewIntent, Task ID: " + getTaskId(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        C3250y.m11453c("[LIFE] onStart, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStart();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        C3250y.m11453c("[LIFE] onStop, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStop();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        C3250y.m11453c("[LIFE] onResume, Task ID: " + getTaskId(), getClass().getSimpleName());
        m4669f();
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putBoolean("mIsSpecialBuddy", this.f3482c);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.f3482c = bundle.getBoolean("mIsSpecialBuddy");
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        super.onSupportCreateOptionsMenu(menu);
        if (!this.f3482c) {
            getMenuInflater().inflate(R.menu.activity_chat_menu, menu);
            return true;
        }
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        C3250y.m11453c("[LIFE] onPause, Task ID: " + getTaskId(), getClass().getSimpleName());
        getWindow().clearFlags(4194304);
        super.onPause();
    }

    /* renamed from: d */
    public ArrayList<String> m4671d() {
        if (this.f3480a != null) {
            return this.f3480a.m5024y();
        }
        return null;
    }

    /* renamed from: e */
    public void m4672e() {
        if (this.f3480a != null) {
            this.f3480a.m5021v();
        }
    }

    /* renamed from: f */
    private void m4669f() {
        C3250y.m11450b("showAgainPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            C3241p.m11403b(false);
            startActivity(intent);
        }
    }
}
