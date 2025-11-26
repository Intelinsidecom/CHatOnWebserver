package com.sec.chaton.buddy.dialog;

import android.content.ContentValues;
import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.buddy.ViewProfileImage;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.au */
/* loaded from: classes.dex */
class ViewOnClickListenerC1221au implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f4719a;

    ViewOnClickListenerC1221au(SpecialBuddyDialog specialBuddyDialog) {
        this.f4719a = specialBuddyDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            switch (view.getId()) {
                case R.id.buddy_cprofile_popup_add /* 2131165384 */:
                    this.f4719a.m7373e();
                    break;
                case R.id.special_buddy_profile_popup_favorite_btn /* 2131166560 */:
                    if (this.f4719a.m7369c(true)) {
                        this.f4719a.m7365b(true);
                        if (this.f4719a.f4693y) {
                            new C2128i(this.f4719a.f4671c).m9524e(this.f4719a.f4677i);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("likecount", String.valueOf(this.f4719a.f4680l));
                            contentValues.put("islike", "N");
                            this.f4719a.f4672d.startUpdate(502, this.f4719a.f4673e, C2230ar.f7958a, contentValues, "buddy_no='" + this.f4719a.f4673e.m7082a() + "'", null);
                        } else {
                            new C2128i(this.f4719a.f4671c).m9519d(this.f4719a.f4677i);
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("likecount", String.valueOf(this.f4719a.f4680l));
                            contentValues2.put("islike", "Y");
                            this.f4719a.f4672d.startUpdate(502, this.f4719a.f4673e, C2230ar.f7958a, contentValues2, "buddy_no='" + this.f4719a.f4673e.m7082a() + "'", null);
                        }
                        this.f4719a.m7358a(!this.f4719a.f4693y);
                        break;
                    }
                    break;
                case R.id.special_buddy_profile_popup_image /* 2131166564 */:
                    BuddyFragment.f3586l = true;
                    int code = Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode();
                    if (this.f4719a.f4686r.getDrawable() == null) {
                        code = Buddy.BuddyImageStatus.NONE_PROFILE.getCode();
                    }
                    Intent intent = new Intent(this.f4719a.f4676h, (Class<?>) ViewProfileImage.class);
                    intent.putExtra("PROFILE_BUDDY_NO", this.f4719a.f4677i);
                    intent.putExtra("PROFILE_BUDDY_BIGIMAGE_STATUS", code);
                    this.f4719a.startActivityForResult(intent, 0);
                    this.f4719a.finish();
                    break;
                case R.id.special_buddy_profile_popup_contents /* 2131166568 */:
                    BuddyFragment.f3586l = true;
                    if (C4904y.f17873c) {
                        C4904y.m18641c("profile_special_chat, isTaskRoot: " + this.f4719a.isTaskRoot() + ", Task ID: " + this.f4719a.getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
                    }
                    Intent intent2 = new Intent(CommonApplication.m18732r(), (Class<?>) ChatActivity.class);
                    intent2.setFlags(67108864);
                    intent2.putExtra("callChatList", true);
                    intent2.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                    intent2.putExtra("receivers", new String[]{this.f4719a.f4673e.m7082a()});
                    intent2.putExtra("specialbuddy", true);
                    intent2.putExtra("roomType", EnumC2301u.LIVE.m10212a());
                    intent2.putExtra("liveUserType", this.f4719a.f4673e.m7093j().m7095a());
                    intent2.putExtra("liveServiceType", EnumC4549n.LIVECONTENTS.m17247a());
                    this.f4719a.startActivity(intent2);
                    this.f4719a.finish();
                    break;
                case R.id.special_buddy_profile_popup_chat /* 2131166569 */:
                    BuddyFragment.f3586l = true;
                    if (C4904y.f17873c) {
                        C4904y.m18641c("profile_special_chat, isTaskRoot: " + this.f4719a.isTaskRoot() + ", Task ID: " + this.f4719a.getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
                    }
                    Intent intent3 = new Intent(CommonApplication.m18732r(), (Class<?>) ChatActivity.class);
                    intent3.setFlags(67108864);
                    intent3.putExtra("callChatList", true);
                    intent3.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                    intent3.putExtra("receivers", new String[]{this.f4719a.f4673e.m7082a()});
                    intent3.putExtra("specialbuddy", true);
                    intent3.putExtra("roomType", EnumC2301u.LIVE.m10212a());
                    intent3.putExtra("liveUserType", this.f4719a.f4673e.m7093j().m7095a());
                    intent3.putExtra("liveServiceType", EnumC4549n.LIVECHAT.m17247a());
                    this.f4719a.startActivity(intent3);
                    this.f4719a.finish();
                    break;
                case R.id.special_buddy_profile_popup_ignore /* 2131166570 */:
                    if (C4904y.f17873c) {
                        C4904y.m18641c("profile_ignore_special_buddy, isTaskRoot: " + this.f4719a.isTaskRoot() + ", Task ID: " + this.f4719a.getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
                    }
                    if (this.f4719a.m7369c(true) && this.f4719a.f4685q) {
                        this.f4719a.m7378g();
                        this.f4719a.m7376f();
                        break;
                    }
                    break;
                case R.id.special_buddy_profile_popup_add_buddy /* 2131166571 */:
                    if (C4904y.f17873c) {
                        C4904y.m18641c("profile_add_special_buddy, isTaskRoot: " + this.f4719a.isTaskRoot() + ", Task ID: " + this.f4719a.getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
                    }
                    if (this.f4719a.m7369c(true)) {
                        this.f4719a.m7378g();
                        this.f4719a.m7373e();
                        break;
                    }
                    break;
                case R.id.special_buddy_profile_popup_view_profile /* 2131166572 */:
                    BuddyFragment.f3586l = true;
                    Intent intent4 = new Intent(this.f4719a.f4676h, (Class<?>) SpecialBuddyActivity.class);
                    intent4.putExtra("specialuserid", this.f4719a.f4677i);
                    intent4.putExtra("speicalusername", this.f4719a.f4678j);
                    intent4.putExtra("specialBuddyAdded", this.f4719a.f4685q);
                    this.f4719a.f4676h.startActivity(intent4);
                    this.f4719a.finish();
                    break;
            }
        }
    }
}
