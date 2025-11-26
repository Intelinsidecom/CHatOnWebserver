package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.am */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4727am implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC4726al f17391a;

    DialogInterfaceOnClickListenerC4727am(ViewOnClickListenerC4726al viewOnClickListenerC4726al) {
        this.f17391a = viewOnClickListenerC4726al;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (!this.f17391a.f17390a.f17243al.exists()) {
                this.f17391a.f17390a.f17243al.mkdirs();
            }
            this.f17391a.f17390a.f17241aj = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f17391a.f17390a.f17240ai = new File(this.f17391a.f17390a.f17243al + "/", this.f17391a.f17390a.f17241aj);
            if (C4904y.f17872b) {
                C4904y.m18639b("[Create File] " + this.f17391a.f17390a.f17243al.toString() + this.f17391a.f17390a.f17241aj + " : " + this.f17391a.f17390a.f17240ai.getName(), MyPageFragment.f17192a);
            }
            this.f17391a.f17390a.f17233ab = Uri.fromFile(this.f17391a.f17390a.f17240ai);
            if (!C4873ck.m18500a()) {
                C5179v.m19811a(this.f17391a.f17390a.getActivity(), this.f17391a.f17390a.getString(R.string.toast_sdcard_amount), 1).show();
                return;
            }
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f17391a.f17390a.getActivity());
            if (C4822an.m18251s()) {
                abstractC4932aM18733a.mo18734a(R.string.mypage_profile_add_photo).mo18736a(R.array.selphoto, this.f17391a.f17390a.f17228aG);
            } else {
                abstractC4932aM18733a.mo18734a(R.string.mypage_profile_add_photo).mo18736a(R.array.selphoto_first_nocamera_nodelete, this.f17391a.f17390a.f17229aH);
            }
            abstractC4932aM18733a.mo18745a().show();
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, MyPageFragment.f17192a);
            }
        }
    }
}
