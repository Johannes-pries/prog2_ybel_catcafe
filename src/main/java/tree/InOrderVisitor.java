package tree;

import static java.util.Objects.requireNonNull;

public class InOrderVisitor<T extends Comparable<T>> implements TreeVisitor<T> {
    @Override
    public String visit(Empty<T> e) {
        return "";
    }

    @Override
    public String visit(Node<T> n) {
        requireNonNull(n);
        String left = n.leftChild().accept(this);
        String right = n.rightChild().accept(this);
        String data = n.data().toString();
        return left + data + right;
    }
}