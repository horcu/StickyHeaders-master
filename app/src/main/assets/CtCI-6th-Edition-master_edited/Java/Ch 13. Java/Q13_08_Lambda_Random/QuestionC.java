{"Id":"59352cb8-68fb-4eef-9f77-e67df7545652","Topic":"QuestionC.java","Question":"","Solution":"package Q13_08_Lambda_Random;\n\nimport java.util.ArrayList;\nimport java.util.List;\nimport java.util.Random;\nimport java.util.function.Predicate;\nimport java.util.stream.Collectors;\n\npublic class QuestionC {\n\tpublic static Random random = new Random();\n\tpublic static Predicate<Object> flipCoin = o -> {\n\t\treturn random.nextBoolean();\n\t};\n\t\n\tpublic static List<Integer> getRandomSubset(List<Integer> list) {\n \t\tList<Integer> subset = list.stream().filter(flipCoin).\n \t\t\tcollect(Collectors.toList());\n \t\treturn subset;\n\t}\n\t\n \tpublic static void main(String... args) {\t\n \t\tList<Integer> list = new ArrayList<Integer>();\n \t\tlist.add(1);\n \t\tlist.add(2);\n \t\tlist.add(3);\n \t\tlist.add(4);\n \t\tList<Integer> subset = getRandomSubset(list);\n \t\tSystem.out.println(subset.toString());\n \t}\n\n}","Chapter":"Q13_08_Lambda_Random"}