document.getElementById('connectButton').addEventListener('click', function() {
    const socket = new SockJS('/ws');
    const stompClient = Stomp.over(socket);

    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);

        stompClient.subscribe('/topic/seats', function(message) {
            console.log('Message from server: ' + message.body);
        });
    }, function(error) {
        console.error('STOMP error: ' + error);
    });
});