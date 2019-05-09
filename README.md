# springboot-bdz
WebSocket 测试
[TOC]

#
## WebSocket 搭建

### 添加maven依赖

```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-websocket</artifactId>
    </dependency>
```
### 服务端
> #### config 包下做一个配置

```java
@Component
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

```

> #### Service包下直接创建类 

```java
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("【websocket消息】有新的连接, 总数:{}", webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("【websocket消息】连接断开, 总数:{}", webSocketSet.size());
    }

    // 接收到客户端发送的消息
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    // 向客户端发送消息
    public void sendMessage(String message) {
        for (WebSocket webSocket: webSocketSet) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
```

### 客户端 script

```javascript
<script>
    var websocket = null;
    if('WebSocket' in window) {
        websocket = new WebSocket('ws://127.0.0.1:8080/sell/webSocket');
    }else {
        alert('该浏览器不支持websocket!');
    }

    websocket.onopen = function (event) {
        console.log('建立连接');
    }

    websocket.onclose = function (event) {
        console.log('连接关闭');
    }
    // 拿到消息的事件
    websocket.onmessage = function (event) {
        console.log('收到消息:' + event.data)
        //弹窗提醒, 播放音乐
        $('#myModal').modal('show');
    }

    websocket.onerror = function () {
        alert('websocket通信发生错误！');
    }
    
    // 窗口关闭时关闭 websocket
    window.onbeforeunload = function () {
        websocket.close();
    }

</script>
```

## WebSocket 调用

### Controller

```java
    @Autowired
    private WebSocket webSocket;
```

```java
    //发送websocket消息
    webSocket.sendMessage(orderDTO.getOrderId());
```
> * demo
```java
    @Controller
    @RequestMapping("/getwebsocket")
    public class WsSendController {
        @Autowired
        private WebSocket webSocket;
    
        @PostMapping("/send")
        public void demo(@RequestParam("typeId") Integer typeId){
            if (typeId==0){
                webSocket.sendMessage("关机中...");
            }else if (typeId==1){
                webSocket.sendMessage("开机中...");
            }
        }
    }
```
