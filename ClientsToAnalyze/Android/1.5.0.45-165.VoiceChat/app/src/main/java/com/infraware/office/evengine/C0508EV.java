package com.infraware.office.evengine;

import android.graphics.Point;

/* renamed from: com.infraware.office.evengine.EV */
/* loaded from: classes.dex */
public class C0508EV {
    BOOK_CLIP bookClip;
    BOOKMARK_LABEL bookmarkLabel;
    BULLET_TYPE bulletType;
    BWP_GRAP_ATTR_INFO bwpGrapAttrInfo;
    BWP_OP_INFO bwpOpInfo;
    BWP_SPLITCELL_MAXNUM bwpSplitCellMaxNum;
    CARET_INFO caretInfoEvent;
    CARET_POS caretPos;
    CELL_PROPERTY cellProperty;
    CONFIG_INFO configInfo;
    protected EDITOR_OBJECT_POINTARRAY editorObjectPointArray;
    GUI_BORDER_EVENT guiBorderEvent;
    FONT_INFO guiFontEvent;
    SET_PARAATT_INFO guiSetParaAttEvent;
    GUI_SHEET_CHART_EVENT guiSheetChartEvent;
    HYPERLINK_INFO hyperInfo;
    INVALID_DRAW_INFO invalidDrawInfo;
    PROPERTIES properties;
    SCREEN_INFO screenInfo;
    SCROLLINFO_EDITOR scrollInfoEditor;
    SHEET_CELL_INFO sheetCellInfo;
    SHEET_FORMAT_INFO sheetFormatInfo;
    SHEET_INFO sheetInfo;
    RANGE sheetRange;

    public CONFIG_INFO getConfigInfo() {
        if (this.configInfo == null) {
            this.configInfo = new CONFIG_INFO();
        }
        return this.configInfo;
    }

    public PROPERTIES getProperties() {
        if (this.properties == null) {
            this.properties = new PROPERTIES();
        }
        return this.properties;
    }

    public BOOKMARK_LABEL getBookmarkLabel() {
        if (this.bookmarkLabel == null) {
            this.bookmarkLabel = new BOOKMARK_LABEL();
        }
        return this.bookmarkLabel;
    }

    public BOOK_CLIP getBookClip() {
        if (this.bookClip == null) {
            this.bookClip = new BOOK_CLIP();
        }
        return this.bookClip;
    }

    public HYPERLINK_INFO getHyperLinkInfo() {
        if (this.hyperInfo == null) {
            this.hyperInfo = new HYPERLINK_INFO();
        }
        return this.hyperInfo;
    }

    public SCREEN_INFO getScreenInfo() {
        if (this.screenInfo == null) {
            this.screenInfo = new SCREEN_INFO();
        }
        return this.screenInfo;
    }

    public GUI_BORDER_EVENT getGuiBorderEvent() {
        if (this.guiBorderEvent == null) {
            this.guiBorderEvent = new GUI_BORDER_EVENT();
        }
        return this.guiBorderEvent;
    }

    public CARET_INFO getCaretInfoEvent() {
        if (this.caretInfoEvent == null) {
            this.caretInfoEvent = new CARET_INFO();
        }
        return this.caretInfoEvent;
    }

    public CARET_POS getCaretPos() {
        if (this.caretPos == null) {
            this.caretPos = new CARET_POS();
        }
        return this.caretPos;
    }

    public FONT_INFO getGuiFontEvent() {
        if (this.guiFontEvent == null) {
            this.guiFontEvent = new FONT_INFO();
        }
        return this.guiFontEvent;
    }

    public BWP_GRAP_ATTR_INFO getBwpGrapAttrInfo() {
        if (this.bwpGrapAttrInfo == null) {
            this.bwpGrapAttrInfo = new BWP_GRAP_ATTR_INFO();
        }
        return this.bwpGrapAttrInfo;
    }

    public BWP_OP_INFO getBwpOpInfo() {
        if (this.bwpOpInfo == null) {
            this.bwpOpInfo = new BWP_OP_INFO();
        }
        return this.bwpOpInfo;
    }

    public BWP_SPLITCELL_MAXNUM getBwpSplitCellMaxNum() {
        if (this.bwpSplitCellMaxNum == null) {
            this.bwpSplitCellMaxNum = new BWP_SPLITCELL_MAXNUM();
        }
        return this.bwpSplitCellMaxNum;
    }

    public INVALID_DRAW_INFO getInvalidDrawInfo() {
        if (this.invalidDrawInfo == null) {
            this.invalidDrawInfo = new INVALID_DRAW_INFO();
        }
        return this.invalidDrawInfo;
    }

    public SET_PARAATT_INFO getGuiSetParaAttEvent() {
        if (this.guiSetParaAttEvent == null) {
            this.guiSetParaAttEvent = new SET_PARAATT_INFO();
        }
        return this.guiSetParaAttEvent;
    }

    public SHEET_FORMAT_INFO getSheetFormatInfo() {
        if (this.sheetFormatInfo == null) {
            this.sheetFormatInfo = new SHEET_FORMAT_INFO();
        }
        return this.sheetFormatInfo;
    }

    public RANGE getRange() {
        if (this.sheetRange == null) {
            this.sheetRange = new RANGE();
        }
        return this.sheetRange;
    }

    public SHEET_CELL_INFO getSheetCellInfo() {
        if (this.sheetCellInfo == null) {
            this.sheetCellInfo = new SHEET_CELL_INFO();
        }
        return this.sheetCellInfo;
    }

    public SHEET_INFO getSheetInfo() {
        if (this.sheetInfo == null) {
            this.sheetInfo = new SHEET_INFO();
        }
        return this.sheetInfo;
    }

    public GUI_SHEET_CHART_EVENT getGuiSheetChartEvent() {
        if (this.guiSheetChartEvent == null) {
            this.guiSheetChartEvent = new GUI_SHEET_CHART_EVENT();
        }
        return this.guiSheetChartEvent;
    }

    public SCROLLINFO_EDITOR getScrollInfoEditor() {
        if (this.scrollInfoEditor == null) {
            this.scrollInfoEditor = new SCROLLINFO_EDITOR();
        }
        return this.scrollInfoEditor;
    }

    public BULLET_TYPE getBulletType() {
        if (this.bulletType == null) {
            this.bulletType = new BULLET_TYPE();
        }
        return this.bulletType;
    }

    public CELL_PROPERTY getCellProperty() {
        if (this.cellProperty == null) {
            this.cellProperty = new CELL_PROPERTY();
        }
        return this.cellProperty;
    }

    public EDITOR_OBJECT_POINTARRAY getEditorObjectPointArray() {
        if (this.editorObjectPointArray == null) {
            this.editorObjectPointArray = new EDITOR_OBJECT_POINTARRAY();
        }
        return this.editorObjectPointArray;
    }

    void clear() {
        if (this.configInfo != null) {
            this.configInfo.clear();
        }
        if (this.properties != null) {
            this.properties.clear();
        }
        if (this.bookmarkLabel != null) {
            this.bookmarkLabel.clear();
        }
        if (this.bookClip != null) {
            this.bookClip.clear();
        }
        if (this.screenInfo != null) {
            this.screenInfo.clear();
        }
        if (this.guiBorderEvent != null) {
            this.guiBorderEvent.clear();
        }
        if (this.caretInfoEvent != null) {
            this.caretInfoEvent.clear();
        }
        if (this.caretPos != null) {
            this.caretPos.clear();
        }
        if (this.guiFontEvent != null) {
            this.guiFontEvent.clear();
        }
        if (this.bwpGrapAttrInfo != null) {
            this.bwpGrapAttrInfo.clear();
        }
        if (this.bwpOpInfo != null) {
            this.bwpOpInfo.clear();
        }
        if (this.bwpSplitCellMaxNum != null) {
            this.bwpSplitCellMaxNum.clear();
        }
        if (this.invalidDrawInfo != null) {
            this.invalidDrawInfo.clear();
        }
        if (this.guiSetParaAttEvent != null) {
            this.guiSetParaAttEvent.clear();
        }
        if (this.sheetFormatInfo != null) {
            this.sheetFormatInfo.clear();
        }
        if (this.sheetRange != null) {
            this.sheetRange.clear();
        }
        if (this.sheetCellInfo != null) {
            this.sheetCellInfo.clear();
        }
        if (this.sheetInfo != null) {
            this.sheetInfo.clear();
        }
        if (this.hyperInfo != null) {
            this.hyperInfo.clear();
        }
        if (this.guiSheetChartEvent != null) {
            this.guiSheetChartEvent.clear();
        }
        if (this.scrollInfoEditor != null) {
            this.scrollInfoEditor.clear();
        }
        if (this.bulletType != null) {
            this.bulletType.clear();
        }
        if (this.cellProperty != null) {
            this.cellProperty.clear();
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$CONFIG_INFO */
    public class CONFIG_INFO {
        public int bBGLoad;
        public int bContinuousMode;
        public int nCurPage;
        public int nDocExtType;
        public int nFitToHeightZoomValue;
        public int nFitToWidthZoomValue;
        public int nMaxZoom;
        public int nMinZoom;
        public int nOnlyOnePage;
        public int nReflowState;
        public int nRotateAngle;
        public int nTotalPages;
        public int nZoomLevel;
        public int nZoomRatio;
        public SCROLLINFO scrollInfo = new SCROLLINFO();

        /* renamed from: com.infraware.office.evengine.EV$CONFIG_INFO$SCROLLINFO */
        public class SCROLLINFO {
            public boolean possibleScrollDown;
            public boolean possibleScrollLeft;
            public boolean possibleScrollNextPage;
            public boolean possibleScrollPrevPage;
            public boolean possibleScrollRight;
            public boolean possibleScrollUp;

            public SCROLLINFO() {
            }

            void clear() {
                this.possibleScrollRight = false;
                this.possibleScrollUp = false;
                this.possibleScrollLeft = false;
                this.possibleScrollNextPage = false;
                this.possibleScrollPrevPage = false;
                this.possibleScrollDown = false;
            }
        }

        CONFIG_INFO() {
        }

        void clear() {
            this.nOnlyOnePage = 0;
            this.nDocExtType = 0;
            this.nFitToHeightZoomValue = 0;
            this.nFitToWidthZoomValue = 0;
            this.bContinuousMode = 0;
            this.nZoomLevel = 0;
            this.nReflowState = 0;
            this.nMaxZoom = 0;
            this.nMinZoom = 0;
            this.nRotateAngle = 0;
            this.nZoomRatio = 0;
            this.bBGLoad = 0;
            this.nTotalPages = 0;
            this.nCurPage = 0;
            this.scrollInfo.clear();
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$PROPERTIES */
    public class PROPERTIES {
        public int bCaretDoesntMoveWhenComposing;
        public int bDrawDirtyBitmap;
        public int bDualDisplay;
        public int bFixedWidth;
        public int bMakeThumbnailImage;
        public int bNotUseThumbnailBgColor;
        public int bPageOutline;
        public int bUseOriginImageAtComics;
        public int bVariableScale;
        public int byPageEdgePosition;
        public int byPageEdgeWidth;
        public int dwBgColor;
        public int dwEdgeColor;
        public int dwOutlineColor;
        public int dwPageMapColor;
        public int dwPageMapViewColor;
        public int dwSearchMarkSelectColor;
        public int nBookmarkType;
        public int nDefAlignment;
        public int nDefCharSpace;
        public int nDefLineSpace;
        public int nDirectionAtComics;
        public int nFrameBufferSwap;
        public int nGrayLevelForImage;
        public int nMakeThumbnailPages;
        public int nMaxBookclipValue;
        public int nPageMargin;
        public int nScrollType;
        public int nSearchMarkingMode;
        public int nSeperateModeAtComics;
        public int nThumbnailPercent;
        public int nUseBookmark;
        public int nZoomPhase;
        PAGEMAPPROPERTIES pagemapProperties = new PAGEMAPPROPERTIES();

        PROPERTIES() {
        }

        /* renamed from: com.infraware.office.evengine.EV$PROPERTIES$PAGEMAPPROPERTIES */
        public class PAGEMAPPROPERTIES {
            public int bBluringPagemap;
            public int bExternalPagemap;
            public int nPagemapHeight;
            public int nPagemapWidth;

            public PAGEMAPPROPERTIES() {
            }

            void clear() {
                this.nPagemapHeight = 0;
                this.nPagemapWidth = 0;
                this.bBluringPagemap = 0;
                this.bExternalPagemap = 0;
            }
        }

        void clear() {
            this.bCaretDoesntMoveWhenComposing = 0;
            this.bNotUseThumbnailBgColor = 0;
            this.dwSearchMarkSelectColor = 0;
            this.nDirectionAtComics = 0;
            this.bUseOriginImageAtComics = 0;
            this.nSeperateModeAtComics = 0;
            this.nPageMargin = 0;
            this.nMaxBookclipValue = 0;
            this.nDefCharSpace = 0;
            this.nDefAlignment = 0;
            this.nDefLineSpace = 0;
            this.nGrayLevelForImage = 0;
            this.nZoomPhase = 0;
            this.bDualDisplay = 0;
            this.bDrawDirtyBitmap = 0;
            this.nSearchMarkingMode = 0;
            this.nThumbnailPercent = 0;
            this.bFixedWidth = 0;
            this.bVariableScale = 0;
            this.nMakeThumbnailPages = 0;
            this.bMakeThumbnailImage = 0;
            this.nFrameBufferSwap = 0;
            this.nScrollType = 0;
            this.nBookmarkType = 0;
            this.nUseBookmark = 0;
            this.dwPageMapViewColor = 0;
            this.dwPageMapColor = 0;
            this.dwOutlineColor = 0;
            this.dwEdgeColor = 0;
            this.dwBgColor = 0;
            this.bPageOutline = 0;
            this.byPageEdgePosition = 0;
            this.byPageEdgeWidth = 0;
            this.pagemapProperties.clear();
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$BOOKMARK_LABEL */
    public class BOOKMARK_LABEL {
        public String szLabel = new String();
        public String szFilePath = new String();

        public BOOKMARK_LABEL() {
        }

        void clear() {
            this.szFilePath = "";
            this.szLabel = "";
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$BOOK_CLIP */
    public class BOOK_CLIP {
        public String szClipName = new String();
        public String szFilePath = new String();

        public BOOK_CLIP() {
        }

        void clear() {
            this.szFilePath = "";
            this.szClipName = "";
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$HYPERLINK_INFO */
    public class HYPERLINK_INFO {
        public int bReDraw;
        public int bUse;
        public String szHyperLink;
        public String szHyperText;

        public HYPERLINK_INFO() {
        }

        void clear() {
            this.szHyperLink = "";
            this.szHyperText = "";
            this.bReDraw = 0;
            this.bUse = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$SCREEN_INFO */
    public class SCREEN_INFO {
        public int nHeight;
        public int nMapHeight;
        public int nMapWidth;
        public int nMapX;
        public int nMapY;
        public int nWidth;

        /* renamed from: nX */
        public int f59nX;

        /* renamed from: nY */
        public int f60nY;

        public SCREEN_INFO() {
        }

        void clear() {
            this.nMapHeight = 0;
            this.nMapWidth = 0;
            this.nMapY = 0;
            this.nMapX = 0;
            this.nHeight = 0;
            this.nWidth = 0;
            this.f60nY = 0;
            this.f59nX = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$GUI_BORDER_EVENT */
    public class GUI_BORDER_EVENT {
        public int nBorderBottomColor;
        public int nBorderHorizontalColor;
        public int nBorderLeftColor;
        public int nBorderMask;
        public int nBorderRightColor;
        public int nBorderStyle;
        public int nBorderTopColor;
        public int nBorderVerticalColor;
        public int nCellColor;
        public int nType;

        public GUI_BORDER_EVENT() {
        }

        void clear() {
            this.nCellColor = 0;
            this.nBorderHorizontalColor = 0;
            this.nBorderVerticalColor = 0;
            this.nBorderBottomColor = 0;
            this.nBorderRightColor = 0;
            this.nBorderTopColor = 0;
            this.nBorderLeftColor = 0;
            this.nBorderStyle = 0;
            this.nBorderMask = 0;
            this.nType = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$CARET_INFO */
    public class CARET_INFO {
        public int bCaret;
        public int bOnlyCaretMove;
        public int nHeight;
        public int nType;
        public int nWidth;

        /* renamed from: nX */
        public int f57nX;

        /* renamed from: nY */
        public int f58nY;

        public CARET_INFO() {
        }

        void clear() {
            this.bOnlyCaretMove = 0;
            this.bCaret = 0;
            this.nHeight = 0;
            this.nWidth = 0;
            this.f58nY = 0;
            this.f57nX = 0;
            this.nType = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$CARET_POS */
    public class CARET_POS {
        public int bCorrectValue;
        public int nColPos;
        public int nParaPos;

        public CARET_POS() {
        }

        void clear() {
            this.nColPos = 0;
            this.nParaPos = 0;
            this.bCorrectValue = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$FONT_INFO */
    public class FONT_INFO {
        public int nBColor;
        public int nFColor;
        public int nFSize;
        public int nFontAtt;
        public int nHeight;
        public int nMaskFontAtt;
        public int nType;
        public int nWidth;
        public String szFontName;

        public FONT_INFO() {
        }

        void clear() {
            this.szFontName = "";
            this.nHeight = 0;
            this.nWidth = 0;
            this.nBColor = 0;
            this.nFColor = 0;
            this.nMaskFontAtt = 0;
            this.nFontAtt = 0;
            this.nFSize = 0;
            this.nType = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$BWP_GRAP_ATTR_INFO */
    public class BWP_GRAP_ATTR_INFO {
        public int eObjectType;
        public int nArrowType;
        public int nBorderColor;
        public int nBorderStyle;
        public int nBorderThickness;
        public int nFillColor;
        public int nGradient;
        public int nHeight;
        public int nRate;
        public int nWidth;

        public BWP_GRAP_ATTR_INFO() {
        }

        void clear() {
            this.eObjectType = 0;
            this.nRate = 0;
            this.nHeight = 0;
            this.nWidth = 0;
            this.nArrowType = 0;
            this.nBorderStyle = 0;
            this.nBorderThickness = 0;
            this.nBorderColor = 0;
            this.nGradient = 0;
            this.nFillColor = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$BWP_OP_INFO */
    public class BWP_OP_INFO {
        public int bCutCopy;
        public int bHasNativeClipboardData;
        public int bPaste;
        public int bSelectedLargeData;
        public BWP_GRAP_ATTR_INFO eObjectAttr;
        public int nCaretMode;
        public int nStatusOP;

        public BWP_OP_INFO() {
            this.eObjectAttr = C0508EV.this.new BWP_GRAP_ATTR_INFO();
        }

        void clear() {
            this.bHasNativeClipboardData = 0;
            this.bSelectedLargeData = 0;
            this.nStatusOP = 0;
            this.bPaste = 0;
            this.bCutCopy = 0;
            this.nCaretMode = 0;
            this.eObjectAttr.clear();
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$BWP_SPLITCELL_MAXNUM */
    public class BWP_SPLITCELL_MAXNUM {
        public int nCol;
        public int nRow;

        public BWP_SPLITCELL_MAXNUM() {
        }

        void clear() {
            this.nCol = 0;
            this.nRow = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$INVALID_DRAW_INFO */
    public class INVALID_DRAW_INFO {
        public int bInvalidFlag;
        public int nBottom;
        public int nLeft;
        public int nRight;
        public int nTop;

        public INVALID_DRAW_INFO() {
        }

        void clear() {
            this.bInvalidFlag = 0;
            this.nBottom = 0;
            this.nTop = 0;
            this.nRight = 0;
            this.nLeft = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$SET_PARAATT_INFO */
    public class SET_PARAATT_INFO {
        public int FirstLineType;
        public int FirstLineValue;
        public int ParaBottomValue;
        public int ParaDirection;
        public int ParaTopValue;
        public int bUndo;
        public int nHAlignType;
        public int nLeftMarginValue;
        public int nLineHeight;
        public int nLineSpace;
        public int nLineSpaceValue;
        public int nRightMarginValue;
        public int nType;
        public int nVAlignType;

        public SET_PARAATT_INFO() {
        }

        void clear() {
            this.bUndo = 0;
            this.ParaDirection = 0;
            this.nLineHeight = 0;
            this.ParaBottomValue = 0;
            this.ParaTopValue = 0;
            this.nLineSpaceValue = 0;
            this.nLineSpace = 0;
            this.FirstLineValue = 0;
            this.FirstLineType = 0;
            this.nRightMarginValue = 0;
            this.nLeftMarginValue = 0;
            this.nHAlignType = 0;
            this.nVAlignType = 0;
            this.nType = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$SHEET_FORMAT_INFO */
    public class SHEET_FORMAT_INFO {
        public int bBold;
        public int bItalic;
        public int bSeparate;
        public int bStrikeout;
        public int bUnderLine;
        public int bWrap;
        public int dwBorderBottomColor;
        public int dwBorderHorizontalColor;
        public int dwBorderLeftColor;
        public int dwBorderRightColor;
        public int dwBorderStyle;
        public int dwBorderTopColor;
        public int dwBorderVerticalColor;
        public int dwCellType;
        public int dwFillColor;
        public int dwFontColor;
        public int dwFontMask;
        public int nFontSize;
        public String szFontName = new String();
        public int wCurrency;
        public int wDate;
        public int wDecimalPlaces;
        public int wFormat;
        public int wFraction;
        public int wHorizontalAlignment;
        public int wNegative;
        public int wTime;
        public int wVerticalAlignment;

        public SHEET_FORMAT_INFO() {
        }

        void clear() {
            this.bWrap = 0;
            this.dwCellType = 0;
            this.dwFillColor = 0;
            this.dwBorderHorizontalColor = 0;
            this.dwBorderVerticalColor = 0;
            this.dwBorderBottomColor = 0;
            this.dwBorderRightColor = 0;
            this.dwBorderTopColor = 0;
            this.dwBorderLeftColor = 0;
            this.dwBorderStyle = 0;
            this.dwFontMask = 0;
            this.bStrikeout = 0;
            this.bUnderLine = 0;
            this.bItalic = 0;
            this.bBold = 0;
            this.dwFontColor = 0;
            this.nFontSize = 0;
            this.wVerticalAlignment = 0;
            this.wHorizontalAlignment = 0;
            this.wFraction = 0;
            this.wTime = 0;
            this.wDate = 0;
            this.wNegative = 0;
            this.wCurrency = 0;
            this.bSeparate = 0;
            this.wDecimalPlaces = 0;
            this.wFormat = 0;
            this.szFontName = "";
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$RANGE */
    public class RANGE {
        public int nBottom;
        public int nCol1;
        public int nCol2;
        public int nLeft;
        public int nRight;
        public int nRow1;
        public int nRow2;
        public int nTop;

        public RANGE() {
        }

        void clear() {
            this.nBottom = 0;
            this.nRight = 0;
            this.nTop = 0;
            this.nLeft = 0;
            this.nCol2 = 0;
            this.nRow2 = 0;
            this.nCol1 = 0;
            this.nRow1 = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$SHEET_CELL_INFO */
    public class SHEET_CELL_INFO {
        public RANGE tActiveRange;
        public RANGE tColumnHeader;
        public RANGE tEditTextRange;
        public RANGE tRowHeader;
        public RANGE tSelectedRange;
        public int wColWidth;
        public int wRowHeight;

        public SHEET_CELL_INFO() {
            this.tRowHeader = C0508EV.this.new RANGE();
            this.tColumnHeader = C0508EV.this.new RANGE();
            this.tActiveRange = C0508EV.this.new RANGE();
            this.tSelectedRange = C0508EV.this.new RANGE();
            this.tEditTextRange = C0508EV.this.new RANGE();
        }

        void clear() {
            this.tRowHeader.clear();
            this.tColumnHeader.clear();
            this.wColWidth = 0;
            this.wRowHeight = 0;
            this.tActiveRange.clear();
            this.tSelectedRange.clear();
            this.tEditTextRange.clear();
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$SHEET_INFO */
    public class SHEET_INFO {
        public int bFreeze;
        public int bPageBreak;
        public int bProtectSheet;
        public String szSheetName = new String();

        public SHEET_INFO() {
        }

        void clear() {
            this.szSheetName = "";
            this.bPageBreak = 0;
            this.bFreeze = 0;
            this.bProtectSheet = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$GUI_SHEET_CHART_EVENT */
    public class GUI_SHEET_CHART_EVENT {
        public int nChart;
        public int nLegend;
        public int nSeriesIn;
        public int nType;
        public String szTitle = new String();
        public String szXAxis = new String();
        public String szYAxis = new String();
        public RANGE tRange;

        public GUI_SHEET_CHART_EVENT() {
            this.tRange = C0508EV.this.new RANGE();
        }

        void clear() {
            this.nChart = 0;
            this.nType = 0;
            this.tRange.clear();
            this.nSeriesIn = 0;
            this.szYAxis = "";
            this.szXAxis = "";
            this.szTitle = "";
            this.nLegend = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$SCROLLINFO_EDITOR */
    public class SCROLLINFO_EDITOR {
        public int bGaroScroll;
        public int nCurPosX;
        public int nCurPosY;
        public int nHeight;
        public int nWidth;

        public SCROLLINFO_EDITOR() {
        }

        void clear() {
            this.bGaroScroll = 0;
            this.nCurPosY = 0;
            this.nCurPosX = 0;
            this.nHeight = 0;
            this.nWidth = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$BULLET_TYPE */
    public class BULLET_TYPE {
        public int nBulletMode;
        public int nBulletType;

        public BULLET_TYPE() {
        }

        void clear() {
            this.nBulletType = 0;
            this.nBulletMode = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$CELL_PROPERTY */
    public class CELL_PROPERTY {
        public int a_BorderColor;
        public int a_BorderLineStyle;
        public int a_BorderLineWidthType;
        public int a_CellBorderType;
        public int a_CellColor;

        public CELL_PROPERTY() {
        }

        void clear() {
            this.a_BorderLineStyle = 0;
            this.a_BorderLineWidthType = 0;
            this.a_CellBorderType = 0;
            this.a_BorderColor = 0;
            this.a_CellColor = 0;
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$FONT_DATA */
    public class FONT_DATA {
        public int bBold;
        public long bColor;
        public int bEmboss;
        public int bEngrave;
        public int bItalic;
        public int bOutLine;
        public int bStrikeout;
        public int bUnderLine;
        public long fColor;
        public String fName;
        public int fSize;

        public FONT_DATA() {
        }
    }

    /* renamed from: com.infraware.office.evengine.EV$EDITOR_OBJECT_POINTARRAY */
    public class EDITOR_OBJECT_POINTARRAY {
        public int nObjPointCnt;
        public EDIT_OBJECT_RANGE ptObjRange = new EDIT_OBJECT_RANGE();
        public EDIT_OBJECT_POINT[] ptObjPoint = new EDIT_OBJECT_POINT[2];

        EDITOR_OBJECT_POINTARRAY() {
            this.ptObjPoint[0] = new EDIT_OBJECT_POINT();
            this.ptObjPoint[1] = new EDIT_OBJECT_POINT();
        }

        /* renamed from: com.infraware.office.evengine.EV$EDITOR_OBJECT_POINTARRAY$EDIT_OBJECT_RANGE */
        public class EDIT_OBJECT_RANGE {
            public int bEditing;
            public int nEditingAngle;
            public int nObjectType;
            public int nRotateAngle;
            public Point startPoint = new Point();
            public Point endPoint = new Point();
            public Point ptEditingStart = new Point();
            public Point ptEditingEnd = new Point();
            public Point sObjectSize = new Point();

            public EDIT_OBJECT_RANGE() {
            }

            void clear() {
                Point point = this.startPoint;
                Point point2 = this.startPoint;
                Point point3 = this.endPoint;
                Point point4 = this.endPoint;
                Point point5 = this.sObjectSize;
                Point point6 = this.sObjectSize;
                this.nObjectType = 0;
                point6.y = 0;
                point5.x = 0;
                point4.y = 0;
                point3.x = 0;
                point2.y = 0;
                point.x = 0;
                Point point7 = this.ptEditingStart;
                Point point8 = this.ptEditingStart;
                Point point9 = this.ptEditingEnd;
                Point point10 = this.ptEditingEnd;
                int i = this.bEditing;
                this.nEditingAngle = i;
                point10.y = i;
                point9.x = i;
                point8.y = i;
                point7.x = i;
                this.nRotateAngle = i;
            }
        }

        /* renamed from: com.infraware.office.evengine.EV$EDITOR_OBJECT_POINTARRAY$EDIT_OBJECT_POINT */
        public class EDIT_OBJECT_POINT {
            public int nObjectType;
            public Point point = new Point();

            public EDIT_OBJECT_POINT() {
            }

            void clear() {
                Point point = this.point;
                Point point2 = this.point;
                this.nObjectType = 0;
                point2.y = 0;
                point.x = 0;
            }
        }

        EDITOR_OBJECT_POINTARRAY setValue(int[] param) {
            this.ptObjRange.startPoint.x = param[0];
            this.ptObjRange.startPoint.y = param[1];
            this.ptObjRange.endPoint.x = param[2];
            this.ptObjRange.endPoint.y = param[3];
            this.ptObjRange.nRotateAngle = param[4];
            this.ptObjRange.ptEditingStart.x = param[5];
            this.ptObjRange.ptEditingStart.y = param[6];
            this.ptObjRange.ptEditingEnd.x = param[7];
            this.ptObjRange.ptEditingEnd.y = param[8];
            this.ptObjRange.nEditingAngle = param[9];
            this.ptObjRange.bEditing = param[10];
            this.ptObjRange.sObjectSize.x = param[11];
            this.ptObjRange.sObjectSize.y = param[12];
            this.ptObjRange.nObjectType = param[13];
            this.nObjPointCnt = param[14];
            this.ptObjPoint[0].point.x = param[15];
            this.ptObjPoint[0].point.y = param[16];
            this.ptObjPoint[0].nObjectType = param[17];
            this.ptObjPoint[1].point.x = param[18];
            this.ptObjPoint[1].point.y = param[19];
            this.ptObjPoint[1].nObjectType = param[20];
            return this;
        }

        void clear() {
            this.ptObjRange.clear();
            this.nObjPointCnt = 0;
            this.ptObjPoint[0].clear();
            this.ptObjPoint[1].clear();
        }
    }
}
