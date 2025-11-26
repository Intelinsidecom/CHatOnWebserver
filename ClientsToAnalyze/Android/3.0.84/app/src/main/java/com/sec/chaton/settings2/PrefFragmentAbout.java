package com.sec.chaton.settings2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0048d;
import com.sec.chaton.AdminMenu;
import com.sec.chaton.ChatONVUpgradeDialog;
import com.sec.chaton.NewSPPUpgradeDialog;
import com.sec.chaton.R;
import com.sec.chaton.UpgradeDialog;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1306as;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p025d.p026a.C1215cp;
import com.sec.chaton.p035io.entry.AvaliableApps;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;

@TargetApi(11)
/* loaded from: classes.dex */
public class PrefFragmentAbout extends BasePreferenceFragment {
    public static final int CHATON = 0;
    private static final int DIALOG_LICENSE = 1;
    private static final String DIALOG_OPENSOURCE = "dialogOpensource";
    public static final String IS_HEADER_VIEW_REQUIRED = "is_header_view_required";
    public static final int MAX_SERVICE = 3;
    public static final String PACKAGE_NAME_FROM_SERVER = "com.sec.chaton";
    private static final String TAG = "ActivityAbout";
    private static final String fileName = "NOTICE.html";
    protected Boolean critical;
    protected String downloadurl;
    private Activity mActivity;
    private Button[] mButton;
    private Context mContext;
    String[] mCurrentVersion;
    private C1215cp mGetVersionNoticeTask;
    private Button mLicences;
    private int mLogoImageClickCount;
    String[] mNewVersion;
    private TextView mPolicy;
    private TextView mTerms;
    private TextView[] mVersionCurrent;
    private TextView[] mVersionLatest;
    private ListView serviceList;
    private LinearLayout termsLayout;
    protected Boolean update;
    public static int CHATON_V = 1;
    public static int SPP = 2;
    private AboutServiceAdapter serviceAdapter = null;
    private int listViewHeight = -1;
    private C0045a chatonvAPII = null;
    private boolean chatonVUpdate = false;
    public Handler mHandler = new Handler() { // from class: com.sec.chaton.settings2.PrefFragmentAbout.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 1104:
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        GetVersionNotice getVersionNotice = (GetVersionNotice) c0267d.m1354e();
                        if (getVersionNotice != null && getVersionNotice.uptodate != null) {
                            if (!getVersionNotice.uptodate.booleanValue()) {
                                View childAt = PrefFragmentAbout.this.serviceList.getChildAt(0);
                                if (childAt != null && PrefFragmentAbout.this.getActivity() != null) {
                                    PrefFragmentAbout.this.mVersionCurrent[0] = (TextView) childAt.findViewById(R.id.service_current_ver);
                                    PrefFragmentAbout.this.mVersionLatest[0] = (TextView) childAt.findViewById(R.id.service_latest_ver);
                                    PrefFragmentAbout.this.mButton[0] = (Button) childAt.findViewById(R.id.button_update);
                                    PrefFragmentAbout.this.mVersionCurrent[0].setText(PrefFragmentAbout.this.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + PrefFragmentAbout.this.mCurrentVersion[0]);
                                    PrefFragmentAbout.this.mVersionLatest[0].setText(PrefFragmentAbout.this.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (PrefFragmentAbout.this.mNewVersion[0].length() > 0 ? PrefFragmentAbout.this.mNewVersion[0] : PrefFragmentAbout.this.mCurrentVersion[0]));
                                    PrefFragmentAbout.this.mButton[0].setEnabled(true);
                                    PrefFragmentAbout.this.googleAppsUpdate(0);
                                }
                                C3159aa.m10962a().m10986b("UpdateTargetVersion", getVersionNotice.newversion);
                                C3159aa.m10962a().m10983b("UpdateIsCritical", getVersionNotice.critical);
                                C3159aa.m10962a().m10983b("UpdateIsNormal", getVersionNotice.uptodate);
                                C3159aa.m10962a().m10986b("UpdateUrl", getVersionNotice.downloadurl);
                                C3159aa.m10962a().m10986b("SamsungappsUrl", getVersionNotice.samsungappsurl);
                                break;
                            } else {
                                C3171am.m11081s();
                                PrefFragmentAbout.this.dismissVersionUpgradeDialog();
                                break;
                            }
                        }
                    } else if (C3250y.f11734b) {
                        C3250y.m11450b("network fail to get version", PrefFragmentAbout.TAG);
                        break;
                    }
                    break;
                case 1106:
                    AvaliableApps avaliableApps = (AvaliableApps) c0267d.m1354e();
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && avaliableApps.resultCode.equals("2")) {
                        C3159aa.m10963a("spp_update_is", (Boolean) true);
                        View childAt2 = C3214cb.m11265c("com.coolots.chaton") ? PrefFragmentAbout.this.serviceList.getChildAt(2) : PrefFragmentAbout.this.serviceList.getChildAt(1);
                        if (childAt2 != null && PrefFragmentAbout.this.getActivity() != null) {
                            PrefFragmentAbout.this.mVersionCurrent[PrefFragmentAbout.SPP] = (TextView) childAt2.findViewById(R.id.service_current_ver);
                            PrefFragmentAbout.this.mVersionLatest[PrefFragmentAbout.SPP] = (TextView) childAt2.findViewById(R.id.service_latest_ver);
                            PrefFragmentAbout.this.mButton[PrefFragmentAbout.SPP] = (Button) childAt2.findViewById(R.id.button_update);
                            if (TextUtils.isEmpty(avaliableApps.version)) {
                                PrefFragmentAbout.this.mVersionLatest[PrefFragmentAbout.SPP].setVisibility(8);
                            } else {
                                C3159aa.m10966a("spp_latest_ver", avaliableApps.version);
                                PrefFragmentAbout.this.mVersionLatest[PrefFragmentAbout.SPP].setText(PrefFragmentAbout.this.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + avaliableApps.version);
                            }
                            PrefFragmentAbout.this.mButton[PrefFragmentAbout.SPP].setEnabled(true);
                            PrefFragmentAbout.this.googleAppsUpdate(PrefFragmentAbout.SPP);
                            break;
                        }
                    } else {
                        C3250y.m11450b("There is no update of SPPPushClient.", PrefFragmentAbout.TAG);
                        break;
                    }
                    break;
            }
        }
    };

    static /* synthetic */ int access$908(PrefFragmentAbout prefFragmentAbout) {
        int i = prefFragmentAbout.mLogoImageClickCount;
        prefFragmentAbout.mLogoImageClickCount = i + 1;
        return i;
    }

    @Override // com.sec.chaton.settings2.BasePreferenceFragment, android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        if (C3250y.f11734b) {
            C3250y.m11450b("onCreateView", getClass().getSimpleName());
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_settings_about, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) viewGroup.getParent();
        if (Build.VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(null);
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        linearLayout.setBackgroundColor(0);
        linearLayout.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, 0, 0, 0);
            if (Build.VERSION.SDK_INT >= 17) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(0);
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(0);
            }
        }
        View viewFindViewById = viewInflate.findViewById(R.id.breadcrumb);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.breadcrumb1);
        textView.setText(R.string.settings_about_service);
        textView.setTextColor(getActivity().getResources().getColor(R.color.buddy_list_item_status_changed));
        ((TextView) viewFindViewById.findViewById(R.id.breadcrumb2)).setVisibility(8);
        ((ImageView) viewFindViewById.findViewById(R.id.separator1)).setVisibility(8);
        ((ImageView) viewFindViewById.findViewById(R.id.separator2)).setVisibility(8);
        this.serviceList = (ListView) viewInflate.findViewById(android.R.id.list);
        this.serviceList.setItemsCanFocus(true);
        View viewInflate2 = layoutInflater.inflate(R.layout.layout_common_divider1, (ViewGroup) null);
        viewInflate2.setVisibility(8);
        this.serviceList.addFooterView(viewInflate2, null, true);
        this.downloadurl = C3159aa.m10962a().m10979a("UpdateUrl", "");
        this.serviceAdapter = new AboutServiceAdapter();
        this.serviceList.setAdapter((ListAdapter) this.serviceAdapter);
        this.mTerms = (TextView) viewInflate.findViewById(R.id.terms);
        this.mPolicy = (TextView) viewInflate.findViewById(R.id.policy);
        this.mLicences = (Button) viewInflate.findViewById(R.id.licences);
        this.mTerms.setText(Html.fromHtml("<u>" + getActivity().getResources().getString(R.string.setting_disclaimer_terms) + "</u>"));
        this.mPolicy.setText(Html.fromHtml("<u>" + getActivity().getResources().getString(R.string.setting_disclaimer_policy) + "</u>"));
        this.mTerms.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAbout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(PrefFragmentAbout.this.getActivity(), (Class<?>) ActivityWebView.class);
                intent.putExtra("PARAM_MENU", "TERMS_AND_CONDITION");
                intent.putExtra("FROM_ABOUT_CHATON", true);
                PrefFragmentAbout.this.startActivity(intent);
            }
        });
        this.mPolicy.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAbout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(PrefFragmentAbout.this.getActivity(), (Class<?>) ActivityWebView.class);
                intent.putExtra("PARAM_MENU", "PRIVACY_POLICY");
                intent.putExtra("FROM_ABOUT_CHATON", true);
                PrefFragmentAbout.this.startActivity(intent);
            }
        });
        this.mLicences.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAbout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!C3197bl.m11159a()) {
                    Intent intent = new Intent(PrefFragmentAbout.this.getActivity(), (Class<?>) ActivityWebView.class);
                    intent.putExtra("PARAM_MENU", "License");
                    PrefFragmentAbout.this.startActivity(intent);
                }
            }
        });
        if (bundle == null) {
            this.mGetVersionNoticeTask = new C1324bj(this.mHandler).m5694b();
        }
        if (C3214cb.m11265c("com.sec.spp.push") && C3214cb.m11246a("com.sec.spp.push") < 21) {
            new C1306as(this.mHandler).m5613a(this.mContext);
        }
        return viewInflate;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCurrentVersion = new String[3];
        this.mNewVersion = new String[3];
        this.mVersionCurrent = new TextView[3];
        this.mVersionLatest = new TextView[3];
        this.mButton = new Button[3];
        this.mContext = getActivity();
        checkUpdateService();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3250y.m11456e("onConfigurationChagne", getClass().getSimpleName());
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroyView, mGetVersionNoticeTask : " + this.mGetVersionNoticeTask, getClass().getSimpleName());
        }
        if (this.chatonvAPII != null) {
            this.chatonvAPII.m52a(this.mContext, (InterfaceC0048d) null);
        }
        CHATON_V = 1;
        SPP = 2;
    }

    private void checkUpdateService() {
        try {
            this.mCurrentVersion[0] = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            this.mCurrentVersion[0] = "";
        }
        this.mNewVersion[0] = C3159aa.m10962a().m10979a("UpdateTargetVersion", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissVersionUpgradeDialog() {
        new Intent("com.sec.chaton.ACTION_DISMISS");
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    protected void onCreateDialog(int i) {
        switch (i) {
            case 1:
                new OpenSourceDialog().show(getFragmentManager(), DIALOG_OPENSOURCE);
                break;
        }
    }

    public class OpenSourceDialog extends DialogFragment {
        /* JADX WARN: Removed duplicated region for block: B:78:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
        @Override // android.app.DialogFragment
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.app.Dialog onCreateDialog(android.os.Bundle r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 250
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings2.PrefFragmentAbout.OpenSourceDialog.onCreateDialog(android.os.Bundle):android.app.Dialog");
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mActivity = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void googleAppsUpdate(final int i) {
        this.mButton[i].setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAbout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PrefFragmentAbout.this.getActivity() != null) {
                    boolean zM11261b = C3214cb.m11261b();
                    boolean zM11264c = C3214cb.m11264c();
                    if (i == PrefFragmentAbout.SPP) {
                        if (zM11264c) {
                            C3214cb.m11267d(i);
                            return;
                        } else if (zM11261b) {
                            C3214cb.m11259b(i);
                            return;
                        } else {
                            C3214cb.m11270f(i);
                            return;
                        }
                    }
                    if (zM11261b && zM11264c) {
                        Intent intent = null;
                        if (i == 0) {
                            intent = new Intent(PrefFragmentAbout.this.mContext, (Class<?>) UpgradeDialog.class);
                        } else if (i == 1) {
                            intent = new Intent(PrefFragmentAbout.this.mContext, (Class<?>) ChatONVUpgradeDialog.class);
                        } else if (i == 2) {
                            intent = new Intent(PrefFragmentAbout.this.mContext, (Class<?>) NewSPPUpgradeDialog.class);
                        }
                        if (intent != null) {
                            intent.putExtra("isCritical", false);
                            intent.putExtra("isFromHome", true);
                            PrefFragmentAbout.this.startActivity(intent);
                            return;
                        }
                        return;
                    }
                    if (zM11261b && !zM11264c) {
                        C3214cb.m11259b(i);
                    } else if (!zM11261b && zM11264c) {
                        C3214cb.m11267d(i);
                    } else {
                        C3214cb.m11270f(i);
                    }
                }
            }
        });
    }

    public class AboutServiceAdapter extends BaseAdapter {
        private boolean isInstallChatONV;
        private boolean isInstallSPP;
        private LayoutInflater mInflater;
        private ImageView mServiceLogo;
        private TextView mServiceName;
        private int count = 1;
        private boolean sppUpdate = false;
        private InterfaceC0048d chatonVUpgradeListener = new InterfaceC0048d() { // from class: com.sec.chaton.settings2.PrefFragmentAbout.AboutServiceAdapter.1
            @Override // com.coolots.sso.p006a.InterfaceC0048d
            public void onReceiveUpdateVerion(String str, String str2, int i) {
                C3250y.m11450b("[onReceiveUpdateVerion] ChatONV currentVersionName : " + str + ",serverVersionName : " + str2 + ",versionInfo : " + i, PrefFragmentAbout.TAG);
                PrefFragmentAbout.this.mCurrentVersion[PrefFragmentAbout.CHATON_V] = str;
                PrefFragmentAbout.this.mNewVersion[PrefFragmentAbout.CHATON_V] = str2;
                if (i != 0) {
                    PrefFragmentAbout.this.chatonVUpdate = true;
                    AboutServiceAdapter.this.notifyDataSetChanged();
                    C3159aa.m10962a().m10984b("chatonVUpdateStatus", Integer.valueOf(i));
                }
            }
        };

        public AboutServiceAdapter() {
            this.isInstallChatONV = false;
            this.isInstallSPP = false;
            this.mInflater = LayoutInflater.from(PrefFragmentAbout.this.mContext);
            if (C3214cb.m11256a(PrefFragmentAbout.this.mContext)) {
                this.isInstallChatONV = true;
                this.count++;
            }
            if (C3214cb.m11265c("com.sec.spp.push")) {
                this.isInstallSPP = true;
                this.count++;
            }
            if (!this.isInstallChatONV && this.isInstallSPP) {
                PrefFragmentAbout.SPP = 1;
                PrefFragmentAbout.CHATON_V = -1;
            }
            checkChatonupgradeStatus();
        }

        private void checkChatonupgradeStatus() {
            if (this.isInstallChatONV) {
                PrefFragmentAbout.this.mCurrentVersion[PrefFragmentAbout.CHATON_V] = C3214cb.m11258b("com.coolots.chaton");
                PrefFragmentAbout.this.chatonvAPII = new C0045a();
                if (C3214cb.m11256a(PrefFragmentAbout.this.mContext) && PrefFragmentAbout.this.chatonvAPII.m55d(PrefFragmentAbout.this.mContext)) {
                    PrefFragmentAbout.this.chatonvAPII.m52a(PrefFragmentAbout.this.mContext, this.chatonVUpgradeListener);
                    PrefFragmentAbout.this.chatonvAPII.m65n(PrefFragmentAbout.this.mContext);
                } else if (C3250y.f11734b) {
                    C3250y.m11450b("chatonv update is NOT available", PrefFragmentAbout.TAG);
                }
            }
            if (this.isInstallSPP) {
                PrefFragmentAbout.this.mCurrentVersion[PrefFragmentAbout.SPP] = C3214cb.m11258b("com.sec.spp.push");
                try {
                    Cursor cursorQuery = PrefFragmentAbout.this.mContext.getContentResolver().query(Uri.parse("content://com.sec.spp.provider/version_info"), null, null, null, null);
                    if (cursorQuery != null) {
                        if (cursorQuery.moveToFirst()) {
                            PrefFragmentAbout.this.mCurrentVersion[PrefFragmentAbout.SPP] = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_CURRENT_VERSION));
                            PrefFragmentAbout.this.mNewVersion[PrefFragmentAbout.SPP] = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_LATEST_VERSION));
                            this.sppUpdate = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_NEED_UPDATE)));
                            if (C3250y.f11734b) {
                                C3250y.m11450b("[SPP update status] currentVer : " + PrefFragmentAbout.this.mCurrentVersion[PrefFragmentAbout.SPP] + " latestVer : " + PrefFragmentAbout.this.mNewVersion[PrefFragmentAbout.SPP] + " needUpdate : " + this.sppUpdate, PrefFragmentAbout.TAG);
                            }
                            notifyDataSetChanged();
                            C3159aa.m10963a("spp_update_is", Boolean.valueOf(this.sppUpdate));
                            if (this.sppUpdate) {
                            }
                            C3159aa.m10966a("spp_latest_ver", PrefFragmentAbout.this.mNewVersion[PrefFragmentAbout.SPP]);
                        }
                        cursorQuery.close();
                        return;
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("cursor is null", PrefFragmentAbout.TAG);
                    }
                } catch (Exception e) {
                    C3250y.m11442a(e.toString(), PrefFragmentAbout.TAG);
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.count;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.mInflater.inflate(R.layout.layout_item_about_service, viewGroup, false);
            }
            this.mServiceLogo = (ImageView) view.findViewById(R.id.icon_image);
            this.mServiceName = (TextView) view.findViewById(R.id.service_title);
            PrefFragmentAbout.this.mVersionCurrent[i] = (TextView) view.findViewById(R.id.service_current_ver);
            PrefFragmentAbout.this.mVersionLatest[i] = (TextView) view.findViewById(R.id.service_latest_ver);
            PrefFragmentAbout.this.mButton[i] = (Button) view.findViewById(R.id.button_update);
            switch (i) {
                case 0:
                    this.mServiceLogo.setImageResource(R.drawable.setting_chaton_logo);
                    this.mServiceName.setText(R.string.app_name);
                    PrefFragmentAbout.this.mLogoImageClickCount = 0;
                    this.mServiceLogo.setClickable(true);
                    this.mServiceLogo.setSoundEffectsEnabled(false);
                    this.mServiceLogo.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentAbout.AboutServiceAdapter.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (PrefFragmentAbout.this.mLogoImageClickCount >= 17) {
                                PrefFragmentAbout.this.mLogoImageClickCount = 0;
                                PrefFragmentAbout.this.startActivity(new Intent(PrefFragmentAbout.this.getActivity(), (Class<?>) AdminMenu.class));
                                return;
                            }
                            PrefFragmentAbout.access$908(PrefFragmentAbout.this);
                        }
                    });
                    PrefFragmentAbout.this.mVersionCurrent[0].setText(PrefFragmentAbout.this.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + PrefFragmentAbout.this.mCurrentVersion[0]);
                    PrefFragmentAbout.this.mVersionLatest[0].setText(PrefFragmentAbout.this.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (PrefFragmentAbout.this.mNewVersion[0].length() > 0 ? PrefFragmentAbout.this.mNewVersion[0] : PrefFragmentAbout.this.mCurrentVersion[0]));
                    PrefFragmentAbout.this.mVersionLatest[0].setVisibility(0);
                    setButton(0);
                    return view;
                case 1:
                    if (this.isInstallChatONV) {
                        initializeChatONV();
                    } else if (this.isInstallSPP) {
                        initializeSPP();
                    }
                    return view;
                case 2:
                    if (this.isInstallSPP) {
                        initializeSPP();
                    }
                    return view;
                default:
                    return view;
            }
        }

        private void initializeChatONV() {
            this.mServiceLogo.setImageResource(R.drawable.setting_chaton_logo);
            this.mServiceName.setText(R.string.chaton_voice_video_chat);
            PrefFragmentAbout.this.mVersionCurrent[PrefFragmentAbout.CHATON_V].setText(PrefFragmentAbout.this.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + PrefFragmentAbout.this.mCurrentVersion[PrefFragmentAbout.CHATON_V]);
            PrefFragmentAbout.this.mVersionLatest[PrefFragmentAbout.CHATON_V].setText(PrefFragmentAbout.this.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (PrefFragmentAbout.this.mNewVersion[PrefFragmentAbout.CHATON_V] != null ? PrefFragmentAbout.this.mNewVersion[PrefFragmentAbout.CHATON_V] : PrefFragmentAbout.this.mCurrentVersion[PrefFragmentAbout.CHATON_V]));
            setButton(PrefFragmentAbout.CHATON_V);
        }

        private void initializeSPP() {
            this.mServiceLogo.setImageResource(R.drawable.setting_pushservice_logo);
            this.mServiceName.setText(R.string.registration_samsung_push_service);
            PrefFragmentAbout.this.mVersionCurrent[PrefFragmentAbout.SPP].setText(PrefFragmentAbout.this.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + PrefFragmentAbout.this.mCurrentVersion[PrefFragmentAbout.SPP]);
            PrefFragmentAbout.this.mVersionLatest[PrefFragmentAbout.SPP].setText(PrefFragmentAbout.this.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (C3159aa.m10962a().m10979a("spp_latest_ver", (String) null) != null ? C3159aa.m10962a().m10979a("spp_latest_ver", (String) null) : PrefFragmentAbout.this.mCurrentVersion[PrefFragmentAbout.SPP]));
            setButton(PrefFragmentAbout.SPP);
        }

        private void setButton(int i) {
            if (i == 0) {
                PrefFragmentAbout.this.googleAppsUpdate(i);
                if (PrefFragmentAbout.this.downloadurl == null || PrefFragmentAbout.this.downloadurl.length() <= 0) {
                    PrefFragmentAbout.this.mButton[i].setEnabled(false);
                    return;
                } else {
                    PrefFragmentAbout.this.mButton[i].setEnabled(true);
                    return;
                }
            }
            if (i == PrefFragmentAbout.CHATON_V) {
                PrefFragmentAbout.this.googleAppsUpdate(i);
                if (PrefFragmentAbout.this.chatonVUpdate) {
                    PrefFragmentAbout.this.mButton[i].setEnabled(true);
                    return;
                } else {
                    PrefFragmentAbout.this.mButton[i].setEnabled(false);
                    return;
                }
            }
            if (i == PrefFragmentAbout.SPP) {
                PrefFragmentAbout.this.googleAppsUpdate(i);
                if (this.sppUpdate || C3159aa.m10962a().m10977a("spp_update_is", (Boolean) false).booleanValue()) {
                    PrefFragmentAbout.this.mButton[i].setEnabled(true);
                } else {
                    PrefFragmentAbout.this.mButton[i].setEnabled(false);
                }
            }
        }
    }
}
