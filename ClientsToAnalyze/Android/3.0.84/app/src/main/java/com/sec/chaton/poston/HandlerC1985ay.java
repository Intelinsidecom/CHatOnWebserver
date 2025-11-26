package com.sec.chaton.poston;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p035io.entry.GetPostONBlindList;
import com.sec.chaton.p035io.entry.inner.PostONBlind;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.PostONHideFragment;
import com.sec.chaton.settings2.PrefFragmentPostONHide;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PostONHideListFragment.java */
/* renamed from: com.sec.chaton.poston.ay */
/* loaded from: classes.dex */
class HandlerC1985ay extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONHideListFragment f7681a;

    HandlerC1985ay(PostONHideListFragment postONHideListFragment) {
        this.f7681a = postONHideListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2 = 0;
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 904:
                if (PostONHideListFragment.f7561a != null) {
                    PostONHideListFragment.f7561a.dismiss();
                }
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    ArrayList<PostONBlind> arrayList = ((GetPostONBlindList) c0267d.m1354e()).blind;
                    String[] strArr = new String[arrayList.size()];
                    Iterator<PostONBlind> it = arrayList.iterator();
                    while (it.hasNext()) {
                        PostONBlind next = it.next();
                        if (C1360d.m6054h(CommonApplication.m11493l().getContentResolver(), next.value)) {
                            strArr[i2] = next.value;
                            i = i2 + 1;
                        } else {
                            i = i2;
                        }
                        i2 = i;
                    }
                    Intent intent = new Intent(this.f7681a.getActivity(), (Class<?>) PostONHideFragment.class);
                    intent.putExtra(PrefFragmentPostONHide.BLOCK_BUDDY_RESULT, strArr);
                    this.f7681a.getActivity().setResult(-1, intent);
                    this.f7681a.getActivity().finish();
                    break;
                } else {
                    C3641ai.m13210a(this.f7681a.getActivity(), R.string.dev_network_error, 0).show();
                    break;
                }
                break;
        }
    }
}
