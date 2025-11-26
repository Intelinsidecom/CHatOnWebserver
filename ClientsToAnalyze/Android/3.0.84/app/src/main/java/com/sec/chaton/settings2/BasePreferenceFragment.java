package com.sec.chaton.settings2;

import android.R;
import android.app.FragmentBreadCrumbs;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

/* loaded from: classes.dex */
public class BasePreferenceFragment extends PreferenceFragment {
    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout;
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        LinearLayout linearLayout2 = (LinearLayout) viewGroup.getParent();
        if (Build.VERSION.SDK_INT >= 16) {
            linearLayout2.setBackground(null);
        } else {
            linearLayout2.setBackgroundDrawable(null);
        }
        linearLayout2.setPadding(0, 0, 0, 0);
        linearLayout2.setBackgroundColor(0);
        ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            if (Build.VERSION.SDK_INT >= 17) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(0);
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(0);
            }
        }
        viewGroup.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.sec.chaton.settings2.BasePreferenceFragment.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                view.setPadding(0, 0, 0, 0);
            }
        });
        FragmentBreadCrumbs fragmentBreadCrumbs = (FragmentBreadCrumbs) linearLayout2.findViewById(R.id.title);
        if (fragmentBreadCrumbs != null && (linearLayout = (LinearLayout) fragmentBreadCrumbs.getParent()) != null) {
            linearLayout.setVisibility(8);
        }
        ListView listView = (ListView) viewOnCreateView.findViewById(R.id.list);
        ViewGroup viewGroup2 = (ViewGroup) listView.getParent();
        ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
        listView.setPadding(0, 0, 0, 0);
        viewGroup2.setPadding(0, 0, 0, 0);
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).setMargins(0, 0, 0, 0);
        }
        return viewOnCreateView;
    }
}
