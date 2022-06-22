package tech.antee.second.data.local.shared_preferences

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val DEFAULT_STRING = ""

fun <T> SharedPreferences.getList(key: String?): List<T>? {
    val gson = Gson()
    val type: Type = object : TypeToken<List<T>?>() {}.type
    return gson.fromJson(getString(key, DEFAULT_STRING), type)
}

fun <T> SharedPreferences.putList(key: String?, list: List<T>?) {
    val gson = Gson()
    val json: String = gson.toJson(list)
    putString(key, json)
}

fun SharedPreferences.putString(key: String?, value: String?) {
    val editor = this.edit()
    editor.putString(key, value)
    editor.apply()
}
