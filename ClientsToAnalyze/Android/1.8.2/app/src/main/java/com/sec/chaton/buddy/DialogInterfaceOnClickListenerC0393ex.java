package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.p016a.C0555aw;
import java.util.ArrayList;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.ex */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0393ex implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0392ew f1552a;

    DialogInterfaceOnClickListenerC0393ex(HandlerC0392ew handlerC0392ew) {
        this.f1552a = handlerC0392ew;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(C0555aw.m2754a(this.f1552a.f1551a.f1255m));
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
