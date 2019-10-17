
function Node(data) {
    this.data = data;
    this.next = null;
}

function Stack() {
    this.top = null;
}

Stack.prototype.push = function (data) {

    var newNode = new Node(data);

    newNode.next = this.top;
    this.top = newNode;
}

Stack.prototype.pop = function () {
    if (this.top == null) {
        console.log("Stack is empty");
    }
    else {
        var removeNode = this.top;
        this.top = this.top.next;
        console.log(removeNode.data);
        return removeNode.data;
    }
}


Stack.prototype.printStack = function () {
    var current = this.top;
    var string = "";
    while (current != null) {
        string += current.data + " ";
        current = current.next;
    }
    console.log(string);
}

Stack.prototype.empty = function () {
    if (this.top == null)
        return true;
    else
        return false;
}
