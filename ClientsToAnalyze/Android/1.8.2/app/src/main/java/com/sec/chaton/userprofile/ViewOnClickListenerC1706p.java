package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.File;
import java.io.IOException;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.p */
/* loaded from: classes.dex */
class ViewOnClickListenerC1706p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6219a;

    ViewOnClickListenerC1706p(MyPageFragment myPageFragment) {
        this.f6219a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        File file = new File(this.f6219a.f5844k, "myprofile.png_");
        C1786r.m6061b("photoFile=" + file, getClass().getSimpleName());
        if (!C1789u.m6075a().getString("profile_image_status", "").equals("deleted") && file.exists()) {
            this.f6219a.f5815C = true;
            this.f6219a.startActivity(new Intent(this.f6219a.getActivity(), (Class<?>) UserProfileImageView.class));
            return;
        }
        this.f6219a.m5615c();
    }
}
