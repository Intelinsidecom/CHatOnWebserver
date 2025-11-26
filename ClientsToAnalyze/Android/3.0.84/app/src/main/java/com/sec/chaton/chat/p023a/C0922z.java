package com.sec.chaton.chat.p023a;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SystemBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.z */
/* loaded from: classes.dex */
public class C0922z extends AbstractC0888a {
    @Override // com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    protected void mo5087a() throws Resources.NotFoundException {
        String str;
        String string;
        boolean zContainsAll;
        EnumC1391ai enumC1391aiM6246a;
        this.f3794h.f4279i.setVisibility(8);
        this.f3794h.f4280j.setVisibility(8);
        this.f3794h.f4215D.setVisibility(0);
        this.f3794h.f4276f.setVisibility(8);
        String[] strArrSplit = this.f3802p.split(Config.KEYVALUE_SPLIT);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        if (strArrSplit.length > 0) {
            EnumC1391ai enumC1391ai = EnumC1391ai.UNKNOWN;
            int length = strArrSplit.length;
            int i = 0;
            while (i < length) {
                String[] strArrSplit2 = strArrSplit[i].split(",");
                if (strArrSplit2.length > 2) {
                    enumC1391aiM6246a = EnumC1391ai.m6246a(Integer.parseInt(strArrSplit2[0]));
                    sb.append(C1075eq.m5323b(strArrSplit2[2].replace('\n', ' '))).append(",");
                    if (enumC1391aiM6246a == EnumC1391ai.LEAVE) {
                        arrayList.add(strArrSplit2[1]);
                    }
                } else {
                    enumC1391aiM6246a = enumC1391ai;
                }
                i++;
                enumC1391ai = enumC1391aiM6246a;
            }
            switch (C0892ad.f3818a[enumC1391ai.ordinal()]) {
                case 1:
                    if (TextUtils.isEmpty(this.f3783D)) {
                        string = GlobalApplication.m6451b().getString(R.string.chat_view_system_invite);
                        break;
                    } else {
                        string = GlobalApplication.m6451b().getString(R.string.chat_view_system_invite_2);
                        break;
                    }
                case 2:
                    String string2 = GlobalApplication.m6451b().getString(R.string.chat_view_system_leave);
                    if (arrayList.size() > 0 && this.f3798l == EnumC1450r.GROUPCHAT) {
                        try {
                            ChatActivity chatActivity = (ChatActivity) this.f3789c;
                            zContainsAll = chatActivity.m4671d() != null ? chatActivity.m4671d().containsAll(arrayList) : false;
                        } catch (Exception e) {
                            e.printStackTrace();
                            zContainsAll = false;
                        }
                        if (C3250y.f11735c) {
                            C3250y.m11453c("isAlreadyInvitedMember - " + zContainsAll, getClass().getSimpleName());
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                C3250y.m11453c("reInviteMember - " + ((String) it.next()), getClass().getSimpleName());
                            }
                        }
                        if (!zContainsAll) {
                            this.f3794h.f4276f.setVisibility(0);
                            SpannableString spannableString = new SpannableString(this.f3789c.getString(R.string.reinvite));
                            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
                            this.f3794h.f4276f.setText(spannableString);
                            this.f3794h.f4276f.setOnClickListener(new ViewOnClickListenerC0889aa(this, String.format(GlobalApplication.m6451b().getString(R.string.reinvite_to_this_chat), sb.substring(0, sb.length() - 1)), (String[]) arrayList.toArray(new String[0])));
                        }
                        string = string2;
                        break;
                    } else {
                        string = string2;
                        break;
                    }
                    break;
                case 3:
                    string = GlobalApplication.m6451b().getString(R.string.noti_invite_member);
                    break;
                case 4:
                    string = GlobalApplication.m6451b().getString(R.string.toast_chat_change_account_info);
                    break;
                case 5:
                    string = GlobalApplication.m6451b().getString(R.string.chat_view_chat_member);
                    break;
                case 6:
                    this.f3794h.f4275e.setText(GlobalApplication.m6451b().getString(R.string.chat_view_mark));
                    return;
                case 7:
                    this.f3794h.f4275e.setText(GlobalApplication.m6451b().getString(R.string.unable_to_chat));
                    return;
                case 8:
                    this.f3794h.f4275e.setText(String.format(GlobalApplication.m6451b().getString(R.string.buddy_msg_translate_into), C0952c.m5143c().m5148a(sb.substring(0, sb.indexOf(","))), C0952c.m5143c().m5148a(sb.substring(sb.indexOf(",") + 1, sb.length() - 1))));
                    return;
                case 9:
                    string = GlobalApplication.m6451b().getString(R.string.translate_disabled);
                    this.f3794h.f4275e.setText(string);
                    break;
                default:
                    this.f3794h.f4275e.setText(this.f3802p);
                    return;
            }
            if (TextUtils.isEmpty(string)) {
                str = "";
            } else if (sb.length() > 1) {
                if (!TextUtils.isEmpty(this.f3783D) && enumC1391ai == EnumC1391ai.ENTER) {
                    str = String.format(string, this.f3783D, sb.substring(0, sb.length() - 1));
                } else {
                    str = String.format(string, sb.substring(0, sb.length() - 1));
                }
            } else {
                str = String.format(string, GlobalApplication.m6451b().getString(R.string.unknown));
            }
        } else {
            str = this.f3802p;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f3794h.f4275e.setText(str);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        this.f3794h.f4215D.setVisibility(8);
    }
}
