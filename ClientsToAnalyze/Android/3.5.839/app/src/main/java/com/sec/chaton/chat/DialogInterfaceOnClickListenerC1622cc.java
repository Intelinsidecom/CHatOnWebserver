package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.multisend.GalleryActivity;
import com.sec.chaton.util.C4873ck;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1622cc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6149a;

    DialogInterfaceOnClickListenerC1622cc(ChatFragment chatFragment) {
        this.f6149a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f6149a.m8030al();
                break;
            case 1:
                if (!C4873ck.m18500a()) {
                    C5179v.m19810a(this.f6149a.f5624cN, R.string.sdcard_not_found, 0).show();
                    break;
                } else {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Intent intent = new Intent(this.f6149a.f5624cN, (Class<?>) GalleryActivity.class);
                    intent.putParcelableArrayListExtra("preview_data", arrayList);
                    this.f6149a.startActivityForResult(intent, 22);
                    break;
                }
        }
    }
}
