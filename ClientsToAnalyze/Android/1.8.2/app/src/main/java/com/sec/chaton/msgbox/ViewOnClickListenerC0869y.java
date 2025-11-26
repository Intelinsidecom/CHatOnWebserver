package com.sec.chaton.msgbox;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyActivity2;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.y */
/* loaded from: classes.dex */
class ViewOnClickListenerC0869y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f3201a;

    ViewOnClickListenerC0869y(MsgboxFragment msgboxFragment) {
        this.f3201a = msgboxFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel /* 2131493037 */:
                this.f3201a.getListView().setChoiceMode(0);
                this.f3201a.f3112f.setVisibility(8);
                this.f3201a.getListView().clearChoices();
                break;
            case R.id.btnLeave /* 2131493625 */:
                String[] strArrM3513h = this.f3201a.m3513h();
                if (strArrM3513h.length > 0) {
                    this.f3201a.m3504a(strArrM3513h);
                    break;
                }
                break;
            case R.id.button_start_chat /* 2131493627 */:
                Intent intent = new Intent(this.f3201a.getActivity(), (Class<?>) BuddyActivity2.class);
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                intent.putExtra("ACTION_PURPOSE", 4);
                this.f3201a.startActivity(intent);
                break;
            case R.id.button_broadcast /* 2131493628 */:
                Intent intent2 = new Intent(this.f3201a.getActivity(), (Class<?>) BuddyActivity2.class);
                intent2.putExtra("BUDDY_SORT_STYLE", 11);
                intent2.putExtra("ACTIVITY_PURPOSE", 3);
                intent2.putExtra("ACTION_PURPOSE", 5);
                this.f3201a.startActivity(intent2);
                break;
        }
    }
}
