package com.sec.chaton.poston;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.multisend.GalleryActivity;
import com.sec.chaton.util.C3223ck;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1994bg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7709a;

    DialogInterfaceOnClickListenerC1994bg(PostONWriteFragment postONWriteFragment) {
        this.f7709a = postONWriteFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                this.f7709a.startActivityForResult(intent, 2);
                break;
            case 1:
                if (!C3223ck.m11327a()) {
                    C3641ai.m13210a(this.f7709a.getActivity(), R.string.sdcard_not_found, 0).show();
                    break;
                } else {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Intent intent2 = new Intent(this.f7709a.getActivity(), (Class<?>) GalleryActivity.class);
                    intent2.putParcelableArrayListExtra("preview_data", arrayList);
                    intent2.putExtra("caller", "POSTON");
                    intent2.putExtra("attachedimagecount", this.f7709a.f7591Q.size());
                    this.f7709a.startActivityForResult(intent2, 3);
                    break;
                }
        }
    }
}
