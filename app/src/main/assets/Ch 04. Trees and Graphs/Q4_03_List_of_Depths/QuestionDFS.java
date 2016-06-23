{"Id":"36fe9899-c20e-408a-811c-01ecc2267295","Topic":"QuestionDFS.java","Question":"","Solution":"package Q4_03_List_of_Depths;\r\n\r\nimport CtCILibrary.*;\r\n\r\nimport java.util.ArrayList;\r\nimport java.util.Iterator;\r\nimport java.util.LinkedList;\r\n\r\npublic class QuestionDFS {\r\n\r\n\tpublic static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {\r\n\t\tif (root == null) return;\r\n\t\tLinkedList<TreeNode> list = null;\r\n\t\tif (lists.size() == level) { // Level not contained in list\r\n\t\t\tlist = new LinkedList<TreeNode>();\r\n\t\t\t/* Levels are always traversed in order. So, if this is the first time we've visited level i,\r\n\t\t\t * we must have seen levels 0 through i - 1. We can therefore safely add the level at the end. */\r\n\t\t\tlists.add(list);  \r\n\t\t} else {\r\n\t\t\tlist = lists.get(level);\r\n\t\t}\r\n\t\tlist.add(root);\r\n\t\tcreateLevelLinkedList(root.left, lists, level + 1);\r\n\t\tcreateLevelLinkedList(root.right, lists, level + 1);\r\n\t}\r\n\t\r\n\tpublic static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {\r\n\t\tArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();\r\n\t\tcreateLevelLinkedList(root, lists, 0);\r\n\t\treturn lists;\r\n\t}\t\r\n\t\r\n\tpublic static void printResult(ArrayList<LinkedList<TreeNode>> result){\r\n\t\tint depth = 0;\r\n\t\tfor(LinkedList<TreeNode> entry : result) {\r\n\t\t\tIterator<TreeNode> i = entry.listIterator();\r\n\t\t\tSystem.out.print(\"Link list at depth \" + depth + \":\");\r\n\t\t\twhile(i.hasNext()){\r\n\t\t\t\tSystem.out.print(\" \" + ((TreeNode)i.next()).data);\r\n\t\t\t}\r\n\t\t\tSystem.out.println();\r\n\t\t\tdepth++;\r\n\t\t}\r\n\t}\r\n\t\r\n\r\n\tpublic static void main(String[] args) {\r\n\t\tint[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};\r\n\t\tTreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);\r\n\t\tArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);\r\n\t\tprintResult(list);\r\n\t}\r\n\r\n}\r\n","Chapter":"Q4_03_List_of_Depths"}