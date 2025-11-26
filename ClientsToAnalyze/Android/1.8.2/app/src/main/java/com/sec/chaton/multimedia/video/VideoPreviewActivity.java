package com.sec.chaton.multimedia.video;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1783o;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1797a;
import com.sec.chaton.widget.C1798b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VideoPreviewActivity extends Activity {

    /* renamed from: b */
    private String f3915b;

    /* renamed from: c */
    private Context f3916c;

    /* renamed from: d */
    private ListView f3917d;

    /* renamed from: f */
    private C1798b f3919f;

    /* renamed from: e */
    private Rect f3918e = new Rect();

    /* renamed from: a */
    AdapterView.OnItemClickListener f3914a = new C1056c(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_video_view);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        this.f3916c = this;
        this.f3917d = (ListView) findViewById(R.id.dropdownview);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("URI")) {
                this.f3915b = extras.getString("URI");
            }
            if (this.f3915b != null && extras.getBoolean("playDirectly", false) && C1767bw.m6002a()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(this.f3915b), "video/*");
                intent.putExtra("android.intent.extra.finishOnCompletion", false);
                startActivity(intent);
                finish();
            }
        }
        if (GlobalApplication.m3265f()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1797a(getResources().getString(R.string.save), R.drawable.save));
            arrayList.add(new C1797a(getResources().getString(R.string.cancel), R.drawable.cancel));
            this.f3919f = new C1798b(this, arrayList);
            this.f3917d.setAdapter((ListAdapter) this.f3919f);
            this.f3917d.setOnItemClickListener(this.f3914a);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        setTitle(R.string.media_video);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C1786r.m6061b("videoUri: " + this.f3915b, getClass().getSimpleName());
        ImageView imageView = (ImageView) findViewById(R.id.video_image);
        if (this.f3915b == null || C0452a.f1724c.equals(this.f3915b)) {
            new AlertDialog.Builder(this.f3916c).setMessage(getResources().getString(R.string.media_download_fail)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1054a(this)).create().show();
            return;
        }
        if (this.f3915b.contains("file://")) {
            this.f3915b = this.f3915b.substring(7);
        }
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.f3915b, 1);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.view_play_button);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.chaton_attach_video_play), 110, 110, true);
        Bitmap bitmapCreateScaledBitmap2 = null;
        if (bitmapDecodeResource != null && bitmapCreateVideoThumbnail != null) {
            bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateVideoThumbnail, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), true);
        }
        if (bitmapCreateScaledBitmap2 != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateScaledBitmap2);
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(getResources(), bitmapCreateScaledBitmap);
            bitmapDrawable2.setGravity(17);
            imageView.setImageDrawable(new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable2}));
        } else {
            imageView.setImageResource(R.drawable.view_play_button);
        }
        imageView.setOnClickListener(new ViewOnClickListenerC1055b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4055a() {
        if (!C1767bw.m6002a()) {
            Toast.makeText(getBaseContext(), R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent();
        String strM6032a = C1783o.m6032a(this.f3915b, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//ChatON", this.f3915b.substring(this.f3915b.lastIndexOf("/") + 1));
        if (strM6032a != null) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            intent.putExtra("SAVE", true);
            setResult(-1, intent);
            C1786r.m6061b("SAVE RESULT OK : " + strM6032a, getClass().getSimpleName());
        } else {
            C1786r.m6054a("SAVE RESULT Fail : " + this.f3915b, getClass().getSimpleName());
            intent.putExtra("SAVE", false);
            setResult(-1, intent);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4057b() {
        setResult(0, new Intent());
        finish();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu_more_option, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.actionbar_menu_more_option /* 2131494125 */:
                if (this.f3917d.getVisibility() == 8) {
                    this.f3917d.setVisibility(0);
                    break;
                } else {
                    this.f3917d.setVisibility(8);
                    break;
                }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f3917d != null) {
            this.f3917d.getGlobalVisibleRect(this.f3918e);
            if (this.f3917d.getVisibility() == 0 && !this.f3918e.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f3917d.setVisibility(8);
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
