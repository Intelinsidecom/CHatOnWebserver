package com.sec.chaton.chat;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.C2660e;
import com.sec.chaton.msgbox.C2679x;
import com.sec.chaton.p046a.p047a.C0777a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2246g;
import com.sec.chaton.p065io.entry.ChatProfileEntry;
import com.sec.chaton.p065io.entry.CheckBuddyList;
import com.sec.chaton.p065io.entry.FlagImageURLEntry;
import com.sec.chaton.p065io.entry.inner.ChatProfiles;
import com.sec.chaton.p065io.entry.inner.CheckBuddy;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dc */
/* loaded from: classes.dex */
class HandlerC1649dc extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6181a;

    HandlerC1649dc(ChatFragment chatFragment) {
        this.f6181a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException, RemoteException, OperationApplicationException {
        ArrayList<CheckBuddy> arrayList;
        CheckBuddy checkBuddy;
        int iM3101c;
        FlagImageURLEntry flagImageURLEntry;
        String string;
        int i = 0;
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 303:
                this.f6181a.m8275t();
                if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    if (this.f6181a.f5624cN != null && this.f6181a.getResources() != null) {
                        C5179v.m19811a(GlobalApplication.m18732r(), this.f6181a.getResources().getString(R.string.tellfriends_added), 0).show();
                    }
                    this.f6181a.m7977aL();
                    break;
                } else if (this.f6181a.f5624cN != null && this.f6181a.getResources() != null) {
                    if (c0778b.m3111f() == 16003) {
                        string = this.f6181a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0778b.m3111f() == 16004) {
                        string = this.f6181a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                        this.f6181a.m7977aL();
                    } else if (c0778b.m3111f() == 16005) {
                        string = this.f6181a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else if (c0778b.m3111f() == 16010) {
                        string = this.f6181a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_phonenumber);
                    } else if (c0778b.m3111f() == 16011) {
                        string = this.f6181a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_email);
                    } else {
                        string = this.f6181a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    C5179v.m19811a(GlobalApplication.m18732r(), string, 0).show();
                    break;
                }
                break;
            case 306:
                if (c0778b != null) {
                    if (this.f6181a.f5588bd.size() == 0) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ContactControl.METHOD_CHECK_BUDDY - the size of mParticipantsList is 0", "ChatFragment");
                            break;
                        }
                    } else if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        CheckBuddyList checkBuddyList = (CheckBuddyList) c0778b.m3110e();
                        if (checkBuddyList != null && (arrayList = checkBuddyList.buddy) != null && arrayList.size() != 0 && (checkBuddy = arrayList.get(0)) != null) {
                            String str = "NO_SEARCH";
                            if (this.f6181a.f5624cN != null && this.f6181a.getResources() != null) {
                                str = checkBuddy.countrycode;
                            }
                            if (this.f6181a.f5624cN != null && this.f6181a.getResources() != null && !this.f6181a.f5752x.startsWith("0999")) {
                                if (!TextUtils.isEmpty(checkBuddy.spamcount)) {
                                    C4904y.m18641c("SPAM reported count : " + Integer.valueOf(checkBuddy.spamcount).intValue(), getClass().getSimpleName());
                                }
                                this.f6181a.m7943a(checkBuddy.name, str, checkBuddy.authenticated.booleanValue(), -1, 0);
                            }
                            C0777a c0777a = (C0777a) this.f6181a.f5591bg.get(this.f6181a.f5588bd.get(0));
                            String strM3099b = "";
                            if (c0777a != null) {
                                strM3099b = c0777a.m3099b();
                                iM3101c = c0777a.m3101c();
                            } else {
                                iM3101c = 0;
                            }
                            boolean z = TextUtils.isEmpty(strM3099b) || !strM3099b.equals(checkBuddy.name);
                            if (TextUtils.isEmpty(checkBuddy.msisdns) || new StringTokenizer(checkBuddy.msisdns, "|").countTokens() == 1) {
                                i = 1;
                            }
                            if (iM3101c == i ? z : true) {
                                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                                arrayList2.add(C2176ab.m9674a(this.f6181a.f5752x, checkBuddy.name, str, checkBuddy.authenticated.booleanValue(), -1, i));
                                try {
                                    if (arrayList2.size() > 0) {
                                        GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                                    }
                                } catch (Exception e) {
                                    C4904y.m18634a(e.getMessage(), getClass().getSimpleName());
                                }
                                C4904y.m18641c("CHATON NUMBER : " + this.f6181a.f5752x + ", NAME : " + checkBuddy.name + ", CountryCode : " + str + ", isAuthUser : " + checkBuddy.authenticated + ", web only : " + i, getClass().getSimpleName());
                                break;
                            }
                        }
                    } else if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.ERROR && c0778b.m3111f() == 16005) {
                        this.f6181a.m7977aL();
                        C4904y.m18641c("blocked user CHATON NUMBER : " + this.f6181a.f5752x, getClass().getSimpleName());
                        break;
                    }
                }
                break;
            case 324:
                if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS && (flagImageURLEntry = (FlagImageURLEntry) c0778b.m3110e()) != null && !TextUtils.isEmpty(flagImageURLEntry.fileurl)) {
                    new AsyncTaskC1667du(this.f6181a).execute(flagImageURLEntry.fileurl);
                    break;
                }
                break;
            case 602:
                this.f6181a.m8275t();
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    if (this.f6181a.f5624cN != null && this.f6181a.getResources() != null) {
                        C5179v.m19811a(CommonApplication.m18732r(), this.f6181a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                        break;
                    }
                } else {
                    C2212z.m10068a(new C2212z(), 1, new C2246g(this.f6181a.f5541ah, new C1106c(this.f6181a.f5752x, this.f6181a.f5600bp), 1, false));
                    this.f6181a.m7977aL();
                    break;
                }
                break;
            case 605:
                if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    if (this.f6181a.f5624cN != null && this.f6181a.getResources() != null) {
                        C5179v.m19811a(GlobalApplication.m18732r(), this.f6181a.getResources().getString(R.string.spammer_report_toast), 0).show();
                    }
                    this.f6181a.m7977aL();
                    if (this.f6181a.f5487D == EnumC2300t.GROUPCHAT || this.f6181a.f5487D == EnumC2300t.TOPIC) {
                        this.f6181a.f5735en = new C2660e(this.f6181a.getActivity(), this.f6181a.f5750v, 7);
                        this.f6181a.f5735en.m11239a(new C2679x(this.f6181a.f5750v, this.f6181a.f5487D, this.f6181a.f5488E, this.f6181a.f5637ca, true), this.f6181a.f5713eB);
                        break;
                    } else {
                        this.f6181a.m8275t();
                        break;
                    }
                } else {
                    this.f6181a.m8275t();
                    if (this.f6181a.f5624cN != null && this.f6181a.getResources() != null) {
                        C5179v.m19811a(GlobalApplication.m18732r(), this.f6181a.getResources().getString(R.string.buddy_profile_saveprofile_toast_failed), 0).show();
                        break;
                    }
                }
                break;
            case 807:
                if (c0778b != null && c0778b.m3110e() != null && c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    ChatProfiles chatProfiles = ((ChatProfileEntry) c0778b.m3110e()).titleprofile;
                    if (!TextUtils.isEmpty(chatProfiles.title) && !this.f6181a.f5692de.getText().equals(chatProfiles.title)) {
                        this.f6181a.f5595bk = chatProfiles.title;
                        this.f6181a.f5692de.setText(this.f6181a.f5595bk);
                        break;
                    }
                }
                break;
        }
    }
}
