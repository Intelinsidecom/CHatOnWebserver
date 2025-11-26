package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p065io.entry.CheckBuddyList;
import com.sec.chaton.p065io.entry.inner.CheckBuddy;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fy */
/* loaded from: classes.dex */
class HandlerC1318fy extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4854a;

    HandlerC1318fy(BuddyProfileFragment buddyProfileFragment) {
        this.f4854a = buddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws RemoteException, OperationApplicationException {
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 306) {
            C4904y.m18639b("check buddy isConnectionSuccess()=" + c0778b.m18954n() + ", result=" + c0778b.m3107b() + ", fault=" + c0778b.m3111f(), "BUDDY PROFILE");
            if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.ERROR && c0778b.m3111f() == 16005) {
                this.f4854a.f3955aV.setVisibility(8);
                this.f4854a.f3956aW.setVisibility(8);
                this.f4854a.f3957aX.setVisibility(8);
                this.f4854a.f3959aZ.setVisibility(0);
                this.f4854a.f3986ba.setText(this.f4854a.getResources().getString(R.string.new_buddy_information_unblock, this.f4854a.f3926S.getText().toString()));
            } else if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.ERROR && c0778b.m3111f() == 15009) {
                this.f4854a.f3955aV.setVisibility(8);
                this.f4854a.f3956aW.setVisibility(8);
                this.f4854a.f3957aX.setVisibility(8);
                this.f4854a.f3959aZ.setVisibility(8);
                this.f4854a.f3986ba.setText(this.f4854a.getResources().getString(R.string.toast_deleted_account, this.f4854a.f3926S.getText().toString()));
                if (this.f4854a.f3947aN) {
                    ContentResolver contentResolver = this.f4854a.getActivity().getContentResolver();
                    ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                    arrayList.add(C2181ag.m9738a(this.f4854a.f4013t));
                    try {
                        contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
                    } catch (OperationApplicationException e) {
                        e.printStackTrace();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.ERROR && c0778b.m3111f() == 50005) {
                this.f4854a.f3955aV.setVisibility(8);
                this.f4854a.f3956aW.setVisibility(8);
                this.f4854a.f3957aX.setVisibility(8);
                this.f4854a.f3959aZ.setVisibility(8);
                this.f4854a.f3986ba.setText(this.f4854a.getResources().getString(R.string.samsung_account_mapping_not_finished));
            } else if (!c0778b.m18954n()) {
                this.f4854a.m6828h();
            } else {
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    if (this.f4854a.f3947aN) {
                        this.f4854a.f3986ba.setText(this.f4854a.getResources().getString(R.string.new_buddy_information, this.f4854a.f3926S.getText().toString()));
                    } else {
                        this.f4854a.f3986ba.setText(this.f4854a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f4854a.f3926S.getText().toString()));
                    }
                } else {
                    CheckBuddyList checkBuddyList = (CheckBuddyList) c0778b.m3110e();
                    if (checkBuddyList == null) {
                        this.f4854a.m6832j();
                        this.f4854a.m6828h();
                        return;
                    }
                    ArrayList<CheckBuddy> arrayList2 = checkBuddyList.buddy;
                    if (arrayList2 == null || arrayList2.size() == 0) {
                        this.f4854a.m6832j();
                        this.f4854a.m6828h();
                        return;
                    }
                    for (int i = 0; i < arrayList2.size(); i++) {
                        CheckBuddy checkBuddy = arrayList2.get(i);
                        if (!checkBuddy.authenticated.booleanValue()) {
                            this.f4854a.f3986ba.setText(this.f4854a.getResources().getString(R.string.privacy_dialog_not_identified_user, this.f4854a.f3926S.getText().toString()));
                            this.f4854a.f3987bb.setVisibility(0);
                        } else if (TextUtils.isEmpty(checkBuddy.countrycode) || checkBuddy.countrycode.equalsIgnoreCase(C4822an.m18257y())) {
                            if (this.f4854a.f3947aN) {
                                this.f4854a.f3986ba.setText(this.f4854a.getResources().getString(R.string.new_buddy_information, this.f4854a.f3926S.getText().toString()));
                            } else {
                                this.f4854a.f3986ba.setText(this.f4854a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f4854a.f3926S.getText().toString()));
                            }
                        } else {
                            this.f4854a.f3986ba.setText(this.f4854a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f4854a.f3926S.getText().toString()));
                            if (this.f4854a.m6802b(checkBuddy.countrycode)) {
                                this.f4854a.m6807c(checkBuddy.countrycode);
                            } else {
                                this.f4854a.m6811d(checkBuddy.countrycode);
                            }
                            this.f4854a.f3990be = checkBuddy.countrycode;
                        }
                    }
                }
                this.f4854a.f3955aV.setVisibility(0);
                if (this.f4854a.f3947aN) {
                    this.f4854a.f3958aY.setVisibility(0);
                    this.f4854a.f3957aX.setVisibility(8);
                } else {
                    this.f4854a.f3956aW.setVisibility(0);
                    this.f4854a.f3958aY.setVisibility(8);
                    this.f4854a.f3957aX.setVisibility(0);
                }
                this.f4854a.f3959aZ.setVisibility(8);
            }
        }
        this.f4854a.m6832j();
    }
}
