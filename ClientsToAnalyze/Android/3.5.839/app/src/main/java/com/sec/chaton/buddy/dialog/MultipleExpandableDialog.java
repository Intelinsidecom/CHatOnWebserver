package com.sec.chaton.buddy.dialog;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.C1364hq;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class MultipleExpandableDialog extends BaseActivity {

    /* renamed from: A */
    private boolean f4626A = false;

    /* renamed from: n */
    InterfaceC2211y f4627n = new C1204ad(this);

    /* renamed from: o */
    View.OnClickListener f4628o = new ViewOnClickListenerC1205ae(this);

    /* renamed from: p */
    private List<String> f4629p;

    /* renamed from: q */
    private Map<String, List<String>> f4630q;

    /* renamed from: r */
    private ExpandableListView f4631r;

    /* renamed from: s */
    private TextView f4632s;

    /* renamed from: t */
    private C1364hq f4633t;

    /* renamed from: u */
    private HashMap<String, String> f4634u;

    /* renamed from: v */
    private HashMap<String, String> f4635v;

    /* renamed from: w */
    private C2210x f4636w;

    /* renamed from: x */
    private Context f4637x;

    /* renamed from: y */
    private Button f4638y;

    /* renamed from: z */
    private Button f4639z;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
        }
        setContentView(R.layout.multiple_expandable_list);
        this.f4637x = this;
        this.f4629p = new ArrayList();
        this.f4635v = new HashMap<>();
        this.f4632s = (TextView) findViewById(R.id.group_profile_popup_name);
        this.f4632s.setText(getResources().getString(R.string.buddy_selected));
        this.f4638y = (Button) findViewById(R.id.button2);
        this.f4639z = (Button) findViewById(R.id.button3);
        if (Build.VERSION.SDK_INT < 11) {
            this.f4638y.setText(getResources().getString(R.string.dialog_ok));
            this.f4639z.setText(getResources().getString(R.string.dialog_cancel));
        } else {
            this.f4638y.setText(getResources().getString(R.string.dialog_cancel));
            this.f4639z.setText(getResources().getString(R.string.dialog_ok));
        }
        this.f4638y.setOnClickListener(this.f4628o);
        this.f4639z.setOnClickListener(this.f4628o);
        String[] stringArray = getIntent().getExtras().getStringArray("activity_arg_buddyno_list");
        this.f4626A = getIntent().getExtras().getBoolean("activity_arg_from_sms");
        this.f4636w = new C2210x(getContentResolver(), this.f4627n);
        String str = "'" + stringArray[0] + "'";
        this.f4629p.add(stringArray[0]);
        String str2 = str;
        int i = 1;
        while (i < stringArray.length) {
            String str3 = str2 + ", '" + stringArray[i] + "'";
            this.f4629p.add(stringArray[i]);
            i++;
            str2 = str3;
        }
        this.f4636w.startQuery(1000, null, C2289i.f8196a, new String[]{"buddy_no", "buddy_name", "buddy_status_message", "buddy_contact_buddy", "buddy_phonenumber_external_use"}, "buddy_no IN ( " + str2 + " )", null, null);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Dialog;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_Dialog;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getWindow().getDecorView().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && motionEvent.getAction() == 0) {
            finish();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public Intent m7326f() {
        Intent intent = new Intent("com.sec.chaton.smsplugin.SEND");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f4633t.m7499a().keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.f4633t.m7499a().get(it.next()));
        }
        intent.setFlags(67108864);
        intent.putExtra("receiver_array", (String[]) arrayList.toArray(new String[0]));
        return intent;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.multi_selection_list_root);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (configuration.orientation == 2) {
            layoutParams.height = m7316a(200.0f);
        } else {
            layoutParams.height = this.f4637x.getResources().getDimensionPixelSize(R.dimen.buddy_popup_boddy_height);
        }
        frameLayout.requestLayout();
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private int m7316a(float f) {
        return (int) ((CommonApplication.m18732r().getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
