
# JVM gc 情况体现demo

启动参数：
```bash
java -Xms128m -Xmx128m -XX:+PrintGC -XX:+PrintGCDetails  -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xloggc:./gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=10M -jar xxx.jar
```

格式化下

```bash
# 启用垃圾回收日志的基本输出，记录 GC 事件。
-Xms128m -Xmx128m \
# 启用垃圾回收日志的基本输出、启用更详细的垃圾回收日志输出，包括每次 GC 的内存变化、使用的内存区域等信息。
-XX:+PrintGC -XX:+PrintGCDetails \
#  在 GC 日志中添加时间戳，记录每次 GC 发生的具体时间
-XX:+PrintGCDateStamps \
# 在 GC 日志中记录从 JVM 启动到 GC 发生的时间（以秒为单位）
-XX:+PrintGCTimeStamps \
# 指定 GC 日志的输出文件路径。这里设置为当前目录下的 gc.log 文件
-Xloggc:./gc.log \
# 启用垃圾回收日志文件轮换。这意味着当日志文件达到一定大小后，会自动创建一个新的日志文件
-XX:+UseGCLogFileRotation \
# 设置日志文件轮换的数量。在这个例子中，最多保留 5 个 GC 日志文件。
 -XX:NumberOfGCLogFiles=5 \
 # 设置单个 GC 日志文件的最大大小为 10 MB。当日志文件大小达到这个限制时，会创建一个新的日志文件
 -XX:GCLogFileSize=10M
```

