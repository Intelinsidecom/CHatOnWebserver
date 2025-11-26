package com.sec.chaton.buddy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.common.util.AbstractC5016a;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.dp */
/* loaded from: classes.dex */
class C1255dp extends AbstractC5016a<HashMap<String, String>, Button, Void> {

    /* renamed from: a */
    HashMap<String, String> f4757a;

    /* renamed from: b */
    LinearLayout f4758b;

    /* renamed from: c */
    CheckBox f4759c;

    /* renamed from: d */
    final /* synthetic */ BuddyFragment f4760d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1255dp(BuddyFragment buddyFragment, View view, ExecutorService executorService) {
        super(executorService);
        this.f4760d = buddyFragment;
        if (view != null && (view instanceof CheckBox)) {
            this.f4759c = (CheckBox) view;
        }
    }

    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a */
    protected void mo6107a() {
        if (this.f4759c != null) {
            this.f4759c.setEnabled(false);
        }
        super.mo6107a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Void mo6106a(HashMap<String, String>... mapArr) {
        if (mapArr[0] != null) {
            this.f4757a = mapArr[0];
        }
        if (this.f4757a != null && this.f4757a.size() > 0) {
            this.f4758b = (LinearLayout) this.f4760d.f3622aC.getChildAt(0);
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f4760d.getActivity());
            this.f4760d.f3622aC.post(new RunnableC1256dq(this));
            System.currentTimeMillis();
            for (String str : this.f4757a.keySet()) {
                String str2 = this.f4757a.get(str);
                if (str != null && str2 != null) {
                    if (this.f4758b != null && this.f4758b.findViewWithTag(str) == null) {
                        Button button = (Button) layoutInflaterFrom.inflate(R.layout.choice_panel_button, (ViewGroup) this.f4758b, false);
                        button.setOnClickListener(this.f4760d.f3744ch);
                        button.setSingleLine(true);
                        button.setText(str2);
                        button.setTag(str);
                        m19060e(button);
                    }
                } else {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo7398b(Button button) {
        if (this.f4760d.f3622aC.getVisibility() == 8) {
            this.f4760d.f3622aC.setVisibility(0);
            this.f4760d.f3602I.invalidate();
        }
        this.f4758b.addView(button);
        this.f4758b.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo6108a(Void r3) {
        super.mo6108a((C1255dp) r3);
        if (this.f4759c != null) {
            this.f4759c.setEnabled(true);
        }
    }
}
