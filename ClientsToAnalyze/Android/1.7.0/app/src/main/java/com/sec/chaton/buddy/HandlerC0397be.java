package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.memo.C0729b;
import com.sec.chaton.memo.C0734g;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.p026a.C0623c;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p026a.C0632l;
import com.sec.chaton.p025d.p027b.C0643f;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.be */
/* loaded from: classes.dex */
class HandlerC0397be extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1371a;

    HandlerC0397be(BuddyProfileActivity buddyProfileActivity) {
        this.f1371a = buddyProfileActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0259g c0259g = (C0259g) message.obj;
        if (message.what == 602) {
            this.f1371a.m2272g();
            if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                this.f1371a.m2272g();
                C1619g.m5889a(this.f1371a.f1240k, this.f1371a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                return;
            } else {
                C0627g.m2858a(new C0627g(), 2, new C0643f(this.f1371a.f1235e, this.f1371a.f1241l, 2, false));
                return;
            }
        }
        if (message.what == 303) {
            this.f1371a.m2272g();
            if (c0259g.m927a()) {
                C1341p.m4658b("************** RESULT CODE : " + c0259g.m928b(), "ADD BUDDY");
                if (c0259g.m928b() == EnumC0518y.SUCCESS) {
                    Intent intent = new Intent(this.f1371a.f1240k, (Class<?>) BuddyProfileActivity.class);
                    intent.putExtra("PROFILE_BUDDY_NO", this.f1371a.f1242m);
                    intent.putExtra("PROFILE_BUDDY_NAME", this.f1371a.f1243n);
                    this.f1371a.f1240k.startActivity(intent);
                    return;
                }
                C1341p.m4658b("*********** ADD BUDDY RESULT : " + c0259g.m934f(), null);
                C1341p.m4658b("*********** ADD BUDDY RESULT : " + c0259g.m934f(), null);
                if (c0259g.m934f() == 16003) {
                    string = this.f1371a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_your_self);
                } else if (c0259g.m934f() == 16004) {
                    string = this.f1371a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0259g.m934f() == 16005) {
                    string = this.f1371a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else {
                    string = String.format(this.f1371a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_invaliduser), this.f1371a.f1243n);
                }
                new AlertDialogBuilderC1625m(this.f1371a.f1240k).setTitle(string).setPositiveButton(this.f1371a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0454s(this)).show();
                return;
            }
            new AlertDialogBuilderC1625m(this.f1371a.f1240k).setTitle(this.f1371a.getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).setMessage(this.f1371a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f1371a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0453r(this)).setNegativeButton(this.f1371a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (message.what == 603) {
            this.f1371a.m2272g();
            if (c0259g.m927a() && c0259g.m928b() == EnumC0518y.SUCCESS) {
                C1341p.m4658b("****** UNBLOCK : " + this.f1371a.f1242m, BuddyProfileActivity.f1198a);
                C1619g.m5889a(this.f1371a.f1240k, this.f1371a.f1240k.getResources().getString(R.string.setting_buddy_unblocked, this.f1371a.f1243n), 0).show();
                this.f1371a.finish();
                return;
            }
            return;
        }
        if (message.what == 901 || message.what == 902) {
            this.f1371a.m2272g();
            if (this.f1371a.f1220W != null) {
                this.f1371a.f1220W.setVisibility(8);
            }
            Cursor cursorM2876a = C0632l.m2876a(this.f1371a.getContentResolver(), this.f1371a.f1242m);
            while (cursorM2876a.moveToNext()) {
                this.f1371a.f1223Z = cursorM2876a.getString(cursorM2876a.getColumnIndex("buddy_name"));
                this.f1371a.f1224aa = cursorM2876a.getString(cursorM2876a.getColumnIndex("endtime"));
                this.f1371a.f1225ab = cursorM2876a.getString(cursorM2876a.getColumnIndex("isblind"));
            }
            cursorM2876a.close();
            if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                this.f1371a.m2272g();
                if (this.f1371a.f1220W != null) {
                    this.f1371a.f1220W.setVisibility(8);
                }
                if (this.f1371a.f1225ab == null || !this.f1371a.f1225ab.equals("true")) {
                    ((LinearLayout) this.f1371a.f1218U.findViewById(R.id.profile_write_area)).setVisibility(0);
                } else {
                    this.f1371a.f1215Q.clear();
                    if (this.f1371a.f1213O != null) {
                        this.f1371a.f1213O.notifyDataSetChanged();
                    }
                    ((LinearLayout) this.f1371a.f1218U.findViewById(R.id.profile_write_area)).setVisibility(8);
                    if (this.f1371a.f1243n == null || this.f1371a.f1243n.length() == 0) {
                        C1341p.m4651a("Buddy name is null", BuddyProfileActivity.f1198a);
                        this.f1371a.f1243n = this.f1371a.getString(R.string.buddy_profile_no_name);
                    }
                    this.f1371a.f1221X.setText(String.format(this.f1371a.getResources().getString(R.string.memo_blinded), this.f1371a.f1243n));
                }
                this.f1371a.f1222Y.setVisibility(0);
                ((Button) this.f1371a.f1219V.findViewById(R.id.footer_memo_content)).setText(this.f1371a.getResources().getString(R.string.trunk_network_not_available));
                if (this.f1371a.f1213O != null) {
                    this.f1371a.f1213O.notifyDataSetChanged();
                }
            } else if (this.f1371a.f1225ab == null || !this.f1371a.f1225ab.equals("true")) {
                Cursor cursorM2853a = C0623c.m2853a(this.f1371a.getContentResolver(), this.f1371a.f1242m);
                this.f1371a.f1215Q.clear();
                ((LinearLayout) this.f1371a.f1218U.findViewById(R.id.profile_write_area)).setVisibility(0);
                if (cursorM2853a.getCount() == 0) {
                    this.f1371a.f1222Y.setVisibility(0);
                    this.f1371a.f1220W.setVisibility(8);
                    if (this.f1371a.f1213O != null) {
                        this.f1371a.f1213O.notifyDataSetChanged();
                    }
                } else {
                    while (cursorM2853a.moveToNext()) {
                        this.f1371a.f1215Q.add(new C0734g(cursorM2853a.getString(cursorM2853a.getColumnIndex("buddy_no")), cursorM2853a.getString(cursorM2853a.getColumnIndex("buddy_name")), cursorM2853a.getString(cursorM2853a.getColumnIndex("memo")), cursorM2853a.getString(cursorM2853a.getColumnIndex("timestamp"))));
                        this.f1371a.f1222Y.setVisibility(8);
                    }
                    cursorM2853a.close();
                }
                if (this.f1371a.f1223Z == null || !this.f1371a.f1223Z.equals("true")) {
                    this.f1371a.f1220W.setVisibility(8);
                } else {
                    this.f1371a.f1220W.setVisibility(0);
                }
                if (this.f1371a.f1213O == null) {
                    this.f1371a.f1213O = new C0729b(this.f1371a.f1214P, this.f1371a.f1240k, this.f1371a.f1215Q, R.layout.memo_adapter_item);
                    this.f1371a.f1214P.setAdapter((ListAdapter) this.f1371a.f1213O);
                } else {
                    this.f1371a.f1213O.notifyDataSetChanged();
                }
            } else {
                C1341p.m4662e(this.f1371a.f1242m + " is blinded", BuddyProfileActivity.f1198a);
                this.f1371a.f1215Q.clear();
                if (this.f1371a.f1213O != null) {
                    this.f1371a.f1213O.notifyDataSetChanged();
                }
                ((LinearLayout) this.f1371a.f1218U.findViewById(R.id.profile_write_area)).setVisibility(8);
                this.f1371a.f1220W.setVisibility(8);
                this.f1371a.f1243n = this.f1371a.f1241l.m2314b();
                if (this.f1371a.f1243n == null || this.f1371a.f1243n.length() == 0) {
                    C1341p.m4651a("Buddy name is null", BuddyProfileActivity.f1198a);
                    this.f1371a.f1243n = this.f1371a.getString(R.string.buddy_profile_no_name);
                }
                this.f1371a.f1221X.setText(String.format(this.f1371a.getResources().getString(R.string.memo_blinded), this.f1371a.f1243n));
                this.f1371a.f1222Y.setVisibility(0);
                this.f1371a.f1226ac = true;
            }
            this.f1371a.f1226ac = false;
            return;
        }
        if (message.what == 904) {
            if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                this.f1371a.m2272g();
                C1619g.m5889a(this.f1371a.f1240k, this.f1371a.getResources().getString(R.string.toast_network_unable), 0).show();
            } else {
                this.f1371a.f1226ac = true;
                this.f1371a.f1216R.m864a(this.f1371a.f1242m);
            }
        }
    }
}
