package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.io.File;
import java.io.IOException;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC1208ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4285a;

    ViewOnClickListenerC1208ae(UserProfileDetail userProfileDetail) {
        this.f4285a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        File file = new File(this.f4285a.f4241j, "myprofile.png_");
        C1341p.m4658b("photoFile=" + file, getClass().getSimpleName());
        if (C1323bs.m4575a().getString("profile_image_status", "").equals("deleted") || !file.exists()) {
            this.f4285a.m4390g();
        } else {
            this.f4285a.startActivity(new Intent(this.f4285a.f4223E, (Class<?>) UserProfileImageView.class));
        }
    }
}
