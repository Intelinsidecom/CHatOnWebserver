package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.util.C1739av;
import com.sec.chaton.util.C1786r;

/* compiled from: SpecialBuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fn */
/* loaded from: classes.dex */
class ViewOnClickListenerC0410fn implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyProfileFragment f1569a;

    ViewOnClickListenerC0410fn(SpecialBuddyProfileFragment specialBuddyProfileFragment) {
        this.f1569a = specialBuddyProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1739av.m5927a()) {
            C0809s.m3420a(GlobalApplication.m3260b());
            switch (view.getId()) {
                case R.id.new_buddy_add /* 2131493187 */:
                    if (Build.VERSION.SDK_INT >= 11) {
                        this.f1569a.m2280b();
                        break;
                    } else {
                        this.f1569a.m2294a();
                        break;
                    }
                case R.id.new_buddy_block /* 2131493188 */:
                    if (Build.VERSION.SDK_INT < 11) {
                        this.f1569a.m2280b();
                        break;
                    } else {
                        this.f1569a.m2294a();
                        break;
                    }
                case R.id.new_buddy_unblock /* 2131493189 */:
                    if (Build.VERSION.SDK_INT < 11) {
                        this.f1569a.m2284c();
                        break;
                    } else {
                        this.f1569a.getActivity().finish();
                        break;
                    }
                case R.id.new_buddy_cancel /* 2131493190 */:
                    if (Build.VERSION.SDK_INT >= 11) {
                        this.f1569a.m2284c();
                        break;
                    } else {
                        this.f1569a.getActivity().finish();
                        break;
                    }
                case R.id.profile_special_chat /* 2131494035 */:
                    C1786r.m6063c("profile_special_chat, isTaskRoot: " + this.f1569a.getActivity().isTaskRoot() + ", Task ID: " + this.f1569a.getActivity().getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    Intent intentM585a = HomeActivity.m585a(GlobalApplication.m3260b(), true);
                    intentM585a.setFlags(67108864);
                    intentM585a.putExtra("callChatList", true);
                    intentM585a.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                    intentM585a.putExtra("receivers", new String[]{this.f1569a.f1275e.m2354a()});
                    intentM585a.putExtra("specialbuddy", true);
                    this.f1569a.startActivity(intentM585a);
                    break;
                case R.id.profile_spcial_buddy_see_more_btn /* 2131494042 */:
                    C1786r.m6063c("profile_spcial_buddy_see_more_btn, isTaskRoot: " + this.f1569a.getActivity().isTaskRoot() + ", Task ID: " + this.f1569a.getActivity().getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    break;
                case R.id.profile_special_is_favorite /* 2131494048 */:
                    ContentValues contentValues = new ContentValues();
                    if (!this.f1569a.f1286p.isChecked()) {
                        if (this.f1569a.f1280j <= 0) {
                            this.f1569a.f1280j = 0;
                        } else {
                            SpecialBuddyProfileFragment.m2278b(this.f1569a, 1);
                        }
                        toString();
                        contentValues.put("likecount", String.valueOf(this.f1569a.f1280j));
                        contentValues.put("islike", "N");
                        this.f1569a.f1274d.startUpdate(2, null, C0704s.f2647a, contentValues, "buddy_no='" + this.f1569a.f1275e.m2354a() + "'", null);
                        new C0633e(this.f1569a.f1273c).m2880e(this.f1569a.f1278h);
                        toString();
                        this.f1569a.f1292v.setText(String.valueOf(this.f1569a.f1280j));
                        this.f1569a.f1292v.setTextColor(Color.rgb(0, 0, 0));
                        this.f1569a.f1276f.show();
                        break;
                    } else {
                        SpecialBuddyProfileFragment.m2273a(this.f1569a, 1);
                        toString();
                        contentValues.put("likecount", String.valueOf(this.f1569a.f1280j));
                        contentValues.put("islike", "Y");
                        this.f1569a.f1274d.startUpdate(2, this.f1569a.f1275e, C0704s.f2647a, contentValues, "buddy_no='" + this.f1569a.f1275e.m2354a() + "'", null);
                        new C0633e(this.f1569a.f1273c).m2876d(this.f1569a.f1278h);
                        toString();
                        this.f1569a.f1292v.setText(String.valueOf(this.f1569a.f1280j));
                        this.f1569a.f1292v.setTextColor(Color.rgb(230, 95, 20));
                        this.f1569a.f1276f.show();
                        break;
                    }
            }
        }
    }
}
