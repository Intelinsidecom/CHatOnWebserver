package com.sec.chaton.poston;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.hardware.motion.MotionRecognitionManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
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
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2074ag;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4838bc;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4899t;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PostONWriteFragment extends Fragment implements InterfaceC2984bb, InterfaceC3026u {

    /* renamed from: Z */
    private static String f10967Z = C4873ck.m18502c() + "/poston/";

    /* renamed from: aa */
    private static String f10968aa = ".jpg";

    /* renamed from: A */
    private ImageButton f10969A;

    /* renamed from: B */
    private String f10970B;

    /* renamed from: C */
    private String f10971C;

    /* renamed from: D */
    private String f10972D;

    /* renamed from: E */
    private AlertDialogC4916i f10973E;

    /* renamed from: F */
    private ProgressDialog f10974F;

    /* renamed from: G */
    private InterfaceC4936e f10975G;

    /* renamed from: H */
    private C2074ag f10976H;

    /* renamed from: I */
    private Toast f10977I;

    /* renamed from: J */
    private String f10978J;

    /* renamed from: K */
    private String f10979K;

    /* renamed from: L */
    private MenuItem f10980L;

    /* renamed from: M */
    private boolean f10981M;

    /* renamed from: N */
    private Uri f10982N;

    /* renamed from: O */
    private Uri f10983O;

    /* renamed from: P */
    private int f10984P;

    /* renamed from: Q */
    private int f10985Q;

    /* renamed from: R */
    private boolean f10986R;

    /* renamed from: U */
    private C3023r f10989U;

    /* renamed from: V */
    private C5007c f10990V;

    /* renamed from: W */
    private GridView f10991W;

    /* renamed from: X */
    private String f10992X;

    /* renamed from: Y */
    private String f10993Y;

    /* renamed from: ad */
    private AsyncTaskC3006bx f10997ad;

    /* renamed from: ae */
    private boolean f10998ae;

    /* renamed from: af */
    private boolean f10999af;

    /* renamed from: ag */
    private boolean f11000ag;

    /* renamed from: c */
    int f11008c;

    /* renamed from: q */
    private ImageButton f11022q;

    /* renamed from: r */
    private ImageButton f11023r;

    /* renamed from: s */
    private ImageButton f11024s;

    /* renamed from: t */
    private ImageButton f11025t;

    /* renamed from: u */
    private TextView f11026u;

    /* renamed from: v */
    private int f11027v;

    /* renamed from: w */
    private EditText f11028w;

    /* renamed from: x */
    private LinearLayout f11029x;

    /* renamed from: y */
    private LinearLayout f11030y;

    /* renamed from: z */
    private TextView f11031z;

    /* renamed from: d */
    private final String f11009d = "PostONWriteFragment";

    /* renamed from: e */
    private final int f11010e = 0;

    /* renamed from: f */
    private final int f11011f = 1;

    /* renamed from: g */
    private final int f11012g = 1;

    /* renamed from: h */
    private final int f11013h = 2;

    /* renamed from: i */
    private final int f11014i = 3;

    /* renamed from: j */
    private final int f11015j = 4;

    /* renamed from: k */
    private final int f11016k = 5;

    /* renamed from: l */
    private final int f11017l = 6;

    /* renamed from: m */
    private final int f11018m = 7;

    /* renamed from: n */
    private final int f11019n = 140;

    /* renamed from: o */
    private final int f11020o = 255;

    /* renamed from: p */
    private final int f11021p = 153;

    /* renamed from: S */
    private ArrayList<PreviewData> f10987S = new ArrayList<>();

    /* renamed from: T */
    private ArrayList<PreviewData> f10988T = new ArrayList<>();

    /* renamed from: a */
    int f10994a = 0;

    /* renamed from: b */
    int f11007b = 0;

    /* renamed from: ab */
    private boolean f10995ab = false;

    /* renamed from: ac */
    private boolean f10996ac = false;

    /* renamed from: ah */
    private TextWatcher f11001ah = new C3001bs(this);

    /* renamed from: ai */
    private View.OnClickListener f11002ai = new ViewOnClickListenerC2989bg(this);

    /* renamed from: aj */
    private DialogInterface.OnClickListener f11003aj = new DialogInterfaceOnClickListenerC2990bh(this);

    /* renamed from: ak */
    private Handler f11004ak = new HandlerC2993bk(this);

    /* renamed from: al */
    private Handler f11005al = new HandlerC2994bl(this);

    /* renamed from: am */
    private Handler f11006am = new HandlerC2995bm(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ("MY_PAGE".equals(getActivity().getIntent().getExtras().getString("WRITE_FROM"))) {
            this.f10981M = true;
        } else {
            this.f10981M = false;
        }
        if (getActivity().getIntent().getExtras().getString("CHATON_ID") != null) {
            this.f10979K = getActivity().getIntent().getExtras().getString("CHATON_ID");
        } else {
            this.f10979K = C4809aa.m18104a().m18121a("chaton_id", "");
        }
        this.f10978J = C4809aa.m18104a().m18121a("Push Name", "");
        this.f10993Y = f10967Z + this.f10979K;
        this.f10985Q = 0;
        this.f10984P = 0;
        this.f10975G = null;
        this.f10986R = false;
        this.f10999af = false;
        this.f10976H = new C2074ag(this.f11006am);
        BaseActivity.m6160a((Fragment) this, true);
        this.f10977I = C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_poston_write, viewGroup, false);
        this.f11028w = (EditText) viewInflate.findViewById(R.id.poston_text);
        this.f11028w.addTextChangedListener(this.f11001ah);
        this.f11028w.setFilters(new InputFilter[]{new C4902w(getActivity(), 140)});
        this.f11028w.setOnEditorActionListener(new C2985bc(this));
        this.f11029x = (LinearLayout) viewInflate.findViewById(R.id.llayout_location_text);
        this.f11031z = (TextView) this.f11029x.findViewById(R.id.location_text);
        this.f10969A = (ImageButton) this.f11029x.findViewById(R.id.location_delete);
        this.f11029x.setOnClickListener(this.f11002ai);
        this.f11022q = (ImageButton) viewInflate.findViewById(R.id.camera_button);
        if (!C4822an.m18251s()) {
            this.f11022q.setEnabled(false);
        }
        this.f11023r = (ImageButton) viewInflate.findViewById(R.id.image_button);
        this.f11024s = (ImageButton) viewInflate.findViewById(R.id.video_button);
        this.f11025t = (ImageButton) viewInflate.findViewById(R.id.location_button);
        if (C1427a.m7518a()) {
            this.f11025t.setVisibility(0);
        } else {
            this.f11025t.setVisibility(8);
        }
        this.f11026u = (TextView) viewInflate.findViewById(R.id.text_length);
        this.f11030y = (LinearLayout) viewInflate.findViewById(R.id.contents_preview_panel);
        this.f10991W = (GridView) viewInflate.findViewById(R.id.contents_preview_grid_view);
        this.f10974F = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.wait_sending);
        if (bundle != null) {
            String string = bundle.getString("CAPTURE_IMAGE_URI");
            String string2 = bundle.getString("IMAGE_URI");
            ArrayList<PreviewData> parcelableArrayList = bundle.getParcelableArrayList("IMAGE_MULTIMEDIA_ARRAY");
            ArrayList<PreviewData> parcelableArrayList2 = bundle.getParcelableArrayList("IMAGE_MULTIMEDIA_ARRAY_FAIL");
            String string3 = bundle.getString("LOCATION_ADDRESS_URI");
            String string4 = bundle.getString("LOCATION_POINT_URI");
            int i = bundle.getInt("TEXT_LENGTH_VALUE");
            this.f10986R = bundle.getBoolean("IS_CAMERA_CALLED");
            this.f10999af = bundle.getBoolean("IS_VIDEO_ATTACHED");
            if (!TextUtils.isEmpty(string)) {
                this.f10983O = Uri.parse(string);
            }
            if (!TextUtils.isEmpty(string2)) {
                this.f10982N = Uri.parse(string2);
            }
            if (!parcelableArrayList.isEmpty()) {
                this.f10987S = parcelableArrayList;
                m12347b();
            }
            if (!parcelableArrayList2.isEmpty()) {
                this.f10988T = parcelableArrayList2;
            }
            if (!TextUtils.isEmpty(string3)) {
                this.f10972D = string3;
            }
            if (!TextUtils.isEmpty(string4)) {
                this.f10971C = string4;
                m12324g();
            }
            this.f11027v = i;
            this.f11026u.setText(this.f11027v + "/140");
            this.f11000ag = false;
            this.f11030y.setVisibility(8);
        }
        m12315c(getActivity().getResources().getConfiguration().orientation);
        m12318d();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m12315c(configuration.orientation);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f10983O != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f10983O.toString());
        }
        if (this.f10982N != null) {
            bundle.putString("IMAGE_URI", this.f10982N.toString());
        }
        if (this.f10987S != null) {
            bundle.putParcelableArrayList("IMAGE_MULTIMEDIA_ARRAY", this.f10987S);
        }
        if (this.f10988T != null) {
            bundle.putParcelableArrayList("IMAGE_MULTIMEDIA_ARRAY_FAIL", this.f10988T);
        }
        if (!TextUtils.isEmpty(this.f10972D)) {
            bundle.putString("LOCATION_ADDRESS_URI", this.f10972D);
        }
        if (!TextUtils.isEmpty(this.f10971C)) {
            bundle.putString("LOCATION_POINT_URI", this.f10971C);
        }
        bundle.putInt("TEXT_LENGTH_VALUE", this.f11027v);
        bundle.putBoolean("IS_CAMERA_CALLED", this.f10986R);
        bundle.putBoolean("IS_VIDEO_ATTACHED", this.f10999af);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_write_poston_menu, menu);
        this.f10980L = menu.findItem(R.id.write_poston_menu_post);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (this.f10995ab) {
            this.f10980L.setEnabled(true);
        } else {
            this.f10980L.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.write_poston_menu_cancel) {
            getActivity().finish();
        }
        if (menuItem.getItemId() == R.id.write_poston_menu_post) {
            if (C4847bl.m18333a()) {
                C4904y.m18646e("MultiClickBlocker", getClass().getSimpleName());
                return true;
            }
            if (this.f10998ae) {
                C5179v.m19810a(getActivity(), R.string.download_progressing, 0).show();
                return true;
            }
            if (this.f10987S != null && this.f10987S.size() > 0) {
                int iM10677a = C2471v.m10677a(getActivity());
                if (-3 == iM10677a || -2 == iM10677a) {
                    this.f10977I.show();
                    return true;
                }
                if (this.f10999af) {
                    this.f10997ad = new AsyncTaskC3006bx(this, this.f10987S, EnumC2214ab.VIDEO);
                    this.f10997ad.execute(new Void[0]);
                    return true;
                }
                this.f10997ad = new AsyncTaskC3006bx(this, this.f10987S, EnumC2214ab.IMAGE);
                this.f10997ad.execute(new Void[0]);
                return true;
            }
            m12305a((ArrayList<PreviewData>) null);
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
        if (this.f11028w != null) {
            this.f11028w.removeTextChangedListener(this.f11001ah);
        }
        if (this.f10991W != null) {
            this.f10991W.setOnItemClickListener(null);
            this.f10991W.setAdapter((ListAdapter) null);
        }
        if (this.f10990V != null) {
            this.f10990V.m19014a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f10997ad != null) {
            this.f10997ad.m12356a();
        }
        if (this.f10975G != null) {
            this.f10975G.dismiss();
        }
        if (this.f10974F != null) {
            this.f10974F.dismiss();
        }
        if (this.f10973E != null && this.f10973E.isShowing()) {
            this.f10973E.dismiss();
        }
        if (this.f10987S != null && !this.f10987S.isEmpty()) {
            this.f10987S.clear();
            this.f10989U = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12299a(EditText editText, boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        Handler handler = null;
        if (inputMethodManager.isActive()) {
            if (z) {
                inputMethodManager.showSoftInput(editText, 0, new ResultReceiver(handler) { // from class: com.sec.chaton.poston.PostONWriteFragment.2
                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int i, Bundle bundle) {
                        if (i == 0) {
                            PostONWriteFragment.this.f11030y.setVisibility(8);
                        }
                    }
                });
            } else {
                inputMethodManager.hideSoftInputFromWindow(this.f11028w.getWindowToken(), 0, new ResultReceiver(handler) { // from class: com.sec.chaton.poston.PostONWriteFragment.3
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
    public void m12305a(ArrayList<PreviewData> arrayList) {
        if (this.f11028w.getText().toString() != null) {
            C4904y.m18646e("PostONCommentItem: " + this.f11028w.getText().toString(), getClass().getSimpleName());
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                if (this.f10999af) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i) != null && arrayList.get(i).m11984f() != null) {
                            C4904y.m18646e("writePostONImage / url = " + arrayList.get(i).m11984f(), getClass().getSimpleName());
                            arrayList2.add(m12294a(arrayList.get(i).m11984f(), Spam.ACTIVITY_CHECK));
                        }
                    }
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (arrayList.get(i2) != null && arrayList.get(i2).m11984f() != null) {
                            C4904y.m18646e("writePostONVideo / url = " + arrayList.get(i2).m11984f(), getClass().getSimpleName());
                            arrayList2.add(m12294a(arrayList.get(i2).m11984f(), Spam.ACTIVITY_REPORT));
                        }
                    }
                }
            }
            if (this.f10970B != null && this.f10970B.length() > 0) {
                C4904y.m18646e("writePostON / LocationData = " + this.f10970B, getClass().getSimpleName());
                arrayList2.add(m12294a(this.f10970B, "3"));
            }
            m12299a(this.f11028w, false);
            this.f10976H.m9287a(new C3016k(this.f10979K, this.f10979K, this.f10978J, this.f11028w.getText().toString(), String.valueOf(System.currentTimeMillis()), Spam.ACTIVITY_CANCEL, Spam.ACTIVITY_CANCEL, "-1", arrayList2, null, null, null), this.f10979K);
            this.f10974F.show();
        }
    }

    /* renamed from: com.sec.chaton.poston.PostONWriteFragment$4 */
    class ResultReceiverC29544 extends ResultReceiver {
        final /* synthetic */ PostONWriteFragment this$0;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            if (i == 3 && !this.this$0.f10987S.isEmpty()) {
                this.this$0.f11030y.setVisibility(0);
            }
        }
    }

    /* renamed from: a */
    private C3007by m12294a(String str, String str2) {
        C3007by c3007by = new C3007by(this);
        if (!str2.equals("3")) {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit != null) {
                for (int i = 0; i < strArrSplit.length; i++) {
                    C4904y.m18646e(" strArray[" + i + "]= " + strArrSplit[i], getClass().getSimpleName());
                }
                if (strArrSplit.length == 3) {
                    c3007by.f11124a = strArrSplit[0] + "/";
                    c3007by.f11125b = strArrSplit[2] + "/" + strArrSplit[1];
                    c3007by.f11126c = str2;
                }
            }
        } else {
            c3007by.f11124a = str;
            c3007by.f11125b = str;
            c3007by.f11126c = str2;
        }
        return c3007by;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12300a(PreviewData previewData) throws Throwable {
        File file;
        String strM11982d;
        String string = Long.toString(System.currentTimeMillis());
        if (previewData.m11982d() == null) {
            file = new File(previewData.m11976a());
            strM11982d = previewData.m11976a();
        } else {
            file = new File(previewData.m11982d());
            strM11982d = previewData.m11982d();
        }
        if (C4838bc.m18308a(file) && !this.f10999af) {
            try {
                File fileM18310b = C4838bc.m18310b(getActivity(), file, "/poston/" + this.f10979K, null, true);
                if (fileM18310b != null) {
                    previewData.m11977a(fileM18310b.getAbsolutePath());
                    previewData.m11981c(fileM18310b.getName());
                    C4904y.m18646e("yeseul / getAbsolutePath : " + fileM18310b.getAbsolutePath() + "/ getName()" + fileM18310b.getName(), getClass().getSimpleName());
                    return;
                }
                return;
            } catch (FileNotFoundException e) {
                C4904y.m18635a(e, "PostONWriteFragment");
                return;
            } catch (IOException e2) {
                C4904y.m18635a(e2, "PostONWriteFragment");
                return;
            } catch (Exception e3) {
                C4904y.m18635a(e3, "PostONWriteFragment");
                return;
            } catch (OutOfMemoryError e4) {
                C4904y.m18635a(e4, "PostONWriteFragment");
                return;
            }
        }
        String str = string + file.getName().substring(file.getName().indexOf("."));
        C4904y.m18646e("yeseul / PostONFilePath :" + this.f10993Y + "/" + str + " /mImageId: " + string, getClass().getSimpleName());
        try {
            C4894o.m18603a(strM11982d, this.f10993Y, str);
            previewData.m11977a(this.f10993Y + "/" + str);
            previewData.m11981c(str);
        } catch (Exception e5) {
            C4904y.m18635a(e5, getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public AlertDialogC4916i m12312c() {
        if (this.f10973E == null) {
            this.f10973E = new AlertDialogC4916i(getActivity());
            this.f10973E.setTitle(R.string.poston_upload);
            this.f10973E.setMessage(getString(R.string.upload_body));
            this.f10973E.setCancelable(false);
        }
        this.f10973E.setButton(-2, getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC3000br(this));
        return this.f10973E;
    }

    /* renamed from: d */
    private void m12318d() {
        this.f11028w.setOnClickListener(new ViewOnClickListenerC3002bt(this));
        this.f11022q.setOnClickListener(new ViewOnClickListenerC3003bu(this));
        this.f11023r.setOnClickListener(new ViewOnClickListenerC3004bv(this));
        this.f11024s.setOnClickListener(new ViewOnClickListenerC2986bd(this));
        this.f11025t.setOnClickListener(new ViewOnClickListenerC2987be(this));
        this.f10969A.setOnClickListener(new ViewOnClickListenerC2988bf(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        File file;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.f10986R = true;
                    this.f10999af = false;
                    if (this.f10983O != null) {
                        MediaScannerConnection.scanFile(getActivity(), new String[]{this.f10983O.getPath()}, null, null);
                    }
                    if (getActivity() != null && !getActivity().isFinishing()) {
                        Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent2.setDataAndType(this.f10983O, "image/*");
                        intent2.putExtra("return-data", true);
                        intent2.putExtra("randomFName", true);
                        startActivityForResult(intent2, 11);
                        break;
                    }
                    break;
                case 2:
                    this.f10999af = false;
                    if (intent == null) {
                        C4904y.m18639b("To pick image From Gallery is NULL", "PostONWriteFragment");
                        C5179v.m19810a(CommonApplication.m18732r(), R.string.toast_error, 0).show();
                        break;
                    } else if (getActivity() != null && !getActivity().isFinishing()) {
                        this.f10982N = intent.getData();
                        Intent intent3 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent3.setDataAndType(this.f10982N, "image/*");
                        intent3.putExtra("return-data", true);
                        intent3.putExtra("randomFName", true);
                        startActivityForResult(intent3, 10);
                        break;
                    }
                    break;
                case 3:
                    this.f10999af = false;
                    if (this.f10987S.size() == 0) {
                        this.f10987S = intent.getParcelableArrayListExtra("preview_data");
                    } else {
                        Iterator it = intent.getParcelableArrayListExtra("preview_data").iterator();
                        while (it.hasNext()) {
                            this.f10987S.add((PreviewData) it.next());
                        }
                    }
                    m12347b();
                    break;
                case 4:
                case 10:
                case 11:
                    this.f10999af = false;
                    if (intent == null) {
                        C4904y.m18639b("To pick image From Gallery is NULL", "PostONWriteFragment");
                        break;
                    } else {
                        if (this.f10984P != 0) {
                            this.f10984P++;
                        } else {
                            this.f10984P = 1;
                        }
                        String string = intent.getExtras().getString("temp_file_path");
                        if (this.f10987S != null) {
                            if (this.f10986R && this.f10983O != null) {
                                this.f10987S.add(new PreviewData(this.f10983O.toString(), null, null, string, null));
                                this.f10986R = false;
                            } else if (this.f10982N != null) {
                                this.f10987S.add(new PreviewData(this.f10982N.toString(), null, null, string, null));
                            }
                        }
                        m12347b();
                        break;
                    }
                    break;
                case 5:
                    this.f10999af = false;
                    C4904y.m18639b("Get the item modified by effect function", "PostONWriteFragment");
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("temp_file_path");
                        if (!this.f10987S.isEmpty()) {
                            this.f10987S.get(this.f10985Q).m11977a(stringExtra);
                            this.f10991W.invalidateViews();
                            this.f11000ag = true;
                            this.f11030y.setVisibility(0);
                            this.f10991W.setVisibility(0);
                            this.f11029x.setVisibility(8);
                            break;
                        }
                    }
                    break;
                case 6:
                    this.f10999af = true;
                    if (intent == null) {
                        C4904y.m18639b("To pick image From Gallery is NULL", "PostONWriteFragment");
                        C5179v.m19810a(CommonApplication.m18732r(), R.string.toast_error, 0).show();
                        break;
                    } else {
                        if ("file".equals(intent.getData().getScheme())) {
                            file = new File(intent.getData().getPath());
                        } else {
                            C4899t c4899tM18615c = C4894o.m18615c(intent.getData().toString());
                            file = c4899tM18615c != null ? c4899tM18615c.f17859a : null;
                        }
                        if (file != null) {
                            if (file.length() <= 31457280) {
                                this.f10987S.add(new PreviewData(file.getAbsolutePath(), file.getName(), null, null, null));
                                C4904y.m18646e("fi.getAbsolutePath(): " + file.getAbsolutePath() + " /fi.getName(): " + file.getName(), "PostONWriteFragment");
                                m12347b();
                                break;
                            } else {
                                C5179v.m19811a(getActivity(), CommonApplication.m18732r().getString(R.string.maximum_file_size_exceeded, 30L), 0).show();
                                break;
                            }
                        } else {
                            if (C4904y.f17875e) {
                                C4904y.m18634a("sendVideo file is null", "PostONWriteFragment");
                            }
                            C5179v.m19810a(CommonApplication.m18732r(), R.string.toast_error, 0).show();
                            break;
                        }
                    }
                case 7:
                    m12298a(intent);
                    break;
            }
            return;
        }
        if (m12307a(i, intent)) {
        }
    }

    /* renamed from: a */
    private boolean m12307a(int i, Intent intent) {
        switch (i) {
            case 10:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m12320e();
                    return true;
                }
                break;
            case 11:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m12322f();
                    return true;
                }
                break;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12320e() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        try {
            startActivityForResult(intent, 2);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "PostONWriteFragment");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12322f() {
        if (!C4822an.m18245m() || !C4822an.m18246n()) {
            C5179v.m19810a(getActivity(), R.string.recordvideo_unable_to_record_during_call, 0).show();
            return;
        }
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getActivity(), R.string.sdcard_not_found, 0).show();
            return;
        }
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + f10968aa;
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//");
        if (!file.exists()) {
            file.mkdir();
        }
        this.f10983O = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//", str));
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("return-data", false);
        intent.putExtra("output", this.f10983O);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        try {
            startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "PostONWriteFragment");
            }
        }
    }

    /* renamed from: a */
    private void m12298a(Intent intent) {
        if (intent != null && intent.getStringExtra("GEOPOINT") != null) {
            this.f11000ag = true;
            m12306a(true);
            this.f10972D = intent.getStringExtra("GEOADDRESS");
            this.f10971C = intent.getStringExtra("GEOPOINT");
            C4904y.m18646e("GEOPOINT: " + this.f10971C + "/ GEOADDRESS: " + this.f10972D, getClass().getSimpleName());
            m12324g();
        }
    }

    /* renamed from: g */
    private void m12324g() {
        if (TextUtils.isEmpty(this.f10972D)) {
            this.f10972D = getString(R.string.menu_multimedia_geo_tag);
        }
        this.f10970B = "(" + this.f10971C + ", " + this.f10972D + ")";
        this.f11031z.setText(this.f10972D);
        this.f11029x.setVisibility(0);
        this.f11025t.setSelected(true);
        if (this.f11030y.getVisibility() == 8) {
            this.f11030y.setVisibility(0);
        }
        this.f10991W.setVisibility(8);
        this.f11029x.setVisibility(0);
    }

    /* renamed from: b */
    void m12347b() {
        this.f11000ag = true;
        if (this.f11030y.getVisibility() == 8 && !this.f10987S.isEmpty()) {
            this.f11030y.setVisibility(0);
        }
        this.f10990V = new C5007c();
        this.f10989U = new C3023r(getActivity(), R.layout.item_poston_preview_contents, this.f10987S, this.f10990V);
        this.f10989U.m12388a(this);
        this.f10991W.setAdapter((ListAdapter) this.f10989U);
        this.f10991W.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        if (this.f10987S.size() >= 1) {
            this.f11029x.setVisibility(8);
            this.f10991W.setVisibility(0);
            this.f10995ab = true;
            if (this.f10980L != null) {
                this.f10980L.setEnabled(true);
            }
            if (this.f10999af) {
                this.f10989U.m12389a(true);
                this.f11022q.setEnabled(false);
                this.f11024s.setSelected(true);
                this.f11023r.setEnabled(false);
                return;
            }
            this.f11024s.setEnabled(false);
            this.f10984P = this.f10987S.size();
            if (this.f10984P >= 1) {
                this.f11023r.setEnabled(true);
                this.f11022q.setEnabled(false);
                this.f11023r.setSelected(true);
                return;
            }
            return;
        }
        this.f11022q.setEnabled(true);
        this.f11024s.setEnabled(true);
        this.f11023r.setEnabled(true);
        if (this.f11028w.getText().length() > 0 || !TextUtils.isEmpty(this.f10970B)) {
            m12306a(true);
        } else {
            m12306a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m12326h() {
        if (this.f10973E != null && this.f10973E.isShowing()) {
            this.f10973E.dismiss();
        }
        if (this.f11008c == 0) {
            m12305a(this.f10987S);
            this.f11007b = 0;
        } else {
            this.f10975G = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.poston_title)).mo18749b(getResources().getString(R.string.toast_setting_profile_update_failed)).mo18755c(getResources().getString(R.string.setting_selfsms_retry), new DialogInterfaceOnClickListenerC2992bj(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2991bi(this)).mo18752b();
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC3026u
    /* renamed from: b */
    public void mo12348b(int i) {
        this.f10987S.remove(i);
        if (this.f11030y.getVisibility() == 0 && this.f10987S.isEmpty()) {
            this.f11030y.setVisibility(8);
        }
        this.f10991W.invalidateViews();
        if (this.f10989U != null) {
            this.f10989U.notifyDataSetChanged();
        }
        this.f11022q.setEnabled(true);
        this.f11022q.setSelected(false);
        this.f11023r.setEnabled(true);
        this.f11023r.setSelected(false);
        if (this.f10987S.size() == 0) {
            this.f11024s.setEnabled(true);
            this.f11024s.setSelected(false);
            if (this.f11028w.getText().length() > 0 || !TextUtils.isEmpty(this.f10970B)) {
                m12306a(true);
            } else {
                m12306a(false);
            }
        }
    }

    /* renamed from: a */
    private void m12306a(boolean z) {
        this.f10995ab = z;
        if (this.f10980L != null) {
            this.f10980L.setEnabled(z);
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC3026u
    /* renamed from: a */
    public void mo12345a(int i) {
        if (!this.f10999af) {
            PreviewData previewData = this.f10987S.get(i);
            this.f10985Q = i;
            String strM11982d = previewData.m11982d();
            if (strM11982d == null) {
                m12304a(previewData.m11978b(), true);
            } else {
                m12304a(strM11982d, false);
            }
        }
    }

    /* renamed from: a */
    private void m12304a(String str, boolean z) {
        String str2;
        C4904y.m18639b("[SendingMedia] Start - Picture", getClass().getSimpleName());
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

    @Override // com.sec.chaton.poston.InterfaceC2984bb
    /* renamed from: a */
    public boolean mo12346a() {
        if (this.f11030y.getVisibility() != 0) {
            return true;
        }
        this.f11030y.setVisibility(8);
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f11000ag) {
            this.f11030y.setVisibility(8);
        } else {
            this.f11000ag = false;
            this.f11030y.setVisibility(0);
        }
    }

    /* renamed from: c */
    private void m12315c(int i) {
        LinearLayout.LayoutParams layoutParams = null;
        if (this.f11030y != null) {
            if (i == 2) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            } else if (i == 1) {
                layoutParams = new LinearLayout.LayoutParams(-1, (int) C5034k.m19088a(240.0f));
            }
            this.f11030y.setLayoutParams(layoutParams);
        }
    }
}
