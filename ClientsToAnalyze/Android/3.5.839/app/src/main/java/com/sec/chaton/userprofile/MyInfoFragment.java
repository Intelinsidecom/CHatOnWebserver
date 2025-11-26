package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1047as;
import com.sec.chaton.R;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p114b.AbstractC4439w;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AdaptableTextView;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.SelectableImageView;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p130e.InterfaceC4995d;
import com.sec.common.p132g.C5007c;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import java.io.File;
import java.util.Date;

/* loaded from: classes.dex */
public class MyInfoFragment extends Fragment {

    /* renamed from: c */
    private static final String f17144c = MyInfoFragment.class.getSimpleName();

    /* renamed from: A */
    private TextView f17145A;

    /* renamed from: B */
    private View f17146B;

    /* renamed from: C */
    private TextView f17147C;

    /* renamed from: D */
    private TextView f17148D;

    /* renamed from: E */
    private View f17149E;

    /* renamed from: F */
    private SelectableImageView f17150F;

    /* renamed from: G */
    private SelectableImageView f17151G;

    /* renamed from: H */
    private C2130k f17152H;

    /* renamed from: I */
    private ProgressDialog f17153I;

    /* renamed from: J */
    private File f17154J;

    /* renamed from: K */
    private Uri f17155K;

    /* renamed from: L */
    private File f17156L;

    /* renamed from: M */
    private Uri f17157M;

    /* renamed from: N */
    private InterfaceC4936e f17158N;

    /* renamed from: O */
    private C4756bo f17159O;

    /* renamed from: P */
    private LayoutInflater f17160P;

    /* renamed from: Q */
    private C5007c f17161Q;

    /* renamed from: R */
    private String f17162R;

    /* renamed from: S */
    private Handler f17163S = new HandlerC4721ag(this);

    /* renamed from: T */
    private DialogInterface.OnClickListener f17164T = new DialogInterfaceOnClickListenerC4804w(this);

    /* renamed from: U */
    private DialogInterface.OnClickListener f17165U = new DialogInterfaceOnClickListenerC4805x(this);

    /* renamed from: V */
    private Handler f17166V = new HandlerC4806y(this);

    /* renamed from: a */
    View f17167a;

    /* renamed from: b */
    View f17168b;

    /* renamed from: d */
    private View f17169d;

    /* renamed from: e */
    private String f17170e;

    /* renamed from: f */
    private String f17171f;

    /* renamed from: g */
    private String f17172g;

    /* renamed from: h */
    private C2075ah f17173h;

    /* renamed from: i */
    private View f17174i;

    /* renamed from: j */
    private AbstractC4439w f17175j;

    /* renamed from: k */
    private LinearLayout f17176k;

    /* renamed from: l */
    private TextView f17177l;

    /* renamed from: m */
    private TextView f17178m;

    /* renamed from: n */
    private View f17179n;

    /* renamed from: o */
    private TextView f17180o;

    /* renamed from: p */
    private TextView f17181p;

    /* renamed from: q */
    private View f17182q;

    /* renamed from: r */
    private TextView f17183r;

    /* renamed from: s */
    private TextView f17184s;

    /* renamed from: t */
    private LinearLayout f17185t;

    /* renamed from: u */
    private View f17186u;

    /* renamed from: v */
    private TextView f17187v;

    /* renamed from: w */
    private TextView f17188w;

    /* renamed from: x */
    private LinearLayout f17189x;

    /* renamed from: y */
    private View f17190y;

    /* renamed from: z */
    private TextView f17191z;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m17844b();
        this.f17173h = new C2075ah(this.f17163S);
        this.f17152H = new C2130k(this.f17163S);
        this.f17161Q = new C5007c();
        this.f17153I = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_userprofile_updating);
        try {
            this.f17162R = getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
        if (C4809aa.m18104a().m18119a("coverstory_first_set", (Boolean) true).booleanValue()) {
            C4904y.m18639b(" myInfo onCreate listCoverStory First @@@@", f17144c);
            this.f17152H.m9544c();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        this.f17160P = layoutInflater;
        this.f17174i = layoutInflater.inflate(R.layout.layout_mypage_info, (ViewGroup) null);
        this.f17150F = (SelectableImageView) this.f17174i.findViewById(R.id.profile_image_view);
        this.f17151G = (SelectableImageView) this.f17174i.findViewById(R.id.coverstory_image_view);
        View viewFindViewById = this.f17174i.findViewById(R.id.layout_name);
        this.f17176k = (LinearLayout) viewFindViewById.findViewById(R.id.layout);
        this.f17177l = (TextView) viewFindViewById.findViewById(R.id.title);
        this.f17178m = (TextView) viewFindViewById.findViewById(R.id.content);
        this.f17177l.setText(R.string.mypage_profile_name);
        View viewFindViewById2 = this.f17174i.findViewById(R.id.layout_status);
        this.f17179n = (LinearLayout) viewFindViewById2.findViewById(R.id.layout);
        this.f17180o = (TextView) viewFindViewById2.findViewById(R.id.title);
        this.f17181p = (TextView) viewFindViewById2.findViewById(R.id.content);
        this.f17180o.setText(R.string.mypage_profile_status);
        this.f17167a = this.f17174i.findViewById(R.id.layout_phone);
        this.f17182q = (LinearLayout) this.f17167a.findViewById(R.id.layout);
        this.f17183r = (TextView) this.f17167a.findViewById(R.id.title);
        this.f17184s = (TextView) this.f17167a.findViewById(R.id.content);
        this.f17183r.setText(R.string.buddy_phone_number);
        this.f17168b = this.f17174i.findViewById(R.id.layout_account);
        this.f17186u = (LinearLayout) this.f17168b.findViewById(R.id.layout);
        this.f17187v = (TextView) this.f17168b.findViewById(R.id.title);
        this.f17188w = (TextView) this.f17168b.findViewById(R.id.content);
        this.f17187v.setText(R.string.setting_account);
        View viewFindViewById3 = this.f17174i.findViewById(R.id.layout_birthday);
        this.f17190y = (LinearLayout) viewFindViewById3.findViewById(R.id.layout);
        this.f17191z = (TextView) viewFindViewById3.findViewById(R.id.title);
        this.f17145A = (TextView) viewFindViewById3.findViewById(R.id.content);
        this.f17191z.setText(R.string.settings_birthday_category);
        View viewFindViewById4 = this.f17174i.findViewById(R.id.layout_privacy);
        this.f17146B = (LinearLayout) viewFindViewById4.findViewById(R.id.layout);
        this.f17147C = (TextView) viewFindViewById4.findViewById(R.id.title);
        this.f17148D = (TextView) viewFindViewById4.findViewById(R.id.content);
        this.f17147C.setText(R.string.info_privacy_setting);
        this.f17149E = this.f17174i.findViewById(R.id.layout_barrier);
        ((AdaptableTextView) this.f17149E.findViewById(R.id.text1)).setText(R.string.setting_category_privacy);
        m17852f();
        m17850e();
        m17847c();
        C0991aa.m6037a().m18959a(this);
        setHasOptionsMenu(true);
        return this.f17174i;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m17844b();
        m17850e();
        if (C4822an.m18255w()) {
            m17849d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17844b() {
        this.f17170e = C4809aa.m18104a().m18121a("msisdn", "");
        this.f17171f = C4809aa.m18104a().m18121a("chaton_id", "");
        if (C4822an.m18255w()) {
            this.f17172g = C4822an.m18254v();
        } else {
            this.f17172g = "";
        }
        if (this.f17145A != null) {
            if (C4809aa.m18104a().m18119a("birthday_show", (Boolean) true).booleanValue() || C4809aa.m18104a().m18121a("birthday", "").length() == 0) {
                this.f17145A.setTextAppearance(getActivity(), R.style.TextAppearance_List04);
            } else {
                this.f17145A.setTextAppearance(getActivity(), R.style.MyInfoGreyTextStyle);
            }
        }
    }

    @InterfaceC4995d
    public void onMyProfileImageChanged(C1047as c1047as) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onMyProfileImageChanged", f17144c);
        }
        C2496n.m10763a(this.f17150F, EnumC2498p.SQUARE);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f17153I != null && this.f17153I.isShowing()) {
            this.f17153I.dismiss();
        }
        if (this.f17158N != null) {
            this.f17158N.dismiss();
        }
        C0991aa.m6037a().m18960b(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f17173h != null) {
            this.f17173h.m9321h();
        }
        super.onDestroy();
    }

    /* renamed from: c */
    private void m17847c() {
        this.f17150F.setOnClickListener(new ViewOnClickListenerC4803v(this));
        this.f17151G.setOnClickListener(new ViewOnClickListenerC4807z(this));
        this.f17176k.setOnClickListener(new ViewOnClickListenerC4715aa(this));
        this.f17179n.setOnClickListener(new ViewOnClickListenerC4716ab(this));
        this.f17190y.setOnClickListener(new ViewOnClickListenerC4717ac(this));
        this.f17146B.setOnClickListener(new ViewOnClickListenerC4718ad(this));
    }

    /* renamed from: d */
    private void m17849d() {
        if (C4904y.f17871a) {
            C4904y.m18646e("getProfileImageInfo()", f17144c);
        }
        this.f17173h.m9310b(null, "4");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m17850e() throws Resources.NotFoundException {
        this.f17178m.setText(C4809aa.m18104a().m18121a("Push Name", ""));
        String strM18121a = C4809aa.m18104a().m18121a("status_message", "");
        if (!TextUtils.isEmpty(strM18121a)) {
            this.f17181p.setText(strM18121a);
        } else {
            this.f17181p.setText(R.string.mypage_enter_status_message);
        }
        this.f17185t = (LinearLayout) this.f17167a.findViewById(R.id.space1);
        this.f17185t.removeAllViews();
        this.f17184s.setText(R.string.mypage_register_phone_number);
        this.f17167a.setClickable(true);
        this.f17167a.setOnClickListener(new ViewOnClickListenerC4719ae(this));
        if (C4822an.m18255w()) {
            String strM18121a2 = C4809aa.m18104a().m18121a("msisdn1", "");
            String strM18121a3 = C4809aa.m18104a().m18121a("msisdn2", "");
            String strM18121a4 = C4809aa.m18104a().m18121a("msisdn3", "");
            String strM18121a5 = C4809aa.m18104a().m18121a("msisdn4", "");
            if (!strM18121a2.isEmpty()) {
                m17845b(strM18121a2);
            }
            if (!strM18121a3.isEmpty()) {
                m17845b(strM18121a3);
            }
            if (!strM18121a4.isEmpty()) {
                m17845b(strM18121a4);
            }
            if (!strM18121a5.isEmpty()) {
                m17845b(strM18121a5);
            }
        } else {
            String strM18121a6 = C4809aa.m18104a().m18121a("msisdn", "");
            if (!strM18121a6.isEmpty()) {
                m17845b(strM18121a6);
            }
        }
        if (C4822an.m18255w() && this.f17172g.length() != 0) {
            this.f17188w.setText(this.f17172g);
            this.f17188w.setVisibility(0);
            this.f17168b.setClickable(false);
        } else if (!C4822an.m18197G()) {
            this.f17188w.setText(R.string.sns_account_sign_in);
            this.f17168b.setOnClickListener(new ViewOnClickListenerC4720af(this));
            this.f17168b.setClickable(true);
        }
        m17866a(this.f17145A);
        this.f17148D.setText(R.string.mypage_information_privacy_text);
        if (C4822an.m18197G()) {
            this.f17168b.setClickable(false);
            if (this.f17175j == null) {
                this.f17175j = AbstractC4439w.m16816a(C4822an.m18198H(), getActivity());
            }
            this.f17168b.setVisibility(0);
            this.f17189x = (LinearLayout) this.f17168b.findViewById(R.id.space1);
            this.f17189x.removeAllViews();
            this.f17189x.setVisibility(0);
            View viewInflate = this.f17160P.inflate(R.layout.layout_sns_info_item, (ViewGroup) this.f17189x, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.sns_info_type);
            TextView textView = (TextView) viewInflate.findViewById(R.id.sns_info_name);
            if (C4368e.f15815a.equalsIgnoreCase(C4822an.m18198H())) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.facebook_btn_normal));
            } else if (C4368e.f15817c.equalsIgnoreCase(C4822an.m18198H())) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.profile_info_ic_weibo));
            } else if (C4368e.f15818d.equalsIgnoreCase(C4822an.m18198H())) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.odnoklassniki_btn_normal));
            } else if (C4368e.f15820f.equalsIgnoreCase(C4822an.m18198H())) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.vkontakte_btn_normal));
            }
            textView.setText(this.f17175j.mo16647b());
            this.f17189x.addView(viewInflate);
        }
    }

    /* renamed from: b */
    private void m17845b(String str) {
        this.f17167a.setVisibility(0);
        this.f17167a.setClickable(false);
        this.f17184s.setVisibility(8);
        this.f17185t.setVisibility(0);
        View viewInflate = this.f17160P.inflate(R.layout.layout_sns_info_item, (ViewGroup) this.f17185t, false);
        ((ImageView) viewInflate.findViewById(R.id.sns_info_type)).setVisibility(8);
        TextView textView = (TextView) viewInflate.findViewById(R.id.sns_info_name);
        textView.setText("+" + str);
        if (C4809aa.m18104a().m18121a("msisdn", "").equals(str)) {
            if (C4809aa.m18104a().m18119a("show_phone_number_to_all", (Boolean) true).booleanValue()) {
                textView.setTextAppearance(getActivity(), R.style.TextAppearance_List04);
                if (C4904y.f17872b) {
                    C4904y.m18639b("PREF_SHOW_PHONE_NUMBER_TO_ALL = true", getClass().getSimpleName());
                }
            } else {
                textView.setTextAppearance(getActivity(), R.style.MyInfoGreyTextStyle);
            }
        }
        this.f17185t.addView(viewInflate);
    }

    /* renamed from: f */
    private void m17852f() {
        C2496n.m10763a(this.f17150F, EnumC2498p.SQUARE);
        if ("updated".equals(C4809aa.m18104a().m18121a("mypage_coverstory_state", ""))) {
            if (C4904y.f17872b) {
                C4904y.m18639b(" coverstory updated image in setImageView()", f17144c);
            }
            C4754bm.m18042a(this.f17151G);
        } else {
            if (C4904y.f17872b) {
                C4904y.m18639b(" coverstory default image loadDefaultCoverStory() in setImageView()", f17144c);
            }
            C1331gk.m7458a(this.f17151G);
        }
    }

    /* renamed from: a */
    public void m17866a(TextView textView) throws Resources.NotFoundException {
        String strM18121a = C4809aa.m18104a().m18121a("birthday_type", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("birthday", "");
        if (strM18121a2 == null || strM18121a2.length() == 0) {
            strM18121a2 = CommonApplication.m18732r().getResources().getString(R.string.add_your_birthday);
        }
        C4904y.m18646e("setBirthDay birthday : " + strM18121a2, f17144c);
        if (textView != null) {
            try {
                if (strM18121a2.equals(CommonApplication.m18732r().getResources().getString(R.string.add_your_birthday))) {
                    textView.setText(CommonApplication.m18732r().getResources().getString(R.string.add_your_birthday));
                } else if (strM18121a.equals("FULL") || strM18121a.equals("FULL_HIDE")) {
                    textView.setText(m17841a(strM18121a2));
                } else if (strM18121a.equals("SHORT") || strM18121a.equals("SHORT_HIDE")) {
                    String[] strArrSplit = strM18121a2.split("-");
                    textView.setText(m17841a(strArrSplit[1] + "-" + strArrSplit[2]));
                } else {
                    textView.setText(CommonApplication.m18732r().getResources().getString(R.string.add_your_birthday));
                }
            } catch (Exception e) {
                C4904y.m18639b("setBirthDay error", f17144c);
                return;
            }
        }
        this.f17169d.setVisibility(0);
    }

    /* renamed from: a */
    public static String m17841a(String str) throws NumberFormatException {
        String strReplaceAll;
        int i;
        int i2;
        int i3;
        C4904y.m18646e("original birthday str:" + str, f17144c);
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.contains(" ") && (str.contains("-") || str.contains("/") || str.contains(".") || str.contains(","))) {
            strReplaceAll = str.replaceAll("\\s", "");
            C4904y.m18646e("trimmed birthday str:" + strReplaceAll, f17144c);
        } else {
            strReplaceAll = str;
        }
        String[] strArrSplit = strReplaceAll.split("-|\\/|\\s|\\.|\\,");
        try {
            if (strReplaceAll.length() == 10) {
                i = Integer.parseInt(strArrSplit[0]) - 1900;
                i2 = Integer.parseInt(strArrSplit[1]) - 1;
                i3 = Integer.parseInt(strArrSplit[2]);
            } else {
                i = 100;
                i2 = Integer.parseInt(strArrSplit[0]) - 1;
                i3 = Integer.parseInt(strArrSplit[1]);
            }
            try {
                String string = DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(i, i2, i3)).toString();
                if (str.length() != 10) {
                    if (string.contains(" ") && (string.contains("-") || string.contains("/") || string.contains(".") || string.contains(","))) {
                        string = string.replaceAll("\\s", "");
                    }
                    String[] strArrSplit2 = string.split("-|\\/|\\s|\\.|\\,");
                    if (strArrSplit2[0].length() == 4) {
                        return string.substring(5);
                    }
                    if (strArrSplit2[2].length() == 4) {
                        return string.substring(0, strArrSplit2[1].length() + strArrSplit2[0].length() + 1);
                    }
                    return string;
                }
                return string;
            } catch (Exception e) {
                C4904y.m18639b("change date format error", f17144c);
                return str;
            }
        } catch (Exception e2) {
            C4904y.m18639b("change date format error", f17144c);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m17855g() {
        this.f17154J = C4754bm.m18041a();
        this.f17155K = Uri.fromFile(this.f17154J);
        if (!C4873ck.m18500a()) {
            C5179v.m19811a(getActivity(), getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        new Intent("android.intent.action.PICK").setType("image/*");
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
        if (C4822an.m18251s()) {
            abstractC4932aM18733a.mo18734a(R.string.change_cover_image).mo18736a(R.array.coverstory_with_camera, this.f17164T);
        } else {
            abstractC4932aM18733a.mo18734a(R.string.change_cover_image).mo18736a(R.array.coverstory_without_camera, this.f17165U);
        }
        abstractC4932aM18733a.mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m17857h() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m17859i() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("return-data", false);
        intent.putExtra("output", this.f17155K);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        startActivityForResult(intent, 12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m17861j() {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
            if (C4904y.f17872b) {
                C4904y.m18639b("setCoverstorySample network error!!", f17144c);
                return;
            }
            return;
        }
        startActivityForResult(new Intent(getActivity(), (Class<?>) CoverstorySampleActivity.class), 13);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 8:
                    int iM10677a = C2471v.m10677a(getActivity());
                    if (-3 == iM10677a || -2 == iM10677a) {
                        C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
                        break;
                    } else if (i2 == -1) {
                        Uri uri = Uri.parse(intent.getExtras().getString("temp_file_path"));
                        File file = new File(uri.getPath());
                        if (file.length() <= 0) {
                            if (C4904y.f17875e) {
                                C4904y.m18634a("Crop return null!", f17144c);
                                break;
                            }
                        } else {
                            try {
                                this.f17153I.show();
                                if (file.exists()) {
                                    this.f17156L = file;
                                    this.f17157M = uri;
                                    new AsyncTaskC4755bn(file, this.f17166V).execute(new Void[0]);
                                    break;
                                }
                            } catch (Exception e) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e, getClass().getSimpleName());
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    break;
                case 10:
                    if (intent == null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Crop Return is NULL", getClass().getSimpleName());
                            break;
                        }
                    } else {
                        this.f17155K = intent.getData();
                        Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent2.setDataAndType(this.f17155K, "image/*");
                        intent2.putExtra("outputX", C4754bm.f17425h);
                        intent2.putExtra("outputY", C4754bm.f17426i);
                        intent2.putExtra("aspectX", 2);
                        intent2.putExtra("aspectY", 3);
                        intent2.putExtra("return-data", true);
                        startActivityForResult(intent2, 8);
                        break;
                    }
                    break;
                case 12:
                    Intent intent3 = new Intent(getActivity().getApplicationContext(), (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f17155K, "image/*");
                    intent3.putExtra("outputX", C4754bm.f17425h);
                    intent3.putExtra("outputY", C4754bm.f17426i);
                    intent3.putExtra("aspectX", 2);
                    intent3.putExtra("aspectY", 3);
                    intent3.putExtra("return-data", true);
                    startActivityForResult(intent3, 8);
                    break;
            }
        }
    }
}
