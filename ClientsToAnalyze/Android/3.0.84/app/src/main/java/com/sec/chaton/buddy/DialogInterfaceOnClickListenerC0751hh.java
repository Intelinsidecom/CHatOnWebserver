package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: GroupProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.hh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0751hh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GroupProfileImageViewFragment f3017a;

    DialogInterfaceOnClickListenerC0751hh(GroupProfileImageViewFragment groupProfileImageViewFragment) {
        this.f3017a = groupProfileImageViewFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f3017a.f2248d);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f3017a.startActivityForResult(intent, 6);
                break;
            case 1:
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                intent2.putExtra("set-as-image", true);
                if (!BuddyProfileActivity.m3573a(this.f3017a.f2262r, intent2)) {
                    intent2 = new Intent();
                    intent2.setAction("android.intent.action.GET_CONTENT");
                    intent2.setType("image/*");
                    intent2.putExtra("set-as-image", true);
                }
                this.f3017a.startActivityForResult(intent2, 5);
                break;
            case 2:
                C3250y.m11456e("onClick Delete profile iamge", GroupProfileImageViewFragment.f2245b);
                try {
                    this.f3017a.f2252h = URLEncoder.encode(this.f3017a.f2252h, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, getClass().getSimpleName());
                    }
                }
                File file = new File(this.f3017a.f2256l, this.f3017a.f2252h + "_group_profile.png_");
                C1335m.m5782a(null, this.f3017a.f2252h);
                if (file.delete()) {
                    this.f3017a.f2247c.setImageResource(R.drawable.contacts_default_group);
                    C3205bt.m11182a(this.f3017a.f2262r).m11219a(this.f3017a.f2252h, true);
                }
                this.f3017a.f2262r.finish();
                break;
        }
    }
}
