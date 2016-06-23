{"Id":"37b0907f-0880-4c79-aa31-df3f9f73e628","Topic":"Question.java","Question":"","Solution":"package Q2_04_Partition;\r\n\r\nimport CtCILibrary.LinkedListNode;\r\n\r\npublic class Question {\r\n\r\n\tpublic static LinkedListNode partition(LinkedListNode node, int x) {\r\n\t\tLinkedListNode beforeStart = null;\r\n\t\tLinkedListNode beforeEnd = null;\r\n\t\tLinkedListNode afterStart = null;\r\n\t\tLinkedListNode afterEnd = null;\r\n\t\t\r\n\t\t/* Partition list */\r\n\t\twhile (node != null) {\r\n\t\t\tLinkedListNode next = node.next;\r\n\t\t\tnode.next = null;\r\n\t\t\tif (node.data < x) {\r\n\t\t\t\tif (beforeStart == null) {\r\n\t\t\t\t\tbeforeStart = node;\r\n\t\t\t\t\tbeforeEnd = beforeStart;\r\n\t\t\t\t} else {\r\n\t\t\t\t\tbeforeEnd.next = node;\r\n\t\t\t\t\tbeforeEnd = node;\r\n\t\t\t\t}\r\n\t\t\t} else {\r\n\t\t\t\tif (afterStart == null) {\r\n\t\t\t\t\tafterStart = node;\r\n\t\t\t\t\tafterEnd = afterStart;\r\n\t\t\t\t} else {\r\n\t\t\t\t\tafterEnd.next = node;\r\n\t\t\t\t\tafterEnd = node;\r\n\t\t\t\t}\r\n\t\t\t}\t\r\n\t\t\tnode = next;\r\n\t\t}\r\n\t\t\r\n\t\t/* Merge before list and after list */\r\n\t\tif (beforeStart == null) {\r\n\t\t\treturn afterStart;\r\n\t\t}\r\n\t\t\r\n\t\tbeforeEnd.next = afterStart;\r\n\t\treturn beforeStart;\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\t/* Create linked list */\r\n\t\tint[] vals = {33,9,2,3,10,10389,838,874578,5};\r\n\t\tLinkedListNode head = new LinkedListNode(vals[0], null, null);\r\n\t\tLinkedListNode current = head;\r\n\t\tfor (int i = 1; i < vals.length; i++) {\r\n\t\t\tcurrent = new LinkedListNode(vals[i], null, current);\r\n\t\t}\r\n\t\tSystem.out.println(head.printForward());\r\n\t\t\r\n\t\t/* Partition */\r\n\t\tLinkedListNode h = partition(head, 3);\r\n\t\t\r\n\t\t/* Print Result */\r\n\t\tSystem.out.println(h.printForward());\r\n\t}\r\n\r\n}\r\n","Chapter":"Q2_04_Partition"}