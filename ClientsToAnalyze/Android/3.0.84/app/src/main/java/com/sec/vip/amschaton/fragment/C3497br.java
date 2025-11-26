package com.sec.vip.amschaton.fragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sec.chaton.R;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.br */
/* loaded from: classes.dex */
public class C3497br extends CursorAdapter implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12877a;

    /* renamed from: b */
    private C3490bk f12878b;

    /* renamed from: c */
    private boolean[] f12879c;

    /* renamed from: d */
    private Handler f12880d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3497br(AMSListFragment aMSListFragment, Context context, Cursor cursor) {
        super(context, cursor);
        this.f12877a = aMSListFragment;
        this.f12878b = null;
        this.f12879c = null;
        if (cursor != null) {
            this.f12878b = new C3490bk(aMSListFragment);
            this.f12879c = new boolean[cursor.getCount()];
            m12718a(false);
        }
    }

    /* renamed from: a */
    public boolean[] m12719a() {
        return this.f12879c;
    }

    /* renamed from: a */
    public void m12718a(boolean z) {
        if (this.f12879c != null) {
            for (int i = 0; i < this.f12879c.length; i++) {
                this.f12879c[i] = z;
            }
        }
        notifyDataSetChanged();
        m12716b();
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_checkbox);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_delete);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_ams_image);
        checkBox.setTag(Integer.valueOf(cursor.getPosition()));
        relativeLayout.setTag(Integer.valueOf(cursor.getPosition()));
        relativeLayout.setOnClickListener(null);
        if (this.f12877a.f12728a == 2002) {
            relativeLayout.setVisibility(0);
            checkBox.setOnCheckedChangeListener(this);
            checkBox.setChecked(this.f12879c[cursor.getPosition()]);
            relativeLayout.setOnClickListener(new ViewOnClickListenerC3498bs(this, checkBox));
        } else {
            relativeLayout.setVisibility(8);
            checkBox.setOnCheckedChangeListener(null);
        }
        String string = cursor.getString(cursor.getColumnIndex("ams_path"));
        if (string != null) {
            this.f12878b.m12711a(string, imageView);
        }
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f12877a.getActivity().getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton instanceof CheckBox) {
            this.f12879c[((Integer) ((CheckBox) compoundButton).getTag()).intValue()] = z;
        }
        m12716b();
    }

    /* renamed from: b */
    private void m12716b() {
        boolean z;
        boolean z2;
        if (this.f12880d != null) {
            Message message = new Message();
            message.what = 1000;
            if (this.f12879c != null) {
                z = true;
                z2 = false;
                for (int i = 0; i < this.f12879c.length; i++) {
                    if (this.f12879c[i]) {
                        z2 = true;
                    } else {
                        z = false;
                    }
                }
            } else {
                z = true;
                z2 = false;
            }
            message.arg1 = z2 ? 1 : 0;
            message.arg2 = z ? 1 : 0;
            this.f12880d.sendMessage(message);
        }
    }

    /* renamed from: a */
    public void m12717a(Handler handler) {
        this.f12880d = handler;
    }
}
