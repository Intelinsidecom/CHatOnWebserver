package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1789u;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.ar */
/* loaded from: classes.dex */
class HandlerC1239ar extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f4780a;

    HandlerC1239ar(ActivityPrivacy activityPrivacy) {
        this.f4780a = activityPrivacy;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4780a.f4552k != null) {
            this.f4780a.f4552k.dismiss();
        }
        C0101b c0101b = (C0101b) message.obj;
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            C1789u.m6076a("show_phone_number_to_all", Boolean.valueOf(this.f4780a.f4553l));
            this.f4780a.f4545d.setChecked(C1789u.m6075a().getBoolean("show_phone_number_to_all", false));
            StringBuilder sb = new StringBuilder();
            if (this.f4780a.f4545d.isChecked()) {
                sb.append("+").append(this.f4780a.f4551j).append("\n").append(this.f4780a.getResources().getString(R.string.phone_number_privacy_guide));
            } else {
                sb.append("+").append(this.f4780a.f4551j).append("\n").append(this.f4780a.getResources().getString(R.string.phone_number_privacy_guide_off));
            }
            this.f4780a.f4545d.setSummary(sb);
            this.f4780a.m4548a(this.f4780a.f4545d.getSummary().toString(), this.f4780a.f4545d, this.f4780a.getResources().getColor(R.color.ics_orange_font_color));
            return;
        }
        if (this.f4780a.getActivity() != null) {
            this.f4780a.f4545d.setChecked(C1789u.m6075a().getBoolean("show_phone_number_to_all", false));
            Toast.makeText(this.f4780a.getActivity(), this.f4780a.getResources().getString(R.string.dev_network_error), 0).show();
        }
    }
}
