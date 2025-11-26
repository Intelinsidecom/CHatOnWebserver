package com.sec.chaton.multimedia.text;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class DetailTextView extends BaseActivity {

    /* renamed from: d */
    private static final String f7289d = DetailTextView.class.getSimpleName();

    /* renamed from: a */
    private String f7290a;

    /* renamed from: b */
    private String f7291b;

    /* renamed from: c */
    private Context f7292c;

    /* renamed from: e */
    private long f7293e;

    /* renamed from: f */
    private TextView f7294f;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.layout_original_textview);
        this.f7292c = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7290a = extras.getString("fulltext");
            if (C1075eq.m5326c(this.f7290a)) {
                this.f7290a = this.f7290a.substring(1);
            }
            this.f7291b = extras.getString("View All");
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("mText: " + this.f7290a + ", mMessageId: " + this.f7293e, f7289d);
        }
        setTitle(this.f7291b);
        String strM10979a = C3159aa.m10962a().m10979a("Default Font Size", "");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.bubble_marginTop);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.bubble_re_marginTop);
        CharSequence charSequenceM7508a = C1835j.m7508a(this, this.f7290a, (int) C3172an.m11085a(30.0f));
        this.f7294f = (TextView) findViewById(R.id.original_text);
        this.f7294f.setTextSize(0, m7782a(strM10979a, dimensionPixelSize, dimensionPixelSize2));
        this.f7294f.setText(charSequenceM7508a);
        m7783a();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C3250y.f11734b) {
            C3250y.m11450b("onUserLeaveHint", "DetailTextView");
        }
        m7783a();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onUserLeaveHint() {
        if (C3250y.f11734b) {
            C3250y.m11450b("onUserLeaveHint", "DetailTextView");
        }
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: a */
    private void m7783a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", "DetailTextView");
        }
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: a */
    private float m7782a(String str, int i, int i2) throws Resources.NotFoundException {
        float fM11053b = C3171am.m11053b(this.f7292c);
        if (!"sizeSystem".equals(str)) {
            if ("size50".equals(str)) {
                return this.f7292c.getResources().getDimension(R.dimen.font_size_tiny);
            }
            if ("size70".equals(str)) {
                return this.f7292c.getResources().getDimension(R.dimen.font_size_small);
            }
            if ("size100".equals(str)) {
                return this.f7292c.getResources().getDimension(R.dimen.font_size_normal);
            }
            if ("size150".equals(str)) {
                return this.f7292c.getResources().getDimension(R.dimen.font_size_large);
            }
            if ("size200".equals(str)) {
                return this.f7292c.getResources().getDimension(R.dimen.font_size_huge);
            }
            return this.f7292c.getResources().getDimension(R.dimen.font_size_normal);
        }
        return fM11053b;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
