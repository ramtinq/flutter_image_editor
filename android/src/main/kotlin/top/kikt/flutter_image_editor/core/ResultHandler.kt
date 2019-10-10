package top.kikt.flutter_image_editor.core

import android.os.Handler
import android.os.Looper
import io.flutter.plugin.common.MethodChannel

/// create 2019-10-10 by cai
class ResultHandler(private var result: MethodChannel.Result?) {
  
  companion object {
    private val handler = Handler(Looper.getMainLooper())
  }
  
  fun reply(any: Any?) {
    val result = this.result
    this.result = null
    handler.post {
      result?.success(any)
    }
  }
  
  fun replyError(code: String, message: String? = null, obj: Any? = null) {
    val result = this.result
    this.result = null
    handler.post {
      result?.error(code, message, obj)
    }
  }
  
  fun notImplemented() {
    handler.post {
      result?.notImplemented()
    }
  }
}