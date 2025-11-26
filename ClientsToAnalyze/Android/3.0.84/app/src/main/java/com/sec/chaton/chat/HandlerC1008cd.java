package com.sec.chaton.chat;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0264a;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p027e.p029b.C1416g;
import com.sec.chaton.p035io.entry.ChatProfileEntry;
import com.sec.chaton.p035io.entry.CheckBuddyList;
import com.sec.chaton.p035io.entry.FlagImageURLEntry;
import com.sec.chaton.p035io.entry.GetAllMessageList;
import com.sec.chaton.p035io.entry.inner.ChatProfiles;
import com.sec.chaton.p035io.entry.inner.CheckBuddy;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cd */
/* loaded from: classes.dex */
class HandlerC1008cd extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4082a;

    HandlerC1008cd(ChatFragment chatFragment) {
        this.f4082a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException, RemoteException, OperationApplicationException {
        ArrayList<CheckBuddy> arrayList;
        CheckBuddy checkBuddy;
        String str;
        String strM1329a;
        FlagImageURLEntry flagImageURLEntry;
        String string;
        this.f4082a.m5022w();
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 303:
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    if (this.f4082a.f3672cr != null && this.f4082a.getResources() != null) {
                        C3641ai.m13211a(GlobalApplication.m11493l(), this.f4082a.getResources().getString(R.string.tellfriends_added), 0).show();
                    }
                    this.f4082a.m4855aw();
                    break;
                } else if (this.f4082a.f3672cr != null && this.f4082a.getResources() != null) {
                    if (c0267d.m1355f() == 16003) {
                        string = this.f4082a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0267d.m1355f() == 16004) {
                        string = this.f4082a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                        this.f4082a.m4855aw();
                    } else if (c0267d.m1355f() == 16005) {
                        string = this.f4082a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else if (c0267d.m1355f() == 16010) {
                        string = this.f4082a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_phonenumber);
                    } else if (c0267d.m1355f() == 16011) {
                        string = this.f4082a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_email);
                    } else {
                        string = this.f4082a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    C3641ai.m13211a(GlobalApplication.m11493l(), string, 0).show();
                    break;
                }
                break;
            case 306:
                if (c0267d != null) {
                    if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        CheckBuddyList checkBuddyList = (CheckBuddyList) c0267d.m1354e();
                        if (checkBuddyList != null && (arrayList = checkBuddyList.buddy) != null && arrayList.size() != 0 && (checkBuddy = arrayList.get(0)) != null) {
                            if (TextUtils.isEmpty(checkBuddy.countrycode)) {
                                str = "NO_SEARCH";
                            } else {
                                str = checkBuddy.countrycode;
                            }
                            if (this.f4082a.f3672cr != null && this.f4082a.getResources() != null) {
                                this.f4082a.m4771a(checkBuddy.name, str, checkBuddy.authenticated.booleanValue(), -1);
                            }
                            C0264a c0264a = (C0264a) this.f4082a.f3537aM.get(this.f4082a.f3536aL.get(0));
                            if (c0264a == null) {
                                strM1329a = "";
                            } else {
                                strM1329a = c0264a.m1329a();
                            }
                            if (TextUtils.isEmpty(strM1329a) || !strM1329a.equals(checkBuddy.name)) {
                                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                                arrayList2.add(C1381y.m6208a(this.f4082a.f3704s, checkBuddy.name, str, checkBuddy.authenticated.booleanValue(), -1));
                                try {
                                    if (arrayList2.size() > 0) {
                                        GlobalApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                                    }
                                } catch (Exception e) {
                                    C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
                                }
                            }
                            C3250y.m11453c("CHATON NUMBER : " + this.f4082a.f3704s + ", NAME : " + checkBuddy.name + ", CountryCode : " + str + ", isAuthUser : " + checkBuddy.authenticated, getClass().getSimpleName());
                            break;
                        }
                    } else if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.ERROR && c0267d.m1355f() == 16005) {
                        this.f4082a.m4855aw();
                        C3250y.m11453c("blocked user CHATON NUMBER : " + this.f4082a.f3704s, getClass().getSimpleName());
                        break;
                    }
                }
                break;
            case 324:
                if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS && (flagImageURLEntry = (FlagImageURLEntry) c0267d.m1354e()) != null && !TextUtils.isEmpty(flagImageURLEntry.fileurl)) {
                    new AsyncTaskC1026cv(this.f4082a).execute(flagImageURLEntry.fileurl);
                    break;
                }
                break;
            case 602:
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    if (this.f4082a.f3672cr != null && this.f4082a.getResources() != null) {
                        C3641ai.m13211a(CommonApplication.m11493l(), this.f4082a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                        break;
                    }
                } else {
                    C1379w.m6203a(new C1379w(), 1, new C1416g(this.f4082a.f3523Y, new C0513c(this.f4082a.f3704s, this.f4082a.f3545aU), 1, false));
                    this.f4082a.m4855aw();
                    break;
                }
                break;
            case 605:
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    if (this.f4082a.f3672cr != null && this.f4082a.getResources() != null) {
                        C3641ai.m13211a(GlobalApplication.m11493l(), "reported", 0).show();
                    }
                    this.f4082a.m4855aw();
                    break;
                } else if (this.f4082a.f3672cr != null && this.f4082a.getResources() != null) {
                    C3641ai.m13211a(GlobalApplication.m11493l(), this.f4082a.getResources().getString(R.string.buddy_profile_saveprofile_toast_failed), 0).show();
                    break;
                }
                break;
            case 807:
                if (c0267d != null && c0267d.m1354e() != null && c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    ChatProfiles chatProfiles = ((ChatProfileEntry) c0267d.m1354e()).titleprofile;
                    if (!TextUtils.isEmpty(chatProfiles.title) && !this.f4082a.f3639cI.getText().equals(chatProfiles.title)) {
                        this.f4082a.f3540aP = chatProfiles.title;
                        this.f4082a.f3639cI.setText(this.f4082a.f3540aP);
                        break;
                    }
                }
                break;
            case 811:
                if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    GetAllMessageList getAllMessageList = (GetAllMessageList) c0267d.m1354e();
                    if (getAllMessageList == null) {
                        this.f4082a.m4860az();
                        if (C3250y.f11735c) {
                            C3250y.m11453c("METHOD_GET_ALL_MESSAGES handling - allMessages is null", ChatFragment.f3484a);
                            break;
                        }
                    } else {
                        boolean zBooleanValue = getAllMessageList.has_more.booleanValue();
                        ArrayList<com.sec.chaton.p035io.entry.inner.Message> arrayList3 = getAllMessageList.messages;
                        if (!zBooleanValue) {
                            this.f4082a.f3548aX = "-1";
                        } else if (arrayList3.size() > 0) {
                            Collections.sort(arrayList3, new C1009ce(this));
                            this.f4082a.f3548aX = arrayList3.get(0).tid;
                        }
                    }
                } else if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                    this.f4082a.f3548aX = "-1";
                }
                this.f4082a.m4860az();
                if (C3250y.f11735c) {
                    C3250y.m11453c("METHOD_GET_ALL_MESSAGES handling", ChatFragment.f3484a);
                    break;
                }
                break;
        }
    }
}
