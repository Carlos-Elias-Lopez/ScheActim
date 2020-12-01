package com.example.scheactim.data;

import android.provider.BaseColumns;

public class ScheActimDbContract {
    private ScheActimDbContract() {}

    //implementar BaseColumns permite implementar facilmente un campo por defecto que funciona
    //como llave primaria (_ID)
    public static class Struct implements BaseColumns {
        public static final String TABLE_NAME = "actividades";
        public static final String COLUMN_TITLE = "nombre";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_CREATED_INI = "inicio";
        //public static final String COLUMN_CREATED_FIN = "fin";
    }

    public static class Queries {
        //Tipos de datos: https://www.sqlite.org/datatype3.html
        public static final String CREATE =
                "CREATE TABLE " + Struct.TABLE_NAME +
                        " (" + Struct._ID + " INTEGER PRIMARY KEY, " +
                        Struct.COLUMN_TITLE + " TEXT, " +
                        Struct.COLUMN_DESCRIPTION + " TEXT, " +
                        Struct.COLUMN_CREATED_INI + " LONG " +

                        " )";

        public static final String DELETE =
                "DROP TABLE IF EXISTS " + Struct.TABLE_NAME;
    }

}
