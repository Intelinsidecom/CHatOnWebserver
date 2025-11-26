package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.GroupDialog;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.global.GlobalApplication;
import java.util.Iterator;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.am */
/* loaded from: classes.dex */
class ViewOnClickListenerC0528am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0522ag f2473a;

    ViewOnClickListenerC0528am(C0522ag c0522ag) {
        this.f2473a = c0522ag;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0513c c0513c = (C0513c) view.getTag();
        if (c0513c.m3975b().equals(this.f2473a.f2443f.getResources().getString(R.string.setting_interaction_me))) {
            Intent intent = new Intent(this.f2473a.f2443f, (Class<?>) MeDialog.class);
            intent.putExtra("ME_DIALOG_NAME", c0513c.m3976c());
            intent.putExtra("ME_DIALOG_STATUSMSG", c0513c.m3977d());
            this.f2473a.f2443f.startActivity(intent);
            return;
        }
        if (c0513c.m3975b().startsWith("0999")) {
            if (GlobalApplication.m6456e()) {
                Intent intent2 = new Intent(this.f2473a.f2443f, (Class<?>) SpecialBuddyActivity.class);
                intent2.putExtra("specialuserid", c0513c.m3975b());
                intent2.putExtra("speicalusername", c0513c.m3976c());
                intent2.putExtra("specialBuddyAdded", true);
                this.f2473a.f2443f.startActivity(intent2);
                return;
            }
            Intent intent3 = new Intent(this.f2473a.f2443f, (Class<?>) SpecialBuddyDialog.class);
            intent3.putExtra("specialuserid", c0513c.m3975b());
            intent3.putExtra("speicalusername", c0513c.m3976c());
            intent3.putExtra("specialBuddyAdded", true);
            this.f2473a.f2443f.startActivity(intent3);
            return;
        }
        if (c0513c.m3997x()) {
            Intent intent4 = new Intent(this.f2473a.f2443f, (Class<?>) GroupDialog.class);
            intent4.setFlags(67108864);
            intent4.putExtra("GROUP_DIALOG_GROUP_NAME", c0513c.m3976c());
            intent4.putExtra("GROUP_DIALOG_CHAT_RECEIVER", (String[]) c0513c.m3999z().keySet().toArray(new String[0]));
            Iterator<String> it = c0513c.m3999z().keySet().iterator();
            StringBuffer stringBuffer = new StringBuffer();
            while (it.hasNext()) {
                stringBuffer.append(c0513c.m3999z().get(it.next()) + ", ");
            }
            String string = stringBuffer.toString();
            if (string.endsWith(", ")) {
                string = string.substring(0, string.length() - 2);
            }
            intent4.putExtra("GROUP_DIALOG_GROUP_MEMBERS", string);
            intent4.putExtra("GROUP_DIALOG_GROUP_ID", c0513c.m3975b());
            this.f2473a.f2443f.startActivity(intent4);
            return;
        }
        if (GlobalApplication.m6456e()) {
            Intent intent5 = new Intent(this.f2473a.f2443f, (Class<?>) BuddyProfileActivity.class);
            intent5.putExtra("PROFILE_BUDDY_NO", c0513c.m3975b());
            intent5.putExtra("PROFILE_BUDDY_NAME", c0513c.m3976c());
            intent5.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
            this.f2473a.f2443f.startActivity(intent5);
            return;
        }
        Intent intent6 = new Intent(this.f2473a.f2443f, (Class<?>) BuddyDialog.class);
        intent6.putExtra("BUDDY_DIALOG_BUDDY_NO", c0513c.m3975b());
        intent6.putExtra("BUDDY_DIALOG_BUDDY_NAME", c0513c.m3976c());
        intent6.setFlags(268435456);
        this.f2473a.f2443f.startActivity(intent6);
    }
}
