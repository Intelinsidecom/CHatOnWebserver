package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p025d.p026a.C1206cg;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.fx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0713fx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0711fv f2954a;

    DialogInterfaceOnClickListenerC0713fx(HandlerC0711fv handlerC0711fv) {
        this.f2954a = handlerC0711fv;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(C1206cg.m5544a(this.f2954a.f2952a.f2197j));
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
