package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import java.io.File;
import java.io.IOException;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3106be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11319a;

    DialogInterfaceOnClickListenerC3106be(MyPageFragment myPageFragment) {
        this.f11319a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws IOException {
        int i2 = R.array.selphoto_first_nocamera_nodelete;
        try {
            if (!this.f11319a.f11164au.exists()) {
                this.f11319a.f11164au.mkdirs();
            }
            this.f11319a.m10729d("/profile/");
            this.f11319a.f11157an = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f11319a.f11156am = new File(this.f11319a.f11164au + "/", this.f11319a.f11157an);
            boolean zCreateNewFile = this.f11319a.f11156am.createNewFile();
            if (C3250y.f11734b) {
                C3250y.m11450b("[Create File] " + this.f11319a.f11164au.toString() + this.f11319a.f11157an + " : " + zCreateNewFile, MyPageFragment.f11095a);
            }
            this.f11319a.f11167ax = Uri.fromFile(this.f11319a.f11156am);
            if (!C3223ck.m11327a()) {
                Toast.makeText(this.f11319a.getActivity(), this.f11319a.getString(R.string.toast_sdcard_amount), 1).show();
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            intent.putExtra("set-as-image", true);
            if (BuddyProfileActivity.m3573a(this.f11319a.getActivity(), intent)) {
                if (C3171am.m11077o()) {
                    i2 = R.array.selphoto_first;
                }
            } else if (C3171am.m11077o()) {
                i2 = R.array.cselphoto_first;
            }
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f11319a.getActivity());
            if (C3171am.m11077o()) {
                abstractC3271aM11494a.mo11495a(R.string.mypage_profile_add_photo).mo11497a(i2, this.f11319a.f11141aS);
            } else {
                abstractC3271aM11494a.mo11495a(R.string.mypage_profile_add_photo).mo11497a(i2, this.f11319a.f11142aT);
            }
            abstractC3271aM11494a.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3107bf(this));
            abstractC3271aM11494a.mo11505a().show();
            if (this.f11319a.f11168ay) {
                abstractC3271aM11494a.mo11505a().dismiss();
            }
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, MyPageFragment.f11095a);
            }
        }
    }
}
