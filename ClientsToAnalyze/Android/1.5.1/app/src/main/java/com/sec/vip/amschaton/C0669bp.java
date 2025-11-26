package com.sec.vip.amschaton;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.vip.amschaton.bp */
/* loaded from: classes.dex */
class C0669bp extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ BackgroundDefaultMusicSelectionActivity f4289a;

    /* renamed from: b */
    private String[] f4290b;

    public C0669bp(BackgroundDefaultMusicSelectionActivity backgroundDefaultMusicSelectionActivity, Context context) {
        this.f4289a = backgroundDefaultMusicSelectionActivity;
        this.f4290b = context.getResources().getStringArray(C0062R.array.ams_strarr_default_bgm);
    }

    /* renamed from: a */
    public void m4230a() {
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f4290b == null) {
            return 0;
        }
        return this.f4290b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? this.f4289a.getLayoutInflater().inflate(C0062R.layout.ams_bg_default_music_item, viewGroup, false) : view;
        ImageView imageView = (ImageView) viewInflate.findViewById(C0062R.id.itemImg);
        imageView.setImageResource(this.f4289a.f4125n[i % 8]);
        if (i == 0) {
            imageView.setVisibility(4);
        } else {
            imageView.setVisibility(0);
        }
        ((TextView) viewInflate.findViewById(C0062R.id.itemText)).setText(this.f4290b[i]);
        RadioButton radioButton = (RadioButton) viewInflate.findViewById(C0062R.id.checkradio);
        if (i == this.f4289a.f4120a + 1) {
            radioButton.setChecked(true);
        } else {
            radioButton.setChecked(false);
        }
        return viewInflate;
    }
}
