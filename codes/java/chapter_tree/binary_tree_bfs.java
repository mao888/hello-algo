/*
 * File: binary_tree_bfs.java
 * Created Time: 2022-11-25
 * Author: Krahets (krahets@163.com)
 */

package chapter_tree;

import include.*;
import java.util.*;

public class binary_tree_bfs {
    /* 层序遍历 */
    static List<Integer> hierOrder(TreeNode root) {
        // 初始化队列，加入根结点
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();  // 队列出队
            list.add(node.val);            // 保存结点
            if (node.left != null)
                queue.offer(node.left);    // 左子结点入队
            if (node.right != null)
                queue.offer(node.right);   // 右子结点入队
        }
        return list;
    }

    public static void main(String[] args) {
        /* 初始化二叉树 */
        // 这里借助了一个从数组直接生成二叉树的函数
        TreeNode root = TreeNode.arrToTree(new Integer[] {
                1, 2, 3, 4, 5, 6, 7, null, null, null, null, null, null, null, null });
        System.out.println("\n初始化二叉树\n");
        PrintUtil.printTree(root);

        /* 层序遍历 */
        List<Integer> list = hierOrder(root);
        System.out.println("\n层序遍历的结点打印序列 = " + list);
    }
}
