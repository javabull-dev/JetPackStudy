package cn.ljpc.viewmodel

import androidx.databinding.ObservableField
import cn.ljpc.model.Animal

class AnimalViewModel(private val animal: Animal) {

    val info = ObservableField("${animal.name} 叫了 ${animal.shoutCount}声..")

    fun shout() {
        animal.shoutCount++
        info.set("${animal.name} 叫了 ${animal.shoutCount}声..")
    }
}