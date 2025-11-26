package com.coolots.chaton.call.screenshare;

import android.net.Uri;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FileUriArrayList {
    private int mCurrentIdx;
    private final FilenameFilter mFileNameFilter;
    private String mFilePath;
    private ArrayList<Uri> mList;

    public FileUriArrayList() {
        this.mFileNameFilter = new FilenameFilter() { // from class: com.coolots.chaton.call.screenshare.FileUriArrayList.1
            @Override // java.io.FilenameFilter
            public boolean accept(File dir, String filename) {
                return filename.contains(".png") || filename.contains(".jpg") || filename.contains(".gif");
            }
        };
        this.mCurrentIdx = 0;
        this.mFilePath = "";
        this.mList = new ArrayList<>();
    }

    public FileUriArrayList(String path) {
        this.mFileNameFilter = new FilenameFilter() { // from class: com.coolots.chaton.call.screenshare.FileUriArrayList.1
            @Override // java.io.FilenameFilter
            public boolean accept(File dir, String filename) {
                return filename.contains(".png") || filename.contains(".jpg") || filename.contains(".gif");
            }
        };
        this.mCurrentIdx = 0;
        this.mFilePath = path;
        makeFileUriList();
    }

    public void makeFileUriList() {
        File[] files;
        if (this.mList == null) {
            this.mList = new ArrayList<>();
        }
        if (!this.mList.isEmpty()) {
            this.mList.clear();
        }
        File dir = new File(this.mFilePath);
        if (dir != null && (files = dir.listFiles(this.mFileNameFilter)) != null) {
            for (File file : files) {
                String fileName = file.getAbsolutePath();
                File file2 = new File(fileName);
                if (file2.exists()) {
                    Uri uri = Uri.fromFile(file2);
                    this.mList.add(uri);
                }
            }
        }
    }

    public void removeFiles() {
        File dir = new File(this.mFilePath);
        if (dir != null) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (int fileIdx = 0; fileIdx < files.length; fileIdx++) {
                    if (files[fileIdx].exists()) {
                        files[fileIdx].delete();
                    }
                }
            }
            dir.delete();
        }
    }

    public Uri getFileUri() {
        return this.mList.get(this.mCurrentIdx);
    }

    public Uri moveToPrev() {
        this.mCurrentIdx--;
        if (this.mCurrentIdx < 0) {
            this.mCurrentIdx = this.mList.size() - 1;
        }
        return getFileUri();
    }

    public Uri moveToNext() {
        this.mCurrentIdx++;
        if (this.mCurrentIdx >= this.mList.size()) {
            this.mCurrentIdx = 0;
        }
        return getFileUri();
    }

    public int getCurrentIdx() {
        return this.mCurrentIdx;
    }

    public int getSize() {
        return this.mList.size();
    }

    public void setCurrentIdx(int currentIdx) {
        this.mCurrentIdx = currentIdx;
    }

    public void setFilePath(String filePath) {
        this.mFilePath = filePath;
    }

    public String getFilePath() {
        return this.mFilePath;
    }
}
