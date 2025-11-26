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
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.util.List;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.eg */
/* loaded from: classes.dex */
class ViewOnClickListenerC0669eg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f2890a;

    ViewOnClickListenerC0669eg(BuddyInfoFragment buddyInfoFragment) {
        this.f2890a = buddyInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Uri uri;
        if (!C3197bl.m11159a()) {
            switch (view.getId()) {
                case R.id.profile_chat /* 2131165403 */:
                    Intent intentM1171a = IntentControllerActivity.m1171a((Context) this.f2890a.f1963K, true);
                    intentM1171a.setFlags(67108864);
                    intentM1171a.putExtra("callChatList", true);
                    intentM1171a.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                    intentM1171a.putExtra("receivers", new String[]{this.f2890a.f1976f});
                    this.f2890a.startActivity(intentM1171a);
                    this.f2890a.f1963K.finish();
                    break;
                case R.id.profile_v_voice /* 2131165407 */:
                    if (this.f2890a.m3546g()) {
                        if (this.f2890a.m3544f() && this.f2890a.m3547h() && this.f2890a.m3538d()) {
                            try {
                                if (this.f2890a.m3551j() && this.f2890a.f1968P.m47a(this.f2890a.f1963K, false, this.f2890a.f1976f, this.f2890a.f1977g, null) != 0) {
                                    C3641ai.m13210a(this.f2890a.f1963K, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                    break;
                                }
                            } catch (Exception e) {
                                C3250y.m11443a(e, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f2890a.startActivity(new Intent(this.f2890a.f1963K, (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else {
                        this.f2890a.startActivity(new Intent(this.f2890a.f1963K, (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                    break;
                case R.id.profile_v_video /* 2131165409 */:
                    if (this.f2890a.m3546g()) {
                        if (this.f2890a.m3544f() && this.f2890a.m3547h() && this.f2890a.m3538d()) {
                            try {
                                if (this.f2890a.m3551j() && this.f2890a.f1968P.m47a(this.f2890a.f1963K, true, this.f2890a.f1976f, this.f2890a.f1977g, null) != 0) {
                                    C3641ai.m13210a(this.f2890a.f1963K, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                    break;
                                }
                            } catch (Exception e2) {
                                C3250y.m11443a(e2, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f2890a.startActivity(new Intent(this.f2890a.f1963K, (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else {
                        this.f2890a.startActivity(new Intent(this.f2890a.f1963K, (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                    break;
                case R.id.profile_contact /* 2131165411 */:
                    Uri uri2 = ContactsContract.Contacts.CONTENT_URI;
                    C3250y.m11450b("RAWCONTACTID: " + this.f2890a.f1975e.m3984k() + ", mContactId: " + this.f2890a.f1980j, BuddyInfoFragment.f1952d);
                    this.f2890a.f1965M = true;
                    if (!this.f2890a.f1964L) {
                        if (this.f2890a.f1967O) {
                            this.f2890a.m3528b(this.f2890a.f1975e.m3979f());
                            break;
                        } else if (this.f2890a.f1976f.startsWith("+")) {
                            this.f2890a.m3528b(this.f2890a.f1976f);
                            break;
                        } else {
                            this.f2890a.m3528b("+" + this.f2890a.f1976f);
                            break;
                        }
                    } else {
                        List listM3563p = this.f2890a.m3563p();
                        if (listM3563p.size() == 1) {
                            if (((String) listM3563p.get(0)).startsWith("+")) {
                                this.f2890a.m3528b((String) listM3563p.get(0));
                                break;
                            } else {
                                this.f2890a.m3528b("+" + ((String) listM3563p.get(0)));
                                break;
                            }
                        } else if (listM3563p.size() > 1) {
                            Intent intent = new Intent(this.f2890a.f1963K, (Class<?>) PhoneNumberSelectorDialog.class);
                            intent.putExtra("PN_DIALOG_BUDDY_TYPE", 2);
                            intent.putExtra("PN_DIALOG_BUDDY_NAME", this.f2890a.f1975e.m3976c());
                            intent.putExtra("PN_DIALOG_BUDDY_MSISDNS", this.f2890a.f1975e.m3980g());
                            if (this.f2890a.f1975e.m3978e() != null) {
                                intent.putExtra("PN_DIALOG_BUDDY_SAMSUNGEMAIL", this.f2890a.f1975e.m3978e());
                            }
                            this.f2890a.startActivity(intent);
                            break;
                        }
                    }
                    break;
                case R.id.profile_call /* 2131165864 */:
                    C3250y.m11458g("************ BUDDY NO : " + this.f2890a.f1976f, BuddyInfoFragment.f1952d);
                    C3250y.m11458g("************ BUDDY ORG NO : " + this.f2890a.f1975e.m3979f(), BuddyInfoFragment.f1952d);
                    if (!this.f2890a.f1964L) {
                        Uri uri3 = (this.f2890a.f1975e.m3979f() == null || this.f2890a.f1975e.m3979f().length() <= 0) ? this.f2890a.f1979i != null ? Uri.parse("tel:" + this.f2890a.f1979i) : Uri.parse("tel:+" + this.f2890a.f1976f) : Uri.parse("tel:" + this.f2890a.f1975e.m3979f());
                        C3250y.m11450b("Call Number: " + uri3.toString(), BuddyInfoFragment.f1952d);
                        Intent intent2 = new Intent("android.intent.action.CALL", uri3);
                        intent2.setFlags(268435456);
                        try {
                            this.f2890a.startActivityForResult(intent2, 0);
                            break;
                        } catch (ActivityNotFoundException e3) {
                            C3250y.m11443a(e3, getClass().getSimpleName());
                            return;
                        }
                    } else {
                        List listM3563p2 = this.f2890a.m3563p();
                        if (listM3563p2.size() == 1) {
                            if (this.f2890a.f1979i != null) {
                                uri = Uri.parse("tel:" + this.f2890a.f1979i);
                            } else {
                                uri = Uri.parse("tel:+" + ((String) listM3563p2.get(0)));
                            }
                            C3250y.m11450b("Call Number: " + uri.toString(), BuddyInfoFragment.f1952d);
                            try {
                                this.f2890a.startActivity(new Intent("android.intent.action.CALL", uri));
                                break;
                            } catch (ActivityNotFoundException e4) {
                                C3250y.m11443a(e4, getClass().getSimpleName());
                                return;
                            }
                        } else if (listM3563p2.size() > 1) {
                            Intent intent3 = new Intent(this.f2890a.f1963K, (Class<?>) PhoneNumberSelectorDialog.class);
                            intent3.putExtra("PN_DIALOG_BUDDY_TYPE", 1);
                            intent3.putExtra("PN_DIALOG_BUDDY_MSISDNS", this.f2890a.f1975e.m3980g());
                            this.f2890a.startActivity(intent3);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
