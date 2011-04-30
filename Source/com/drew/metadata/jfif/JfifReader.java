/*
 * Copyright 2002-2011 Drew Noakes
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 * More information about this project is available at:
 *
 *    http://drewnoakes.com/code/exif/
 *    http://code.google.com/p/metadata-extractor/
 */
package com.drew.metadata.jfif;

import com.drew.lang.BufferBoundsException;
import com.drew.lang.BufferReader;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataReader;

/**
 * Reader for JFIF data, found in the APP0 Jpeg segment.
 * <p/>
 * More info at: http://en.wikipedia.org/wiki/JPEG_File_Interchange_Format
 *
 * @author Yuri Binev, Drew Noakes
 */
public class JfifReader implements MetadataReader
{
    // TODO add unit tests for JFIF data

    /** The SOF0 data segment. */
    @NotNull
    private final byte[] _data;

    /**
     * Initialises a new JfifReader for a given byte array.
     *
     * @param data the byte array to read Jfif data from
     */
    public JfifReader(@NotNull byte[] data)
    {
        if (data == null)
            throw new NullPointerException();
        _data = data;
    }

    /**
     * Performs the Jfif data extraction, adding found values to the specified
     * instance of <code>Metadata</code>.
     */
    public void extract(@NotNull Metadata metadata)
    {
        JfifDirectory directory = metadata.getOrCreateDirectory(JfifDirectory.class);
        BufferReader reader = new BufferReader(_data);

        try {
            int ver = reader.getInt32(JfifDirectory.TAG_JFIF_VERSION);
            directory.setInt(JfifDirectory.TAG_JFIF_VERSION, ver);

            int units = reader.getUInt16(JfifDirectory.TAG_JFIF_UNITS);
            directory.setInt(JfifDirectory.TAG_JFIF_UNITS, units);

            int height = reader.getInt32(JfifDirectory.TAG_JFIF_RESX);
            directory.setInt(JfifDirectory.TAG_JFIF_RESX, height);

            int width = reader.getInt32(JfifDirectory.TAG_JFIF_RESY);
            directory.setInt(JfifDirectory.TAG_JFIF_RESY, width);

        } catch (BufferBoundsException me) {
            directory.addError(me.getMessage());
        }
    }
}