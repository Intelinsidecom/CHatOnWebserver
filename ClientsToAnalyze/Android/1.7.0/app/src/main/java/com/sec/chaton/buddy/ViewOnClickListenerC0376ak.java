package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1341p;

/* compiled from: BuddyGroupProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC0376ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileActivity f1344a;

    ViewOnClickListenerC0376ak(BuddyGroupProfileActivity buddyGroupProfileActivity) {
        this.f1344a = buddyGroupProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.group_profile_start_chat /* 2131427515 */:
                if (this.f1344a.f1193s > 0) {
                    C1341p.m4663f("mGroupInfo.getId(): " + this.f1344a.f1181f.m2347a(), BuddyGroupProfileActivity.f1176a);
                    Intent intent = new Intent(this.f1344a.f1183i, (Class<?>) ChatActivity.class);
                    intent.setFlags(67108864);
                    intent.putExtra("chatType", EnumC0665r.GROUPCHAT.m3012a());
                    intent.putExtra("receivers", this.f1344a.m2222a().m2205g());
                    intent.putExtra("groupId", String.valueOf(this.f1344a.f1181f.m2347a()));
                    this.f1344a.startActivity(intent);
                    this.f1344a.finish();
                    break;
                }
                break;
            case R.id.group_profile_broadcast /* 2131427516 */:
                if (this.f1344a.f1193s > 0) {
                    C1341p.m4663f("mGroupInfo.getId(): " + this.f1344a.f1181f.m2347a(), BuddyGroupProfileActivity.f1176a);
                    Intent intent2 = new Intent(this.f1344a.f1183i, (Class<?>) ChatActivity.class);
                    intent2.setFlags(67108864);
                    intent2.putExtra("chatType", EnumC0665r.BROADCAST.m3012a());
                    intent2.putExtra("receivers", this.f1344a.m2222a().m2205g());
                    intent2.putExtra("groupId", String.valueOf(this.f1344a.f1181f.m2347a()));
                    this.f1344a.startActivity(intent2);
                    this.f1344a.finish();
                    break;
                }
                break;
            case R.id.group_profile_call /* 2131427517 */:
            case R.id.group_profile_videocall /* 2131427518 */:
                Intent intent3 = new Intent(this.f1344a.f1183i, (Class<?>) BuddyActivity2.class);
                intent3.putExtra("ACTIVITY_PURPOSE", view.getId() == R.id.group_profile_call ? 14 : 15);
                intent3.putExtra("range", 2);
                intent3.putExtra("groupInfo", this.f1344a.f1181f);
                this.f1344a.startActivity(intent3);
                break;
            case R.id.header_button1 /* 2131427690 */:
                if (!this.f1344a.f1194t) {
                    this.f1344a.f1182g.m5919a(view);
                    break;
                } else {
                    view.setEnabled(false);
                    this.f1344a.m2229c();
                    break;
                }
        }
    }
}
