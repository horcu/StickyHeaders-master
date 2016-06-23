{"Id":"64187dee-2a57-486a-b915-3ea4adc6d655","Topic":"QuestionA.java","Question":"","Solution":"package Q17_07_Baby_Names;\n\nimport java.util.HashMap;\nimport java.util.HashSet;\nimport java.util.Map.Entry;\nimport java.util.Set;\n\npublic class QuestionA {\n\n\t/* Read through (name, frequency) pairs and initialize a mapping\n\t * of names to NameSets (equivalence classes).*/\n\tpublic static HashMap<String, NameSet> constructGroups(HashMap<String, Integer> names) {\n\t\tHashMap<String, NameSet> groups = new HashMap<String, NameSet>();\n\t\tfor (Entry<String, Integer> entry : names.entrySet()) {\n\t\t    String name = entry.getKey();\n\t\t    int frequency = entry.getValue();\n\t\t    NameSet group = new NameSet(name, frequency);\n\t\t    groups.put(name,  group);\n\t\t}\n\t\treturn groups;\n\t}\n\t\n\tpublic static void mergeClasses(HashMap<String, NameSet> groups, String[][] synonyms) {\n\t\tfor (String[] entry : synonyms) {\n\t\t    String name1 = entry[0];\n\t\t    String name2 = entry[1];\n\t\t    NameSet set1 = groups.get(name1);\n\t\t    NameSet set2 = groups.get(name2);\n\t\t    if (set1 != set2) {\n\t\t    \t/* Always merge the smaller set into the bigger one. */\n\t\t    \tNameSet smaller = set2.size() < set1.size() ? set2 : set1;\n\t\t    \tNameSet bigger = set2.size() < set1.size() ? set1 : set2;\n\t\t    \t\n\t\t\t    /* Merge lists */\n\t\t\t    Set<String> otherNames = smaller.getNames();\n\t\t\t    int frequency = smaller.getFrequency();\n\t\t\t    bigger.copyNamesWithFrequency(otherNames, frequency);\n\t\t\t    \n\t\t\t    /* Update mapping */\n\t\t\t    for (String name : otherNames) {\n\t\t\t    \tgroups.put(name,  bigger);\n\t\t\t    }\n\t\t    }\n\t\t}\n\t}\n\t\n\tpublic static HashMap<String, Integer> convertToMap(HashMap<String, NameSet> groups) {\n\t\tHashMap<String, Integer> list = new HashMap<String, Integer>();\n\t\tfor (NameSet group : groups.values()) {\n\t\t\tlist.put(group.getRootName(), group.getFrequency());\n\t\t}\n\t\treturn list;\n\t}\n\t\n\tpublic static HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> names, String[][] synonyms) {\n\t\tHashMap<String, NameSet> groups = constructGroups(names);\n\t\tmergeClasses(groups, synonyms);\n\t\treturn convertToMap(groups);\n\t}\n\t\n\tpublic static void main(String[] args) {\n\t\tHashMap<String, Integer> names = new HashMap<String, Integer>();\n\t\t\n\t\tnames.put(\"John\", 3);\n\t\tnames.put(\"Jonathan\", 4);\n\t\tnames.put(\"Johnny\", 5);\n\t\tnames.put(\"Chris\", 1);\n\t\tnames.put(\"Kris\", 3);\n\t\tnames.put(\"Brian\", 2);\n\t\tnames.put(\"Bryan\", 4);\n\t\tnames.put(\"Carleton\", 4);\n\t\t\n\t\tString[][] synonyms = \n\t\t\t{{\"John\", \"Jonathan\"}, \n\t\t\t {\"Jonathan\", \"Johnny\"}, \n\t\t\t {\"Chris\", \"Kris\"}, \n\t\t\t {\"Brian\", \"Bryan\"}};\n\t\t\n\t\tHashMap<String, Integer> finalList = trulyMostPopular(names, synonyms);\n\t\tfor (Entry<String, Integer> entry : finalList.entrySet()) {\n\t\t    String name = entry.getKey();\n\t\t    int frequency = entry.getValue();\n\t\t    System.out.println(name + \": \" + frequency);\n\t\t}\n\t}\n\n}\n","Chapter":"Q17_07_Baby_Names"}