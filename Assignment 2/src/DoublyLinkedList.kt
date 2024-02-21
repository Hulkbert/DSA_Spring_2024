class DoublyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    /**
     * Node class for a double linked list.
     */

    private class Node<T>(var data:T, var next: Node<T>? = null, var prev: Node<T>? = null)

    /**
     * Adds the element [data] to the front of the linked list.
     * @param data The information that is being added to the front of the list.
     */
    fun pushFront(data: T){
        val newNode = Node(data, next = head)
        if (head != null) {
            head?.prev = newNode//links the head to the new node

        } else {
            tail = newNode //if list is empty, node is also tail
        }
        head = newNode // sets node as head
    }
    /**
     * Adds the element [data] to the back of the linked list.
     * @param data The information that is being added to the back of the list.
     *
     */
    fun pushBack(data: T){
        val newNode = Node(data, next = null)
        if (head != null) {
            // links tail to new node
            newNode.prev = tail
            tail?.next = newNode
            tail = newNode
        } else {
            // setting the head and tail new nodes if list is empty
            tail = newNode
            head = newNode
        }

    }
    /**
     * Removes an element from the front of the list. If the list is empty, it is unchanged.
     * @return the value at the front of the list or nil if none exists
     */
    fun popFront(): T?{

        if (head==null){
            return null // list is empty, return null
        }
        val yeetValue = head?.data //value to be deleted

        if (head == tail) {
            // One element in list
            head = null
            tail = null
        }
        else{
            // >1 element in list
            head = head!!.next
            head?.prev = null
        }
        return yeetValue



    }
    /**
     * Removes an element from the back of the list. If the list is empty, it is unchanged.
     * @return the value at the back of the list or nil if none exists
     */
    fun popBack(): T?{
        if (tail==null){
            return null // list is empty, return null
        }
        val yeetValue = tail!!.data //value to be deleted

        if (head == tail) {
            // One element in list
            head = null
            tail = null
        }
        else{
            // >1 element in list

            tail = tail!!.prev
            tail!!.next = null
        }
        return yeetValue

    }
    /**
     * @return the value at the front of the list (head node) or nil if none exists
     */
    fun peekFront(): T?{
        if(head == null){
            return null
        }else {
            return head!!.data
        }
    }

    /**
     * @return the value at the back of the list (tail node) or nil if none exists
     */
    fun peekBack(): T?{
        if(tail == null){
            return null
        }else {
            return tail!!.data
        }
    }
    /**
     * @return true if the list is empty and false otherwise
     */
    fun isEmpty(): Boolean = head == null // list is empty
    override fun toString(): String{
        var active = head
        var output = StringBuilder()
        while(active != null){
            output.append(active.data)
            active = active.next
        }
        return(output.toString())
    }
}