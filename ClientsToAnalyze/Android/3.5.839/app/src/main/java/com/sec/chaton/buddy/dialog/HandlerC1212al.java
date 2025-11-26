package com.sec.chaton.buddy.dialog;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1063bc;
import com.sec.chaton.EnumC1064bd;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1107d;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p065io.entry.GetContentCategoryList;
import com.sec.chaton.p065io.entry.GetSpecialUserList;
import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.p065io.entry.specialbuddy.LivepartnerLikesCountEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.Iterator;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.al */
/* loaded from: classes.dex */
class HandlerC1212al extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f4707a;

    HandlerC1212al(SpecialBuddyDialog specialBuddyDialog) {
        this.f4707a = specialBuddyDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2 = true;
        C0778b c0778b = (C0778b) message.obj;
        if (this.f4707a.f4676h != null) {
            if (message.what == 319) {
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    this.f4707a.m7370d();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("likecount", String.valueOf(this.f4707a.f4680l));
                    contentValues.put("islike", "N");
                    this.f4707a.f4672d.startUpdate(502, this.f4707a.f4673e, C2230ar.f7958a, contentValues, "buddy_no='" + this.f4707a.f4673e.m7082a() + "'", null);
                } else if (c0778b.m3110e() != null) {
                    LivepartnerLikesCountEntry livepartnerLikesCountEntry = (LivepartnerLikesCountEntry) c0778b.m3110e();
                    if (!this.f4707a.f4693y) {
                        this.f4707a.f4693y = true;
                        if (livepartnerLikesCountEntry.count != null) {
                            this.f4707a.f4680l = Integer.parseInt(livepartnerLikesCountEntry.count);
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("likecount", String.valueOf(this.f4707a.f4680l));
                            contentValues2.put("islike", "Y");
                            this.f4707a.f4672d.startUpdate(502, this.f4707a.f4673e, C2230ar.f7958a, contentValues2, "buddy_no='" + this.f4707a.f4673e.m7082a() + "'", null);
                        }
                        this.f4707a.m7370d();
                    }
                }
                this.f4707a.m7365b(false);
            } else if (message.what == 320) {
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    this.f4707a.m7370d();
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("likecount", String.valueOf(this.f4707a.f4680l));
                    contentValues3.put("islike", "N");
                    this.f4707a.f4672d.startUpdate(502, this.f4707a.f4673e, C2230ar.f7958a, contentValues3, "buddy_no='" + this.f4707a.f4673e.m7082a() + "'", null);
                } else if (c0778b.m3110e() != null) {
                    LivepartnerLikesCountEntry livepartnerLikesCountEntry2 = (LivepartnerLikesCountEntry) c0778b.m3110e();
                    if (this.f4707a.f4693y) {
                        this.f4707a.f4693y = false;
                        if (livepartnerLikesCountEntry2.count != null) {
                            this.f4707a.f4680l = Integer.parseInt(livepartnerLikesCountEntry2.count);
                            ContentValues contentValues4 = new ContentValues();
                            contentValues4.put("likecount", String.valueOf(this.f4707a.f4680l));
                            contentValues4.put("islike", "N");
                            this.f4707a.f4672d.startUpdate(502, this.f4707a.f4673e, C2230ar.f7958a, contentValues4, "buddy_no='" + this.f4707a.f4673e.m7082a() + "'", null);
                        }
                        this.f4707a.m7370d();
                    }
                }
                this.f4707a.m7365b(false);
            } else if (message.what == 316) {
                if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    GetContentCategoryList getContentCategoryList = (GetContentCategoryList) c0778b.m3110e();
                    if (C4904y.f17872b) {
                        C4904y.m18639b("categoryList.bFollowCount : " + getContentCategoryList.followcount + " categoryList.nLikeCount" + getContentCategoryList.likecount, "SpecialBuddyDialog");
                    }
                    if (!TextUtils.isEmpty(getContentCategoryList.likecount)) {
                        this.f4707a.f4682n = Integer.parseInt(getContentCategoryList.likecount);
                    } else {
                        this.f4707a.f4682n = -1;
                    }
                    if (!TextUtils.isEmpty(getContentCategoryList.followcount)) {
                        this.f4707a.f4683o = Long.parseLong(getContentCategoryList.followcount);
                    } else {
                        this.f4707a.f4683o = -1L;
                    }
                    if (this.f4707a.f4673e != null) {
                        this.f4707a.f4673e.m7083a(String.valueOf(this.f4707a.f4683o));
                        this.f4707a.f4673e.m7085b(String.valueOf(this.f4707a.f4682n));
                    }
                } else {
                    C5179v.m19811a(CommonApplication.m18732r(), this.f4707a.getResources().getString(R.string.dev_network_error), 0).show();
                }
            } else if (message.what == 317) {
                if (c0778b.m18954n()) {
                    String strM7084b = this.f4707a.f4673e != null ? this.f4707a.f4673e.m7084b() : null;
                    if (strM7084b == null) {
                        strM7084b = this.f4707a.f4678j;
                    }
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        this.f4707a.f4685q = true;
                        C5179v.m19811a(this.f4707a.f4676h, this.f4707a.getResources().getString(R.string.livepartner_now_following, strM7084b), 0).show();
                        C0991aa.m6037a().m18962d(C1063bc.m6173a(EnumC1064bd.FOLLOW, this.f4707a.f4673e.m7082a()));
                        z = false;
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Follow LivePartner, faultCode: " + c0778b.m3111f(), "SpecialBuddyDialog");
                        }
                        C5179v.m19811a(this.f4707a.f4676h, this.f4707a.getResources().getString(R.string.livepartner_failed_to_follow, strM7084b), 0).show();
                        z = true;
                    }
                    z2 = z;
                }
            } else if (message.what == 318) {
                if (c0778b.m18954n()) {
                    EnumC2464o enumC2464oM3107b = c0778b.m3107b();
                    String strM7084b2 = this.f4707a.f4673e != null ? this.f4707a.f4673e.m7084b() : null;
                    if (enumC2464oM3107b == EnumC2464o.SUCCESS) {
                        this.f4707a.f4685q = false;
                        C2186al.m9777d(CommonApplication.m18732r().getContentResolver(), this.f4707a.f4677i);
                        C5179v.m19811a(this.f4707a.f4676h, this.f4707a.getResources().getString(R.string.livepartner_no_longer_following, strM7084b2), 0).show();
                        C0991aa.m6037a().m18962d(C1063bc.m6173a(EnumC1064bd.UNFOLLOW, this.f4707a.f4673e.m7082a()));
                        this.f4707a.finish();
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("unFollow LivePartner, faultCode: " + c0778b.m3111f(), "SpecialBuddyDialog");
                        }
                        C5179v.m19811a(this.f4707a.f4676h, this.f4707a.getResources().getString(R.string.livepartner_failed_to_unfollow, strM7084b2), 0).show();
                    }
                }
            } else if (message.what == 334) {
                if (c0778b.m18954n()) {
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        Iterator<SpecialUser> it = ((GetSpecialUserList) c0778b.m3110e()).specialuser.iterator();
                        if (it.hasNext()) {
                            SpecialUser next = it.next();
                            this.f4707a.f4678j = next.name;
                            this.f4707a.f4680l = Integer.parseInt(next.likecount);
                            this.f4707a.f4679k = next.msgstatus;
                            this.f4707a.f4673e = C1107d.m7078a(next);
                        }
                        if (C4904y.f17872b) {
                            C4904y.m18639b("result code : " + c0778b.m3107b() + ", " + c0778b.m18953m() + ", GET_SPECIALBUDDY_PROFILE : " + this.f4707a.f4678j, "SpecialBuddyDialog");
                        }
                        this.f4707a.m7355a();
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("faultCode: " + c0778b.m3111f(), "SpecialBuddyDialog");
                        }
                        this.f4707a.finish();
                        C5179v.m19811a(CommonApplication.m18732r(), this.f4707a.getResources().getString(R.string.dev_network_error), 0).show();
                    }
                } else {
                    this.f4707a.finish();
                    C5179v.m19811a(CommonApplication.m18732r(), this.f4707a.getResources().getString(R.string.dev_network_error), 0).show();
                }
            } else if (message.what == 321 && c0778b.m18954n()) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Sucess follow LivePartner and get my followings", "SpecialBuddyDialog");
                }
                C0991aa.m6037a().m18962d(C1063bc.m6172a(EnumC1064bd.GET_MY_FOLLOWING));
                this.f4707a.finish();
            }
            if (z2) {
                this.f4707a.m7380h();
            }
        }
    }
}
