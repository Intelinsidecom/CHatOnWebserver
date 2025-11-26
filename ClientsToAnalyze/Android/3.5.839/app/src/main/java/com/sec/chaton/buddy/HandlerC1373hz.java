package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1107d;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p065io.entry.GetContentCategoryList;
import com.sec.chaton.p065io.entry.GetSpecialUserList;
import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.p065io.entry.specialbuddy.LivepartnerLikesCountEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import java.util.Iterator;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hz */
/* loaded from: classes.dex */
class HandlerC1373hz extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4973a;

    HandlerC1373hz(SpecialBuddyFragment specialBuddyFragment) {
        this.f4973a = specialBuddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f4973a.getActivity() != null && this.f4973a.f4151j != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (message.what == 317) {
                if (c0778b.m18954n()) {
                    String strM7084b = this.f4973a.f4148g != null ? this.f4973a.f4148g.m7084b() : null;
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        this.f4973a.f4136O = true;
                        this.f4973a.m6964a((CharSequence) this.f4973a.getResources().getString(R.string.livepartner_now_following, strM7084b));
                        this.f4973a.m6962a(this.f4973a.f4148g, this.f4973a.f4136O, false);
                        return;
                    } else {
                        C4904y.m18639b("Follow LivePartner, faultCode: " + c0778b.m3111f(), null);
                        this.f4973a.m6964a((CharSequence) this.f4973a.getResources().getString(R.string.livepartner_failed_to_follow, strM7084b));
                        return;
                    }
                }
                return;
            }
            if (message.what == 318) {
                this.f4973a.m6989g();
                if (c0778b.m18954n()) {
                    String strM7084b2 = this.f4973a.f4148g != null ? this.f4973a.f4148g.m7084b() : null;
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        this.f4973a.f4136O = false;
                        this.f4973a.m6964a((CharSequence) this.f4973a.getResources().getString(R.string.livepartner_no_longer_following, strM7084b2));
                        return;
                    } else {
                        C4904y.m18639b("unFollow LivePartner, faultCode: " + c0778b.m3111f(), null);
                        this.f4973a.m6964a((CharSequence) this.f4973a.getResources().getString(R.string.livepartner_failed_to_unfollow, strM7084b2));
                        return;
                    }
                }
                return;
            }
            if (message.what == 319) {
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    this.f4973a.f4138Q = false;
                    this.f4973a.m6973b(this.f4973a.f4138Q);
                    this.f4973a.m6958a(this.f4973a.f4132K);
                } else if (c0778b.m3110e() != null) {
                    LivepartnerLikesCountEntry livepartnerLikesCountEntry = (LivepartnerLikesCountEntry) c0778b.m3110e();
                    if (livepartnerLikesCountEntry.count != null) {
                        this.f4973a.f4132K = Integer.parseInt(livepartnerLikesCountEntry.count);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("likecount", String.valueOf(this.f4973a.f4132K));
                        contentValues.put("islike", "Y");
                        this.f4973a.f4146e.startUpdate(502, this.f4973a.f4148g, C2230ar.f7958a, contentValues, "buddy_no='" + this.f4973a.f4148g.m7082a() + "'", null);
                        this.f4973a.m6958a(this.f4973a.f4132K);
                    }
                }
                this.f4973a.m6966a(false);
                this.f4973a.m6989g();
                return;
            }
            if (message.what == 320) {
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    this.f4973a.f4138Q = true;
                    this.f4973a.m6973b(this.f4973a.f4138Q);
                    this.f4973a.m6958a(this.f4973a.f4132K);
                } else if (c0778b.m3110e() != null) {
                    LivepartnerLikesCountEntry livepartnerLikesCountEntry2 = (LivepartnerLikesCountEntry) c0778b.m3110e();
                    if (livepartnerLikesCountEntry2.count != null) {
                        this.f4973a.f4132K = Integer.parseInt(livepartnerLikesCountEntry2.count);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("likecount", String.valueOf(this.f4973a.f4132K));
                        contentValues2.put("islike", "N");
                        this.f4973a.f4146e.startUpdate(502, this.f4973a.f4148g, C2230ar.f7958a, contentValues2, "buddy_no='" + this.f4973a.f4148g.m7082a() + "'", null);
                        this.f4973a.m6958a(this.f4973a.f4132K);
                    }
                }
                this.f4973a.m6966a(false);
                this.f4973a.m6989g();
                return;
            }
            if (message.what == 316) {
                if (this.f4973a.f4153l != null) {
                    this.f4973a.f4153l.setVisibility(8);
                }
                this.f4973a.f4137P = false;
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    this.f4973a.m6970b(R.string.dev_network_error);
                    return;
                }
                GetContentCategoryList getContentCategoryList = (GetContentCategoryList) c0778b.m3110e();
                if (C4904y.f17872b) {
                    C4904y.m18639b("categoryList.bFollowCount : " + getContentCategoryList.followcount + ", categoryList.nLikeCount : " + getContentCategoryList.likecount, getClass().getSimpleName());
                }
                if (!TextUtils.isEmpty(getContentCategoryList.likecount)) {
                    this.f4973a.f4132K = Integer.parseInt(getContentCategoryList.likecount);
                } else {
                    this.f4973a.f4132K = 0;
                }
                if (!TextUtils.isEmpty(getContentCategoryList.followcount)) {
                    this.f4973a.f4134M = Long.parseLong(getContentCategoryList.followcount);
                } else {
                    this.f4973a.f4134M = 0L;
                }
                if (this.f4973a.f4148g != null) {
                    this.f4973a.f4148g.m7083a(String.valueOf(this.f4973a.f4134M));
                    this.f4973a.f4148g.m7085b(String.valueOf(this.f4973a.f4132K));
                }
                this.f4973a.m6958a(this.f4973a.f4132K);
                this.f4973a.m6959a(this.f4973a.f4134M);
                return;
            }
            if (message.what == 334) {
                this.f4973a.m6989g();
                if (!c0778b.m18954n()) {
                    this.f4973a.f4151j.finish();
                    this.f4973a.m6970b(R.string.dev_network_error);
                    return;
                }
                if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    Iterator<SpecialUser> it = ((GetSpecialUserList) c0778b.m3110e()).specialuser.iterator();
                    if (it.hasNext()) {
                        SpecialUser next = it.next();
                        this.f4973a.f4131J = next.name;
                        this.f4973a.f4148g = C1107d.m7078a(next);
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("result code : " + c0778b.m3107b() + ", " + c0778b.m18953m() + ", GET_SPECIALBUDDY_PROFILE : " + this.f4973a.f4131J, getClass().getSimpleName());
                    }
                    this.f4973a.m6962a(this.f4973a.f4148g, this.f4973a.f4136O, false);
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("faultCode: " + c0778b.m3111f(), getClass().getSimpleName());
                }
                String strM3112g = c0778b.m3112g();
                if (c0778b.m3111f() != 46001 && c0778b.m3111f() == 46002) {
                }
                AbstractC4932a.m18733a(this.f4973a.f4151j).mo18740a(this.f4973a.getResources().getString(R.string.toast_error)).mo18749b(strM3112g).mo18755c(this.f4973a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1375ia(this));
                return;
            }
            if (message.what == 321) {
                this.f4973a.m6989g();
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    this.f4973a.m6970b(R.string.dev_network_error);
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("Get Following buddy's info isConnectionSuccess()=" + c0778b.m18954n() + ", result=" + c0778b.m3107b() + ", fault=" + c0778b.m3111f(), getClass().getSimpleName());
                }
                this.f4973a.f4146e.startQuery(501, null, C2230ar.f7958a, null, "buddy_no = ? ", new String[]{this.f4973a.f4130I}, null);
            }
        }
    }
}
