package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import org.json.JSONException;

/* compiled from: SkinListView.java */
/* renamed from: com.sec.chaton.settings.downloads.cp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2603cp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SkinListView f9830a;

    DialogInterfaceOnClickListenerC2603cp(SkinListView skinListView) {
        this.f9830a = skinListView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9830a.f9564h != null) {
            try {
                this.f9830a.f9564h.m9563d();
            } catch (JSONException e) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("download_skin, json parsing exception occured.", SkinListView.f9557a);
                }
                C3641ai.m13211a(this.f9830a.f9558b, this.f9830a.f9558b.getString(R.string.download_failed), 0).show();
                e.printStackTrace();
            }
        }
    }
}
