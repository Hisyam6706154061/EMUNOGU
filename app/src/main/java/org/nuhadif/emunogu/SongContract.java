package org.nuhadif.emunogu;

import android.net.Uri;
import android.provider.BaseColumns;

public class SongContract implements BaseColumns {
    public static final String CONTENT_AUTHORITY = "org.nuhadif.emunogu";
    public static final Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final class Song{
        public static final String TABLE_SONG = "song";
        public static final String COL_ID = BaseColumns._ID;
        public static final String COL_TITLE = "title";
        public static final String COL_DESCTIPTION = "description";
        public static final String COL_MUSIC = "music";
        //ntar tambah lagi untuk database composer nya

        //tabel materi
        public static final String TABLE_MATERI = "materi";
        public static final String COL_ID_MATERI = BaseColumns._ID;
        public static final String COL_BAB = "bab";
        public static final String COL_POINT = "point";
        public static final String COL_MATERI = "materi";
        public static final String COL_IMAGE = "image";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI,TABLE_SONG);
        public static final Uri CONTENT_URI_MATERI = Uri.withAppendedPath(BASE_URI,TABLE_MATERI);
    }

}
