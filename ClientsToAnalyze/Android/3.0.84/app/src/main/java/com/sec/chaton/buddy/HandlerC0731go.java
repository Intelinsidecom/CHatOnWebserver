package com.sec.chaton.buddy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.C1206cg;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.go */
/* loaded from: classes.dex */
class HandlerC0731go extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f2985a;

    HandlerC0731go(BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f2985a = buddyRecommendListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException, NumberFormatException, RemoteException, OperationApplicationException {
        String string;
        String string2;
        String strSubstring;
        String string3;
        C0267d c0267d = (C0267d) message.obj;
        if (this.f2985a.getActivity() != null) {
            if (this.f2985a.f2220f != null) {
                this.f2985a.f2220f.dismiss();
            }
            if (message.what == 303) {
                if (c0267d.m11704n()) {
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        GetBuddyList getBuddyList = (GetBuddyList) c0267d.m1354e();
                        if (getBuddyList != null) {
                            this.f2985a.f2226l = getBuddyList.buddy.get(0).name;
                        }
                        C3641ai.m13211a(this.f2985a.getActivity(), this.f2985a.getResources().getString(R.string.add_buddy_added, this.f2985a.f2226l), 0).show();
                        this.f2985a.f2217c.notifyDataSetChanged();
                        if (this.f2985a.f2218d != null) {
                            this.f2985a.f2218d.setEmptyView(this.f2985a.f2219e);
                            return;
                        }
                        return;
                    }
                    if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                        AbstractC3271a.m11494a(this.f2985a.getActivity()).mo11500a(this.f2985a.getResources().getString(R.string.toast_error)).mo11509b(String.format(this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f2985a.f2226l)).mo11510b(this.f2985a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0732gp(this)).mo11512b();
                        return;
                    }
                    C3250y.m11458g("ADD BUDDY RESULT : " + c0267d.m1355f(), null);
                    if (c0267d.m1355f() == 16003) {
                        string3 = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0267d.m1355f() == 16004) {
                        string3 = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0267d.m1355f() == 16005) {
                        string3 = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else if (c0267d.m1355f() == 50005) {
                        string3 = this.f2985a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                    } else {
                        string3 = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    AbstractC3271a.m11494a(this.f2985a.getActivity()).mo11500a(this.f2985a.getResources().getString(R.string.toast_error)).mo11509b(string3).mo11510b(this.f2985a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0733gq(this)).mo11512b();
                    return;
                }
                AbstractC3271a.m11494a(this.f2985a.getActivity()).mo11500a(this.f2985a.getResources().getString(R.string.toast_error)).mo11509b(this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo11510b(this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0734gr(this)).mo11501a(this.f2985a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return;
            }
            if (message.what == 311) {
                if (c0267d.m11704n()) {
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        GetBuddyList getBuddyList2 = (GetBuddyList) c0267d.m1354e();
                        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
                        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                        Iterator<Buddy> it = getBuddyList2.buddy.iterator();
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
                                strSubstring = next.value.substring(1, next.value.length());
                            } else {
                                strSubstring = next.value;
                            }
                            arrayList.add(C1206cg.m5544a(strSubstring));
                        }
                        try {
                            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
                            if (this.f2985a.f2218d != null) {
                                this.f2985a.f2218d.setEmptyView(this.f2985a.f2219e);
                            }
                        } catch (OperationApplicationException e) {
                            e.printStackTrace();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                        this.f2985a.f2227m.setVisibility(8);
                        String str = String.format(this.f2985a.getResources().getString(R.string.suggestion_add_all_buddies_failed_popup), Integer.valueOf(i - i2), Integer.valueOf(i));
                        if (i2 == 0) {
                            if (this.f2985a.getActivity() != null) {
                                C3641ai.m13211a(this.f2985a.getActivity(), this.f2985a.getResources().getString(R.string.tellfriends_added), 0).show();
                            }
                            this.f2985a.getActivity().finish();
                            return;
                        }
                        AbstractC3271a.m11494a(this.f2985a.getActivity()).mo11500a(this.f2985a.getResources().getString(R.string.edit_group_add_member)).mo11509b(str).mo11510b(this.f2985a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0735gs(this)).mo11501a(this.f2985a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                        return;
                    }
                    int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 == iM6733a || -2 == iM6733a) {
                        string2 = this.f2985a.getResources().getString(R.string.popup_no_network_connection);
                    } else if (c0267d.m1355f() == 16003) {
                        string2 = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0267d.m1355f() == 16004) {
                        string2 = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0267d.m1355f() == 16005) {
                        string2 = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else if (c0267d.m1355f() == 50005) {
                        string2 = this.f2985a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                    } else {
                        string2 = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    C3641ai.m13211a(this.f2985a.getActivity(), string2, 0).show();
                    return;
                }
                int iM6733a2 = C1594v.m6733a(CommonApplication.m11493l());
                if (-3 == iM6733a2 || -2 == iM6733a2) {
                    C3641ai.m13210a(this.f2985a.getActivity(), R.string.popup_no_network_connection, 0).show();
                    return;
                }
                return;
            }
            if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                C3641ai.m13211a(this.f2985a.getActivity(), this.f2985a.getResources().getString(R.string.done), 0).show();
                return;
            }
            int iM6733a3 = C1594v.m6733a(CommonApplication.m11493l());
            if (-3 == iM6733a3 || -2 == iM6733a3) {
                string = this.f2985a.getResources().getString(R.string.popup_no_network_connection);
            } else if (c0267d.m1355f() == 16003) {
                string = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
            } else if (c0267d.m1355f() == 16004) {
                string = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
            } else if (c0267d.m1355f() == 16005) {
                string = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
            } else if (c0267d.m1355f() == 50005) {
                string = this.f2985a.getResources().getString(R.string.samsung_account_mapping_not_finished);
            } else {
                string = this.f2985a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
            }
            C3641ai.m13211a(this.f2985a.getActivity(), string, 0).show();
        }
    }
}
