package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.File;
import java.io.IOException;

/* compiled from: MyPageFragmentTablet.java */
/* renamed from: com.sec.chaton.userprofile.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC1624aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragmentTablet f6110a;

    ViewOnClickListenerC1624aa(MyPageFragmentTablet myPageFragmentTablet) {
        this.f6110a = myPageFragmentTablet;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        File file = new File(this.f6110a.f5890m, "myprofile.png_");
        C1786r.m6061b("photoFile=" + file, getClass().getSimpleName());
        if (!C1789u.m6075a().getString("profile_image_status", "").equals("deleted") && file.exists()) {
            this.f6110a.f5863B = true;
            this.f6110a.startActivity(new Intent(this.f6110a.getActivity(), (Class<?>) UserProfileImageView.class));
            return;
        }
        this.f6110a.m5640c();
    }
}
