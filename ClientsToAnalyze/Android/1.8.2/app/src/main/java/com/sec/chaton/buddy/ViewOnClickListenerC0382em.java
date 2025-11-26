package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.coolots.C0529i;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: GroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.em */
/* loaded from: classes.dex */
class ViewOnClickListenerC0382em implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GroupProfileFragment f1540a;

    ViewOnClickListenerC0382em(GroupProfileFragment groupProfileFragment) {
        this.f1540a = groupProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.group_profile_chat /* 2131493313 */:
                if (this.f1540a.f1220i.length > 0 && this.f1540a.f1220i.length + 1 <= 199) {
                    Intent intentM585a = HomeActivity.m585a(this.f1540a.f1217f, true);
                    if (this.f1540a.f1220i.length == 1) {
                        intentM585a.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                    } else {
                        intentM585a.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                    }
                    intentM585a.putExtra("receivers", this.f1540a.f1220i);
                    intentM585a.putExtra("ACTION_PURPOSE_ARG1", this.f1540a.f1230s);
                    this.f1540a.startActivity(intentM585a);
                    break;
                } else {
                    Toast.makeText(this.f1540a.f1217f, String.format(this.f1540a.getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 198), 0).show();
                    break;
                }
                break;
            case R.id.group_profile_broadcast /* 2131493314 */:
                C1786r.m6061b("BuddyChatInfoActivity profile_broadcast", GroupProfileFragment.f1212a);
                if (this.f1540a.f1220i.length > 0 && this.f1540a.f1220i.length <= 200) {
                    Intent intentM585a2 = HomeActivity.m585a(this.f1540a.f1217f, true);
                    intentM585a2.putExtra("chatType", EnumC0695j.BROADCAST.m3146a());
                    intentM585a2.putExtra("receivers", this.f1540a.f1220i);
                    this.f1540a.startActivity(intentM585a2);
                    break;
                } else {
                    Toast.makeText(this.f1540a.f1217f, String.format(this.f1540a.getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
                    break;
                }
                break;
            case R.id.group_profile_call /* 2131493315 */:
                C1786r.m6061b("BuddyChatInfoActivity profile_call", GroupProfileFragment.f1212a);
                if (this.f1540a.f1220i.length > 0) {
                    int i = C1789u.m6075a().getInt("group_voice_call_max_count", 4);
                    if (this.f1540a.f1220i.length <= i - 1) {
                        if (!new C0529i(this.f1540a.f1217f, new C0383en(this), this.f1540a.f1220i, true).m2698a()) {
                            Toast.makeText(this.f1540a.f1217f, "Install Coolots app first.", 0).show();
                            break;
                        }
                    } else {
                        Toast.makeText(this.f1540a.f1217f, this.f1540a.getResources().getString(R.string.call_toast_failed_exceed, Integer.valueOf(i)), 0).show();
                        break;
                    }
                }
                break;
            case R.id.group_profile_video_call /* 2131493316 */:
                C1786r.m6061b("BuddyChatInfoActivity Video_Call", GroupProfileFragment.f1212a);
                if (this.f1540a.f1220i.length > 0) {
                    int i2 = C1789u.m6075a().getInt("group_video_call_max_count", 4);
                    if (this.f1540a.f1220i.length <= i2 - 1) {
                        if (!new C0529i(this.f1540a.f1217f, new C0384eo(this), this.f1540a.f1220i, false).m2698a()) {
                            Toast.makeText(this.f1540a.f1217f, "Install Coolots app first.", 0).show();
                            break;
                        }
                    } else {
                        Toast.makeText(this.f1540a.f1217f, this.f1540a.getResources().getString(R.string.call_toast_failed_exceed, Integer.valueOf(i2)), 0).show();
                        break;
                    }
                }
                break;
            case R.id.btnDone /* 2131493682 */:
                this.f1540a.m2232a();
                break;
        }
    }
}
