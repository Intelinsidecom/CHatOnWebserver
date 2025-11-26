package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.util.C1739av;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;

/* compiled from: SpecialBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.fg */
/* loaded from: classes.dex */
class ViewOnClickListenerC0403fg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyActivity f1562a;

    ViewOnClickListenerC0403fg(SpecialBuddyActivity specialBuddyActivity) {
        this.f1562a = specialBuddyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1739av.m5927a()) {
            int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
            switch (view.getId()) {
                case R.id.new_buddy_add /* 2131493187 */:
                    if (Build.VERSION.SDK_INT >= 11) {
                        this.f1562a.m2251b();
                        break;
                    } else {
                        this.f1562a.m2272a();
                        break;
                    }
                case R.id.new_buddy_block /* 2131493188 */:
                    if (Build.VERSION.SDK_INT < 11) {
                        this.f1562a.m2251b();
                        break;
                    } else {
                        this.f1562a.m2272a();
                        break;
                    }
                case R.id.new_buddy_unblock /* 2131493189 */:
                    if (Build.VERSION.SDK_INT < 11) {
                        this.f1562a.m2255c();
                        break;
                    } else {
                        this.f1562a.finish();
                        break;
                    }
                case R.id.new_buddy_cancel /* 2131493190 */:
                    if (Build.VERSION.SDK_INT >= 11) {
                        this.f1562a.m2255c();
                        break;
                    } else {
                        this.f1562a.finish();
                        break;
                    }
                case R.id.profile_add_special_buddy /* 2131494034 */:
                    C1786r.m6063c("profile_add_special_buddy, isTaskRoot: " + this.f1562a.isTaskRoot() + ", Task ID: " + this.f1562a.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    if (-3 == iM3420a || -2 == iM3420a) {
                        C2153y.m7535a(this.f1562a.f1254l, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else {
                        this.f1562a.m2272a();
                        this.f1562a.f1253k.show();
                        break;
                    }
                    break;
                case R.id.profile_special_chat /* 2131494035 */:
                    C1786r.m6063c("profile_special_chat, isTaskRoot: " + this.f1562a.isTaskRoot() + ", Task ID: " + this.f1562a.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    Intent intentM585a = HomeActivity.m585a(GlobalApplication.m3260b(), true);
                    intentM585a.setFlags(67108864);
                    intentM585a.putExtra("callChatList", true);
                    intentM585a.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                    intentM585a.putExtra("receivers", new String[]{this.f1562a.f1251i.m2354a()});
                    intentM585a.putExtra("specialbuddy", true);
                    this.f1562a.startActivity(intentM585a);
                    this.f1562a.finish();
                    break;
                case R.id.profile_spcial_buddy_see_more_btn /* 2131494042 */:
                    C1786r.m6063c("profile_spcial_buddy_see_more_btn, isTaskRoot: " + this.f1562a.isTaskRoot() + ", Task ID: " + this.f1562a.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    break;
                case R.id.profile_special_is_favorite /* 2131494048 */:
                    ContentValues contentValues = new ContentValues();
                    if (!this.f1562a.f1263u.isChecked()) {
                        if (this.f1562a.f1257o <= 0) {
                            this.f1562a.f1257o = 0;
                        } else {
                            SpecialBuddyActivity.m2249b(this.f1562a, 1);
                        }
                        toString();
                        contentValues.put("likecount", String.valueOf(this.f1562a.f1257o));
                        contentValues.put("islike", "N");
                        this.f1562a.f1250e.startUpdate(2, null, C0704s.f2647a, contentValues, "buddy_no='" + this.f1562a.f1251i.m2354a() + "'", null);
                        new C0633e(this.f1562a.f1249d).m2880e(this.f1562a.f1255m);
                        TextView textView = this.f1562a.f1235A;
                        toString();
                        textView.setText(String.valueOf(this.f1562a.f1257o));
                        this.f1562a.f1235A.setTextColor(Color.rgb(0, 0, 0));
                        this.f1562a.f1253k.show();
                        break;
                    } else {
                        SpecialBuddyActivity.m2244a(this.f1562a, 1);
                        toString();
                        contentValues.put("likecount", String.valueOf(this.f1562a.f1257o));
                        contentValues.put("islike", "Y");
                        this.f1562a.f1250e.startUpdate(2, this.f1562a.f1251i, C0704s.f2647a, contentValues, "buddy_no='" + this.f1562a.f1251i.m2354a() + "'", null);
                        new C0633e(this.f1562a.f1249d).m2876d(this.f1562a.f1255m);
                        TextView textView2 = this.f1562a.f1235A;
                        toString();
                        textView2.setText(String.valueOf(this.f1562a.f1257o));
                        this.f1562a.f1235A.setTextColor(Color.rgb(230, 95, 20));
                        this.f1562a.f1253k.show();
                        break;
                    }
            }
        }
    }
}
