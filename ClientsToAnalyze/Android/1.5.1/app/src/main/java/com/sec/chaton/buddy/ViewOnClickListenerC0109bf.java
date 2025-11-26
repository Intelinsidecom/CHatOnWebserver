package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.BuddyGroupAddTask;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.sec.chaton.buddy.bf */
/* loaded from: classes.dex */
class ViewOnClickListenerC0109bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f652a;

    ViewOnClickListenerC0109bf(BuddyFragment buddyFragment) {
        this.f652a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashSet hashSet = new HashSet();
        this.f652a.m513p();
        Iterator it = this.f652a.f423N.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m692q()) {
                    hashSet.add(buddyItem.m668a());
                }
            }
        }
        switch (view.getId()) {
            case C0062R.id.buddy_menu_cancel /* 2131427518 */:
                if (this.f652a.f419J != 5) {
                    this.f652a.getActivity().finish();
                    break;
                } else {
                    this.f652a.getActivity().setResult(0);
                    this.f652a.getActivity().finish();
                    break;
                }
            case C0062R.id.buddy_menu_broadcast /* 2131427520 */:
                if (hashSet.size() > 0) {
                    if (hashSet.size() <= 100) {
                        Intent intent = new Intent(this.f652a.getActivity(), (Class<?>) ChatActivity.class);
                        intent.setFlags(67108864);
                        intent.putExtra("chatType", ChatONContract.InBoxTable.ChatType.BROADCAST.m2189a());
                        intent.putExtra("receivers", (String[]) hashSet.toArray(new String[0]));
                        if (this.f652a.f439ad) {
                            intent.putExtra(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, this.f652a.f440ae);
                            intent.putExtra("download_uri", this.f652a.f441af);
                            if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f652a.f440ae) == ChatONContract.MessageTable.MsgContentType.CALENDAR || ChatONContract.MessageTable.MsgContentType.m2195a(this.f652a.f440ae) == ChatONContract.MessageTable.MsgContentType.CONTACT) {
                                intent.putExtra("sub_content", this.f652a.f442ag);
                            }
                        }
                        this.f652a.startActivity(intent);
                        this.f652a.getActivity().finish();
                        break;
                    } else {
                        Toast.makeText(this.f652a.f453i, String.format(this.f652a.getResources().getString(C0062R.string.buddy_list_broadcast_toast_failed_exceed), 100), 0).show();
                        break;
                    }
                }
                break;
            case C0062R.id.buddy_menu_group_chat /* 2131427543 */:
                if (hashSet.size() > 0) {
                    if (hashSet.size() + 1 <= 50) {
                        Intent intent2 = new Intent(this.f652a.getActivity(), (Class<?>) ChatActivity.class);
                        intent2.setFlags(67108864);
                        intent2.putExtra("chatType", ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a());
                        intent2.putExtra("receivers", (String[]) hashSet.toArray(new String[0]));
                        if (this.f652a.f439ad) {
                            intent2.putExtra(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, this.f652a.f440ae);
                            intent2.putExtra("download_uri", this.f652a.f441af);
                            if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f652a.f440ae) == ChatONContract.MessageTable.MsgContentType.CALENDAR || ChatONContract.MessageTable.MsgContentType.m2195a(this.f652a.f440ae) == ChatONContract.MessageTable.MsgContentType.CONTACT) {
                                intent2.putExtra("sub_content", this.f652a.f442ag);
                            }
                        }
                        this.f652a.startActivity(intent2);
                        this.f652a.getActivity().finish();
                        break;
                    } else {
                        Toast.makeText(this.f652a.f453i, String.format(this.f652a.getResources().getString(C0062R.string.buddy_list_groupchat_toast_failed_exceed), 50), 0).show();
                        break;
                    }
                }
                break;
            case C0062R.id.buddy_menu_invite /* 2131427544 */:
                ChatONLogWriter.m3512f("Button.OnClickListener() : INVITE BUDDY", BuddyFragment.f409a);
                ChatONLogWriter.m3512f("checkedBuddySet.size() : " + hashSet.size(), BuddyFragment.f409a);
                ChatONLogWriter.m3512f("mBundle.getStringArray(ChatFragment.EXTRA_PARTICIPANT).length : " + this.f652a.f416G.getStringArray(ChatFragment.f724c).length, BuddyFragment.f409a);
                ChatONLogWriter.m3512f("mBundle.getInt(ChatFragment.KEY_CHAT_TYPE) : " + this.f652a.f416G.getInt("chatType"), BuddyFragment.f409a);
                if (hashSet.size() > 0) {
                    if (this.f652a.f416G.getInt("chatType") != ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a()) {
                        if (this.f652a.f416G.getInt("chatType") == ChatONContract.InBoxTable.ChatType.BROADCAST.m2189a() && this.f652a.f416G.getStringArray(ChatFragment.f724c).length + hashSet.size() > 100) {
                            Toast.makeText(this.f652a.f453i, String.format(this.f652a.getResources().getString(C0062R.string.buddy_list_broadcast_toast_failed_exceed), 100), 0).show();
                            break;
                        }
                    } else if (this.f652a.f416G.getStringArray(ChatFragment.f724c).length + hashSet.size() + 1 > 50) {
                        Toast.makeText(this.f652a.f453i, String.format(this.f652a.getResources().getString(C0062R.string.buddy_list_groupchat_toast_failed_exceed), 50), 0).show();
                        break;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("receivers", (String[]) hashSet.toArray(new String[0]));
                    this.f652a.getActivity().setResult(-1, intent3);
                    this.f652a.getActivity().finish();
                    break;
                }
                break;
            case C0062R.id.buddy_menu_add_group /* 2131427545 */:
                if (hashSet.size() > 0) {
                    ChatONLogWriter.m3512f("NEW GROUP NAME : " + this.f652a.f416G.getString("ACTIVITY_PURPOSE_ARG2"), BuddyFragment.f409a);
                    ChatONLogWriter.m3512f("MEMBER COUNT  : " + hashSet.size(), BuddyFragment.f409a);
                    ArrayList arrayList = new ArrayList();
                    Iterator it3 = hashSet.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(it3.next());
                    }
                    arrayList.add(0, this.f652a.f416G.getString("ACTIVITY_PURPOSE_ARG2"));
                    NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 2, new BuddyGroupAddTask(this.f652a.f451g, (String[]) arrayList.toArray(new String[0]), 2));
                    break;
                }
                break;
            case C0062R.id.buddy_menu_blind_memo /* 2131427546 */:
                Intent intent4 = new Intent();
                HashSet hashSet2 = new HashSet();
                Iterator it4 = this.f652a.f423N.iterator();
                while (it4.hasNext()) {
                    Iterator it5 = ((ArrayList) it4.next()).iterator();
                    while (it5.hasNext()) {
                        BuddyItem buddyItem2 = (BuddyItem) it5.next();
                        if (!buddyItem2.m692q()) {
                            hashSet2.add(buddyItem2.m668a());
                        }
                    }
                }
                intent4.putExtra("blindlist", (String[]) hashSet2.toArray(new String[0]));
                this.f652a.getActivity().setResult(-1, intent4);
                this.f652a.getActivity().finish();
                break;
        }
    }
}
