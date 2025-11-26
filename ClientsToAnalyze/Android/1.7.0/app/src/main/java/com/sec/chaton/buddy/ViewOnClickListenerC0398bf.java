package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.account.C0239h;
import com.sec.chaton.coolots.C0613d;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.memo.WriteMemoActivity;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p013a.C0217p;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.p025d.C0668u;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1346u;
import com.sec.widget.C1619g;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.bf */
/* loaded from: classes.dex */
class ViewOnClickListenerC0398bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1372a;

    ViewOnClickListenerC0398bf(BuddyProfileActivity buddyProfileActivity) {
        this.f1372a = buddyProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            switch (view.getId()) {
                case R.id.profile_chat /* 2131427556 */:
                    Intent intent = new Intent(this.f1372a.f1240k, (Class<?>) HomeActivity.class);
                    intent.setFlags(67108864);
                    intent.putExtra("callChatList", true);
                    intent.putExtra("chatType", EnumC0665r.ONETOONE.m3012a());
                    intent.putExtra("receivers", new String[]{this.f1372a.f1241l.m2308a()});
                    this.f1372a.startActivity(intent);
                    this.f1372a.finish();
                    break;
                case R.id.profile_voice_call /* 2131427557 */:
                case R.id.profile_video_call /* 2131427558 */:
                    if (!new C0613d(this.f1372a, null, new String[]{this.f1372a.f1241l.m2308a()}, view.getId() == R.id.profile_voice_call).m2832b()) {
                        C1619g.m5889a(this.f1372a, "Install Coolots app first.", 0).show();
                        break;
                    }
                    break;
                case R.id.profile_call /* 2131427559 */:
                    C1341p.m4663f("************ BUDDY NO : " + this.f1372a.f1241l.m2308a(), BuddyProfileActivity.f1198a);
                    C1341p.m4663f("************ BUDDY ORG NO : " + this.f1372a.f1241l.m2319e(), BuddyProfileActivity.f1198a);
                    Intent intent2 = new Intent("android.intent.action.CALL", (this.f1372a.f1241l.m2319e() == null || this.f1372a.f1241l.m2319e().length() <= 0) ? Uri.parse("tel:+" + this.f1372a.f1241l.m2308a()) : Uri.parse("tel:" + this.f1372a.f1241l.m2319e()));
                    intent2.setFlags(268435456);
                    try {
                        this.f1372a.startActivityForResult(intent2, 0);
                        break;
                    } catch (ActivityNotFoundException e) {
                        C1341p.m4653a(e, getClass().getSimpleName());
                        return;
                    }
                    break;
                case R.id.profile_contact /* 2131427560 */:
                    Uri uri = ContactsContract.Contacts.CONTENT_URI;
                    C1341p.m4658b("RAWCONTACTID: " + this.f1372a.f1241l.m2322h() + ", mContactId: " + this.f1372a.f1228ae, BuddyProfileActivity.f1198a);
                    if (this.f1372a.f1227ad) {
                        long jM905a = C0239h.m905a(this.f1372a.f1241l.m2322h());
                        if (jM905a == 0) {
                            jM905a = this.f1372a.f1228ae;
                        }
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(Uri.parse(uri + "/" + jM905a));
                        this.f1372a.startActivityForResult(intent3, 0);
                        break;
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("phone", "+" + this.f1372a.f1241l.m2308a());
                        bundle.putString("name", this.f1372a.f1241l.m2314b());
                        Intent intent4 = new Intent("android.intent.action.INSERT", uri);
                        intent4.putExtras(bundle);
                        intent4.putExtra("return-data", true);
                        this.f1372a.startActivityForResult(intent4, 5);
                        break;
                    }
                case R.id.profile_msg /* 2131427561 */:
                    C1341p.m4663f("************ BUDDY NO : " + this.f1372a.f1241l.m2308a(), BuddyProfileActivity.f1198a);
                    C1341p.m4663f("************ BUDDY ORG NO : " + this.f1372a.f1241l.m2319e(), BuddyProfileActivity.f1198a);
                    String strM2319e = (this.f1372a.f1241l.m2319e() == null || this.f1372a.f1241l.m2319e().length() <= 0) ? "+" + this.f1372a.f1241l.m2308a() : this.f1372a.f1241l.m2319e();
                    C1341p.m4663f("************ PHONE NO : " + strM2319e, BuddyProfileActivity.f1198a);
                    try {
                        Intent intent5 = new Intent("android.intent.action.VIEW");
                        intent5.putExtra("address", strM2319e);
                        intent5.setType("vnd.android-dir/mms-sms");
                        this.f1372a.startActivityForResult(intent5, 0);
                        break;
                    } catch (ActivityNotFoundException e2) {
                        C1341p.m4651a("************ SMS ERROR : " + e2.toString(), BuddyProfileActivity.f1198a);
                        return;
                    }
                    break;
                case R.id.profile_calendar /* 2131427567 */:
                    String strM2320f = this.f1372a.f1241l.m2320f();
                    if (strM2320f != null && strM2320f.length() >= 5) {
                        if (strM2320f.length() != 5 && strM2320f.length() == 10) {
                            strM2320f = strM2320f.substring(5);
                        }
                        new AsyncTaskC0385at(this.f1372a).execute(strM2320f);
                        break;
                    }
                    break;
                case R.id.memo_btn_write /* 2131427578 */:
                    int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
                    if (-3 == iM2526a || -2 == iM2526a) {
                        C1619g.m5888a(this.f1372a.f1240k, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else {
                        Intent intent6 = new Intent(this.f1372a.f1240k, (Class<?>) WriteMemoActivity.class);
                        intent6.putExtra("buddyid", this.f1372a.f1242m);
                        this.f1372a.startActivityForResult(intent6, 9);
                        break;
                    }
                    break;
                case R.id.profile_image /* 2131427579 */:
                    Intent intent7 = new Intent(this.f1372a.f1240k, (Class<?>) ViewProfileImage.class);
                    intent7.putExtra("PROFILE_BUDDY_NO", this.f1372a.f1241l.m2308a());
                    intent7.putExtra("PROFILE_BUDDY_BIGIMAGE_STATUS", this.f1372a.f1241l.m2332r());
                    this.f1372a.startActivityForResult(intent7, 0);
                    break;
                case R.id.profile_is_favorite /* 2131427583 */:
                    if (this.f1372a.f1248s.isChecked()) {
                        this.f1372a.f1238i.startQuery(4, this.f1372a.f1241l, C0668u.f2311a, null, "group_relation_group = 1 ", null, null);
                        break;
                    } else {
                        this.f1372a.f1238i.startDelete(2, this.f1372a.f1241l, C0668u.f2311a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{this.f1372a.f1241l.m2308a()});
                        break;
                    }
                case R.id.new_buddy_block /* 2131428175 */:
                    this.f1372a.m2270e();
                    new C0217p(this.f1372a.f1233c).m798a(this.f1372a.f1241l.m2308a(), 1);
                    break;
                case R.id.new_buddy_add /* 2131428176 */:
                    this.f1372a.m2270e();
                    new C0202ao(this.f1372a.f1233c).m764b(this.f1372a.f1242m);
                    break;
                case R.id.new_buddy_cancel /* 2131428177 */:
                    this.f1372a.finish();
                    break;
                case R.id.new_buddy_unblock /* 2131428178 */:
                    new C0217p(this.f1372a.f1233c).m797a(this.f1372a.f1242m);
                    this.f1372a.m2270e();
                    break;
            }
        }
    }
}
