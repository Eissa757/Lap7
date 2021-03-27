public DoublyLinkedList<E> clone() throws CloneNotSupportedException {
    // always use inherited Object.clone() to create initial copy
    DoublyLinkedList<E> other = (DoublyLinkedList<E>) super.clone();
    if (size > 0) {
        other.header = new Node<>(null, null, null);
        other.trailer = new Node<>(null, other.header, null);
        other.header.setNext(other.trailer);
        Node<E> walk = header.getNext();
        Node<E> otherWalk = other.header;
        for(int i = 0; i < size; i++) {
            Node<E> newest = new Node<>(walk.getElement(), otherWalk, otherWalk.getNext());
            otherWalk.getNext().setPrev(newest);
            otherWalk.setNext(newest);
            otherWalk = otherWalk.getNext();
            walk = walk.getNext();
}
    }
    return other;

}