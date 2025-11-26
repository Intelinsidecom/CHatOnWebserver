package com.sec.chaton.settings.tellfriends;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0633e;
import java.util.ArrayList;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC1352ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5169a;

    ViewOnClickListenerC1352ag(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity) {
        this.f5169a = snsFriendsUsingChatOnActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_all /* 2131493862 */:
                if (this.f5169a.f4991i.size() > 0) {
                    this.f5169a.m4855i();
                    this.f5169a.f4987e.setMessage(this.f5169a.getResources().getString(R.string.wait_sending));
                    C0633e c0633e = new C0633e(this.f5169a.f4983B);
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.f5169a.f4991i.size()) {
                            arrayList.add(((C1342a) this.f5169a.f4991i.get(i2)).m5069c());
                            i = i2 + 1;
                        } else {
                            c0633e.m2864a(arrayList, true);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
