package com.task2.action.fileworking;
import java.io.File;

public interface FileExecutorsFactory {

    static FileExecutorsFactory create(){

        return new PlaneByPointsFileFactory();
    }

    PlaneReader makeReader(File file);
    PlaneReader makeReader(String filePath);
}
