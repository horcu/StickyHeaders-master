{"Id":"e0595577-4736-4472-b795-92c3771ef6d4","Topic":"QuestionA.java","Question":"","Solution":"package Q9_02_Social_Network;\n\nimport java.util.ArrayList;\nimport java.util.HashMap;\nimport java.util.HashSet;\nimport java.util.LinkedList;\nimport java.util.Queue;\n\npublic class QuestionA {\n\tpublic static LinkedList<Person> findPathBFS(HashMap<Integer, Person> people, int source, int destination) {\n\t\tQueue<PathNode> toVisit = new LinkedList<PathNode>();\n\t\tHashSet<Integer> visited = new HashSet<Integer>();\n\t\ttoVisit.add(new PathNode(people.get(source), null));\n\t\tvisited.add(source);\n\t\twhile (!toVisit.isEmpty()) {\n\t\t\tPathNode node = toVisit.poll();\n\t\t\tPerson person = node.getPerson();\n\t\t\tif (person.getID() == destination) {\n\t\t\t\treturn node.collapse(false);\n\t\t\t}\n\t\t\t\n\t\t\t/* Search friends. */\n\t\t\tArrayList<Integer> friends = person.getFriends();\n\t\t\tfor (int friendId : friends) {\n\t\t\t\tif (!visited.contains(friendId)) {\n\t\t\t\t\tvisited.add(friendId);\n\t\t\t\t\tPerson friend = people.get(friendId);\n\t\t\t\t\ttoVisit.add(new PathNode(friend, node));\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn null;\n\t}\n\t\n\tpublic static void main(String[] args) {\n\t\tint nPeople = 11;\n\t\tHashMap<Integer, Person> people = new HashMap<Integer, Person>();\n\t\tfor (int i = 0; i < nPeople; i++) {\n\t\t\tPerson p = new Person(i);\n\t\t\tpeople.put(i, p);\n\t\t}\n\t\t\n\t\tint[][] edges = {{1, 4}, {1, 2}, {1, 3}, {3, 2}, {4, 6}, {3, 7}, {6, 9}, {9, 10}, {5, 10}, {2, 5}, {3, 7}};\n\t\t\n\t\tfor (int[] edge : edges) {\n\t\t\tPerson source = people.get(edge[0]);\n\t\t\tsource.addFriend(edge[1]);\n\t\t\t\n\t\t\tPerson destination = people.get(edge[1]);\n\t\t\tdestination.addFriend(edge[0]);\n\t\t}\n\t\t\n\t\tint i = 1;\n\t\tint j = 10;\n\t\tLinkedList<Person> path1 = findPathBFS(people, i, j);\n\t\tTester.printPeople(path1);\n\t}\n\n}\n","Chapter":"Q9_02_Social_Network"}