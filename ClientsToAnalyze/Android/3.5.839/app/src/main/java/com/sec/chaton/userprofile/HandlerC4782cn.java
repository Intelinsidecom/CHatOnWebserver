package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.io.File;

/* compiled from: SetCoverstoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.cn */
/* loaded from: classes.dex */
class HandlerC4782cn extends Handler {

    /* renamed from: a */
    final /* synthetic */ SetCoverstoryFragment f17499a;

    HandlerC4782cn(SetCoverstoryFragment setCoverstoryFragment) {
        this.f17499a = setCoverstoryFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f17499a.getActivity() != null) {
            switch (message.what) {
                case 3002:
                    if (this.f17499a.f17372m != null && this.f17499a.f17372m.isShowing()) {
                        this.f17499a.f17372m.dismiss();
                    }
                    C0778b c0778b = (C0778b) message.obj;
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryAdd coverStoryAdd = (CoverStoryAdd) c0778b.m3110e();
                        String str = this.f17499a.f17367h + this.f17499a.f17369j;
                        String str2 = this.f17499a.getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/mycoverstory.jpg";
                        C4904y.m18639b("samplePath : " + str, SetCoverstoryFragment.f17359b);
                        C4904y.m18639b("myCoverStoryPath : " + str2, SetCoverstoryFragment.f17359b);
                        File file = new File(str);
                        File file2 = new File(str2);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        C4636a.m17602a(file, file2);
                        C4809aa.m18108a("mypage_coverstory_state", "coverstory_sample_changed");
                        C4809aa.m18108a("coverstory_metaid", coverStoryAdd.metaid);
                        C4809aa.m18108a("coverstory_contentid", this.f17499a.f17370k);
                        C4809aa.m18108a("coverstory_file_name", "mycoverstory.jpg");
                    } else {
                        C4904y.m18639b(" METHOD_ADD_COVERSTORY fail : ", SetCoverstoryFragment.f17359b);
                    }
                    ((InterfaceC4783co) this.f17499a.getActivity()).mo18030i();
                    break;
            }
        }
    }
}
