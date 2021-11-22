package cn.ljpc.hiltdemo.entity

import javax.inject.Inject

class User @Inject constructor() {
    var _name: String = ""
    var _age: Int = 0
}