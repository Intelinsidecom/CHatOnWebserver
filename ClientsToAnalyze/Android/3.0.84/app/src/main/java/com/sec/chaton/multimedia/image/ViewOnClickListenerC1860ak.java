package com.sec.chaton.multimedia.image;

import android.net.Uri;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3223ck;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.File;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC1860ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f7099a;

    ViewOnClickListenerC1860ak(PostONImagePagerFragment postONImagePagerFragment) {
        this.f7099a = postONImagePagerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            if (C3223ck.m11327a()) {
                if (this.f7099a.f7030t.equals(PostONImagePagerFragment.f6998j)) {
                    this.f7099a.f7036z = this.f7099a.f7031u.split("/")[r0.length - 1];
                    this.f7099a.f7001A = new File(this.f7099a.f7035y, this.f7099a.f7036z);
                    if (!this.f7099a.f7001A.exists() || this.f7099a.f7001A.length() <= 0) {
                        this.f7099a.m7674e();
                        return;
                    } else if (C3171am.m11072j() && C3171am.m11073k()) {
                        ((InterfaceC1866aq) this.f7099a.getActivity()).mo7655a(Uri.fromFile(this.f7099a.f7001A));
                        return;
                    } else {
                        C3641ai.m13210a(this.f7099a.getActivity(), R.string.chatroom_unable_to_record_during_call, 0).show();
                        return;
                    }
                }
                return;
            }
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.sdcard_not_found, 0).show();
        }
    }
}
