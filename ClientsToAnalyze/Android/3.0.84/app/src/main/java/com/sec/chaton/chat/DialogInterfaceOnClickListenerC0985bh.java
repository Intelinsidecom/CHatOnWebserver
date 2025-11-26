package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.multisend.GalleryActivity;
import com.sec.chaton.util.C3223ck;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0985bh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4055a;

    DialogInterfaceOnClickListenerC0985bh(ChatFragment chatFragment) {
        this.f4055a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f4055a.m4811aa();
                break;
            case 1:
                if (!C3223ck.m11327a()) {
                    C3641ai.m13210a(this.f4055a.f3672cr, R.string.sdcard_not_found, 0).show();
                    break;
                } else {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Intent intent = new Intent(this.f4055a.f3672cr, (Class<?>) GalleryActivity.class);
                    intent.putParcelableArrayListExtra("preview_data", arrayList);
                    this.f4055a.startActivityForResult(intent, 22);
                    break;
                }
        }
    }
}
