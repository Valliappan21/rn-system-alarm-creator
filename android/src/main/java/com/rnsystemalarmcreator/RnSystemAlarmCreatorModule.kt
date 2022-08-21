package com.rnsystemalarmcreator

import android.content.Intent
import android.provider.AlarmClock
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class RnSystemAlarmCreatorModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "RnSystemAlarmCreator"
    }

    @ReactMethod
    fun setAlarm(hours: Int, mins: Int, name: String) {
        val i = Intent(AlarmClock.ACTION_SET_ALARM)
        i.putExtra("android.intent.extra.alarm.HOUR", hours)
        i.putExtra("android.intent.extra.alarm.MINUTES", mins)
        i.putExtra("android.intent.extra.alarm.MESSAGE", name)
        i.putExtra("android.intent.extra.alarm.SKIP_UI", true)
        reactApplicationContext.startActivity(i)

    }
}
