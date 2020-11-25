package com.example.scheactim.adaptadores.viewholder;

import androidx.annotation.DrawableRes;

import com.example.scheactim.R;
import com.example.scheactim.data.IActividadesSource;

public class ActividadesViewHelper {
    @DrawableRes
    public static int getResIdByCategory(String category) {
        switch(category) {
            case IActividadesSource.Categories.TAREA_FIN:
                return R.drawable.check_icon;
            case IActividadesSource.Categories.TAREA_PEN:
                return R.drawable.info_icon;
            case IActividadesSource.Categories.TAREA_RET:
                return R.drawable.calendar_icon;
            default:
                return R.drawable.clock;
        }
    }
}
