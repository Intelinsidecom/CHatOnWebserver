package com.sec.chaton.samsungaccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class FlickImageLayout extends Fragment {

    /* renamed from: a */
    private int f8633a;

    public FlickImageLayout() {
        this.f8633a = -1;
    }

    public FlickImageLayout(int i) {
        this.f8633a = -1;
        this.f8633a = i;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("position_data")) {
            this.f8633a = bundle.getInt("position_data");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_multi_device_flicking, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image2);
        TextView textView = (TextView) viewInflate.findViewById(R.id.textComment);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.textView);
        if (this.f8633a == 0) {
            imageView.setImageResource(R.drawable.provisioning_samsung_account_not_sign_in_image);
            textView.setText(R.string.multidevice_brige_comment1);
            textView2.setText(R.string.multidevice_brige_title2);
            textView2.setVisibility(0);
        } else if (this.f8633a == 1) {
            imageView.setImageResource(R.drawable.provisioning_samsung_account_not_sign_in_image);
            textView.setText(R.string.multidevice_brige_comment2);
            textView2.setText(R.string.multidevice_brige_title2);
            textView2.setVisibility(0);
        } else if (this.f8633a == 2) {
            imageView.setImageResource(R.drawable.provisioning_v_already_sign_in_image);
            textView.setText(R.string.multidevice_brige_chatonv_comment);
            textView2.setText(R.string.multidevice_brige_chatonv_title);
            textView2.setVisibility(0);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("position_data", this.f8633a);
        super.onSaveInstanceState(bundle);
    }
}
