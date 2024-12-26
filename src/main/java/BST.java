/**
 *
 * @author
 * 200316008 Yusuf Hastoprak
 * 200316003 Irem Boyalioglu
 * 200316030 Huseyin Ozdamar
 *
 */
class BSTNode {
    String name;
    Object data;
    BSTNode left, right;

    BSTNode(String name, Object data) {
        this.name = name;
        this.data = data;
    }
}

/* Binary Search Tree (BST) Class */
class BST {
    BSTNode root;

    void insert(String name, Object data) {
        root = insertRec(root, name, data);
    }

    BSTNode insertRec(BSTNode root, String name, Object data) {
        if (root == null) {
            return new BSTNode(name, data);
        }
        if (name.compareTo(root.name) < 0) {
            root.left = insertRec(root.left, name, data);
        } else if (name.compareTo(root.name) > 0) {
            root.right = insertRec(root.right, name, data);
        }
        return root;
    }

    Object search(String name) {
        return searchRec(root, name);
    }

    Object searchRec(BSTNode root, String name) {
        if (root == null || root.name.equals(name)) {
            return root != null ? root.data : null;
        }
        if (name.compareTo(root.name) < 0) {
            return searchRec(root.left, name);
        }
        return searchRec(root.right, name);
    }
}
