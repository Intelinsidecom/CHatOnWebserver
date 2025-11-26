package com.sec.chaton.smsplugin.p112ui;

import android.content.ContentUris;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import java.util.ArrayList;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4252fz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15611a;

    /* renamed from: b */
    private boolean f15612b;

    public DialogInterfaceOnClickListenerC4252fz(PluginComposeMessageActivity pluginComposeMessageActivity, boolean z) {
        this.f15611a = pluginComposeMessageActivity;
        this.f15612b = z;
    }

    /* renamed from: a */
    public void m16465a(boolean z) {
        this.f15612b = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Cursor cursor = this.f15611a.f15050p.getCursor();
        if (cursor != null && cursor.moveToFirst()) {
            ArrayList<Uri> arrayList = new ArrayList<>();
            do {
                long j = cursor.getLong(1);
                String string = cursor.getString(0);
                if ((!(cursor.getInt(20) != 0) || this.f15612b) && this.f15611a.f15050p.m16337c(j, string)) {
                    if ("sms".equals(string)) {
                        arrayList.add(ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, j));
                    } else if ("mms".equals(string)) {
                        arrayList.add(ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, j));
                    }
                }
            } while (cursor.moveToNext());
            this.f15611a.f15013bH.m15243a(this.f15611a.f15019bQ, arrayList, 9700, (Object) null, true);
            dialogInterface.dismiss();
            this.f15611a.m16130l();
        }
    }
}
