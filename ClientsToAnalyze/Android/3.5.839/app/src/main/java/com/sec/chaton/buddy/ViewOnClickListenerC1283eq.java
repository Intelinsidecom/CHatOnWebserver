package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.eq */
/* loaded from: classes.dex */
class ViewOnClickListenerC1283eq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4816a;

    ViewOnClickListenerC1283eq(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f4816a = buddyGroupProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        switch (view.getId()) {
            case R.id.profile_image /* 2131165297 */:
                C4904y.m18639b("Clicked the groupProfileImage: " + this.f4816a.f3812i.m7034a(), BuddyGroupProfileFragment.f3785a);
                C4904y.m18639b("Clicked the groupProfileImage: " + this.f4816a.f3812i.m7036b(), BuddyGroupProfileFragment.f3785a);
                String strM7036b = this.f4816a.f3812i.m7036b();
                try {
                    strM7036b = URLEncoder.encode(strM7036b, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, getClass().getSimpleName());
                    }
                }
                File file = new File(this.f4816a.f3799N, strM7036b + "_group_profile.png_");
                C4904y.m18639b("photoFile=" + file, getClass().getSimpleName());
                if (!file.exists()) {
                    this.f4816a.m6659a();
                    break;
                } else {
                    Intent intent = new Intent(this.f4816a.f3801P, (Class<?>) GroupProfileImageViewActivity.class);
                    intent.putExtra("GROUP_PROFILE_ID", this.f4816a.f3812i.m7034a());
                    intent.putExtra("GROUP_PROFILE_NAME", this.f4816a.f3812i.m7036b());
                    this.f4816a.startActivity(intent);
                    break;
                }
            case R.id.buddy_group_profile_edit_groupname /* 2131165299 */:
                Intent intent2 = new Intent(this.f4816a.f3801P, (Class<?>) BuddyEditNickNameActivity.class);
                intent2.putExtra("PROFILE_ID", String.valueOf(this.f4816a.f3812i.m7034a()));
                intent2.putExtra("PROFILE_NAME", this.f4816a.f3812i.m7036b());
                intent2.putExtra("PROFILE_BUDDY_MODE", false);
                intent2.putExtra("PROFILE_BUDDY_LIST", this.f4816a.m6633d().m6606i());
                this.f4816a.startActivityForResult(intent2, 6);
                break;
            case R.id.group_profile_start_chat /* 2131165301 */:
                if (this.f4816a.f3805b > 0) {
                    C4904y.m18639b("mGroupInfo.getId(): " + this.f4816a.f3812i.m7034a(), BuddyGroupProfileFragment.f3785a);
                    Intent intent3 = new Intent(this.f4816a.f3801P, (Class<?>) ChatActivity.class);
                    intent3.setFlags(67108864);
                    intent3.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
                    intent3.putExtra("receivers", this.f4816a.m6633d().m6606i());
                    intent3.putExtra("groupId", String.valueOf(this.f4816a.f3812i.m7034a()));
                    this.f4816a.startActivity(intent3);
                    this.f4816a.f3801P.finish();
                    break;
                }
                break;
            case R.id.group_profile_broadcast /* 2131165302 */:
                if (this.f4816a.f3805b > 0) {
                    C4904y.m18639b("mGroupInfo.getId(): " + this.f4816a.f3812i.m7034a(), BuddyGroupProfileFragment.f3785a);
                    Intent intent4 = new Intent(this.f4816a.f3801P, (Class<?>) ChatActivity.class);
                    intent4.setFlags(67108864);
                    if (C2349a.m10301a("broadcast2_feature")) {
                        intent4.putExtra("chatType", EnumC2300t.BROADCAST2.m10210a());
                    } else {
                        intent4.putExtra("chatType", EnumC2300t.BROADCAST.m10210a());
                    }
                    intent4.putExtra("receivers", this.f4816a.m6633d().m6606i());
                    intent4.putExtra("groupId", String.valueOf(this.f4816a.f3812i.m7034a()));
                    this.f4816a.startActivity(intent4);
                    this.f4816a.f3801P.finish();
                    break;
                }
                break;
            case R.id.group_profile_call /* 2131165303 */:
                if (C2923b.m12153h(GlobalApplication.m18732r())) {
                    if (this.f4816a.m6646j()) {
                        if (this.f4816a.m6638f()) {
                            try {
                                if (this.f4816a.f3797L.length <= 1) {
                                    this.f4816a.f3800O.m1487a(this.f4816a.f3819p, false, this.f4816a.f3797L[0], C4809aa.m18104a().m18121a("Push Name", ""), null);
                                } else if (this.f4816a.f3797L.length <= this.f4816a.f3800O.m1493b(this.f4816a.f3819p, false) - 1) {
                                    this.f4816a.f3800O.m1488a(this.f4816a.f3819p, false, this.f4816a.f3797L, C4809aa.m18104a().m18121a("Push Name", ""), null, this.f4816a.f3812i.m7036b());
                                } else {
                                    C5179v.m19811a(this.f4816a.f3819p, this.f4816a.getResources().getString(R.string.chaton_buddies_voice_group_limit, Integer.valueOf(this.f4816a.f3800O.m1493b(this.f4816a.f3819p, false) - 1)), 0).show();
                                }
                                break;
                            } catch (Exception e2) {
                                C4904y.m18635a(e2, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f4816a.startActivity(new Intent(this.f4816a.f3819p, (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else if (!this.f4816a.m6648k()) {
                        this.f4816a.startActivity(new Intent(this.f4816a.f3819p, (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                }
                break;
            case R.id.group_profile_videocall /* 2131165304 */:
                if (C2923b.m12153h(GlobalApplication.m18732r())) {
                    if (this.f4816a.m6646j()) {
                        if (this.f4816a.m6638f()) {
                            try {
                                if (this.f4816a.f3797L.length <= 1) {
                                    this.f4816a.f3800O.m1487a(this.f4816a.f3819p, true, this.f4816a.f3797L[0], C4809aa.m18104a().m18121a("Push Name", ""), null);
                                } else if (this.f4816a.f3797L.length <= this.f4816a.f3800O.m1493b(this.f4816a.f3819p, true) - 1) {
                                    this.f4816a.f3800O.m1488a(this.f4816a.f3819p, true, this.f4816a.f3797L, C4809aa.m18104a().m18121a("Push Name", ""), null, this.f4816a.f3812i.m7036b());
                                } else {
                                    C5179v.m19811a(this.f4816a.f3819p, this.f4816a.getResources().getString(R.string.chaton_buddies_video_group_limit, Integer.valueOf(this.f4816a.f3800O.m1493b(this.f4816a.f3819p, true) - 1)), 0).show();
                                }
                                break;
                            } catch (Exception e3) {
                                C4904y.m18635a(e3, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            this.f4816a.startActivity(new Intent(this.f4816a.f3819p, (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else if (!this.f4816a.m6648k()) {
                        this.f4816a.startActivity(new Intent(this.f4816a.f3819p, (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                }
                break;
            case R.id.group_profile_edit_group /* 2131165306 */:
                Intent intent5 = new Intent(this.f4816a.f3801P, (Class<?>) BuddyGroupMemberEditActivity.class);
                intent5.putExtra("ACTIVITY_PURPOSE", 19);
                intent5.putExtra("groupInfo", this.f4816a.f3812i);
                intent5.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", this.f4816a.f3797L);
                this.f4816a.startActivity(intent5);
                break;
        }
    }
}
