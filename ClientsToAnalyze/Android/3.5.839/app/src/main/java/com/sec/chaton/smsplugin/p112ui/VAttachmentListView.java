package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.p110g.C3855a;
import com.sec.chaton.smsplugin.p111h.C3892o;
import java.util.HashMap;

@TargetApi(14)
/* loaded from: classes.dex */
public class VAttachmentListView extends LinearLayout {

    /* renamed from: b */
    private static HashMap<String, Integer> f15210b;

    /* renamed from: d */
    private static final float f15211d = GlobalApplication.m10279a().getResources().getDisplayMetrics().density;

    /* renamed from: a */
    private LayoutInflater f15212a;

    /* renamed from: c */
    private boolean f15213c;

    public VAttachmentListView(Context context) {
        super(context);
        this.f15213c = false;
        m16283a(context);
    }

    public VAttachmentListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15213c = false;
        m16283a(context);
    }

    public VAttachmentListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15213c = false;
        m16283a(context);
    }

    /* renamed from: a */
    private void m16283a(Context context) {
        this.mContext = context;
        this.f15212a = LayoutInflater.from(context);
        if (f15210b == null) {
            f15210b = new HashMap<>();
            f15210b.put("text/x-vcard", Integer.valueOf(R.drawable.co_attach_p_contact_normal));
            f15210b.put("text/x-vcalendar", Integer.valueOf(R.drawable.co_attach_p_calendar_normal));
            f15210b.put("text/x-vnote", Integer.valueOf(R.drawable.co_attach_p_s_note_normal));
            f15210b.put("text/x-vtodo", Integer.valueOf(R.drawable.attachment_list_icon_task));
        }
    }

    /* renamed from: a */
    private int m16282a(String str) {
        Integer num = f15210b.get(str.toLowerCase());
        return num == null ? R.drawable.attachment_list_icon_attach : num.intValue();
    }

    /* renamed from: a */
    public void m16285a(C3855a c3855a, View.OnClickListener onClickListener) {
        if (getChildCount() > 0) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.message_attach_files_divider);
            imageView.setLongClickable(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            int dimension = (int) getResources().getDimension(R.dimen.msg_bubble_attachment_left_rihgt_marging);
            imageView.setPadding(dimension, dimension, dimension, dimension);
            addView(imageView, -1, -2);
        }
        View viewInflate = this.f15212a.inflate(R.layout.bubble_attachment_info, (ViewGroup) this, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.name);
        textView.setText(c3855a.m14748d());
        ((ImageView) viewInflate.findViewById(R.id.vattach_icon)).setImageResource(m16282a(c3855a.m14744a()));
        if (this.f15213c) {
            viewInflate.setOnClickListener(onClickListener);
            viewInflate.setTag(c3855a);
            viewInflate.setBackgroundResource(R.drawable.bubble_attachment_selector);
            viewInflate.setLongClickable(true);
        }
        textView.setPadding(C3892o.m15008a(4.0f), textView.getPaddingTop(), C3892o.m15008a(8.3f), textView.getPaddingBottom());
        addView(viewInflate);
    }

    /* renamed from: a */
    public void m16284a() {
        removeAllViews();
    }

    public void setItemClickable(boolean z) {
        this.f15213c = z;
    }
}
