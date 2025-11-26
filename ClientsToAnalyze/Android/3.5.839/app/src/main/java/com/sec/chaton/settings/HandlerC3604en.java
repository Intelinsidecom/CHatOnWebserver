package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.BuddyMappingInfo;
import com.sec.chaton.p065io.entry.inner.MappingInfoEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.en */
/* loaded from: classes.dex */
class HandlerC3604en extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentMultiDeviceView f13130a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3604en(FragmentMultiDeviceView fragmentMultiDeviceView, Looper looper) {
        super(looper);
        this.f13130a = fragmentMultiDeviceView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (this.f13130a.getActivity() != null) {
            switch (message.what) {
                case 413:
                case 416:
                    if (this.f13130a.f12714k != null && this.f13130a.f12714k.isShowing()) {
                        this.f13130a.f12714k.dismiss();
                    }
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        Toast.makeText(this.f13130a.f12707d, R.string.toast_network_unable, 0).show();
                        break;
                    } else {
                        BuddyMappingInfo buddyMappingInfo = (BuddyMappingInfo) c0778b.m3110e();
                        if (buddyMappingInfo == null || !buddyMappingInfo.mapping.booleanValue()) {
                            Toast.makeText(this.f13130a.f12707d, R.string.toast_network_unable, 0).show();
                            break;
                        } else {
                            this.f13130a.f12713j = buddyMappingInfo.MappingInfo;
                            this.f13130a.f12715l = buddyMappingInfo.url;
                            C4904y.m18639b("webURL : " + this.f13130a.f12715l + " mMappingInfo : " + this.f13130a.f12713j, getClass().getSimpleName());
                            if (message.what == 416) {
                                this.f13130a.f12717n.setChoiceMode(1);
                                this.f13130a.m13578a((ArrayList<MappingInfoEntry>) this.f13130a.f12713j);
                            } else {
                                this.f13130a.m13576a(buddyMappingInfo);
                            }
                            this.f13130a.f12717n.setAdapter((ListAdapter) this.f13130a.f12710g);
                            this.f13130a.f12717n.setItemsCanFocus(true);
                            break;
                        }
                    }
                    break;
                case 2007:
                case 2008:
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        if (this.f13130a.f12714k != null && this.f13130a.f12714k.isShowing()) {
                            this.f13130a.f12714k.dismiss();
                        }
                        Toast.makeText(this.f13130a.f12707d, R.string.toast_network_unable, 0).show();
                        break;
                    } else {
                        this.f13130a.f12721r = true;
                        if (C4822an.m18255w()) {
                            this.f13130a.f12711h.m9320g("");
                            break;
                        } else if (this.f13130a.getActivity() != null) {
                            this.f13130a.getActivity().setResult(-1);
                            this.f13130a.getActivity().finish();
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
