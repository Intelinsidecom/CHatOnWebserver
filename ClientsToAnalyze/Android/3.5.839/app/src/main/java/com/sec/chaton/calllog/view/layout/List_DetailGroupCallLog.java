package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.p053b.C1452a;
import java.util.List;

/* loaded from: classes.dex */
public class List_DetailGroupCallLog extends List_DetailCallLog {

    /* renamed from: h */
    private final C1452a f5385h;

    public List_DetailGroupCallLog(Context context, Handler handler, List<Boolean> list, InterfaceC1447e interfaceC1447e) {
        super(context, handler, list, interfaceC1447e);
        this.f5385h = C1452a.m7605a();
    }

    @Override // com.sec.chaton.calllog.view.layout.List_DetailCallLog
    /* renamed from: a */
    protected RelativeLayout mo7810a(Context context) {
        return new List_TypeDetailGroupCallLog(context);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_DetailCallLog
    /* renamed from: a */
    protected void mo7811a(CallLogData callLogData, String str, boolean z, boolean z2) {
        ((List_TypeDetailGroupCallLog) this.f5381a).setDeleteMode(z);
        ((List_TypeDetailGroupCallLog) this.f5381a).setName(this.f5385h.m7616b(callLogData));
        ((List_TypeDetailGroupCallLog) this.f5381a).setTime(str);
        ((List_TypeDetailGroupCallLog) this.f5381a).setDuration(C1452a.m7605a().m7612a(callLogData));
        ((List_TypeDetailGroupCallLog) this.f5381a).setCallType(callLogData);
        ((List_TypeDetailGroupCallLog) this.f5381a).setCallMethod(callLogData.callmethod);
        ((List_TypeDetailGroupCallLog) this.f5381a).setChecked(z2);
        ((List_TypeDetailGroupCallLog) this.f5381a).setVisibility(0);
    }
}
