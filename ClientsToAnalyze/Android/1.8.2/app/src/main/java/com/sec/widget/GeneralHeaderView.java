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
import com.sec.chaton.C0229at;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class GeneralHeaderView extends FrameLayout {

    /* renamed from: a */
    private ImageButton f7721a;

    /* renamed from: b */
    private ImageButton f7722b;

    /* renamed from: c */
    private TextView f7723c;

    /* renamed from: d */
    private ImageView f7724d;

    /* renamed from: e */
    private ImageView f7725e;

    /* renamed from: f */
    private View.OnClickListener f7726f;

    public GeneralHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GeneralHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7726f = new ViewOnClickListenerC2152x(this);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.general_header, (ViewGroup) this, true);
        this.f7721a = (ImageButton) findViewById(R.id.header_button_back);
        this.f7722b = (ImageButton) findViewById(R.id.header_button1);
        this.f7723c = (TextView) findViewById(R.id.header_title);
        this.f7723c.setOnTouchListener(new ViewOnTouchListenerC2151w(this));
        this.f7724d = (ImageView) findViewById(R.id.header_separator_left);
        this.f7725e = (ImageView) findViewById(R.id.header_separator_right);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0229at.GeneralHeaderView, i, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(1);
        if (text != null) {
            this.f7723c.setText(text);
        } else if (context instanceof Activity) {
            this.f7723c.setText(((Activity) context).getTitle());
        }
        setButtonImageResource(typedArrayObtainStyledAttributes.getResourceId(0, 0));
        this.f7721a.setOnClickListener(this.f7726f);
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.f7721a.setOnClickListener(this.f7726f);
        } else {
            this.f7721a.setOnClickListener(onClickListener);
        }
    }

    public void setText(int i) {
        this.f7723c.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f7723c.setText(charSequence);
    }

    public void setButtonImageResource(int i) {
        if (i == 0) {
            this.f7722b.setVisibility(4);
            this.f7725e.setVisibility(4);
        } else {
            this.f7722b.setImageResource(i);
            this.f7722b.setVisibility(0);
            this.f7725e.setVisibility(0);
        }
        this.f7722b.setContentDescription(m7458a(i));
    }

    public void setMarquee() {
        this.f7723c.setSingleLine(true);
        this.f7723c.setSelected(true);
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.f7722b.setOnClickListener(onClickListener);
    }

    public void setButtonEnabled(boolean z) {
        this.f7722b.setEnabled(z);
    }

    /* renamed from: a */
    private CharSequence m7458a(int i) {
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

    public void setBackInvisiable() {
        this.f7721a.setVisibility(4);
        this.f7724d.setVisibility(4);
    }

    public void setInvisableAllButton() {
        this.f7721a.setVisibility(8);
        this.f7724d.setVisibility(8);
        this.f7722b.setVisibility(8);
        this.f7725e.setVisibility(8);
    }
}
