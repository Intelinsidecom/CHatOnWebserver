package com.coolots.chaton.setting.view.ringtone;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.view.callsettings.SettingCallSettingsFragment;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.ChangeRingtone;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RadioButtonRingtoneListDialog extends DialogFragment {
    private static final String CLASSNAME = "[RadioButtonRingtoneListDialog]";
    private static final int RINGTONE_TYPE_CHATONV_DEVICE = 2;
    private static final int RINGTONE_TYPE_USER_SELECTED_LIST = 3;
    private static final int SELECT_CHATONV_DEFAULT = -1;
    private static final int SELECT_SILENT = -2;
    public static MediaPlayer mPlayer = new MediaPlayer();
    private Context mContext;
    private InterfaceRingtone mInterfaceRingtone;
    public String mRingtoneData;
    private int mSelect;
    private String mRingtoneName = null;
    public int mCurrentIdx = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public RadioButtonRingtoneListDialog(String title, int searchtype, InterfaceRingtone interfaceRingtone) {
        this.mSelect = 0;
        Bundle args = new Bundle();
        args.putString(SlookSmartClipMetaTag.TAG_TYPE_TITLE, title);
        setArguments(args);
        this.mSelect = searchtype;
        this.mInterfaceRingtone = interfaceRingtone;
    }

    public void setRingToneName(String ringtoneName) {
        this.mRingtoneName = ringtoneName;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) throws Resources.NotFoundException {
        this.mContext = getActivity().getApplicationContext();
        String title = getResources().getString(C0000R.string.preference_3_1_5_title);
        ArrayList<String> totalList = ChangeRingtone.getRingtoneList();
        totalList.add(0, (String) getResources().getText(C0000R.string.ringtone_default_name));
        totalList.add(0, (String) getResources().getText(C0000R.string.ringtone_silent));
        int length = totalList.size();
        CharSequence[] listRingtone = (CharSequence[]) totalList.toArray(new CharSequence[length]);
        if (this.mRingtoneName == null) {
            this.mCurrentIdx = 1;
        } else {
            this.mCurrentIdx = totalList.indexOf(this.mRingtoneName);
        }
        this.mSelect = this.mCurrentIdx - 2;
        return new AlertDialog.Builder(getActivity(), C0000R.style.ChatONDialogTheme).setTitle(title).setSingleChoiceItems(listRingtone, this.mCurrentIdx, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.ringtone.RadioButtonRingtoneListDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                RadioButtonRingtoneListDialog.this.mSelect = which - 2;
                RadioButtonRingtoneListDialog.this.logI("Selected Item : " + RadioButtonRingtoneListDialog.this.mSelect);
                if (RadioButtonRingtoneListDialog.this.mSelect == -2) {
                    if (RadioButtonRingtoneListDialog.mPlayer.isPlaying()) {
                        RadioButtonRingtoneListDialog.mPlayer.pause();
                        return;
                    }
                    return;
                }
                try {
                    RadioButtonRingtoneListDialog.mPlayer.reset();
                    if (RadioButtonRingtoneListDialog.this.mSelect == -1) {
                        RadioButtonRingtoneListDialog.mPlayer = MediaPlayer.create(RadioButtonRingtoneListDialog.this.mContext, MainApplication.mResources.getRawRingtone());
                    } else {
                        Uri[] arrRingtone = RadioButtonRingtoneListDialog.this.getRingtoneUri();
                        if (arrRingtone != null) {
                            RadioButtonRingtoneListDialog.mPlayer.setDataSource(RadioButtonRingtoneListDialog.this.mContext, arrRingtone[RadioButtonRingtoneListDialog.this.mSelect]);
                            RadioButtonRingtoneListDialog.mPlayer.prepare();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!RadioButtonRingtoneListDialog.mPlayer.isPlaying()) {
                    RadioButtonRingtoneListDialog.mPlayer.start();
                } else {
                    RadioButtonRingtoneListDialog.mPlayer.pause();
                }
            }
        }).setNegativeButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.ringtone.RadioButtonRingtoneListDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (RadioButtonRingtoneListDialog.this.mSelect != -2) {
                    if (RadioButtonRingtoneListDialog.this.mSelect != -1) {
                        ChatONSettingData.getInstance().setRingtoneData(3, RadioButtonRingtoneListDialog.this.mSelect, null);
                    } else {
                        ChatONSettingData.getInstance().setRingtoneData(2, 0, null);
                    }
                } else {
                    ChatONSettingData.getInstance().setRingtoneData(3, -1, null);
                }
                RadioButtonRingtoneListDialog.this.getFragmentManager().beginTransaction().replace(R.id.content, new SettingCallSettingsFragment(RadioButtonRingtoneListDialog.this.mContext)).commit();
            }
        }).setPositiveButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.ringtone.RadioButtonRingtoneListDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setNeutralButton(C0000R.string.add, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.ringtone.RadioButtonRingtoneListDialog.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                RadioButtonRingtoneListDialog.this.mInterfaceRingtone.lauchRingtoneList();
            }
        }).create();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        dispose();
        super.onDismiss(dialog);
    }

    public void dispose() {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
        }
        ViewRecycleUtil.recurisveRecycle(getView());
        System.gc();
    }

    public Uri[] getRingtoneUri() {
        RingtoneManager ringtoneManager = new RingtoneManager(this.mContext);
        ringtoneManager.setType(1);
        ringtoneManager.setIncludeDrm(true);
        Cursor ringtoneCursor = ringtoneManager.getCursor();
        int ringtoneCount = ringtoneCursor.getCount();
        if (ringtoneCount == 0 && !ringtoneCursor.moveToFirst()) {
            return null;
        }
        Uri[] ringtones = new Uri[ringtoneCount];
        while (!ringtoneCursor.isAfterLast() && ringtoneCursor.moveToNext()) {
            int currentPosition = ringtoneCursor.getPosition();
            ringtones[currentPosition] = ringtoneManager.getRingtoneUri(currentPosition);
        }
        ringtoneCursor.close();
        return ringtones;
    }
}
