package cn.ljpc.model.model

data class Item(var counter: Int) {

    //运算符重载
    operator fun plus(new: Int): Item {
        counter += new
        return this
    }
}

