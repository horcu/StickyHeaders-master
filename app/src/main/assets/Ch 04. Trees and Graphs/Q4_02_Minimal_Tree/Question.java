{"Id":"3f25ed4e-8a8f-4c49-bf1c-cecf46e5ea3a","Topic":"Question.java","Question":"","Solution":"package Q4_02_Minimal_Tree;\r\n\r\nimport CtCILibrary.TreeNode;\r\n\r\npublic class Question {\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};\r\n\t\t\r\n\t\t// We needed this code for other files, so check out the code in the library\r\n\t\tTreeNode root = TreeNode.createMinimalBST(array);\r\n\t\tSystem.out.println(\"Root? \" + root.data);\r\n\t\tSystem.out.println(\"Created BST? \" + root.isBST());\r\n\t\tSystem.out.println(\"Height: \" + root.height());\r\n\t}\r\n\r\n}\r\n","Chapter":"Q4_02_Minimal_Tree"}