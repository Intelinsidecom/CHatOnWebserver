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
class HandlerC0848aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ DeleteCallLogFragment f3357a;

    /* renamed from: b */
    private boolean f3358b;

    private HandlerC0848aa(DeleteCallLogFragment deleteCallLogFragment) {
        this.f3357a = deleteCallLogFragment;
        this.f3358b = false;
    }

    /* synthetic */ HandlerC0848aa(DeleteCallLogFragment deleteCallLogFragment, DialogInterfaceOnClickListenerC0883w dialogInterfaceOnClickListenerC0883w) {
        this(deleteCallLogFragment);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f3357a.isDetached() && !this.f3358b) {
            switch (message.what) {
                case 8000:
                    this.f3357a.m4589b("CallLog Updated!!");
                    this.f3357a.m4602i();
                    m4638a(this.f3357a.f3318i.size() <= 1);
                    break;
                case 8002:
                    this.f3357a.m4593d();
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m4638a(boolean z) {
        this.f3357a.m4589b("moveToPreActivity() isAllDeleted:" + z);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (z) {
            intent.putExtra("DELETE_DETAIL_CALLLOG_ALL", true);
            this.f3357a.getActivity().setResult(-1, intent);
            C0847a.m4634a(false);
            ((InterfaceC0849ab) this.f3357a.getActivity()).mo4584c();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int size = this.f3357a.f3318i.size() - 1; size >= 0; size--) {
            if (!(this.f3357a.f3317h.get(size) instanceof SeperatorCallLog)) {
                arrayList.add(Integer.valueOf(((CallLogData) this.f3357a.f3317h.get(size))._id));
            }
        }
        intent.putExtras(bundle);
        intent.setFlags(1073741824);
        this.f3357a.getActivity().setResult(-1, intent);
        C0847a.m4634a(false);
        ((InterfaceC0849ab) this.f3357a.getActivity()).mo4584c();
    }
}
