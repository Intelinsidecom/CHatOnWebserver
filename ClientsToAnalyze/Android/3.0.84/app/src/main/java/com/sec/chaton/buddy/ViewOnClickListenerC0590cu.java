package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.userprofile.MyPageFragment;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cu */
/* loaded from: classes.dex */
class ViewOnClickListenerC0590cu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2553a;

    ViewOnClickListenerC0590cu(BuddyFragment buddyFragment) {
        this.f2553a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent();
            intent.setAction(MyPageFragment.class.getName());
            intent.putExtra("ACTIVITY_PURPOSE_CALL_MYPAGE", 22);
            ((TabActivity) this.f2553a.getActivity()).m1312a(R.id.fragment_user_profile, intent, MyPageFragment.class);
            return;
        }
        Intent intent2 = new Intent(this.f2553a.getActivity(), (Class<?>) MeDialog.class);
        intent2.putExtra("ME_DIALOG_NAME", this.f2553a.f1782aT.getText());
        intent2.putExtra("ME_DIALOG_STATUSMSG", this.f2553a.f1783aU.getText());
        this.f2553a.getActivity().startActivity(intent2);
    }
}
