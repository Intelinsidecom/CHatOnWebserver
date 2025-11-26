package com.coolots.chaton.call.screenshare.util;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BoardDataController implements DisposeInterface {
    private static final String CLASSNAME = "[BoardDataController] ";
    private int mDocsTotalPageNum;
    private String mDocsImgDumpPath = null;
    private String mDocsName = null;
    private String mDocsFilePath = null;
    private boolean isHomeKeyExit = false;
    private ArrayList<BoardDataContainer> mBoardContainerList = new ArrayList<>();

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public void getCurrentContainer(int page) {
        logI("getCurrentContainer page: " + page);
        BoardDataContainer container = getBoardDataContainer(page);
        if (container == null) {
            addBoardDataContainer(page);
        }
    }

    private BoardDataContainer addBoardDataContainer(int page) {
        BoardDataContainer container = new BoardDataContainer();
        container.setPage(page);
        this.mBoardContainerList.add(container);
        return container;
    }

    public void addBoardData(int page, int type, byte[] data) {
        BoardDataContainer container = getBoardDataContainer(page);
        if (container != null) {
            container.addData(type, data);
        } else {
            addBoardDataContainer(page).addData(type, data);
        }
    }

    private BoardDataContainer getBoardDataContainer(int page) {
        if (this.mBoardContainerList == null) {
            this.mBoardContainerList = new ArrayList<>();
        }
        Iterator<BoardDataContainer> it = this.mBoardContainerList.iterator();
        while (it.hasNext()) {
            BoardDataContainer container = it.next();
            if (container.getPage() == page) {
                return container;
            }
        }
        return null;
    }

    public void removeBoardDataInPage(int page) {
        Iterator<BoardDataContainer> it = this.mBoardContainerList.iterator();
        while (it.hasNext()) {
            BoardDataContainer container = it.next();
            if (container.getPage() == page) {
                container.removeBoardData();
                return;
            }
        }
    }

    public ArrayList<BoardData> getCurrentPageData(int page) {
        BoardDataContainer container = getBoardDataContainer(page);
        if (container != null) {
            return container.getBoardData();
        }
        return null;
    }

    public void setmDocsImgeDumpPath(String ImgDumpPath) {
        this.mDocsImgDumpPath = ImgDumpPath;
    }

    public String getDocImgDumpPath() {
        return this.mDocsImgDumpPath;
    }

    public void setDocsName(String docsName) {
        this.mDocsName = docsName;
    }

    public String getDocsName() {
        return this.mDocsName;
    }

    public void pressedHomeKey(boolean pressed) {
        this.isHomeKeyExit = pressed;
    }

    public boolean isHomeKeyExit() {
        return this.isHomeKeyExit;
    }

    public void setFilePath(String filePath) {
        this.mDocsFilePath = filePath;
    }

    public String getFilePath() {
        return this.mDocsFilePath;
    }

    public void setDocsToltalPageNum(int totalPage) {
        this.mDocsTotalPageNum = totalPage;
    }

    public int getDocsToltalPageNum() {
        return this.mDocsTotalPageNum;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mBoardContainerList != null) {
            if (this.mBoardContainerList.size() > 0) {
                Iterator<BoardDataContainer> it = this.mBoardContainerList.iterator();
                while (it.hasNext()) {
                    BoardDataContainer container = it.next();
                    container.dispose();
                }
            }
            this.mBoardContainerList.clear();
            this.mBoardContainerList = null;
        }
        if (this.mDocsImgDumpPath != null) {
            this.mDocsImgDumpPath = null;
        }
        if (this.mDocsFilePath != null) {
            this.mDocsFilePath = null;
        }
        if (this.mDocsName != null) {
            this.mDocsName = null;
        }
    }
}
