package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0680g;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ai */
/* loaded from: classes.dex */
class ViewOnClickListenerC0267ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1362a;

    ViewOnClickListenerC0267ai(BuddyFragment buddyFragment) {
        this.f1362a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1362a.f951aM = this.f1362a.m1927O();
        switch (view.getId()) {
            case R.id.buddy_menu_cancel /* 2131493083 */:
                if (this.f1362a.f969af == 5) {
                    this.f1362a.getActivity().setResult(0);
                    this.f1362a.getActivity().finish();
                    break;
                } else {
                    this.f1362a.getActivity().finish();
                    break;
                }
            case R.id.buddy_menu_broadcast /* 2131493085 */:
                if (this.f1362a.f951aM.size() > 0) {
                    if (this.f1362a.f951aM.size() <= 200) {
                        Intent intent = new Intent(this.f1362a.getActivity(), (Class<?>) ChatActivity.class);
                        intent.setFlags(67108864);
                        intent.putExtra("chatType", EnumC0695j.BROADCAST.m3146a());
                        intent.putExtra("receivers", (String[]) this.f1362a.f951aM.toArray(new String[0]));
                        if (this.f1362a.f943aE) {
                            intent.putExtra("content_type", this.f1362a.f944aF);
                            intent.putExtra("download_uri", this.f1362a.f945aG);
                            intent.putExtra("sub_content", this.f1362a.f946aH);
                            intent.putExtra("forward_sender_name", this.f1362a.f1011m);
                        }
                        this.f1362a.startActivity(intent);
                        this.f1362a.getActivity().finish();
                        break;
                    } else {
                        Toast.makeText(this.f1362a.f1018t, String.format(this.f1362a.getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
                        break;
                    }
                }
                break;
            case R.id.buddy_menu_group_chat /* 2131493108 */:
                if (this.f1362a.f951aM.size() > 0) {
                    if (this.f1362a.f951aM.size() + 1 <= 199) {
                        Intent intent2 = new Intent(this.f1362a.getActivity(), (Class<?>) ChatActivity.class);
                        intent2.setFlags(67108864);
                        if (this.f1362a.f951aM.size() == 1) {
                            intent2.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                        } else {
                            intent2.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                        }
                        intent2.putExtra("receivers", (String[]) this.f1362a.f951aM.toArray(new String[0]));
                        if (this.f1362a.f943aE) {
                            intent2.putExtra("content_type", this.f1362a.f944aF);
                            intent2.putExtra("download_uri", this.f1362a.f945aG);
                            intent2.putExtra("sub_content", this.f1362a.f946aH);
                            intent2.putExtra("forward_sender_name", this.f1362a.f1011m);
                        }
                        this.f1362a.startActivity(intent2);
                        this.f1362a.getActivity().finish();
                        break;
                    } else {
                        Toast.makeText(this.f1362a.f1018t, String.format(this.f1362a.getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 198), 0).show();
                        break;
                    }
                }
                break;
            case R.id.buddy_menu_invite /* 2131493109 */:
                C1786r.m6067f("Button.OnClickListener() : INVITE BUDDY", BuddyFragment.f908a);
                C1786r.m6067f("checkedBuddySet.size() : " + this.f1362a.f951aM.size(), BuddyFragment.f908a);
                C1786r.m6067f("mBundle.getStringArray(ChatFragment.EXTRA_PARTICIPANT).length : " + this.f1362a.f966ac.getStringArray(ChatFragment.f1749e).length, BuddyFragment.f908a);
                C1786r.m6067f("mBundle.getInt(ChatFragment.KEY_CHAT_TYPE) : " + this.f1362a.f966ac.getInt("chatType"), BuddyFragment.f908a);
                if (this.f1362a.f951aM.size() > 0) {
                    if (this.f1362a.f966ac.getInt("chatType") == EnumC0695j.GROUPCHAT.m3146a() || this.f1362a.f966ac.getInt("chatType") == EnumC0695j.ONETOONE.m3146a()) {
                        if (this.f1362a.f966ac.getStringArray(ChatFragment.f1749e).length + this.f1362a.f951aM.size() + 1 > 199) {
                            Toast.makeText(this.f1362a.f1018t, String.format(this.f1362a.getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 198), 0).show();
                            break;
                        }
                    } else if (this.f1362a.f966ac.getInt("chatType") == EnumC0695j.BROADCAST.m3146a() && this.f1362a.f966ac.getStringArray(ChatFragment.f1749e).length + this.f1362a.f951aM.size() > 200) {
                        Toast.makeText(this.f1362a.f1018t, String.format(this.f1362a.getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
                        break;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("receivers", (String[]) this.f1362a.f951aM.toArray(new String[0]));
                    this.f1362a.getActivity().setResult(-1, intent3);
                    this.f1362a.getActivity().finish();
                    break;
                }
                break;
            case R.id.buddy_menu_add_group /* 2131493110 */:
                if (this.f1362a.f951aM.size() > 0) {
                    C1786r.m6067f("NEW GROUP NAME : " + this.f1362a.f966ac.getString("ACTIVITY_PURPOSE_ARG2"), BuddyFragment.f908a);
                    C1786r.m6067f("MEMBER COUNT  : " + this.f1362a.f951aM.size(), BuddyFragment.f908a);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.f1362a.f951aM.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                    arrayList.add(0, this.f1362a.f966ac.getString("ACTIVITY_PURPOSE_ARG2"));
                    C0668l.m3077a(new C0668l(), 2, new C0680g(this.f1362a.f1007i, (String[]) arrayList.toArray(new String[0]), 2));
                    this.f1362a.f1022x.findViewById(R.id.buddy_menu_add_group).setClickable(false);
                    break;
                }
                break;
            case R.id.buddy_menu_blind_memo /* 2131493111 */:
                Intent intent4 = new Intent();
                HashSet hashSet = new HashSet();
                Iterator it2 = this.f1362a.f973aj.iterator();
                while (it2.hasNext()) {
                    Iterator it3 = ((ArrayList) it2.next()).iterator();
                    while (it3.hasNext()) {
                        C0257c c0257c = (C0257c) it3.next();
                        if (!c0257c.m2345q()) {
                            hashSet.add(c0257c.m2318a());
                        }
                    }
                }
                intent4.putExtra("blindlist", (String[]) hashSet.toArray(new String[0]));
                this.f1362a.getActivity().setResult(-1, intent4);
                this.f1362a.getActivity().finish();
                break;
        }
    }
}
