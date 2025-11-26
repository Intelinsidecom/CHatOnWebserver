package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.io.File;

/* renamed from: com.sec.chaton.userprofile.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC0551ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f3530a;

    ViewOnClickListenerC0551ae(UserProfileDetail userProfileDetail) {
        this.f3530a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3530a.f3402T = true;
        File file = new File(this.f3530a.f3421o, "myprofile.png_");
        ChatONLogWriter.m3506b("photoFile=" + file, getClass().getSimpleName());
        if (ChatONPref.m3519a().getString("profile_image_status", "").equals("deleted") || !file.exists()) {
            this.f3530a.m3373j();
            return;
        }
        this.f3530a.f3397O = true;
        this.f3530a.startActivity(new Intent(this.f3530a.f3412f, (Class<?>) UserProfileImageView.class));
    }
}
