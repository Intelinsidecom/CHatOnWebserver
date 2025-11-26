package com.sec.chaton.calllog.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import java.util.ArrayList;

/* compiled from: DeleteCallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.aa */
/* loaded from: classes.dex */
class HandlerC1459aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ DeleteCallLogFragment f5330a;

    /* renamed from: b */
    private boolean f5331b;

    private HandlerC1459aa(DeleteCallLogFragment deleteCallLogFragment) {
        this.f5330a = deleteCallLogFragment;
        this.f5331b = false;
    }

    /* synthetic */ HandlerC1459aa(DeleteCallLogFragment deleteCallLogFragment, DialogInterfaceOnClickListenerC1494w dialogInterfaceOnClickListenerC1494w) {
        this(deleteCallLogFragment);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f5330a.isDetached() && !this.f5331b) {
            switch (message.what) {
                case 8000:
                    this.f5330a.m7745b("CallLog Updated!!");
                    this.f5330a.m7758i();
                    m7794a(this.f5330a.f5291i.size() <= 1);
                    break;
                case 8002:
                    this.f5330a.m7749d();
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m7794a(boolean z) {
        this.f5330a.m7745b("moveToPreActivity() isAllDeleted:" + z);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (z) {
            intent.putExtra("DELETE_DETAIL_CALLLOG_ALL", true);
            this.f5330a.getActivity().setResult(-1, intent);
            C1458a.m7790a(false);
            ((InterfaceC1460ab) this.f5330a.getActivity()).mo7740h();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int size = this.f5330a.f5291i.size() - 1; size >= 0; size--) {
            if (!(this.f5330a.f5290h.get(size) instanceof SeperatorCallLog)) {
                arrayList.add(Integer.valueOf(((CallLogData) this.f5330a.f5290h.get(size))._id));
            }
        }
        intent.putExtras(bundle);
        intent.setFlags(1073741824);
        this.f5330a.getActivity().setResult(-1, intent);
        C1458a.m7790a(false);
        ((InterfaceC1460ab) this.f5330a.getActivity()).mo7740h();
    }
}
