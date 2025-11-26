package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.hj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1357hj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f4936a;

    DialogInterfaceOnClickListenerC1357hj(BuddyRecommendFragment buddyRecommendFragment) {
        this.f4936a = buddyRecommendFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(C2181ag.m9738a(this.f4936a.f4083k));
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
