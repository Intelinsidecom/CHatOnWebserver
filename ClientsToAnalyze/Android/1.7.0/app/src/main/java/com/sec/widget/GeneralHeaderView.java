package com.sec.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.C0122a;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class GeneralHeaderView extends FrameLayout {

    /* renamed from: a */
    private ImageButton f5666a;

    /* renamed from: b */
    private ImageButton f5667b;

    /* renamed from: c */
    private TextView f5668c;

    /* renamed from: d */
    private ImageView f5669d;

    /* renamed from: e */
    private ImageView f5670e;

    /* renamed from: f */
    private View.OnClickListener f5671f;

    public GeneralHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GeneralHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5671f = new ViewOnClickListenerC1627o(this);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.general_header, (ViewGroup) this, true);
        this.f5666a = (ImageButton) findViewById(R.id.header_button_back);
        this.f5667b = (ImageButton) findViewById(R.id.header_button1);
        this.f5668c = (TextView) findViewById(R.id.header_title);
        this.f5668c.setOnTouchListener(new ViewOnTouchListenerC1626n(this));
        this.f5669d = (ImageView) findViewById(R.id.header_separator_left);
        this.f5670e = (ImageView) findViewById(R.id.header_separator_right);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0122a.GeneralHeaderView, i, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(1);
        if (text != null) {
            this.f5668c.setText(text);
        } else if (context instanceof Activity) {
            this.f5668c.setText(((Activity) context).getTitle());
        }
        setButtonImageResource(typedArrayObtainStyledAttributes.getResourceId(0, 0));
        this.f5666a.setOnClickListener(this.f5671f);
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.f5666a.setOnClickListener(this.f5671f);
        } else {
            this.f5666a.setOnClickListener(onClickListener);
        }
    }

    public void setText(int i) {
        this.f5668c.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f5668c.setText(charSequence);
    }

    public void setTextSize(float f) {
        this.f5668c.setTextSize(1, f);
    }

    public void setButtonImageResource(int i) {
        if (i == 0) {
            this.f5667b.setVisibility(4);
            this.f5670e.setVisibility(4);
        } else {
            this.f5667b.setImageResource(i);
            this.f5667b.setVisibility(0);
            this.f5670e.setVisibility(0);
        }
        this.f5667b.setContentDescription(m5853a(i));
    }

    public void setMarquee() {
        this.f5668c.setSingleLine(true);
        this.f5668c.setSelected(true);
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.f5667b.setOnClickListener(onClickListener);
    }

    public void setButtonEnabled(boolean z) {
        this.f5667b.setEnabled(z);
    }

    /* renamed from: a */
    public boolean m5854a() {
        return this.f5667b.isEnabled();
    }

    /* renamed from: a */
    private CharSequence m5853a(int i) {
        int i2 = 0;
        if (i == R.drawable.general_btn_icon_complete_xml) {
            i2 = R.string.done;
        } else if (i == R.drawable.general_btn_down_arrow_xml) {
            i2 = R.string.chat_view_sendfail_title;
        } else if (i == R.drawable.general_btn_icon_send_xml) {
            i2 = R.string.layout_chat_fragment_send;
        } else if (i == R.drawable.general_btn_icon_save_xml) {
            i2 = R.string.save;
        } else if (i == R.drawable.general_btn_icon_edit_xml) {
            i2 = R.string.ams_optmenu_edit;
        } else if (i == R.drawable.general_btn_icon_share_xml) {
            i2 = R.string.share;
        }
        if (i2 == 0) {
            return null;
        }
        return getResources().getString(i2);
    }
}
