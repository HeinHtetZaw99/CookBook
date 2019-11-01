package com.cache.room.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class HashMapTypeConverter {
    @TypeConverter
    fun fromString(value: String): HashMap<String, String> =
        Gson().fromJson(value, object : TypeToken<HashMap<String, String>>() {}.type)


    @TypeConverter
    fun fromStringMap(map: Map<String, String>) = Gson().toJson(map)!!

}