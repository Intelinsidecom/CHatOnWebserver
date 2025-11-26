package com.sec.chaton.chat;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.util.Iterator;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.dx */
/* loaded from: classes.dex */
class HandlerC1055dx extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatInfoMoreFragment f4165a;

    HandlerC1055dx(ChatInfoMoreFragment chatInfoMoreFragment) {
        this.f4165a = chatInfoMoreFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0267d c0267d = (C0267d) message.obj;
        if (this.f4165a.getActivity() != null) {
            if (c0267d.m11704n()) {
                if (message.what == 311) {
                    if (c0267d.m1351b() != EnumC1587o.SUCCESS) {
                        if (this.f4165a.f3760b != null && this.f4165a.getResources() != null) {
                            int iM6733a = C1594v.m6733a(GlobalApplication.m11493l());
                            if (-3 == iM6733a || -2 == iM6733a) {
                                string = this.f4165a.getResources().getString(R.string.popup_no_network_connection);
                            } else if (c0267d.m1355f() == 16003) {
                                string = this.f4165a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                            } else if (c0267d.m1355f() == 16004) {
                                string = this.f4165a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                            } else if (c0267d.m1355f() == 16005) {
                                string = this.f4165a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                            } else if (c0267d.m1355f() == 50005) {
                                string = this.f4165a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                            } else {
                                string = this.f4165a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                            }
                            C3641ai.m13211a(GlobalApplication.m11493l(), string, 0).show();
                        }
                    } else {
                        if (c0267d.m1354e() != null) {
                            Iterator<Buddy> it = ((GetBuddyList) c0267d.m1354e()).buddy.iterator();
                            while (it.hasNext()) {
                                Buddy next = it.next();
                                if (Integer.parseInt(next.result) == 3) {
                                    String strSubstring = next.value;
                                    if (next.value.startsWith("+")) {
                                        strSubstring = next.value.substring(1);
                                    }
                                    next.value = strSubstring;
                                    if (!this.f4165a.getArguments().containsKey("member_name")) {
                                        next.name = C1381y.m6224g(GlobalApplication.m11493l().getContentResolver(), this.f4165a.f3762d, strSubstring);
                                    } else {
                                        String[] stringArray = this.f4165a.getArguments().getStringArray("member_name");
                                        next.name = strSubstring;
                                        int i = 0;
                                        while (true) {
                                            if (i >= this.f4165a.f3765g.length) {
                                                break;
                                            }
                                            if (!this.f4165a.f3765g[i].equals(strSubstring)) {
                                                i++;
                                            } else {
                                                next.name = stringArray[i];
                                                break;
                                            }
                                        }
                                    }
                                    if (C3250y.f11734b) {
                                        C3250y.m11450b("Blocked Buddy NO : " + next.value + ", Name : " + next.name, getClass().getSimpleName());
                                    }
                                    this.f4165a.f3768j.add(next);
                                }
                            }
                        }
                        if (this.f4165a.f3768j.size() > 0) {
                            StringBuilder sb = new StringBuilder();
                            Iterator it2 = this.f4165a.f3768j.iterator();
                            while (it2.hasNext()) {
                                sb.append(((Buddy) it2.next()).name).append(",");
                            }
                            sb.setLength(sb.length() - 1);
                            C3641ai.m13211a(GlobalApplication.m11493l(), String.format(this.f4165a.getString(R.string.toast_was_blocked), sb.toString()), 0).show();
                        } else {
                            C3641ai.m13210a(GlobalApplication.m11493l(), R.string.tellfriends_added, 0).show();
                        }
                        if (this.f4165a.f3768j.size() == this.f4165a.f3767i.size()) {
                            if (C3250y.f11734b) {
                                C3250y.m11450b("All buddies are blocked", getClass().getSimpleName());
                            }
                        } else {
                            this.f4165a.m5081a();
                        }
                    }
                }
            } else {
                C3641ai.m13210a(GlobalApplication.m11493l(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            }
            this.f4165a.m5073d();
        }
    }
}
