{"Id":"eb3e23da-33dd-40ea-b97d-7155963df85c","Topic":"QuestionB.java","Question":"","Solution":"package Q4_05_Validate_BST;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\nimport CtCILibrary.TreeNode;\r\n\r\npublic class QuestionB {\r\n\tpublic static boolean checkBST(TreeNode n, Integer min, Integer max) {\r\n\t\tif (n == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\t\tif ((min != null && n.data <= min) || (max != null && n.data > max)) {\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tif (!checkBST(n.left, min, n.data) ||\r\n\t\t\t!checkBST(n.right, n.data, max)) {\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\treturn true;\r\n\t}\r\n\t\t\r\n\tpublic static boolean checkBST(TreeNode n) {\r\n\t\treturn checkBST(n, null, null);\r\n\t}\r\n\t\r\n\tpublic static boolean checkBSTAlternate(TreeNode n) {\r\n\t\treturn checkBSTAlternate(n, new IntWrapper(0), new IntWrapper(0));\r\n\t}\t\t\r\n\r\n\tpublic static boolean checkBSTAlternate(TreeNode n, IntWrapper min, IntWrapper max) {\r\n\t\t/* An alternate, less clean approach. This is not provided in the book, but is used to test the other method. */\r\n\t\tif (n.left == null) {\r\n\t\t\tmin.data = n.data;\r\n\t\t} else {\r\n\t\t\tIntWrapper leftMin = new IntWrapper(0);\r\n\t\t\tIntWrapper leftMax = new IntWrapper(0);\r\n\t\t\tif (!checkBSTAlternate(n.left, leftMin, leftMax)) {\r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t\tif (leftMax.data > n.data) {\r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t\tmin.data = leftMin.data;\r\n\t\t}\r\n\t\tif (n.right == null) {\r\n\t\t\tmax.data = n.data;\r\n\t\t} else {\r\n\t\t\tIntWrapper rightMin = new IntWrapper(0);\r\n\t\t\tIntWrapper rightMax = new IntWrapper(0);\r\n\t\t\tif (!checkBSTAlternate(n.right, rightMin, rightMax)) {\r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t\tif (rightMin.data <= n.data) {\r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t\tmax.data = rightMax.data;\r\n\t\t}\r\n\t\treturn true;\r\n\t}\r\n\r\n\t/* Create a tree that may or may not be a BST */\r\n\tpublic static TreeNode createTestTree() {\r\n\t\t/* Create a random BST */\r\n\t\tTreeNode head = AssortedMethods.randomBST(10, -10, 10); \r\n\t\t\r\n\t\t/* Insert an element into the BST and potentially ruin the BST property */\r\n\t\tTreeNode node = head;\r\n\t\tdo {\r\n\t\t\tint n = AssortedMethods.randomIntInRange(-10, 10);\r\n\t\t\tint rand = AssortedMethods.randomIntInRange(0, 5);\r\n\t\t\tif (rand == 0) {\r\n\t\t\t\tnode.data = n;\r\n\t\t\t} else if (rand == 1) {\r\n\t\t\t\tnode = node.left;\r\n\t\t\t} else if (rand == 2) {\r\n\t\t\t\tnode = node.right;\r\n\t\t\t} else if (rand == 3 || rand == 4) {\r\n\t\t\t\tbreak;\r\n\t\t\t}\r\n\t\t} while (node != null);\t\r\n\t\t\r\n\t\treturn head;\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\t/* Simple test -- create one */\r\n\t\tint[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};\r\n\t\tTreeNode node = TreeNode.createMinimalBST(array);\r\n\t\t//node.left.data = 6; // \"ruin\" the BST property by changing one of the elements\r\n\t\tnode.print();\r\n\t\tboolean isBst = checkBST(node);\r\n\t\tSystem.out.println(isBst);\r\n\t\t\r\n\t\t/* More elaborate test -- creates 100 trees (some BST, some not) and compares the outputs of various methods. */\r\n\t\t/*for (int i = 0; i < 100; i++) {\r\n\t\t\tTreeNode head = createTestTree();\r\n\t\t\t\r\n\t\t\t// Compare results \r\n\t\t\tboolean isBst1 = checkBST(head);\r\n\t\t\tboolean isBst2 = checkBSTAlternate(head);\r\n\t\t\t\r\n\t\t\tif (isBst1 != isBst2) {\r\n\t\t\t\tSystem.out.println(\"*********************** ERROR *******************\");\r\n\t\t\t\thead.print();\r\n\t\t\t\tbreak;\r\n\t\t\t} else {\r\n\t\t\t\tSystem.out.println(isBst1 + \" | \" + isBst2);\r\n\t\t\t\thead.print();\r\n\t\t\t}\r\n\t\t}*/\r\n\t}\r\n}\r\n","Chapter":"Q4_05_Validate_BST"}