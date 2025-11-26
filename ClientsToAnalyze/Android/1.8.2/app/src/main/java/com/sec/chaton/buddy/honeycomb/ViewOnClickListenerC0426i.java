package com.sec.chaton.buddy.honeycomb;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.coolots.C0529i;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1789u;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddySelectFragment.java */
/* renamed from: com.sec.chaton.buddy.honeycomb.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0426i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddySelectFragment f1642a;

    ViewOnClickListenerC0426i(BuddySelectFragment buddySelectFragment) {
        this.f1642a = buddySelectFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.buddy_select_group_chat) {
            if (this.f1642a.m2422c() > 0 && this.f1642a.m2422c() + 1 <= 199) {
                Intent intentM585a = HomeActivity.m585a((Context) this.f1642a.getActivity(), true);
                if (this.f1642a.m2422c() == 1) {
                    intentM585a.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                } else {
                    intentM585a.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                }
                intentM585a.putExtra("receivers", (String[]) this.f1642a.m2425d().toArray(new String[0]));
                this.f1642a.startActivity(intentM585a);
                return;
            }
            Toast.makeText(this.f1642a.f1590b, String.format(this.f1642a.getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 198), 0).show();
            return;
        }
        if (view.getId() == R.id.buddy_select_group_broadcast) {
            if (this.f1642a.m2422c() > 0 && this.f1642a.m2422c() <= 200) {
                Intent intentM585a2 = HomeActivity.m585a((Context) this.f1642a.getActivity(), true);
                intentM585a2.putExtra("chatType", EnumC0695j.BROADCAST.m3146a());
                intentM585a2.putExtra("receivers", (String[]) this.f1642a.m2425d().toArray(new String[0]));
                this.f1642a.startActivity(intentM585a2);
                return;
            }
            Toast.makeText(this.f1642a.f1590b, String.format(this.f1642a.getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
            return;
        }
        if (view.getId() == R.id.buddy_select_voice_call || view.getId() == R.id.buddy_select_video_call) {
            boolean z = view.getId() == R.id.buddy_select_voice_call;
            if (this.f1642a.m2422c() > 0) {
                int i = C1789u.m6075a().getInt(z ? "group_voice_call_max_count" : "group_video_call_max_count", 4);
                if (this.f1642a.m2422c() <= i - 1) {
                    if (!new C0529i(this.f1642a.getActivity(), new C0427j(this), (String[]) this.f1642a.m2425d().toArray(new String[0]), z).m2698a()) {
                        Toast.makeText(this.f1642a.getActivity(), "Install Coolots app first.", 0).show();
                        return;
                    }
                    return;
                }
                Toast.makeText(this.f1642a.f1590b, this.f1642a.getResources().getString(R.string.call_toast_failed_exceed, Integer.valueOf(i)), 0).show();
            }
        }
    }
}
