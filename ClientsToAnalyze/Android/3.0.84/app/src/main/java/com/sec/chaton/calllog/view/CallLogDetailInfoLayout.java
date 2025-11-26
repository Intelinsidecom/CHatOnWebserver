package com.sec.chaton.calllog.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyGroupProfileActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p019a.C0512b;
import com.sec.chaton.calllog.manager.HandlerC0838a;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.p022b.C0841a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatInfoMoreActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CallLogDetailInfoLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private final HandlerC0838a f3267a;

    /* renamed from: b */
    private final C0841a f3268b;

    /* renamed from: c */
    private CallLogDetailFragment f3269c;

    /* renamed from: d */
    private LinearLayout f3270d;

    /* renamed from: e */
    private LinearLayout f3271e;

    /* renamed from: f */
    private LinearLayout f3272f;

    /* renamed from: g */
    private Button f3273g;

    /* renamed from: h */
    private Button f3274h;

    /* renamed from: i */
    private Button f3275i;

    /* renamed from: j */
    private Button f3276j;

    /* renamed from: k */
    private Button f3277k;

    /* renamed from: l */
    private Button f3278l;

    /* renamed from: m */
    private CallLogData f3279m;

    /* renamed from: n */
    private int f3280n;

    /* renamed from: o */
    private ArrayList<String> f3281o;

    /* renamed from: a */
    private void m4551a(String str) {
        C3250y.m11442a(str, "[CallLogDetailInfoLayout]");
    }

    public CallLogDetailInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3267a = CallLogFragment.f3288f;
        this.f3268b = C0841a.m4451a();
        this.f3281o = new ArrayList<>();
        LayoutInflater.from(context).inflate(R.layout.calllog_detail_info, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        this.f3271e = (LinearLayout) findViewById(R.id.individual_buddy);
        this.f3270d = (LinearLayout) findViewById(R.id.not_buddy);
        this.f3272f = (LinearLayout) findViewById(R.id.group_buddy);
        this.f3273g = (Button) findViewById(R.id.btn_add_buddy);
        this.f3274h = (Button) findViewById(R.id.btn_unblock_buddy);
        this.f3275i = (Button) findViewById(R.id.btn_unhide_buddy);
        this.f3276j = (Button) findViewById(R.id.btn_add_group);
        this.f3277k = (Button) findViewById(R.id.buddy_profile_info);
        this.f3278l = (Button) findViewById(R.id.group_profile_info);
        this.f3273g.setOnClickListener(this);
        this.f3274h.setOnClickListener(this);
        this.f3275i.setOnClickListener(this);
        this.f3276j.setOnClickListener(this);
        this.f3277k.setOnClickListener(this);
        this.f3278l.setOnClickListener(this);
        super.onFinishInflate();
    }

    public void setParent(CallLogDetailFragment callLogDetailFragment, CallLogData callLogData) {
        this.f3269c = callLogDetailFragment;
        this.f3279m = callLogData;
    }

    /* renamed from: a */
    public void m4553a(int i) {
        m4551a("updateUIComponent()-------buddy type???" + i);
        this.f3280n = i;
        switch (i) {
            case 0:
                this.f3271e.setVisibility(0);
                this.f3270d.setVisibility(8);
                this.f3272f.setVisibility(8);
                break;
            case 1:
                this.f3271e.setVisibility(8);
                this.f3270d.setVisibility(0);
                this.f3272f.setVisibility(8);
                this.f3274h.setVisibility(8);
                this.f3275i.setVisibility(0);
                this.f3273g.setVisibility(8);
                break;
            case 2:
                this.f3271e.setVisibility(8);
                this.f3270d.setVisibility(0);
                this.f3272f.setVisibility(8);
                this.f3275i.setVisibility(8);
                this.f3273g.setVisibility(8);
                break;
            case 3:
            case 4:
                this.f3271e.setVisibility(8);
                this.f3270d.setVisibility(0);
                this.f3272f.setVisibility(8);
                this.f3274h.setVisibility(8);
                this.f3275i.setVisibility(8);
                this.f3273g.setVisibility(0);
                break;
            case 6:
                this.f3271e.setVisibility(8);
                this.f3270d.setVisibility(0);
                this.f3272f.setVisibility(8);
                this.f3274h.setVisibility(8);
                this.f3275i.setVisibility(8);
                this.f3273g.setVisibility(8);
                break;
            case 10:
                this.f3271e.setVisibility(8);
                this.f3270d.setVisibility(8);
                this.f3272f.setVisibility(0);
                this.f3276j.setVisibility(8);
                this.f3278l.setVisibility(0);
                break;
            case 11:
                this.f3271e.setVisibility(8);
                this.f3270d.setVisibility(8);
                this.f3272f.setVisibility(0);
                this.f3276j.setVisibility(0);
                this.f3278l.setVisibility(8);
                break;
        }
    }

    /* renamed from: a */
    public void m4552a() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m4551a("onClick()");
        if (view.getId() == this.f3273g.getId() || view.getId() == this.f3276j.getId()) {
            if (view.getId() == this.f3273g.getId()) {
                this.f3269c.m4549a();
                return;
            }
            new ArrayList();
            ArrayList<String> arrayListM4507a = CallLogDetailFragment.m4507a(this.f3279m);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f3279m.userInfo.size(); i++) {
                arrayList.add(this.f3279m.userInfo.get(i).f3206b);
            }
            Intent intent = new Intent(getContext(), (Class<?>) ChatInfoMoreActivity.class);
            intent.putExtra("ACTIVITY_PURPOSE", 6);
            intent.putExtra(ChatFragment.f3489f, (String[]) arrayListM4507a.toArray(new String[0]));
            intent.putExtra("member_name", (String[]) arrayList.toArray(new String[0]));
            intent.putExtra("ACTIVITY_PURPOSE_ARG", false);
            intent.putExtra("ACTIVITY_PURPOSE_CALLLOG_GROUP", true);
            getContext().startActivity(intent);
            return;
        }
        if (view.getId() != this.f3274h.getId() && view.getId() != this.f3275i.getId()) {
            if (view.getId() == this.f3277k.getId()) {
                Intent intent2 = new Intent(getContext(), (Class<?>) BuddyProfileActivity.class);
                intent2.putExtra("PROFILE_BUDDY_NO", this.f3279m.userInfo.get(0).f3205a);
                intent2.putExtra("PROFILE_BUDDY_NAME", this.f3279m.userInfo.get(0).f3207c);
                getContext().startActivity(intent2);
                return;
            }
            if (view.getId() == this.f3278l.getId()) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < this.f3279m.userInfo.size(); i2++) {
                    arrayList2.add(this.f3279m.userInfo.get(i2).f3205a);
                }
                String strM4458a = this.f3268b.m4458a(this.f3279m, this.f3267a.m4426a(), this.f3279m.userInfo);
                C0512b c0512b = new C0512b(C1362f.m6072d(GlobalApplication.m11493l().getContentResolver(), strM4458a), strM4458a, arrayList2 == null ? 0 : arrayList2.size(), 2);
                Intent intent3 = new Intent(getContext(), (Class<?>) BuddyGroupProfileActivity.class);
                intent3.putExtra("ACTIVITY_PURPOSE", 18);
                intent3.putExtra("groupInfo", c0512b);
                intent3.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) arrayList2.toArray(new String[0]));
                intent3.putExtra("GROUP_PROFILE_NAME", strM4458a);
                getContext().startActivity(intent3);
            }
        }
    }

    public void setBtnTextUpdate() {
        this.f3273g.setText(R.string.call_menu_add_buddy);
        this.f3274h.setText(R.string.preference_buddies_btn_unblock);
        this.f3275i.setText(R.string.call_menu_add_buddy);
        this.f3276j.setText(R.string.menu_add_group);
    }
}
