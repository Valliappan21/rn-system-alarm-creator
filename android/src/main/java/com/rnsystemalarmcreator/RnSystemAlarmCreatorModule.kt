package com.rnsystemalarmcreator

import android.content.Intent
import android.provider.AlarmClock
import com.facebook.react.bridge.*
import java.util.*
import kotlin.collections.ArrayList


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
                alarmDays.add(it as Int)
            }
        }
        val i = Intent(AlarmClock.ACTION_SET_ALARM)
//        val alarmDays = ArrayList<Int>()
        alarmDays.add(Calendar.SATURDAY)
        i.putExtra("android.intent.extra.alarm.HOUR", hours)
        i.putExtra("android.intent.extra.alarm.MINUTES", mins)
        i.putExtra("android.intent.extra.alarm.MESSAGE", name)
        i.putExtra("android.intent.extra.alarm.SKIP_UI", true)
        i.flags=Intent.FLAG_ACTIVITY_NEW_TASK
        reactApplicationContext.startActivity(i)
    }
}
