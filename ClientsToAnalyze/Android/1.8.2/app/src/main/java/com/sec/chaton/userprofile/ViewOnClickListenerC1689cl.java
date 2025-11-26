package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.File;
import java.io.IOException;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.cl */
/* loaded from: classes.dex */
class ViewOnClickListenerC1689cl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6186a;

    ViewOnClickListenerC1689cl(UserProfileDetail userProfileDetail) {
        this.f6186a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        File file = new File(this.f6186a.f6074u, "myprofile.png_");
        C1786r.m6061b("photoFile=" + file, getClass().getSimpleName());
        if (C1789u.m6075a().getString("profile_image_status", "").equals("deleted") || !file.exists()) {
            this.f6186a.m5761q();
        } else {
            this.f6186a.startActivity(new Intent(this.f6186a.f6028K, (Class<?>) UserProfileImageView.class));
            this.f6186a.f6029L = true;
        }
        this.f6186a.invalidateOptionsMenu();
    }
}
