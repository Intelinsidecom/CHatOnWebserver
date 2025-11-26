package com.sec.vip.amschaton;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;
import com.sec.vip.cropimage.CropImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSComposerActivity extends AMSActivity implements View.OnClickListener, InterfaceC0641ao, InterfaceC0715r {

    /* renamed from: a */
    public static boolean f3824a = true;

    /* renamed from: A */
    private ImageView f3825A;

    /* renamed from: B */
    private ImageView f3826B;

    /* renamed from: C */
    private ImageView f3827C;

    /* renamed from: D */
    private ImageView f3828D;

    /* renamed from: E */
    private ImageView f3829E;

    /* renamed from: F */
    private PopupWindow f3830F;

    /* renamed from: G */
    private AMSDrawManager f3831G;

    /* renamed from: T */
    private String f3844T;

    /* renamed from: W */
    private AMSPenSelectionDialog f3847W;

    /* renamed from: X */
    private AMSTextSelectionDialog f3848X;

    /* renamed from: Y */
    private AMSFigureSelectionDialog f3849Y;

    /* renamed from: Z */
    private AMSStampSelectionDialog f3850Z;

    /* renamed from: aa */
    private AMSEraserSelectionDialog f3851aa;

    /* renamed from: c */
    private ImageView f3860c;

    /* renamed from: d */
    private ImageView f3861d;

    /* renamed from: m */
    private ImageView f3862m;

    /* renamed from: n */
    private ImageView f3863n;

    /* renamed from: o */
    private ImageView f3864o;

    /* renamed from: p */
    private ImageView f3865p;

    /* renamed from: q */
    private ImageView f3866q;

    /* renamed from: r */
    private ImageView f3867r;

    /* renamed from: s */
    private ImageView f3868s;

    /* renamed from: t */
    private ImageView f3869t;

    /* renamed from: u */
    private ImageView f3870u;

    /* renamed from: v */
    private ImageView f3871v;

    /* renamed from: w */
    private ImageView f3872w;

    /* renamed from: x */
    private ImageView f3873x;

    /* renamed from: y */
    private ImageView f3874y;

    /* renamed from: z */
    private ImageView f3875z;

    /* renamed from: b */
    private float f3859b = 1.0f;

    /* renamed from: H */
    private int f3832H = MsgResultCode.UNKNOWN_MESSAGE_TYPE;

    /* renamed from: I */
    private int f3833I = MsgResultCode.INTERNAL_SERVER_ERROR;

    /* renamed from: J */
    private int f3834J = 0;

    /* renamed from: K */
    private int[] f3835K = null;

    /* renamed from: L */
    private int[] f3836L = null;

    /* renamed from: M */
    private int f3837M = -7829368;

    /* renamed from: N */
    private int f3838N = 2;

    /* renamed from: O */
    private TextInputDialog f3839O = null;

    /* renamed from: P */
    private int f3840P = 3;

    /* renamed from: Q */
    private int f3841Q = -7829368;

    /* renamed from: R */
    private int f3842R = 3;

    /* renamed from: S */
    private int f3843S = 0;

    /* renamed from: U */
    private boolean f3845U = true;

    /* renamed from: V */
    private boolean f3846V = false;

    /* renamed from: ab */
    private int f3852ab = 0;

    /* renamed from: ac */
    private String f3853ac = "";

    /* renamed from: ad */
    private int f3854ad = -1;

    /* renamed from: ae */
    private int f3855ae = 0;

    /* renamed from: af */
    private int f3856af = 10;

    /* renamed from: ag */
    private final InterfaceC0702e f3857ag = new C0674bu(this);

    /* renamed from: ah */
    private Handler f3858ah = new HandlerC0693cm(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m3724A() {
        if (m3766b(true)) {
            Intent intent = new Intent(this, (Class<?>) BackgroundAudioRecordActivity.class);
            intent.putExtra("AMS_FILE_PATH", f3813j);
            startActivityForResult(intent, 6);
        }
    }

    /* renamed from: B */
    private void m3726B() {
        if (m3766b(false)) {
            Intent intent = new Intent(this, (Class<?>) AMSPlayerActivity.class);
            intent.putExtra("VIEWER_MODE", 1001);
            intent.putExtra("AMS_FILE_PATH", f3813j);
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m3728C() throws IOException {
        if (this.f3831G == null) {
            return;
        }
        this.f3831G.m3829a();
        m3768c(9);
        this.f3831G.invalidate();
        this.f3853ac = "";
        m3801r();
        m3799q();
        this.f3827C.setVisibility(4);
        this.f3846V = false;
    }

    /* renamed from: D */
    private void m3729D() {
        if (this.f3831G == null) {
            return;
        }
        if (this.f3831G.m3827B()) {
            new AlertDialog.Builder(this).setTitle(C0062R.string.ams_title_send).setSingleChoiceItems(C0062R.array.ams_strarr_sending_mode, 0, new DialogInterfaceOnClickListenerC0686cf(this)).setPositiveButton(C0062R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC0695co(this)).setNegativeButton(C0062R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC0696cp(this)).create().show();
        } else {
            Toast.makeText(this, C0062R.string.ams_msg_empty_ams, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m3731E() {
        String str = f3810g + m3749a("A", System.currentTimeMillis(), ".jpg");
        if (!this.f3831G.m3838a(str)) {
            Toast.makeText(this, C0062R.string.ams_error_ams_file_save, 0).show();
            return;
        }
        File file = new File(str);
        if (file.length() < 1048576) {
            m3764b(str);
        } else {
            new AlertDialog.Builder(this).setTitle(C0062R.string.ams_btn_send).setMessage(String.format("%s\n(%d/%d)", getResources().getString(C0062R.string.ams_msg_exceed_limit), Long.valueOf(file.length()), 1048576)).setPositiveButton(C0062R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC0689ci(this)).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.graphics.Bitmap$CompressFormat] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: F */
    public void m3734F() throws Throwable {
        FileOutputStream fileOutputStream;
        String str = f3815l + m3749a("I", System.currentTimeMillis(), ".jpg");
        if (!this.f3831G.m3852j()) {
            return;
        }
        Bitmap bitmapM3851i = this.f3831G.m3851i();
        if (bitmapM3851i == null) {
            ChatONLogWriter.m3499a("Bitmap main is null", getClass().getSimpleName());
            return;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapM3851i, 480, 480, true);
        FileOutputStream fileOutputStream2 = null;
         = 0;
        ?? r2 = 0;
        try {
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(str);
                try {
                    r2 = Bitmap.CompressFormat.JPEG;
                    bitmapCreateScaledBitmap.compress(r2, 80, fileOutputStream3);
                    bitmapCreateScaledBitmap.recycle();
                    fileOutputStream3.flush();
                    fileOutputStream3.close();
                    fileOutputStream2 = r2;
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.close();
                            fileOutputStream2 = r2;
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            fileOutputStream2 = r2;
                            m3764b(str);
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    r2 = fileOutputStream3;
                    e.printStackTrace();
                    fileOutputStream2 = r2;
                    if (r2 != 0) {
                        try {
                            r2.close();
                            fileOutputStream2 = r2;
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            fileOutputStream2 = r2;
                            m3764b(str);
                        }
                    }
                    m3764b(str);
                } catch (IOException e4) {
                    e = e4;
                    r2 = fileOutputStream3;
                    e.printStackTrace();
                    fileOutputStream2 = r2;
                    if (r2 != 0) {
                        try {
                            r2.close();
                            fileOutputStream2 = r2;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            fileOutputStream2 = r2;
                            m3764b(str);
                        }
                    }
                    m3764b(str);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
            } catch (IOException e8) {
                e = e8;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            m3764b(str);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = fileOutputStream2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public Context m3735G() {
        return this;
    }

    /* renamed from: H */
    private boolean m3738H() {
        new String();
        String strM3749a = (this.f3853ac.length() <= 0 || !m3770c(this.f3853ac)) ? m3749a("A", System.currentTimeMillis(), "") : this.f3853ac;
        this.f3839O = new TextInputDialog(this, C0062R.style.AMSCustomDialogTheme, 64);
        this.f3839O.setTitle(C0062R.string.ams_title_save);
        this.f3839O.m4181a(strM3749a);
        this.f3839O.m4183b("\\/:*?\"<>|");
        this.f3839O.m4180a(new C0690cj(this));
        this.f3839O.show();
        m3756a(this.f3839O);
        return true;
    }

    /* renamed from: I */
    private void m3739I() {
        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 1);
        this.f3832H = sharedPreferences.getInt("AMS_TOOL_TYPE", MsgResultCode.UNKNOWN_MESSAGE_TYPE);
        this.f3834J = sharedPreferences.getInt("AMS_PEN_STYLE", 0);
        this.f3835K[0] = sharedPreferences.getInt("AMS_PEN_LINE_COLOR", -7829368);
        this.f3835K[1] = sharedPreferences.getInt("AMS_PEN_BLUR_COLOR", -7829368);
        this.f3835K[2] = sharedPreferences.getInt("AMS_CPEN_MARKER_COLOR", -7829368);
        this.f3835K[3] = sharedPreferences.getInt("AMS_PEN_DOT_COLOR", -7829368);
        this.f3836L[0] = sharedPreferences.getInt("AMS_PEN_LINE", 3);
        this.f3836L[1] = sharedPreferences.getInt("AMS_PEN_BLUR_SIZE", 3);
        this.f3836L[2] = sharedPreferences.getInt("AMS_PEN_MARKER_SIZE", 3);
        this.f3836L[3] = sharedPreferences.getInt("AMS_PEN_DOT_SIZE", 3);
        this.f3836L[4] = sharedPreferences.getInt("AMS_PEN_ERASER_SIZE", 5);
        this.f3840P = sharedPreferences.getInt("AMS_FIGURE_STYLE", 3);
        this.f3841Q = sharedPreferences.getInt("AMS_FITURE_COLOR", -7829368);
        this.f3842R = sharedPreferences.getInt("AMS_FIGURE_SIZE", 3);
        this.f3838N = sharedPreferences.getInt("AMS_TEXT_SIZE", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public void m3740J() {
        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 3);
        sharedPreferences.edit().putInt("AMS_TOOL_TYPE", this.f3832H).commit();
        sharedPreferences.edit().putInt("AMS_PEN_STYLE", this.f3834J).commit();
        sharedPreferences.edit().putInt("AMS_PEN_LINE_COLOR", this.f3835K[0]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_BLUR_COLOR", this.f3835K[1]).commit();
        sharedPreferences.edit().putInt("AMS_CPEN_MARKER_COLOR", this.f3835K[2]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_DOT_COLOR", this.f3835K[3]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_ERASER_COLOR", this.f3835K[4]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_LINE", this.f3836L[0]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_BLUR_SIZE", this.f3836L[1]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_MARKER_SIZE", this.f3836L[2]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_DOT_SIZE", this.f3836L[3]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_ERASER_SIZE", this.f3836L[4]).commit();
        sharedPreferences.edit().putInt("AMS_FIGURE_STYLE", this.f3840P).commit();
        sharedPreferences.edit().putInt("AMS_FITURE_COLOR", this.f3841Q).commit();
        sharedPreferences.edit().putInt("AMS_FIGURE_SIZE", this.f3842R).commit();
        sharedPreferences.edit().putInt("AMS_TEXT_SIZE", this.f3838N).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m3741K() {
        this.f3861d.setImageDrawable(m3760b(1, this.f3834J, this.f3835K[this.f3834J], this.f3836L[this.f3834J]));
        this.f3831G.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public Bitmap m3743a(int i, int i2, int i3, int i4) {
        Paint paint = new Paint();
        paint.setTextSize(12.0f * getResources().getDisplayMetrics().density);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setDither(true);
        int i5 = (int) (80.0f * this.f3859b);
        int i6 = (int) (80.0f * this.f3859b);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawARGB(0, 0, 0, 0);
        switch (i) {
            case 1:
                AMSObjectLine aMSObjectLine = new AMSObjectLine(i2, i3, i4);
                aMSObjectLine.m3957a(bitmapCreateBitmap);
                aMSObjectLine.mo3963a((float) (i5 * 0.3d), (float) (i6 * 0.8d), (float) (i5 * 0.7d), (float) (i6 * 0.8d), 255);
                return bitmapCreateBitmap;
            case 2:
            case 3:
            default:
                return bitmapCreateBitmap;
            case 4:
                AMSObjectDrawings aMSObjectDrawings = new AMSObjectDrawings(i2, i3, i4);
                aMSObjectDrawings.m3957a(bitmapCreateBitmap);
                aMSObjectDrawings.mo3954a(this.f3859b * 2.0f);
                aMSObjectDrawings.mo3963a((float) (i5 * 0.25d), (float) (i6 * 0.25d), (float) (i5 * 0.75d), (float) (i6 * 0.75d), 255);
                return bitmapCreateBitmap;
        }
    }

    /* renamed from: a */
    private Bitmap m3744a(Intent intent, Bundle bundle) {
        Bitmap bitmap;
        if (bundle.getBoolean("exceed_size", true)) {
            ChatONLogWriter.m3506b("[getBitmapFromExtras] exceed_size is true!", getClass().getSimpleName());
            String string = bundle.getString("temp_file_path");
            if (string == null) {
                return null;
            }
            ChatONLogWriter.m3506b("tmpFilePath : " + string, getClass().getSimpleName());
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(string);
            if (bitmapDecodeFile == null) {
                return null;
            }
            File file = new File(string);
            if (file.exists()) {
                file.delete();
            }
            bitmap = bitmapDecodeFile;
        } else {
            ChatONLogWriter.m3506b("[getBitmapFromExtras] exceed_size is false!", getClass().getSimpleName());
            bitmap = (Bitmap) bundle.getParcelable("data");
        }
        ChatONLogWriter.m3506b("[getBitmapFromExtras] bmp width and height : " + bitmap.getWidth() + "," + bitmap.getHeight(), getClass().getSimpleName());
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m3749a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: a */
    private void m3750a() throws IOException {
        this.f3831G.setEditMode(false, false);
        this.f3832H = MsgResultCode.INTERNAL_SERVER_ERROR;
        m3751a(this.f3832H);
        this.f3865p.setEnabled(true);
        if (this.f3833I != this.f3832H) {
            this.f3831G.m3833a(1, this.f3834J, this.f3835K[this.f3834J], this.f3836L[this.f3834J]);
            this.f3833I = this.f3832H;
            return;
        }
        this.f3833I = this.f3832H;
        this.f3847W = new AMSPenSelectionDialog(this, C0062R.style.AMSCustomDialogTheme);
        this.f3847W.m4004a(this.f3834J);
        this.f3847W.m4005a(this.f3835K);
        this.f3847W.m4007b(this.f3835K[this.f3834J]);
        this.f3847W.m4008b(this.f3836L);
        this.f3847W.m4108a(new C0678by(this));
        this.f3847W.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3751a(int i) {
        int[] iArr = {MsgResultCode.INTERNAL_SERVER_ERROR, MsgResultCode.INTERRUPTED, 2004, 2005, MsgResultCode.UNEXPECTED_MESSAGE, 2006, 2007};
        ImageView[] imageViewArr = {this.f3861d, this.f3862m, this.f3863n, this.f3863n, this.f3860c, this.f3864o, this.f3865p};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(false);
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i) {
                imageViewArr[i3].setSelected(true);
            }
        }
    }

    /* renamed from: a */
    private void m3752a(Context context, int i, int i2) throws Resources.NotFoundException {
        Toast toastMakeText = Toast.makeText(context, i, i2);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.show();
    }

    /* renamed from: a */
    private void m3753a(Bitmap bitmap) throws IOException {
        this.f3831G.m3836a(bitmap, true);
        this.f3831G.setEditMode(false, true);
        this.f3831G.invalidate();
        this.f3865p.setEnabled(true);
    }

    /* renamed from: a */
    private void m3754a(Uri uri) {
        Intent intent = new Intent(this, (Class<?>) CropImage.class);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("outputX", 120);
        intent.putExtra("outputY", 120);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("template", true);
        intent.putExtra("effect", false);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 9);
    }

    /* renamed from: a */
    private void m3756a(TextInputDialog textInputDialog) {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(textInputDialog.m4182b(), 2);
        textInputDialog.m4182b().setOnFocusChangeListener(new ViewOnFocusChangeListenerC0687cg(this, textInputDialog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3758a(boolean z) {
        this.f3832H = this.f3833I;
        if (z) {
            new Handler().postDelayed(new RunnableC0691ck(this), 1000L);
        } else {
            this.f3830F.dismiss();
            m3751a(this.f3832H);
            if (this.f3832H == 2002) {
                this.f3865p.setEnabled(true);
            }
        }
        return true;
    }

    /* renamed from: b */
    private Drawable m3760b(int i, int i2, int i3, int i4) throws Resources.NotFoundException {
        Drawable drawable;
        Drawable drawable2;
        if (i != 1) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        int i5 = (int) (80.0f * this.f3859b);
        int i6 = (int) (80.0f * this.f3859b);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
        switch (i2) {
            case 1:
                drawable = getResources().getDrawable(C0062R.drawable.button_crayon_normal);
                drawable2 = getResources().getDrawable(C0062R.drawable.button_crayon_pressed);
                break;
            case 2:
                drawable = getResources().getDrawable(C0062R.drawable.button_marker_normal);
                drawable2 = getResources().getDrawable(C0062R.drawable.button_marker_pressed);
                break;
            default:
                drawable = getResources().getDrawable(C0062R.drawable.button_pen_normal);
                drawable2 = getResources().getDrawable(C0062R.drawable.button_pen_pressed);
                break;
        }
        drawable.setBounds(new Rect(0, 0, i5, i6));
        drawable.draw(canvas);
        drawable2.setBounds(new Rect(0, 0, i5, i6));
        drawable2.draw(canvas2);
        AMSObjectLine aMSObjectLine = new AMSObjectLine(i2, i3, i4);
        aMSObjectLine.m3957a(bitmapCreateBitmap);
        aMSObjectLine.mo3954a(this.f3859b * 2.0f);
        aMSObjectLine.mo3963a((float) (i5 * 0.2d), (float) (i6 * 0.8d), (float) (i5 * 0.8d), (float) (i6 * 0.8d), 255);
        aMSObjectLine.m3957a(bitmapCreateBitmap2);
        aMSObjectLine.mo3954a(this.f3859b * 2.0f);
        aMSObjectLine.mo3963a((float) (i5 * 0.2d), (float) (i6 * 0.8d), (float) (i5 * 0.8d), (float) (i6 * 0.8d), 255);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
        bitmapDrawable.setTargetDensity(bitmapCreateBitmap.getDensity());
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap2);
        bitmapDrawable2.setTargetDensity(bitmapCreateBitmap2.getDensity());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, bitmapDrawable);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, bitmapDrawable2);
        return stateListDrawable;
    }

    /* renamed from: b */
    private View m3761b(int i) {
        this.f3830F = new PopupWindow(this);
        this.f3830F.setOnDismissListener(new C0692cl(this));
        this.f3830F.setBackgroundDrawable(new BitmapDrawable());
        this.f3830F.setWidth(-2);
        this.f3830F.setHeight(-2);
        this.f3830F.setTouchable(true);
        this.f3830F.setFocusable(true);
        this.f3830F.setOutsideTouchable(true);
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
        this.f3830F.setContentView(viewGroup);
        viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        viewGroup.measure(-2, -2);
        return viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3762b(Uri uri) {
        Intent intent = new Intent(this, (Class<?>) CropImage.class);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("outputX", 240);
        intent.putExtra("outputY", 240);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("template", false);
        intent.putExtra("effect", true);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 7);
    }

    /* renamed from: b */
    private void m3764b(String str) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("AMS_FILE_PATH", str);
        startActivity(intent);
    }

    /* renamed from: b */
    private boolean m3766b(boolean z) throws IOException {
        if (this.f3831G == null) {
            ChatONLogWriter.m3499a("[startAMSPreview] mAMSComposer is NULL!", getClass().getSimpleName());
            return false;
        }
        if (!z && !this.f3831G.m3827B()) {
            ChatONLogWriter.m3499a("[startAMSPreview] Empty AMS file!", getClass().getSimpleName());
            return false;
        }
        File file = new File(f3813j);
        if (file.exists()) {
            file.delete();
        }
        if (this.f3831G.m3838a(f3813j)) {
            this.f3831G.setEditMode(false, false);
            return true;
        }
        ChatONLogWriter.m3499a("[startAMSPreview] Fail to save AMS file!", getClass().getSimpleName());
        return false;
    }

    /* renamed from: c */
    private void m3768c(int i) throws IOException {
        this.f3831G.m3835a(i, true);
        this.f3831G.setEditMode(false, true);
        this.f3831G.invalidate();
        this.f3865p.setEnabled(true);
    }

    /* renamed from: c */
    private boolean m3770c(String str) {
        String[] list = new File(f3810g).list();
        if (list == null) {
            return false;
        }
        String str2 = str + ".jpg";
        for (String str3 : list) {
            if (str2.equals(str3)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    private void m3783i() throws IOException {
        this.f3832H = MsgResultCode.INTERRUPTED;
        m3751a(this.f3832H);
        if (this.f3833I != 2003) {
            this.f3831G.setEditMode(false, false);
            this.f3865p.setEnabled(false);
            this.f3831G.m3833a(2, 0, this.f3837M, this.f3838N);
            this.f3833I = this.f3832H;
            return;
        }
        this.f3833I = this.f3832H;
        this.f3848X = new AMSTextSelectionDialog(this, C0062R.style.AMSCustomDialogTheme);
        this.f3848X.m4105a(this.f3837M);
        this.f3848X.m4107b(this.f3838N);
        this.f3848X.m4108a(new C0676bw(this));
        this.f3848X.show();
    }

    /* renamed from: j */
    private void m3784j() throws IOException {
        this.f3832H = 2004;
        m3751a(this.f3832H);
        if (this.f3833I != 2004) {
            this.f3831G.setEditMode(false, false);
            this.f3865p.setEnabled(false);
        }
        this.f3833I = this.f3832H;
        this.f3849Y = new AMSFigureSelectionDialog(this, C0062R.style.AMSCustomDialogTheme);
        this.f3849Y.m3891a(this.f3840P);
        this.f3849Y.m3893b(this.f3841Q);
        this.f3849Y.m3896d(this.f3842R);
        this.f3849Y.m4108a(new C0682cb(this));
        this.f3849Y.setOnShowListener(new DialogInterfaceOnShowListenerC0683cc(this));
        this.f3852ab = 1;
        this.f3849Y.show();
    }

    /* renamed from: k */
    private void m3787k() throws IOException {
        this.f3832H = 2005;
        m3751a(this.f3832H);
        this.f3831G.setEditMode(false, false);
        this.f3865p.setEnabled(false);
        this.f3833I = this.f3832H;
        this.f3850Z = new AMSStampSelectionDialog(this, C0062R.style.AMSCustomDialogTheme);
        this.f3850Z.m4083a(this.f3843S);
        this.f3850Z.m4108a(new C0684cd(this));
        this.f3850Z.setOnShowListener(new DialogInterfaceOnShowListenerC0685ce(this));
        this.f3850Z.m4084a(this.f3857ag);
        this.f3850Z.show();
        this.f3852ab = 2;
    }

    /* renamed from: l */
    private void m3789l() throws IOException {
        this.f3832H = 2007;
        m3751a(this.f3832H);
        this.f3831G.setEditMode(false, false);
        if (this.f3833I != this.f3832H) {
            this.f3831G.m3833a(1, 4, this.f3835K[this.f3834J], this.f3836L[4]);
            this.f3833I = this.f3832H;
            return;
        }
        this.f3833I = this.f3832H;
        this.f3851aa = new AMSEraserSelectionDialog(this, C0062R.style.AMSCustomDialogTheme);
        this.f3851aa.m3872a(this.f3836L[4]);
        this.f3851aa.m4108a(new C0694cn(this));
        this.f3851aa.show();
    }

    /* renamed from: m */
    private void m3791m() throws Resources.NotFoundException, IOException {
        this.f3831G.m3860r();
        m3799q();
        m3801r();
        m3752a(this, C0062R.string.ams_msg_add_page, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m3793n() throws IOException {
        this.f3831G.m3861s();
        m3799q();
        m3801r();
    }

    /* renamed from: o */
    private void m3795o() throws IOException {
        this.f3831G.m3862t();
        this.f3831G.m3852j();
        this.f3831G.invalidate();
        m3799q();
    }

    /* renamed from: p */
    private void m3797p() throws IOException {
        this.f3831G.m3863u();
        this.f3831G.m3852j();
        this.f3831G.invalidate();
        m3799q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m3799q() {
        int iM3865w = this.f3831G.m3865w();
        ((RelativeLayout) findViewById(C0062R.id.layout_page_navigator)).setVisibility(0);
        int iM3866x = this.f3831G.m3866x();
        ChatONLogWriter.m3506b(String.format("%d/%d", Integer.valueOf(iM3866x), Integer.valueOf(iM3865w)), getClass().getSimpleName());
        LinearLayout linearLayout = (LinearLayout) findViewById(C0062R.id.layout_page_index);
        linearLayout.removeAllViews();
        for (int i = 0; i <= iM3865w; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            if (iM3866x == i) {
                imageView.setImageResource(C0062R.drawable.button_navi_select);
            } else {
                imageView.setImageResource(C0062R.drawable.button_navi_unselect);
            }
            linearLayout.addView(imageView);
            if (i < iM3865w) {
                LinearLayout linearLayout2 = new LinearLayout(this);
                linearLayout2.setLayoutParams(new ViewGroup.LayoutParams((int) (21.0f * this.f3859b), -1));
                linearLayout.addView(linearLayout2);
            }
        }
        ImageView imageView2 = (ImageView) findViewById(C0062R.id.btn_prev);
        ImageView imageView3 = (ImageView) findViewById(C0062R.id.btn_next);
        int i2 = iM3866x == 0 ? 4 : 0;
        int i3 = iM3866x == iM3865w ? 4 : 0;
        imageView2.setVisibility(i2);
        imageView3.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m3801r() {
        if (this.f3831G.m3865w() < 9) {
            this.f3866q.setEnabled(true);
        } else {
            this.f3866q.setEnabled(false);
        }
        if (!this.f3867r.isEnabled() && this.f3831G.m3867y()) {
            this.f3867r.setEnabled(true);
        } else if (this.f3867r.isEnabled() && !this.f3831G.m3867y()) {
            this.f3867r.setEnabled(false);
        }
        if (!this.f3868s.isEnabled() && this.f3831G.m3868z()) {
            this.f3868s.setEnabled(true);
        } else if (this.f3868s.isEnabled() && !this.f3831G.m3868z()) {
            this.f3868s.setEnabled(false);
        }
        if (!this.f3869t.isEnabled() && this.f3831G.m3827B()) {
            this.f3869t.setEnabled(true);
            this.f3870u.setEnabled(true);
        } else if (this.f3869t.isEnabled() && !this.f3831G.m3827B()) {
            this.f3869t.setEnabled(false);
            this.f3870u.setEnabled(false);
        }
        if (this.f3865p.isEnabled() && this.f3831G.m3841b() != 1 && this.f3831G.m3850h() == null) {
            this.f3865p.setEnabled(false);
        }
    }

    /* renamed from: s */
    private void m3803s() throws IOException {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        ChatONLogWriter.m3506b("[setComposerLayout] Composer Size = " + width, getClass().getSimpleName());
        this.f3831G = new AMSDrawManager(this, width, width);
        this.f3831G.m3829a();
        this.f3831G.setEnableZoom(false);
        this.f3831G.setPlayMode(false);
        this.f3831G.setOnTextInputRequestListener(this);
        this.f3831G.setOnObjectListener(this);
        this.f3853ac = "";
        m3768c(this.f3856af - 1);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0062R.id.layout_ams);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(width, width));
        relativeLayout.addView(this.f3831G);
        int[] iArr = {C0062R.drawable.ams_basic_selector_move_left, C0062R.drawable.ams_basic_selector_move_top, C0062R.drawable.ams_basic_selector_move_right, C0062R.drawable.ams_basic_selector_move_bottom};
        int[][] iArr2 = {new int[]{9, 15}, new int[]{10, 14}, new int[]{11, 15}, new int[]{12, 14}};
        ImageView[] imageViewArr = new ImageView[4];
        for (int i = 0; i < 4; i++) {
            imageViewArr[i] = new ImageView(this);
            imageViewArr[i].setBackgroundResource(iArr[i]);
            imageViewArr[i].setAlpha(128);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(iArr2[i][0]);
            layoutParams.addRule(iArr2[i][1]);
            imageViewArr[i].setLayoutParams(layoutParams);
            this.f3831G.setMoveDirectionButtonView(imageViewArr[i], i);
            relativeLayout.addView(imageViewArr[i]);
        }
        linearLayout.addView(relativeLayout);
    }

    /* renamed from: t */
    private void m3805t() throws IOException {
        this.f3832H = MsgResultCode.UNEXPECTED_MESSAGE;
        m3751a(this.f3832H);
        this.f3831G.setEditMode(false, true);
        this.f3865p.setEnabled(false);
        View viewM3761b = m3761b(C0062R.layout.ams_bg_image_popup_layout);
        this.f3871v = (ImageView) viewM3761b.findViewById(C0062R.id.btn_bg_selector1);
        this.f3872w = (ImageView) viewM3761b.findViewById(C0062R.id.btn_bg_selector2);
        this.f3873x = (ImageView) viewM3761b.findViewById(C0062R.id.btn_bg_selector3);
        this.f3871v.setOnClickListener(this);
        this.f3872w.setOnClickListener(this);
        this.f3873x.setOnClickListener(this);
        int[] iArr = new int[2];
        this.f3860c.getLocationOnScreen(iArr);
        this.f3830F.showAtLocation(this.f3860c, 0, 0, iArr[1] + this.f3860c.getHeight());
    }

    /* renamed from: u */
    private void m3807u() throws IOException {
        this.f3832H = 2006;
        m3751a(this.f3832H);
        this.f3831G.setEditMode(false, true);
        this.f3865p.setEnabled(false);
        View viewM3761b = m3761b(C0062R.layout.ams_bg_audio_popup_layout);
        this.f3874y = (ImageView) viewM3761b.findViewById(C0062R.id.btn_bg_selector4);
        this.f3875z = (ImageView) viewM3761b.findViewById(C0062R.id.btn_bg_selector5);
        this.f3874y.setOnClickListener(this);
        this.f3875z.setOnClickListener(this);
        int[] iArr = new int[2];
        this.f3864o.getLocationOnScreen(iArr);
        this.f3830F.showAtLocation(this.f3864o, 0, ((this.f3864o.getMeasuredWidth() - viewM3761b.getMeasuredWidth()) / 2) + iArr[0], iArr[1] + this.f3864o.getHeight());
    }

    /* renamed from: v */
    private void m3809v() {
        if (this.f3833I != 2005 && this.f3833I != 2004 && this.f3852ab != 0) {
            if (this.f3852ab == 1) {
                this.f3832H = 2004;
                this.f3831G.m3833a(4, this.f3840P, this.f3841Q, this.f3842R);
            } else {
                this.f3832H = 2005;
                this.f3831G.m3833a(3, this.f3843S, 0, 0);
            }
            m3751a(this.f3832H);
            this.f3865p.setEnabled(false);
            this.f3833I = this.f3832H;
            return;
        }
        this.f3832H = 2005;
        m3751a(this.f3832H);
        View viewM3761b = m3761b(C0062R.layout.ams_stamp_shape_popup_layout);
        this.f3829E = (ImageView) viewM3761b.findViewById(C0062R.id.btn_tool_stamp);
        this.f3828D = (ImageView) viewM3761b.findViewById(C0062R.id.btn_tool_shape);
        this.f3829E.setOnClickListener(this);
        this.f3828D.setOnClickListener(this);
        int[] iArr = new int[2];
        this.f3863n.getLocationOnScreen(iArr);
        this.f3830F.showAtLocation(this.f3863n, 0, ((this.f3863n.getMeasuredWidth() - viewM3761b.getMeasuredWidth()) / 2) + iArr[0], iArr[1] + this.f3863n.getHeight());
    }

    /* renamed from: w */
    private void m3811w() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    /* renamed from: x */
    private void m3812x() {
        Intent intent = new Intent(this, (Class<?>) BackgroundMemoSelectionActivity.class);
        intent.putExtra("BACKGROUND_COLOR", this.f3831G.m3844c());
        intent.putExtra("BACKGROUND_INDEX", this.f3856af);
        startActivityForResult(intent, 3);
    }

    /* renamed from: y */
    private void m3814y() {
        File file = new File(f3814k);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(file));
        startActivityForResult(intent, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m3817z() {
        Intent intent = new Intent(this, (Class<?>) BackgroundDefaultMusicSelectionActivity.class);
        intent.putExtra("BGM_INDEX", this.f3854ad);
        startActivityForResult(intent, 5);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.vip.amschaton.InterfaceC0641ao
    /* renamed from: a */
    public boolean mo3818a(int i, int i2, int i3, int i4, int i5) {
        switch (i) {
            case 0:
                this.f3846V = true;
                m3799q();
                m3801r();
                return false;
            case 1:
                this.f3865p.setEnabled(true);
                return false;
            case 2:
                if (this.f3831G.m3841b() != 1) {
                    this.f3865p.setEnabled(false);
                }
                return false;
            default:
                return false;
        }
    }

    @Override // com.sec.vip.amschaton.InterfaceC0715r
    /* renamed from: a */
    public boolean mo3819a(String str) {
        this.f3839O = new TextInputDialog(this, C0062R.style.AMSCustomDialogTheme, 128);
        if (str != null) {
            this.f3839O.m4181a(str);
        }
        this.f3839O.m4180a(new C0688ch(this));
        this.f3839O.show();
        m3756a(this.f3839O);
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws IOException {
        Bitmap bitmapM3744a;
        String string;
        if (i2 != -1) {
        }
        switch (i) {
            case 2:
                m3762b(intent.getData());
                break;
            case 3:
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    this.f3856af = extras.getInt("BACKGROUND_INDEX", 0);
                    if (this.f3856af != 0) {
                        m3768c(this.f3856af - 1);
                        break;
                    } else {
                        int i3 = extras.getInt("BACKGROUND_COLOR");
                        this.f3831G.m3834a(Color.red(i3), Color.green(i3), Color.blue(i3), true);
                        this.f3831G.m3852j();
                        this.f3831G.invalidate();
                        break;
                    }
                }
                break;
            case 4:
                new C0672bs(this).start();
                break;
            case 5:
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    this.f3854ad = extras2.getInt("BGM_INDEX", -1);
                    if (this.f3854ad < 0) {
                        this.f3831G.m3831a(-1, 0);
                    } else {
                        this.f3831G.m3831a(this.f3854ad, 1);
                    }
                    if (!this.f3831G.m3849g()) {
                        this.f3827C.setVisibility(4);
                        break;
                    } else {
                        this.f3827C.setVisibility(0);
                        break;
                    }
                }
                break;
            case 6:
                Bundle extras3 = intent.getExtras();
                if (extras3 != null && (string = extras3.getString("REC_AUDIO_PATH")) != null) {
                    this.f3831G.m3839a(string, 3);
                    if (!this.f3831G.m3849g()) {
                        this.f3827C.setVisibility(4);
                        break;
                    } else {
                        this.f3827C.setVisibility(0);
                        break;
                    }
                }
                break;
            case 7:
                Bundle extras4 = intent.getExtras();
                if (extras4 != null) {
                    Bitmap bitmapM3744a2 = m3744a(intent, extras4);
                    if (bitmapM3744a2 != null) {
                        m3753a(bitmapM3744a2);
                    }
                }
                File file = new File(AMSFileListActivity.f3814k);
                if (file.exists()) {
                    file.delete();
                    break;
                }
                break;
            case 8:
                m3754a(intent.getData());
                break;
            case 9:
                Bundle extras5 = intent.getExtras();
                if (extras5 != null && (bitmapM3744a = m3744a(intent, extras5)) != null) {
                    String str = AMSActivity.f3811h + m3749a("[STP]", System.currentTimeMillis(), ".png");
                    if (this.f3850Z == null) {
                        ChatONLogWriter.m3506b("mStampSelectionDialog is null", getClass().getSimpleName());
                        m3787k();
                    }
                    this.f3850Z.m4085a(bitmapM3744a, str);
                    AMSStampManager.m4056a().m4061a(this, getAssets(), AMSActivity.f3811h);
                    this.f3850Z.m4086b();
                    break;
                }
                break;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        f3824a = false;
        if (!this.f3846V || !this.f3831G.m3827B()) {
            finish();
            return;
        }
        if (!this.f3831G.m3838a(f3810g + m3749a("A", System.currentTimeMillis(), "") + ".jpg")) {
            Toast.makeText(m3735G(), C0062R.string.ams_error_ams_file_save, 0).show();
        } else {
            Toast.makeText(m3735G(), C0062R.string.ams_msg_saved, 0).show();
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException, IOException {
        switch (view.getId()) {
            case C0062R.id.btn_bg_selector4 /* 2131427344 */:
                if (this.f3831G.m3846d() == 0) {
                    m3817z();
                    m3758a(true);
                    break;
                } else {
                    new AlertDialog.Builder(this).setTitle(C0062R.string.ams_title_bgm).setMessage(C0062R.string.ams_msg_delete_bgm).setPositiveButton(C0062R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC0679bz(this)).setNegativeButton(C0062R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC0673bt(this)).create().show();
                    break;
                }
            case C0062R.id.btn_bg_selector5 /* 2131427345 */:
                if (this.f3831G.m3846d() == 0) {
                    m3724A();
                    m3758a(true);
                    break;
                } else {
                    new AlertDialog.Builder(this).setTitle(C0062R.string.ams_title_bgm).setMessage(C0062R.string.ams_msg_delete_bgm).setPositiveButton(C0062R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC0677bx(this)).setNegativeButton(C0062R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC0681ca(this)).create().show();
                    break;
                }
            case C0062R.id.btn_bg_selector1 /* 2131427358 */:
                m3812x();
                m3758a(true);
                break;
            case C0062R.id.btn_bg_selector2 /* 2131427359 */:
                m3811w();
                m3758a(true);
                break;
            case C0062R.id.btn_bg_selector3 /* 2131427360 */:
                m3814y();
                m3758a(true);
                break;
            case C0062R.id.btn_tool_background_image /* 2131427378 */:
                m3805t();
                break;
            case C0062R.id.btn_tool_text /* 2131427379 */:
                m3783i();
                break;
            case C0062R.id.btn_tool_pen /* 2131427380 */:
                m3750a();
                break;
            case C0062R.id.btn_tool_stamp_shape /* 2131427381 */:
                m3809v();
                break;
            case C0062R.id.btn_tool_eraser /* 2131427382 */:
                if (this.f3831G.m3841b() != 1) {
                    this.f3831G.m3855m();
                    break;
                } else {
                    m3789l();
                    break;
                }
            case C0062R.id.btn_tool_background_audio /* 2131427383 */:
                m3807u();
                break;
            case C0062R.id.btn_prev /* 2131427390 */:
                m3795o();
                break;
            case C0062R.id.btn_next /* 2131427391 */:
                m3797p();
                break;
            case C0062R.id.btn_page /* 2131427392 */:
                m3791m();
                break;
            case C0062R.id.btn_undo /* 2131427393 */:
                this.f3831G.m3856n();
                break;
            case C0062R.id.btn_redo /* 2131427394 */:
                this.f3831G.m3857o();
                break;
            case C0062R.id.btn_preview /* 2131427395 */:
                m3726B();
                break;
            case C0062R.id.btn_send /* 2131427396 */:
                f3824a = false;
                m3729D();
                break;
            case C0062R.id.btn_tool_stamp /* 2131427462 */:
                m3787k();
                m3758a(true);
                break;
            case C0062R.id.btn_tool_shape /* 2131427463 */:
                m3784j();
                m3758a(true);
                break;
        }
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws IOException {
        super.onCreate(bundle);
        this.f3835K = new int[5];
        this.f3836L = new int[5];
        m3739I();
        setContentView(C0062R.layout.ams_composer_layout);
        this.f3859b = getWindowManager().getDefaultDisplay().getWidth() / 480.0f;
        m3712b();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f3844T = extras.getString("AMS_FILE_PATH");
            this.f3845U = false;
        } else {
            ChatONLogWriter.m3506b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f3844T = "";
        }
        f3824a = true;
        this.f3860c = (ImageView) findViewById(C0062R.id.btn_tool_background_image);
        this.f3861d = (ImageView) findViewById(C0062R.id.btn_tool_pen);
        this.f3862m = (ImageView) findViewById(C0062R.id.btn_tool_text);
        this.f3863n = (ImageView) findViewById(C0062R.id.btn_tool_stamp_shape);
        this.f3864o = (ImageView) findViewById(C0062R.id.btn_tool_background_audio);
        this.f3865p = (ImageView) findViewById(C0062R.id.btn_tool_eraser);
        this.f3866q = (ImageView) findViewById(C0062R.id.btn_page);
        this.f3867r = (ImageView) findViewById(C0062R.id.btn_undo);
        this.f3868s = (ImageView) findViewById(C0062R.id.btn_redo);
        this.f3869t = (ImageView) findViewById(C0062R.id.btn_preview);
        this.f3870u = (ImageView) findViewById(C0062R.id.btn_send);
        this.f3825A = (ImageView) findViewById(C0062R.id.btn_prev);
        this.f3826B = (ImageView) findViewById(C0062R.id.btn_next);
        this.f3827C = (ImageView) findViewById(C0062R.id.image_audio);
        this.f3860c.setOnClickListener(this);
        this.f3861d.setOnClickListener(this);
        this.f3862m.setOnClickListener(this);
        this.f3863n.setOnClickListener(this);
        this.f3864o.setOnClickListener(this);
        this.f3865p.setOnClickListener(this);
        this.f3866q.setOnClickListener(this);
        this.f3867r.setOnClickListener(this);
        this.f3868s.setOnClickListener(this);
        this.f3869t.setOnClickListener(this);
        this.f3870u.setOnClickListener(this);
        this.f3825A.setOnClickListener(this);
        this.f3826B.setOnClickListener(this);
        m3803s();
        if (!this.f3845U) {
            new Thread(new RunnableC0675bv(this)).start();
        }
        this.f3867r.setEnabled(this.f3831G.m3867y());
        this.f3868s.setEnabled(this.f3831G.m3868z());
        this.f3869t.setEnabled(this.f3831G.m3827B());
        this.f3870u.setEnabled(this.f3831G.m3827B());
        m3799q();
        this.f3832H = MsgResultCode.INTERNAL_SERVER_ERROR;
        this.f3831G.m3833a(1, this.f3834J, this.f3835K[this.f3834J], this.f3836L[this.f3834J]);
        m3751a(this.f3832H);
        m3741K();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0062R.menu.ams_composer_option_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (f3824a && this.f3846V) {
            ChatONLogWriter.m3506b("onDestroy :" + this.f3846V, getClass().getSimpleName());
            if (!this.f3831G.m3838a(f3810g + m3749a("A", System.currentTimeMillis(), "") + ".jpg")) {
                Toast.makeText(m3735G(), C0062R.string.ams_error_ams_file_save, 0).show();
            }
            Toast.makeText(m3735G(), C0062R.string.ams_msg_temp_saved, 0).show();
        }
        if (this.f3831G != null) {
            this.f3831G.m3828C();
            this.f3831G = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IOException {
        switch (menuItem.getItemId()) {
            case C0062R.id.menu_create_new /* 2131428115 */:
                if (this.f3846V) {
                    new AlertDialog.Builder(this).setTitle(C0062R.string.ams_title_create_new).setMessage(C0062R.string.ams_msg_exit_with_save).setPositiveButton(C0062R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC0698cr(this)).setNegativeButton(C0062R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC0697cq(this)).create().show();
                    return true;
                }
                m3728C();
                return true;
            case C0062R.id.menu_group_save /* 2131428116 */:
            case C0062R.id.menu_group_page /* 2131428118 */:
            case C0062R.id.menu_group_audio /* 2131428120 */:
            default:
                return false;
            case C0062R.id.menu_save /* 2131428117 */:
                m3738H();
                return true;
            case C0062R.id.menu_delete_page /* 2131428119 */:
                new AlertDialog.Builder(this).setTitle(C0062R.string.ams_title_delete_page).setMessage(C0062R.string.ams_msg_delete_page).setPositiveButton(C0062R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC0700ct(this)).setNegativeButton(C0062R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC0699cs(this)).create().show();
                return true;
            case C0062R.id.menu_delete_audio /* 2131428121 */:
                this.f3854ad = -1;
                this.f3831G.m3831a(-1, 0);
                if (this.f3831G.m3849g()) {
                    this.f3827C.setVisibility(0);
                } else {
                    this.f3827C.setVisibility(4);
                }
                return true;
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(C0062R.id.menu_group_page, this.f3831G.m3865w() > 0);
        menu.setGroupVisible(C0062R.id.menu_group_audio, this.f3831G.m3849g());
        menu.setGroupVisible(C0062R.id.menu_group_save, this.f3831G.m3827B() && this.f3846V);
        return super.onPrepareOptionsMenu(menu);
    }
}
