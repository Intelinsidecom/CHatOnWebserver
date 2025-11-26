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
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.vip.imagefilter.C5136a;
import com.sec.widget.C5179v;
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
    private static final String f10183a = ImageEffectFragment.class.getSimpleName();

    /* renamed from: b */
    private String f10184b;

    /* renamed from: c */
    private ImageView f10185c;

    /* renamed from: d */
    private Bitmap f10186d;

    /* renamed from: e */
    private Bitmap f10187e;

    /* renamed from: f */
    private Bitmap f10188f;

    /* renamed from: g */
    private ArrayList<C2849i> f10189g = new ArrayList<>();

    /* renamed from: h */
    private HashMap<EnumC2850j, View> f10190h;

    /* renamed from: i */
    private Toast f10191i;

    /* renamed from: j */
    private Activity f10192j;

    /* renamed from: k */
    private int f10193k;

    /* renamed from: l */
    private int f10194l;

    /* renamed from: m */
    private ProgressDialog f10195m;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f10184b = arguments.getString("filterOrgUri");
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("image uri : " + this.f10184b, f10183a);
        }
        this.f10190h = new HashMap<>();
        this.f10191i = C5179v.m19810a(this.f10192j, R.string.chat_view_memory_error, 0);
        this.f10195m = (ProgressDialog) new C4923p(this.f10192j).m18724a(R.string.setting_webview_please_wait);
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes;
        View viewInflate = layoutInflater.inflate(R.layout.layout_image_effect, viewGroup, false);
        this.f10185c = (ImageView) viewInflate.findViewById(R.id.effect_image);
        if (this.f10192j != null && (typedArrayObtainStyledAttributes = this.f10192j.getTheme().obtainStyledAttributes(new int[]{R.attr.ftChat11Color, R.attr.ftChat12Color})) != null && typedArrayObtainStyledAttributes.getIndexCount() > 1) {
            this.f10193k = typedArrayObtainStyledAttributes.getColorStateList(typedArrayObtainStyledAttributes.getIndex(0)).getDefaultColor();
            this.f10194l = typedArrayObtainStyledAttributes.getColorStateList(typedArrayObtainStyledAttributes.getIndex(1)).getDefaultColor();
            typedArrayObtainStyledAttributes.recycle();
        }
        m11770a(viewInflate);
        return viewInflate;
    }

    /* renamed from: a */
    private void m11770a(View view) {
        Boolean boolValueOf;
        if (this.f10192j != null) {
            try {
                this.f10186d = BitmapFactory.decodeFile(this.f10184b);
                int attributeInt = new ExifInterface(this.f10184b).getAttributeInt("Orientation", 0);
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
                if (this.f10186d != null) {
                    if (boolValueOf.booleanValue()) {
                        this.f10186d = Bitmap.createBitmap(this.f10186d, 0, 0, this.f10186d.getWidth(), this.f10186d.getHeight(), matrix, true);
                    }
                    this.f10185c.setImageBitmap(this.f10186d);
                }
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.filter_layout);
                LayoutInflater layoutInflater = (LayoutInflater) this.f10192j.getSystemService("layout_inflater");
                this.f10189g.add(new C2849i(this, EnumC2850j.ORIGINAL, getString(R.string.image_filter_original)));
                this.f10189g.add(new C2849i(this, EnumC2850j.BLUE_WASH, getString(R.string.image_filter_bluewash)));
                this.f10189g.add(new C2849i(this, EnumC2850j.VINTAGE, getString(R.string.image_filter_vintage)));
                this.f10189g.add(new C2849i(this, EnumC2850j.SOFT_GLOW, getString(R.string.image_filter_softglow)));
                this.f10189g.add(new C2849i(this, EnumC2850j.VIVID, getString(R.string.image_filter_vivid)));
                this.f10189g.add(new C2849i(this, EnumC2850j.VIGNETTE, getString(R.string.ams_strarr_effect_image_08)));
                this.f10189g.add(new C2849i(this, EnumC2850j.FADED_COLOR, getString(R.string.image_filter_fadedcolor)));
                this.f10189g.add(new C2849i(this, EnumC2850j.BRIGHT, getString(R.string.ams_strarr_effect_image_03)));
                this.f10189g.add(new C2849i(this, EnumC2850j.RETRO, getString(R.string.image_filter_retro)));
                this.f10189g.add(new C2849i(this, EnumC2850j.CLASSIC, getString(R.string.image_filter_classic)));
                this.f10189g.add(new C2849i(this, EnumC2850j.SEPIA, getString(R.string.ams_strarr_effect_image_10)));
                this.f10189g.add(new C2849i(this, EnumC2850j.GRAY, getString(R.string.ams_strarr_effect_image_05)));
                this.f10189g.add(new C2849i(this, EnumC2850j.FUSAIN, getString(R.string.image_filter_fusain)));
                Iterator<C2849i> it = this.f10189g.iterator();
                while (it.hasNext()) {
                    C2849i next = it.next();
                    View viewInflate = layoutInflater.inflate(R.layout.layout_image_effect_item, (ViewGroup) linearLayout, false);
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.filter_image_view);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.filter_name);
                    textView.setText(next.f10466d);
                    next.f10463a = imageView;
                    next.f10464b = textView;
                    next.f10463a.setContentDescription(next.f10466d);
                    viewInflate.setId(next.f10465c.f10482n);
                    linearLayout.addView(viewInflate);
                    viewInflate.setOnClickListener(this);
                    viewInflate.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2846f(this));
                    new AsyncTaskC2851k(this, viewInflate, this.f10184b, null).execute(new String[0]);
                }
                C2849i c2849i = this.f10189g.get(0);
                if (c2849i.f10465c == EnumC2850j.ORIGINAL) {
                    c2849i.f10464b.setTextColor(this.f10194l);
                    c2849i.f10463a.setImageResource(R.drawable.gridview_selector_focused);
                    if (this.f10186d != null) {
                        this.f10187e = this.f10186d.copy(Bitmap.Config.ARGB_8888, true);
                    }
                }
            } catch (IOException e) {
                C4904y.m18635a(e, f10183a);
                C5179v.m19810a(this.f10192j, R.string.toast_error, 0).show();
                this.f10192j.setResult(0);
                this.f10192j.finish();
            } catch (OutOfMemoryError e2) {
                this.f10191i.show();
                C4904y.m18635a(e2, f10183a);
                this.f10192j.setResult(0);
                this.f10192j.finish();
            }
        }
    }

    /* renamed from: b */
    private void m11773b() {
        if (!this.f10190h.isEmpty()) {
            for (Map.Entry<EnumC2850j, View> entry : this.f10190h.entrySet()) {
                if (this.f10190h.containsKey(entry.getKey())) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Restart PreviewFilterTask : " + entry.getKey().name(), f10183a);
                    }
                    new AsyncTaskC2851k(this, entry.getValue(), this.f10184b, null).execute(new String[0]);
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
    private void m11775c() throws Throwable {
        FileOutputStream fileOutputStream;
        String str;
        if (this.f10192j == null) {
            return;
        }
        File file = new File(this.f10192j.getExternalCacheDir().getAbsolutePath() + "/tempEffect.jpg");
        ?? r1 = this.f10187e;
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
                            C4904y.m18635a(e4, f10183a);
                        }
                    }
                    throw th;
                }
                try {
                    this.f10187e.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            C4904y.m18635a(e5, f10183a);
                        }
                    }
                    Intent intent = new Intent();
                    intent.putExtra("filterResultUri", file.getAbsolutePath());
                    this.f10192j.setResult(-1, intent);
                    this.f10192j.finish();
                    r1 = intent;
                } catch (FileNotFoundException e6) {
                    e = e6;
                    C5179v.m19810a(this.f10192j, R.string.toast_error, 0).show();
                    C4904y.m18635a(e, f10183a);
                    this.f10192j.setResult(0);
                    this.f10192j.finish();
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e7) {
                            e = e7;
                            str = f10183a;
                            C4904y.m18635a(e, str);
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                    C5179v.m19810a(this.f10192j, R.string.toast_error, 0).show();
                    C4904y.m18635a(e, f10183a);
                    this.f10192j.setResult(0);
                    this.f10192j.finish();
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e9) {
                            e = e9;
                            str = f10183a;
                            C4904y.m18635a(e, str);
                        }
                    }
                } catch (OutOfMemoryError e10) {
                    e = e10;
                    this.f10191i.show();
                    C4904y.m18635a(e, f10183a);
                    this.f10192j.setResult(0);
                    this.f10192j.finish();
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e11) {
                            e = e11;
                            str = f10183a;
                            C4904y.m18635a(e, str);
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
        if (!C4847bl.m18333a() && view != null) {
            m11773b();
            new AsyncTaskC2848h(this, view, this.f10186d, null).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m11776d() {
        Iterator<C2849i> it = this.f10189g.iterator();
        while (it.hasNext()) {
            C2849i next = it.next();
            next.f10463a.setImageDrawable(null);
            next.f10464b.setTextColor(this.f10193k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Object m11768a(EnumC2850j enumC2850j, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                switch (enumC2850j) {
                    case BLUE_WASH:
                        C5136a.m19609i(bitmapCopy);
                        break;
                    case VINTAGE:
                        C5136a.m19607g(bitmapCopy);
                        break;
                    case SOFT_GLOW:
                        C5136a.m19611k(bitmapCopy);
                        break;
                    case VIVID:
                        C5136a.m19605e(bitmapCopy);
                        break;
                    case VIGNETTE:
                        C5136a.m19606f(bitmapCopy);
                        break;
                    case FADED_COLOR:
                        C5136a.m19604d(bitmapCopy);
                        break;
                    case BRIGHT:
                        C5136a.m19602b(bitmapCopy);
                        break;
                    case RETRO:
                        C5136a.m19608h(bitmapCopy);
                        break;
                    case CLASSIC:
                        C5136a.m19610j(bitmapCopy);
                        break;
                    case SEPIA:
                        C5136a.m19603c(bitmapCopy);
                        break;
                    case GRAY:
                        C5136a.m19601a(bitmapCopy);
                        break;
                    case FUSAIN:
                        C5136a.m19612l(bitmapCopy);
                        break;
                }
                return bitmapCopy;
            } catch (Exception e) {
                C4904y.m18635a(e, f10183a);
                return e;
            } catch (OutOfMemoryError e2) {
                C4904y.m18635a(e2, f10183a);
                return e2;
            }
        }
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f10185c != null) {
            this.f10185c.setImageBitmap(null);
        }
        if (this.f10186d != null && !this.f10186d.isRecycled()) {
            this.f10186d.recycle();
        }
        if (this.f10187e != null && !this.f10187e.isRecycled()) {
            this.f10187e.recycle();
        }
        if (this.f10188f != null && !this.f10188f.isRecycled()) {
            this.f10188f.recycle();
        }
        Iterator<C2849i> it = this.f10189g.iterator();
        while (it.hasNext()) {
            C2849i next = it.next();
            next.f10463a.setImageBitmap(null);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) next.f10463a.getBackground();
            if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()) {
                bitmapDrawable.getBitmap().recycle();
            }
        }
        this.f10195m.dismiss();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10192j = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10192j = null;
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        if (menuItem.getItemId() == 16908332 || menuItem.getItemId() == R.id.menu_cancel) {
            if (this.f10192j != null) {
                this.f10192j.finish();
                return true;
            }
        } else if (menuItem.getItemId() == R.id.menu_done) {
            m11775c();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.cancel_done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
