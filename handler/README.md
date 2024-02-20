# Handler
关于handler的进一步学习

创建Looper
使用Looper创建Handler
启动Looper
使用Handler发送信息

![image-20240218182640269](C:\Users\29364\AppData\Roaming\Typora\typora-user-images\image-20240218182640269.png)

用户使用线程的Looper构建Handler之后，通过Handler的send和post方法发送消息
消息会加入到MessageQueue中，等待Looper获取处理
Looper会不断地从MessageQueue中获取Message然后交付给对应的Handler处理


