package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.GroupDialog;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.buddy.p050a.C1106c;
import java.util.Iterator;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ah */
/* loaded from: classes.dex */
class ViewOnClickListenerC1117ah implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1113ad f4326a;

    ViewOnClickListenerC1117ah(C1113ad c1113ad) {
        this.f4326a = c1113ad;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1106c c1106c = (C1106c) view.getTag();
        if (c1106c.m7046a().equals(this.f4326a.f4300g.getResources().getString(R.string.setting_interaction_me))) {
            Intent intent = new Intent(this.f4326a.f4300g, (Class<?>) MeDialog.class);
            intent.putExtra("ME_DIALOG_NAME", c1106c.m7051b());
            intent.putExtra("ME_DIALOG_STATUSMSG", c1106c.m7054c());
            this.f4326a.f4300g.startActivity(intent);
            return;
        }
        if (c1106c.m7046a().startsWith("0999")) {
            Intent intent2 = new Intent(this.f4326a.f4300g, (Class<?>) SpecialBuddyDialog.class);
            intent2.putExtra("specialuserid", c1106c.m7046a());
            intent2.putExtra("speicalusername", c1106c.m7051b());
            intent2.putExtra("specialBuddyAdded", true);
            this.f4326a.f4300g.startActivity(intent2);
            return;
        }
        if (c1106c.m7074w()) {
            Intent intent3 = new Intent(this.f4326a.f4300g, (Class<?>) GroupDialog.class);
            intent3.setFlags(67108864);
            intent3.putExtra("GROUP_DIALOG_GROUP_NAME", c1106c.m7051b());
            intent3.putExtra("GROUP_DIALOG_CHAT_RECEIVER", (String[]) c1106c.m7076y().keySet().toArray(new String[0]));
            Iterator<String> it = c1106c.m7076y().keySet().iterator();
            StringBuffer stringBuffer = new StringBuffer();
            while (it.hasNext()) {
                stringBuffer.append(c1106c.m7076y().get(it.next()) + ", ");
            }
            String string = stringBuffer.toString();
            if (string.endsWith(", ")) {
                string = string.substring(0, string.length() - 2);
            }
            intent3.putExtra("GROUP_DIALOG_GROUP_MEMBERS", string);
            intent3.putExtra("GROUP_DIALOG_GROUP_ID", c1106c.m7046a());
            this.f4326a.f4300g.startActivity(intent3);
            return;
        }
        Intent intent4 = new Intent(this.f4326a.f4300g, (Class<?>) BuddyDialog.class);
        intent4.putExtra("BUDDY_DIALOG_BUDDY_NO", c1106c.m7046a());
        intent4.putExtra("BUDDY_DIALOG_BUDDY_NAME", c1106c.m7051b());
        intent4.setFlags(268435456);
        this.f4326a.f4300g.startActivity(intent4);
    }
}
