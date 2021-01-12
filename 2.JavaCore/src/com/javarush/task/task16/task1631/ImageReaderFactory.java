package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes it){
        if (it != null)
            switch (it){
                case BMP: return new BmpReader();
                case JPG: return new JpgReader();
                case PNG: return new PngReader();
                default: throw new IllegalArgumentException("Неизвестный тип картинки");
            }
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
