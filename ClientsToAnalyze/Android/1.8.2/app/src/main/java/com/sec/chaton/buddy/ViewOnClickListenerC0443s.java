package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0256b;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import java.util.HashMap;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC0443s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0442r f1692a;

    ViewOnClickListenerC0443s(C0442r c0442r) {
        this.f1692a = c0442r;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0257c c0257c = (C0257c) view.getTag();
        if (!c0257c.m2318a().equals(this.f1692a.f1671f.getResources().getString(R.string.setting_interaction_me))) {
            if (c0257c.m2318a().startsWith("0999")) {
                Intent intent = new Intent(this.f1692a.f1671f, (Class<?>) SpecialBuddyActivity.class);
                intent.putExtra("specialuserid", c0257c.m2318a());
                intent.putExtra("specialBuddyAdded", true);
                this.f1692a.f1671f.startActivity(intent);
                return;
            }
            if (c0257c.m2350v()) {
                if (GlobalApplication.m3265f()) {
                    String[] strArr = null;
                    if (c0257c.m2351w() != null) {
                        strArr = (String[]) c0257c.m2351w().keySet().toArray(new String[0]);
                    }
                    Intent intent2 = new Intent(this.f1692a.f1671f, (Class<?>) GroupProfileActivity.class);
                    intent2.putExtra("ACTIVITY_PURPOSE", 6);
                    intent2.putExtra("ACTIVITY_PURPOSE_ARG", c0257c.m2318a());
                    intent2.putExtra("BUDDY_SORT_STYLE", 11);
                    intent2.putExtra("group profile", "GROUP PROFILE");
                    intent2.putExtra("ACTION_PURPOSE_ARG1", c0257c.m2324b());
                    intent2.putExtra("ACTION_PURPOSE_ARG2", strArr);
                    intent2.putExtra(ChatFragment.f1749e, strArr);
                    this.f1692a.f1687v.startActivityForResult(intent2, 6);
                    return;
                }
                HashMap mapM2351w = c0257c.m2351w();
                C0256b c0256b = new C0256b(Integer.parseInt(c0257c.m2318a()), c0257c.m2324b(), mapM2351w == null ? 0 : mapM2351w.size(), 2);
                Intent intent3 = new Intent(this.f1692a.f1671f, (Class<?>) BuddyGroupEditActivity.class);
                intent3.putExtra("ACTIVITY_PURPOSE", 1);
                intent3.putExtra("ACTIVITY_PURPOSE_ARG1", c0256b);
                this.f1692a.f1671f.startActivity(intent3);
                return;
            }
            Intent intent4 = new Intent(this.f1692a.f1671f, (Class<?>) BuddyProfileActivity.class);
            intent4.putExtra("PROFILE_BUDDY_NO", c0257c.m2318a());
            intent4.putExtra("PROFILE_BUDDY_NAME", c0257c.m2324b());
            intent4.setFlags(268435456);
            this.f1692a.f1671f.startActivity(intent4);
        }
    }
}
