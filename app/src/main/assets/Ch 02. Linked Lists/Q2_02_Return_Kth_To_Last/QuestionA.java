{"Id":"d2c71967-49d7-4087-b0e3-c0e0aca80ab4","Topic":"QuestionA.java","Question":"","Solution":"package Q2_02_Return_Kth_To_Last;\r\n\r\nimport CtCILibrary.*;\r\n\r\npublic class QuestionA {\r\n\r\n\tpublic static int printKthToLast(LinkedListNode head, int k) {\r\n\t\tif (head == null) {\r\n\t\t\treturn 0;\r\n\t\t}\r\n\t\tint index = printKthToLast(head.next, k) + 1;\r\n\t\tif (index == k) {\r\n\t\t\tSystem.out.println(k + \"th to last node is \" + head.data);\r\n\t\t}\r\n\t\treturn index;\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint[] array = {0, 1, 2, 3, 4, 5, 6};\r\n\t\tLinkedListNode head = AssortedMethods.createLinkedListFromArray(array);\r\n\t\tfor (int i = 0; i <= array.length + 1; i++) {\r\n\t\t\tprintKthToLast(head, i);\r\n\t\t}\r\n\t}\r\n\r\n}\r\n","Chapter":"Q2_02_Return_Kth_To_Last"}