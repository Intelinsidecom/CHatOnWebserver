package com.sec.chaton.buddy.dialog;

import android.content.ContentValues;
import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.buddy.ViewProfileImage;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC0617ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f2835a;

    ViewOnClickListenerC0617ak(SpecialBuddyDialog specialBuddyDialog) {
        this.f2835a = specialBuddyDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            switch (view.getId()) {
                case R.id.buddy_cprofile_popup_add /* 2131165386 */:
                    this.f2835a.m4299d();
                    break;
                case R.id.special_buddy_profile_popup_favorite_btn /* 2131166494 */:
                    if (this.f2835a.m4302d(true)) {
                        this.f2835a.m4298c(true);
                        if (this.f2835a.f2815u) {
                            new C1330h(this.f2835a.f2797c).m5750f(this.f2835a.f2803i);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("likecount", String.valueOf(this.f2835a.f2805k));
                            contentValues.put("islike", "N");
                            this.f2835a.f2798d.startUpdate(2, this.f2835a.f2799e, C1390ah.f5188a, contentValues, "buddy_no='" + this.f2835a.f2799e.m4000a() + "'", null);
                        } else {
                            new C1330h(this.f2835a.f2797c).m5746e(this.f2835a.f2803i);
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("likecount", String.valueOf(this.f2835a.f2805k));
                            contentValues2.put("islike", "Y");
                            this.f2835a.f2798d.startUpdate(2, this.f2835a.f2799e, C1390ah.f5188a, contentValues2, "buddy_no='" + this.f2835a.f2799e.m4000a() + "'", null);
                        }
                        this.f2835a.m4294b(!this.f2835a.f2815u);
                        break;
                    }
                    break;
                case R.id.special_buddy_profile_popup_image /* 2131166497 */:
                    BuddyFragment.f1734m = true;
                    int code = Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode();
                    if (this.f2835a.f2808n.getDrawable() == null) {
                        code = Buddy.BuddyImageStatus.NONE_PROFILE.getCode();
                    }
                    Intent intent = new Intent(this.f2835a.f2802h, (Class<?>) ViewProfileImage.class);
                    intent.putExtra("PROFILE_BUDDY_NO", this.f2835a.f2803i);
                    intent.putExtra("PROFILE_BUDDY_BIGIMAGE_STATUS", code);
                    this.f2835a.startActivityForResult(intent, 0);
                    this.f2835a.finish();
                    break;
                case R.id.special_buddy_profile_popup_contents /* 2131166501 */:
                    BuddyFragment.f1734m = true;
                    if (C3250y.f11735c) {
                        C3250y.m11453c("profile_special_chat, isTaskRoot: " + this.f2835a.isTaskRoot() + ", Task ID: " + this.f2835a.getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
                    }
                    Intent intent2 = new Intent(CommonApplication.m11493l(), (Class<?>) ChatActivity.class);
                    intent2.setFlags(67108864);
                    intent2.putExtra("callChatList", true);
                    intent2.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                    intent2.putExtra("receivers", new String[]{this.f2835a.f2799e.m4000a()});
                    intent2.putExtra("specialbuddy", true);
                    this.f2835a.startActivity(intent2);
                    this.f2835a.finish();
                    break;
                case R.id.special_buddy_profile_popup_ignore /* 2131166503 */:
                    if (C3250y.f11735c) {
                        C3250y.m11453c("profile_ignore_special_buddy, isTaskRoot: " + this.f2835a.isTaskRoot() + ", Task ID: " + this.f2835a.getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
                    }
                    if (this.f2835a.m4302d(true) && this.f2835a.f2807m) {
                        this.f2835a.m4306f();
                        this.f2835a.m4303e();
                        break;
                    }
                    break;
                case R.id.special_buddy_profile_popup_add_buddy /* 2131166504 */:
                    if (C3250y.f11735c) {
                        C3250y.m11453c("profile_add_special_buddy, isTaskRoot: " + this.f2835a.isTaskRoot() + ", Task ID: " + this.f2835a.getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
                    }
                    if (this.f2835a.m4302d(true)) {
                        this.f2835a.m4306f();
                        this.f2835a.m4299d();
                        break;
                    }
                    break;
                case R.id.special_buddy_profile_popup_view_profile /* 2131166505 */:
                    BuddyFragment.f1734m = true;
                    Intent intent3 = new Intent(this.f2835a.f2802h, (Class<?>) SpecialBuddyActivity.class);
                    intent3.putExtra("specialuserid", this.f2835a.f2803i);
                    intent3.putExtra("speicalusername", this.f2835a.f2804j);
                    intent3.putExtra("specialBuddyAdded", this.f2835a.f2807m);
                    this.f2835a.f2802h.startActivity(intent3);
                    this.f2835a.finish();
                    break;
            }
        }
    }
}
