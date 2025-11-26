package com.sec.chaton.multimedia.image;

import android.net.Uri;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.an */
/* loaded from: classes.dex */
class ViewOnClickListenerC2829an implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f10410a;

    ViewOnClickListenerC2829an(PostONImagePagerFragment postONImagePagerFragment) {
        this.f10410a = postONImagePagerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            if (C4873ck.m18500a()) {
                if (this.f10410a.f10336t.equals(PostONImagePagerFragment.f10305j)) {
                    this.f10410a.f10342z = this.f10410a.f10337u.split("/")[r0.length - 1];
                    this.f10410a.f10308A = new File(this.f10410a.f10341y, this.f10410a.f10342z);
                    if (!this.f10410a.f10308A.exists() || this.f10410a.f10308A.length() <= 0) {
                        this.f10410a.m11901h();
                        return;
                    } else if (C4822an.m18245m() && C4822an.m18246n()) {
                        ((InterfaceC2835at) this.f10410a.getActivity()).mo11871a(Uri.fromFile(this.f10410a.f10308A));
                        return;
                    } else {
                        C5179v.m19810a(this.f10410a.getActivity(), R.string.chatroom_unable_to_record_during_call, 0).show();
                        return;
                    }
                }
                return;
            }
            C5179v.m19810a(CommonApplication.m18732r(), R.string.sdcard_not_found, 0).show();
        }
    }
}
