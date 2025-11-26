package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sec.chaton.R;
import java.util.List;

/* compiled from: DeliveryReportAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.u */
/* loaded from: classes.dex */
public class C4354u extends ArrayAdapter<C4355v> {
    public C4354u(Context context, List<C4355v> list) {
        super(context, R.layout.delivery_report_list_item, R.id.recipient, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        DeliveryReportListItem deliveryReportListItem;
        C4355v item = getItem(i);
        if (view == null) {
            deliveryReportListItem = (DeliveryReportListItem) LayoutInflater.from(getContext()).inflate(R.layout.delivery_report_list_item, viewGroup, false);
        } else if (view instanceof DeliveryReportListItem) {
            deliveryReportListItem = (DeliveryReportListItem) view;
        } else {
            return view;
        }
        deliveryReportListItem.m15768a(item.f15793a, item.f15794b);
        return deliveryReportListItem;
    }
}
