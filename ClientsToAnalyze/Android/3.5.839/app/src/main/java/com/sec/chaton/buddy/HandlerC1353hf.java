package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.util.Iterator;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.hf */
/* loaded from: classes.dex */
class HandlerC1353hf extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f4932a;

    HandlerC1353hf(BuddyRecommendFragment buddyRecommendFragment) {
        this.f4932a = buddyRecommendFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException, NumberFormatException {
        String string;
        C0778b c0778b = (C0778b) message.obj;
        if (this.f4932a.f4066A != null) {
            this.f4932a.m6932d();
            if (message.what == 303) {
                this.f4932a.f4089q = false;
                if (!c0778b.m18954n()) {
                    AbstractC4932a.m18733a(this.f4932a.f4066A).mo18740a(this.f4932a.getResources().getString(R.string.toast_error)).mo18749b(this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo18755c(this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1354hg(this)).mo18741a(this.f4932a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                } else if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    this.f4932a.f4089q = true;
                    GetBuddyList getBuddyList = (GetBuddyList) c0778b.m3110e();
                    if (getBuddyList != null) {
                        this.f4932a.f4085m = getBuddyList.buddy.get(0).name;
                    }
                    C5179v.m19811a(this.f4932a.f4066A, this.f4932a.getResources().getString(R.string.add_buddy_added, this.f4932a.f4085m), 0).show();
                    this.f4932a.f4077e.notifyDataSetChanged();
                } else if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                    this.f4932a.f4085m = BuddyRecommendFragment.m6903a(this.f4932a.f4066A.getContentResolver(), this.f4932a.f4083k);
                    this.f4932a.m6910a(this.f4932a.getResources().getString(R.string.toast_error), String.format(this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f4932a.f4085m));
                } else {
                    C4904y.m18639b("ADD BUDDY RESULT : " + c0778b.m3111f(), null);
                    if (c0778b.m3111f() == 16003) {
                        string = this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0778b.m3111f() == 16004) {
                        string = this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0778b.m3111f() == 16005) {
                        string = this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else if (c0778b.m3111f() == 50005) {
                        string = this.f4932a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                    } else {
                        string = this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    this.f4932a.m6910a(this.f4932a.getResources().getString(R.string.toast_error), string);
                }
            } else if (message.what == 311) {
                if (c0778b.m18954n()) {
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        Iterator<Buddy> it = ((GetBuddyList) c0778b.m3110e()).buddy.iterator();
                        int i = 0;
                        int i2 = 0;
                        while (it.hasNext()) {
                            Buddy next = it.next();
                            int i3 = Integer.parseInt(next.result);
                            if (next.result != null && i3 > 0) {
                                i2++;
                            }
                            i++;
                            if (next.value.startsWith("+")) {
                                next.value.substring(1, next.value.length());
                            } else {
                                String str = next.value;
                            }
                        }
                        this.f4932a.f4093u.setVisibility(8);
                        String str2 = String.format(this.f4932a.getResources().getString(R.string.suggestion_add_all_buddies_failed_popup), Integer.valueOf(i - i2), Integer.valueOf(i));
                        if (i2 == 0) {
                            if (this.f4932a.getActivity() != null) {
                                C5179v.m19811a(this.f4932a.getActivity(), this.f4932a.getResources().getString(R.string.tellfriends_added), 0).show();
                            }
                        } else {
                            AbstractC4932a.m18733a(this.f4932a.getActivity()).mo18740a(this.f4932a.getResources().getString(R.string.edit_group_add_member)).mo18749b(str2).mo18755c(this.f4932a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1355hh(this)).mo18741a(this.f4932a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                        }
                    } else {
                        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                        if (-3 == iM10677a || -2 == iM10677a) {
                            this.f4932a.getResources().getString(R.string.popup_no_network_connection);
                        } else if (c0778b.m3111f() == 16003) {
                            this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                        } else if (c0778b.m3111f() == 16004) {
                            this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                        } else if (c0778b.m3111f() == 16005) {
                            this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                        } else if (c0778b.m3111f() == 50005) {
                            this.f4932a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                        } else {
                            this.f4932a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                        }
                    }
                } else {
                    int iM10677a2 = C2471v.m10677a(CommonApplication.m18732r());
                    if (-3 == iM10677a2 || -2 == iM10677a2) {
                        C5179v.m19810a(this.f4932a.getActivity(), R.string.popup_no_network_connection, 0).show();
                    }
                }
            } else if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                C5179v.m19811a(this.f4932a.f4066A, this.f4932a.getResources().getString(R.string.done), 0).show();
            } else {
                C5179v.m19810a(this.f4932a.f4066A, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            }
            this.f4932a.f4091s.startQuery(1, null, C2228ap.f7956a, null, null, null, null);
        }
    }
}
