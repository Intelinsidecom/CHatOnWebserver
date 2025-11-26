package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.view.View;
import java.net.URL;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ct */
/* loaded from: classes.dex */
class ViewOnClickListenerC1419ct implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1418cs f5298a;

    ViewOnClickListenerC1419ct(C1418cs c1418cs) {
        this.f5298a = c1418cs;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String unused = TellFriendsWeiboActivity.f5047C = ((C1417cr) this.f5298a.f5295c.get(((Integer) view.getTag()).intValue())).f5289d;
        URL unused2 = TellFriendsWeiboActivity.f5048D = ((C1417cr) this.f5298a.f5295c.get(((Integer) view.getTag()).intValue())).f5290e;
        this.f5298a.f5297e.f5055H = ((C1417cr) this.f5298a.f5295c.get(((Integer) view.getTag()).intValue())).f5286a;
        if (TellFriendsWeiboActivity.f5047C != null && TellFriendsWeiboActivity.f5048D != null && this.f5298a.f5297e.f5055H != 0) {
            Intent intent = new Intent(this.f5298a.f5297e.f5065k, (Class<?>) WeiboMessageActivity.class);
            intent.putExtra("following_uid", String.valueOf(this.f5298a.f5297e.f5055H));
            intent.putExtra("following_name", TellFriendsWeiboActivity.f5047C);
            this.f5298a.f5297e.startActivity(intent);
        }
    }
}
