package com.sec.chaton.msgbox;

import android.content.Intent;
import android.database.Cursor;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0701p;
import java.util.ArrayList;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.t */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0864t implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f3189a;

    /* renamed from: b */
    final /* synthetic */ boolean f3190b;

    /* renamed from: c */
    final /* synthetic */ MsgboxFragment f3191c;

    MenuItemOnMenuItemClickListenerC0864t(MsgboxFragment msgboxFragment, String str, boolean z) {
        this.f3191c = msgboxFragment;
        this.f3189a = str;
        this.f3190b = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0701p.m3164a(this.f3191c.f3120n), new String[]{"participants_buddy_no"}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("participants_buddy_no")));
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        Intent intent = new Intent(this.f3191c.getActivity(), (Class<?>) BuddyActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 6);
        String str = this.f3191c.f3122p;
        intent.putExtra(ChatFragment.f1753i, true);
        intent.putExtra(ChatFragment.f1750f, str);
        intent.putExtra("inboxNO", this.f3191c.f3120n);
        intent.putExtra("chatType", this.f3191c.f3124r.m3146a());
        intent.putExtra("buddyNO", this.f3189a);
        intent.putExtra("inboxValid", true);
        intent.putExtra(ChatFragment.f1749e, (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra(ChatFragment.f1758n, this.f3190b);
        if (GlobalApplication.m3265f()) {
            ((BaseActivity) this.f3191c.getActivity()).mo1830a(intent);
        } else {
            this.f3191c.startActivityForResult(intent, 2);
        }
        return true;
    }
}
