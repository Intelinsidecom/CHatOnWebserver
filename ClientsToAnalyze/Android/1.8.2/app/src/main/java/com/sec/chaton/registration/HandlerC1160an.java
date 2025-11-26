package com.sec.chaton.registration;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.coolots.AbstractC0521a;
import com.sec.chaton.for3rd.AddonStatusService;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.registration.ActivityNonSelfSMS;
import com.sec.chaton.registration.ActivityRegistPushName;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.an */
/* loaded from: classes.dex */
class HandlerC1160an extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName.RegistPushNameFragment f4362a;

    HandlerC1160an(ActivityRegistPushName.RegistPushNameFragment registPushNameFragment) {
        this.f4362a = registPushNameFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws PackageManager.NameNotFoundException {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 201:
                if (this.f4362a.getActivity() != null) {
                    this.f4362a.f4270n.dismiss();
                }
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    boolean zM2697a = AbstractC0521a.m2697a(this.f4362a.getActivity());
                    Intent intent = new Intent(this.f4362a.getActivity(), (Class<?>) AddonStatusService.class);
                    intent.putExtra("package_name", "com.coolots.chaton");
                    intent.putExtra("is_installed", zM2697a);
                    this.f4362a.getActivity().startService(intent);
                    Intent intent2 = new Intent();
                    intent2.putExtra("PUSH_NAME", this.f4362a.f4257a.getText().toString());
                    this.f4362a.getActivity().setResult(-1, intent2);
                    this.f4362a.getActivity().finish();
                    break;
                } else if (c0101b.m673f() == 12007) {
                    ActivityNonSelfSMS.NonSelfSMSFragment.m4335a((Activity) this.f4362a.getActivity(), true);
                    new Intent();
                    this.f4362a.getActivity().setResult(2);
                    break;
                } else if (c0101b.m673f() == 12008) {
                    ActivityNonSelfSMS.NonSelfSMSFragment.m4343b((Activity) this.f4362a.getActivity(), true);
                    new Intent();
                    this.f4362a.getActivity().setResult(2);
                    break;
                } else {
                    new AlertDialogBuilderC2120a(this.f4362a.getActivity()).setTitle(this.f4362a.getResources().getString(R.string.toast_error)).setMessage(this.f4362a.getResources().getString(R.string.toast_network_unable)).setNegativeButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1162ap(this)).setPositiveButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1161ao(this)).show();
                    C1786r.m6054a("[Dev]Registration Failed. httpStatus: " + c0101b.m675h() + ", FaultCode: " + c0101b.m673f() + ", Message: " + c0101b.m674g(), getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
