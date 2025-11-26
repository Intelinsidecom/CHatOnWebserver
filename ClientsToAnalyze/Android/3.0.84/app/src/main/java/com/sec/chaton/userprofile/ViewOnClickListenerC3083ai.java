package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;
import java.io.File;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ai */
/* loaded from: classes.dex */
class ViewOnClickListenerC3083ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11295a;

    ViewOnClickListenerC3083ai(MyPageFragment myPageFragment) {
        this.f11295a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            File file = new File(this.f11295a.f11163at, "myprofile.png_");
            if (C3250y.f11734b) {
                C3250y.m11450b("photoFile=" + file, getClass().getSimpleName());
            }
            String strM10979a = C3159aa.m10962a().m10979a("profile_small_image1", "");
            if (!this.f11295a.f11162as || ((!C3159aa.m10962a().m10979a("profile_image_status", "").equals("deleted") && file.exists()) || !strM10979a.equals(""))) {
                this.f11295a.f11155al = true;
                ((InterfaceC3112bk) this.f11295a.getActivity()).mo1313a(0, false);
            } else {
                this.f11295a.m10778e();
            }
        }
    }
}
