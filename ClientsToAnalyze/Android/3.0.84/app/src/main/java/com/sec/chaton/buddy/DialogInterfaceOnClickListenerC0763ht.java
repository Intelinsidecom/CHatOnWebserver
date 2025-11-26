package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p025d.p026a.C1206cg;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ht */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0763ht implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0762hs f3030a;

    DialogInterfaceOnClickListenerC0763ht(HandlerC0762hs handlerC0762hs) {
        this.f3030a = handlerC0762hs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(C1206cg.m5544a(this.f3030a.f3029a.f2306k));
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
