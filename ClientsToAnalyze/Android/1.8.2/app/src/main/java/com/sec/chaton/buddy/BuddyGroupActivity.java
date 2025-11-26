package com.sec.chaton.buddy;

import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0680g;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;
import com.sec.widget.EditTextWithClearButton;

/* loaded from: classes.dex */
public class BuddyGroupActivity extends BaseActivity {

    /* renamed from: a */
    public static final String f1025a = BuddyGroupActivity.class.getSimpleName();

    /* renamed from: c */
    private EditTextWithClearButton f1027c;

    /* renamed from: d */
    private Button f1028d;

    /* renamed from: e */
    private TextView f1029e;

    /* renamed from: i */
    private Context f1030i;

    /* renamed from: b */
    InterfaceC0677d f1026b = new C0305bq(this);

    /* renamed from: j */
    private TextWatcher f1031j = new C0306br(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1786r.m6067f("onCreate()", f1025a);
        super.onCreate(bundle);
        setContentView(R.layout.buddy_group_layout);
        m2061a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        C1786r.m6067f("onStart()", f1025a);
        super.onStart();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        C1786r.m6067f("onResume()", f1025a);
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    /* renamed from: a */
    private void m2061a() {
        this.f1030i = this;
        this.f1029e = (TextView) findViewById(R.id.buddy_group_list_title);
        this.f1027c = (EditTextWithClearButton) findViewById(R.id.buddy_group_groupname_field);
        this.f1027c.addTextChangedListener(this.f1031j);
        this.f1027c.setOnEditorActionListener(new C0303bo(this));
        this.f1028d = (Button) findViewById(R.id.buddy_group_create_btn);
        this.f1028d.setOnClickListener(new ViewOnClickListenerC0304bp(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2063a(String str) {
        if (str.toUpperCase().equals(getResources().getString(R.string.buddy_list_group_birthday).toUpperCase()) || str.toUpperCase().equals(getResources().getString(R.string.buddy_list_group_favorites).toUpperCase()) || str.toUpperCase().equals(getResources().getString(R.string.buddy_list_group_favorites2).toUpperCase())) {
            C2153y.m7536a(this, getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0).show();
        } else {
            C0668l.m3077a(new C0668l(), 3, new C0680g(this.f1026b, str, 3));
        }
    }
}
