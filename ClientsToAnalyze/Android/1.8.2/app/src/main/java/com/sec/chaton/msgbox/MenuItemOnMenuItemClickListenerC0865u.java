package com.sec.chaton.msgbox;

import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyChatInfoActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0701p;
import com.sec.chaton.specialbuddy.SpecialBuddyInfo;
import java.util.ArrayList;
import twitter4j.MediaEntity;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.u */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0865u implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f3192a;

    /* renamed from: b */
    final /* synthetic */ String f3193b;

    /* renamed from: c */
    final /* synthetic */ boolean f3194c;

    /* renamed from: d */
    final /* synthetic */ MsgboxFragment f3195d;

    MenuItemOnMenuItemClickListenerC0865u(MsgboxFragment msgboxFragment, String str, String str2, boolean z) {
        this.f3195d = msgboxFragment;
        this.f3192a = str;
        this.f3193b = str2;
        this.f3194c = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (!TextUtils.isEmpty(this.f3192a) && this.f3192a.startsWith("0999")) {
            Intent intent = new Intent(this.f3195d.getActivity(), (Class<?>) SpecialBuddyInfo.class);
            intent.putExtra("buddy_no", this.f3192a);
            intent.putExtra("buddy_name", this.f3193b);
            intent.putExtra("inbox_no", this.f3195d.f3120n);
            this.f3195d.startActivityForResult(intent, 2);
        } else {
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0701p.m3164a(this.f3195d.f3120n), new String[]{"participants_buddy_no"}, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("participants_buddy_no")));
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            Intent intent2 = new Intent(this.f3195d.getActivity(), (Class<?>) BuddyChatInfoActivity.class);
            intent2.putExtra("ACTIVITY_PURPOSE", 6);
            String str = this.f3195d.f3122p;
            intent2.putExtra(ChatFragment.f1753i, true);
            intent2.putExtra(ChatFragment.f1750f, str);
            intent2.putExtra("inboxNO", this.f3195d.f3120n);
            intent2.putExtra("chatType", this.f3195d.f3124r.m3146a());
            intent2.putExtra(ChatFragment.f1755k, false);
            intent2.putExtra(ChatFragment.f1758n, this.f3194c);
            intent2.putExtra(ChatFragment.f1749e, (String[]) arrayList.toArray(new String[arrayList.size()]));
            intent2.putExtra("ACTIVITY_TYPE", MediaEntity.Size.CROP);
            ((BaseActivity) this.f3195d.getActivity()).mo1830a(intent2);
        }
        return true;
    }
}
