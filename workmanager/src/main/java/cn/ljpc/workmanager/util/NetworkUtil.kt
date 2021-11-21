package cn.ljpc.workmanager.util

import android.util.Log
import cn.ljpc.workmanager.model.User
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson

//定义静态方法
class NetworkUtil {

    //伴生对象
    companion object {
        //get请求
        fun get(url: String) {
            Fuel.get(url).responseString { request, response, result ->
                result.fold({ d ->  //请求成功了，干啥
                    Log.d("lan", "消息：${d}")
                }, { err ->  //请求失败了，干啥
                    Log.d("lan", "错误：${err.message}")
                })
            }
        }

        //post请求
        fun post() {
            val url3 = "http://192.168.0.101:8889/name"

            val requestBean = User("王五", 22)
            val requestData = Gson().toJson(requestBean)
            val type = mutableMapOf<String, String>()
            type["Content-Type"] = "application/json"

            Fuel.post(url3)
                .body(requestData)
                .header(type)
                .responseString { _, _, result ->
                    result.fold({
                        Log.e("lan", it)
                    }, {
                        //当message不为空时，才执行let
                        it.message?.let { it1 -> Log.e("lan", it1) }
                    })
                }
        }
    }
}

//object NetworkUtilw {
//    fun get(url: String) {
//        Fuel.get(url).responseString { request, response, result ->
//            result.fold({ d ->  //请求成功了，干啥
//                Log.d("lan", "消息：${d}")
//            }, { err ->  //请求失败了，干啥
//                Log.d("lan", "错误：${err.message}")
//            })
//        }
//    }
//}