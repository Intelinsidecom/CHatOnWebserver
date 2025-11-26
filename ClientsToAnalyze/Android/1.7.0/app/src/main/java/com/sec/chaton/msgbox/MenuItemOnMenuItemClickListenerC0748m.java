package com.sec.chaton.msgbox;

import android.content.Intent;
import android.database.Cursor;
import android.view.MenuItem;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0654g;
import java.util.ArrayList;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.m */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0748m implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2550a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f2551b;

    MenuItemOnMenuItemClickListenerC0748m(MsgboxFragment msgboxFragment, String str) {
        this.f2551b = msgboxFragment;
        this.f2550a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = GlobalApplication.m3100a().getContentResolver().query(C0654g.m2980a(this.f2551b.f2507m), new String[]{"participants_buddy_no"}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("participants_buddy_no")));
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        Intent intent = new Intent(this.f2551b.getActivity(), (Class<?>) BuddyActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 6);
        String str = this.f2551b.f2509o;
        intent.putExtra(ChatFragment.f1734g, true);
        intent.putExtra(ChatFragment.f1731d, str);
        intent.putExtra("inboxNO", this.f2551b.f2507m);
        intent.putExtra("chatType", this.f2551b.f2511q.m3012a());
        intent.putExtra("buddyNO", this.f2550a);
        intent.putExtra("inboxValid", true);
        intent.putExtra(ChatFragment.f1730c, (String[]) arrayList.toArray(new String[arrayList.size()]));
        this.f2551b.startActivityForResult(intent, 2);
        return true;
    }
}
