package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.buddy.dialog.PhoneNumberSelectorDialog;
import com.sec.chaton.buddy.dialog.SpamConfirmDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1445m;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.poston.PostONWriteActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;
import java.util.List;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ex */
/* loaded from: classes.dex */
class ViewOnClickListenerC0686ex implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2908a;

    ViewOnClickListenerC0686ex(BuddyProfileFragment buddyProfileFragment) {
        this.f2908a = buddyProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        Uri uriM3720b;
        Uri uriM3720b2;
        if (!C3197bl.m11159a()) {
            switch (view.getId()) {
                case R.id.profile_image /* 2131165301 */:
                case R.id.buddy_profile_more_icon /* 2131165367 */:
                    C3250y.m11458g("mBuddyInfo.getProfileStatus() : " + this.f2908a.f2116s.m3994u(), BuddyProfileFragment.f2014a);
                    Intent intent = new Intent(this.f2908a.f2058aQ, (Class<?>) BuddyProfileImageView.class);
                    intent.putExtra("PROFILE_BUDDY_NO", this.f2908a.f2117t);
                    intent.putExtra("PROFILE_BUDDY_IMAGE_ID", this.f2908a.f2027L.m4342b());
                    intent.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "FULL");
                    if (GlobalApplication.m6456e()) {
                        intent.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVIEW", "PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVUEW_VALUE");
                    }
                    this.f2908a.startActivity(intent);
                    break;
                case R.id.profile_image_1 /* 2131165868 */:
                    String strM4342b = this.f2908a.f2028M.m4342b();
                    C3250y.m11458g("profileImageId : " + strM4342b, BuddyProfileFragment.f2014a);
                    Intent intent2 = new Intent(this.f2908a.f2058aQ, (Class<?>) BuddyProfileImageView.class);
                    intent2.putExtra("PROFILE_BUDDY_NO", this.f2908a.f2117t);
                    intent2.putExtra("PROFILE_BUDDY_IMAGE_ID", strM4342b);
                    intent2.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                    if (GlobalApplication.m6456e()) {
                        intent2.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVIEW", "PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVUEW_VALUE");
                    }
                    this.f2908a.startActivity(intent2);
                    break;
                case R.id.profile_image_2 /* 2131165870 */:
                    String strM4342b2 = this.f2908a.f2029N.m4342b();
                    C3250y.m11458g("profileImageId : " + strM4342b2, BuddyProfileFragment.f2014a);
                    Intent intent3 = new Intent(this.f2908a.f2058aQ, (Class<?>) BuddyProfileImageView.class);
                    intent3.putExtra("PROFILE_BUDDY_NO", this.f2908a.f2117t);
                    intent3.putExtra("PROFILE_BUDDY_IMAGE_ID", strM4342b2);
                    intent3.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                    if (GlobalApplication.m6456e()) {
                        intent3.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVIEW", "PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVUEW_VALUE");
                    }
                    this.f2908a.startActivity(intent3);
                    break;
                case R.id.profile_image_3 /* 2131165872 */:
                    String strM4342b3 = this.f2908a.f2030O.m4342b();
                    C3250y.m11458g("profileImageId : " + strM4342b3, BuddyProfileFragment.f2014a);
                    Intent intent4 = new Intent(this.f2908a.f2058aQ, (Class<?>) BuddyProfileImageView.class);
                    intent4.putExtra("PROFILE_BUDDY_NO", this.f2908a.f2117t);
                    intent4.putExtra("PROFILE_BUDDY_IMAGE_ID", strM4342b3);
                    intent4.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                    if (GlobalApplication.m6456e()) {
                        intent4.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVIEW", "PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVUEW_VALUE");
                    }
                    this.f2908a.startActivity(intent4);
                    break;
                case R.id.btn_edit_buddyname /* 2131165874 */:
                    Intent intent5 = new Intent(this.f2908a.f2058aQ, (Class<?>) BuddyEditNickNameActivity.class);
                    intent5.putExtra("PROFILE_ID", this.f2908a.f2117t);
                    intent5.putExtra("PROFILE_NAME", this.f2908a.f2032Q.getText());
                    intent5.putExtra("PROFILE_BUDDY_MODE", true);
                    if (GlobalApplication.m6456e() && this.f2908a.getArguments().getInt("ACTIVITY_PURPOSE_CALL_START_CHAT", 0) == 21) {
                        intent5.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                    }
                    this.f2908a.startActivityForResult(intent5, 7);
                    break;
                case R.id.btn_buddyprofile_info /* 2131165875 */:
                    Intent intent6 = new Intent(this.f2908a.f2058aQ, (Class<?>) BuddyInfoActivity.class);
                    intent6.putExtra("PROFILE_BUDDY_NO", this.f2908a.f2117t);
                    intent6.putExtra("PROFILE_BUDDY_NAME", this.f2908a.f2118u);
                    if (GlobalApplication.m6456e() && this.f2908a.getArguments().getInt("ACTIVITY_PURPOSE_CALL_START_CHAT", 0) == 21) {
                        intent6.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                    }
                    this.f2908a.startActivity(intent6);
                    break;
                case R.id.buddypage_main_poston_write /* 2131165876 */:
                    Intent intent7 = new Intent(this.f2908a.f2058aQ, (Class<?>) PostONWriteActivity.class);
                    intent7.putExtra("CHATON_ID", this.f2908a.f2117t);
                    intent7.putExtra("WRITE_FROM", "BUDDY_PAGE");
                    this.f2908a.startActivityForResult(intent7, 9);
                    break;
                case R.id.btn_fav_buddyname /* 2131165880 */:
                    if (this.f2908a.f2097bd != null) {
                        if (!this.f2908a.f2121x) {
                            this.f2908a.f2109l.startQuery(4, this.f2908a.f2116s, C1445m.f5377a, null, "group_relation_group = 1 ", null, null);
                            break;
                        } else {
                            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                                C3358h.m11842a().m11846a("00040002");
                            }
                            this.f2908a.f2109l.startDelete(2, this.f2908a.f2116s, C1445m.f5377a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{this.f2908a.f2117t});
                            break;
                        }
                    }
                    break;
                case R.id.btn_start_chat /* 2131165881 */:
                    Intent intent8 = new Intent(this.f2908a.f2058aQ, (Class<?>) TabActivity.class);
                    intent8.setFlags(67108864);
                    intent8.putExtra("callChatList", true);
                    intent8.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                    intent8.putExtra("receivers", new String[]{this.f2908a.f2117t});
                    intent8.putExtra("groupId", String.valueOf(this.f2908a.f2116s.m3970a()));
                    this.f2908a.startActivity(intent8);
                    this.f2908a.getActivity().sendBroadcast(new Intent(BuddyFragment.f1735n));
                    break;
                case R.id.btn_call /* 2131165883 */:
                    if (!this.f2908a.f2120w) {
                        if (this.f2908a.f2116s.m3979f() == null || this.f2908a.f2116s.m3979f().length() <= 0) {
                            if (this.f2908a.f2119v != null) {
                                uriM3720b2 = this.f2908a.m3720b(this.f2908a.f2119v);
                                if (uriM3720b2 == null) {
                                    uriM3720b2 = Uri.parse("tel:" + this.f2908a.f2119v);
                                }
                                C3250y.m11450b("no multi [2] Call Number: " + uriM3720b2.toString(), BuddyProfileFragment.f2014a);
                            } else {
                                uriM3720b2 = Uri.parse("tel:+" + this.f2908a.f2117t);
                                C3250y.m11450b("no multi [3] Call Number: " + uriM3720b2.toString(), BuddyProfileFragment.f2014a);
                            }
                        } else {
                            uriM3720b2 = Uri.parse("tel:" + this.f2908a.f2116s.m3979f());
                            C3250y.m11450b("no multi [1] Call Number: " + uriM3720b2.toString(), BuddyProfileFragment.f2014a);
                        }
                        C3250y.m11450b("Call Number: " + uriM3720b2.toString(), BuddyProfileFragment.f2014a);
                        try {
                            this.f2908a.startActivity(new Intent("android.intent.action.CALL", uriM3720b2));
                            break;
                        } catch (ActivityNotFoundException e) {
                            C3250y.m11443a(e, getClass().getSimpleName());
                            return;
                        }
                    } else {
                        List listM3689o = this.f2908a.m3689o();
                        if (listM3689o.size() == 1) {
                            if (this.f2908a.f2119v != null) {
                                uriM3720b = this.f2908a.m3720b(this.f2908a.f2119v);
                                if (uriM3720b == null) {
                                    uriM3720b = Uri.parse("tel:" + this.f2908a.f2119v);
                                }
                                C3250y.m11450b("[r2d209] multi [1] Call Number: " + uriM3720b.toString(), BuddyProfileFragment.f2014a);
                            } else {
                                uriM3720b = Uri.parse("tel:+" + ((String) listM3689o.get(0)));
                                C3250y.m11450b("[r2d209] multi [2] Call Number: " + uriM3720b.toString(), BuddyProfileFragment.f2014a);
                            }
                            C3250y.m11450b("Call Number: " + uriM3720b.toString(), BuddyProfileFragment.f2014a);
                            try {
                                this.f2908a.startActivity(new Intent("android.intent.action.CALL", uriM3720b));
                                break;
                            } catch (ActivityNotFoundException e2) {
                                C3250y.m11443a(e2, getClass().getSimpleName());
                                return;
                            }
                        } else if (listM3689o.size() > 1) {
                            Intent intent9 = new Intent(this.f2908a.getActivity(), (Class<?>) PhoneNumberSelectorDialog.class);
                            intent9.putExtra("PN_DIALOG_BUDDY_TYPE", 1);
                            intent9.putExtra("PN_DIALOG_BUDDY_MSISDNS", this.f2908a.f2116s.m3980g());
                            this.f2908a.startActivity(intent9);
                            break;
                        }
                    }
                    break;
                case R.id.btn_voicecall /* 2131165885 */:
                    if (this.f2908a.m3709y()) {
                        if (this.f2908a.m3707x() && this.f2908a.m3711z() && this.f2908a.m3703v()) {
                            try {
                                if (this.f2908a.m3672h()) {
                                    C3250y.m11450b("ChatON V call id : " + this.f2908a.f2116s.m3981h(), BuddyProfileFragment.f2014a);
                                    C3250y.m11450b("ChatON V call name : " + C3159aa.m10962a().m10979a("Push Name", ""), BuddyProfileFragment.f2014a);
                                    if (this.f2908a.f2057aP.m47a(this.f2908a.f2058aQ.getApplicationContext(), false, this.f2908a.f2117t, C3159aa.m10962a().m10979a("Push Name", ""), null) != 0) {
                                        C3641ai.m13210a(this.f2908a.f2058aQ.getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                        break;
                                    }
                                }
                            } catch (Exception e3) {
                                C3250y.m11443a(e3, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f2908a.startActivity(new Intent(this.f2908a.f2058aQ.getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else {
                        this.f2908a.startActivity(new Intent(this.f2908a.f2058aQ.getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                    break;
                case R.id.btn_videocall /* 2131165887 */:
                    if (this.f2908a.m3709y()) {
                        if (this.f2908a.m3707x() && this.f2908a.m3711z() && this.f2908a.m3703v()) {
                            try {
                                if (this.f2908a.m3672h()) {
                                    C3250y.m11450b("ChatON V call id : " + this.f2908a.f2116s.m3981h(), BuddyProfileFragment.f2014a);
                                    C3250y.m11450b("ChatON V call name : " + C3159aa.m10962a().m10979a("Push Name", ""), BuddyProfileFragment.f2014a);
                                    if (this.f2908a.f2057aP.m47a(this.f2908a.f2058aQ.getApplicationContext(), true, this.f2908a.f2117t, C3159aa.m10962a().m10979a("Push Name", ""), null) != 0) {
                                        C3641ai.m13210a(this.f2908a.f2058aQ.getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                        break;
                                    }
                                }
                            } catch (Exception e4) {
                                C3250y.m11443a(e4, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f2908a.startActivity(new Intent(this.f2908a.f2058aQ.getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else {
                        this.f2908a.startActivity(new Intent(this.f2908a.f2058aQ.getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                    break;
                case R.id.btn_phone /* 2131165889 */:
                    Uri uri = ContactsContract.Contacts.CONTENT_URI;
                    C3250y.m11450b("RAWCONTACTID: " + this.f2908a.f2116s.m3984k() + ", mContactId: " + this.f2908a.f2055aN, BuddyProfileFragment.f2014a);
                    if (!this.f2908a.f2120w) {
                        if (this.f2908a.f2054aM) {
                            this.f2908a.m3679j(this.f2908a.f2116s.m3979f());
                            break;
                        } else if (this.f2908a.f2117t.startsWith("+")) {
                            this.f2908a.m3679j(this.f2908a.f2117t);
                            break;
                        } else {
                            this.f2908a.m3679j("+" + this.f2908a.f2117t);
                            break;
                        }
                    } else {
                        List listM3689o2 = this.f2908a.m3689o();
                        if (listM3689o2.size() == 1) {
                            if (((String) listM3689o2.get(0)).startsWith("+")) {
                                this.f2908a.m3679j((String) listM3689o2.get(0));
                                break;
                            } else {
                                this.f2908a.m3679j("+" + ((String) listM3689o2.get(0)));
                                break;
                            }
                        } else if (listM3689o2.size() > 1) {
                            Intent intent10 = new Intent(this.f2908a.getActivity(), (Class<?>) PhoneNumberSelectorDialog.class);
                            intent10.putExtra("PN_DIALOG_BUDDY_TYPE", 2);
                            intent10.putExtra("PN_DIALOG_BUDDY_NAME", this.f2908a.f2116s.m3976c());
                            intent10.putExtra("PN_DIALOG_BUDDY_MSISDNS", this.f2908a.f2116s.m3980g());
                            if (this.f2908a.f2116s.m3978e() != null) {
                                intent10.putExtra("PN_DIALOG_BUDDY_SAMSUNGEMAIL", this.f2908a.f2116s.m3978e());
                            }
                            this.f2908a.startActivity(intent10);
                            break;
                        }
                    }
                    break;
                case R.id.buddy_profile_popup_button_addbuddy /* 2131166344 */:
                    this.f2908a.m3691p();
                    break;
                case R.id.buddy_profile_popup_alarm /* 2131166345 */:
                    Intent intent11 = new Intent(this.f2908a.getActivity(), (Class<?>) SpamConfirmDialog.class);
                    if (TextUtils.isEmpty(this.f2908a.f2118u)) {
                        intent11.putExtra("SCD_DIALOG_BUDDY_NAME", this.f2908a.getString(R.string.unknown));
                    } else {
                        intent11.putExtra("SCD_DIALOG_BUDDY_NAME", this.f2908a.f2118u);
                    }
                    intent11.putExtra("SCD_DIALOG_BUDDY_NO", this.f2908a.f2117t);
                    this.f2908a.startActivity(intent11);
                    this.f2908a.getActivity().finish();
                    break;
                case R.id.buddy_profile_popup_button_block /* 2131166346 */:
                    this.f2908a.m3693q();
                    break;
                case R.id.buddy_profile_popup_button_ignore /* 2131166347 */:
                    this.f2908a.m3695r();
                    break;
                case R.id.buddy_profile_popup_button_unblock /* 2131166348 */:
                    this.f2908a.m3665g();
                    break;
            }
        }
    }
}
