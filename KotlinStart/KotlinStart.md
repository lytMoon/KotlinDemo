# Kotlin入门

​    相信大家在经历了一个学习的学习，应该对我们下学期要学习的Kotlin语言有过一定的听闻。大家应该或多或少对Kotlin这么语言有些问题，那么，接下来我们将真正踏入Kotlin安卓开发学习的过程.

##  Kotlin的一些历史

Kotlin是一种静态类型的编程语言，由JetBrains团队于2011年开发。JetBrains公司相信大家应该并不陌生了，我们编程过程总会或多或少用到JetBrains公司的产品。

![image-20240306211226843](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306211226843.png)

Kotlin诞生之后，在2017年的Google I/O大会上，Google宣布在Android上为Kotlin提供最佳支持，这标志着Kotlin成为Android开发的官方语言，我们Google的英文官网上阅读相关文档的时候也都能发现示例代码都是由Kotlin实现。

Kotlin旨在提供比Java更简洁更安全的编程体验，它对Java提供了百分百的支持兼容。

了解过Kotlin的一些发展历史后，接下来我们来正式学习这门语言。

## 使用Kotlin写安卓教程

我们现在AS的 new project界面选择  empty views activity  (不要选择empty activity,现在AS更新，部分老教程可能并不太适用)。

![image-20240306211835817](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306211835817.png)

![image-20240306212238168](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306212238168.png)

![image-20240306212322690](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306212322690.png)



等待项目gradle完成，我们就可以在AS中写Kotlin代码了。

补充：选择kts搭建项目后导入依赖需要注意一下

![image-20240306212454699](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306212454699.png)

这里大家如果想要导入其他依赖的话依照这种写法就行了，与之前的不同，这里需要加入大括号、单引号变成双引号，写法不同。

下面我们来学习一下Kotlin这门语言的一些语法。）

## Kotlin语法

### 变量和函数

#### 变量

为了运行Kotlin代码，我们可以先新建一个Kotlin类，方便我们写Kotlin代码

![image-20240306213452522](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306213452522.png)

![image-20240306213505830](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306213505830.png)

![image-20240306213556644](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306213556644.png)

与Java不同，Kotlin的程序运行入口是main方法，这个main方法是可以不在类里面的，而是在这个Kotlin文件中（Kotlin中的方法可以不依附类存在）。关于main方法大家了解就行，在安卓开发中不会用到。

与Java不同，在Kotlin中，我们使用`var` 和`val`关键字来声明变量，这其实得益于Kotlin独具一格的类型推导机制。

例如在Java中我们可能这样声明变量。

```java
int age = 18;
String name = "周博";
```

但是在Kotlin中，我们可以这么写

```Kotlin
val age : Int = 18
val name : String ="周博"
```

相信大家已经发现了，在Kotlin中，在每行代码结束是没有分号的，这点大家需要注意一下(加了也没事，智能的编译器会提示我们删除。)

上面我们说过，Kotlin具有独具特色的类型推导机制，那么我们：后面的Int和String是不是也可以省略的（作用可以理解为表示数据的类型），当然可以，我们可以尝试一下

![image-20240306215153355](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306215153355.png)

虽然我们没有显式声明变量`age`的类型，Kotlin的类型推断机制会根据赋值`30`自动推断出`age`是`Int`类型的。这是因为`30`是一个整数字面量，而Kotlin会将整数字面量推断为`Int`类型。

那么上面我们提到都可以声明变量的的`val`和`var`有什么区别呢？

- `var`：声明一个可变变量，其值可以被改变。
- `val`：声明一个只读变量，其值一旦初始化后不能被改变。



例如

![image-20240306215218428](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306215218428.png)

因为我们使用的`val`来声明变量，后面变不能修改了，编译器这时候提醒我们换成`var`。或许你会觉得`var`有点万能，那么我以后的开发过程中是不是就可以全部使用var来声明变量，其实不是如此，在安卓开发中我们在声明对象的时候常常使用的`val`。如果不是一些特殊情况，大家在以后开发中尽量默认使用`val`来声明引用型变量。（直接用`val`，反正不通过后面编译器也会提示我们，怕啥![D0FC656EBA47321B8F042558977FA674](C:\Program Files (x86)\Baidu\BaiduPinyin\6.1.3.8\dict\Default\D0FC656EBA47321B8F042558977FA674.png))

相信大家在上面还发现了一些不一样的，比如Java声明使用int而Kotlin使用的是Int。这是因为Kotlin完全摒弃了Java的基本数据类型，大家可以看一下下面的表

| Java类型 | Kotlin类型 |
| :------- | :--------- |
| byte     | Byte       |
| short    | Short      |
| int      | Int        |
| long     | Long       |
| float    | Float      |
| double   | Double     |
| char     | Char       |
| boolean  | Boolean    |

#### 函数

> 函数是执行特定任务的代码块。在Kotlin中，函数使用`fun`关键字声明。函数可以有参数和返回值。

下面我们来看一下Java和Kotlin对函数写法的不同



```Kotlin
fun greet(name: String, greeting: String = "Hello"): String {
    return "$greeting, $name!"
}
```

```Java
public static String greet(String name, String greeting) {
      return greeting + ", " + name + "!";
}
```

与Java不用，Kotlin使用fun 来声明一个函数，语法大致如下：

> fun + 方法名(小驼峰命名) + (arg1:String...) :String (返回值)

接受的参数类型我们使用`:参数类型`表示

当然我们也可以没有参数或者没有返回值。

![image-20240306220900513](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306220900513.png)

下面我们在main函数里面调用一下

![image-20240306221507020](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306221507020.png)



![image-20240306221516220](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306221516220.png)

这里补充一下Java中打印我们使用`System.*out*.println();`对应Kotlin中的`println`

下面来说一个语法糖，

> 当一个函数中只有一行代码的时候Kotlin允许我们不必编写函数体，可以直接将唯一的一行代码写在函数定义的尾部，中间用等号连接

![image-20240306221308716](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306221308716.png)

也就是这个函数的返回值为等号后面的内容，这个了解就行，一般可用可不用。

### 逻辑控制语句

#### 条件控制语句

##### `if` 语句

`if` 是最基本的条件控制语句，它可以单独使用，也可以与 `else` 配合使用来执行条件判断。

举个栗子，我们还是来写个看谁小的方法

```kotlin
fun minChoose(a: Int, b: Int): Int {
    if (a < b) {
        return a
    } else {
        return b
    }

}
```

逻辑比较清楚，这是编译器提示我们有一种更为简便的写法

![image-20240306222247722](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306222247722.png)

我们光标移动到黄色的位置，`alt`+`enter` 看一下编译器给我们改成了什么代码

```kotlin
fun minChoose(a: Int, b: Int): Int {
    return if (a < b) {
        a
    } else {
        b
    }
}

```

显然这里Kotlin允许我们return与if的配合使用，大家目前了解一下就好。

其实结合我们之前提到的语法糖我们也可以不写`return`语句直接用等号和if配合返回结果，这里不再赘述

```kotlin
fun minChoose(a: Int, b: Int): Int = if (a < b) a else b

```



##### `when` 语句

`when` 类似于 Java 中的 `switch` 语句，但更加强大。它可以用作表达式或语句，并支持多种类型的条件匹配。

```kotlin
val x = 1
when (x) {
    1 -> println("x 等于 1")
    2 -> println("x 等于 2")
    else -> println("x 不是 1 也不是 2")
}

```

大家需要掌握这种用法。

如果我们使用when语句后的每种情况需要执行的逻辑不止一行代码，我们也可以加{}

```kotlin
    val x = 1
    when (x) {
        1 -> {
            fun1()
        }
        2 ->{} println("x 等于 2")
        else -> println("x 不是 1 也不是 2")
    }
```

相信大家也发现了，与switch不同when是没有break的,而且，switch的defult 在这里是else

都说when很强大，哪里强大呢？

when()括号中可以加任何类型的参数，并且when还支持类型匹配，这在我们的后面开发中会使用到，举个简单的例子。

`when is` 用法

```Kotlin
fun printTypeInfo(obj: Any) {
    when (obj) {
        is String -> println("这是一个字符串")
        is Int -> println("这是一个整数")
        is Boolean -> println("这是一个布尔值")
        else -> println("未知类型")
    }
}

// 使用函数
printTypeInfo("Hello") // 输出：这是一个字符串
printTypeInfo(123) // 输出：这是一个整数
printTypeInfo(true) // 输出：这是一个布尔值

```



还有一个例子，这个例子大家能理解就行，理解不了就忽视，在后面的开发中可能会用到。

加入我有两个这时我有个需求我需要根据不同的类调用不同的方法，进行不同逻辑判断，这个怎么实现呢？

这里的holder是`ViewHolder`类型的但是`ViewHolder`有很多子类，而且这个`onBindViewHolder()`疯狂回调往里面传递各种类型的`ViewHolder`,这里就要用到`when is` 语句，根据不同的对象类型执行不同的逻辑，怎么样，是不是很酷。

```
   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is RvNewsTopViewHolder -> {}

            is RvNewsViewHolder -> {
                val itemData = getItem(position)
                holder.bind(itemData)
            }
        }
    }
```

### 循环控制语句

#### `for` 循环

`for` 循环可以遍历任何提供迭代器（iterator）的对象，如集合或区间。

```kotlin
for (i in 1..5) {
    println(i)
}

```

#### `while` 和 `do-while` 循环

`while` 循环在给定条件为真时重复执行代码块。`do-while` 循环至少执行一次代码块，然后再检查条件。

```java
var i = 1
while (i <= 5) {
    println(i)
    i++
}

do {
    println(i)
    i++
} while (i <= 5)

```

这些跟Java基本相同。

需要注意的是在for循环的遍历方式。大家只需要记住Kotlin中遍历用的是`for in`语句

![image-20240306224507194](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240306224507194.png)

这里就是在【1-5】之间，下面列举一些遍历会用到的数据遍历区间范围

| 表达方式 | 描述                                     | 示例                     |
| :------- | :--------------------------------------- | :----------------------- |
| `..`     | 闭区间运算符，包含起始值和结束值         | `for (i in 1..5)`        |
| `until`  | 半开区间运算符，包含起始值但不包含结束值 | `for (i in 1 until 5)`   |
| `downTo` | 降序区间运算符，包含起始值和结束值       | `for (i in 5 downTo 1)`  |
| `step`   | 步进值运算符，定义区间内的步进值         | `for (i in 1..5 step 2)` |

了解一下就行。

## 面向对象

这么快就到了面向对象这里，不知道大家学习到了现在，大家对面向对象的理解如何了？应该不会像之前那么抽象了吧，虽然面向对象思想一直是个抽象的概念，这里我们再来看一下Kotlin的面向对象。