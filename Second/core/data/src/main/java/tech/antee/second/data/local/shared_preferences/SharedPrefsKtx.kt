package tech.antee.second.data.local.shared_preferences

import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import tech.antee.second.data.utils.TAG_DATA_LOCAL
import java.lang.reflect.Type

internal inline fun <reified T> SharedPreferences.getList(key: String?): List<T>? {
    val gson = Gson()
    val type: Type = object : TypeToken<List<T>?>() {}.type
    return gson.fromJson<List<T>?>(getString(key, ""), type).also {
        Log.d(TAG_DATA_LOCAL, "Getting data from cache: size = ${it.size}, data =  $it.")
    }
}

internal inline fun <reified T> SharedPreferences.putList(key: String?, list: List<T>?) {
    val gson = Gson()
    val json: String = gson.toJson(list)
    putString(key, json)
    Log.d(TAG_DATA_LOCAL, "Local data updated: key = $key, size = ${list?.size}, data = $list")
}

internal fun SharedPreferences.putString(key: String?, value: String?) {
    val editor = this.edit()
    editor.putString(key, value)
    editor.apply()
}
