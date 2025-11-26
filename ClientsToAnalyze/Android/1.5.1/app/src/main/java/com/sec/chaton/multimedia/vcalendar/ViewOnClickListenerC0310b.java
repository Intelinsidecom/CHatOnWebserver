package com.sec.chaton.multimedia.vcalendar;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.chaton.multimedia.vcalendar.VCalendarStruct;

/* renamed from: com.sec.chaton.multimedia.vcalendar.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0310b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VCalendarDetailActivity2 f2261a;

    ViewOnClickListenerC0310b(VCalendarDetailActivity2 vCalendarDetailActivity2) {
        this.f2261a = vCalendarDetailActivity2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2261a.f2200o.setEnabled(false);
        this.f2261a.f2199n.setEnabled(false);
        this.f2261a.f2201p.setEnabled(false);
        switch (view.getId()) {
            case C0062R.id.vcal_event_detail_save /* 2131427867 */:
                this.f2261a.m2566a();
                break;
            case C0062R.id.vcal_event_detail_send /* 2131427868 */:
                VCalendarStruct.EventStruct eventStruct = new VCalendarStruct.EventStruct();
                eventStruct.f2244i = this.f2261a.f2190e;
                eventStruct.f2238c = String.valueOf(this.f2261a.f2191f);
                eventStruct.f2237b = String.valueOf(this.f2261a.f2192g);
                eventStruct.f2245j = this.f2261a.f2193h;
                eventStruct.f2236a = this.f2261a.f2194i;
                this.f2261a.f2196k = new VCalendarStruct();
                this.f2261a.f2196k.m2601a(eventStruct);
                this.f2261a.showDialog(0);
                new Thread((ThreadGroup) null, this.f2261a.f2205t).start();
                break;
            case C0062R.id.vcal_event_detail_cancel /* 2131427869 */:
                Intent intent = new Intent();
                intent.putExtra("extra vcalendar", this.f2261a.f2190e);
                this.f2261a.setResult(0, intent);
                this.f2261a.finish();
                break;
        }
    }
}
