package com.sec.chaton.buddy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0256b;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0681h;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1790v;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.widget.ProgressDialogC1806j;
import java.util.ArrayList;
import java.util.HashMap;
import twitter4j.MediaEntity;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.al */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0270al implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1365a;

    MenuItemOnMenuItemClickListenerC0270al(BuddyFragment buddyFragment) {
        this.f1365a = buddyFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Intent intentM6081a;
        Bitmap bitmap;
        C0257c c0257c = this.f1365a.f978ao;
        ExpandableListView.ExpandableListContextMenuInfo expandableListContextMenuInfo = (ExpandableListView.ExpandableListContextMenuInfo) menuItem.getMenuInfo();
        if (ExpandableListView.getPackedPositionType(expandableListContextMenuInfo.packedPosition) != 1) {
            return false;
        }
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListContextMenuInfo.packedPosition);
        int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListContextMenuInfo.packedPosition);
        switch (menuItem.getItemId()) {
            case MediaEntity.Size.CROP /* 101 */:
                if (c0257c.m2318a().startsWith("0999")) {
                    Intent intent = new Intent(this.f1365a.getActivity(), (Class<?>) SpecialBuddyActivity.class);
                    intent.putExtra("specialuserid", c0257c.m2318a());
                    intent.putExtra("specialBuddyAdded", true);
                    this.f1365a.startActivity(intent);
                    break;
                } else {
                    Intent intent2 = new Intent(this.f1365a.f1018t, (Class<?>) BuddyProfileActivity.class);
                    intent2.putExtra("PROFILE_BUDDY_NO", ((C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild)).m2318a());
                    intent2.putExtra("PROFILE_BUDDY_NAME", ((C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild)).m2324b());
                    this.f1365a.startActivityForResult(intent2, 11);
                    break;
                }
            case 102:
                this.f1365a.f981ar.m2372a((C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild));
                this.f1365a.m1950a(BuddyFragment.f909aZ, ((C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild)).m2318a());
                break;
            case 103:
                this.f1365a.f981ar.m2375b((C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild));
                this.f1365a.m1950a(BuddyFragment.f910ba, ((C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild)).m2318a());
                break;
            case 104:
                this.f1365a.f978ao = (C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild);
                this.f1365a.f989az = ProgressDialogC1806j.m6141a(this.f1365a.f1018t, null, this.f1365a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                new C0632d(this.f1365a.f1004f).m2847a(this.f1365a.f978ao.m2318a(), 1);
                this.f1365a.m1950a(BuddyFragment.f911bb, ((C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild)).m2318a());
                break;
            case 105:
                C1786r.m6063c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT start, Memory Address:" + this, this.f1365a.getClass().getSimpleName());
                this.f1365a.f978ao = (C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild);
                if (this.f1365a.f978ao.m2350v()) {
                    intentM6081a = C1790v.m6081a(this.f1365a.getActivity(), this.f1365a.f978ao.m2318a(), EnumC0695j.GROUPCHAT);
                    intentM6081a.putExtra("receivers", (String[]) this.f1365a.f978ao.m2351w().keySet().toArray(new String[0]));
                    intentM6081a.putExtra("shortcut_from_buddy_screen", "shortcut_from_buddy_screen");
                } else {
                    intentM6081a = C1790v.m6081a(this.f1365a.getActivity(), this.f1365a.f978ao.m2318a(), EnumC0695j.ONETOONE);
                }
                try {
                    bitmap = ((BitmapDrawable) this.f1365a.f979ap.getDrawable()).getBitmap();
                } catch (Exception e) {
                    bitmap = null;
                }
                C1790v.m6082a(this.f1365a.getActivity(), intentM6081a, this.f1365a.f978ao.m2324b(), Bitmap.createScaledBitmap(C1791w.m6085a(this.f1365a.getActivity(), bitmap), C1790v.m6080a(this.f1365a.getResources().getDisplayMetrics().density), C1790v.m6080a(this.f1365a.getResources().getDisplayMetrics().density), true));
                C1786r.m6063c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT end, Memory Address:" + this, this.f1365a.getClass().getSimpleName());
                break;
            case 111:
                this.f1365a.f978ao = (C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild);
                C0668l.m3077a(new C0668l(), 4, new C0681h(this.f1365a.f1005g, Integer.parseInt(this.f1365a.f978ao.m2318a())));
                break;
            case 112:
                this.f1365a.f978ao = (C0257c) ((ArrayList) this.f1365a.f975al.get(packedPositionGroup)).get(packedPositionChild);
                if (GlobalApplication.m3265f()) {
                    String[] strArr = this.f1365a.f978ao.m2351w() != null ? (String[]) this.f1365a.f978ao.m2351w().keySet().toArray(new String[0]) : null;
                    Intent intent3 = new Intent(this.f1365a.f1018t, (Class<?>) GroupProfileActivity.class);
                    intent3.putExtra("ACTIVITY_PURPOSE", 6);
                    intent3.putExtra("ACTIVITY_PURPOSE_ARG", this.f1365a.f978ao.m2318a());
                    intent3.putExtra("BUDDY_SORT_STYLE", 11);
                    intent3.putExtra("group profile", "GROUP PROFILE");
                    intent3.putExtra("ACTION_PURPOSE_ARG1", this.f1365a.f978ao.m2324b());
                    intent3.putExtra("ACTION_PURPOSE_ARG2", strArr);
                    intent3.putExtra("ACTION_PURPOSE_ARG2", strArr);
                    intent3.putExtra(ChatFragment.f1749e, strArr);
                    this.f1365a.startActivityForResult(intent3, 6);
                    break;
                } else {
                    HashMap mapM2351w = this.f1365a.f978ao.m2351w();
                    C0256b c0256b = new C0256b(Integer.parseInt(this.f1365a.f978ao.m2318a()), this.f1365a.f978ao.m2324b(), mapM2351w == null ? 0 : mapM2351w.size(), 2);
                    Intent intent4 = new Intent(this.f1365a.f1018t, (Class<?>) BuddyGroupEditActivity.class);
                    intent4.putExtra("ACTIVITY_PURPOSE", 1);
                    intent4.putExtra("ACTIVITY_PURPOSE_ARG1", c0256b);
                    this.f1365a.startActivity(intent4);
                    break;
                }
            case 113:
                this.f1365a.f981ar.m2378c(c0257c);
                break;
            case 114:
                this.f1365a.f981ar.m2380d(c0257c);
                break;
        }
        return true;
    }
}
