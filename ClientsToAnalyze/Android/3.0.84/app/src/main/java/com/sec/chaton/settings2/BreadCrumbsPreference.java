package com.sec.chaton.settings2;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.C0432aj;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class BreadCrumbsPreference extends Preference {
    private String breadcrumb1;
    private String breadcrumb2;
    private String breadcrumb3;
    Activity mAttachedActivity;
    private TextView mBreadCrumb1;
    private TextView mBreadCrumb2;
    private TextView mBreadCrumb3;
    private Context mContext;
    private final Listener mListener;
    private ImageView mSeparator1;
    private ImageView mSeparator2;

    public BreadCrumbsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mListener = new Listener();
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0432aj.BreadCrumbsPreference);
        this.breadcrumb1 = typedArrayObtainStyledAttributes.getString(0);
        this.breadcrumb2 = typedArrayObtainStyledAttributes.getString(1);
        this.breadcrumb3 = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public BreadCrumbsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BreadCrumbsPreference(Context context) {
        this(context, null);
    }

    public void setActivity(Activity activity) {
        this.mAttachedActivity = activity;
    }

    @Override // android.preference.Preference
    protected View onCreateView(ViewGroup viewGroup) {
        return ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.preference_item_breadcrumbs, viewGroup, false);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        this.mBreadCrumb1 = (TextView) view.findViewById(R.id.breadcrumb1);
        this.mBreadCrumb2 = (TextView) view.findViewById(R.id.breadcrumb2);
        this.mBreadCrumb3 = (TextView) view.findViewById(R.id.breadcrumb3);
        this.mSeparator1 = (ImageView) view.findViewById(R.id.separator1);
        this.mSeparator2 = (ImageView) view.findViewById(R.id.separator2);
        if (this.breadcrumb3 == null) {
            this.mSeparator2.setVisibility(8);
            this.mBreadCrumb3.setVisibility(8);
        } else {
            this.mBreadCrumb3.setTextColor(this.mContext.getResources().getColor(R.color.buddy_list_item_status_changed));
            this.mBreadCrumb3.setText(this.breadcrumb3);
        }
        if (this.breadcrumb2 == null) {
            this.mBreadCrumb1.setTextColor(this.mContext.getResources().getColor(R.color.buddy_list_item_status_changed));
            this.mBreadCrumb1.setText(this.breadcrumb1);
            this.mSeparator1.setVisibility(8);
            this.mBreadCrumb2.setVisibility(8);
            return;
        }
        this.mBreadCrumb1.setText(this.breadcrumb1);
        if (!this.mBreadCrumb1.isClickable()) {
            this.mBreadCrumb1.setClickable(true);
        }
        this.mBreadCrumb1.setOnClickListener(this.mListener);
        this.mBreadCrumb2.setText(this.breadcrumb2);
        if (this.breadcrumb3 == null) {
            this.mBreadCrumb2.setTextColor(this.mContext.getResources().getColor(R.color.buddy_list_item_status_changed));
        }
    }

    class Listener implements View.OnClickListener {
        private Listener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BreadCrumbsPreference.this.mAttachedActivity != null) {
                BreadCrumbsPreference.this.mAttachedActivity.getFragmentManager().popBackStack();
            }
        }
    }
}
