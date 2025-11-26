package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.poston.PostONWriteActivity;
import com.sec.chaton.util.C4847bl;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ar */
/* loaded from: classes.dex */
class ViewOnClickListenerC4732ar implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17396a;

    ViewOnClickListenerC4732ar(MyPageFragment myPageFragment) {
        this.f17396a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            Intent intent = new Intent(this.f17396a.getActivity(), (Class<?>) PostONWriteActivity.class);
            intent.putExtra("WRITE_FROM", "MY_PAGE");
            this.f17396a.startActivityForResult(intent, 2);
        }
    }
}
