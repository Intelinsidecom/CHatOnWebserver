package com.sec.chaton.userprofile;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class RelationshipRank2 extends BaseMultiPaneActivity {
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.setting_interaction_rank);
        setContentView(R.layout.base_activity);
        if (GlobalApplication.m3265f()) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.fragment_controller, new RankWeeklyViewFragment());
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, new RelationshipRankFragment2(), "container");
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ListView listView = (ListView) findViewById(R.id.more_option_list);
        if (listView != null) {
            Rect rect = new Rect();
            listView.getGlobalVisibleRect(rect);
            if (listView.getVisibility() == 0 && !rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                listView.setVisibility(8);
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
