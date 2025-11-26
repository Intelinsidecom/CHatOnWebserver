package com.sec.vip.amschaton;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.sec.chaton.C0229at;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class AMSActionBarView extends FrameLayout {

    /* renamed from: a */
    private Context f6599a;

    /* renamed from: b */
    private LinearLayout f6600b;

    /* renamed from: c */
    private ImageView f6601c;

    /* renamed from: d */
    private TextView f6602d;

    /* renamed from: e */
    private LinearLayout f6603e;

    /* renamed from: f */
    private LinearLayout f6604f;

    /* renamed from: g */
    private PopupWindow f6605g;

    /* renamed from: h */
    private View.OnClickListener f6606h;

    /* renamed from: i */
    private View.OnClickListener f6607i;

    public AMSActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AMSActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6606h = new ViewOnClickListenerC1867b(this);
        this.f6607i = new ViewOnClickListenerC1886c(this);
        this.f6599a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.ams_ics_layout_actionbar, (ViewGroup) this, true);
        this.f6600b = (LinearLayout) findViewById(R.id.layout_home);
        this.f6601c = (ImageView) findViewById(R.id.img_btn_more);
        this.f6602d = (TextView) findViewById(R.id.text_title);
        this.f6602d.setOnTouchListener(new ViewOnTouchListenerC1840a(this));
        CharSequence text = context.obtainStyledAttributes(attributeSet, C0229at.AMSActionBarView, i, 0).getText(0);
        if (text != null) {
            this.f6602d.setText(text);
        } else if (context instanceof Activity) {
            this.f6602d.setText(((Activity) context).getTitle());
        }
        this.f6600b.setOnClickListener(this.f6606h);
        this.f6601c.setOnClickListener(this.f6607i);
        this.f6603e = (LinearLayout) findViewById(R.id.layout_action_buttons);
    }

    public void setHomeClickListener(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.f6600b.setOnClickListener(this.f6606h);
        } else {
            this.f6600b.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(int i) {
        this.f6602d.setText(i);
    }

    public void setTitleText(CharSequence charSequence) {
        this.f6602d.setText(charSequence);
    }

    public void setActionButtonLayoutVisibility(boolean z) {
        if (this.f6603e != null) {
            this.f6603e.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public boolean m6246a(int i, int i2, View.OnClickListener onClickListener, int i3) {
        if (this.f6603e == null) {
            return false;
        }
        View viewInflate = ((LayoutInflater) this.f6599a.getSystemService("layout_inflater")).inflate(R.layout.ams_ics_layout_actionbar_button, (ViewGroup) this, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon_action_button);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text_action_button);
        imageView.setImageResource(i);
        textView.setText(i2);
        viewInflate.setId(i3);
        viewInflate.setOnClickListener(onClickListener);
        this.f6603e.addView(viewInflate);
        return true;
    }

    /* renamed from: a */
    private View m6243a(int i) {
        int childCount = this.f6603e.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f6603e.getChildAt(i2);
            if (childAt == null) {
                return null;
            }
            if (childAt.getId() == i) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m6248a(int i, boolean z) {
        View viewM6243a = m6243a(i);
        if (viewM6243a == null) {
            return false;
        }
        viewM6243a.setEnabled(z);
        ImageView imageView = (ImageView) viewM6243a.findViewById(R.id.icon_action_button);
        TextView textView = (TextView) viewM6243a.findViewById(R.id.text_action_button);
        imageView.setEnabled(z);
        textView.setEnabled(z);
        return true;
    }

    /* renamed from: a */
    public boolean m6245a(int i, int i2) {
        View viewM6243a = m6243a(i);
        if (viewM6243a == null) {
            return false;
        }
        ((ImageView) viewM6243a.findViewById(R.id.icon_action_button)).setImageResource(i2);
        return true;
    }

    /* renamed from: b */
    public boolean m6250b(int i, int i2) {
        View viewM6243a = m6243a(i);
        if (viewM6243a == null) {
            return false;
        }
        ((TextView) viewM6243a.findViewById(R.id.text_action_button)).setText(i2);
        return true;
    }

    /* renamed from: b */
    public boolean m6251b(int i, boolean z) {
        View viewM6243a = m6243a(i);
        if (viewM6243a == null) {
            return false;
        }
        viewM6243a.setVisibility(z ? 0 : 8);
        return true;
    }

    /* renamed from: a */
    public void m6244a() {
        if (this.f6603e != null) {
            this.f6603e.removeAllViews();
        }
    }

    public void setMoreOptionIconVisibility(boolean z) {
        if (this.f6601c != null) {
            this.f6601c.setVisibility(z ? 0 : 8);
        }
    }

    public void setMoreOptionMenuPopup() {
        this.f6605g = new PopupWindow(this.f6599a);
        this.f6605g.setBackgroundDrawable(new BitmapDrawable());
        this.f6605g.setWidth(-2);
        this.f6605g.setHeight(-2);
        this.f6605g.setTouchable(true);
        this.f6605g.setFocusable(true);
        this.f6605g.setOutsideTouchable(true);
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.ams_ics_layout_actionbar_popup, (ViewGroup) null);
        this.f6605g.setContentView(viewGroup);
        viewGroup.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        viewGroup.measure(-2, -2);
        this.f6604f = (LinearLayout) viewGroup.findViewById(R.id.layout_more_option);
    }

    /* renamed from: a */
    public boolean m6247a(int i, int i2, View.OnClickListener onClickListener, boolean z) {
        if (this.f6604f == null) {
            return false;
        }
        LinearLayout linearLayout = new LinearLayout(this.f6599a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f6599a.getResources().getDimensionPixelSize(R.dimen.ams_ics_more_option_item_height));
        linearLayout.setGravity(19);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundResource(R.drawable.ams_list_selector_holo_light);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(onClickListener);
        linearLayout.setPadding(this.f6599a.getResources().getDimensionPixelSize(R.dimen.ams_ics_more_option_text_left_padding), 0, 0, 0);
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.ams_ics_layout_actionbar_popup_item, (ViewGroup) null);
        ((ImageView) viewGroup.findViewById(R.id.option_menu_icon)).setImageResource(i2);
        ((TextView) viewGroup.findViewById(R.id.option_menu_text)).setText(i);
        linearLayout.addView(viewGroup);
        this.f6604f.addView(linearLayout);
        if (z) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            ImageView imageView = new ImageView(this.f6599a);
            imageView.setLayoutParams(layoutParams2);
            imageView.setBackgroundResource(R.drawable.list_divider_h);
            this.f6604f.addView(imageView);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m6249a(boolean z) {
        if (this.f6605g == null) {
            return false;
        }
        if (z) {
            if (!this.f6605g.isShowing()) {
                this.f6605g.showAsDropDown(this.f6601c, this.f6601c.getMeasuredWidth() - this.f6599a.getResources().getDimensionPixelSize(R.dimen.ams_ics_more_option_width), 0);
            }
        } else if (this.f6605g.isShowing()) {
            this.f6605g.dismiss();
        }
        return true;
    }
}
