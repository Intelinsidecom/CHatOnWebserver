package com.sec.chaton.specialbuddy;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p065io.entry.GetSpecialBuddyList;
import com.sec.chaton.p065io.entry.GetSpecialUserList;
import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyFollowEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.x */
/* loaded from: classes.dex */
class HandlerC4559x extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16431a;

    HandlerC4559x(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f16431a = specialBuddyChatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException, RemoteException, OperationApplicationException {
        SpecialUser specialUser;
        boolean z;
        if (this.f16431a.isValidActivity()) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 317:
                    if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                        SpecialBuddyFollowEntry specialBuddyFollowEntryM17211a = this.f16431a.m17211a();
                        if (specialBuddyFollowEntryM17211a == null) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("follow_handler #1, follow fail, entry null", SpecialBuddyChatFragment.f16299l);
                                break;
                            }
                        } else {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("follow_handler #2, follow fail, entry : " + specialBuddyFollowEntryM17211a, SpecialBuddyChatFragment.f16299l);
                            }
                            this.f16431a.m17215a(specialBuddyFollowEntryM17211a.error, specialBuddyFollowEntryM17211a.f8583id);
                            break;
                        }
                    }
                    break;
                case 321:
                    SpecialBuddyFollowEntry specialBuddyFollowEntryM17211a2 = this.f16431a.m17211a();
                    if (!SpecialBuddyFollowEntry.isValid(specialBuddyFollowEntryM17211a2)) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("follow_handler #3, get my follow fail, entry is not valid : " + specialBuddyFollowEntryM17211a2, SpecialBuddyChatFragment.f16299l);
                            break;
                        }
                    } else {
                        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS && c0778b.m3110e() != null) {
                            for (SpecialUser specialUser2 : ((GetSpecialBuddyList) c0778b.m3110e()).specialbuddy) {
                                if (specialBuddyFollowEntryM17211a2.f8583id != null && specialUser2.specialuserid.equals(specialBuddyFollowEntryM17211a2.f8583id)) {
                                    z = true;
                                }
                            }
                            z = false;
                        } else {
                            z = false;
                        }
                        if (C4904y.f17872b) {
                            C4904y.m18639b("follow_handler #3, get my follow " + z + ", entry : " + specialBuddyFollowEntryM17211a2, SpecialBuddyChatFragment.f16299l);
                        }
                        if (z) {
                            this.f16431a.m17215a(specialBuddyFollowEntryM17211a2.success, specialBuddyFollowEntryM17211a2.f8583id);
                            break;
                        } else {
                            this.f16431a.m17215a(specialBuddyFollowEntryM17211a2.error, specialBuddyFollowEntryM17211a2.f8583id);
                            break;
                        }
                    }
                    break;
                case 334:
                    if (c0778b.m18954n()) {
                        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                            GetSpecialUserList getSpecialUserList = (GetSpecialUserList) c0778b.m3110e();
                            if (getSpecialUserList != null && getSpecialUserList.specialuser != null && (specialUser = getSpecialUserList.specialuser.get(0)) != null && !TextUtils.isEmpty(specialUser.name)) {
                                this.f16431a.f16378w = specialUser.name;
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("[Handler] result code : " + c0778b.m3107b() + ", " + c0778b.m18953m() + ", GET_SPECIALBUDDY_PROFILE : " + this.f16431a.f16378w, SpecialBuddyChatFragment.f16299l);
                                }
                                this.f16431a.setTitle(this.f16431a.f16378w);
                                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                                arrayList.add(C2176ab.m9687c(this.f16431a.f16376u, this.f16431a.f16375t, this.f16431a.f16378w));
                                try {
                                    CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                                    break;
                                } catch (Exception e) {
                                    if (C4904y.f17873c) {
                                        C4904y.m18641c("[Handler] Failed to update participant name of unfollowing Live CP.", SpecialBuddyChatFragment.f16299l);
                                        return;
                                    }
                                    return;
                                }
                            } else if (C4904y.f17872b) {
                                C4904y.m18639b("result code : " + c0778b.m3107b() + ", " + c0778b.m18953m() + "GET_SPECIALBUDDY_PROFILE Object is null", SpecialBuddyChatFragment.f16299l);
                                break;
                            }
                        } else if (C4904y.f17872b) {
                            C4904y.m18639b("faultCode: " + c0778b.m3111f(), SpecialBuddyChatFragment.f16299l);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
