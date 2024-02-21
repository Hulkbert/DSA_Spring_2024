//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * flips a stack onto another stack
 */
fun <T>flipStack(stack1: Stack<T?>,stack2: Stack<T?>) {
    while(!stack1.isEmpty()) {
        stack2.push(stack1.pop())
    }

}
fun main() {
    val firstStack = MyStack<String?>()
    val storeStack = MyStack<String?>()
    val moreStack = MyStack<String?>()
    firstStack.push("1")
    firstStack.push("2")
    firstStack.push("3")
    firstStack.push("4")
    println(firstStack.toString())
    flipStack(firstStack,storeStack)
    flipStack(storeStack,moreStack)
    flipStack(moreStack,firstStack)
    println(firstStack.toString())


}