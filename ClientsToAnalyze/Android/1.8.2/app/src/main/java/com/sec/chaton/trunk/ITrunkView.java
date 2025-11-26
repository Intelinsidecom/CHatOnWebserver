package com.sec.chaton.trunk;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.trunk.p048b.EnumC1551b;

/* loaded from: classes.dex */
public abstract class ITrunkView extends Fragment {
    /* renamed from: a */
    public abstract void mo5228a(Cursor cursor, EnumC1551b enumC1551b);

    /* renamed from: a */
    public abstract void mo5229a(InterfaceC1605k interfaceC1605k);

    /* renamed from: a */
    public abstract void mo5230a(InterfaceC1606l interfaceC1606l);

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        m5227a(configuration);
    }

    /* renamed from: a */
    private void m5227a(Configuration configuration) throws Resources.NotFoundException {
        if (configuration.orientation == 2) {
            m5226a(R.dimen.land_Left_fragment_size, R.dimen.land_right_fragment_size);
        } else if (configuration.orientation == 1) {
            m5226a(R.dimen.port_left_fragment_size, R.dimen.port_right_fragment_size);
        }
    }

    /* renamed from: a */
    private void m5226a(int i, int i2) throws Resources.NotFoundException {
        int dimensionPixelOffset = getActivity().getResources().getDimensionPixelOffset(i);
        int dimensionPixelOffset2 = getActivity().getResources().getDimensionPixelOffset(i2);
        ((FrameLayout) getActivity().findViewById(R.id.fragment_controller)).setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset, -1));
        ((FrameLayout) getActivity().findViewById(R.id.fragment_container)).setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset2, -1));
    }
}
