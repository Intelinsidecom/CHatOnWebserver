package com.sec.vip.amschaton.ics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import java.io.IOException;

/* compiled from: AMSBgFrameSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bo */
/* loaded from: classes.dex */
public class C1511bo extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSBgFrameSelectionActivity f5336a;

    /* renamed from: b */
    private Context f5337b;

    public C1511bo(AMSBgFrameSelectionActivity aMSBgFrameSelectionActivity, Context context) {
        this.f5336a = aMSBgFrameSelectionActivity;
        this.f5337b = context;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5336a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_frame, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image_frame);
        try {
            if (i < 2) {
                imageView.setImageBitmap(null);
            } else if (i == 14) {
                imageView.setImageResource(R.drawable.ams_tool_frame_color_bg);
            } else {
                int i2 = i - 2;
                Bitmap bitmapDecodeStream = this.f5336a.f5173e[i2];
                if (bitmapDecodeStream == null) {
                    String str = this.f5336a.f5172d[i2];
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 4;
                    bitmapDecodeStream = BitmapFactory.decodeStream(this.f5337b.getAssets().open("bg_org_hp/" + str), null, options);
                }
                imageView.setImageBitmap(bitmapDecodeStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_add);
        if (i == 0) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(4);
        }
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout_none);
        if (i == 1) {
            linearLayout2.setVisibility(0);
        } else {
            linearLayout2.setVisibility(4);
        }
        return view;
    }

    /* renamed from: a */
    public void m5614a() {
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 15;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }
}
