{"Id":"2e3df6c1-2e0e-4b11-be53-a1472b1023b3","Topic":"LockFactory.java","Question":"","Solution":"package Q15_04_Deadlock_Free_Class;\r\n\r\nimport java.util.HashMap;\r\nimport java.util.LinkedList;\r\nimport java.util.concurrent.locks.Lock;\r\n\r\npublic class LockFactory {\r\n\tprivate static LockFactory instance;\r\n\t\r\n\tprivate int numberOfLocks = 5; /* default */\r\n\tprivate LockNode[] locks;\r\n\t\r\n\t/* Maps from a process or owner to the order that the owner claimed it would call the locks in */\r\n\tprivate HashMap<Integer, LinkedList<LockNode>> lockOrder;\r\n\t\r\n\tprivate LockFactory(int count) {\r\n\t\tnumberOfLocks = count;\r\n\t\tlocks = new LockNode[numberOfLocks];\r\n\t\tlockOrder = new HashMap<Integer, LinkedList<LockNode>>();\r\n\t\tfor (int i = 0; i < numberOfLocks; i++) {\r\n\t\t\tlocks[i] = new LockNode(i, count);\r\n\t\t}\r\n\t}\r\n\t\r\n\tpublic static LockFactory getInstance() {\r\n\t\treturn instance;\r\n\t}\r\n\t\r\n\tpublic static LockFactory initialize(int count) {\r\n\t\tif (instance == null) {\r\n\t\t\tinstance = new LockFactory(count);\r\n\t\t}\r\n\t\treturn instance;\r\n\t}\r\n\t\r\n\tpublic boolean hasCycle(HashMap<Integer, Boolean> touchedNodes, int[] resourcesInOrder) {\r\n\t\t/* check for a cycle */\r\n\t\tfor (int resource : resourcesInOrder) {\r\n\t\t\tif (touchedNodes.get(resource) == false) {\r\n\t\t\t\tLockNode n = locks[resource];\r\n\t\t\t\tif (n.hasCycle(touchedNodes)) {\r\n\t\t\t\t\treturn true;\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn false;\r\n\t}\r\n\r\n\t/* To prevent deadlocks, force the processes to declare upfront what order they will\r\n\t * need the locks in. Verify that this order does not create a deadlock (a cycle in a directed graph)\r\n\t */\r\n\tpublic boolean declare(int ownerId, int[] resourcesInOrder) {\r\n\t\tHashMap<Integer, Boolean> touchedNodes = new HashMap<Integer, Boolean>();\r\n\t\t\r\n\t\t/* add nodes to graph */\r\n\t\tint index = 1;\r\n\t\ttouchedNodes.put(resourcesInOrder[0], false);\r\n\t\tfor (index = 1; index < resourcesInOrder.length; index++) {\r\n\t\t\tLockNode prev = locks[resourcesInOrder[index - 1]];\r\n\t\t\tLockNode curr = locks[resourcesInOrder[index]];\r\n\t\t\tprev.joinTo(curr);\r\n\t\t\ttouchedNodes.put(resourcesInOrder[index], false);\r\n\t\t}\r\n\t\t\r\n\t\t/* if we created a cycle, destroy this resource list and return false */\r\n\t\tif (hasCycle(touchedNodes, resourcesInOrder)) {\r\n\t\t\tfor (int j = 1; j < resourcesInOrder.length; j++) {\r\n\t\t\t\tLockNode p = locks[resourcesInOrder[j - 1]];\r\n\t\t\t\tLockNode c = locks[resourcesInOrder[j]];\r\n\t\t\t\tp.remove(c);\r\n\t\t\t}\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\t\r\n\t\t/* No cycles detected. Save the order that was declared, so that we can verify that the\r\n\t\t * process is really calling the locks in the order it said it would. */\r\n\t\tLinkedList<LockNode> list = new LinkedList<LockNode>();\r\n\t\tfor (int i = 0; i < resourcesInOrder.length; i++) {\r\n\t\t\tLockNode resource = locks[resourcesInOrder[i]];\r\n\t\t\tlist.add(resource);\r\n\t\t}\r\n\t\tlockOrder.put(ownerId, list);\r\n\t\t\r\n\t\treturn true;\r\n\t}\r\n\t\r\n\t/* Get the lock, verifying first that the process is really calling the locks in the order\r\n\t * it said it would. */\r\n\tpublic Lock getLock(int ownerId, int resourceID) {\r\n\t\tLinkedList<LockNode> list = lockOrder.get(ownerId);\r\n\t\tif (list == null) {\r\n\t\t\treturn null;\r\n\t\t}\r\n\t\t\r\n\t\tLockNode head = list.getFirst();\r\n\t\tif (head.getId() == resourceID) {\r\n\t\t\tlist.removeFirst();\r\n\t\t\treturn head.getLock();\r\n\t\t}\r\n\t\treturn null;\r\n\t}\r\n}\r\n","Chapter":"Q15_04_Deadlock_Free_Class"}