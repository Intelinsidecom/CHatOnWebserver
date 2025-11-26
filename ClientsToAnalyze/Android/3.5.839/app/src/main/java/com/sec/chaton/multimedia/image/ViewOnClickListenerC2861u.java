package com.sec.chaton.multimedia.image;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.plugin.C2921a;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC2861u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f10503a;

    ViewOnClickListenerC2861u(ImagePagerFragment imagePagerFragment) {
        this.f10503a = imagePagerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            if (C4873ck.m18500a()) {
                if (this.f10503a.f10257s != EnumC2214ab.IMAGE && this.f10503a.f10257s != EnumC2214ab.AMS) {
                    if (this.f10503a.f10257s == EnumC2214ab.VIDEO) {
                        if (TextUtils.isEmpty(this.f10503a.f10256r)) {
                            this.f10503a.mo10896b();
                            return;
                        }
                        if (!C4822an.m18245m() || !C4822an.m18246n()) {
                            C5179v.m19810a(this.f10503a.getActivity(), R.string.chatroom_unable_to_record_during_call, 0).show();
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.parse("file://" + this.f10503a.f10256r), "video/*");
                        intent.putExtra("android.intent.extra.finishOnCompletion", false);
                        try {
                            this.f10503a.startActivity(intent);
                            return;
                        } catch (ActivityNotFoundException e) {
                            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e, ImagePagerFragment.f10232f);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (this.f10503a.getActivity() != null) {
                    if (C4822an.m18206P() || C4822an.m18207Q()) {
                        C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                        return;
                    }
                    if (C2948h.m12190a().m12192a(this.f10503a.getActivity(), EnumC2949i.Animessage)) {
                        this.f10503a.startActivity(C2921a.m12139a(this.f10503a.getActivity(), this.f10503a.f10256r));
                        return;
                    } else {
                        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f10503a.getActivity());
                        abstractC4932aM18733a.mo18734a(R.string.media_animessage).mo18746b(R.string.ams_install_message).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2862v(this)).mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
                        abstractC4932aM18733a.mo18752b();
                        return;
                    }
                }
                return;
            }
            C5179v.m19810a(CommonApplication.m18732r(), R.string.sdcard_not_found, 0).show();
        }
    }
}
