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

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.db */
/* loaded from: classes.dex */
public class C3535db extends CursorAdapter implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12957a;

    /* renamed from: b */
    private C3523cq f12958b;

    /* renamed from: c */
    private boolean[] f12959c;

    /* renamed from: d */
    private Handler f12960d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3535db(AMSStampSelectionFragment aMSStampSelectionFragment, Context context, Cursor cursor) {
        super(context, cursor);
        this.f12957a = aMSStampSelectionFragment;
        this.f12958b = null;
        this.f12959c = null;
        this.f12958b = new C3523cq(aMSStampSelectionFragment);
        this.f12959c = new boolean[cursor.getCount()];
        m12744a(false);
    }

    /* renamed from: a */
    public boolean[] m12745a() {
        return this.f12959c;
    }

    /* renamed from: a */
    public void m12744a(boolean z) {
        if (this.f12959c != null) {
            for (int i = 0; i < this.f12959c.length; i++) {
                this.f12959c[i] = z;
            }
        }
        notifyDataSetChanged();
        m12742b();
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_create_stamp);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.layout_checkbox);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_delete);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_basic_stamp);
        relativeLayout.setVisibility(8);
        checkBox.setTag(Integer.valueOf(cursor.getPosition()));
        relativeLayout2.setOnClickListener(null);
        if (this.f12957a.f12754m == 2002) {
            relativeLayout2.setVisibility(0);
            checkBox.setOnCheckedChangeListener(this);
            checkBox.setChecked(this.f12959c[cursor.getPosition()]);
            relativeLayout2.setOnClickListener(new ViewOnClickListenerC3536dc(this, checkBox));
        } else {
            relativeLayout2.setVisibility(8);
            checkBox.setOnCheckedChangeListener(null);
        }
        int iIntValue = Integer.valueOf(cursor.getString(cursor.getColumnIndex("ams_index"))).intValue();
        if (iIntValue >= 40000) {
            this.f12958b.m12729a("d" + cursor.getString(cursor.getColumnIndex("ams_path")), imageView);
        } else {
            this.f12958b.m12729a(String.valueOf(iIntValue), imageView);
        }
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f12957a.getActivity().getLayoutInflater().inflate(R.layout.ams_ics_list_item_stamp, viewGroup, false);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton instanceof CheckBox) {
            this.f12959c[((Integer) ((CheckBox) compoundButton).getTag()).intValue()] = z;
        }
        m12742b();
    }

    /* renamed from: b */
    private void m12742b() {
        boolean z;
        boolean z2;
        if (this.f12960d != null) {
            Message message = new Message();
            message.what = 1000;
            if (this.f12959c != null) {
                z = true;
                z2 = false;
                for (int i = 0; i < this.f12959c.length; i++) {
                    if (this.f12959c[i]) {
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
            this.f12960d.sendMessage(message);
        }
    }

    /* renamed from: a */
    public void m12743a(Handler handler) {
        this.f12960d = handler;
    }
}
