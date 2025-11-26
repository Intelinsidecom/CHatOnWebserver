package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.C3855a;
import java.util.ArrayList;

/* compiled from: AttachmentListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.d */
/* loaded from: classes.dex */
public class ViewOnClickListenerC4172d extends ArrayAdapter<C3855a> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    private final int f15490a;

    /* renamed from: b */
    private final LayoutInflater f15491b;

    /* renamed from: c */
    private SparseBooleanArray f15492c;

    /* renamed from: d */
    private Button f15493d;

    /* renamed from: e */
    private int f15494e;

    /* renamed from: f */
    private C3855a f15495f;

    public ViewOnClickListenerC4172d(Context context, int i, ArrayList<C3855a> arrayList) {
        super(context, i, arrayList);
        this.f15493d = null;
        this.f15490a = i;
        this.f15491b = LayoutInflater.from(context);
        this.f15492c = new SparseBooleanArray(arrayList.size());
        this.f15494e = arrayList.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f15491b.inflate(this.f15490a, (ViewGroup) null);
        }
        this.f15495f = getItem(i);
        TextView textView = (TextView) view.findViewById(R.id.attachment_text);
        textView.setText(this.f15495f.m14748d());
        textView.setFocusable(false);
        textView.setFocusableInTouchMode(false);
        textView.setTag(Integer.valueOf(i));
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.selected);
        checkBox.setTag(Integer.valueOf(i));
        checkBox.setChecked(this.f15492c.get(i, false));
        checkBox.setOnCheckedChangeListener(this);
        checkBox.setOnClickListener(new ViewOnClickListenerC4199e(this));
        view.setFocusable(false);
        view.setBackgroundResource(R.drawable.msg_list_background_selector);
        view.setOnClickListener(this);
        view.setTag(Integer.valueOf(i));
        return view;
    }

    /* renamed from: a */
    public boolean m16463a(int i) {
        return this.f15492c.get(i, false);
    }

    /* renamed from: a */
    public void m16461a(int i, boolean z) {
        if (this.f15492c != null) {
            this.f15492c.put(i, z);
            notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public void m16464b(int i) {
        m16461a(i, !m16463a(i));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.f15492c != null) {
            this.f15492c.put(((Integer) compoundButton.getTag()).intValue(), z);
            if (this.f15493d != null) {
                for (int i = 0; i < this.f15494e; i++) {
                    if (m16463a(i)) {
                        this.f15493d.setEnabled(true);
                        return;
                    }
                }
                this.f15493d.setEnabled(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m16464b(((Integer) view.getTag()).intValue());
    }

    /* renamed from: a */
    public void m16462a(Button button) {
        this.f15493d = button;
        this.f15493d.setEnabled(false);
    }
}
