package com.sec.chaton.buddy;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageButton;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hp */
/* loaded from: classes.dex */
class ViewOnClickListenerC0759hp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3026a;

    ViewOnClickListenerC0759hp(SpecialBuddyFragment specialBuddyFragment) {
        this.f3026a = specialBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        if (!C3197bl.m11159a()) {
            if (view instanceof ImageButton) {
                if (view.isSelected()) {
                    view.setSelected(false);
                } else {
                    view.setSelected(true);
                }
            }
            C1594v.m6733a(CommonApplication.m11493l());
            switch (view.getId()) {
                case R.id.new_buddy_add /* 2131166446 */:
                    if (Build.VERSION.SDK_INT >= 11) {
                        this.f3026a.m3902h();
                        break;
                    } else {
                        this.f3026a.m3929a();
                        break;
                    }
                case R.id.new_buddy_block /* 2131166447 */:
                    if (Build.VERSION.SDK_INT < 11) {
                        this.f3026a.m3902h();
                        break;
                    } else {
                        this.f3026a.m3929a();
                        break;
                    }
                case R.id.new_buddy_unblock /* 2131166448 */:
                    if (Build.VERSION.SDK_INT < 11) {
                        this.f3026a.m3904i();
                        break;
                    } else {
                        this.f3026a.f2288Y.finish();
                        break;
                    }
                case R.id.new_buddy_cancel /* 2131166449 */:
                    if (Build.VERSION.SDK_INT < 11) {
                        this.f3026a.f2288Y.finish();
                        break;
                    } else {
                        this.f3026a.m3904i();
                        break;
                    }
                case R.id.specialbuddy_profile_image /* 2131166471 */:
                    int code = Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode();
                    C3205bt.m11182a(this.f3026a.f2288Y).m11211a(this.f3026a.f2313r, this.f3026a.f2306k, code);
                    if (this.f3026a.f2313r.getDrawable() == null) {
                        code = Buddy.BuddyImageStatus.NONE_PROFILE.getCode();
                    }
                    Intent intent = new Intent(this.f3026a.f2288Y, (Class<?>) ViewProfileImage.class);
                    intent.putExtra("PROFILE_BUDDY_NO", this.f3026a.f2306k);
                    intent.putExtra("PROFILE_BUDDY_BIGIMAGE_STATUS", code);
                    this.f3026a.startActivityForResult(intent, 0);
                    break;
                case R.id.profile_special_contents /* 2131166475 */:
                    if (C3250y.f11735c) {
                        C3250y.m11453c("profile_special_chat, isTaskRoot: " + this.f3026a.f2288Y.isTaskRoot() + ", Task ID: " + this.f3026a.f2288Y.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    }
                    Intent intentM1171a = IntentControllerActivity.m1171a(CommonApplication.m11493l(), true);
                    intentM1171a.setFlags(67108864);
                    intentM1171a.putExtra("callChatList", true);
                    intentM1171a.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                    intentM1171a.putExtra("receivers", new String[]{this.f3026a.f2302g.m4000a()});
                    intentM1171a.putExtra("specialbuddy", true);
                    this.f3026a.startActivity(intentM1171a);
                    if (!GlobalApplication.m6456e()) {
                        this.f3026a.f2288Y.finish();
                        break;
                    }
                    break;
                case R.id.profile_recommend_special_buddy /* 2131166477 */:
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f3026a.f2306k);
                        jSONObject.put("name", this.f3026a.f2307l);
                        this.f3026a.startActivity(this.f3026a.m3866a(this.f3026a.f2288Y, EnumC1455w.LIVERECOMMEND, jSONObject.toString(), null));
                        break;
                    } catch (JSONException e) {
                        if (C3250y.f11737e) {
                            C3250y.m11443a(e, getClass().getSimpleName());
                            return;
                        }
                        return;
                    }
                case R.id.profile_unfollow_special_buddy /* 2131166478 */:
                    C3250y.m11453c("profile_ignore_special_buddy, isTaskRoot: " + this.f3026a.f2288Y.isTaskRoot() + ", Task ID: " + this.f3026a.f2288Y.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    if (this.f3026a.m3892d(true) && this.f3026a.f2311p) {
                        this.f3026a.m3906j();
                        this.f3026a.m3900g();
                        if (GlobalApplication.m6456e()) {
                            this.f3026a.f2295ae.setVisibility(8);
                            break;
                        }
                    }
                    break;
                case R.id.profile_add_special_buddy /* 2131166479 */:
                    C3250y.m11453c("profile_add_special_buddy, isTaskRoot: " + this.f3026a.f2288Y.isTaskRoot() + ", Task ID: " + this.f3026a.f2288Y.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
                    if (this.f3026a.m3892d(true)) {
                        this.f3026a.m3906j();
                        this.f3026a.m3896f();
                        break;
                    }
                    break;
                case R.id.list_special_header /* 2131166485 */:
                    Intent intent2 = new Intent(this.f3026a.f2288Y, (Class<?>) ChatActivity.class);
                    intent2.putExtra("liveprofile", true);
                    intent2.putExtra("liveprofile_id", this.f3026a.f2306k);
                    this.f3026a.startActivity(intent2);
                    break;
            }
        }
    }
}
