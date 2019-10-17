
function Node(data) {
    this.data = data;
    this.next = null;
}

function Queue() {
    this.front = null;
    this.rear = null;
}

Queue.prototype.enqueue = function (data) {

    var newNode = new Node(data);

    if (this.front == null) {
        this.front = newNode;
        this.rear = newNode;
    }
    else {
        this.rear.next = newNode;
        this.rear = newNode;
    }

}

Queue.prototype.dequeue = function () {
    if (this.front == null) {
        console.log("queue empty!");
    }
    else {
        var prevFront = this.front;
        this.front = this.front.next;
        console.log(prevFront.data);
        return prevFront.data;
    }
}

Queue.prototype.empty = function () {

    if (this.front == null && this.rear == null)
        return true;
    else
        return false;
}



Queue.prototype.printQueue = function () {
    var current = this.front;
    var string = "";
    while (current != null) {
        string += current.data + " ";
        current = current.next;
    }
    console.log(string);
}
