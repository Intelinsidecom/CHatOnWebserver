package com.sec.chaton.hide;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* compiled from: HideBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC1512c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1510a f5568a;

    ViewOnClickListenerC1512c(C1510a c1510a) {
        this.f5568a = c1510a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws RemoteException, OperationApplicationException {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.f5568a.f5560d = this.f5568a.f5557a.get(iIntValue).f5572a;
        this.f5568a.f5559c = this.f5568a.f5557a.get(iIntValue).f5573b;
        try {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            arrayList.add(C1360d.m6052f(GlobalApplication.m11493l().getContentResolver(), this.f5568a.f5560d));
            CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            this.f5568a.f5564h.mo6490a();
            C3641ai.m13211a(this.f5568a.f5558b, this.f5568a.f5558b.getResources().getString(R.string.hide_list_button_shown), 0).show();
            C3250y.m11453c(this.f5568a.f5559c + " is unhide", getClass().getSimpleName());
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
