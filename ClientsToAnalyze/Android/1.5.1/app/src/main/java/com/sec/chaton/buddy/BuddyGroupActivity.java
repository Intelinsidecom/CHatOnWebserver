package com.sec.chaton.buddy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.database.task.BuddyGroupAddTask;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class BuddyGroupActivity extends BaseActivity {

    /* renamed from: a */
    public static final String f480a = BuddyGroupActivity.class.getSimpleName();

    /* renamed from: c */
    private EditText f482c;

    /* renamed from: d */
    private Button f483d;

    /* renamed from: e */
    private TextView f484e;

    /* renamed from: f */
    private Context f485f;

    /* renamed from: b */
    AbstractQueryTask.OnQueryTaskResult f481b = new C0098av(this);

    /* renamed from: g */
    private TextWatcher f486g = new C0097au(this);

    /* renamed from: a */
    private void m537a() {
        this.f485f = this;
        this.f484e = (TextView) findViewById(C0062R.id.buddy_group_list_title);
        this.f482c = (EditText) findViewById(C0062R.id.buddy_group_groupname_field);
        this.f482c.addTextChangedListener(this.f486g);
        this.f482c.setOnEditorActionListener(new C0095as(this));
        this.f483d = (Button) findViewById(C0062R.id.buddy_group_create_btn);
        this.f483d.setOnClickListener(new ViewOnClickListenerC0094ar(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m539a(String str) {
        NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 3, new BuddyGroupAddTask(this.f481b, str, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m541b() throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(C0062R.drawable.btn_del);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (this.f482c.getText().toString().length() > 0) {
            this.f482c.setCompoundDrawables(null, null, drawable, null);
            this.f482c.setOnTouchListener(new ViewOnTouchListenerC0096at(this, drawable));
        } else {
            this.f482c.setCompoundDrawables(null, null, null, null);
            this.f482c.setOnTouchListener(null);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        ChatONLogWriter.m3512f("onCreate()", f480a);
        super.onCreate(bundle);
        setContentView(C0062R.layout.buddy_group_layout);
        m537a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        ChatONLogWriter.m3512f("onResume()", f480a);
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        ChatONLogWriter.m3512f("onStart()", f480a);
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }
}
