package com.coolots.chaton.call.screenshare.filepicker;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.ScreenShareProc;
import com.sds.coolots.common.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class FilePickerActivity extends ListActivity {
    private static final String CLASSNAME = "[FilePickerActivity]";
    private FileInfoArrayAdapter mAdapter;
    private RelativeLayout mBackBtn;
    private File mCurrentPath;
    private TextView mFileDirName;
    private final String mInitPath = "/sdcard/";
    private Stack<File> dirStack = new Stack<>();

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0000R.layout.screenshare_filepicker);
        this.mBackBtn = (RelativeLayout) findViewById(C0000R.id.file_picker_back);
        this.mFileDirName = (TextView) findViewById(C0000R.id.file_picker_sub_name);
        this.mCurrentPath = new File("/sdcard/");
        fillListView(this.mCurrentPath);
        ScreenShareProc.mInstance.setHideForFilePicker(false);
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.filepicker.FilePickerActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (FilePickerActivity.this.dirStack.size() == 0) {
                    FilePickerActivity.logI("<CIH> stack empty. return sharescreen");
                    FilePickerActivity.this.setResult(0);
                    FilePickerActivity.this.finish();
                } else {
                    FilePickerActivity.this.mCurrentPath = (File) FilePickerActivity.this.dirStack.pop();
                    FilePickerActivity.logI("<CIH> current path = " + FilePickerActivity.this.mCurrentPath);
                    FilePickerActivity.this.fillListView(FilePickerActivity.this.mCurrentPath);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillListView(File path) {
        File[] contents = path.listFiles();
        List<FileInfo> directories = new ArrayList<>();
        List<FileInfo> files = new ArrayList<>();
        if (contents != null) {
            for (File f : contents) {
                if (f.isDirectory()) {
                    directories.add(new FileInfo(f.getName(), f.getAbsolutePath(), getDrawableResId(1), 1, true));
                } else {
                    FileInfo info = makeFileInfo(f);
                    if (info != null) {
                        files.add(info);
                    }
                }
            }
        }
        Collections.sort(directories);
        Collections.sort(files);
        directories.addAll(files);
        if (!path.getName().equalsIgnoreCase("sdcard")) {
            directories.add(0, new FileInfo("..", path.getParent(), getDrawableResId(1), 0, true));
        }
        this.mFileDirName.setText(this.mCurrentPath.getPath());
        this.mAdapter = new FileInfoArrayAdapter(this, C0000R.layout.screenshare_filepicker_item, directories);
        getListView().setDividerHeight(0);
        setListAdapter(this.mAdapter);
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        FileInfo fileInfo = this.mAdapter.getItem(position);
        if (fileInfo.getCategory() == 1) {
            logI("<CIH> directory Clicked!");
            this.dirStack.push(this.mCurrentPath);
            this.mCurrentPath = new File(fileInfo.getPath());
            fillListView(this.mCurrentPath);
            return;
        }
        if (fileInfo.getCategory() == 0) {
            logI("<CIH> parent directory Clicked!");
            this.mCurrentPath = this.dirStack.pop();
            fillListView(this.mCurrentPath);
        } else {
            logI("<CIH> file Clicked!");
            Intent intent = new Intent();
            intent.putExtra("TARGET_FILE_PATH", fileInfo.getPath());
            setResult(-1, intent);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.dirStack.size() == 0) {
            logI("<CIH> stack empty. return sharescreen");
            setResult(0);
            finish();
        } else {
            this.mCurrentPath = this.dirStack.pop();
            logI("<CIH> current path = " + this.mCurrentPath);
            fillListView(this.mCurrentPath);
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        ScreenShareProc.mInstance.setHideForFilePicker(true);
        finish();
    }

    private FileInfo makeFileInfo(File file) {
        String extension = getExtension(file.getName());
        int category = -1;
        if (extension != null) {
            category = makeCategory(extension);
        }
        if (category >= 0) {
            return new FileInfo(file.getName(), file.getAbsolutePath(), getDrawableResId(category), category, category >= 0);
        }
        return null;
    }

    private String getExtension(String fileName) {
        if (fileName != null) {
            StringTokenizer st = new StringTokenizer(fileName, ".");
            String extension = null;
            while (st.hasMoreTokens()) {
                extension = st.nextToken();
            }
            return extension;
        }
        return null;
    }

    private int makeCategory(String extension) {
        if (extension == null) {
            return -1;
        }
        if (extension.equalsIgnoreCase("txt")) {
            return 2;
        }
        if (extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx")) {
            return 3;
        }
        if (extension.equalsIgnoreCase("ppt") || extension.equalsIgnoreCase("pptx")) {
            return 4;
        }
        if (extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase("docx")) {
            return 5;
        }
        return extension.equalsIgnoreCase("pdf") ? 6 : -1;
    }

    private int getDrawableResId(int category) {
        switch (category) {
            case -1:
            case 0:
            default:
                return C0000R.drawable.co_attach_p_alert_normal;
            case 1:
                return C0000R.drawable.co_attach_file_folder;
            case 2:
                return C0000R.drawable.co_attach_file_text;
            case 3:
                return C0000R.drawable.co_attach_file_excel;
            case 4:
                return C0000R.drawable.co_attach_file_ppt;
            case 5:
                return C0000R.drawable.co_attach_file_word;
            case 6:
                return C0000R.drawable.co_attach_file_pdf;
        }
    }
}
