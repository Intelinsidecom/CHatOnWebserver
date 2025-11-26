package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1416g;
import com.sec.chaton.p035io.entry.GetContentCategoryList;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.p035io.entry.specialbuddy.LivepartnerLikesCountEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hs */
/* loaded from: classes.dex */
class HandlerC0762hs extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3029a;

    HandlerC0762hs(SpecialBuddyFragment specialBuddyFragment) {
        this.f3029a = specialBuddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws RemoteException, OperationApplicationException {
        if (this.f3029a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 317) {
                this.f3029a.m3908k();
                if (c0267d.m11704n()) {
                    String strM4001b = this.f3029a.f2302g != null ? this.f3029a.f2302g.m4001b() : null;
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        this.f3029a.f2311p = true;
                        C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.livepartner_now_following, strM4001b), 0).show();
                        if (!GlobalApplication.m6456e()) {
                            this.f3029a.m3874a(this.f3029a.f2302g, this.f3029a.f2311p);
                            return;
                        } else {
                            this.f3029a.getActivity().finish();
                            return;
                        }
                    }
                    C3250y.m11458g("Follow LivePartner, faultCode: " + c0267d.m1355f(), null);
                    C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.livepartner_failed_to_follow, strM4001b), 0).show();
                    return;
                }
                return;
            }
            if (message.what == 318) {
                this.f3029a.m3908k();
                if (c0267d.m11704n()) {
                    String strM4001b2 = this.f3029a.f2302g != null ? this.f3029a.f2302g.m4001b() : null;
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        this.f3029a.f2311p = false;
                        C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.livepartner_no_longer_following, strM4001b2), 0).show();
                        if (!GlobalApplication.m6456e() || this.f3029a.f2288Y == null || !(this.f3029a.f2288Y instanceof InterfaceC0777ig)) {
                            if (this.f3029a.f2288Y != null) {
                                this.f3029a.f2288Y.finish();
                                return;
                            }
                            return;
                        }
                        ((InterfaceC0777ig) this.f3029a.f2288Y).mo1325f();
                        return;
                    }
                    C3250y.m11458g("unFollow LivePartner, faultCode: " + c0267d.m1355f(), null);
                    C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.livepartner_failed_to_unfollow, strM4001b2), 0).show();
                    return;
                }
                return;
            }
            if (message.what == 319) {
                if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                    this.f3029a.f2316u = false;
                    if (!GlobalApplication.m6456e()) {
                        this.f3029a.m3884b(this.f3029a.f2316u);
                    }
                    this.f3029a.m3871a(this.f3029a.f2308m);
                } else if (c0267d.m1354e() != null) {
                    LivepartnerLikesCountEntry livepartnerLikesCountEntry = (LivepartnerLikesCountEntry) c0267d.m1354e();
                    if (livepartnerLikesCountEntry.count != null) {
                        this.f3029a.f2308m = Integer.parseInt(livepartnerLikesCountEntry.count);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("likecount", String.valueOf(this.f3029a.f2308m));
                        contentValues.put("islike", "Y");
                        this.f3029a.f2301f.startUpdate(2, this.f3029a.f2302g, C1390ah.f5188a, contentValues, "buddy_no='" + this.f3029a.f2302g.m4000a() + "'", null);
                        this.f3029a.m3871a(this.f3029a.f2308m);
                    }
                }
                this.f3029a.m3877a(false);
                this.f3029a.m3908k();
                return;
            }
            if (message.what == 320) {
                if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                    this.f3029a.f2316u = true;
                    if (!GlobalApplication.m6456e()) {
                        this.f3029a.m3884b(this.f3029a.f2316u);
                    }
                    this.f3029a.m3871a(this.f3029a.f2308m);
                } else if (c0267d.m1354e() != null) {
                    LivepartnerLikesCountEntry livepartnerLikesCountEntry2 = (LivepartnerLikesCountEntry) c0267d.m1354e();
                    if (livepartnerLikesCountEntry2.count != null) {
                        this.f3029a.f2308m = Integer.parseInt(livepartnerLikesCountEntry2.count);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("likecount", String.valueOf(this.f3029a.f2308m));
                        contentValues2.put("islike", "N");
                        this.f3029a.f2301f.startUpdate(2, this.f3029a.f2302g, C1390ah.f5188a, contentValues2, "buddy_no='" + this.f3029a.f2302g.m4000a() + "'", null);
                        this.f3029a.m3871a(this.f3029a.f2308m);
                    }
                }
                this.f3029a.m3877a(false);
                this.f3029a.m3908k();
                return;
            }
            if (message.what == 100) {
                if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                    C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(this.f3029a.f2302g.m4000a());
                this.f3029a.f2303h.m5791a("true", arrayList);
                return;
            }
            if (message.what == 316) {
                if (this.f3029a.f2280Q != null) {
                    this.f3029a.f2280Q.setVisibility(8);
                }
                this.f3029a.m3911l();
                if (this.f3029a.f2311p) {
                }
                this.f3029a.f2312q = false;
                if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                    C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.dev_network_error), 0).show();
                    return;
                }
                GetContentCategoryList getContentCategoryList = (GetContentCategoryList) c0267d.m1354e();
                if (C3250y.f11734b) {
                    C3250y.m11450b("categoryList.bFollowCount : " + getContentCategoryList.followcount + ", categoryList.nLikeCount : " + getContentCategoryList.likecount, getClass().getSimpleName());
                }
                if (!TextUtils.isEmpty(getContentCategoryList.likecount)) {
                    this.f3029a.f2308m = Integer.parseInt(getContentCategoryList.likecount);
                } else {
                    this.f3029a.f2308m = 0;
                }
                if (!TextUtils.isEmpty(getContentCategoryList.followcount)) {
                    this.f3029a.f2310o = Long.parseLong(getContentCategoryList.followcount);
                } else {
                    this.f3029a.f2310o = 0L;
                }
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                if (this.f3029a.f2302g != null) {
                    SpecialUser specialUser = new SpecialUser();
                    specialUser.followcount = getContentCategoryList.followcount;
                    this.f3029a.m3871a(this.f3029a.f2308m);
                    this.f3029a.m3872a(this.f3029a.f2310o);
                    if (this.f3029a.f2311p) {
                        arrayList2.add(C1360d.m6018a(this.f3029a.f2288Y.getContentResolver(), this.f3029a.m3928a(this.f3029a.f2302g, specialUser)));
                        try {
                            this.f3029a.f2288Y.getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                            return;
                        } catch (OperationApplicationException e) {
                            e.printStackTrace();
                            return;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (message.what == 321) {
                if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                    C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.dev_network_error), 0).show();
                    return;
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("Get Following buddy's info isConnectionSuccess()=" + c0267d.m11704n() + ", result=" + c0267d.m1351b() + ", fault=" + c0267d.m1355f(), getClass().getSimpleName());
                }
                this.f3029a.f2301f.startQuery(1, null, C1390ah.f5188a, null, "buddy_no = ? ", new String[]{this.f3029a.f2306k}, null);
                return;
            }
            if (message.what == 303) {
                this.f3029a.m3908k();
                if (c0267d.m11704n()) {
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        this.f3029a.f2311p = true;
                        if (this.f3029a.f2302g != null) {
                            C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.add_buddy_added, this.f3029a.f2302g.m4001b()), 0).show();
                        } else {
                            C3641ai.m13210a(this.f3029a.f2288Y, R.string.buddy_suggestion_added_to_list, 0).show();
                        }
                        this.f3029a.m3894e();
                        this.f3029a.m3874a(this.f3029a.f2302g, this.f3029a.f2311p);
                        this.f3029a.f2301f.startDelete(5, null, C1388af.f5186a, "buddy_no = ? ", new String[]{this.f3029a.f2306k});
                        return;
                    }
                    if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                        if (this.f3029a.f2302g != null) {
                            AbstractC3271a.m11494a(this.f3029a.f2288Y).mo11500a(this.f3029a.getResources().getString(R.string.toast_error)).mo11509b(String.format(this.f3029a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f3029a.f2302g.m4001b())).mo11510b(this.f3029a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0763ht(this)).mo11512b();
                            return;
                        }
                        return;
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11458g("ADD BUDDY RESULT : " + c0267d.m1355f(), null);
                    }
                    if (c0267d.m1355f() == 16003) {
                        C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self), 0).show();
                    } else if (c0267d.m1355f() == 16004) {
                        C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added), 0).show();
                    } else if (c0267d.m1355f() == 16005) {
                        C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy), 0).show();
                    } else {
                        C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed), 0).show();
                    }
                    AbstractC3271a.m11494a(this.f3029a.f2288Y).mo11500a(this.f3029a.getResources().getString(R.string.toast_error)).mo11509b("").mo11510b(this.f3029a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0764hu(this)).mo11512b();
                    return;
                }
                return;
            }
            if (message.what == 602) {
                this.f3029a.m3908k();
                if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                    C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                    return;
                }
                C1379w.m6203a(new C1379w(), 2, new C1416g(this.f3029a.f2298c, this.f3029a.m3927a(this.f3029a.f2302g), 2, false));
                this.f3029a.f2311p = false;
                this.f3029a.m3894e();
                this.f3029a.m3874a(this.f3029a.f2302g, this.f3029a.f2311p);
                this.f3029a.f2288Y.finish();
                return;
            }
            if (message.what == 603) {
                if (this.f3029a.f2304i != null && this.f3029a.f2304i.isShowing()) {
                    this.f3029a.m3908k();
                }
                if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("isNew", "Y");
                    this.f3029a.f2301f.startUpdate(0, null, C1390ah.f5188a, contentValues3, "buddy_no='" + this.f3029a.f2306k + "'", null);
                    this.f3029a.f2311p = true;
                    this.f3029a.m3894e();
                    this.f3029a.m3874a(this.f3029a.f2302g, this.f3029a.f2311p);
                    this.f3029a.f2288Y.finish();
                    return;
                }
                C3641ai.m13211a(this.f3029a.f2288Y, this.f3029a.getResources().getString(R.string.setting_buddy_unblocked, this.f3029a.f2306k), 0).show();
                return;
            }
            if (message.what == 306) {
                if (this.f3029a.f2304i != null && this.f3029a.f2304i.isShowing()) {
                    this.f3029a.m3908k();
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("check buddy isConnectionSuccess()=" + c0267d.m11704n() + ", result=" + c0267d.m1351b() + ", fault=" + c0267d.m1355f(), "BUDDY PROFILE");
                }
                if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.ERROR && c0267d.m1355f() == 16005) {
                    this.f3029a.f2282S.setVisibility(0);
                    this.f3029a.f2283T.setVisibility(8);
                    this.f3029a.f2284U.setVisibility(8);
                    this.f3029a.f2285V.setVisibility(0);
                    this.f3029a.f2286W.setVisibility(0);
                    this.f3029a.f2281R.setText(this.f3029a.getResources().getString(R.string.new_buddy_information_unblock, this.f3029a.f2314s.getText().toString()));
                    return;
                }
                if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.ERROR || c0267d.m1355f() != 15009) {
                    this.f3029a.f2283T.setVisibility(0);
                    this.f3029a.f2285V.setVisibility(8);
                    this.f3029a.f2286W.setVisibility(8);
                    this.f3029a.f2281R.setText(this.f3029a.getResources().getString(R.string.new_buddy_information, this.f3029a.f2314s.getText().toString()));
                    return;
                }
                this.f3029a.f2281R.setText(this.f3029a.getResources().getString(R.string.toast_deleted_account, this.f3029a.f2314s.getText().toString()));
            }
        }
    }
}
