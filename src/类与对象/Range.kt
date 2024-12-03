package 类与对象

//左侧和右侧
//类的封装包括：将成员变量有private修饰，然后提供次构造函数，暴露一些public方法,其实就是javaBean的定义
class Range(var l: Int, var r: Int) {
    //运算符号重载
    operator fun compareTo(other: Range): Int {
        // 利用l去对比
        return l.compareTo(other.l)
    }
    //fun getL():Int = l

    //区间合并重载
    operator fun plus(other: Range): Range {
        if (this.r < other.l) {
            return this
        } else if (this.r >= other.l && this.r <= other.r) {
            return Range(l, other.r)
        } else {
            return Range(l, r)
        }
    }

    //重载not运算符号
    operator fun not(): Range {
        val l = this.l
        val r = this.r
        return Range(r, l)
    }

    //包含运算
    operator fun contains(other: Range): Boolean {
        return this.r >= other.r
    }

    override fun toString(): String {
        return "l: $l; r: $r"
    }

}