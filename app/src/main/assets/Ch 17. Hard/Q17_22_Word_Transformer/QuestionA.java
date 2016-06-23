{"Id":"50cee8d7-3e72-41f8-be17-7ee969e98b64","Topic":"QuestionA.java","Question":"","Solution":"package Q17_22_Word_Transformer;\r\n\r\nimport java.util.ArrayList;\r\nimport java.util.HashSet;\r\nimport java.util.LinkedList;\r\nimport java.util.Map;\r\nimport java.util.Queue;\r\nimport java.util.Set;\r\nimport java.util.TreeMap;\r\nimport java.util.TreeSet;\r\n\r\npublic class QuestionA {\r\n\r\n\tpublic static ArrayList<String> wordsOneAway(String word) {\r\n\t\tArrayList<String> words = new ArrayList<String>();\r\n\t\tfor (int i = 0; i < word.length(); i++) {\r\n\t\t\tfor (char c = 'a'; c <= 'z'; c++) {\r\n\t\t\t\tString w = word.substring(0, i) + c + word.substring(i + 1);\r\n\t\t\t\twords.add(w);\r\n\t\t\t}\r\n\t\t}\t\t\r\n\t\treturn words;\r\n\t}\r\n\t\r\n\tpublic static LinkedList<String> transform(HashSet<String> visited, String startWord, String stopWord, Set<String> dictionary) {\r\n\t\tif (startWord.equals(stopWord)) {\r\n\t\t\tLinkedList<String> path = new LinkedList<String>();\r\n\t\t\tpath.add(startWord);\r\n\t\t\treturn path;\r\n\t\t} else if (visited.contains(startWord) || !dictionary.contains(startWord)) {\r\n\t\t\treturn null;\r\n\t\t}\r\n\r\n\t\tvisited.add(startWord);\r\n\t\tArrayList<String> words = wordsOneAway(startWord);\r\n\t\t\r\n\t\tfor (String word : words) {\r\n\t\t\tLinkedList<String> path = transform(visited, word, stopWord, dictionary);\r\n\t\t\tif (path != null) {\r\n\t\t\t\tpath.addFirst(startWord);\r\n\t\t\t\treturn path;\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\treturn null;\r\n\t}\r\n\r\n\tpublic static LinkedList<String> transform(String start, String stop, String[] words) {\r\n\t\tHashSet<String> dict = setupDictionary(words);\r\n\t\tHashSet<String> visited = new HashSet<String>();\r\n\t\treturn transform(visited, start, stop, dict);\r\n\t}\r\n\t\r\n\tpublic static HashSet<String> setupDictionary(String[] words) {\r\n\t\tHashSet<String> hash = new HashSet<String>();\r\n\t\tfor (String word : words) {\r\n\t\t\thash.add(word.toLowerCase());\r\n\t\t}\r\n\t\treturn hash;\r\n\t}\r\n\r\n\tpublic static void main(String[] args) {\r\n\t\tString[] words = {\"maps\", \"tan\", \"tree\", \"apple\", \"cans\", \"help\", \"aped\", \"pree\", \"pret\", \"apes\", \"flat\", \"trap\", \"fret\", \"trip\", \"trie\", \"frat\", \"fril\"};\t\t\r\n\t\tLinkedList<String> list = transform(\"tree\", \"flat\", words);\r\n\t\t\r\n\t\tif (list == null) {\r\n\t\t\tSystem.out.println(\"No path.\");\r\n\t\t} else {\r\n\t\t\tSystem.out.println(list.toString());\r\n\t\t}\r\n\t}\r\n\r\n}\r\n","Chapter":"Q17_22_Word_Transformer"}