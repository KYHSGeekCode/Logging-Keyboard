package com.myhome.rpgkeyboard

import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.InputConnection
import org.greenrobot.eventbus.EventBus

class ChattyInputConnection(val inputConnection: InputConnection) :
    InputConnection by inputConnection {
    override fun sendKeyEvent(p0: KeyEvent?): Boolean {
        Log.d("LoggingKeyboard", "sendKeyEvent + ${p0?.keyCode}")
        EventBus.getDefault().post(p0)
        return inputConnection.sendKeyEvent(p0)
    }

    override fun commitText(p0: CharSequence?, p1: Int): Boolean {
        Log.d("LoggingKeyboard", "commitText + $p0? $p1")
        EventBus.getDefault().post(LoggingKeyEvent(p0, p1))
        return inputConnection.commitText(p0, p1)
    }
}