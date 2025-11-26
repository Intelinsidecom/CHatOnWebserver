package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.C1206cg;
import com.sec.chaton.p035io.entry.CheckBuddyList;
import com.sec.chaton.p035io.entry.inner.CheckBuddy;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ew */
/* loaded from: classes.dex */
class HandlerC0685ew extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2907a;

    HandlerC0685ew(BuddyProfileFragment buddyProfileFragment) {
        this.f2907a = buddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws RemoteException, OperationApplicationException {
        C0267d c0267d = (C0267d) message.obj;
        if (!GlobalApplication.m6456e() || this.f2907a.getActivity() != null) {
            if (message.what == 306) {
                C3250y.m11450b("check buddy isConnectionSuccess()=" + c0267d.m11704n() + ", result=" + c0267d.m1351b() + ", fault=" + c0267d.m1355f(), "BUDDY PROFILE");
                if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.ERROR && c0267d.m1355f() == 16005) {
                    this.f2907a.f2059aR.setVisibility(8);
                    this.f2907a.f2060aS.setVisibility(8);
                    this.f2907a.f2061aT.setVisibility(8);
                    this.f2907a.f2063aV.setVisibility(0);
                    this.f2907a.f2064aW.setText(this.f2907a.getResources().getString(R.string.new_buddy_information_unblock, this.f2907a.f2032Q.getText().toString()));
                } else if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.ERROR && c0267d.m1355f() == 15009) {
                    this.f2907a.f2059aR.setVisibility(8);
                    this.f2907a.f2060aS.setVisibility(8);
                    this.f2907a.f2061aT.setVisibility(8);
                    this.f2907a.f2063aV.setVisibility(8);
                    this.f2907a.f2064aW.setText(this.f2907a.getResources().getString(R.string.toast_deleted_account, this.f2907a.f2032Q.getText().toString()));
                    if (this.f2907a.f2051aJ) {
                        ContentResolver contentResolver = this.f2907a.getActivity().getContentResolver();
                        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                        arrayList.add(C1206cg.m5544a(this.f2907a.f2117t));
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
                } else if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.ERROR && c0267d.m1355f() == 50005) {
                    this.f2907a.f2059aR.setVisibility(8);
                    this.f2907a.f2060aS.setVisibility(8);
                    this.f2907a.f2061aT.setVisibility(8);
                    this.f2907a.f2063aV.setVisibility(8);
                    this.f2907a.f2064aW.setText(this.f2907a.getResources().getString(R.string.samsung_account_mapping_not_finished));
                } else if (!c0267d.m11704n()) {
                    this.f2907a.m3681k();
                } else {
                    if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                        if (this.f2907a.f2051aJ) {
                            this.f2907a.f2064aW.setText(this.f2907a.getResources().getString(R.string.new_buddy_information, this.f2907a.f2032Q.getText().toString()));
                        } else {
                            this.f2907a.f2064aW.setText(this.f2907a.getResources().getString(R.string.privacy_dialog_not_added_user, this.f2907a.f2032Q.getText().toString()));
                        }
                    } else {
                        CheckBuddyList checkBuddyList = (CheckBuddyList) c0267d.m1354e();
                        if (checkBuddyList == null) {
                            this.f2907a.m3685m();
                            this.f2907a.m3681k();
                            return;
                        }
                        ArrayList<CheckBuddy> arrayList2 = checkBuddyList.buddy;
                        if (arrayList2 == null || arrayList2.size() == 0) {
                            this.f2907a.m3685m();
                            this.f2907a.m3681k();
                            return;
                        }
                        for (int i = 0; i < arrayList2.size(); i++) {
                            CheckBuddy checkBuddy = arrayList2.get(i);
                            if (!checkBuddy.authenticated.booleanValue()) {
                                this.f2907a.f2064aW.setText(this.f2907a.getResources().getString(R.string.privacy_dialog_not_identified_user, this.f2907a.f2032Q.getText().toString()));
                                this.f2907a.f2065aX.setVisibility(0);
                            } else if (TextUtils.isEmpty(checkBuddy.countrycode) || checkBuddy.countrycode.equalsIgnoreCase(C3171am.m11082t())) {
                                if (this.f2907a.f2051aJ) {
                                    this.f2907a.f2064aW.setText(this.f2907a.getResources().getString(R.string.new_buddy_information, this.f2907a.f2032Q.getText().toString()));
                                } else {
                                    this.f2907a.f2064aW.setText(this.f2907a.getResources().getString(R.string.privacy_dialog_not_added_user, this.f2907a.f2032Q.getText().toString()));
                                }
                            } else {
                                this.f2907a.f2064aW.setText(this.f2907a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f2907a.f2032Q.getText().toString()));
                                if (this.f2907a.m3663f(checkBuddy.countrycode)) {
                                    this.f2907a.m3667g(checkBuddy.countrycode);
                                } else {
                                    this.f2907a.m3671h(checkBuddy.countrycode);
                                }
                                this.f2907a.f2094ba = checkBuddy.countrycode;
                            }
                        }
                    }
                    this.f2907a.f2059aR.setVisibility(0);
                    if (this.f2907a.f2051aJ) {
                        this.f2907a.f2062aU.setVisibility(0);
                        this.f2907a.f2061aT.setVisibility(8);
                    } else {
                        this.f2907a.f2060aS.setVisibility(0);
                        this.f2907a.f2062aU.setVisibility(8);
                        this.f2907a.f2061aT.setVisibility(0);
                    }
                    this.f2907a.f2063aV.setVisibility(8);
                }
            }
            this.f2907a.m3685m();
        }
    }
}
