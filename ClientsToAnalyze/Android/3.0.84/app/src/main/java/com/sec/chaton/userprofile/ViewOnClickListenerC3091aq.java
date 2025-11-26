package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.poston.PostONWriteActivity;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.aq */
/* loaded from: classes.dex */
class ViewOnClickListenerC3091aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11303a;

    ViewOnClickListenerC3091aq(MyPageFragment myPageFragment) {
        this.f11303a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f11303a.getActivity(), (Class<?>) PostONWriteActivity.class);
        intent.putExtra("WRITE_FROM", "MY_PAGE");
        this.f11303a.startActivityForResult(intent, 7);
    }
}
