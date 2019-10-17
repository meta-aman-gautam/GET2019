function Node(data) {
    this.data = data;
    this.next = null;
    this.pre = null;
}

function DoublyLinkedList() {
    this.head = null;
}

DoublyLinkedList.prototype.add = function (data) {

    var newNode = new Node(data);
    var previousNode = null;
    if (this.head == null) {
        this.head = newNode;
    }
    else {
        var current = this.head;
        while (current.next != null) {
            previousNode = current;
            current = current.next;
        }
        current.next = newNode;
        current.pre = previousNode;
    }
}

DoublyLinkedList.prototype.delete = function () {
    var current = this.head;
    var previousNode = null;
    while (current.next != null) {
        previousNode = current;
        current = current.next;
    }

    if (current == this.head) {
        this.head = null;
    } else {
        current.pre = null;
        previousNode.next = null;
    }
}

DoublyLinkedList.prototype.printList = function () {
    var current = this.head;
    var string = "";
    while (current != null) {
        string += current.data + " ";
        current = current.next;
    }
    console.log(string);
}