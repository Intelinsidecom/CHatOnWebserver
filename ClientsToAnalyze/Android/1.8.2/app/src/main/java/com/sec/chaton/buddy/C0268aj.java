package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.aj */
/* loaded from: classes.dex */
class C0268aj implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1363a;

    C0268aj(BuddyFragment buddyFragment) {
        this.f1363a = buddyFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (view != null) {
            if (view.isPressed() || view.isInTouchMode()) {
                if (view.getTag().equals(this.f1363a.getResources().getString(R.string.buddy_list_dialog_addbuddy_title))) {
                    this.f1363a.startActivityForResult(new Intent(this.f1363a.getActivity(), (Class<?>) AddBuddyActivity.class), 1);
                    return;
                }
                if (view.getTag().equals(this.f1363a.getResources().getString(R.string.buddy_list_optionmenu_addgroup))) {
                    new AlertDialogC0307bs(this.f1363a.getActivity()).show();
                    return;
                }
                if (view.getTag().equals(this.f1363a.getResources().getString(R.string.menu_video_call)) || view.getTag().equals(this.f1363a.getResources().getString(R.string.menu_voice_call))) {
                    Intent intent = new Intent(this.f1363a.f1018t, (Class<?>) BuddySelectActivity.class);
                    if (view.getTag().equals(this.f1363a.getResources().getString(R.string.menu_voice_call))) {
                        intent.putExtra("ACTIVITY_PURPOSE", 17);
                    } else {
                        intent.putExtra("ACTIVITY_PURPOSE", 18);
                    }
                    intent.putExtra("BUDDY_SORT_STYLE", 11);
                    intent.putExtra("ACTIVITY_PURPOSE_ARG2", view.getTag().equals(this.f1363a.getResources().getString(R.string.menu_voice_call)));
                    this.f1363a.startActivity(intent);
                    return;
                }
                if (view.getTag().equals(this.f1363a.getResources().getString(R.string.menu_call))) {
                    Intent intent2 = new Intent(this.f1363a.getActivity(), (Class<?>) BuddyActivity2.class);
                    intent2.putExtra("ACTIVITY_PURPOSE", 13);
                    intent2.putExtra("BUDDY_SORT_STYLE", 11);
                    intent2.putExtra("ACTION_PURPOSE", 7);
                    this.f1363a.startActivityForResult(intent2, 13);
                    return;
                }
                if (view.getTag().equals(this.f1363a.getResources().getString(R.string.recommendation))) {
                    this.f1363a.startActivity(new Intent(this.f1363a.getActivity(), (Class<?>) BuddyRecommendActivity.class));
                    return;
                }
                if (view.getTag().equals(this.f1363a.getResources().getString(R.string.buddy_list_tell_friends_button))) {
                    Intent intent3 = new Intent(this.f1363a.getActivity(), (Class<?>) AddBuddyActivity.class);
                    intent3.putExtra("ADD_BUDDY_DEFAULT_TAB", 3);
                    this.f1363a.startActivityForResult(intent3, 1);
                } else if (view.getTag().equals(this.f1363a.getResources().getString(R.string.buddy_list_optionmenu_sortby))) {
                    this.f1363a.f939aA = new AlertDialogBuilderC2120a(this.f1363a.f1018t).setTitle(this.f1363a.getString(R.string.buddy_list_optionmenu_listby)).setSingleChoiceItems(new String[]{this.f1363a.getString(R.string.buddy_list_optionmenu_sortby_option_buddy), this.f1363a.getString(R.string.buddy_list_optionmenu_sortby_option_interaction)}, this.f1363a.f967ad - 11, new DialogInterfaceOnClickListenerC0269ak(this)).show();
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
