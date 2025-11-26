package com.sec.chaton.userprofile;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p017a.C0363a;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.e */
/* loaded from: classes.dex */
class C1255e implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4352a;

    C1255e(MyPageFragment myPageFragment) {
        this.f4352a = myPageFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f4352a.f4104B != null && this.f4352a.f4104B.size() > 0) {
            String strM2308a = ((C0363a) this.f4352a.f4104B.get(i)).m2308a();
            if (!TextUtils.isEmpty(strM2308a)) {
                view.playSoundEffect(0);
                this.f4352a.f4113K = true;
                Intent intent = new Intent(this.f4352a.getActivity(), (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", strM2308a);
                this.f4352a.startActivity(intent);
            }
        }
    }
}
