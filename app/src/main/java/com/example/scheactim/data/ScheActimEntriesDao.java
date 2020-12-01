package com.example.scheactim.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.scheactim.helpers.DateHelper;
import com.example.scheactim.modelos.ActividadesEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ScheActimEntriesDao {
    private static final String TAG = ScheActimEntriesDao.class.getName();
    private final Context mContext;

    public ScheActimEntriesDao(@NonNull Context context) {
        mContext = context;
    }

    public List<ActividadesEntry> getAll() {
        //definimos los campos que consultaremos de la tabla en BD.
        String[] projection = {
                ScheActimDbContract.Struct._ID,
                ScheActimDbContract.Struct.COLUMN_TITLE,
                ScheActimDbContract.Struct.COLUMN_DESCRIPTION,
                ScheActimDbContract.Struct.COLUMN_CREATED_INI,
        };

        //Ordenar por fecha de creacion DESC
        String sortOrder = ScheActimDbContract.Struct.COLUMN_CREATED_INI + " DESC";

        //Crea o abre la conexion a BD y nos devuelve una instancia de ella.
        MainDbHelper mDbHelper = MainDbHelper.getInstance(mContext);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        //De forma simple, un cursor representa cada fila de los resultados generados tras la consulta.
        Cursor rowCursor = db.query(
                ScheActimDbContract.Struct.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
        List<ActividadesEntry> entriesFromDb = new ArrayList<>();
        //en un ciclo recorremos cada fila de resultados usando el metodo moveToNext
        //el cual nos mueve a la siguiente fila por cada iteracion realizada.
        while (rowCursor.moveToNext()) {
            ActividadesEntry entry = toEntryFromCursor(rowCursor);
            if(entry != null) {
                entriesFromDb.add(entry);
            }
        }

        rowCursor.close();
        return entriesFromDb;
    }

    public long insert(ActividadesEntry entry) {
        MainDbHelper mDbHelper = MainDbHelper.getInstance(mContext);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues valuesToInsert = buildRowContentFromModel(entry);
        return db.insert(ScheActimDbContract.Struct.TABLE_NAME, null, valuesToInsert);
    }

    public boolean deleteAll() {
        try {
            MainDbHelper mDbHelper = MainDbHelper.getInstance(mContext);
            SQLiteDatabase db = mDbHelper.getWritableDatabase();
            long result = db.delete(ScheActimDbContract.Struct.TABLE_NAME, null, null);
            return true;
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
            return false;
        }
    }

    @Nullable
    private ActividadesEntry toEntryFromCursor(@NonNull Cursor cursor) {
        try {
            long id = cursor.getLong(
                    cursor.getColumnIndexOrThrow(ScheActimDbContract.Struct._ID)
            );
            String name = cursor.getString(
                    cursor.getColumnIndexOrThrow(ScheActimDbContract.Struct.COLUMN_TITLE)
            );
            String description = cursor.getString(
                    cursor.getColumnIndexOrThrow(ScheActimDbContract.Struct.COLUMN_DESCRIPTION)
            );
            long createdINI = cursor.getLong(
                    cursor.getColumnIndexOrThrow(ScheActimDbContract.Struct.COLUMN_CREATED_INI)
            );
            /*long createdFIN = cursor.getLong(
                    cursor.getColumnIndexOrThrow(ScheActimDbContract.Struct.COLUMN_CREATED_FIN)
            );*/

            return new ActividadesEntry(
                    id,
                    name,
                    description,
                    DateHelper.getDateFromMilli(createdINI)
            );
        } catch (IllegalArgumentException ex) {
            Log.e(TAG, String.format(
                    Locale.getDefault(),
                    "Ocurrió un error al obtener desde BD el registro. Mensaje: %s", ex.getMessage()
            ));
            return null;
        }
    }

    private ContentValues buildRowContentFromModel(ActividadesEntry entry) {
        ContentValues values = new ContentValues();
        values.put(ScheActimDbContract.Struct.COLUMN_TITLE, entry.getTitle());
        values.put(ScheActimDbContract.Struct.COLUMN_DESCRIPTION, entry.getDescription());
        values.put(ScheActimDbContract.Struct.COLUMN_CREATED_INI, DateHelper.getNowMillis());
        //values.put(ScheActimDbContract.Struct.COLUMN_CREATED_FIN, DateHelper.getNowMillis());
        return values;
    }
}
