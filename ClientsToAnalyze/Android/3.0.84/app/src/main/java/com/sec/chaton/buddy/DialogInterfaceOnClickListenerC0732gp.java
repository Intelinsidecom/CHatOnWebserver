package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p025d.p026a.C1206cg;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.gp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0732gp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0731go f2986a;

    DialogInterfaceOnClickListenerC0732gp(HandlerC0731go handlerC0731go) {
        this.f2986a = handlerC0731go;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(C1206cg.m5544a(this.f2986a.f2985a.f2224j));
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            if (this.f2986a.f2985a.f2218d != null) {
                this.f2986a.f2985a.f2218d.setEmptyView(this.f2986a.f2985a.f2219e);
            }
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
