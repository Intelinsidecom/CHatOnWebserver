package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.io.File;
import java.io.IOException;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC1254d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4351a;

    ViewOnClickListenerC1254d(MyPageFragment myPageFragment) {
        this.f4351a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        File file = new File(this.f4351a.f4151m, "myprofile.png_");
        C1341p.m4658b("photoFile=" + file, getClass().getSimpleName());
        if (!C1323bs.m4575a().getString("profile_image_status", "").equals("deleted") && file.exists()) {
            this.f4351a.f4113K = true;
            this.f4351a.startActivity(new Intent(this.f4351a.getActivity(), (Class<?>) UserProfileImageView.class));
            return;
        }
        this.f4351a.m4332c();
    }
}
