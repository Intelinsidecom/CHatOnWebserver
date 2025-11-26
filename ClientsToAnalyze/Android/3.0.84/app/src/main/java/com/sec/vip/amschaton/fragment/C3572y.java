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

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.y */
/* loaded from: classes.dex */
public class C3572y extends CursorAdapter implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f13021a;

    /* renamed from: b */
    private C3564q f13022b;

    /* renamed from: c */
    private boolean[] f13023c;

    /* renamed from: d */
    private Handler f13024d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3572y(AMSBgSelectionFragment aMSBgSelectionFragment, Context context, Cursor cursor) {
        super(context, cursor);
        this.f13021a = aMSBgSelectionFragment;
        this.f13022b = null;
        this.f13023c = null;
        this.f13022b = new C3564q(aMSBgSelectionFragment);
        this.f13023c = new boolean[cursor.getCount()];
        m12762a(false);
    }

    /* renamed from: a */
    public boolean[] m12763a() {
        return this.f13023c;
    }

    /* renamed from: a */
    public void m12762a(boolean z) {
        if (this.f13023c != null) {
            for (int i = 0; i < this.f13023c.length; i++) {
                this.f13023c[i] = z;
            }
        }
        notifyDataSetChanged();
        m12760b();
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_checkbox);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_delete);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_frame);
        checkBox.setTag(Integer.valueOf(cursor.getPosition()));
        relativeLayout.setOnClickListener(null);
        if (this.f13021a.f12646v == 3002) {
            relativeLayout.setVisibility(0);
            checkBox.setOnCheckedChangeListener(this);
            checkBox.setChecked(this.f13023c[cursor.getPosition()]);
            relativeLayout.setOnClickListener(new ViewOnClickListenerC3573z(this, checkBox));
        } else {
            relativeLayout.setVisibility(8);
            checkBox.setOnCheckedChangeListener(null);
        }
        int iIntValue = Integer.valueOf(cursor.getString(cursor.getColumnIndex("ams_index"))).intValue();
        if (iIntValue >= 10000) {
            this.f13022b.m12749a("d" + cursor.getString(cursor.getColumnIndex("ams_path")), imageView);
        } else {
            this.f13022b.m12749a(String.valueOf(iIntValue), imageView);
        }
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f13021a.getActivity().getLayoutInflater().inflate(R.layout.ams_ics_list_item_frame, viewGroup, false);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton instanceof CheckBox) {
            this.f13023c[((Integer) ((CheckBox) compoundButton).getTag()).intValue()] = z;
        }
        m12760b();
    }

    /* renamed from: b */
    private void m12760b() {
        boolean z;
        boolean z2;
        if (this.f13024d != null) {
            Message message = new Message();
            message.what = 2000;
            if (this.f13023c != null) {
                z = true;
                z2 = false;
                for (int i = 0; i < this.f13023c.length; i++) {
                    if (this.f13023c[i]) {
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
            this.f13024d.sendMessage(message);
        }
    }

    /* renamed from: a */
    public void m12761a(Handler handler) {
        this.f13024d = handler;
    }
}
