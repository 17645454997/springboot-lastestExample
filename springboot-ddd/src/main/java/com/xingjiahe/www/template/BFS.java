package com.xingjiahe.www.template;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/1/12 上午11:42
 */
public class BFS {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
   public List<List<Integer>> BFS (TreeNode root){
       List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return  res;
        }
       Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return  res;
   }

}
