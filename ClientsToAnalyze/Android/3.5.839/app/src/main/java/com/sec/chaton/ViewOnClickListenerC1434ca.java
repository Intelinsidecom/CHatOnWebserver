package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.specialbuddy.EnumC4549n;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.ca */
/* loaded from: classes.dex */
class ViewOnClickListenerC1434ca implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f5122a;

    ViewOnClickListenerC1434ca(PlusFragment plusFragment) {
        this.f5122a = plusFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1503cg c1503cg = (C1503cg) view.getTag();
        if (this.f5122a.f1994u != null) {
            this.f5122a.f1994u.moveToPosition(c1503cg.f5450d);
            String string = this.f5122a.f1994u.getString(this.f5122a.f1994u.getColumnIndex("id"));
            Intent intent = new Intent(this.f5122a.f1990q, (Class<?>) ChatActivity.class);
            intent.setFlags(67108864);
            intent.putExtra("callChatList", true);
            intent.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
            intent.putExtra("receivers", new String[]{string});
            intent.putExtra("specialbuddy", true);
            intent.putExtra("roomType", EnumC2301u.LIVE.m10212a());
            intent.putExtra("liveUserType", EnumC1109f.CONTENTS);
            intent.putExtra("liveServiceType", EnumC4549n.LIVECONTENTS.m17247a());
            intent.putExtra("fromLiveMain", true);
            this.f5122a.startActivity(intent);
        }
    }
}
