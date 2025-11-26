package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyGroupListItem;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.control.BlockControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONShortcutUtil;
import com.sec.chaton.util.ChatOnGraphics;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.sec.chaton.buddy.bd */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0107bd implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f650a;

    MenuItemOnMenuItemClickListenerC0107bd(BuddyFragment buddyFragment) {
        this.f650a = buddyFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Bitmap bitmap;
        ExpandableListView.ExpandableListContextMenuInfo expandableListContextMenuInfo = (ExpandableListView.ExpandableListContextMenuInfo) menuItem.getMenuInfo();
        if (ExpandableListView.getPackedPositionType(expandableListContextMenuInfo.packedPosition) != 1) {
            return false;
        }
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListContextMenuInfo.packedPosition);
        int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListContextMenuInfo.packedPosition);
        switch (menuItem.getItemId()) {
            case 101:
                Intent intent = new Intent(this.f650a.f453i, (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", ((BuddyItem) ((ArrayList) this.f650a.f425P.get(packedPositionGroup)).get(packedPositionChild)).m668a());
                intent.putExtra("PROFILE_BUDDY_NAME", ((BuddyItem) ((ArrayList) this.f650a.f425P.get(packedPositionGroup)).get(packedPositionChild)).m673b());
                this.f650a.startActivity(intent);
                break;
            case 102:
                this.f650a.f431V.m532a((BuddyItem) ((ArrayList) this.f650a.f425P.get(packedPositionGroup)).get(packedPositionChild));
                break;
            case 103:
                this.f650a.f431V.m535b((BuddyItem) ((ArrayList) this.f650a.f425P.get(packedPositionGroup)).get(packedPositionChild));
                break;
            case 104:
                this.f650a.f428S = (BuddyItem) ((ArrayList) this.f650a.f425P.get(packedPositionGroup)).get(packedPositionChild);
                this.f650a.f435Z = ProgressDialog.show(this.f650a.f453i, null, this.f650a.getResources().getString(C0062R.string.buddy_list_progress_dialog_message), true);
                new BlockControl(this.f650a.f448d).m1991a(this.f650a.f428S.m668a(), 1);
                break;
            case 105:
                ChatONLogWriter.m3508c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT start, Memory Address:" + this, this.f650a.getClass().getSimpleName());
                this.f650a.f428S = (BuddyItem) ((ArrayList) this.f650a.f425P.get(packedPositionGroup)).get(packedPositionChild);
                Intent intentM3525a = ChatONShortcutUtil.m3525a(this.f650a.getActivity(), this.f650a.f428S.m668a(), ChatONContract.InBoxTable.ChatType.ONETOONE);
                try {
                    bitmap = ((BitmapDrawable) this.f650a.f429T.getDrawable()).getBitmap();
                } catch (Exception e) {
                    bitmap = null;
                }
                ChatONShortcutUtil.m3526a(this.f650a.getActivity(), intentM3525a, this.f650a.f428S.m673b(), Bitmap.createScaledBitmap(ChatOnGraphics.m3527a(this.f650a.getActivity(), bitmap), ChatONShortcutUtil.m3524a(this.f650a.getResources().getDisplayMetrics().density), ChatONShortcutUtil.m3524a(this.f650a.getResources().getDisplayMetrics().density), true));
                ChatONLogWriter.m3508c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT end, Memory Address:" + this, this.f650a.getClass().getSimpleName());
                break;
            case 111:
                this.f650a.f428S = (BuddyItem) ((ArrayList) this.f650a.f425P.get(packedPositionGroup)).get(packedPositionChild);
                new AlertDialog.Builder(this.f650a.f453i).setTitle(this.f650a.getResources().getString(C0062R.string.buddy_group_list_dialog_removegroup_title)).setMessage(this.f650a.getResources().getString(C0062R.string.buddy_group_list_dialog_removegroup_message)).setPositiveButton(this.f650a.getResources().getString(C0062R.string.dialog_ok), new DialogInterfaceOnClickListenerC0091ao(this)).setNegativeButton(this.f650a.getResources().getString(C0062R.string.cancel), (DialogInterface.OnClickListener) null).show();
                break;
            case 112:
                this.f650a.f428S = (BuddyItem) ((ArrayList) this.f650a.f425P.get(packedPositionGroup)).get(packedPositionChild);
                HashMap mapM698w = this.f650a.f428S.m698w();
                BuddyGroupListItem buddyGroupListItem = new BuddyGroupListItem(Integer.parseInt(this.f650a.f428S.m668a()), this.f650a.f428S.m673b(), mapM698w == null ? 0 : mapM698w.size(), 2);
                Intent intent2 = new Intent(this.f650a.f453i, (Class<?>) BuddyGroupEditActivity.class);
                intent2.putExtra("ACTIVITY_PURPOSE", 1);
                intent2.putExtra("ACTIVITY_PURPOSE_ARG1", buddyGroupListItem);
                this.f650a.startActivity(intent2);
                break;
        }
        return true;
    }
}
