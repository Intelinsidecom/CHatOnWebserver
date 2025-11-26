package com.sec.chaton.buddy.dialog;

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

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.e */
/* loaded from: classes.dex */
class HandlerC1227e extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f4727a;

    HandlerC1227e(BuddyDialog buddyDialog) {
        this.f4727a = buddyDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws RemoteException, OperationApplicationException {
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 306) {
            C4904y.m18639b("check buddy isConnectionSuccess()=" + c0778b.m18954n() + ", result=" + c0778b.m3107b() + ", fault=" + c0778b.m3111f(), "BUDDY PROFILE");
            if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.ERROR && c0778b.m3111f() == 16005) {
                this.f4727a.f4464aF.setVisibility(8);
                this.f4727a.f4506ax.setVisibility(0);
                this.f4727a.f4467aI.setVisibility(8);
                this.f4727a.f4466aH.setVisibility(8);
                this.f4727a.f4465aG.setVisibility(8);
                this.f4727a.f4469aK.setVisibility(8);
                this.f4727a.f4507ay.setVisibility(8);
                this.f4727a.f4508az.setVisibility(8);
                this.f4727a.f4459aA.setVisibility(8);
                this.f4727a.f4468aJ.setVisibility(0);
                this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.new_buddy_information_unblock, this.f4727a.f4501as.getText().toString()));
            } else if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.ERROR && c0778b.m3111f() == 15009) {
                this.f4727a.f4463aE.setVisibility(8);
                this.f4727a.f4464aF.setVisibility(8);
                this.f4727a.f4507ay.setVisibility(8);
                this.f4727a.f4506ax.setVisibility(8);
                this.f4727a.f4467aI.setVisibility(8);
                this.f4727a.f4466aH.setVisibility(8);
                this.f4727a.f4465aG.setVisibility(8);
                this.f4727a.f4469aK.setVisibility(8);
                this.f4727a.f4508az.setVisibility(8);
                this.f4727a.f4459aA.setVisibility(8);
                this.f4727a.f4468aJ.setVisibility(8);
                this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.toast_deleted_account, this.f4727a.f4501as.getText().toString()));
                if (this.f4727a.f4460aB) {
                    ContentResolver contentResolver = this.f4727a.getApplicationContext().getContentResolver();
                    ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                    arrayList.add(C2181ag.m9738a(this.f4727a.f4509d));
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
                this.f4727a.f4464aF.setVisibility(0);
                this.f4727a.f4507ay.setVisibility(0);
                this.f4727a.f4506ax.setVisibility(8);
                this.f4727a.f4467aI.setVisibility(8);
                this.f4727a.f4466aH.setVisibility(8);
                this.f4727a.f4465aG.setVisibility(8);
                this.f4727a.f4469aK.setVisibility(8);
                this.f4727a.f4508az.setVisibility(8);
                this.f4727a.f4459aA.setVisibility(8);
                this.f4727a.f4468aJ.setVisibility(8);
                this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.samsung_account_mapping_not_finished));
            } else if (!c0778b.m18954n()) {
                this.f4727a.m7245t();
            } else {
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    if (this.f4727a.f4460aB) {
                        this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.new_buddy_information, this.f4727a.f4501as.getText().toString()));
                    } else {
                        this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f4727a.f4501as.getText().toString()));
                    }
                } else {
                    CheckBuddyList checkBuddyList = (CheckBuddyList) c0778b.m3110e();
                    if (checkBuddyList == null) {
                        this.f4727a.m7136A();
                        this.f4727a.m7245t();
                        return;
                    }
                    ArrayList<CheckBuddy> arrayList2 = checkBuddyList.buddy;
                    if (arrayList2 == null || arrayList2.size() == 0) {
                        this.f4727a.m7136A();
                        this.f4727a.m7245t();
                        return;
                    }
                    for (int i = 0; i < arrayList2.size(); i++) {
                        CheckBuddy checkBuddy = arrayList2.get(i);
                        if (!checkBuddy.authenticated.booleanValue()) {
                            if (this.f4727a.f4460aB) {
                                this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.new_buddy_information, this.f4727a.f4501as.getText().toString()));
                            } else {
                                this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.privacy_dialog_not_identified_user, this.f4727a.f4501as.getText().toString()));
                            }
                            this.f4727a.f4503au.setVisibility(0);
                        } else if (TextUtils.isEmpty(checkBuddy.countrycode) || checkBuddy.countrycode.equalsIgnoreCase(C4822an.m18257y())) {
                            if (this.f4727a.f4460aB) {
                                this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.new_buddy_information, this.f4727a.f4501as.getText().toString()));
                            } else {
                                this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f4727a.f4501as.getText().toString()));
                            }
                        } else {
                            if (this.f4727a.f4460aB) {
                                this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.new_buddy_information, this.f4727a.f4501as.getText().toString()));
                            } else {
                                this.f4727a.f4505aw.setText(this.f4727a.getResources().getString(R.string.privacy_dialog_not_match_location_user, this.f4727a.f4501as.getText().toString()));
                            }
                            if (this.f4727a.m7207e(checkBuddy.countrycode)) {
                                this.f4727a.m7211f(checkBuddy.countrycode);
                            } else {
                                this.f4727a.m7215g(checkBuddy.countrycode);
                            }
                            this.f4727a.f4520o = checkBuddy.countrycode;
                        }
                    }
                }
                this.f4727a.f4464aF.setVisibility(8);
                this.f4727a.f4506ax.setVisibility(0);
                this.f4727a.f4467aI.setVisibility(0);
                if (this.f4727a.f4460aB) {
                    if (this.f4727a.f4461aC) {
                        this.f4727a.f4466aH.setVisibility(8);
                        this.f4727a.f4469aK.setVisibility(8);
                    } else {
                        this.f4727a.f4466aH.setVisibility(0);
                        this.f4727a.f4469aK.setVisibility(0);
                    }
                    this.f4727a.f4465aG.setVisibility(8);
                } else if (this.f4727a.f4462aD) {
                    this.f4727a.f4503au.setVisibility(0);
                    this.f4727a.f4465aG.setVisibility(8);
                    this.f4727a.f4469aK.setVisibility(8);
                } else {
                    this.f4727a.f4466aH.setVisibility(0);
                    this.f4727a.f4469aK.setVisibility(8);
                    this.f4727a.f4465aG.setVisibility(0);
                }
                this.f4727a.f4468aJ.setVisibility(8);
                this.f4727a.f4507ay.setVisibility(8);
                this.f4727a.f4508az.setVisibility(8);
                this.f4727a.f4459aA.setVisibility(8);
            }
        }
        this.f4727a.m7136A();
    }
}
