{"Id":"5a91aff8-57ff-4cb0-afd6-378ca5e07760","Topic":"IntroductionCollections.java","Question":"","Solution":"package Introduction;\r\n\r\nimport java.util.ArrayList;\r\nimport java.util.HashMap;\r\nimport java.util.Iterator;\r\nimport java.util.LinkedList;\r\nimport java.util.Vector;\r\n\r\npublic class IntroductionCollections {\r\n\tpublic static void main(String[] args) {\r\n\t\t// ArrayList\r\n\t\tArrayList<String> myArr = new ArrayList<String>();\r\n\t\tmyArr.add(\"one\");\r\n\t\tmyArr.add(\"two\");\r\n\t\tSystem.out.println(myArr.get(0));\r\n\t\t\r\n\t\t// Vector\r\n\t\tVector<String> myVect = new Vector<String>();\r\n\t\tmyVect.add(\"one\");\r\n\t\tmyVect.add(\"two\");\r\n\t\tSystem.out.println(myVect.get(0));\r\n\t\t\r\n\t\t// Linked List\r\n\t\tLinkedList<String> myLinkedList = new LinkedList<String>();\r\n\t\tmyLinkedList.add(\"two\");\r\n\t\tmyLinkedList.addFirst(\"one\");\r\n\t\tIterator<String> iter = myLinkedList.iterator();\r\n\t\twhile (iter.hasNext()) {\r\n\t\t\tSystem.out.println(iter.next());\r\n\t\t}\r\n\t\t\r\n\t\t// Hash Map\r\n\t\tHashMap<String, String> map = new HashMap<String, String>();\r\n\t\tmap.put(\"one\", \"uno\");\r\n\t\tmap.put(\"two\", \"dos\");\r\n\t\tSystem.out.println(map.get(\"one\"));\r\n\t}\r\n}\r\n","Chapter":"Introduction"}