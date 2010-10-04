package org.albite.book.model;

import java.util.Vector;
import javax.microedition.io.InputConnection;
import org.albite.util.archive.ArchivedFile;

public class Chapter {
    private final String            title;
    private final InputConnection   file;
    private final int               fileSize;

    private Chapter                 prevChapter;
    private Chapter                 nextChapter;

    private char[]                  textBuffer;
    private Vector                  images;

    private int                     currentPosition = 0;

    private final int               number;

    public Chapter(
            final InputConnection file,
            final int fileSize,
            final String title,
            final int number) {

        this.file = file;
        this.fileSize = fileSize;
        this.title = title;
        this.number = number;
    }

    public final String getTitle() {
        return title;
    }

    public final Chapter getPrevChapter() {
        return prevChapter;
    }

    public final void setPrevChapter(final Chapter bc) {
        prevChapter = bc;
    }

    public final Chapter getNextChapter() {
        return nextChapter;
    }

    public final void setNextChapter(final Chapter bc) {
        nextChapter = bc;
    }

    public final char[] getTextBuffer() {
        if (textBuffer == null) {
            try {
                textBuffer = ArchivedFile.getAsChars(file, fileSize);
            } catch (Exception e) {}
        }
        return textBuffer;
    }

    public final void unload() {
        textBuffer = null;
    }

    public final int getCurrentPosition() {
        return currentPosition;
    }

    public final void setCurrentPosition(final int pos) {
        if (pos < 0) {
            currentPosition = 0;
        }

        currentPosition = pos;
    }

    public final int getNumber() {
        return number;
    }
}