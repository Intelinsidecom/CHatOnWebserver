package com.sec.common.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.sec.common.C3307b;
import com.sec.common.C3323e;
import com.sec.common.widget.HoneycombLinearLayout;

/* loaded from: classes.dex */
public class ActionBarMenuView extends HoneycombLinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private int f11892a;

    /* renamed from: b */
    private InterfaceC3298o f11893b;

    public ActionBarMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11892a = (int) (context.getResources().getDisplayMetrics().density * 4.0f);
    }

    public void setOnMenuItemClickListener(InterfaceC3298o interfaceC3298o) {
        this.f11893b = interfaceC3298o;
    }

    @Override // com.sec.common.widget.HoneycombLinearLayout
    /* renamed from: a */
    protected boolean mo11547a(int i) {
        if (i == 0) {
            return false;
        }
        MenuItem menuItem = i > 1 ? (MenuItem) getChildAt(i - 1).getTag() : null;
        MenuItem menuItem2 = i != getChildCount() ? (MenuItem) getChildAt(i).getTag() : null;
        if (menuItem == null || !menuItem.isVisible() || TextUtils.isEmpty(menuItem.getTitle())) {
            return menuItem2 != null && menuItem2.isVisible() && !TextUtils.isEmpty(menuItem2.getTitle()) && menuItem2.getIcon() == null;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    void m11546a(MenuItem menuItem) {
        TextView textView;
        if (menuItem.getIcon() != null) {
            ImageButton imageButton = new ImageButton(getContext(), null, C3307b.actionButtonStyle);
            imageButton.setImageDrawable(menuItem.getIcon());
            imageButton.setContentDescription(menuItem.getTitle());
            textView = imageButton;
        } else {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(C3323e.CommonTheme);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(9, 0);
            int color = typedArrayObtainStyledAttributes.getColor(10, 0);
            typedArrayObtainStyledAttributes.recycle();
            TextView textView2 = new TextView(getContext(), null, C3307b.actionButtonStyle);
            textView2.setText(menuItem.getTitle());
            textView2.setTextColor(color);
            textView2.setTextAppearance(getContext(), resourceId);
            textView = textView2;
        }
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        textView.setPadding(this.f11892a, 0, this.f11892a, 0);
        textView.setTag(menuItem);
        textView.setOnClickListener(this);
        textView.setEnabled(menuItem.isEnabled());
        if (menuItem.isVisible()) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        addView(textView);
    }

    /* renamed from: a */
    void m11545a() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setOnClickListener(null);
        }
        removeAllViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11893b != null) {
            this.f11893b.mo11620a(view, (MenuItem) view.getTag());
        }
    }
}
