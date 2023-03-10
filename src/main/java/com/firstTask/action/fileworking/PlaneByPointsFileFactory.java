package com.task2.action.fileworking;

import java.io.File;
public class PlaneByPointsFileFactory implements FileExecutorsFactory {
    @Override
    public PlaneReader makeReader(File file) {
        return new PlaneByPointReader(file);
    }

    @Override
    public PlaneReader makeReader(String filePath) {
        return new PlaneByPointReader(new File(filePath));
    }
}
