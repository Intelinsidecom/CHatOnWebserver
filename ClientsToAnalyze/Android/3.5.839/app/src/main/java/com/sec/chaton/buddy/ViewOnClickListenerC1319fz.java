package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.poston.PostONWriteActivity;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fz */
/* loaded from: classes.dex */
class ViewOnClickListenerC1319fz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4855a;

    ViewOnClickListenerC1319fz(BuddyProfileFragment buddyProfileFragment) {
        this.f4855a = buddyProfileFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            switch (view.getId()) {
                case R.id.mypage_main_profile_image_represent /* 2131166004 */:
                case R.id.mypage_profile_more /* 2131166017 */:
                    C4904y.m18639b("mBuddyInfo.getProfileStatus() : " + this.f4855a.f4012s.m7071t(), BuddyProfileFragment.f3906a);
                    Intent intent = new Intent(this.f4855a.f3954aU, (Class<?>) BuddyProfileImageView.class);
                    intent.putExtra("PROFILE_BUDDY_NO", this.f4855a.f4013t);
                    intent.putExtra("PROFILE_BUDDY_IMAGE_ID", this.f4855a.f3921N.m7485b());
                    intent.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "FULL");
                    this.f4855a.startActivity(intent);
                    break;
                case R.id.mypage_main_profile_image_sub1 /* 2131166011 */:
                    String strM7485b = this.f4855a.f3922O.m7485b();
                    C4904y.m18639b("profileImageId : " + strM7485b, BuddyProfileFragment.f3906a);
                    Intent intent2 = new Intent(this.f4855a.f3954aU, (Class<?>) BuddyProfileImageView.class);
                    intent2.putExtra("PROFILE_BUDDY_NO", this.f4855a.f4013t);
                    intent2.putExtra("PROFILE_BUDDY_IMAGE_ID", strM7485b);
                    intent2.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                    this.f4855a.startActivity(intent2);
                    break;
                case R.id.mypage_main_profile_image_sub2 /* 2131166013 */:
                    String strM7485b2 = this.f4855a.f3923P.m7485b();
                    C4904y.m18639b("profileImageId : " + strM7485b2, BuddyProfileFragment.f3906a);
                    Intent intent3 = new Intent(this.f4855a.f3954aU, (Class<?>) BuddyProfileImageView.class);
                    intent3.putExtra("PROFILE_BUDDY_NO", this.f4855a.f4013t);
                    intent3.putExtra("PROFILE_BUDDY_IMAGE_ID", strM7485b2);
                    intent3.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                    this.f4855a.startActivity(intent3);
                    break;
                case R.id.mypage_main_profile_image_sub3 /* 2131166015 */:
                    String strM7485b3 = this.f4855a.f3924Q.m7485b();
                    C4904y.m18639b("profileImageId : " + strM7485b3, BuddyProfileFragment.f3906a);
                    Intent intent4 = new Intent(this.f4855a.f3954aU, (Class<?>) BuddyProfileImageView.class);
                    intent4.putExtra("PROFILE_BUDDY_NO", this.f4855a.f4013t);
                    intent4.putExtra("PROFILE_BUDDY_IMAGE_ID", strM7485b3);
                    intent4.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                    this.f4855a.startActivity(intent4);
                    break;
                case R.id.btn_mypage_info /* 2131166019 */:
                    Intent intent5 = new Intent(this.f4855a.f3954aU, (Class<?>) BuddyInfoActivity.class);
                    intent5.putExtra("PROFILE_BUDDY_NO", this.f4855a.f4013t);
                    intent5.putExtra("PROFILE_BUDDY_NAME", this.f4855a.f4014u);
                    this.f4855a.startActivityForResult(intent5, 7);
                    break;
                case R.id.mypage_poston_write_frame /* 2131166029 */:
                    Intent intent6 = new Intent(this.f4855a.f3954aU, (Class<?>) PostONWriteActivity.class);
                    intent6.putExtra("CHATON_ID", this.f4855a.f4013t);
                    intent6.putExtra("WRITE_FROM", "BUDDY_PAGE");
                    this.f4855a.startActivityForResult(intent6, 9);
                    break;
            }
        }
    }
}
