package com.sec.chaton.chat;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.util.Iterator;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.fl */
/* loaded from: classes.dex */
class HandlerC1712fl extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatInfoMoreFragment f6316a;

    HandlerC1712fl(ChatInfoMoreFragment chatInfoMoreFragment) {
        this.f6316a = chatInfoMoreFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0778b c0778b = (C0778b) message.obj;
        if (this.f6316a.f5817b != null) {
            if (c0778b.m18954n()) {
                if (message.what == 311) {
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        if (c0778b.m3110e() != null) {
                            Iterator<Buddy> it = ((GetBuddyList) c0778b.m3110e()).buddy.iterator();
                            while (it.hasNext()) {
                                Buddy next = it.next();
                                if (Integer.parseInt(next.result) == 3) {
                                    String strSubstring = next.value;
                                    if (next.value.startsWith("+")) {
                                        strSubstring = next.value.substring(1);
                                    }
                                    next.value = strSubstring;
                                    if (!this.f6316a.getArguments().containsKey("member_name")) {
                                        next.name = C2176ab.m9698g(GlobalApplication.m18732r().getContentResolver(), this.f6316a.f5818c, strSubstring);
                                    } else {
                                        String[] stringArray = this.f6316a.getArguments().getStringArray("member_name");
                                        next.name = strSubstring;
                                        int i = 0;
                                        while (true) {
                                            if (i >= this.f6316a.f5821f.length) {
                                                break;
                                            }
                                            if (!this.f6316a.f5821f[i].equals(strSubstring)) {
                                                i++;
                                            } else {
                                                next.name = stringArray[i];
                                                break;
                                            }
                                        }
                                    }
                                    if (C4904y.f17872b) {
                                        C4904y.m18639b("Blocked Buddy NO : " + next.value + ", Name : " + next.name, getClass().getSimpleName());
                                    }
                                    this.f6316a.f5824i.add(next);
                                }
                            }
                        }
                        if (this.f6316a.f5827l != null) {
                            this.f6316a.f5827l.m6610m();
                        }
                        if (this.f6316a.f5824i.size() > 0) {
                            StringBuilder sb = new StringBuilder();
                            Iterator it2 = this.f6316a.f5824i.iterator();
                            while (it2.hasNext()) {
                                sb.append(((Buddy) it2.next()).name).append(",");
                            }
                            sb.setLength(sb.length() - 1);
                            C5179v.m19811a(GlobalApplication.m18732r(), String.format(this.f6316a.getString(R.string.toast_was_blocked), sb.toString()), 0).show();
                        } else {
                            C5179v.m19810a(GlobalApplication.m18732r(), R.string.tellfriends_added, 0).show();
                        }
                        if (this.f6316a.f5824i.size() == this.f6316a.f5823h.size()) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("All buddies are blocked", getClass().getSimpleName());
                            }
                        } else {
                            this.f6316a.m8350a();
                        }
                    } else if (this.f6316a.getResources() != null) {
                        int iM10677a = C2471v.m10677a(GlobalApplication.m18732r());
                        if (-3 == iM10677a || -2 == iM10677a) {
                            string = this.f6316a.getResources().getString(R.string.popup_no_network_connection);
                        } else if (c0778b.m3111f() == 16003) {
                            string = this.f6316a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                        } else if (c0778b.m3111f() == 16004) {
                            string = this.f6316a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                        } else if (c0778b.m3111f() == 16005) {
                            string = this.f6316a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                        } else if (c0778b.m3111f() == 50005) {
                            string = this.f6316a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                        } else {
                            string = this.f6316a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                        }
                        C5179v.m19811a(GlobalApplication.m18732r(), string, 0).show();
                    }
                }
            } else {
                C5179v.m19810a(GlobalApplication.m18732r(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            }
            this.f6316a.m8341d();
        }
    }
}
