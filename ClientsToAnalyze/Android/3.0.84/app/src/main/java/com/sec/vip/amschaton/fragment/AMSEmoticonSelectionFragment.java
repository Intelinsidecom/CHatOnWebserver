package com.sec.vip.amschaton.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class AMSEmoticonSelectionFragment extends AMSFragment implements View.OnClickListener {

    /* renamed from: a */
    private GridView f12710a = null;

    /* renamed from: b */
    private C3472at f12711b = null;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_ams_emoticon_selection, (ViewGroup) null, false);
        this.f12710a = (GridView) viewInflate.findViewById(R.id.gridview_emoticon);
        if (GlobalApplication.m6456e()) {
            this.f12710a.setColumnWidth(getActivity().getResources().getDimensionPixelOffset(R.dimen.ams_ics2_emoticion_grid_layout_column_width));
        }
        this.f12710a.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        m12520a();
        this.f12710a.setOnItemClickListener(new C3471as(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12522b(int i) {
        Intent intent = new Intent();
        intent.putExtra("AMS_EMOTICON_INDEX", i);
        getActivity().setResult(-1, intent);
        ((InterfaceC3474av) getActivity()).mo11978c();
    }

    /* renamed from: a */
    private void m12520a() {
        C3471as c3471as = null;
        if (this.f12710a != null) {
            if (this.f12711b != null) {
                this.f12711b = null;
            }
            this.f12711b = new C3472at(this, c3471as);
            this.f12710a.setAdapter((ListAdapter) this.f12711b);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
