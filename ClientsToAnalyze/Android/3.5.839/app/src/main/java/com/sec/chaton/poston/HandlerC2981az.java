package com.sec.chaton.poston;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.GetPostONBlindList;
import com.sec.chaton.p065io.entry.inner.PostONBlind;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.settings.PostONHideFragment;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PostONHideListFragment.java */
/* renamed from: com.sec.chaton.poston.az */
/* loaded from: classes.dex */
class HandlerC2981az extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONHideListFragment f11077a;

    HandlerC2981az(PostONHideListFragment postONHideListFragment) {
        this.f11077a = postONHideListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 904:
                if (PostONHideListFragment.f10952i != null) {
                    PostONHideListFragment.f10952i.dismiss();
                }
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    ArrayList<PostONBlind> arrayList = ((GetPostONBlindList) c0778b.m3110e()).blind;
                    String[] strArr = new String[arrayList.size()];
                    Iterator<PostONBlind> it = arrayList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        PostONBlind next = it.next();
                        if (C2190d.m9846i(CommonApplication.m18732r().getContentResolver(), next.value)) {
                            strArr[i2] = next.value;
                            i = i2 + 1;
                        } else {
                            i = i2;
                        }
                        i2 = i;
                    }
                    C5179v.m19810a(this.f11077a.getActivity(), R.string.contact_unblocked_toast, 0).show();
                    Intent intent = new Intent(this.f11077a.getActivity(), (Class<?>) PostONHideFragment.class);
                    intent.putExtra("block_buddy_result", strArr);
                    this.f11077a.getActivity().setResult(-1, intent);
                    this.f11077a.getActivity().finish();
                    break;
                } else {
                    C5179v.m19810a(this.f11077a.getActivity(), R.string.dev_network_error, 0).show();
                    break;
                }
                break;
        }
    }
}
