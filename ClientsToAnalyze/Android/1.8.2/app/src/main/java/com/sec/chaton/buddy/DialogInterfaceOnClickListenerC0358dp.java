package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.p016a.C0555aw;
import java.util.ArrayList;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.dp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0358dp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0357do f1502a;

    DialogInterfaceOnClickListenerC0358dp(HandlerC0357do handlerC0357do) {
        this.f1502a = handlerC0357do;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(C0555aw.m2754a(this.f1502a.f1501a.f1172h));
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
