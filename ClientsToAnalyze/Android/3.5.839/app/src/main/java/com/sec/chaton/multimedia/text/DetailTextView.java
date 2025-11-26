package com.sec.chaton.multimedia.text;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;

/* loaded from: classes.dex */
public class DetailTextView extends BaseActivity {

    /* renamed from: q */
    private static final String f10610q = DetailTextView.class.getSimpleName();

    /* renamed from: n */
    private String f10611n;

    /* renamed from: o */
    private String f10612o;

    /* renamed from: p */
    private Context f10613p;

    /* renamed from: r */
    private long f10614r;

    /* renamed from: s */
    private TextView f10615s;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.layout_original_textview);
        this.f10613p = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f10611n = extras.getString("fulltext");
            if (C1736gi.m8652d(this.f10611n)) {
                this.f10611n = this.f10611n.substring(1);
            }
            this.f10612o = extras.getString("View All");
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("mText: " + this.f10611n + ", mMessageId: " + this.f10614r, f10610q);
        }
        setTitle(this.f10612o);
        String strM18121a = C4809aa.m18104a().m18121a("Default Font Size", "");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.bubble_marginTop);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.bubble_re_marginTop);
        CharSequence charSequenceM11709a = C2799k.m11709a(this, this.f10611n, (int) C5034k.m19088a(30.0f));
        this.f10615s = (TextView) findViewById(R.id.original_text);
        this.f10615s.setTextSize(0, m12012a(strM18121a, dimensionPixelSize, dimensionPixelSize2));
        this.f10615s.setText(charSequenceM11709a);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C4904y.f17872b) {
            C4904y.m18639b("onResume", "DetailTextView");
        }
    }

    /* renamed from: a */
    private float m12012a(String str, int i, int i2) throws Resources.NotFoundException {
        float fM18220b = C4822an.m18220b(this.f10613p);
        if (!"sizeSystem".equals(str)) {
            if ("size50".equals(str)) {
                return this.f10613p.getResources().getDimension(R.dimen.font_size_tiny);
            }
            if ("size70".equals(str)) {
                return this.f10613p.getResources().getDimension(R.dimen.font_size_small);
            }
            if ("size100".equals(str)) {
                return this.f10613p.getResources().getDimension(R.dimen.font_size_normal);
            }
            if ("size150".equals(str)) {
                return this.f10613p.getResources().getDimension(R.dimen.font_size_large);
            }
            if ("size200".equals(str)) {
                return this.f10613p.getResources().getDimension(R.dimen.font_size_huge);
            }
            return this.f10613p.getResources().getDimension(R.dimen.font_size_normal);
        }
        return fM18220b;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
