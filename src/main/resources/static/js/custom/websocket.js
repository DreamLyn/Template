/// 
var websocket;
$(function () {
    //读取上次保存的地址信息
    var wsAddress = localStorage.getItem("websocket-address") || "ws://";
    $("#websocket-address").val(wsAddress);

    $("#websocket-address").blur(function (e) {
        e.preventDefault();
        localStorage.setItem("websocket-address", $(this).val());

    });


    //进行事件处理
    //连接 
    $("#websocket-connect").click(function (e) {
        e.preventDefault();
        var wsaddr = $("#websocket-address").val();
        if (wsaddr == '') {
            alert("请填写websocket的地址");
            return false;
        }
        StartWebSocket(wsaddr);
    });
    $("#websocket-disconnect").click(function (e) {
        e.preventDefault();
        websocket.close();
    });

    //清空
    $("#websocket-clear").click(function (e) {
        e.preventDefault();
        $("#websocket-output").html("");
    });

    //发送
    $("#websocket-send").click(function (e) {
        e.preventDefault();
        var message = $("#websocket-message").val();
        if (message == '') {
            alert("请先填写发送信息");
            $("#websocket-message").focus();
            return false;
        }
        if (typeof websocket === "undefined") {
            alert("websocket还没有连接，或者连接失败，请检测");
            return false;
        }
        if (websocket.readyState == 3) {
            alert("websocket已经关闭，请重新连接");
            return false;
        }

        writeToScreen('<span style="color:green">发送信息&nbsp;' + '</span><br/>' + message);
        websocket.send(message);
    });
});

function StartWebSocket(wsUri) {
    websocket = new WebSocket(wsUri);
    websocket.onopen = function (evt) {
        onOpen(evt)
    };
    websocket.onclose = function (evt) {
        onClose(evt)
    };
    websocket.onmessage = function (evt) {
        onMessage(evt)
    };
    websocket.onerror = function (evt) {
        onError(evt)
    };
}

function onOpen(evt) {
    writeToScreen("<span style='color:red'>连接成功，可以发送信息了！</span>");
}

function onClose(evt) {
    writeToScreen("<span style='color:red'>websocket连接已断开!</span>");
    websocket.close();
}

function onMessage(evt) {
    writeToScreen('<span style="color:blue">服务端回应&nbsp;' + '</span><br/><span class="bubble">' + evt.data + '</span>');
}

function onError(evt) {
    writeToScreen('<span style="color: red;">发生错误:</span> ' + evt.data);
}


function writeToScreen(message) {
    var div = "<div class='newmessage'>" + formatDateTime(new Date(), "yyyy-MM-dd HH:mm:ss") + " -- " + message + "</div>";
    // var d = $("#websocket-output");
    // var d = d[0];
    // var doScroll = d.scrollTop == d.scrollHeight - d.clientHeight;
    $("#websocket-output").prepend(div);
    // if (doScroll) {
    //     d.scrollTop = d.scrollHeight - d.clientHeight;
    // }
}


function en(event) {
    var evt = evt ? evt : (window.event ? window.event : null);
    if (evt.keyCode == 13) {
        doSend()
    }
}

function formatDateTime(time, format) {
    var t = new Date(time);
    var tf = function (i) {
        return (i < 10 ? '0' : '') + i
    };
    return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function (a) {
        switch (a) {
            case 'yyyy':
                return tf(t.getFullYear());
                break;
            case 'MM':
                return tf(t.getMonth() + 1);
                break;
            case 'mm':
                return tf(t.getMinutes());
                break;
            case 'dd':
                return tf(t.getDate());
                break;
            case 'HH':
                return tf(t.getHours());
                break;
            case 'ss':
                return tf(t.getSeconds());
                break;
        }
    })
};