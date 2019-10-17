
function Node(data) {
    this.data = data;
    this.next = null;
}

function SinglyLinkedList() {
    this.head = null;
}

//singly linked list

SinglyLinkedList.prototype.insertNode = function (data) {
    var newNode = new node(data);

    if (this.head == null) {
        this.head = newNode;
    }
    else {
        var currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }
}

SinglyLinkedList.prototype.deleteFromLast = function () {
    var pre = null
    var currentNode = this.head;
    while (currentNode.next != null) {
        pre = currentNode;
        currentNode = currentNode.next;
    }
    if (currentNode == this.head) {
        this.head = null;
    }
    else {
        pre.next = null;
    }
}

SinglyLinkedList.prototype.printLinkedList = function () {
    var currentNode = this.head;
    while (currentNode) {
        console.log(currentNode.data);
        currentNode = currentNode.next;
    }
}

