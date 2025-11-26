package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.io.File;

/* compiled from: SetCoverstoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.cd */
/* loaded from: classes.dex */
class HandlerC3132cd extends Handler {

    /* renamed from: a */
    final /* synthetic */ SetCoverstoryFragment f11364a;

    HandlerC3132cd(SetCoverstoryFragment setCoverstoryFragment) {
        this.f11364a = setCoverstoryFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f11364a.getActivity() != null) {
            switch (message.what) {
                case 3002:
                    if (this.f11364a.f11280m != null && this.f11364a.f11280m.isShowing()) {
                        this.f11364a.f11280m.dismiss();
                    }
                    C0267d c0267d = (C0267d) message.obj;
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        CoverStoryAdd coverStoryAdd = (CoverStoryAdd) c0267d.m1354e();
                        String str = this.f11364a.f11275h + this.f11364a.f11277j;
                        String str2 = this.f11364a.getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/mycoverstory.jpg";
                        C3250y.m11450b(" Kmission samplePath : " + str, SetCoverstoryFragment.f11267b);
                        C3250y.m11450b(" Kmission myCoverStoryPath : " + str2, SetCoverstoryFragment.f11267b);
                        File file = new File(str);
                        File file2 = new File(str2);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        C3020a.m10525a(file, file2);
                        C3159aa.m10966a("mypage_coverstory_state", "coverstory_sample_changed");
                        C3159aa.m10966a("coverstory_metaid", coverStoryAdd.metaid);
                        C3159aa.m10966a("coverstory_contentid", this.f11364a.f11278k);
                        C3159aa.m10966a("coverstory_file_name", "mycoverstory.jpg");
                    } else {
                        C3250y.m11450b(" METHOD_ADD_COVERSTORY fail : ", SetCoverstoryFragment.f11267b);
                    }
                    ((InterfaceC3133ce) this.f11364a.getActivity()).mo10874d();
                    break;
            }
        }
    }
}
