package com.sec.chaton.buddy.dialog;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.C1206cg;
import com.sec.chaton.p035io.entry.CheckBuddyList;
import com.sec.chaton.p035io.entry.inner.CheckBuddy;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.d */
/* loaded from: classes.dex */
class HandlerC0622d extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f2842a;

    HandlerC0622d(BuddyDialog buddyDialog) {
        this.f2842a = buddyDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws RemoteException, OperationApplicationException {
        C0267d c0267d = (C0267d) message.obj;
        if (message.what == 306) {
            C3250y.m11450b("check buddy isConnectionSuccess()=" + c0267d.m11704n() + ", result=" + c0267d.m1351b() + ", fault=" + c0267d.m1355f(), "BUDDY PROFILE");
            if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.ERROR && c0267d.m1355f() == 16005) {
                this.f2842a.f2664ay.setVisibility(8);
                this.f2842a.f2659at.setVisibility(0);
                this.f2842a.f2629aB.setVisibility(8);
                this.f2842a.f2628aA.setVisibility(8);
                this.f2842a.f2665az.setVisibility(8);
                this.f2842a.f2631aD.setVisibility(8);
                this.f2842a.f2660au.setVisibility(8);
                this.f2842a.f2661av.setVisibility(8);
                this.f2842a.f2662aw.setVisibility(8);
                this.f2842a.f2630aC.setVisibility(0);
                this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.new_buddy_information_unblock, this.f2842a.f2654ao.getText().toString()));
            } else if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.ERROR && c0267d.m1355f() == 15009) {
                this.f2842a.f2664ay.setVisibility(8);
                this.f2842a.f2660au.setVisibility(8);
                this.f2842a.f2659at.setVisibility(8);
                this.f2842a.f2629aB.setVisibility(8);
                this.f2842a.f2628aA.setVisibility(8);
                this.f2842a.f2665az.setVisibility(8);
                this.f2842a.f2631aD.setVisibility(8);
                this.f2842a.f2661av.setVisibility(8);
                this.f2842a.f2662aw.setVisibility(8);
                this.f2842a.f2630aC.setVisibility(8);
                this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.toast_deleted_account, this.f2842a.f2654ao.getText().toString()));
                if (this.f2842a.f2663ax) {
                    ContentResolver contentResolver = this.f2842a.getApplicationContext().getContentResolver();
                    ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                    arrayList.add(C1206cg.m5544a(this.f2842a.f2666d));
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
                this.f2842a.f2664ay.setVisibility(0);
                this.f2842a.f2660au.setVisibility(0);
                this.f2842a.f2659at.setVisibility(8);
                this.f2842a.f2629aB.setVisibility(8);
                this.f2842a.f2628aA.setVisibility(8);
                this.f2842a.f2665az.setVisibility(8);
                this.f2842a.f2631aD.setVisibility(8);
                this.f2842a.f2661av.setVisibility(8);
                this.f2842a.f2662aw.setVisibility(8);
                this.f2842a.f2630aC.setVisibility(8);
                this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.samsung_account_mapping_not_finished));
            } else if (!c0267d.m11704n()) {
                this.f2842a.m4174p();
            } else {
                if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                    if (this.f2842a.f2663ax) {
                        this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.new_buddy_information, this.f2842a.f2654ao.getText().toString()));
                    } else {
                        this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f2842a.f2654ao.getText().toString()));
                    }
                } else {
                    CheckBuddyList checkBuddyList = (CheckBuddyList) c0267d.m1354e();
                    if (checkBuddyList == null) {
                        this.f2842a.m4186v();
                        this.f2842a.m4174p();
                        return;
                    }
                    ArrayList<CheckBuddy> arrayList2 = checkBuddyList.buddy;
                    if (arrayList2 == null || arrayList2.size() == 0) {
                        this.f2842a.m4186v();
                        this.f2842a.m4174p();
                        return;
                    }
                    for (int i = 0; i < arrayList2.size(); i++) {
                        CheckBuddy checkBuddy = arrayList2.get(i);
                        if (!checkBuddy.authenticated.booleanValue()) {
                            if (this.f2842a.f2663ax) {
                                this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.new_buddy_information, this.f2842a.f2654ao.getText().toString()));
                            } else {
                                this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.privacy_dialog_not_identified_user, this.f2842a.f2654ao.getText().toString()));
                            }
                            this.f2842a.f2656aq.setVisibility(0);
                        } else if (TextUtils.isEmpty(checkBuddy.countrycode) || checkBuddy.countrycode.equalsIgnoreCase(C3171am.m11082t())) {
                            if (this.f2842a.f2663ax) {
                                this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.new_buddy_information, this.f2842a.f2654ao.getText().toString()));
                            } else {
                                this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f2842a.f2654ao.getText().toString()));
                            }
                        } else {
                            if (this.f2842a.f2663ax) {
                                this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.new_buddy_information, this.f2842a.f2654ao.getText().toString()));
                            } else {
                                this.f2842a.f2658as.setText(this.f2842a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f2842a.f2654ao.getText().toString()));
                            }
                            if (this.f2842a.m4149f(checkBuddy.countrycode)) {
                                this.f2842a.m4151g(checkBuddy.countrycode);
                            } else {
                                this.f2842a.m4156h(checkBuddy.countrycode);
                            }
                            this.f2842a.f2674l = checkBuddy.countrycode;
                        }
                    }
                }
                this.f2842a.f2664ay.setVisibility(8);
                this.f2842a.f2659at.setVisibility(0);
                this.f2842a.f2629aB.setVisibility(0);
                if (this.f2842a.f2663ax) {
                    this.f2842a.f2631aD.setVisibility(0);
                    this.f2842a.f2665az.setVisibility(8);
                } else {
                    this.f2842a.f2628aA.setVisibility(0);
                    this.f2842a.f2631aD.setVisibility(8);
                    this.f2842a.f2665az.setVisibility(0);
                }
                this.f2842a.f2630aC.setVisibility(8);
                this.f2842a.f2660au.setVisibility(8);
                this.f2842a.f2661av.setVisibility(8);
                this.f2842a.f2662aw.setVisibility(8);
            }
        }
        this.f2842a.m4186v();
    }
}
