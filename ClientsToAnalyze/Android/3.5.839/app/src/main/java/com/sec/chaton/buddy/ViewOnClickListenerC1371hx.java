package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hx */
/* loaded from: classes.dex */
class ViewOnClickListenerC1371hx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4971a;

    ViewOnClickListenerC1371hx(SpecialBuddyFragment specialBuddyFragment) {
        this.f4971a = specialBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        if (!C4847bl.m18333a()) {
            if (view instanceof ImageButton) {
                if (view.isSelected()) {
                    view.setSelected(false);
                } else {
                    view.setSelected(true);
                }
            }
            switch (view.getId()) {
                case R.id.specialbuddy_profile_image /* 2131166540 */:
                    int code = Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode();
                    ImageView imageView = new ImageView(this.f4971a.f4151j);
                    C2496n.m10765a(imageView, this.f4971a.f4130I, EnumC2498p.ROUND);
                    if (imageView.getDrawable() == null) {
                        code = Buddy.BuddyImageStatus.NONE_PROFILE.getCode();
                    }
                    Intent intent = new Intent(this.f4971a.f4151j, (Class<?>) ViewProfileImage.class);
                    intent.putExtra("PROFILE_BUDDY_NO", this.f4971a.f4130I);
                    intent.putExtra("PROFILE_BUDDY_BIGIMAGE_STATUS", code);
                    this.f4971a.startActivityForResult(intent, 0);
                    break;
                case R.id.profile_special_contents /* 2131166544 */:
                    if (C4904y.f17873c) {
                        C4904y.m18641c("profile_special_chat, isTaskRoot: " + this.f4971a.f4151j.isTaskRoot() + ", Task ID: " + this.f4971a.f4151j.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    }
                    Intent intentM2923a = IntentControllerActivity.m2923a(CommonApplication.m18732r(), true);
                    intentM2923a.setFlags(67108864);
                    intentM2923a.putExtra("callChatList", true);
                    intentM2923a.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                    intentM2923a.putExtra("receivers", new String[]{this.f4971a.f4148g.m7082a()});
                    intentM2923a.putExtra("specialbuddy", true);
                    intentM2923a.putExtra("roomType", EnumC2301u.LIVE.m10212a());
                    intentM2923a.putExtra("liveUserType", this.f4971a.f4148g.m7093j().m7095a());
                    intentM2923a.putExtra("liveServiceType", EnumC4549n.LIVECONTENTS.m17247a());
                    this.f4971a.startActivity(intentM2923a);
                    this.f4971a.f4151j.finish();
                    break;
                case R.id.profile_special_chat /* 2131166545 */:
                    if (C4904y.f17873c) {
                        C4904y.m18641c("profile_special_chat, isTaskRoot: " + this.f4971a.f4151j.isTaskRoot() + ", Task ID: " + this.f4971a.f4151j.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    }
                    Intent intent2 = new Intent(CommonApplication.m18732r(), (Class<?>) ChatActivity.class);
                    intent2.setFlags(67108864);
                    intent2.putExtra("callChatList", true);
                    intent2.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                    intent2.putExtra("receivers", new String[]{this.f4971a.f4148g.m7082a()});
                    intent2.putExtra("specialbuddy", true);
                    intent2.putExtra("roomType", EnumC2301u.LIVE.m10212a());
                    intent2.putExtra("liveUserType", this.f4971a.f4148g.m7093j().m7095a());
                    intent2.putExtra("liveServiceType", EnumC4549n.LIVECHAT.m17247a());
                    this.f4971a.startActivity(intent2);
                    this.f4971a.f4151j.finish();
                    break;
                case R.id.profile_recommend_special_buddy /* 2131166546 */:
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f4971a.f4130I);
                        jSONObject.put("name", this.f4971a.f4131J);
                        this.f4971a.startActivity(this.f4971a.m6952a(this.f4971a.f4151j, EnumC2214ab.LIVERECOMMEND, jSONObject.toString(), null, R.string.live_partner_option_recommend));
                        break;
                    } catch (JSONException e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                            return;
                        }
                        return;
                    }
                case R.id.profile_unfollow_special_buddy /* 2131166547 */:
                    C4904y.m18641c("profile_ignore_special_buddy, isTaskRoot: " + this.f4971a.f4151j.isTaskRoot() + ", Task ID: " + this.f4971a.f4151j.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    if (this.f4971a.m6979c(true) && this.f4971a.f4136O) {
                        this.f4971a.m6986f();
                        this.f4971a.m6984e();
                        break;
                    }
                    break;
                case R.id.buddy_add_contact /* 2131166548 */:
                    C4904y.m18641c("buddy_add_contact, isTaskRoot: " + this.f4971a.f4151j.isTaskRoot() + ", Task ID: " + this.f4971a.f4151j.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    if (this.f4971a.m6979c(true)) {
                        this.f4971a.m6986f();
                        this.f4971a.m6981d();
                        break;
                    }
                    break;
                case R.id.list_special_header /* 2131166554 */:
                    Intent intent3 = new Intent(this.f4971a.f4151j, (Class<?>) ChatActivity.class);
                    intent3.putExtra("liveprofile", true);
                    intent3.putExtra("liveprofile_id", this.f4971a.f4130I);
                    this.f4971a.startActivity(intent3);
                    break;
            }
        }
    }
}
