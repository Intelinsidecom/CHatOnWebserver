package com.sec.chaton.chat;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.trunk.TrunkView;
import com.sec.chaton.util.C3197bl;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC1133q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4549a;

    ViewOnClickListenerC1133q(ChatFragment chatFragment) {
        this.f4549a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            this.f4549a.f3587bJ = null;
            this.f4549a.f3642cL = null;
            this.f4549a.m4918j(this.f4549a.f3710y);
            Intent intent = new Intent();
            intent.putExtra("sessionId", this.f4549a.f3710y);
            intent.putExtra("inboxNO", this.f4549a.f3703r);
            intent.putExtra("mTitle", this.f4549a.f3639cI.getText());
            intent.putExtra("mSubtitle", this.f4549a.f3640cJ.getText());
            intent.putExtra("imageProfile", ((BitmapDrawable) this.f4549a.f3630c.getDrawable()).getBitmap());
            intent.putExtra("isValid", this.f4549a.f3609bf);
            ((TabActivity) this.f4549a.getActivity()).m1312a(R.id.fragment_msg_box, intent, TrunkView.class);
        }
    }
}
