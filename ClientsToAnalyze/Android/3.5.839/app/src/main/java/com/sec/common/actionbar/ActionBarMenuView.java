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
import com.sec.common.C4969b;
import com.sec.common.C4991e;
import com.sec.common.widget.HoneycombLinearLayout;

/* loaded from: classes.dex */
public class ActionBarMenuView extends HoneycombLinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private int f18091a;

    /* renamed from: b */
    private InterfaceC4960o f18092b;

    public ActionBarMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18091a = (int) (context.getResources().getDisplayMetrics().density * 4.0f);
    }

    public void setOnMenuItemClickListener(InterfaceC4960o interfaceC4960o) {
        this.f18092b = interfaceC4960o;
    }

    @Override // com.sec.common.widget.HoneycombLinearLayout
    /* renamed from: a */
    protected boolean mo18788a(int i) {
        int childCount = getChildCount();
        if (i == 0 || i == childCount) {
            return false;
        }
        MenuItem menuItem = i > 1 ? (MenuItem) getChildAt(i - 1).getTag() : null;
        MenuItem menuItem2 = i != childCount ? (MenuItem) getChildAt(i).getTag() : null;
        if (menuItem == null || !menuItem.isVisible() || TextUtils.isEmpty(menuItem.getTitle())) {
            return menuItem2 != null && menuItem2.isVisible() && !TextUtils.isEmpty(menuItem2.getTitle()) && menuItem2.getIcon() == null;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    void m18787a(MenuItem menuItem) {
        TextView textView;
        if (menuItem.getIcon() != null) {
            ImageButton imageButton = new ImageButton(getContext(), null, C4969b.actionButtonStyle);
            imageButton.setImageDrawable(menuItem.getIcon());
            imageButton.setContentDescription(menuItem.getTitle());
            textView = imageButton;
        } else {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(C4991e.CommonTheme);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(9, 0);
            int color = typedArrayObtainStyledAttributes.getColor(10, 0);
            typedArrayObtainStyledAttributes.recycle();
            TextView textView2 = new TextView(getContext(), null, C4969b.actionButtonStyle);
            textView2.setText(menuItem.getTitle());
            textView2.setTextColor(color);
            textView2.setTextAppearance(getContext(), resourceId);
            textView = textView2;
        }
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        textView.setPadding(this.f18091a, 0, this.f18091a, 0);
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
    void m18786a() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setOnClickListener(null);
        }
        removeAllViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f18092b != null) {
            this.f18092b.mo18859a(view, (MenuItem) view.getTag());
        }
    }
}
