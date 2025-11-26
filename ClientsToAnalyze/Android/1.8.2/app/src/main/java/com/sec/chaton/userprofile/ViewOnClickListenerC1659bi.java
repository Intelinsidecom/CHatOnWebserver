package com.sec.chaton.userprofile;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: RankWeeklyViewFragment.java */
/* renamed from: com.sec.chaton.userprofile.bi */
/* loaded from: classes.dex */
class ViewOnClickListenerC1659bi implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RankWeeklyViewFragment f6150a;

    ViewOnClickListenerC1659bi(RankWeeklyViewFragment rankWeeklyViewFragment) {
        this.f6150a = rankWeeklyViewFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("com.sec.chaton.ACTION_DISPALY_WEEK");
        this.f6150a.f5975a.setTextColor(this.f6150a.getResources().getColor(R.color.ics_main_font_color_2));
        this.f6150a.f5976b.setTextColor(this.f6150a.getResources().getColor(R.color.ics_main_font_color_2));
        this.f6150a.f5977c.setTextColor(this.f6150a.getResources().getColor(R.color.ics_main_font_color_2));
        this.f6150a.f5978d.setTextColor(this.f6150a.getResources().getColor(R.color.ics_main_font_color_2));
        this.f6150a.f5979e.setVisibility(8);
        this.f6150a.f5980f.setVisibility(8);
        this.f6150a.f5981g.setVisibility(8);
        this.f6150a.f5982h.setVisibility(8);
        switch (view.getId()) {
            case R.id.layoutWeek1 /* 2131493900 */:
                this.f6150a.f5975a.setTextColor(this.f6150a.getResources().getColor(R.color.blue_color_021));
                this.f6150a.f5979e.setVisibility(0);
                intent.putExtra("WEEK_DETAILS", 1);
                break;
            case R.id.layoutWeek2 /* 2131493903 */:
                this.f6150a.f5976b.setTextColor(this.f6150a.getResources().getColor(R.color.blue_color_021));
                this.f6150a.f5980f.setVisibility(0);
                intent.putExtra("WEEK_DETAILS", 2);
                break;
            case R.id.layoutWeek3 /* 2131493906 */:
                this.f6150a.f5977c.setTextColor(this.f6150a.getResources().getColor(R.color.blue_color_021));
                this.f6150a.f5981g.setVisibility(0);
                intent.putExtra("WEEK_DETAILS", 3);
                break;
            case R.id.layoutWeek4 /* 2131493909 */:
                this.f6150a.f5978d.setTextColor(this.f6150a.getResources().getColor(R.color.blue_color_021));
                this.f6150a.f5982h.setVisibility(0);
                intent.putExtra("WEEK_DETAILS", 4);
                break;
        }
        LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).sendBroadcast(intent);
    }
}
