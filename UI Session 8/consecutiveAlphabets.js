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


function removeConsecutive(inputString) {
    stack1 = new Stack();
    stack2 = new Stack();
    for (var index = 0; index < inputString.length; index++) {
        stack1.push(inputString[index]);
    }
    while (!stack1.empty()) {
        if (!stack2.empty() && stack1.top.data == stack2.top.data) {
            stack1.pop();
            stack2.pop();
        } else {
            stack2.push(stack1.pop());
        }
    }
    var outputString = "";
    while (!stack2.empty()) {
        outputString += stack2.pop();
    }
    if (outputString.length == 0) {
        return "empty string";
    }
    else {
        console.log(outputString);
        return outputString;
    }
}