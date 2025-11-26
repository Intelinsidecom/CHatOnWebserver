package com.sec.chaton.chat;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class ChatActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    private InterfaceC0454a f1741a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        ChatFragment chatFragment = new ChatFragment();
        this.f1741a = chatFragment;
        return chatFragment;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f1741a == null || this.f1741a.isBackKeyIgnore()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C1786r.m6063c("[LIFE] onNewIntent, Task ID: " + getTaskId(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        C1786r.m6063c("[LIFE] onStart, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        C1786r.m6063c("[LIFE] onStop, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStop();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        C1786r.m6063c("[LIFE] onResume, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        C1786r.m6063c("[LIFE] onPause, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onPause();
    }
}
