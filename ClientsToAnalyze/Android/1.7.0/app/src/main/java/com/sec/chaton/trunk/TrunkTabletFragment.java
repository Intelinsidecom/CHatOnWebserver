package com.sec.chaton.trunk;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class TrunkTabletFragment extends Fragment {

    /* renamed from: a */
    View f3824a;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3824a = layoutInflater.inflate(R.layout.base_activity, viewGroup, false);
        return this.f3824a;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.fragment_controller, new TrunkView());
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, new EmptyContentFragment(), "container");
        fragmentTransactionBeginTransaction.commit();
    }

    public class EmptyContentFragment extends Fragment {
        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.fragment_empty, viewGroup, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.emptyTextView);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.chaton_trunk_ic_trunk), (Drawable) null, (Drawable) null);
            textView.setText(R.string.trunk_nothing);
            return viewInflate;
        }
    }

    public class EmptyNetWorkErrorContentFragment extends Fragment {
        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.fragment_empty, viewGroup, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.emptyTextView);
            textView.setTextColor(getResources().getColor(R.color.trunk_empty_string));
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.chaton_trunk_ic_no_network), (Drawable) null, (Drawable) null);
            textView.setText(R.string.toast_network_unable);
            return viewInflate;
        }
    }
}
