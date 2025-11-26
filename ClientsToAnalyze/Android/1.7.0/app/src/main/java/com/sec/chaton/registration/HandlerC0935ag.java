package com.sec.chaton.registration;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.coolots.AbstractC0617h;
import com.sec.chaton.for3rd.AddonStatusService;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.registration.ActivityNonSelfSMS;
import com.sec.chaton.registration.ActivityRegistPushName;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ag */
/* loaded from: classes.dex */
class HandlerC0935ag extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName.RegistPushNameFragment f3322a;

    HandlerC0935ag(ActivityRegistPushName.RegistPushNameFragment registPushNameFragment) {
        this.f3322a = registPushNameFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws PackageManager.NameNotFoundException {
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 201:
                if (this.f3322a.getActivity() != null) {
                    this.f3322a.f3244m.dismiss();
                }
                if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                    if (this.f3322a.getActivity() != null) {
                        boolean zM2831a = AbstractC0617h.m2831a(this.f3322a.getActivity());
                        Intent intent = new Intent(this.f3322a.getActivity(), (Class<?>) AddonStatusService.class);
                        intent.putExtra("package_name", "com.coolots.chaton");
                        intent.putExtra("is_installed", zM2831a);
                        this.f3322a.getActivity().startService(intent);
                        Intent intent2 = new Intent();
                        intent2.putExtra("PUSH_NAME", this.f3322a.f3232a.getText().toString());
                        this.f3322a.getActivity().setResult(-1, intent2);
                        this.f3322a.getActivity().finish();
                        break;
                    }
                } else if (c0259g.m934f() == 12007) {
                    ActivityNonSelfSMS.NonSelfSMSFragment.m3660a(this.f3322a.f3235d, true);
                    new Intent();
                    this.f3322a.getActivity().setResult(2);
                    break;
                } else if (c0259g.m934f() == 12008) {
                    ActivityNonSelfSMS.NonSelfSMSFragment.m3666b(this.f3322a.f3235d, true);
                    new Intent();
                    this.f3322a.getActivity().setResult(2);
                    break;
                } else {
                    new AlertDialogBuilderC1625m(this.f3322a.getActivity()).setMessage(this.f3322a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0953ay(this)).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0952ax(this)).create().show();
                    C1341p.m4651a("[Dev]Registration Failed. httpStatus: " + c0259g.m936h() + ", FaultCode: " + c0259g.m934f() + ", Message: " + c0259g.m935g(), getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
