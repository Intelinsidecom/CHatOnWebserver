package com.sec.chaton.chat;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ChatActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    private OnBackKeyListener f721a;

    public interface OnBackKeyListener {
        /* renamed from: d */
        boolean mo526d();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f721a == null || this.f721a.mo526d()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    protected Fragment onCreatePane() {
        ChatFragment chatFragment = new ChatFragment();
        this.f721a = chatFragment;
        return chatFragment;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ChatONLogWriter.m3508c("[LIFE] onNewIntent, Task ID: " + getTaskId(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        ChatONLogWriter.m3508c("[LIFE] onPause, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onPause();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        ChatONLogWriter.m3508c("[LIFE] onResume, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        ChatONLogWriter.m3508c("[LIFE] onStart, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        ChatONLogWriter.m3508c("[LIFE] onStop, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStop();
    }
}
