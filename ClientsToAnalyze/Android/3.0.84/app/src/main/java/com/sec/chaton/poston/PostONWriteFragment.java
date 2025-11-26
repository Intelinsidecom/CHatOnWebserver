package com.sec.chaton.poston;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1344v;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3188bc;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3246u;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.AlertDialogC3256c;
import com.sec.chaton.widget.C3263j;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.p069e.C3326c;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PostONWriteFragment extends Fragment implements InterfaceC1988ba, InterfaceC2030u {

    /* renamed from: X */
    private static String f7573X = C3223ck.m11329c() + "/poston/";

    /* renamed from: Y */
    private static String f7574Y = ".jpg";

    /* renamed from: A */
    private String f7575A;

    /* renamed from: B */
    private String f7576B;

    /* renamed from: C */
    private AlertDialogC3256c f7577C;

    /* renamed from: D */
    private ProgressDialog f7578D;

    /* renamed from: E */
    private InterfaceC3274d f7579E;

    /* renamed from: F */
    private C1344v f7580F;

    /* renamed from: G */
    private Toast f7581G;

    /* renamed from: H */
    private String f7582H;

    /* renamed from: I */
    private String f7583I;

    /* renamed from: J */
    private MenuItem f7584J;

    /* renamed from: K */
    private boolean f7585K;

    /* renamed from: L */
    private Uri f7586L;

    /* renamed from: M */
    private Uri f7587M;

    /* renamed from: N */
    private int f7588N;

    /* renamed from: O */
    private int f7589O;

    /* renamed from: P */
    private boolean f7590P;

    /* renamed from: S */
    private C2027r f7593S;

    /* renamed from: T */
    private C3326c f7594T;

    /* renamed from: U */
    private GridView f7595U;

    /* renamed from: V */
    private String f7596V;

    /* renamed from: W */
    private String f7597W;

    /* renamed from: aa */
    private AsyncTaskC2010bw f7600aa;

    /* renamed from: ab */
    private boolean f7601ab;

    /* renamed from: ac */
    private boolean f7602ac;

    /* renamed from: ad */
    private boolean f7603ad;

    /* renamed from: c */
    int f7611c;

    /* renamed from: q */
    private ImageButton f7625q;

    /* renamed from: r */
    private ImageButton f7626r;

    /* renamed from: s */
    private ImageButton f7627s;

    /* renamed from: t */
    private ImageButton f7628t;

    /* renamed from: u */
    private TextView f7629u;

    /* renamed from: v */
    private EditText f7630v;

    /* renamed from: w */
    private LinearLayout f7631w;

    /* renamed from: x */
    private LinearLayout f7632x;

    /* renamed from: y */
    private TextView f7633y;

    /* renamed from: z */
    private ImageButton f7634z;

    /* renamed from: d */
    private final String f7612d = "PostONWriteFragment";

    /* renamed from: e */
    private final int f7613e = 0;

    /* renamed from: f */
    private final int f7614f = 1;

    /* renamed from: g */
    private final int f7615g = 1;

    /* renamed from: h */
    private final int f7616h = 2;

    /* renamed from: i */
    private final int f7617i = 3;

    /* renamed from: j */
    private final int f7618j = 4;

    /* renamed from: k */
    private final int f7619k = 5;

    /* renamed from: l */
    private final int f7620l = 6;

    /* renamed from: m */
    private final int f7621m = 7;

    /* renamed from: n */
    private final int f7622n = 140;

    /* renamed from: o */
    private final int f7623o = MotionEventCompat.ACTION_MASK;

    /* renamed from: p */
    private final int f7624p = 153;

    /* renamed from: Q */
    private ArrayList<PreviewData> f7591Q = new ArrayList<>();

    /* renamed from: R */
    private ArrayList<PreviewData> f7592R = new ArrayList<>();

    /* renamed from: a */
    int f7599a = 0;

    /* renamed from: b */
    int f7610b = 0;

    /* renamed from: Z */
    private boolean f7598Z = false;

    /* renamed from: ae */
    private TextWatcher f7604ae = new C2005br(this);

    /* renamed from: af */
    private View.OnClickListener f7605af = new ViewOnClickListenerC1993bf(this);

    /* renamed from: ag */
    private DialogInterface.OnClickListener f7606ag = new DialogInterfaceOnClickListenerC1994bg(this);

    /* renamed from: ah */
    private Handler f7607ah = new HandlerC1997bj(this);

    /* renamed from: ai */
    private Handler f7608ai = new HandlerC1998bk(this);

    /* renamed from: aj */
    private Handler f7609aj = new HandlerC1999bl(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ("MY_PAGE".equals(getActivity().getIntent().getExtras().getString("WRITE_FROM"))) {
            this.f7585K = true;
        } else {
            this.f7585K = false;
        }
        if (getActivity().getIntent().getExtras().getString("CHATON_ID") != null) {
            this.f7583I = getActivity().getIntent().getExtras().getString("CHATON_ID");
        } else {
            this.f7583I = C3159aa.m10962a().m10979a("chaton_id", "");
        }
        this.f7582H = C3159aa.m10962a().m10979a("Push Name", "");
        this.f7597W = f7573X + this.f7583I;
        this.f7586L = null;
        if (bundle == null) {
            this.f7587M = null;
        } else {
            String string = bundle.getString("CAPTURE_IMAGE_URI");
            if (!TextUtils.isEmpty(string)) {
                this.f7587M = Uri.parse(string);
            }
        }
        this.f7589O = 0;
        this.f7588N = 0;
        this.f7579E = null;
        this.f7590P = false;
        this.f7602ac = false;
        this.f7580F = new C1344v(this.f7609aj);
        BaseActivity.m3081a(this, true);
        this.f7581G = C3641ai.m13210a(getActivity(), R.string.popup_no_network_connection, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_poston_write, viewGroup, false);
        this.f7630v = (EditText) viewInflate.findViewById(R.id.poston_text);
        this.f7630v.addTextChangedListener(this.f7604ae);
        this.f7630v.setFilters(new InputFilter[]{new C3248w(getActivity(), 140)});
        this.f7630v.setOnEditorActionListener(new C1989bb(this));
        this.f7631w = (LinearLayout) viewInflate.findViewById(R.id.llayout_location_text);
        this.f7633y = (TextView) this.f7631w.findViewById(R.id.location_text);
        this.f7634z = (ImageButton) this.f7631w.findViewById(R.id.location_delete);
        this.f7631w.setOnClickListener(this.f7605af);
        this.f7625q = (ImageButton) viewInflate.findViewById(R.id.camera_button);
        if (!C3171am.m11077o()) {
            this.f7625q.setEnabled(false);
        }
        this.f7626r = (ImageButton) viewInflate.findViewById(R.id.image_button);
        this.f7627s = (ImageButton) viewInflate.findViewById(R.id.video_button);
        this.f7628t = (ImageButton) viewInflate.findViewById(R.id.location_button);
        if (C0816a.m4365a()) {
            this.f7628t.setVisibility(0);
        } else {
            this.f7628t.setVisibility(8);
        }
        this.f7629u = (TextView) viewInflate.findViewById(R.id.text_length);
        this.f7632x = (LinearLayout) viewInflate.findViewById(R.id.contents_preview_panel);
        this.f7595U = (GridView) viewInflate.findViewById(R.id.contents_preview_grid_view);
        this.f7578D = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.wait_sending);
        m8003e();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f7587M != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f7587M.toString());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_write_poston_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f7584J = null;
        this.f7584J = menu.findItem(R.id.write_poston_menu_post);
        if (this.f7598Z) {
            this.f7584J.setEnabled(true);
        } else {
            this.f7584J.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.write_poston_menu_cancel) {
            getActivity().finish();
        }
        if (menuItem.getItemId() == R.id.write_poston_menu_post) {
            if (this.f7601ab) {
                C3641ai.m13210a(getActivity(), R.string.download_progressing, 0).show();
                return true;
            }
            if (this.f7591Q != null && this.f7591Q.size() > 0) {
                int iM6733a = C1594v.m6733a(getActivity());
                if (-3 == iM6733a || -2 == iM6733a) {
                    this.f7581G.show();
                    return true;
                }
                if (this.f7602ac) {
                    this.f7600aa = new AsyncTaskC2010bw(this, this.f7591Q, EnumC1455w.VIDEO);
                    this.f7600aa.execute(new Void[0]);
                    return true;
                }
                this.f7600aa = new AsyncTaskC2010bw(this, this.f7591Q, EnumC1455w.IMAGE);
                this.f7600aa.execute(new Void[0]);
                return true;
            }
            m7992a((ArrayList<PreviewData>) null);
            return true;
        }
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f7595U != null) {
            this.f7595U.setOnItemClickListener(null);
            this.f7595U.setAdapter((ListAdapter) null);
        }
        if (this.f7594T != null) {
            this.f7594T.m11731a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f7600aa != null) {
            this.f7600aa.m8036a();
        }
        if (this.f7579E != null) {
            this.f7579E.dismiss();
        }
        if (this.f7578D != null) {
            this.f7578D.dismiss();
        }
        if (this.f7577C != null && this.f7577C.isShowing()) {
            this.f7577C.dismiss();
        }
        if (this.f7591Q != null && !this.f7591Q.isEmpty()) {
            this.f7591Q.clear();
            this.f7593S = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7986a(EditText editText, boolean z) {
        Handler handler = null;
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            if (z) {
                inputMethodManager.showSoftInput(editText, 0, new ResultReceiver(handler) { // from class: com.sec.chaton.poston.PostONWriteFragment.2
                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int i, Bundle bundle) {
                        if (i == 0) {
                            PostONWriteFragment.this.f7632x.setVisibility(8);
                        }
                    }
                });
            } else {
                inputMethodManager.hideSoftInputFromWindow(this.f7630v.getWindowToken(), 0, new ResultReceiver(handler) { // from class: com.sec.chaton.poston.PostONWriteFragment.3
                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int i, Bundle bundle) {
                        if (i == 3) {
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7992a(ArrayList<PreviewData> arrayList) {
        if (this.f7630v.getText().toString() != null) {
            C3250y.m11456e("PostONCommentItem: " + this.f7630v.getText().toString(), getClass().getSimpleName());
            if (!C3197bl.m11159a()) {
                ArrayList arrayList2 = new ArrayList();
                if (arrayList != null) {
                    if (this.f7602ac) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            if (arrayList.get(i) != null && arrayList.get(i).m7754f() != null) {
                                C3250y.m11456e("writePostONImage / url = " + arrayList.get(i).m7754f(), getClass().getSimpleName());
                                arrayList2.add(m7981a(arrayList.get(i).m7754f(), "2"));
                            }
                        }
                    } else {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            if (arrayList.get(i2) != null && arrayList.get(i2).m7754f() != null) {
                                C3250y.m11456e("writePostONVideo / url = " + arrayList.get(i2).m7754f(), getClass().getSimpleName());
                                arrayList2.add(m7981a(arrayList.get(i2).m7754f(), "1"));
                            }
                        }
                    }
                }
                if (this.f7575A != null && this.f7575A.length() > 0) {
                    C3250y.m11456e("writePostON / LocationData = " + this.f7575A, getClass().getSimpleName());
                    arrayList2.add(m7981a(this.f7575A, "3"));
                }
                m7986a(this.f7630v, false);
                this.f7580F.m5912a(new C2020k(this.f7583I, this.f7583I, this.f7582H, this.f7630v.getText().toString(), String.valueOf(System.currentTimeMillis()), "0", "0", "-1", arrayList2, null, null, null), this.f7583I);
                this.f7578D.show();
            }
        }
    }

    /* renamed from: com.sec.chaton.poston.PostONWriteFragment$4 */
    class ResultReceiverC19594 extends ResultReceiver {
        final /* synthetic */ PostONWriteFragment this$0;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            if (i == 3 && !this.this$0.f7591Q.isEmpty()) {
                this.this$0.f7632x.setVisibility(0);
            }
        }
    }

    /* renamed from: a */
    private C2011bx m7981a(String str, String str2) {
        C2011bx c2011bx = new C2011bx(this);
        if (!str2.equals("3")) {
            String[] strArrSplit = str.split("\n");
            for (int i = 0; i < strArrSplit.length; i++) {
                C3250y.m11456e(" strArray[" + i + "]= " + strArrSplit[i], getClass().getSimpleName());
            }
            if (strArrSplit != null && strArrSplit.length == 3) {
                c2011bx.f7728a = strArrSplit[0] + "/";
                c2011bx.f7729b = strArrSplit[2] + "/" + strArrSplit[1];
                c2011bx.f7730c = str2;
            }
        } else {
            c2011bx.f7728a = str;
            c2011bx.f7729b = str;
            c2011bx.f7730c = str2;
        }
        return c2011bx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7987a(PreviewData previewData) throws Throwable {
        File file;
        String strM7752d;
        String string = Long.toString(System.currentTimeMillis());
        if (previewData.m7752d() == null) {
            file = new File(previewData.m7746a());
            strM7752d = previewData.m7746a();
        } else {
            file = new File(previewData.m7752d());
            strM7752d = previewData.m7752d();
        }
        if (C3188bc.m11135a(file) && !this.f7602ac) {
            try {
                File fileM11136b = C3188bc.m11136b(getActivity(), file, "/poston/" + this.f7583I, null, true);
                previewData.m7747a(fileM11136b.getAbsolutePath());
                previewData.m7751c(fileM11136b.getName());
                C3250y.m11456e("yeseul / getAbsolutePath : " + fileM11136b.getAbsolutePath() + "/ getName()" + fileM11136b.getName(), getClass().getSimpleName());
                return;
            } catch (FileNotFoundException e) {
                C3250y.m11443a(e, "PostONWriteFragment");
                return;
            } catch (IOException e2) {
                C3250y.m11443a(e2, "PostONWriteFragment");
                return;
            } catch (Exception e3) {
                C3250y.m11443a(e3, "PostONWriteFragment");
                return;
            } catch (OutOfMemoryError e4) {
                C3250y.m11443a(e4, "PostONWriteFragment");
                return;
            }
        }
        String str = string + file.getName().substring(file.getName().indexOf("."));
        C3250y.m11456e("yeseul / PostONFilePath :" + this.f7597W + "/" + str + " /mImageId: " + string, getClass().getSimpleName());
        try {
            C3243r.m11415a(strM7752d, this.f7597W, str);
            previewData.m7747a(this.f7597W + "/" + str);
            previewData.m7751c(str);
        } catch (Exception e5) {
            C3250y.m11443a(e5, getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public AlertDialogC3256c m8000d() {
        if (this.f7577C == null) {
            this.f7577C = new AlertDialogC3256c(getActivity());
            this.f7577C.setTitle(R.string.poston_upload);
            this.f7577C.setMessage(getString(R.string.upload_body));
            this.f7577C.setCancelable(false);
        }
        this.f7577C.setButton(-2, getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2004bq(this));
        return this.f7577C;
    }

    /* renamed from: e */
    private void m8003e() {
        this.f7630v.setOnClickListener(new ViewOnClickListenerC2006bs(this));
        this.f7625q.setOnClickListener(new ViewOnClickListenerC2007bt(this));
        this.f7626r.setOnClickListener(new ViewOnClickListenerC2008bu(this));
        this.f7627s.setOnClickListener(new ViewOnClickListenerC1990bc(this));
        this.f7628t.setOnClickListener(new ViewOnClickListenerC1991bd(this));
        this.f7634z.setOnClickListener(new ViewOnClickListenerC1992be(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        File file;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.f7590P = true;
                    this.f7602ac = false;
                    Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f7587M, "image/*");
                    intent2.putExtra("return-data", true);
                    intent2.putExtra("randomFName", true);
                    startActivityForResult(intent2, 4);
                    break;
                case 2:
                    this.f7602ac = false;
                    if (intent == null) {
                        C3250y.m11450b("To pick image From Gallery is NULL", "PostONWriteFragment");
                        break;
                    } else {
                        this.f7586L = intent.getData();
                        Intent intent3 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent3.setDataAndType(this.f7586L, "image/*");
                        intent3.putExtra("return-data", true);
                        intent3.putExtra("randomFName", true);
                        startActivityForResult(intent3, 4);
                        break;
                    }
                case 3:
                    this.f7602ac = false;
                    if (this.f7591Q.size() == 0) {
                        this.f7591Q = intent.getParcelableArrayListExtra("preview_data");
                    } else {
                        Iterator it = intent.getParcelableArrayListExtra("preview_data").iterator();
                        while (it.hasNext()) {
                            this.f7591Q.add((PreviewData) it.next());
                        }
                    }
                    m8027b();
                    break;
                case 4:
                    this.f7602ac = false;
                    if (intent == null) {
                        C3250y.m11450b("To pick image From Gallery is NULL", "PostONWriteFragment");
                        break;
                    } else {
                        if (this.f7588N != 0) {
                            this.f7588N++;
                        } else {
                            this.f7588N = 1;
                        }
                        String string = intent.getExtras().getString("temp_file_path");
                        if (this.f7590P) {
                            this.f7591Q.add(new PreviewData(this.f7587M.toString(), null, null, string, null));
                            this.f7590P = false;
                        } else {
                            this.f7591Q.add(new PreviewData(this.f7586L.toString(), null, null, string, null));
                        }
                        m8027b();
                        break;
                    }
                case 5:
                    this.f7602ac = false;
                    C3250y.m11450b("Get the item modified by effect function", "PostONWriteFragment");
                    if (intent != null) {
                        this.f7591Q.get(this.f7589O).m7747a(intent.getStringExtra("temp_file_path"));
                        this.f7595U.invalidateViews();
                        break;
                    }
                    break;
                case 6:
                    this.f7602ac = true;
                    if (intent == null) {
                        C3250y.m11450b("To pick image From Gallery is NULL", "PostONWriteFragment");
                        break;
                    } else {
                        if ("file".equals(intent.getData().getScheme())) {
                            file = new File(intent.getData().getPath());
                        } else {
                            C3246u c3246uM11426c = C3243r.m11426c(intent.getData().toString());
                            file = c3246uM11426c != null ? c3246uM11426c.f11726a : null;
                        }
                        if (file != null) {
                            if (file.length() > 10485760) {
                                C3641ai.m13210a(getActivity(), R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
                                break;
                            } else {
                                this.f7591Q.add(new PreviewData(file.getAbsolutePath(), file.getName(), null, null, null));
                                C3250y.m11456e("fi.getAbsolutePath(): " + file.getAbsolutePath() + " /fi.getName(): " + file.getName(), "PostONWriteFragment");
                                m8027b();
                                break;
                            }
                        } else if (C3250y.f11737e) {
                            C3250y.m11442a("sendVideo file is null", "PostONWriteFragment");
                            break;
                        }
                    }
                    break;
                case 7:
                    m7985a(intent);
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m7985a(Intent intent) {
        if (intent != null && intent.getStringExtra("GEOPOINT") != null) {
            this.f7603ad = true;
            this.f7584J.setEnabled(true);
            C3250y.m11456e("GEOPOINT: " + intent.getStringExtra("GEOPOINT") + "/ GEOADDRESS: " + intent.getStringExtra("GEOADDRESS"), getClass().getSimpleName());
            String stringExtra = intent.getStringExtra("GEOADDRESS");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = getString(R.string.menu_multimedia_geo_tag);
            }
            this.f7575A = "(" + intent.getStringExtra("GEOPOINT") + ", " + stringExtra + ")";
            this.f7576B = intent.getStringExtra("GEOPOINT");
            this.f7633y.setText(stringExtra);
            this.f7631w.setVisibility(0);
            this.f7628t.setSelected(true);
            if (this.f7632x.getVisibility() == 8) {
                this.f7632x.setVisibility(0);
            }
            this.f7595U.setVisibility(8);
            this.f7631w.setVisibility(0);
        }
    }

    /* renamed from: b */
    void m8027b() {
        this.f7603ad = true;
        if (this.f7632x.getVisibility() == 8 && !this.f7591Q.isEmpty()) {
            this.f7632x.setVisibility(0);
        }
        this.f7594T = new C3326c();
        this.f7593S = new C2027r(getActivity(), R.layout.item_poston_preview_contents, this.f7591Q, this.f7594T);
        this.f7593S.m8068a(this);
        this.f7595U.setAdapter((ListAdapter) this.f7593S);
        this.f7595U.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        if (this.f7591Q.size() >= 1) {
            this.f7631w.setVisibility(8);
            this.f7595U.setVisibility(0);
            this.f7598Z = true;
            if (this.f7584J != null) {
                this.f7584J.setEnabled(true);
            }
            if (this.f7602ac) {
                this.f7593S.m8069a(true);
                this.f7625q.setEnabled(false);
                this.f7627s.setSelected(true);
                this.f7626r.setEnabled(false);
                return;
            }
            this.f7627s.setEnabled(false);
            this.f7588N = this.f7591Q.size();
            if (this.f7588N >= 1) {
                this.f7626r.setEnabled(true);
                this.f7625q.setEnabled(false);
                this.f7626r.setSelected(true);
                return;
            }
            return;
        }
        this.f7625q.setEnabled(true);
        this.f7627s.setEnabled(true);
        this.f7626r.setEnabled(true);
        if (this.f7630v.getText().length() > 0 || (this.f7575A != null && !this.f7575A.isEmpty())) {
            this.f7598Z = true;
            this.f7584J.setEnabled(true);
        } else {
            this.f7598Z = false;
            this.f7584J.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m8005f() {
        if (this.f7577C != null && this.f7577C.isShowing()) {
            this.f7577C.dismiss();
        }
        if (this.f7611c == 0) {
            m7992a(this.f7591Q);
            this.f7610b = 0;
        } else {
            this.f7579E = AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.poston_title)).mo11509b(getResources().getString(R.string.toast_setting_profile_update_failed)).mo11510b(getResources().getString(R.string.setting_selfsms_retry), new DialogInterfaceOnClickListenerC1996bi(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1995bh(this)).mo11512b();
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC2030u
    /* renamed from: b */
    public void mo8028b(int i) {
        this.f7591Q.remove(i);
        if (this.f7632x.getVisibility() == 0 && this.f7591Q.isEmpty()) {
            this.f7632x.setVisibility(8);
        }
        this.f7595U.invalidateViews();
        if (this.f7593S != null) {
            this.f7593S.notifyDataSetChanged();
        }
        this.f7625q.setEnabled(true);
        this.f7625q.setSelected(false);
        this.f7626r.setEnabled(true);
        this.f7626r.setSelected(false);
        if (this.f7591Q.size() == 0) {
            this.f7627s.setEnabled(true);
            this.f7627s.setSelected(false);
            if (this.f7630v.getText().length() > 0 || (this.f7575A != null && !this.f7575A.isEmpty())) {
                this.f7598Z = true;
                this.f7584J.setEnabled(true);
            } else {
                this.f7598Z = false;
                this.f7584J.setEnabled(false);
            }
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC2030u
    /* renamed from: a */
    public void mo8025a(int i) {
        if (!this.f7602ac) {
            PreviewData previewData = this.f7591Q.get(i);
            this.f7589O = i;
            String strM7752d = previewData.m7752d();
            if (strM7752d == null) {
                m7991a(previewData.m7748b(), true);
            } else {
                m7991a(strM7752d, false);
            }
        }
    }

    /* renamed from: a */
    private void m7991a(String str, boolean z) {
        String str2;
        C3250y.m11450b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(getActivity(), (Class<?>) ImageModify.class);
        if (z) {
            str2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString() + "/" + str;
        } else {
            str2 = "file://" + str;
        }
        intent.setData(Uri.parse(str2));
        intent.putExtra("return-data", true);
        intent.putExtra("randomFName", true);
        startActivityForResult(intent, 5);
    }

    @Override // com.sec.chaton.poston.InterfaceC1988ba
    /* renamed from: a */
    public boolean mo8026a() {
        if (this.f7632x.getVisibility() != 0) {
            return true;
        }
        this.f7632x.setVisibility(8);
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f7603ad) {
            this.f7632x.setVisibility(8);
        } else {
            this.f7603ad = false;
            this.f7632x.setVisibility(0);
        }
    }
}
