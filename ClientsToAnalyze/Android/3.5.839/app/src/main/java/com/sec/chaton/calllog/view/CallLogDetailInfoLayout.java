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
import com.sec.chaton.buddy.p050a.C1105b;
import com.sec.chaton.calllog.manager.HandlerC1449a;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.p053b.C1452a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatInfoMoreActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CallLogDetailInfoLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private final HandlerC1449a f5239a;

    /* renamed from: b */
    private final C1452a f5240b;

    /* renamed from: c */
    private CallLogDetailFragment f5241c;

    /* renamed from: d */
    private LinearLayout f5242d;

    /* renamed from: e */
    private LinearLayout f5243e;

    /* renamed from: f */
    private LinearLayout f5244f;

    /* renamed from: g */
    private Button f5245g;

    /* renamed from: h */
    private Button f5246h;

    /* renamed from: i */
    private Button f5247i;

    /* renamed from: j */
    private Button f5248j;

    /* renamed from: k */
    private Button f5249k;

    /* renamed from: l */
    private Button f5250l;

    /* renamed from: m */
    private CallLogData f5251m;

    /* renamed from: n */
    private int f5252n;

    /* renamed from: o */
    private ArrayList<String> f5253o;

    /* renamed from: a */
    private void m7706a(String str) {
        C4904y.m18634a(str, "[CallLogDetailInfoLayout]");
    }

    public CallLogDetailInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5239a = CallLogFragment.f5260f;
        this.f5240b = C1452a.m7605a();
        this.f5253o = new ArrayList<>();
        LayoutInflater.from(context).inflate(R.layout.calllog_detail_info, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        this.f5243e = (LinearLayout) findViewById(R.id.individual_buddy);
        this.f5242d = (LinearLayout) findViewById(R.id.not_buddy);
        this.f5244f = (LinearLayout) findViewById(R.id.group_buddy);
        this.f5245g = (Button) findViewById(R.id.btn_add_buddy);
        this.f5246h = (Button) findViewById(R.id.btn_unblock_buddy);
        this.f5247i = (Button) findViewById(R.id.btn_unhide_buddy);
        this.f5248j = (Button) findViewById(R.id.btn_add_group);
        this.f5249k = (Button) findViewById(R.id.buddy_profile_info);
        this.f5250l = (Button) findViewById(R.id.group_profile_info);
        this.f5245g.setOnClickListener(this);
        this.f5246h.setOnClickListener(this);
        this.f5247i.setOnClickListener(this);
        this.f5248j.setOnClickListener(this);
        this.f5249k.setOnClickListener(this);
        this.f5250l.setOnClickListener(this);
        super.onFinishInflate();
    }

    public void setParent(CallLogDetailFragment callLogDetailFragment, CallLogData callLogData) {
        this.f5241c = callLogDetailFragment;
        this.f5251m = callLogData;
    }

    /* renamed from: a */
    public void m7708a(int i) {
        m7706a("updateUIComponent()-------buddy type???" + i);
        this.f5252n = i;
        switch (i) {
            case 0:
                this.f5243e.setVisibility(0);
                this.f5242d.setVisibility(8);
                this.f5244f.setVisibility(8);
                break;
            case 1:
                this.f5243e.setVisibility(8);
                this.f5242d.setVisibility(0);
                this.f5244f.setVisibility(8);
                this.f5246h.setVisibility(8);
                this.f5247i.setVisibility(0);
                this.f5245g.setVisibility(8);
                break;
            case 2:
                this.f5243e.setVisibility(8);
                this.f5242d.setVisibility(0);
                this.f5244f.setVisibility(8);
                this.f5247i.setVisibility(8);
                this.f5245g.setVisibility(8);
                break;
            case 3:
            case 4:
                this.f5243e.setVisibility(8);
                this.f5242d.setVisibility(0);
                this.f5244f.setVisibility(8);
                this.f5246h.setVisibility(8);
                this.f5247i.setVisibility(8);
                this.f5245g.setVisibility(0);
                break;
            case 6:
                this.f5243e.setVisibility(8);
                this.f5242d.setVisibility(0);
                this.f5244f.setVisibility(8);
                this.f5246h.setVisibility(8);
                this.f5247i.setVisibility(8);
                this.f5245g.setVisibility(8);
                break;
            case 10:
                this.f5243e.setVisibility(8);
                this.f5242d.setVisibility(8);
                this.f5244f.setVisibility(0);
                this.f5248j.setVisibility(8);
                this.f5250l.setVisibility(0);
                break;
            case 11:
                this.f5243e.setVisibility(8);
                this.f5242d.setVisibility(8);
                this.f5244f.setVisibility(0);
                this.f5248j.setVisibility(0);
                this.f5250l.setVisibility(8);
                break;
        }
    }

    /* renamed from: a */
    public void m7707a() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m7706a("onClick()");
        if (view.getId() == this.f5245g.getId() || view.getId() == this.f5248j.getId()) {
            if (view.getId() == this.f5245g.getId()) {
                this.f5241c.m7704a();
                return;
            }
            new ArrayList();
            ArrayList<String> arrayListM7661a = CallLogDetailFragment.m7661a(this.f5251m);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f5251m.userInfo.size(); i++) {
                arrayList.add(this.f5251m.userInfo.get(i).f5176b);
            }
            Intent intent = new Intent(getContext(), (Class<?>) ChatInfoMoreActivity.class);
            intent.putExtra("ACTIVITY_PURPOSE", 6);
            intent.putExtra(ChatFragment.f5465d, (String[]) arrayListM7661a.toArray(new String[0]));
            intent.putExtra("member_name", (String[]) arrayList.toArray(new String[0]));
            intent.putExtra("ACTIVITY_PURPOSE_ARG", false);
            intent.putExtra("ACTIVITY_PURPOSE_CALLLOG_GROUP", true);
            this.f5241c.startActivityForResult(intent, 2);
            return;
        }
        if (view.getId() != this.f5246h.getId() && view.getId() != this.f5247i.getId()) {
            if (view.getId() == this.f5249k.getId()) {
                Intent intent2 = new Intent(getContext(), (Class<?>) BuddyProfileActivity.class);
                intent2.putExtra("PROFILE_BUDDY_NO", this.f5251m.userInfo.get(0).f5175a);
                intent2.putExtra("PROFILE_BUDDY_NAME", this.f5251m.userInfo.get(0).f5177c);
                getContext().startActivity(intent2);
                return;
            }
            if (view.getId() == this.f5250l.getId()) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < this.f5251m.userInfo.size(); i2++) {
                    arrayList2.add(this.f5251m.userInfo.get(i2).f5175a);
                }
                String strM7613a = this.f5240b.m7613a(this.f5251m, this.f5239a.m7580a(), this.f5251m.userInfo);
                C1105b c1105b = new C1105b(C2191e.m9867d(GlobalApplication.m18732r().getContentResolver(), strM7613a), strM7613a, arrayList2 == null ? 0 : arrayList2.size(), 2);
                Intent intent3 = new Intent(getContext(), (Class<?>) BuddyGroupProfileActivity.class);
                intent3.putExtra("ACTIVITY_PURPOSE", 18);
                intent3.putExtra("groupInfo", c1105b);
                intent3.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) arrayList2.toArray(new String[0]));
                intent3.putExtra("GROUP_PROFILE_NAME", strM7613a);
                getContext().startActivity(intent3);
            }
        }
    }

    public void setBtnTextUpdate() {
        this.f5245g.setText(R.string.buddy_add_contact);
        this.f5246h.setText(R.string.preference_buddies_btn_unblock);
        this.f5247i.setText(R.string.buddy_add_contact);
        this.f5248j.setText(R.string.menu_add_group);
    }
}
