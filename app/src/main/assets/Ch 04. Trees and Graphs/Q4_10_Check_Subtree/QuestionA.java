{"Id":"38de0c1f-779e-4127-b7e5-0ebc17506fc0","Topic":"QuestionA.java","Question":"","Solution":"package Q4_10_Check_Subtree;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\nimport CtCILibrary.TreeNode;\r\n\r\npublic class QuestionA {\r\n\t\r\n\tpublic static boolean containsTree(TreeNode t1, TreeNode t2) {\r\n\t\tStringBuilder string1 = new StringBuilder();\r\n\t\tStringBuilder string2 = new StringBuilder();\r\n\t\t\r\n\t\tgetOrderString(t1, string1);\r\n\t\tgetOrderString(t2, string2);\r\n\t\t\r\n\t\treturn string1.indexOf(string2.toString()) != -1;\r\n\t}\r\n\t\r\n\tpublic static void getOrderString(TreeNode node, StringBuilder sb) {\r\n\t\tif (node == null) {\r\n\t\t\tsb.append(\"X\");             // Add null indicator\r\n\t\t\treturn;\r\n\t\t}\r\n\t\tsb.append(node.data);           // Add root \r\n\t\tgetOrderString(node.left, sb);  // Add left\r\n\t\tgetOrderString(node.right, sb); // Add right\r\n\t}\r\n\r\n\tpublic static void main(String[] args) {\r\n\t\t// t2 is a subtree of t1\r\n\t\tint[] array1 = {1, 2, 1, 3, 1, 1, 5};\r\n\t\tint[] array2 = {2, 3, 1};\r\n\t\t\r\n\t\tTreeNode t1 = AssortedMethods.createTreeFromArray(array1);\r\n\t\tTreeNode t2 = AssortedMethods.createTreeFromArray(array2);\r\n\r\n\t\tif (containsTree(t1, t2)) {\r\n\t\t\tSystem.out.println(\"t2 is a subtree of t1\");\r\n\t\t} else {\r\n\t\t\tSystem.out.println(\"t2 is not a subtree of t1\");\r\n\t\t}\r\n\r\n\t\t// t4 is not a subtree of t3\r\n\t\tint[] array3 = {1, 2, 3};\r\n\t\tTreeNode t3 = AssortedMethods.createTreeFromArray(array1);\r\n\t\tTreeNode t4 = AssortedMethods.createTreeFromArray(array3);\r\n\r\n\t\tif (containsTree(t3, t4)) {\r\n\t\t\tSystem.out.println(\"t4 is a subtree of t3\");\r\n\t\t} else {\r\n\t\t\tSystem.out.println(\"t4 is not a subtree of t3\");\r\n\t\t}\r\n\t}\r\n\r\n}\r\n","Chapter":"Q4_10_Check_Subtree"}