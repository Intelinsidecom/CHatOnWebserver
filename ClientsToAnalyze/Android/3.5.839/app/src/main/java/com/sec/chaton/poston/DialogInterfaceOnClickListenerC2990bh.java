package com.sec.chaton.poston;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.multisend.GalleryActivity;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2990bh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11105a;

    DialogInterfaceOnClickListenerC2990bh(PostONWriteFragment postONWriteFragment) {
        this.f11105a = postONWriteFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                try {
                    this.f11105a.startActivityForResult(intent, 2);
                    break;
                } catch (ActivityNotFoundException e) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, "PostONWriteFragment");
                        return;
                    }
                    return;
                }
            case 1:
                if (!C4873ck.m18500a()) {
                    C5179v.m19810a(this.f11105a.getActivity(), R.string.sdcard_not_found, 0).show();
                    break;
                } else {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Intent intent2 = new Intent(this.f11105a.getActivity(), (Class<?>) GalleryActivity.class);
                    intent2.putParcelableArrayListExtra("preview_data", arrayList);
                    intent2.putExtra("caller", "POSTON");
                    intent2.putExtra("attachedimagecount", this.f11105a.f10987S.size());
                    this.f11105a.startActivityForResult(intent2, 3);
                    break;
                }
        }
    }
}
