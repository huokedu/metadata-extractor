package com.drew.metadata.gif;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;

import java.util.HashMap;

/**
 * @author Drew Noakes https://drewnoakes.com
 */
public class GifHeaderDirectory extends Directory
{
    public static final int TAG_GIF_FORMAT_VERSION = 1;
    public static final int TAG_IMAGE_WIDTH = 2;
    public static final int TAG_IMAGE_HEIGHT = 3;
    public static final int TAG_COLOR_TABLE_SIZE = 4;
    public static final int TAG_IS_COLOR_TABLE_SORTED = 5;
    public static final int TAG_BITS_PER_PIXEL = 6;
    public static final int TAG_HAS_GLOBAL_COLOR_TABLE = 7;
    public static final int TAG_TRANSPARENT_COLOR_INDEX = 8;
    public static final int TAG_PIXEL_ASPECT_RATIO = 9;

    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<Integer, String>();

    static {
        _tagNameMap.put(TAG_GIF_FORMAT_VERSION, "GIF Format Version");
        _tagNameMap.put(TAG_IMAGE_HEIGHT, "Image Height");
        _tagNameMap.put(TAG_IMAGE_WIDTH, "Image Width");
        _tagNameMap.put(TAG_COLOR_TABLE_SIZE, "Color Table Size");
        _tagNameMap.put(TAG_IS_COLOR_TABLE_SORTED, "Is Color Table Sorted");
        _tagNameMap.put(TAG_BITS_PER_PIXEL, "Bits per Pixel");
        _tagNameMap.put(TAG_HAS_GLOBAL_COLOR_TABLE, "Has Global Color Table");
        _tagNameMap.put(TAG_TRANSPARENT_COLOR_INDEX, "Transparent Color Index");
        _tagNameMap.put(TAG_PIXEL_ASPECT_RATIO, "Pixel Aspect Ratio");
    }

    public GifHeaderDirectory()
    {
        this.setDescriptor(new GifHeaderDescriptor(this));
    }

    @Override
    @NotNull
    public String getName()
    {
        return "GIF Header";
    }

    @Override
    @NotNull
    protected HashMap<Integer, String> getTagNameMap()
    {
        return _tagNameMap;
    }
}
