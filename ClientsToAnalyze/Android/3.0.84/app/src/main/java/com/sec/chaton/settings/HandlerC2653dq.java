package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.BuddyMappingInfo;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.dq */
/* loaded from: classes.dex */
class HandlerC2653dq extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentMultiDeviceView f9913a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2653dq(FragmentMultiDeviceView fragmentMultiDeviceView, Looper looper) {
        super(looper);
        this.f9913a = fragmentMultiDeviceView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case HttpResponseCode.TOO_LONG /* 413 */:
                if (this.f9913a.f9159j != null && this.f9913a.f9159j.isShowing()) {
                    this.f9913a.f9159j.dismiss();
                }
                if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    BuddyMappingInfo buddyMappingInfo = (BuddyMappingInfo) c0267d.m1354e();
                    if (buddyMappingInfo == null || !buddyMappingInfo.mapping.booleanValue()) {
                        Toast.makeText(this.f9913a.f9153d, R.string.toast_network_unable, 0).show();
                        break;
                    } else {
                        this.f9913a.f9158i = buddyMappingInfo.MappingInfo;
                        this.f9913a.f9160k = buddyMappingInfo.url;
                        C3250y.m11450b("webURL : " + this.f9913a.f9160k + " mMappingInfo : " + this.f9913a.f9158i, getClass().getSimpleName());
                        this.f9913a.f9162m.setAdapter((ListAdapter) this.f9913a.f9155f);
                        break;
                    }
                }
                break;
            case 2007:
                if (c0267d == null || !c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    if (this.f9913a.f9159j != null && this.f9913a.f9159j.isShowing()) {
                        this.f9913a.f9159j.dismiss();
                    }
                    Toast.makeText(this.f9913a.f9153d, R.string.toast_network_unable, 0).show();
                    break;
                } else {
                    this.f9913a.f9156g.m5942f("");
                    break;
                }
                break;
        }
    }
}
