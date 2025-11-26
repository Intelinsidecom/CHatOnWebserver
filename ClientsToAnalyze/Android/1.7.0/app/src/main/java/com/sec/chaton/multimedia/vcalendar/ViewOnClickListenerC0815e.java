package com.sec.chaton.multimedia.vcalendar;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: VCalendarDetailActivity2.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC0815e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailActivity2 f2803a;

    ViewOnClickListenerC0815e(VCalendarDetailActivity2 vCalendarDetailActivity2) {
        this.f2803a = vCalendarDetailActivity2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2803a.f2768r.setButtonEnabled(false);
        switch (view.getId()) {
            case R.id.header_button1 /* 2131427690 */:
                if (this.f2803a.f2760j != 1) {
                    if (this.f2803a.f2760j == 2 || this.f2803a.f2760j == 3) {
                        this.f2803a.m3306a();
                        break;
                    }
                } else {
                    C0811a c0811a = new C0811a();
                    c0811a.f2795i = this.f2803a.f2755e;
                    c0811a.f2789c = String.valueOf(this.f2803a.f2756f);
                    c0811a.f2788b = String.valueOf(this.f2803a.f2757g);
                    c0811a.f2796j = this.f2803a.f2758h;
                    c0811a.f2787a = this.f2803a.f2759i;
                    this.f2803a.f2761k = new C0812b();
                    this.f2803a.f2761k.m3341a(c0811a);
                    this.f2803a.showDialog(0);
                    new Thread((ThreadGroup) null, this.f2803a.f2769s).start();
                    break;
                }
                break;
        }
    }
}
