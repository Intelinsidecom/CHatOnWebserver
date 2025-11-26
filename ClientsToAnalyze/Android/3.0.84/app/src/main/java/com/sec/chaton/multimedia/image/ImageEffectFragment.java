package com.sec.chaton.multimedia.image;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.vip.imagefilter.C3631a;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class ImageEffectFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    private static final String f6884a = ImageEffectFragment.class.getSimpleName();

    /* renamed from: b */
    private String f6885b;

    /* renamed from: c */
    private ImageView f6886c;

    /* renamed from: d */
    private Bitmap f6887d;

    /* renamed from: e */
    private Bitmap f6888e;

    /* renamed from: f */
    private Bitmap f6889f;

    /* renamed from: g */
    private ArrayList<C1879h> f6890g = new ArrayList<>();

    /* renamed from: h */
    private HashMap<EnumC1880i, View> f6891h;

    /* renamed from: i */
    private Toast f6892i;

    /* renamed from: j */
    private Activity f6893j;

    /* renamed from: k */
    private MenuItem f6894k;

    /* renamed from: l */
    private int f6895l;

    /* renamed from: m */
    private int f6896m;

    /* renamed from: n */
    private ProgressDialog f6897n;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f6885b = arguments.getString("filterOrgUri");
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("image uri : " + this.f6885b, f6884a);
        }
        this.f6891h = new HashMap<>();
        this.f6892i = C3641ai.m13210a(this.f6893j, R.string.chat_view_memory_error, 0);
        this.f6897n = (ProgressDialog) new C3263j(this.f6893j).m11487a(R.string.setting_webview_please_wait);
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes;
        View viewInflate = layoutInflater.inflate(R.layout.layout_image_effect, viewGroup, false);
        this.f6886c = (ImageView) viewInflate.findViewById(R.id.effect_image);
        if (this.f6893j != null && (typedArrayObtainStyledAttributes = this.f6893j.getTheme().obtainStyledAttributes(new int[]{R.attr.ftChat11Color, R.attr.ftChat12Color})) != null && typedArrayObtainStyledAttributes.getIndexCount() > 1) {
            this.f6895l = typedArrayObtainStyledAttributes.getColorStateList(typedArrayObtainStyledAttributes.getIndex(0)).getDefaultColor();
            this.f6896m = typedArrayObtainStyledAttributes.getColorStateList(typedArrayObtainStyledAttributes.getIndex(1)).getDefaultColor();
            typedArrayObtainStyledAttributes.recycle();
        }
        m7565a(viewInflate);
        return viewInflate;
    }

    /* renamed from: a */
    private void m7565a(View view) {
        Boolean boolValueOf;
        if (this.f6893j != null) {
            try {
                this.f6887d = BitmapFactory.decodeFile(this.f6885b);
                int attributeInt = new ExifInterface(this.f6885b).getAttributeInt("Orientation", 0);
                Matrix matrix = new Matrix();
                Boolean.valueOf(false);
                if (attributeInt == 6) {
                    boolValueOf = Boolean.valueOf(matrix.postRotate(90.0f));
                } else if (attributeInt == 3) {
                    boolValueOf = Boolean.valueOf(matrix.postRotate(180.0f));
                } else if (attributeInt == 8) {
                    boolValueOf = Boolean.valueOf(matrix.postRotate(270.0f));
                } else {
                    boolValueOf = false;
                }
                if (boolValueOf.booleanValue()) {
                    this.f6887d = Bitmap.createBitmap(this.f6887d, 0, 0, this.f6887d.getWidth(), this.f6887d.getHeight(), matrix, true);
                }
                this.f6886c.setImageBitmap(this.f6887d);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.filter_layout);
                LayoutInflater layoutInflater = (LayoutInflater) this.f6893j.getSystemService("layout_inflater");
                this.f6890g.add(new C1879h(this, EnumC1880i.ORIGINAL, getString(R.string.image_filter_original)));
                this.f6890g.add(new C1879h(this, EnumC1880i.BLUE_WASH, getString(R.string.image_filter_bluewash)));
                this.f6890g.add(new C1879h(this, EnumC1880i.VINTAGE, getString(R.string.image_filter_vintage)));
                this.f6890g.add(new C1879h(this, EnumC1880i.SOFT_GLOW, getString(R.string.image_filter_softglow)));
                this.f6890g.add(new C1879h(this, EnumC1880i.VIVID, getString(R.string.image_filter_vivid)));
                this.f6890g.add(new C1879h(this, EnumC1880i.VIGNETTE, getString(R.string.ams_strarr_effect_image_08)));
                this.f6890g.add(new C1879h(this, EnumC1880i.FADED_COLOR, getString(R.string.image_filter_fadedcolor)));
                this.f6890g.add(new C1879h(this, EnumC1880i.BRIGHT, getString(R.string.ams_strarr_effect_image_03)));
                this.f6890g.add(new C1879h(this, EnumC1880i.RETRO, getString(R.string.image_filter_retro)));
                this.f6890g.add(new C1879h(this, EnumC1880i.CLASSIC, getString(R.string.image_filter_classic)));
                this.f6890g.add(new C1879h(this, EnumC1880i.SEPIA, getString(R.string.ams_strarr_effect_image_10)));
                this.f6890g.add(new C1879h(this, EnumC1880i.GRAY, getString(R.string.ams_strarr_effect_image_05)));
                this.f6890g.add(new C1879h(this, EnumC1880i.FUSAIN, getString(R.string.image_filter_fusain)));
                Iterator<C1879h> it = this.f6890g.iterator();
                while (it.hasNext()) {
                    C1879h next = it.next();
                    View viewInflate = layoutInflater.inflate(R.layout.layout_image_effect_item, (ViewGroup) linearLayout, false);
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.filter_image_view);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.filter_name);
                    textView.setText(next.f7145d);
                    next.f7142a = imageView;
                    next.f7143b = textView;
                    next.f7142a.setContentDescription(next.f7145d);
                    viewInflate.setId(next.f7144c.f7161n);
                    linearLayout.addView(viewInflate);
                    viewInflate.setOnClickListener(this);
                    viewInflate.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1876e(this));
                    new AsyncTaskC1881j(this, viewInflate, this.f6885b).execute(new String[0]);
                }
            } catch (IOException e) {
                C3250y.m11443a(e, f6884a);
                C3641ai.m13210a(this.f6893j, R.string.toast_error, 0).show();
                this.f6893j.setResult(0);
                this.f6893j.finish();
            } catch (OutOfMemoryError e2) {
                this.f6892i.show();
                C3250y.m11443a(e2, f6884a);
                this.f6893j.setResult(0);
                this.f6893j.finish();
            }
        }
    }

    /* renamed from: b */
    private void m7568b() {
        if (!this.f6891h.isEmpty()) {
            for (Map.Entry<EnumC1880i, View> entry : this.f6891h.entrySet()) {
                if (this.f6891h.containsKey(entry.getKey())) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Restart PreviewFilterTask : " + entry.getKey().name(), f6884a);
                    }
                    new AsyncTaskC1881j(this, entry.getValue(), this.f6885b).execute(new String[0]);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* renamed from: c */
    private void m7570c() throws Throwable {
        FileOutputStream fileOutputStream;
        String str;
        if (this.f6893j == null) {
            return;
        }
        File file = new File(this.f6893j.getExternalCacheDir().getAbsolutePath() + "/tempEffect.jpg");
        ?? r1 = this.f6888e;
        try {
            if (r1 != 0) {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileOutputStream = null;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    r1 = 0;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e4) {
                            C3250y.m11443a(e4, f6884a);
                        }
                    }
                    throw th;
                }
                try {
                    this.f6888e.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            C3250y.m11443a(e5, f6884a);
                        }
                    }
                    Intent intent = new Intent();
                    intent.putExtra("filterResultUri", file.getAbsolutePath());
                    this.f6893j.setResult(-1, intent);
                    this.f6893j.finish();
                    r1 = intent;
                } catch (FileNotFoundException e6) {
                    e = e6;
                    C3641ai.m13210a(this.f6893j, R.string.toast_error, 0).show();
                    C3250y.m11443a(e, f6884a);
                    this.f6893j.setResult(0);
                    this.f6893j.finish();
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e7) {
                            e = e7;
                            str = f6884a;
                            C3250y.m11443a(e, str);
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                    C3641ai.m13210a(this.f6893j, R.string.toast_error, 0).show();
                    C3250y.m11443a(e, f6884a);
                    this.f6893j.setResult(0);
                    this.f6893j.finish();
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e9) {
                            e = e9;
                            str = f6884a;
                            C3250y.m11443a(e, str);
                        }
                    }
                } catch (OutOfMemoryError e10) {
                    e = e10;
                    this.f6892i.show();
                    C3250y.m11443a(e, f6884a);
                    this.f6893j.setResult(0);
                    this.f6893j.finish();
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e11) {
                            e = e11;
                            str = f6884a;
                            C3250y.m11443a(e, str);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a() && view != null) {
            m7568b();
            new AsyncTaskC1878g(this, view, this.f6887d).execute(new String[0]);
            this.f6894k.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7571d() {
        Iterator<C1879h> it = this.f6890g.iterator();
        while (it.hasNext()) {
            C1879h next = it.next();
            next.f7142a.setImageDrawable(null);
            next.f7143b.setTextColor(this.f6895l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Object m7563a(EnumC1880i enumC1880i, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                switch (enumC1880i) {
                    case BLUE_WASH:
                        C3631a.m13050x(bitmapCopy);
                        break;
                    case VINTAGE:
                        C3631a.m13044r(bitmapCopy);
                        break;
                    case SOFT_GLOW:
                        C3631a.m13020B(bitmapCopy);
                        break;
                    case VIVID:
                        C3631a.m13040n(bitmapCopy);
                        break;
                    case VIGNETTE:
                        C3631a.m13043q(bitmapCopy);
                        break;
                    case FADED_COLOR:
                        C3631a.m13033g(bitmapCopy);
                        break;
                    case BRIGHT:
                        C3631a.m13029c(bitmapCopy);
                        break;
                    case RETRO:
                        C3631a.m13047u(bitmapCopy);
                        break;
                    case CLASSIC:
                        C3631a.m13019A(bitmapCopy);
                        break;
                    case SEPIA:
                        C3631a.m13031e(bitmapCopy);
                        break;
                    case GRAY:
                        C3631a.m13026a(bitmapCopy);
                        break;
                    case FUSAIN:
                        C3631a.m13024F(bitmapCopy);
                        break;
                }
                return bitmapCopy;
            } catch (Exception e) {
                C3250y.m11443a(e, f6884a);
                return e;
            } catch (OutOfMemoryError e2) {
                C3250y.m11443a(e2, f6884a);
                return e2;
            }
        }
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f6886c != null) {
            this.f6886c.setImageBitmap(null);
        }
        if (this.f6887d != null && !this.f6887d.isRecycled()) {
            this.f6887d.recycle();
        }
        if (this.f6888e != null && !this.f6888e.isRecycled()) {
            this.f6888e.recycle();
        }
        if (this.f6889f != null && !this.f6889f.isRecycled()) {
            this.f6889f.recycle();
        }
        Iterator<C1879h> it = this.f6890g.iterator();
        while (it.hasNext()) {
            C1879h next = it.next();
            next.f7142a.setImageBitmap(null);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) next.f7142a.getBackground();
            if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()) {
                bitmapDrawable.getBitmap().recycle();
            }
        }
        this.f6897n.dismiss();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6893j = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f6893j = null;
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        if (menuItem.getItemId() == 16908332 || menuItem.getItemId() == R.id.menu_cancel) {
            if (this.f6893j != null) {
                this.f6893j.finish();
                return true;
            }
        } else if (menuItem.getItemId() == R.id.menu_done) {
            m7570c();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.cancel_done_menu, menu);
        this.f6894k = menu.findItem(R.id.menu_done);
        this.f6894k.setEnabled(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
