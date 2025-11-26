package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.BuddyGroupAddBuddyTask;
import com.sec.chaton.database.task.BuddyGroupAddTask;
import com.sec.chaton.database.task.BuddyGroupRemoveBuddyTask;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sec.chaton.buddy.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0116i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f661a;

    ViewOnClickListenerC0116i(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f661a = buddyGroupEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f661a.m584b();
        switch (view.getId()) {
            case C0062R.id.buddy_group_profile_rename_groupname /* 2131427502 */:
                view.setEnabled(false);
                this.f661a.m547a(this.f661a.f515m);
                String strReplace = this.f661a.f515m.getText().toString().trim().replace(",", "");
                this.f661a.f515m.setText(strReplace);
                this.f661a.f500M = strReplace;
                if (strReplace.length() > 0) {
                    NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 3, new BuddyGroupAddTask(this.f661a.f512j, strReplace, 3));
                    break;
                }
                break;
            case C0062R.id.buddy_group_profile_addmember /* 2131427505 */:
            case C0062R.id.buddy_group_profile_addmember_info /* 2131427506 */:
                this.f661a.m567f();
                Intent intent = new Intent(this.f661a.f514l, (Class<?>) BuddyGroupEditActivity.class);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                intent.putExtra("ACTIVITY_PURPOSE_ARG1", this.f661a.f509g);
                intent.putExtra("ACTIVITY_PURPOSE_ARG2", this.f661a.f496I);
                this.f661a.startActivityForResult(intent, 1);
                break;
            case C0062R.id.buddy_group_profile_remove_member /* 2131427507 */:
            case C0062R.id.buddy_group_profile_remove_member_info /* 2131427508 */:
                this.f661a.m567f();
                this.f661a.f490C.setVisibility(0);
                this.f661a.f492E.setVisibility(8);
                this.f661a.f515m.setText("");
                this.f661a.m547a(this.f661a.f515m);
                this.f661a.f488A.setText(this.f661a.getString(C0062R.string.buddy_group_profile_title_remove_member));
                this.f661a.f489B.setVisibility(8);
                this.f661a.f493F.setVisibility(8);
                this.f661a.f518p.setVisibility(0);
                this.f661a.f508f.m597b(true);
                this.f661a.f508f.m590a(1);
                this.f661a.f524v.invalidateViews();
                break;
            case C0062R.id.buddy_add_to_group /* 2131427516 */:
                ArrayList arrayListM583a = this.f661a.m583a();
                if (arrayListM583a.size() > 0) {
                    NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 1, new BuddyGroupAddBuddyTask(this.f661a.f512j, this.f661a.f509g.m663a(), arrayListM583a));
                    break;
                }
                break;
            case C0062R.id.buddy_remove_to_group /* 2131427517 */:
                ArrayList arrayListM583a2 = this.f661a.m583a();
                if (arrayListM583a2.size() > 0) {
                    Iterator it = arrayListM583a2.iterator();
                    while (it.hasNext()) {
                        this.f661a.f508f.m592a((String) it.next());
                    }
                    NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 2, new BuddyGroupRemoveBuddyTask(this.f661a.f512j, this.f661a.f509g.m663a(), arrayListM583a2));
                    break;
                }
                break;
            case C0062R.id.buddy_menu_cancel /* 2131427518 */:
                if (this.f661a.f499L != 2) {
                    if (this.f661a.f499L == 1) {
                        this.f661a.m567f();
                        break;
                    }
                } else {
                    this.f661a.setResult(-1);
                    this.f661a.finish();
                    break;
                }
                break;
            case C0062R.id.buddy_menu_groupchat /* 2131427519 */:
                ArrayList arrayListM583a3 = this.f661a.m583a();
                if (arrayListM583a3.size() > 0) {
                    if (arrayListM583a3.size() <= 50) {
                        Intent intent2 = new Intent(this.f661a.f514l, (Class<?>) ChatActivity.class);
                        intent2.putExtra("groupnmae", this.f661a.f509g.m666b() + " (" + (arrayListM583a3.size() + 1) + ")");
                        intent2.putExtra("chatType", ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a());
                        intent2.putExtra("receivers", (String[]) arrayListM583a3.toArray(new String[0]));
                        this.f661a.startActivity(intent2);
                        this.f661a.finish();
                        break;
                    } else {
                        Toast.makeText(this.f661a.f514l, String.format(this.f661a.getResources().getString(C0062R.string.buddy_list_groupchat_toast_failed_exceed), 50), 0).show();
                        break;
                    }
                }
                break;
            case C0062R.id.buddy_menu_broadcast /* 2131427520 */:
                ArrayList arrayListM583a4 = this.f661a.m583a();
                if (arrayListM583a4.size() > 0) {
                    if (arrayListM583a4.size() > 100) {
                        Toast.makeText(this.f661a.f514l, String.format(this.f661a.getResources().getString(C0062R.string.buddy_list_broadcast_toast_failed_exceed), 100), 0).show();
                        break;
                    } else {
                        Intent intent3 = new Intent(this.f661a.f514l, (Class<?>) ChatActivity.class);
                        intent3.putExtra("groupnmae", this.f661a.f509g.m666b() + " (" + arrayListM583a4.size() + ")");
                        intent3.putExtra("chatType", ChatONContract.InBoxTable.ChatType.BROADCAST.m2189a());
                        intent3.putExtra("receivers", (String[]) arrayListM583a4.toArray(new String[0]));
                        this.f661a.startActivity(intent3);
                        this.f661a.finish();
                    }
                }
                this.f661a.finish();
                break;
        }
    }
}
