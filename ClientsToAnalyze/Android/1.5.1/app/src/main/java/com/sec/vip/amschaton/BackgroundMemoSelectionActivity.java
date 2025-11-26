package com.sec.vip.amschaton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.sec.chaton.C0062R;
import java.io.IOException;

/* loaded from: classes.dex */
public class BackgroundMemoSelectionActivity extends Activity implements View.OnClickListener, OnApplyListener {

    /* renamed from: b */
    private final String f4128b = "bg_thumb_hp";

    /* renamed from: c */
    private final String f4129c = "memo_bg_%02d.png";

    /* renamed from: d */
    private final int f4130d = 12;

    /* renamed from: e */
    private String[] f4131e = null;

    /* renamed from: f */
    private Bitmap[] f4132f = null;

    /* renamed from: g */
    private int f4133g = 0;

    /* renamed from: h */
    private int f4134h = -16777216;

    /* renamed from: i */
    private MemoGridAdapter f4135i = null;

    /* renamed from: a */
    BackgroundColorSelectionDialog f4127a = null;

    public class MemoGridAdapter extends BaseAdapter {

        /* renamed from: b */
        private Context f4137b;

        public MemoGridAdapter(Context context) {
            this.f4137b = context;
        }

        /* renamed from: a */
        public void m4162a() {
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return BackgroundMemoSelectionActivity.this.f4132f.length;
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
            View viewInflate = view == null ? BackgroundMemoSelectionActivity.this.getLayoutInflater().inflate(C0062R.layout.ams_bg_memo_item, viewGroup, false) : view;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C0062R.id.layout_memo);
            linearLayout.setBackgroundResource(C0062R.drawable.ams_grid_selector_memo);
            ImageView imageView = (ImageView) viewInflate.findViewById(C0062R.id.image_memo);
            try {
                if (BackgroundMemoSelectionActivity.this.f4132f[i] == null) {
                    BackgroundMemoSelectionActivity.this.f4132f[i] = BitmapFactory.decodeStream(this.f4137b.getAssets().open("bg_thumb_hp/" + BackgroundMemoSelectionActivity.this.f4131e[i - 1]));
                }
                imageView.setImageBitmap(BackgroundMemoSelectionActivity.this.f4132f[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(C0062R.id.layout_color_icon);
            if (i == 0) {
                linearLayout2.setVisibility(0);
            } else {
                linearLayout2.setVisibility(4);
            }
            if (i == BackgroundMemoSelectionActivity.this.f4133g) {
                linearLayout.setSelected(true);
            } else {
                linearLayout.setSelected(false);
            }
            return viewInflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4156c() {
        this.f4127a = new BackgroundColorSelectionDialog(this, C0062R.style.AMSCustomDialogTheme);
        this.f4127a.m4142a(this.f4134h);
        this.f4127a.m4143a(this);
        this.f4127a.show();
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: a */
    public boolean mo4160a() {
        return true;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: b */
    public boolean mo4161b() {
        this.f4134h = this.f4127a.m4141a();
        new Canvas(this.f4132f[0]).drawColor(this.f4134h);
        this.f4135i.m4162a();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btn_ok /* 2131427351 */:
                Intent intent = new Intent();
                intent.putExtra("BACKGROUND_INDEX", this.f4133g);
                intent.putExtra("BACKGROUND_COLOR", this.f4134h);
                setResult(-1, intent);
                finish();
                break;
            case C0062R.id.btn_cancel /* 2131427352 */:
                finish();
                break;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.ams_bg_memo_layout);
        Bundle extras = getIntent().getExtras();
        this.f4133g = extras.getInt("BACKGROUND_INDEX", 0);
        this.f4134h = extras.getInt("BACKGROUND_COLOR");
        this.f4131e = new String[12];
        for (int i = 0; i < 12; i++) {
            this.f4131e[i] = String.format("memo_bg_%02d.png", Integer.valueOf(i + 1));
        }
        this.f4132f = new Bitmap[this.f4131e.length + 1];
        this.f4132f[0] = Bitmap.createBitmap(154, 154, Bitmap.Config.ARGB_8888);
        new Canvas(this.f4132f[0]).drawColor(this.f4134h);
        this.f4135i = new MemoGridAdapter(this);
        GridView gridView = (GridView) findViewById(C0062R.id.gridview_memo);
        gridView.setAdapter((ListAdapter) this.f4135i);
        gridView.setSelector(C0062R.drawable.ams_grid_selector_memo);
        gridView.setOnItemClickListener(new C0671br(this));
        ((Button) findViewById(C0062R.id.btn_ok)).setOnClickListener(this);
        ((Button) findViewById(C0062R.id.btn_cancel)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
