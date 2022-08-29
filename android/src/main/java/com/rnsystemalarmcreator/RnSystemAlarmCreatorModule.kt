package com.rnsystemalarmcreator

import android.content.Intent
import android.provider.AlarmClock
import android.util.Log
import com.facebook.react.bridge.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt


class RnSystemAlarmCreatorModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "RnSystemAlarmCreator"
    }

    @ReactMethod
    fun setAlarm(data:ReadableMap) {
        val hours =data.getInt("hours")
        val mins = data.getInt("mins");
        val name = data.getString("name");
        val alarmDays = ArrayList<Int>()
        if(data.hasKey("days")){
            val days= data.getArray("days")!!.toArrayList()
            days.forEach { it ->
                alarmDays.add(it.toString().toDouble().roundToInt())
            }
        }
        val i = Intent(AlarmClock.ACTION_SET_ALARM)
        i.putExtra("android.intent.extra.alarm.HOUR", hours)
        i.putExtra("android.intent.extra.alarm.MINUTES", mins)
        i.putExtra("android.intent.extra.alarm.MESSAGE", name)
        if(alarmDays.isNotEmpty()){
            i.putExtra("android.intent.extra.alarm.DAYS",alarmDays)
        }
        i.putExtra("android.intent.extra.alarm.SKIP_UI", true)
        i.flags=Intent.FLAG_ACTIVITY_NEW_TASK
        reactApplicationContext.startActivity(i)
    }
}
