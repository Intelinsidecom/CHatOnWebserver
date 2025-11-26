package com.sec.chaton.msgbox;

import android.content.ContentResolver;
import android.os.Handler;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.plugin.p084c.C2934a;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.AbstractC5016a;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.z */
/* loaded from: classes.dex */
public class C2681z extends AbstractC5016a<Object, Void, Boolean> {

    /* renamed from: a */
    final /* synthetic */ C2660e f9610a;

    /* renamed from: b */
    private EnumC2300t f9611b;

    /* renamed from: c */
    private ArrayList<String> f9612c;

    /* renamed from: d */
    private String f9613d;

    /* renamed from: f */
    private ArrayList<String> f9614f;

    /* renamed from: g */
    private Handler f9615g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2681z(C2660e c2660e, ExecutorService executorService) {
        super(executorService);
        this.f9610a = c2660e;
        this.f9611b = EnumC2300t.UNKNOWN;
        this.f9615g = new HandlerC2609aa(this);
        c2660e.f9551o = true;
        c2660e.f9550n = true;
    }

    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a */
    protected void mo6107a() {
        if (this.f9610a.f9546j != 5 && !this.f9610a.f9542f.isShowing()) {
            this.f9610a.f9542f.show();
        }
        super.mo6107a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean mo6106a(Object... objArr) {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        this.f9612c = (ArrayList) objArr[0];
        this.f9611b = (EnumC2300t) objArr[1];
        ArrayList arrayList = (ArrayList) objArr[2];
        this.f9614f = (ArrayList) objArr[3];
        this.f9613d = (String) objArr[4];
        if (arrayList != null && arrayList.size() > 0) {
            this.f9610a.f9551o = C2198l.m9932a(contentResolver, (ArrayList<String>) arrayList);
            if (C4904y.f17872b) {
                C4904y.m18639b("MsgboxCloseTask - deleteLocal inbox", C2660e.f9537b);
            }
        }
        return (Boolean) objArr[5];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo6108a(Boolean bool) {
        if (C2349a.m10301a("sms_feature") && this.f9614f != null && this.f9614f.size() > 0) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[SMS]request to SMS to delete", C2660e.f9537b);
            }
            new C2934a(this.f9615g, this.f9610a.f9540d, this.f9614f).m12171a(bool.booleanValue());
        } else {
            this.f9615g.sendEmptyMessage(0);
        }
        super.mo6108a((C2681z) bool);
    }
}
