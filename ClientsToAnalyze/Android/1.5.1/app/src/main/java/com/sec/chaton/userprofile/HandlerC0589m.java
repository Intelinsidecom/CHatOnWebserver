package com.sec.chaton.userprofile;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.common.entry.UserProfileEntry;
import com.sec.chaton.database.helper.MemoDatabaseHelper;
import com.sec.chaton.database.helper.MemoSessionsDatabaseHelper;
import com.sec.chaton.memo.MemoAdapter;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.userprofile.m */
/* loaded from: classes.dex */
class HandlerC0589m extends Handler {

    /* renamed from: a */
    final /* synthetic */ UserProfileFragment f3586a;

    HandlerC0589m(UserProfileFragment userProfileFragment) {
        this.f3586a = userProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 401:
                if (this.f3586a.f3437D != null) {
                    this.f3586a.f3437D.dismiss();
                }
                HttpEntry httpEntry = (HttpEntry) message.obj;
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    UserProfileEntry userProfileEntry = (UserProfileEntry) httpEntry.m1956e();
                    if (userProfileEntry.m1964a() != null) {
                        this.f3586a.f3499y.setText(userProfileEntry.m1964a());
                    }
                    if (userProfileEntry.m1966b() != null) {
                        this.f3586a.f3498x.setText(userProfileEntry.m1966b());
                    }
                    if (userProfileEntry.m1968c() != null) {
                        if (this.f3586a.f3448O) {
                            this.f3586a.f3500z.setText(UserProfileDetail.m3354a(this.f3586a.f3453T));
                        } else {
                            this.f3586a.f3500z.setText(this.f3586a.getResources().getString(C0062R.string.dont_show_birthday));
                            this.f3586a.f3446M = "";
                        }
                    }
                    this.f3586a.m3403g();
                    break;
                } else {
                    Toast.makeText(this.f3586a.getActivity(), C0062R.string.toast_setting_profile_update_failed, 0).show();
                    break;
                }
                break;
            case 402:
                if (this.f3586a.f3437D != null) {
                    this.f3586a.f3437D.dismiss();
                }
                if (!((ResultEntry) message.obj).f1325a) {
                    Toast.makeText(this.f3586a.getActivity(), C0062R.string.toast_setting_profile_image_save_failed, 0).show();
                    break;
                } else {
                    this.f3586a.m3432c();
                    break;
                }
            case 403:
                if (this.f3586a.f3437D != null) {
                    this.f3586a.f3437D.dismiss();
                }
                HttpEntry httpEntry2 = (HttpEntry) message.obj;
                if (!httpEntry2.m1950a() || !httpEntry2.m1950a()) {
                    Toast.makeText(this.f3586a.getActivity(), C0062R.string.toast_setting_profile_image_save_failed, 0).show();
                    break;
                } else {
                    this.f3586a.f3496v.setImageResource(C0062R.drawable.msg_list_id_default);
                    break;
                }
                break;
            case TrunkMessageControl.METHOD_GET_TRUNK_ITEM /* 901 */:
            case TrunkMessageControl.METHOD_GET_ITEM_LIST /* 902 */:
                if (this.f3586a.getActivity() != null) {
                    if (this.f3586a.f3471al != null) {
                        this.f3586a.f3471al.dismiss();
                    }
                    if (this.f3586a.f3464ae != null) {
                        this.f3586a.f3464ae.setVisibility(8);
                    }
                    HttpEntry httpEntry3 = (HttpEntry) message.obj;
                    if (!httpEntry3.m1950a() || httpEntry3.m1951b() == HttpResultCode.ERROR) {
                        if (this.f3586a.f3471al != null) {
                            this.f3586a.f3471al.dismiss();
                        }
                        if (this.f3586a.f3464ae != null) {
                            this.f3586a.f3464ae.setVisibility(8);
                        }
                        this.f3586a.f3465af.setVisibility(0);
                        ((LinearLayout) this.f3586a.f3461ab.findViewById(C0062R.id.mypage_write_area)).setVisibility(8);
                        Toast.makeText(this.f3586a.getActivity(), this.f3586a.getResources().getString(C0062R.string.dev_network_error), 0).show();
                        this.f3586a.f3458Y.clear();
                        if (this.f3586a.f3456W != null) {
                            this.f3586a.f3456W.notifyDataSetChanged();
                        }
                    } else {
                        ContentResolver contentResolver = this.f3586a.getActivity().getContentResolver();
                        Cursor cursorM2269a = MemoDatabaseHelper.m2269a(contentResolver, this.f3586a.f3443J);
                        ChatONLogWriter.m3511e("Memo list count: " + this.f3586a.f3443J + ", " + cursorM2269a.getCount(), UserProfileFragment.f3433a);
                        this.f3586a.f3458Y.clear();
                        this.f3586a.f3465af.setVisibility(8);
                        ((LinearLayout) this.f3586a.f3461ab.findViewById(C0062R.id.mypage_write_area)).setVisibility(8);
                        if (cursorM2269a.getCount() == 0) {
                            this.f3586a.f3464ae.setVisibility(8);
                            this.f3586a.f3465af.setVisibility(0);
                            if (this.f3586a.f3456W != null) {
                                this.f3586a.f3456W.notifyDataSetChanged();
                            }
                        } else {
                            while (cursorM2269a.moveToNext()) {
                                this.f3586a.f3458Y.add(new MemoAdapter.MemoItem(cursorM2269a.getString(cursorM2269a.getColumnIndex("buddy_no")), cursorM2269a.getString(cursorM2269a.getColumnIndex("buddy_name")), cursorM2269a.getString(cursorM2269a.getColumnIndex("memo")), cursorM2269a.getString(cursorM2269a.getColumnIndex("timestamp"))));
                                this.f3586a.f3465af.setVisibility(8);
                            }
                            cursorM2269a.close();
                            Cursor cursorM2270a = MemoSessionsDatabaseHelper.m2270a(contentResolver, this.f3586a.f3443J);
                            while (cursorM2270a.moveToNext()) {
                                this.f3586a.f3466ag = cursorM2270a.getString(cursorM2270a.getColumnIndex("buddy_name"));
                                this.f3586a.f3467ah = cursorM2270a.getString(cursorM2270a.getColumnIndex("endtime"));
                            }
                            cursorM2270a.close();
                            if (this.f3586a.f3466ag == null || !this.f3586a.f3466ag.equals("true")) {
                                this.f3586a.f3464ae.setVisibility(8);
                            } else {
                                this.f3586a.f3464ae.setVisibility(0);
                            }
                            if (this.f3586a.f3456W == null) {
                                this.f3586a.f3456W = new MemoAdapter(this.f3586a.f3457X, this.f3586a.f3455V, this.f3586a.f3458Y, C0062R.layout.memo_adapter_item);
                                this.f3586a.f3457X.setAdapter((ListAdapter) this.f3586a.f3456W);
                            } else {
                                this.f3586a.f3456W.notifyDataSetChanged();
                            }
                        }
                        if (cursorM2269a != null) {
                            cursorM2269a.close();
                        }
                    }
                    this.f3586a.f3468ai = false;
                    break;
                }
                break;
            case TrunkMessageControl.METHOD_ADD_COMMENT /* 904 */:
                if (this.f3586a.getActivity() != null) {
                    HttpEntry httpEntry4 = (HttpEntry) message.obj;
                    if (httpEntry4.m1950a() && httpEntry4.m1951b() != HttpResultCode.ERROR) {
                        this.f3586a.f3468ai = true;
                        this.f3586a.f3459Z.m2006a(this.f3586a.f3443J);
                        break;
                    } else {
                        if (this.f3586a.f3471al != null) {
                            this.f3586a.f3471al.dismiss();
                        }
                        Toast.makeText(this.f3586a.getActivity(), this.f3586a.getResources().getString(C0062R.string.dev_network_error), 0).show();
                        break;
                    }
                }
                break;
        }
    }
}
