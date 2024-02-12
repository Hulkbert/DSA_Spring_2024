//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val firstStack = MyStack<String?>()
    val storeStack = MyStack<String?>()
    firstStack.push("1")
    firstStack.push("2")
    firstStack.push("3")
    firstStack.push("4")
    while(!firstStack.isEmpty()) {
        storeStack.push(firstStack.pop())
    }
    while(!storeStack.isEmpty()){
        firstStack.push(storeStack.pop())
    }
}