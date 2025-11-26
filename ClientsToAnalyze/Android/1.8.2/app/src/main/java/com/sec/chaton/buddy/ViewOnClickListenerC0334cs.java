package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.account.C0210g;
import com.sec.chaton.coolots.C0529i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.memo.C0839c;
import com.sec.chaton.memo.WriteMemoActivity;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p017e.C0691f;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.cs */
/* loaded from: classes.dex */
class ViewOnClickListenerC0334cs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1476a;

    ViewOnClickListenerC0334cs(BuddyProfileFragment buddyProfileFragment) {
        this.f1476a = buddyProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_chat /* 2131493131 */:
                view.setClickable(false);
                view.setEnabled(false);
                Intent intent = new Intent(this.f1476a.f1157s, (Class<?>) HomeActivity.class);
                intent.setFlags(67108864);
                intent.putExtra("callChatList", true);
                intent.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                intent.putExtra("receivers", new String[]{this.f1476a.f1158t.m2318a()});
                this.f1476a.startActivity(intent);
                break;
            case R.id.profile_call /* 2131493132 */:
                C1786r.m6067f("************ BUDDY NO : " + this.f1476a.f1158t.m2318a(), BuddyProfileFragment.f1089a);
                C1786r.m6067f("************ BUDDY ORG NO : " + this.f1476a.f1158t.m2331e(), BuddyProfileFragment.f1089a);
                Intent intent2 = new Intent("android.intent.action.CALL", (this.f1476a.f1158t.m2331e() == null || this.f1476a.f1158t.m2331e().length() <= 0) ? Uri.parse("tel:+" + this.f1476a.f1158t.m2318a()) : Uri.parse("tel:" + this.f1476a.f1158t.m2331e()));
                intent2.setFlags(268435456);
                try {
                    this.f1476a.startActivityForResult(intent2, 0);
                    break;
                } catch (ActivityNotFoundException e) {
                    C1786r.m6056a(e, getClass().getSimpleName());
                    return;
                }
                break;
            case R.id.profile_msg /* 2131493133 */:
                C1786r.m6067f("************ BUDDY NO : " + this.f1476a.f1158t.m2318a(), BuddyProfileFragment.f1089a);
                C1786r.m6067f("************ BUDDY ORG NO : " + this.f1476a.f1158t.m2331e(), BuddyProfileFragment.f1089a);
                String strM2331e = (this.f1476a.f1158t.m2331e() == null || this.f1476a.f1158t.m2331e().length() <= 0) ? "+" + this.f1476a.f1158t.m2318a() : this.f1476a.f1158t.m2331e();
                C1786r.m6067f("************ PHONE NO : " + strM2331e, BuddyProfileFragment.f1089a);
                try {
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.putExtra("address", strM2331e);
                    intent3.setType("vnd.android-dir/mms-sms");
                    intent3.setFlags(268435456);
                    this.f1476a.startActivityForResult(intent3, 0);
                    break;
                } catch (ActivityNotFoundException e2) {
                    C1786r.m6054a("************ SMS ERROR : " + e2.toString(), BuddyProfileFragment.f1089a);
                    return;
                }
                break;
            case R.id.profile_calendar /* 2131493138 */:
                String strM2333f = this.f1476a.f1158t.m2333f();
                if (strM2333f != null && strM2333f.length() >= 5) {
                    if (strM2333f.length() != 5 && strM2333f.length() == 10) {
                        strM2333f = strM2333f.substring(5);
                    }
                    new AlertDialogBuilderC2120a(this.f1476a.getActivity()).setPositiveButton(R.string.cancel, new DialogInterfaceOnClickListenerC0336cu(this)).setTitle(this.f1476a.f1157s.getResources().getString(R.string.buddy_profile_birthday)).setMessage(String.format(this.f1476a.getResources().getString(R.string.buddy_profile_dialog_savebirthday_calendar), this.f1476a.f1158t.m2324b())).setNegativeButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0335ct(this, strM2333f)).show();
                    break;
                }
                break;
            case R.id.memo_btn_write /* 2131493149 */:
                int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
                if (-3 == iM3420a || -2 == iM3420a) {
                    Toast.makeText(this.f1476a.f1157s, R.string.toast_network_unable, 0).show();
                    break;
                } else {
                    Intent intent4 = new Intent(this.f1476a.f1157s, (Class<?>) WriteMemoActivity.class);
                    intent4.putExtra("buddyid", this.f1476a.f1159u);
                    this.f1476a.startActivityForResult(intent4, 9);
                    break;
                }
                break;
            case R.id.profile_image /* 2131493151 */:
                Intent intent5 = new Intent(this.f1476a.f1157s, (Class<?>) ViewProfileImage.class);
                intent5.putExtra("PROFILE_BUDDY_NO", this.f1476a.f1158t.m2318a());
                intent5.putExtra("PROFILE_BUDDY_BIGIMAGE_STATUS", this.f1476a.f1158t.m2346r());
                this.f1476a.startActivityForResult(intent5, 0);
                break;
            case R.id.profile_is_favorite /* 2131493154 */:
                if (this.f1476a.f1093B.isChecked()) {
                    this.f1476a.f1156r.startQuery(4, this.f1476a.f1158t, C0691f.f2613a, null, "group_relation_group = 1 ", null, null);
                    break;
                } else {
                    this.f1476a.f1156r.startDelete(2, this.f1476a.f1158t, C0691f.f2613a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{this.f1476a.f1158t.m2318a()});
                    break;
                }
            case R.id.profile_contact /* 2131493155 */:
                Uri uri = ContactsContract.Contacts.CONTENT_URI;
                C1786r.m6061b("RAWCONTACTID: " + this.f1476a.f1158t.m2336h() + ", mContactId: " + this.f1476a.f1120ac, BuddyProfileFragment.f1089a);
                long jM2122a = this.f1476a.m2122a(this.f1476a.f1158t.m2318a());
                this.f1476a.f1119ab = false;
                if (jM2122a != 0) {
                    this.f1476a.f1119ab = true;
                }
                if (this.f1476a.f1119ab) {
                    long jM1807a = C0210g.m1807a(this.f1476a.f1158t.m2336h());
                    if (jM1807a == 0) {
                        jM1807a = this.f1476a.f1120ac;
                    }
                    if (jM1807a != 0) {
                        jM2122a = jM1807a;
                    }
                    Intent intent6 = new Intent("android.intent.action.VIEW");
                    intent6.setData(Uri.parse(uri + "/" + jM2122a));
                    this.f1476a.startActivityForResult(intent6, 0);
                    break;
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("phone", "+" + this.f1476a.f1158t.m2318a());
                    bundle.putString("name", this.f1476a.f1158t.m2324b());
                    Intent intent7 = new Intent("android.intent.action.INSERT", uri);
                    intent7.putExtras(bundle);
                    intent7.putExtra("return-data", true);
                    this.f1476a.startActivityForResult(intent7, 5);
                    break;
                }
            case R.id.profile_voice_call /* 2131493156 */:
            case R.id.profile_video_call /* 2131493157 */:
                if (!new C0529i(this.f1476a.f1157s, null, new String[]{this.f1476a.f1158t.m2318a()}, view.getId() == R.id.profile_voice_call).m2698a()) {
                    Toast.makeText(this.f1476a.f1157s, "Install Coolots app first.", 0).show();
                    break;
                }
                break;
            case R.id.buttonWriteText /* 2131493172 */:
                int iM3420a2 = C0809s.m3420a(GlobalApplication.m3260b());
                if (-3 != iM3420a2 && -2 != iM3420a2) {
                    this.f1476a.f1118aa.m2896a(new C0839c(this.f1476a.f1159u, "", this.f1476a.f1124ah.getText().toString(), String.valueOf(System.currentTimeMillis())));
                    this.f1476a.f1112U.show();
                    break;
                } else {
                    new AlertDialogBuilderC2120a(this.f1476a.getActivity()).setTitle(this.f1476a.getResources().getString(R.string.toast_error)).setMessage(this.f1476a.getResources().getString(R.string.setting_profile_update_status_failed)).setNegativeButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0337cv(this)).setPositiveButton(this.f1476a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                    break;
                }
                break;
            case R.id.new_buddy_add /* 2131493187 */:
                view.setEnabled(false);
                this.f1476a.f1107P.setEnabled(false);
                new C0633e(this.f1476a.f1147i).m2868b(this.f1476a.f1159u);
                break;
            case R.id.new_buddy_block /* 2131493188 */:
                view.setEnabled(false);
                this.f1476a.f1109R.setEnabled(false);
                new C0632d(this.f1476a.f1147i).m2847a(this.f1476a.f1158t.m2318a(), 1);
                break;
            case R.id.new_buddy_unblock /* 2131493189 */:
                view.setEnabled(false);
                this.f1476a.f1110S.setEnabled(false);
                new C0632d(this.f1476a.f1147i).m2846a(this.f1476a.f1159u);
                break;
            case R.id.new_buddy_cancel /* 2131493190 */:
                this.f1476a.getActivity().finish();
                break;
            case R.id.btn_edit_buddyname /* 2131493191 */:
                Intent intent8 = new Intent(this.f1476a.f1157s, (Class<?>) BuddyProfileEditNameActivity.class);
                intent8.putExtra("PROFILE_BUDDY_NO", this.f1476a.f1158t.m2318a());
                intent8.putExtra("PROFILE_BUDDY_NAME", this.f1476a.f1164z.getText().toString());
                this.f1476a.startActivityForResult(intent8, 8);
                break;
        }
    }
}
