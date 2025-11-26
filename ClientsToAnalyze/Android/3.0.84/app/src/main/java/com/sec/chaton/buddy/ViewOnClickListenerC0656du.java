package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.du */
/* loaded from: classes.dex */
class ViewOnClickListenerC0656du implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f2875a;

    ViewOnClickListenerC0656du(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f2875a = buddyGroupProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        switch (view.getId()) {
            case R.id.profile_image /* 2131165301 */:
                C3250y.m11458g("Clicked the groupProfileImage: " + this.f2875a.f1932g.m3960a(), BuddyGroupProfileFragment.f1908a);
                C3250y.m11458g("Clicked the groupProfileImage: " + this.f2875a.f1932g.m3962b(), BuddyGroupProfileFragment.f1908a);
                String strM3962b = this.f2875a.f1932g.m3962b();
                try {
                    strM3962b = URLEncoder.encode(strM3962b, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, getClass().getSimpleName());
                    }
                }
                File file = new File(this.f2875a.f1921M, strM3962b + "_group_profile.png_");
                C3250y.m11450b("photoFile=" + file, getClass().getSimpleName());
                if (!file.exists()) {
                    this.f2875a.m3504a();
                    break;
                } else {
                    Intent intent = new Intent(this.f2875a.f1923O, (Class<?>) GroupProfileImageViewActivity.class);
                    intent.putExtra("GROUP_PROFILE_ID", this.f2875a.f1932g.m3960a());
                    intent.putExtra("GROUP_PROFILE_NAME", this.f2875a.f1932g.m3962b());
                    this.f2875a.startActivity(intent);
                    break;
                }
            case R.id.buddy_group_profile_edit_groupname /* 2131165303 */:
                Intent intent2 = new Intent(this.f2875a.f1923O, (Class<?>) BuddyEditNickNameActivity.class);
                intent2.putExtra("PROFILE_ID", String.valueOf(this.f2875a.f1932g.m3960a()));
                intent2.putExtra("PROFILE_NAME", this.f2875a.f1932g.m3962b());
                intent2.putExtra("PROFILE_BUDDY_MODE", false);
                intent2.putExtra("PROFILE_BUDDY_LIST", this.f2875a.m3478d().m3445j());
                this.f2875a.startActivityForResult(intent2, 6);
                break;
            case R.id.group_profile_start_chat /* 2131165305 */:
                if (this.f2875a.f1927b > 0) {
                    C3250y.m11458g("mGroupInfo.getId(): " + this.f2875a.f1932g.m3960a(), BuddyGroupProfileFragment.f1908a);
                    if (GlobalApplication.m6456e()) {
                        Intent intent3 = new Intent(this.f2875a.f1923O, (Class<?>) TabActivity.class);
                        intent3.setFlags(67108864);
                        intent3.putExtra("callChatList", true);
                        intent3.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                        intent3.putExtra("receivers", this.f2875a.m3478d().m3445j());
                        intent3.putExtra("groupId", String.valueOf(this.f2875a.f1932g.m3960a()));
                        this.f2875a.startActivity(intent3);
                        break;
                    } else {
                        Intent intent4 = new Intent(this.f2875a.f1923O, (Class<?>) ChatActivity.class);
                        intent4.setFlags(67108864);
                        intent4.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                        intent4.putExtra("receivers", this.f2875a.m3478d().m3445j());
                        intent4.putExtra("groupId", String.valueOf(this.f2875a.f1932g.m3960a()));
                        this.f2875a.startActivity(intent4);
                        this.f2875a.f1923O.finish();
                        break;
                    }
                }
                break;
            case R.id.group_profile_broadcast /* 2131165306 */:
                if (this.f2875a.f1927b > 0) {
                    C3250y.m11458g("mGroupInfo.getId(): " + this.f2875a.f1932g.m3960a(), BuddyGroupProfileFragment.f1908a);
                    if (GlobalApplication.m6456e()) {
                        Intent intent5 = new Intent(this.f2875a.f1923O, (Class<?>) TabActivity.class);
                        intent5.setFlags(67108864);
                        intent5.putExtra("callChatList", true);
                        if (C1493a.m6463a("broadcast2_feature")) {
                            intent5.putExtra("chatType", EnumC1450r.BROADCAST2.m6342a());
                        } else {
                            intent5.putExtra("chatType", EnumC1450r.BROADCAST.m6342a());
                        }
                        intent5.putExtra("receivers", this.f2875a.m3478d().m3445j());
                        intent5.putExtra("groupId", String.valueOf(this.f2875a.f1932g.m3960a()));
                        this.f2875a.startActivity(intent5);
                        break;
                    } else {
                        Intent intent6 = new Intent(this.f2875a.f1923O, (Class<?>) ChatActivity.class);
                        intent6.setFlags(67108864);
                        if (C1493a.m6463a("broadcast2_feature")) {
                            intent6.putExtra("chatType", EnumC1450r.BROADCAST2.m6342a());
                        } else {
                            intent6.putExtra("chatType", EnumC1450r.BROADCAST.m6342a());
                        }
                        intent6.putExtra("receivers", this.f2875a.m3478d().m3445j());
                        intent6.putExtra("groupId", String.valueOf(this.f2875a.f1932g.m3960a()));
                        this.f2875a.startActivity(intent6);
                        this.f2875a.f1923O.finish();
                        break;
                    }
                }
                break;
            case R.id.group_profile_call /* 2131165307 */:
                if (C1948a.m7903a(GlobalApplication.m11493l())) {
                    if (this.f2875a.m3493k()) {
                        if (this.f2875a.m3483f()) {
                            try {
                                if (this.f2875a.f1919K.length <= 1) {
                                    this.f2875a.f1922N.m47a(this.f2875a.f1939n, false, this.f2875a.f1919K[0], C3159aa.m10962a().m10979a("Push Name", ""), null);
                                } else if (this.f2875a.f1919K.length <= this.f2875a.f1922N.m53b(this.f2875a.f1939n, false) - 1) {
                                    this.f2875a.f1922N.m48a(this.f2875a.f1939n, false, this.f2875a.f1919K, C3159aa.m10962a().m10979a("Push Name", ""), null, this.f2875a.f1932g.m3962b());
                                } else {
                                    C3641ai.m13211a(this.f2875a.f1939n, this.f2875a.getResources().getString(R.string.chaton_buddies_voice_group_limit, Integer.valueOf(this.f2875a.f1922N.m53b(this.f2875a.f1939n, false) - 1)), 0).show();
                                }
                                break;
                            } catch (Exception e2) {
                                C3250y.m11443a(e2, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f2875a.startActivity(new Intent(this.f2875a.f1939n, (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else if (!this.f2875a.m3495l()) {
                        this.f2875a.startActivity(new Intent(this.f2875a.f1939n, (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                }
                break;
            case R.id.group_profile_videocall /* 2131165308 */:
                if (C1948a.m7903a(GlobalApplication.m11493l())) {
                    if (this.f2875a.m3493k()) {
                        if (this.f2875a.m3483f()) {
                            try {
                                if (this.f2875a.f1919K.length <= 1) {
                                    this.f2875a.f1922N.m47a(this.f2875a.f1939n, true, this.f2875a.f1919K[0], C3159aa.m10962a().m10979a("Push Name", ""), null);
                                } else if (this.f2875a.f1919K.length <= this.f2875a.f1922N.m53b(this.f2875a.f1939n, true) - 1) {
                                    this.f2875a.f1922N.m48a(this.f2875a.f1939n, true, this.f2875a.f1919K, C3159aa.m10962a().m10979a("Push Name", ""), null, this.f2875a.f1932g.m3962b());
                                } else {
                                    C3641ai.m13211a(this.f2875a.f1939n, this.f2875a.getResources().getString(R.string.chaton_buddies_video_group_limit, Integer.valueOf(this.f2875a.f1922N.m53b(this.f2875a.f1939n, true) - 1)), 0).show();
                                }
                                break;
                            } catch (Exception e3) {
                                C3250y.m11443a(e3, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f2875a.startActivity(new Intent(this.f2875a.f1939n, (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else if (!this.f2875a.m3495l()) {
                        this.f2875a.startActivity(new Intent(this.f2875a.f1939n, (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                }
                break;
            case R.id.group_profile_edit_group /* 2131165310 */:
                Intent intent7 = new Intent(this.f2875a.f1923O, (Class<?>) BuddyGroupMemberEditActivity.class);
                intent7.putExtra("ACTIVITY_PURPOSE", 19);
                intent7.putExtra("groupInfo", this.f2875a.f1932g);
                intent7.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", this.f2875a.f1919K);
                this.f2875a.startActivity(intent7);
                break;
        }
    }
}
