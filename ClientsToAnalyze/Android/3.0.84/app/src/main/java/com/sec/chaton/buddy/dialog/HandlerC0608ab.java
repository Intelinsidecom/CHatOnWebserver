package com.sec.chaton.buddy.dialog;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p035io.entry.GetContentCategoryList;
import com.sec.chaton.p035io.entry.inner.ContentCategory;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.p035io.entry.specialbuddy.LivepartnerLikesCountEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ab */
/* loaded from: classes.dex */
class HandlerC0608ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f2823a;

    HandlerC0608ab(SpecialBuddyDialog specialBuddyDialog) {
        this.f2823a = specialBuddyDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws RemoteException, OperationApplicationException {
        C0267d c0267d = (C0267d) message.obj;
        if (message.what == 319) {
            if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                this.f2823a.m4296c();
                ContentValues contentValues = new ContentValues();
                contentValues.put("likecount", String.valueOf(this.f2823a.f2805k));
                contentValues.put("islike", "N");
                this.f2823a.f2798d.startUpdate(2, this.f2823a.f2799e, C1390ah.f5188a, contentValues, "buddy_no='" + this.f2823a.f2799e.m4000a() + "'", null);
            } else if (c0267d.m1354e() != null) {
                LivepartnerLikesCountEntry livepartnerLikesCountEntry = (LivepartnerLikesCountEntry) c0267d.m1354e();
                if (!this.f2823a.f2815u) {
                    this.f2823a.f2815u = true;
                    if (livepartnerLikesCountEntry.count != null) {
                        this.f2823a.f2805k = Integer.parseInt(livepartnerLikesCountEntry.count);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("likecount", String.valueOf(this.f2823a.f2805k));
                        contentValues2.put("islike", "Y");
                        this.f2823a.f2798d.startUpdate(2, this.f2823a.f2799e, C1390ah.f5188a, contentValues2, "buddy_no='" + this.f2823a.f2799e.m4000a() + "'", null);
                    }
                    this.f2823a.m4296c();
                }
            }
            this.f2823a.m4298c(false);
        } else if (message.what == 320) {
            if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                this.f2823a.m4296c();
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("likecount", String.valueOf(this.f2823a.f2805k));
                contentValues3.put("islike", "N");
                this.f2823a.f2798d.startUpdate(2, this.f2823a.f2799e, C1390ah.f5188a, contentValues3, "buddy_no='" + this.f2823a.f2799e.m4000a() + "'", null);
            } else if (c0267d.m1354e() != null) {
                LivepartnerLikesCountEntry livepartnerLikesCountEntry2 = (LivepartnerLikesCountEntry) c0267d.m1354e();
                if (this.f2823a.f2815u) {
                    this.f2823a.f2815u = false;
                    if (livepartnerLikesCountEntry2.count != null) {
                        this.f2823a.f2805k = Integer.parseInt(livepartnerLikesCountEntry2.count);
                        ContentValues contentValues4 = new ContentValues();
                        contentValues4.put("likecount", String.valueOf(this.f2823a.f2805k));
                        contentValues4.put("islike", "N");
                        this.f2823a.f2798d.startUpdate(2, this.f2823a.f2799e, C1390ah.f5188a, contentValues4, "buddy_no='" + this.f2823a.f2799e.m4000a() + "'", null);
                    }
                    this.f2823a.m4296c();
                }
            }
            this.f2823a.m4298c(false);
        } else if (message.what == 316) {
            if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                GetContentCategoryList getContentCategoryList = (GetContentCategoryList) c0267d.m1354e();
                C3250y.m11450b("categoryList.bFollowCount : " + getContentCategoryList.followcount + " categoryList.nLikeCount" + getContentCategoryList.likecount, "SpecialBuddyDialog");
                this.f2823a.f2805k = Integer.parseInt(getContentCategoryList.likecount);
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                if (this.f2823a.f2799e != null) {
                    SpecialUser specialUser = new SpecialUser();
                    specialUser.followcount = getContentCategoryList.followcount;
                    specialUser.likecount = getContentCategoryList.likecount;
                    arrayList.add(C1360d.m6018a(this.f2823a.getContentResolver(), this.f2823a.m4323a(this.f2823a.f2799e, specialUser)));
                    try {
                        this.f2823a.getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                    } catch (OperationApplicationException e) {
                        e.printStackTrace();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
                StringBuilder sb = new StringBuilder();
                Iterator<ContentCategory> it = getContentCategoryList.contentcategory.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().name);
                    if (!TextUtils.isEmpty(getContentCategoryList.contentcategory.toString())) {
                        sb.append(", ");
                    }
                }
                if (sb != null && sb.length() > 0) {
                    sb.delete(sb.length() - 2, sb.length() - 1);
                }
            } else {
                C3641ai.m13211a(CommonApplication.m11493l(), this.f2823a.getResources().getString(R.string.dev_network_error), 0).show();
            }
        } else if (message.what == 306) {
            if (C3250y.f11734b) {
                C3250y.m11450b("check buddy isConnectionSuccess()=" + c0267d.m11704n() + ", result=" + c0267d.m1351b() + ", fault=" + c0267d.m1355f(), "BUDDY PROFILE");
            }
        } else if (message.what == 317) {
            if (c0267d.m11704n()) {
                String strM4001b = this.f2823a.f2799e != null ? this.f2823a.f2799e.m4001b() : null;
                if (strM4001b == null) {
                    strM4001b = this.f2823a.f2804j;
                }
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    this.f2823a.f2807m = true;
                    C3641ai.m13211a(this.f2823a.f2802h, this.f2823a.getResources().getString(R.string.livepartner_now_following, strM4001b), 0).show();
                    this.f2823a.finish();
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Follow LivePartner, faultCode: " + c0267d.m1355f(), "SpecialBuddyDialog");
                    }
                    C3641ai.m13211a(this.f2823a.f2802h, this.f2823a.getResources().getString(R.string.livepartner_failed_to_follow, strM4001b), 0).show();
                }
            }
        } else if (message.what == 318 && c0267d.m11704n()) {
            EnumC1587o enumC1587oM1351b = c0267d.m1351b();
            String strM4001b2 = this.f2823a.f2799e != null ? this.f2823a.f2799e.m4001b() : null;
            if (enumC1587oM1351b == EnumC1587o.SUCCESS) {
                this.f2823a.f2807m = false;
                C1357af.m6000d(CommonApplication.m11493l().getContentResolver(), this.f2823a.f2803i);
                C3641ai.m13211a(this.f2823a.f2802h, this.f2823a.getResources().getString(R.string.livepartner_no_longer_following, strM4001b2), 0).show();
                this.f2823a.finish();
            } else {
                if (C3250y.f11734b) {
                    C3250y.m11450b("unFollow LivePartner, faultCode: " + c0267d.m1355f(), "SpecialBuddyDialog");
                }
                C3641ai.m13211a(this.f2823a.f2802h, this.f2823a.getResources().getString(R.string.livepartner_failed_to_unfollow, strM4001b2), 0).show();
            }
        }
        this.f2823a.m4309g();
    }
}
