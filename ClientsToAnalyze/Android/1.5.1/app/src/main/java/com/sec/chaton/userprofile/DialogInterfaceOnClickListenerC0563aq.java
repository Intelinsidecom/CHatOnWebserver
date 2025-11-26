package com.sec.chaton.userprofile;

import android.content.ContentValues;
import android.content.DialogInterface;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.userprofile.aq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0563aq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0594r f3542a;

    DialogInterfaceOnClickListenerC0563aq(ViewOnClickListenerC0594r viewOnClickListenerC0594r) {
        this.f3542a = viewOnClickListenerC0594r;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_relation_hide", "Y");
        RelationshipRank2.f3368d.startUpdate(0, null, ChatONContract.BuddyTable.f1713a, contentValues, "buddy_no = ? ", new String[]{((BuddyItem) this.f3542a.f3593b.getItem(this.f3542a.f3592a)).m668a()});
    }
}
