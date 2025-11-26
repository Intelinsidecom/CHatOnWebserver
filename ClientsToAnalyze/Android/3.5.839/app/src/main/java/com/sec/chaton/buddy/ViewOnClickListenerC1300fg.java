package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.buddy.dialog.PhoneNumberSelectorDialog;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.fg */
/* loaded from: classes.dex */
class ViewOnClickListenerC1300fg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4836a;

    ViewOnClickListenerC1300fg(BuddyInfoFragment buddyInfoFragment) {
        this.f4836a = buddyInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            switch (view.getId()) {
                case R.id.profile_chat /* 2131165406 */:
                    Intent intentM2923a = IntentControllerActivity.m2923a((Context) this.f4836a.f3845O, true);
                    intentM2923a.setFlags(67108864);
                    intentM2923a.putExtra("callChatList", true);
                    intentM2923a.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                    intentM2923a.putExtra("receivers", new String[]{this.f4836a.f3866l});
                    this.f4836a.startActivity(intentM2923a);
                    this.f4836a.f3845O.finish();
                    break;
                case R.id.profile_v_voice /* 2131165410 */:
                    if (this.f4836a.m6704h()) {
                        if (this.f4836a.m6703g() && this.f4836a.m6706i() && this.f4836a.m6698e()) {
                            try {
                                if (this.f4836a.m6710k() && this.f4836a.f3850T.m1487a(this.f4836a.f3845O, false, this.f4836a.f3866l, this.f4836a.f3867m, null) != 0) {
                                    C5179v.m19810a(this.f4836a.f3845O, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                    break;
                                }
                            } catch (Exception e) {
                                C4904y.m18635a(e, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f4836a.startActivity(new Intent(this.f4836a.f3845O, (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else {
                        this.f4836a.startActivity(new Intent(this.f4836a.f3845O, (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                    break;
                case R.id.profile_v_video /* 2131165412 */:
                    if (this.f4836a.m6704h()) {
                        if (this.f4836a.m6703g() && this.f4836a.m6706i() && this.f4836a.m6698e()) {
                            try {
                                if (this.f4836a.m6710k() && this.f4836a.f3850T.m1487a(this.f4836a.f3845O, true, this.f4836a.f3866l, this.f4836a.f3867m, null) != 0) {
                                    C5179v.m19810a(this.f4836a.f3845O, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                    break;
                                }
                            } catch (Exception e2) {
                                C4904y.m18635a(e2, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f4836a.startActivity(new Intent(this.f4836a.f3845O, (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else {
                        this.f4836a.startActivity(new Intent(this.f4836a.f3845O, (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                    break;
                case R.id.profile_contact /* 2131165414 */:
                    Uri uri = ContactsContract.Contacts.CONTENT_URI;
                    C4904y.m18639b("RAWCONTACTID: " + this.f4836a.f3865k.m7061j() + ", mContactId: " + this.f4836a.f3870p, BuddyInfoFragment.f3830j);
                    this.f4836a.f3847Q = true;
                    if (this.f4836a.f3871q.size() == 1) {
                        this.f4836a.m6683b((String) this.f4836a.f3871q.get(0));
                        break;
                    } else if (this.f4836a.f3871q.size() > 1) {
                        Intent intent = new Intent(this.f4836a.f3845O, (Class<?>) PhoneNumberSelectorDialog.class);
                        intent.putExtra("PN_DIALOG_BUDDY_TYPE", 2);
                        intent.putExtra("PN_DIALOG_BUDDY_NAME", this.f4836a.f3865k.m7051b());
                        intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", this.f4836a.f3865k.m7044G());
                        intent.putExtra("PN_DIALOG_BUDDY_HAS_EXTERNAL_PHONENUMBER_USE", true);
                        if (this.f4836a.f3865k.m7055d() != null) {
                            intent.putExtra("PN_DIALOG_BUDDY_SAMSUNGEMAIL", this.f4836a.f3865k.m7055d());
                        }
                        this.f4836a.startActivity(intent);
                        break;
                    }
                    break;
                case R.id.profile_sms /* 2131165810 */:
                    this.f4836a.m6734b();
                    break;
                case R.id.profile_call /* 2131165811 */:
                    C4904y.m18639b("************ BUDDY NO : " + this.f4836a.f3866l, BuddyInfoFragment.f3830j);
                    C4904y.m18639b("************ BUDDY ORG NO : " + this.f4836a.f3865k.m7056e(), BuddyInfoFragment.f3830j);
                    if (this.f4836a.f3871q.size() == 1) {
                        Uri uri2 = Uri.parse("tel:+" + C3789h.m14307c((String) this.f4836a.f3871q.get(0)));
                        C4904y.m18639b("Call Number: " + uri2.toString(), BuddyInfoFragment.f3830j);
                        try {
                            this.f4836a.startActivity(new Intent("android.intent.action.CALL", uri2));
                            break;
                        } catch (ActivityNotFoundException e3) {
                            C4904y.m18635a(e3, getClass().getSimpleName());
                            return;
                        }
                    } else if (this.f4836a.f3871q.size() > 1) {
                        Intent intent2 = new Intent(this.f4836a.f3845O, (Class<?>) PhoneNumberSelectorDialog.class);
                        intent2.putExtra("PN_DIALOG_BUDDY_TYPE", 1);
                        intent2.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", this.f4836a.f3865k.m7044G());
                        intent2.putExtra("PN_DIALOG_BUDDY_HAS_EXTERNAL_PHONENUMBER_USE", true);
                        this.f4836a.startActivity(intent2);
                        break;
                    }
                    break;
            }
        }
    }
}
