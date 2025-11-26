package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.memo.C0837a;
import com.sec.chaton.memo.C0839c;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.p018a.C0663g;
import com.sec.chaton.p017e.p018a.C0664h;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0678e;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.cw */
/* loaded from: classes.dex */
class HandlerC0338cw extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1481a;

    HandlerC0338cw(BuddyProfileFragment buddyProfileFragment) {
        this.f1481a = buddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 602) {
            if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                if (this.f1481a.f1112U != null && this.f1481a.f1112U.isShowing()) {
                    this.f1481a.f1112U.dismiss();
                }
                Toast.makeText(this.f1481a.f1157s, this.f1481a.f1157s.getString(R.string.buddy_profile_block_toast_failed), 0).show();
                if (this.f1481a.f1109R != null) {
                    this.f1481a.f1109R.setEnabled(true);
                }
                if (this.f1481a.f1107P != null) {
                    this.f1481a.f1107P.setEnabled(true);
                    return;
                }
                return;
            }
            C0668l.m3077a(new C0668l(), 2, new C0678e(this.f1481a.f1149k, this.f1481a.f1158t, 2, false));
            return;
        }
        if (message.what == 303) {
            if (this.f1481a.f1112U != null && this.f1481a.f1112U.isShowing()) {
                this.f1481a.f1112U.dismiss();
            }
            if (c0101b.m664a()) {
                C1786r.m6061b("************** RESULT CODE : " + c0101b.m665b(), "ADD BUDDY");
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    Toast.makeText(this.f1481a.f1157s, String.format(this.f1481a.getResources().getString(R.string.add_buddy_success_toast), this.f1481a.f1160v), 1).show();
                    if (this.f1481a.f1137au) {
                        this.f1481a.getActivity().finish();
                    } else {
                        Intent intent = new Intent(this.f1481a.f1157s, (Class<?>) BuddyProfileActivity.class);
                        intent.putExtra("PROFILE_BUDDY_NO", this.f1481a.f1159u);
                        intent.putExtra("PROFILE_BUDDY_NAME", this.f1481a.f1160v);
                        intent.setFlags(268435456);
                        this.f1481a.f1157s.startActivity(intent);
                    }
                } else {
                    C1786r.m6061b("*********** ADD BUDDY RESULT : " + c0101b.m673f(), null);
                    C1786r.m6061b("*********** ADD BUDDY RESULT : " + c0101b.m673f(), null);
                    if (c0101b.m673f() == 16003) {
                        string = this.f1481a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_your_self);
                    } else if (c0101b.m673f() == 16004) {
                        string = this.f1481a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0101b.m673f() == 16005) {
                        string = this.f1481a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else {
                        string = String.format(this.f1481a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_invaliduser), this.f1481a.f1160v);
                    }
                    FragmentActivity activity = this.f1481a.getActivity();
                    if (activity != null) {
                        new AlertDialog.Builder(activity).setTitle(string).setPositiveButton(this.f1481a.f1157s.getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0339cx(this)).show();
                    } else {
                        Toast.makeText(this.f1481a.f1157s, string, 1).show();
                    }
                }
            } else {
                FragmentActivity activity2 = this.f1481a.getActivity();
                if (activity2 != null) {
                    new AlertDialog.Builder(activity2).setTitle(this.f1481a.f1157s.getString(R.string.buddy_list_dialog_addbuddy_title)).setMessage(this.f1481a.f1157s.getString(R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f1481a.f1157s.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).setNegativeButton(this.f1481a.f1157s.getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0340cy(this)).show();
                } else {
                    Toast.makeText(this.f1481a.f1157s, this.f1481a.f1157s.getString(R.string.buddy_list_dialog_addbuddy_network_failed), 1).show();
                }
            }
            this.f1481a.f1109R.setEnabled(true);
            this.f1481a.f1107P.setEnabled(true);
            return;
        }
        if (message.what == 603) {
            if (!c0101b.m664a() || c0101b.m665b() != EnumC0803m.SUCCESS) {
                Toast.makeText(this.f1481a.f1157s, this.f1481a.f1157s.getString(R.string.toast_network_unable), 0).show();
                if (this.f1481a.f1108Q != null) {
                    this.f1481a.f1108Q.setEnabled(true);
                }
                if (this.f1481a.f1110S != null) {
                    this.f1481a.f1110S.setEnabled(true);
                    return;
                }
                return;
            }
            C1786r.m6061b("****** UNBLOCK : " + this.f1481a.f1159u, BuddyProfileFragment.f1089a);
            Toast.makeText(this.f1481a.f1157s, this.f1481a.f1157s.getString(R.string.setting_buddy_unblocked, this.f1481a.f1160v), 0).show();
            if (this.f1481a.getActivity() != null) {
                this.f1481a.getActivity().finish();
                return;
            }
            return;
        }
        if (message.what == 901 || message.what == 902) {
            if (this.f1481a.f1112U != null && this.f1481a.f1112U.isShowing()) {
                this.f1481a.f1124ah.setText("");
                this.f1481a.f1112U.dismiss();
            }
            if (this.f1481a.f1127ak != null) {
                this.f1481a.f1127ak.setVisibility(8);
            }
            Cursor cursorM3038a = C0664h.m3038a(this.f1481a.f1157s.getContentResolver(), this.f1481a.f1159u);
            while (cursorM3038a.moveToNext()) {
                this.f1481a.f1129am = cursorM3038a.getString(cursorM3038a.getColumnIndex("buddy_name"));
                this.f1481a.f1130an = cursorM3038a.getString(cursorM3038a.getColumnIndex("endtime"));
                this.f1481a.f1131ao = cursorM3038a.getString(cursorM3038a.getColumnIndex("isblind"));
            }
            cursorM3038a.close();
            if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                if (this.f1481a.f1112U != null && this.f1481a.f1112U.isShowing()) {
                    this.f1481a.f1112U.dismiss();
                }
                if (this.f1481a.f1127ak != null) {
                    this.f1481a.f1127ak.setVisibility(8);
                }
                if (this.f1481a.f1131ao == null || !this.f1481a.f1131ao.equals("true")) {
                    this.f1481a.f1123ag.setVisibility(8);
                    this.f1481a.f1124ah.setVisibility(8);
                    this.f1481a.f1163y.setVisibility(0);
                    this.f1481a.f1122af.setVisibility(8);
                } else {
                    this.f1481a.f1117Z.clear();
                    if (this.f1481a.f1113V != null) {
                        this.f1481a.f1113V.notifyDataSetChanged();
                    }
                    ((RelativeLayout) this.f1481a.f1155q.findViewById(R.id.profile_write_area)).setVisibility(8);
                    this.f1481a.f1122af.setVisibility(8);
                    if (this.f1481a.f1160v == null || this.f1481a.f1160v.length() == 0) {
                        C1786r.m6054a("Buddy name is null", BuddyProfileFragment.f1089a);
                        if (this.f1481a.f1158t != null) {
                            this.f1481a.f1160v = this.f1481a.f1158t.m2324b();
                        }
                        if (this.f1481a.f1160v.length() == 0) {
                            this.f1481a.f1160v = this.f1481a.f1157s.getString(R.string.buddy_profile_no_name);
                        }
                    }
                    this.f1481a.f1128al.setText(String.format(this.f1481a.f1157s.getString(R.string.memo_blinded), this.f1481a.f1160v));
                }
                this.f1481a.f1128al.setVisibility(0);
                Toast.makeText(this.f1481a.f1157s, this.f1481a.getResources().getString(R.string.toast_network_unable), 0).show();
                ((Button) this.f1481a.f1126aj.findViewById(R.id.footer_memo_content)).setText(this.f1481a.f1157s.getString(R.string.dialog_title_noblock_item));
                if (this.f1481a.f1113V != null) {
                    this.f1481a.f1113V.notifyDataSetChanged();
                }
            } else if (this.f1481a.f1131ao == null || !this.f1481a.f1131ao.equals("true")) {
                Cursor cursorM3037a = C0663g.m3037a(this.f1481a.f1157s.getContentResolver(), this.f1481a.f1159u);
                this.f1481a.f1117Z.clear();
                this.f1481a.f1123ag.setVisibility(0);
                this.f1481a.f1124ah.setVisibility(0);
                this.f1481a.f1163y.setVisibility(0);
                if (cursorM3037a.getCount() == 0) {
                    this.f1481a.f1114W.setAdapter((ListAdapter) null);
                    this.f1481a.f1128al.setVisibility(0);
                    this.f1481a.f1127ak.setVisibility(8);
                    if (this.f1481a.f1113V != null) {
                        this.f1481a.f1114W.setAdapter((ListAdapter) null);
                        this.f1481a.f1113V.notifyDataSetChanged();
                        this.f1481a.f1113V = null;
                    }
                } else {
                    while (cursorM3037a.moveToNext()) {
                        this.f1481a.f1117Z.add(new C0839c(cursorM3037a.getString(cursorM3037a.getColumnIndex("buddy_no")), cursorM3037a.getString(cursorM3037a.getColumnIndex("buddy_name")), cursorM3037a.getString(cursorM3037a.getColumnIndex("memo")), cursorM3037a.getString(cursorM3037a.getColumnIndex("timestamp"))));
                        this.f1481a.f1128al.setVisibility(8);
                    }
                    cursorM3037a.close();
                }
                if (this.f1481a.f1129am == null || !this.f1481a.f1129am.equals("true")) {
                    this.f1481a.f1127ak.setVisibility(8);
                } else {
                    this.f1481a.f1127ak.setVisibility(0);
                }
                if (this.f1481a.f1113V == null) {
                    this.f1481a.f1113V = new C0837a(this.f1481a.f1114W, this.f1481a.f1157s, this.f1481a.f1117Z, R.layout.memo_adapter_item);
                    this.f1481a.f1114W.setAdapter((ListAdapter) this.f1481a.f1113V);
                    this.f1481a.f1113V.notifyDataSetChanged();
                } else {
                    this.f1481a.f1113V.notifyDataSetChanged();
                }
            } else {
                C1786r.m6066e(this.f1481a.f1159u + " is blinded", BuddyProfileFragment.f1089a);
                this.f1481a.f1117Z.clear();
                if (this.f1481a.f1113V != null) {
                    this.f1481a.f1113V.notifyDataSetChanged();
                }
                ((RelativeLayout) this.f1481a.f1155q.findViewById(R.id.profile_write_area)).setVisibility(0);
                this.f1481a.f1122af.setVisibility(8);
                this.f1481a.f1127ak.setVisibility(8);
                if (this.f1481a.f1160v == null || this.f1481a.f1160v.length() == 0) {
                    C1786r.m6054a("Buddy name is null", BuddyProfileFragment.f1089a);
                    if (this.f1481a.f1158t != null) {
                        this.f1481a.f1160v = this.f1481a.f1158t.m2324b();
                    }
                    if (this.f1481a.f1160v.length() == 0) {
                        this.f1481a.f1160v = this.f1481a.f1157s.getString(R.string.buddy_profile_no_name);
                    }
                }
                this.f1481a.f1128al.setText(String.format(this.f1481a.f1157s.getString(R.string.memo_blinded), this.f1481a.f1160v));
                this.f1481a.f1128al.setVisibility(0);
                this.f1481a.f1132ap = true;
            }
            this.f1481a.f1132ap = false;
            return;
        }
        if (message.what == 904) {
            if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                if (this.f1481a.f1112U != null && this.f1481a.f1112U.isShowing()) {
                    this.f1481a.f1112U.dismiss();
                }
                Toast.makeText(this.f1481a.f1157s, this.f1481a.f1157s.getString(R.string.toast_network_unable), 0).show();
                return;
            }
            this.f1481a.f1132ap = true;
            this.f1481a.f1118aa.m2897a(this.f1481a.f1159u);
            return;
        }
        if (message.what == 903) {
            if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                if (this.f1481a.f1112U != null && this.f1481a.f1112U.isShowing()) {
                    this.f1481a.f1112U.dismiss();
                }
                String string2 = this.f1481a.f1157s.getString(R.string.toast_network_unable);
                if (c0101b.m673f() != 0) {
                    Toast.makeText(this.f1481a.f1157s, string2, 0).show();
                    return;
                }
                AlertDialog alertDialogCreate = new AlertDialogBuilderC2120a(this.f1481a.getActivity()).setTitle(R.string.mypage_buddies_say).setMessage(R.string.Alert_duplicate_msg).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0341cz(this)).create();
                if (!this.f1481a.getActivity().isFinishing()) {
                    alertDialogCreate.show();
                    return;
                }
                return;
            }
            this.f1481a.f1132ap = true;
            this.f1481a.f1118aa.m2897a(this.f1481a.f1159u);
        }
    }
}
