package com.sec.chaton.updates;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: UpdatesFragment.java */
/* renamed from: com.sec.chaton.updates.j */
/* loaded from: classes.dex */
class C4703j implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ UpdatesFragment f17050a;

    C4703j(UpdatesFragment updatesFragment) {
        this.f17050a = updatesFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (C4708o.f17055a[((C4709p) this.f17050a.f16978l.get(i)).m17762a().ordinal()]) {
            case 1:
                ((C4709p) this.f17050a.f16978l.get(i)).m17775l();
                this.f17050a.f16981o = true;
                this.f17050a.m17725a(i);
                break;
            case 2:
                this.f17050a.f16986t = AbstractC4932a.m18733a(this.f17050a.getActivity()).mo18740a(this.f17050a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f17050a.getResources().getString(R.string.contents_not_available)).mo18755c(this.f17050a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC4704k(this)).mo18752b();
                break;
            case 3:
                this.f17050a.f16985s = ((C4709p) this.f17050a.f16978l.get(i)).m17765b(0);
                this.f17050a.f16986t = AbstractC4932a.m18733a(this.f17050a.getActivity()).mo18740a(this.f17050a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f17050a.getActivity().getString(R.string.toast_was_blocked, new Object[]{this.f17050a.f16985s})).mo18741a(this.f17050a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC4705l(this)).mo18752b();
                break;
        }
    }
}
