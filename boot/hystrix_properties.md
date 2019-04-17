/**
 * Command execution properties.
 */
### 隔离策略，默认是线程隔离，还有信号量隔离，参见枚举：ExecutionIsolationStrategy
# hystrix.command.default.execution.isolation.strategy=THREAD
### 隔离线程超时时间，默认1s
#hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=1000
### 是否启用超时配置
#hystrix.command.default.execution.timeout.enabled=true
### 超时的时候是否中断隔离线程
#hystrix.command.default.execution.isolation.thread.interruptOnTimeout=true
### 隔离线程正在执行取消操作时是否中断
#hystrix.command.default.execution.isolation.thread.interruptOnFutureCancel=false
### 隔离策略的最大信号量，只有使用信号量隔离策略时生效
#hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests=10

/**
 * Command fallback properties.HystrixCommand.getFallback()
 */
### 降级方法的最大调用线程数，如果超出此信号量，会抛出异常
#hystrix.command.default.fallback.isolation.semaphore.maxConcurrentRequests=10
### 是否启用降级
#hystrix.command.default.fallback.enabled=true

/**
 * Command circuit breaker properties.
 */
### 是否启用断路器
#hystrix.command.default.circuitBreaker.enabled=true
### 请求量阈值，请求量达到该值是会开启断路器
#hystrix.command.default.circuitBreaker.requestVolumeThreshold=20
### 当断路器打开后，会直接拒绝请求，此时间是配置多长时候后再次尝试处理请求
#hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds=5000
### 打开断路器并走回退逻辑的错误率，默认50%
#hystrix.command.default.circuitBreaker.errorThresholdPercentage=50
### 是否强制打开断路器，打开后会直接拒绝所有请求
#hystrix.command.default.circuitBreaker.forceOpen=false
### 是否强制关闭断路器，关闭后会处理所有请求
#hystrix.command.default.circuitBreaker.forceClosed=false

/**
 * Command metrics properties.主要用于统计执行情况
 */
### 统计的时间窗口值
#hystrix.command.default.metrics.rollingStats.timeInMilliseconds=10000
### 统计时间窗口内分成的份数，需要保证timeInMilliseconds % numBuckets == 0
#hystrix.command.default.metrics.rollingStats.numBuckets=10
### 是否启用百分数统计
#hystrix.command.default.metrics.rollingPercentile.enabled=true
### 百分数统计的时间周期
#hystrix.command.default.metrics.rollingPercentile.timeInMilliseconds=60000
### 百分数统计时间内分成的份数
#hystrix.command.default.metrics.rollingPercentile.numBuckets=6
### 百分数统计每份的最大数量。每个bucket只取这个配置数量的执行数来统计
#hystrix.command.default.metrics.rollingPercentile.bucketSize=100
### 记录健康快照间隔毫秒数
#hystrix.command.default.metrics.healthSnapshot.intervalInMilliseconds=500

/**
 * Command CommandRequest Context properties.
 */
### 是否启用请求缓存。当HystrixCommand.getCacheKey()调用后，缓存到HystrixRequestCache
#hystrix.command.default.requestCache.enabled=true
### 是否启用请求日志记录。HystrixCommand执行或者事件的日志到HystrixRequestLog
#hystrix.command.default.requestLog.enabled=true
#HystrixThreadPoolProperties
/**
 * Thread pool properties.
 */
### 是否启用maximumSize配置
#hystrix.threadpool.default.allowMaximumSizeToDivergeFromCoreSize=false
### 线程数量
#hystrix.threadpool.default.coreSize=10
### 最大执行线程数
#hystrix.threadpool.default.maximumSize=10
### 线程存活毫秒数
#hystrix.threadpool.default.keepAliveTimeMinutes=1
### 最大等待线程队列，如果-1为SynchronousQueue；其他则为LinkedBlockingQueue
#hystrix.threadpool.default.maxQueueSize=-1
### 拒绝队列大小，即使maxQueueSize没有达到，达到queueSizeRejectionThreshold该值后，请求也会被拒绝。当maxQueueSize为-1，则该属性不可用
#hystrix.threadpool.default.queueSizeRejectionThreshold=5
### 线程池统计时间窗口值
#hystrix.threadpool.default.metrics.rollingStats.timeInMilliseconds=10000
### 线程池统计时间窗口内分成的份数
#hystrix.threadpool.default.metrics.rollingStats.numBuckets=10