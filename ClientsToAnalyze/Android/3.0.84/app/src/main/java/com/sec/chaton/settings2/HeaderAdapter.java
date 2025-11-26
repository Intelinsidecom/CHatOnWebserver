package com.sec.chaton.settings2;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.preference.PreferenceActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.widget.AdaptableTextView;
import java.util.List;

/* loaded from: classes.dex */
public class HeaderAdapter extends ArrayAdapter<PreferenceActivity.Header> {
    static final int HEADER_TYPE_CATEGORY = 0;
    private static final int HEADER_TYPE_COUNT = 3;
    static final int HEADER_TYPE_DELETE_ACCOUNT_BUTTON = 2;
    static final int HEADER_TYPE_NORMAL = 1;
    private List<PreferenceActivity.Header> headers;
    private LayoutInflater mInflater;
    private int selectedPosition;

    class HeaderViewHolder {
        View selector;
        TextView summary;
        TextView title;
        View unselector;
        TextView updateNumber;

        private HeaderViewHolder() {
        }
    }

    public HeaderAdapter(Context context, List<PreferenceActivity.Header> list) {
        super(context, 0, list);
        this.selectedPosition = 0;
        this.headers = list;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public int getHeaderType(PreferenceActivity.Header header) {
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getHeaderType(getItem(i));
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItemViewType(i) != 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        if (this.headers == null || this.headers.size() <= 0) {
            return 0;
        }
        return this.headers.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        HeaderViewHolder headerViewHolder;
        View viewInflate;
        PreferenceActivity.Header item = getItem(i);
        int headerType = getHeaderType(item);
        if (view == null) {
            HeaderViewHolder headerViewHolder2 = new HeaderViewHolder();
            switch (headerType) {
                case 0:
                    viewInflate = new AdaptableTextView(getContext(), null, R.attr.listSeparatorTextViewStyle);
                    headerViewHolder2.title = (TextView) viewInflate;
                    break;
                case 1:
                    viewInflate = this.mInflater.inflate(com.sec.chaton.R.layout.preference_item_common, viewGroup, false);
                    headerViewHolder2.title = (TextView) viewInflate.findViewById(R.id.title);
                    headerViewHolder2.summary = (TextView) viewInflate.findViewById(R.id.summary);
                    headerViewHolder2.updateNumber = (TextView) viewInflate.findViewById(com.sec.chaton.R.id.text2);
                    headerViewHolder2.selector = viewInflate.findViewById(com.sec.chaton.R.id.selector);
                    headerViewHolder2.unselector = viewInflate.findViewById(com.sec.chaton.R.id.unselector);
                    break;
                case 2:
                    viewInflate = this.mInflater.inflate(com.sec.chaton.R.layout.preference_delete_account, viewGroup, false);
                    break;
                default:
                    viewInflate = null;
                    break;
            }
            viewInflate.setTag(headerViewHolder2);
            headerViewHolder = headerViewHolder2;
        } else {
            headerViewHolder = (HeaderViewHolder) view.getTag();
            viewInflate = view;
        }
        switch (headerType) {
            case 0:
                headerViewHolder.title.setText(item.getTitle(getContext().getResources()));
                break;
            case 1:
                headerViewHolder.title.setText(item.getTitle(getContext().getResources()));
                CharSequence summary = item.getSummary(getContext().getResources());
                if (!TextUtils.isEmpty(summary)) {
                    headerViewHolder.summary.setVisibility(0);
                    headerViewHolder.summary.setText(summary);
                    break;
                } else {
                    headerViewHolder.summary.setVisibility(8);
                    break;
                }
        }
        if (GlobalApplication.m6456e() && i == this.selectedPosition) {
            if (headerViewHolder.selector != null) {
                headerViewHolder.selector.setVisibility(0);
                headerViewHolder.unselector.setVisibility(8);
                viewInflate.setBackgroundResource(com.sec.chaton.R.color.window_background_color);
                headerViewHolder.title.setTextColor(Color.parseColor("#ef6a20"));
            }
        } else if (headerViewHolder.selector != null) {
            headerViewHolder.selector.setVisibility(8);
            headerViewHolder.unselector.setVisibility(0);
            headerViewHolder.title.setTextColor(-16777216);
            viewInflate.setBackgroundResource(com.sec.chaton.R.drawable.tablet_listview_preference_selector);
        }
        return viewInflate;
    }

    public void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }
}
