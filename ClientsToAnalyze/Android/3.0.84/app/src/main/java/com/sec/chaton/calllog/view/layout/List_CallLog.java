package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.sec.chaton.R;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e;
import com.sec.chaton.calllog.common.view.swipe.SwipeUILayout;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import com.sec.chaton.calllog.manager.p022b.C0841a;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class List_CallLog extends List_Common {

    /* renamed from: a */
    public Handler f3397a;

    /* renamed from: b */
    String f3398b;

    /* renamed from: c */
    String f3399c;

    /* renamed from: g */
    private final int f3400g;

    /* renamed from: h */
    private SwipeUILayout f3401h;

    /* renamed from: i */
    private List_TypeCallLog f3402i;

    /* renamed from: j */
    private final Context f3403j;

    /* renamed from: k */
    private final C0841a f3404k;

    public List_CallLog(Context context, Handler handler, InterfaceC0836e interfaceC0836e) {
        super(context, true, interfaceC0836e);
        this.f3404k = C0841a.m4451a();
        this.f3403j = context;
        this.f3397a = handler;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f3400g = point.x;
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4651a(Context context, Color color, AttributeSet attributeSet) {
        super.mo4651a(context, color, attributeSet);
        this.f3402i = new List_TypeCallLog(context);
        addView(this.f3402i);
        this.f3401h = new SwipeUILayout(context, attributeSet);
        addView(this.f3401h);
        this.f3401h.setVisibility(8);
        this.f3398b = context.getResources().getString(R.string.calllog_seperator_1);
        this.f3399c = context.getResources().getString(R.string.calllog_seperator_2);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    public void setView(CallLogData callLogData, boolean z, boolean z2, String str, HashMap<Set<String>, String> map, boolean z3) {
        mo4650a();
        if (callLogData instanceof SeperatorCallLog) {
            m4653a((SeperatorCallLog) callLogData, str);
            setEnabledSwipe(false);
        } else if (callLogData instanceof CallLogData) {
            setEnabledSwipe(true);
            m4652a(callLogData, m4644a(callLogData, z2), z, map, z3);
            m4645a(this.f3402i, 0);
            this.f3401h.m4412a();
        }
    }

    /* renamed from: a */
    private String m4644a(CallLogData callLogData, boolean z) {
        String strM4459a;
        String strM4459a2;
        if (z) {
            strM4459a = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "HH:mm");
            strM4459a2 = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "HH:mm");
        } else {
            strM4459a = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "a h:mm");
            strM4459a2 = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "h:mm a");
        }
        return m4648b() ? strM4459a : strM4459a2;
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4650a() {
        super.mo4650a();
        this.f3402i.setVisibility(8);
    }

    /* renamed from: a */
    protected void m4653a(SeperatorCallLog seperatorCallLog, String str) {
        if (seperatorCallLog.seperatorname.equals(this.f3398b) || seperatorCallLog.seperatorname.equals(this.f3399c)) {
            this.f3405d.setTitle(seperatorCallLog.seperatorname);
        } else {
            this.f3405d.setTitle(C0841a.m4451a().m4459a(seperatorCallLog.seperatorname.replaceAll("/", "") + "000000", str));
        }
        this.f3405d.setTag(seperatorCallLog.tagname);
        this.f3405d.setVisibility(0);
    }

    /* renamed from: a */
    protected void m4652a(CallLogData callLogData, String str, boolean z, HashMap<Set<String>, String> map, boolean z2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3402i.getLayoutParams();
        layoutParams.width = this.f3400g;
        this.f3402i.setLayoutParams(layoutParams);
        if (callLogData.groupcallkey == null) {
            String str2 = callLogData.userInfo.get(0).f3205a;
            this.f3402i.setName(this.f3404k.m4461b(callLogData));
            this.f3402i.setProfileImage(false, callLogData.userInfo.get(0).f3205a.toString());
            this.f3402i.setChecked(z2);
        } else {
            String strM4458a = this.f3404k.m4458a(callLogData, map, callLogData.userInfo);
            if (strM4458a == null || strM4458a.isEmpty()) {
                this.f3402i.setName(this.f3404k.m4461b(callLogData));
            } else {
                this.f3402i.setName(strM4458a + " (" + callLogData.userInfo.size() + ")");
            }
            this.f3402i.setChecked(z2);
            this.f3402i.setProfileImage(true, strM4458a);
        }
        this.f3402i.setMsg(C0841a.m4451a().m4457a(callLogData));
        this.f3402i.setDeleteMode(z);
        this.f3402i.setCallCount(callLogData.totalIDList.size());
        this.f3402i.setTime(str);
        this.f3402i.setCallType(callLogData);
        this.f3402i.setCallMethod(callLogData.callmethod);
        this.f3402i.setVisibility(0);
        m4649c(callLogData.callmethod);
    }

    /* renamed from: c */
    private void m4649c(int i) {
        switch (i) {
            case 6:
            case 8:
            case 10:
                this.f3401h.setVideoEventUI(true);
                break;
            case 7:
            case 9:
            case 11:
                this.f3401h.setVideoEventUI(false);
                break;
        }
    }

    /* renamed from: b */
    private boolean m4648b() {
        return "kor".equals(this.f3403j.getResources().getConfiguration().locale.getISO3Language());
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo4403a(int i) {
        this.f3401h.setVisibility(8);
        m4645a(this.f3402i, 0);
        super.mo4403a(i);
    }

    /* renamed from: a */
    private void m4645a(View view, int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = i;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private TranslateAnimation m4643a(float f, float f2, float f3, int i) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, f, 0, f2, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(500L);
        translateAnimation.setAnimationListener(new AnimationAnimationListenerC0872b(this, f3, i));
        return translateAnimation;
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common, com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo4404a(int i, int i2) {
        this.f3401h.setVisibility(0);
        m4645a(this.f3402i, i2);
        this.f3401h.m4414a(i2);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common, com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo4402a(float f) {
        this.f3401h.setVisibility(0);
        this.f3402i.startAnimation(m4643a(0.0f, (f - this.f3401h.m4415b()) - this.f3400g, f, 1));
        this.f3401h.m4413a(f);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common, com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: b */
    protected void mo4405b(float f) {
        this.f3401h.setVisibility(0);
        this.f3402i.startAnimation(m4643a(0.0f, (this.f3401h.m4415b() + this.f3400g) - f, f, 0));
        this.f3401h.m4416b(f);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common, com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: c */
    protected void mo4407c(float f) {
        m4645a(this.f3402i, 0);
        this.f3402i.startAnimation(m4643a(f, 0.0f, f, 2));
        this.f3401h.setVisibility(0);
        this.f3401h.m4417c(f);
    }
}
