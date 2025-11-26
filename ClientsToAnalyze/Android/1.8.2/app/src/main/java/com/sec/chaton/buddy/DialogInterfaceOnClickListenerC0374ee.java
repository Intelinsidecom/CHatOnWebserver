package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.p016a.C0555aw;
import java.util.ArrayList;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.ee */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0374ee implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0372ec f1525a;

    DialogInterfaceOnClickListenerC0374ee(HandlerC0372ec handlerC0372ec) {
        this.f1525a = handlerC0372ec;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(C0555aw.m2754a(this.f1525a.f1523a.f1190h));
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            if (this.f1525a.f1523a.f1184b != null) {
                this.f1525a.f1523a.f1184b.setEmptyView(this.f1525a.f1523a.f1185c);
            }
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
