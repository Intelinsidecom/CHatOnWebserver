package com.sec.chaton.calllog.view.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.sec.chaton.R;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e;
import com.sec.chaton.calllog.common.view.swipe.SwipeUILayout;
import com.sec.chaton.calllog.manager.model.C1456d;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import com.sec.chaton.calllog.manager.p053b.C1452a;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class List_CallLog extends List_Common {

    /* renamed from: a */
    public Handler f5370a;

    /* renamed from: b */
    String f5371b;

    /* renamed from: c */
    String f5372c;

    /* renamed from: g */
    private final int f5373g;

    /* renamed from: h */
    private SwipeUILayout f5374h;

    /* renamed from: i */
    private List_TypeCallLog f5375i;

    /* renamed from: j */
    private final Context f5376j;

    /* renamed from: k */
    private final C1452a f5377k;

    public List_CallLog(Context context, Handler handler, InterfaceC1447e interfaceC1447e) {
        super(context, true, interfaceC1447e);
        this.f5377k = C1452a.m7605a();
        this.f5376j = context;
        this.f5370a = handler;
        this.f5373g = m7799a(context);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private int m7799a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (Build.VERSION.SDK_INT < 13) {
            return defaultDisplay.getWidth();
        }
        return point.x;
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo7806a(Context context, Color color, AttributeSet attributeSet) {
        super.mo7806a(context, color, attributeSet);
        this.f5375i = new List_TypeCallLog(context);
        addView(this.f5375i);
        this.f5374h = new SwipeUILayout(context, attributeSet);
        addView(this.f5374h);
        this.f5374h.setVisibility(8);
        this.f5371b = context.getResources().getString(R.string.calllog_seperator_1);
        this.f5372c = context.getResources().getString(R.string.calllog_seperator_2);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    public void setView(CallLogData callLogData, boolean z, boolean z2, String str, HashMap<Set<String>, String> map, boolean z3) {
        mo7805a();
        if (callLogData instanceof SeperatorCallLog) {
            m7808a((SeperatorCallLog) callLogData, str);
            setEnabledSwipe(false);
        } else {
            setEnabledSwipe(true);
            m7807a(callLogData, C1452a.m7606a(callLogData, z2), z, map, z3);
            m7801a(this.f5375i, 0);
            this.f5374h.m7566a();
        }
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo7805a() {
        super.mo7805a();
        this.f5375i.setVisibility(8);
    }

    /* renamed from: a */
    protected void m7808a(SeperatorCallLog seperatorCallLog, String str) {
        if (seperatorCallLog.seperatorname.equals(this.f5371b) || seperatorCallLog.seperatorname.equals(this.f5372c)) {
            this.f5378d.setTitle(seperatorCallLog.seperatorname);
        } else {
            this.f5378d.setTitle(C1452a.m7605a().m7614a(seperatorCallLog.seperatorname, C1456d.m7633f()));
        }
        this.f5378d.setTag(seperatorCallLog.tagname);
        this.f5378d.setVisibility(0);
    }

    /* renamed from: a */
    protected void m7807a(CallLogData callLogData, String str, boolean z, HashMap<Set<String>, String> map, boolean z2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5375i.getLayoutParams();
        layoutParams.width = this.f5373g;
        this.f5375i.setLayoutParams(layoutParams);
        if (callLogData.groupcallkey == null) {
            String str2 = callLogData.userInfo.get(0).f5175a;
            this.f5375i.setName(this.f5377k.m7616b(callLogData));
            this.f5375i.setProfileImage(false, callLogData.userInfo.get(0).f5175a.toString());
            this.f5375i.setChecked(z2);
        } else {
            String strM7613a = this.f5377k.m7613a(callLogData, map, callLogData.userInfo);
            if (strM7613a == null || TextUtils.isEmpty(strM7613a)) {
                this.f5375i.setName(this.f5377k.m7616b(callLogData));
            } else {
                this.f5375i.setName(strM7613a + " (" + callLogData.userInfo.size() + ")");
            }
            this.f5375i.setChecked(z2);
            this.f5375i.setProfileImage(true, strM7613a);
        }
        this.f5375i.setMsg(C1452a.m7605a().m7612a(callLogData));
        this.f5375i.setDeleteMode(z);
        this.f5375i.setCallCount(callLogData.totalIDList.size());
        this.f5375i.setTime(str);
        this.f5375i.setCallType(callLogData);
        this.f5375i.setCallMethod(callLogData.callmethod);
        this.f5375i.setVisibility(0);
        m7804c(callLogData.callmethod);
    }

    /* renamed from: c */
    private void m7804c(int i) {
        switch (i) {
            case 6:
            case 8:
            case 10:
                this.f5374h.setVideoEventUI(true);
                break;
            case 7:
            case 9:
            case 11:
                this.f5374h.setVideoEventUI(false);
                break;
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo7557a(int i) {
        this.f5374h.setVisibility(8);
        m7801a(this.f5375i, 0);
        super.mo7557a(i);
    }

    /* renamed from: a */
    private void m7801a(View view, int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = i;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private TranslateAnimation m7800a(float f, float f2, float f3, int i) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, f, 0, f2, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(500L);
        translateAnimation.setAnimationListener(new AnimationAnimationListenerC1483b(this, f3, i));
        return translateAnimation;
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common, com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo7558a(int i, int i2) {
        this.f5374h.setVisibility(0);
        m7801a(this.f5375i, i2);
        this.f5374h.m7568a(i2);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common, com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo7556a(float f) {
        this.f5374h.setVisibility(0);
        this.f5375i.startAnimation(m7800a(0.0f, (f - this.f5374h.m7569b()) - this.f5373g, f, 1));
        this.f5374h.m7567a(f);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common, com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: b */
    protected void mo7559b(float f) {
        this.f5374h.setVisibility(0);
        this.f5375i.startAnimation(m7800a(0.0f, (this.f5374h.m7569b() + this.f5373g) - f, f, 0));
        this.f5374h.m7570b(f);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common, com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: c */
    protected void mo7561c(float f) {
        m7801a(this.f5375i, 0);
        this.f5375i.startAnimation(m7800a(f, 0.0f, f, 2));
        this.f5374h.setVisibility(0);
        this.f5374h.m7571c(f);
    }
}
