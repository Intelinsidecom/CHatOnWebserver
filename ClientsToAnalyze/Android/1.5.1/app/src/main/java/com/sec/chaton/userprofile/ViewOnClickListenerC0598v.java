package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.io.File;

/* renamed from: com.sec.chaton.userprofile.v */
/* loaded from: classes.dex */
class ViewOnClickListenerC0598v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileFragment f3599a;

    ViewOnClickListenerC0598v(UserProfileFragment userProfileFragment) {
        this.f3599a = userProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File file = new File(this.f3599a.f3486l, "myprofile.png_");
        ChatONLogWriter.m3506b("photoFile=" + file, getClass().getSimpleName());
        if (ChatONPref.m3519a().getString("profile_image_status", "").equals("deleted") || !file.exists()) {
            this.f3599a.m3433d();
            return;
        }
        this.f3599a.f3449P = true;
        this.f3599a.f3439F.setSelected(true);
        this.f3599a.startActivity(new Intent(this.f3599a.getActivity(), (Class<?>) UserProfileImageView.class));
    }
}
