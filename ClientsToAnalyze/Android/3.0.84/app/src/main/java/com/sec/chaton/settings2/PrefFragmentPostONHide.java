package com.sec.chaton.settings2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.block.C0475ac;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1344v;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p035io.entry.GetPostONBlindList;
import com.sec.chaton.p035io.entry.inner.PostONBlind;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.PostONHideListActivity;
import com.sec.chaton.settings.C2674ek;
import com.sec.chaton.settings.InterfaceC2677en;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PrefFragmentPostONHide extends BasePreferenceFragment implements MenuItem.OnMenuItemClickListener, InterfaceC2677en {
    public static final String BLOCK_BUDDY_LIST = "block_buddy_list";
    public static final String BLOCK_BUDDY_RESULT = "block_buddy_result";
    public static final String BLOCK_BUDDY_TYPE = "block_buddy_type";
    private static final String KEY_POSTON_BLIND_LIST = "blindlist";
    private static final int POSTON_BLIND_ADD = 0;
    private static final int POSTON_BLIND_EDIT = 1;
    static ProgressDialog mProgressDialog;
    private C2674ek adapter;
    private TextView breadCrumb2;
    private MenuItem mAddItem;
    private Activity mAttachedActivity;
    private Boolean mBlindFlag;
    private C1344v mControl;
    private int mCount;
    private ArrayList<C0475ac> mData;
    private MenuItem mEditItem;
    private boolean mIsBlindListAlreadyUpdated;
    private ListView mListView;
    private LinearLayout mNetworkErrorLayout;
    private View mNetworkErrorView;
    private LinearLayout mNoBuddyLayout;
    private View mNoBuddyView;
    ArrayList<String> mPostONHideList = new ArrayList<>();
    private ArrayList<String> mBlindListNew = new ArrayList<>();
    private ArrayList<String> mBlindListOld = new ArrayList<>();
    private final Handler mHandler = new Handler() { // from class: com.sec.chaton.settings2.PrefFragmentPostONHide.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (PrefFragmentPostONHide.this.getActivity() != null) {
                C0267d c0267d = (C0267d) message.obj;
                if (message.what == 905) {
                    if (PrefFragmentPostONHide.mProgressDialog != null) {
                        PrefFragmentPostONHide.mProgressDialog.dismiss();
                    }
                    PrefFragmentPostONHide.this.showPostONHideList(c0267d);
                }
                if (message.what == 904) {
                    if (PrefFragmentPostONHide.mProgressDialog != null) {
                        PrefFragmentPostONHide.mProgressDialog.dismiss();
                    }
                    if (c0267d.m11704n()) {
                        PrefFragmentPostONHide.this.showPostONHideList(c0267d);
                    } else {
                        C3641ai.m13210a(PrefFragmentPostONHide.this.getActivity(), R.string.popup_no_network_connection, 0).show();
                    }
                }
            }
        }
    };

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mControl = new C1344v(this.mHandler);
        this.mControl.m5920b();
        C3250y.m11450b("Start getInteractionBlindList Sync", getClass().getSimpleName());
        this.mBlindFlag = false;
        this.mIsBlindListAlreadyUpdated = false;
        this.mCount = 0;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mAttachedActivity = activity;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mAttachedActivity = null;
    }

    @Override // com.sec.chaton.settings2.BasePreferenceFragment, android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_poston_blind_list, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.breadcrumb);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.breadcrumb1);
        textView.setText(R.string.setting_category_privacy);
        textView.setClickable(true);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentPostONHide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrefFragmentPostONHide.this.mAttachedActivity.getFragmentManager().popBackStack();
            }
        });
        this.breadCrumb2 = (TextView) viewFindViewById.findViewById(R.id.breadcrumb2);
        this.breadCrumb2.setText(R.string.poston_title);
        this.breadCrumb2.setTextColor(this.mAttachedActivity.getResources().getColor(R.color.buddy_list_item_status_changed));
        ((ImageView) viewFindViewById.findViewById(R.id.separator2)).setVisibility(8);
        this.mListView = (ListView) viewInflate.findViewById(R.id.poston_blind_list);
        this.mData = new ArrayList<>();
        this.mNoBuddyLayout = (LinearLayout) viewInflate.findViewById(R.id.llayout_poston_no_buddies);
        this.mNoBuddyView = viewInflate.findViewById(R.id.poston_no_buddies);
        ImageView imageView = (ImageView) this.mNoBuddyView.findViewById(R.id.image1);
        TextView textView2 = (TextView) this.mNoBuddyView.findViewById(R.id.text1);
        TextView textView3 = (TextView) this.mNoBuddyView.findViewById(R.id.text2);
        imageView.setImageResource(R.drawable.no_contents_buddies);
        textView2.setText(R.string.chat_title_no_buddies);
        textView3.setText(R.string.poston_buddies_not_visible);
        this.mNetworkErrorLayout = (LinearLayout) viewInflate.findViewById(R.id.llayout_poston_network_error);
        this.mNetworkErrorView = viewInflate.findViewById(R.id.poston_network_error);
        ImageView imageView2 = (ImageView) this.mNetworkErrorView.findViewById(R.id.image1);
        TextView textView4 = (TextView) this.mNetworkErrorView.findViewById(R.id.text1);
        TextView textView5 = (TextView) this.mNetworkErrorView.findViewById(R.id.text2);
        imageView2.setImageResource(R.drawable.no_contents_network);
        textView4.setText(R.string.toast_network_unable);
        textView5.setText((CharSequence) null);
        this.mListView.setVisibility(8);
        this.mNoBuddyLayout.setVisibility(0);
        this.mNetworkErrorLayout.setVisibility(8);
        mProgressDialog = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.dialog_connecting_server);
        mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.sec.chaton.settings2.PrefFragmentPostONHide.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                PrefFragmentPostONHide.this.mControl.m5922c();
                if (PrefFragmentPostONHide.mProgressDialog != null) {
                    PrefFragmentPostONHide.mProgressDialog.dismiss();
                }
                PrefFragmentPostONHide.this.getActivity().finish();
                return true;
            }
        });
        mProgressDialog.show();
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_hide_poston_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.mEditItem = null;
        this.mAddItem = null;
        this.mEditItem = menu.findItem(R.id.hide_poston_menu_edit);
        this.mEditItem.setOnMenuItemClickListener(this);
        this.mAddItem = menu.findItem(R.id.hide_poston_menu_add);
        this.mAddItem.setOnMenuItemClickListener(this);
        if (this.mAddItem != null) {
            if (C1360d.m6034b(getActivity().getContentResolver()) <= 0) {
                this.mAddItem.setEnabled(false);
            } else {
                this.mAddItem.setEnabled(true);
            }
            C3228cp.m11343a(this.mAddItem);
        }
        if (this.mEditItem != null) {
            this.mEditItem.setEnabled(false);
            C3228cp.m11343a(this.mEditItem);
        }
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.hide_poston_menu_add) {
            Intent intent = new Intent(this.mAttachedActivity, (Class<?>) BuddyActivity2.class);
            intent.putExtra("BUDDY_SORT_STYLE", 11);
            intent.putExtra("ACTIVITY_PURPOSE", 9);
            intent.putExtra("ACTIVITY_PURPOSE_ARG", this.mPostONHideList);
            startActivityForResult(intent, 0);
        }
        if (menuItem.getItemId() == R.id.hide_poston_menu_edit) {
            Intent intent2 = new Intent(this.mAttachedActivity, (Class<?>) PostONHideListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(BLOCK_BUDDY_LIST, this.mData);
            bundle.putString(BLOCK_BUDDY_TYPE, "post_on");
            intent2.putExtras(bundle);
            startActivityForResult(intent2, 1);
        }
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
        }
        return true;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C3250y.m11456e("Get blind list from user", getClass().getSimpleName());
                    String[] stringArrayExtra = intent.getStringArrayExtra(KEY_POSTON_BLIND_LIST);
                    this.mCount = stringArrayExtra.length;
                    this.breadCrumb2.setText(this.mAttachedActivity.getResources().getString(R.string.poston_title) + " (" + Integer.toString(this.mData.size()) + ")");
                    this.mEditItem.setEnabled(true);
                    C3228cp.m11343a(this.mEditItem);
                    this.mBlindListNew.clear();
                    for (String str : stringArrayExtra) {
                        this.mBlindListNew.add(str);
                    }
                    this.mControl.m5919a(this.mBlindListOld, this.mBlindListNew);
                    this.mBlindFlag = false;
                    mProgressDialog = ProgressDialogC3265l.m11490a(getActivity(), null, getResources().getString(R.string.wait_sending), true);
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    C3250y.m11456e("Remove multiple blinded buddy", getClass().getSimpleName());
                    this.mPostONHideList.clear();
                    this.mBlindListOld.clear();
                    String[] stringArrayExtra2 = intent.getStringArrayExtra(BLOCK_BUDDY_RESULT);
                    for (String str2 : stringArrayExtra2) {
                        this.mPostONHideList.add(str2);
                    }
                    showPostONHideList_inner(stringArrayExtra2);
                    this.mIsBlindListAlreadyUpdated = true;
                    break;
                }
                break;
        }
    }

    public void getBlindListToSet() {
        String str = getClass().getSimpleName() + " - getBlindListToSet()";
        Iterator<String> it = this.mBlindListOld.iterator();
        while (it.hasNext()) {
            C3250y.m11456e("[mBlindOldList] " + it.next(), str);
        }
        Iterator<String> it2 = this.mBlindListNew.iterator();
        while (it2.hasNext()) {
            C3250y.m11456e("[mBlindNewList] " + it2.next(), str);
        }
        for (int i = 0; i < this.mBlindListNew.size(); i++) {
            String str2 = this.mBlindListNew.get(i);
            if (this.mBlindListOld.remove(str2)) {
                this.mBlindListNew.remove(str2);
            }
        }
        Iterator<String> it3 = this.mBlindListOld.iterator();
        while (it3.hasNext()) {
            C3250y.m11456e("[1st mBlindOldList] " + it3.next(), str);
        }
        Iterator<String> it4 = this.mBlindListNew.iterator();
        while (it4.hasNext()) {
            C3250y.m11456e("[1st mBlindNewList] " + it4.next(), str);
        }
        for (int i2 = 0; i2 < this.mBlindListOld.size(); i2++) {
            String str3 = this.mBlindListOld.get(i2);
            if (this.mBlindListNew.remove(str3)) {
                this.mBlindListOld.remove(str3);
            }
        }
        Iterator<String> it5 = this.mBlindListOld.iterator();
        while (it5.hasNext()) {
            C3250y.m11456e("[2nd mBlindOldList] " + it5.next(), str);
        }
        Iterator<String> it6 = this.mBlindListNew.iterator();
        while (it6.hasNext()) {
            C3250y.m11456e("[2nd mBlindNewList] " + it6.next(), str);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.breadCrumb2.setText(this.mAttachedActivity.getResources().getString(R.string.poston_title) + " (" + Integer.toString(this.mData.size()) + ")");
        if (this.mIsBlindListAlreadyUpdated) {
            this.mIsBlindListAlreadyUpdated = false;
            return;
        }
        this.mControl.m5920b();
        mProgressDialog.show();
        C3250y.m11450b("Start getInteractionBlindList Sync", getClass().getSimpleName());
        this.mBlindFlag = false;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroyView() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        super.onDestroyView();
    }

    private void showPostONHideList_inner(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new C0475ac(strArr[i], C1360d.m6037b(CommonApplication.m11493l().getContentResolver(), strArr[i]), null));
        }
        this.mData.clear();
        this.mData.addAll(arrayList);
        this.mCount = this.mData.size();
        this.breadCrumb2.setText(this.mAttachedActivity.getResources().getString(R.string.poston_title) + " (" + Integer.toString(this.mData.size()) + ")");
        if (this.mPostONHideList.isEmpty()) {
            this.mEditItem.setEnabled(false);
            C3228cp.m11343a(this.mEditItem);
            this.mListView.setVisibility(8);
            this.mNoBuddyLayout.setVisibility(0);
            this.mNetworkErrorLayout.setVisibility(8);
        } else {
            this.mEditItem.setEnabled(true);
            C3228cp.m11343a(this.mEditItem);
            this.mListView.setVisibility(0);
            this.mNoBuddyLayout.setVisibility(8);
            this.mNetworkErrorLayout.setVisibility(8);
        }
        this.mBlindListOld = this.mPostONHideList;
        InitAdapter();
        if (this.mBlindFlag.booleanValue()) {
            this.mBlindFlag = false;
            C3641ai.m13210a(getActivity(), R.string.settings_removed, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPostONHideList(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            ArrayList<PostONBlind> arrayList = ((GetPostONBlindList) c0267d.m1354e()).blind;
            this.mPostONHideList.clear();
            this.mBlindListOld.clear();
            Iterator<PostONBlind> it = arrayList.iterator();
            while (it.hasNext()) {
                PostONBlind next = it.next();
                if (C1360d.m6054h(CommonApplication.m11493l().getContentResolver(), next.value)) {
                    this.mPostONHideList.add(next.value);
                }
                C3250y.m11456e("Add blindedBuddies: " + next.value, getClass().getSimpleName());
            }
            int size = this.mPostONHideList.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = this.mPostONHideList.get(i);
            }
            showPostONHideList_inner(strArr);
            return;
        }
        this.mListView.setVisibility(8);
        this.mNoBuddyLayout.setVisibility(8);
        this.mNetworkErrorLayout.setVisibility(0);
        this.mData.clear();
        C3641ai.m13210a(getActivity(), R.string.popup_no_network_connection, 0).show();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private void InitAdapter() {
        this.adapter = new C2674ek(getActivity(), this.mPostONHideList);
        this.adapter.m9684a(this);
        this.mListView.setAdapter((ListAdapter) this.adapter);
    }

    @Override // com.sec.chaton.settings.InterfaceC2677en
    public void onItemClicked(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        mProgressDialog.show();
        this.mBlindFlag = true;
        this.mControl.m5919a(arrayList, new ArrayList<>());
        C3250y.m11450b("PostON Buddy Show: " + str2, getClass().getSimpleName());
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return onOptionsItemSelected(menuItem);
    }
}
