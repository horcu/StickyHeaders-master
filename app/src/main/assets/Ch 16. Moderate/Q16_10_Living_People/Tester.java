{"Id":"b929be54-66be-44e5-ab83-7deae57447d8","Topic":"Tester.java","Question":"","Solution":"package Q16_10_Living_People;\n\nimport java.util.Random;\n\npublic class Tester {\n\n\t\n\t\n\tpublic static void main(String[] args) {\n\t\tint n = 100;\n\t\tint first = 1900;\n\t\tint last = 2000;\n\t\t\n\t\tRandom random = new Random();\n\t\tPerson[] people = new Person[n + 1];\n\t\tfor (int i = 0; i < n; i++) {\n\t\t\tint birth = first + random.nextInt(last - first);\n\t\t\tint death = birth + random.nextInt(last - birth);\n\t\t\tpeople[i] = new Person(birth, death);\n\t\t\t//System.out.println(birth + \", \" + death);\n\t\t}\n\t\tpeople[n] = new Person(first, first);\n\t\t\n\t\tint yearA = QuestionA.maxAliveYear(people, first, last);\n\t\tint yearB = QuestionB.maxAliveYear(people, first, last);\n\t\tint yearC = QuestionC.maxAliveYear(people, first, last);\n\t\tint yearD = QuestionD.maxAliveYear(people, first, last);\n\t\tSystem.out.println(\"A: \" + yearA);\n\t\tSystem.out.println(\"B: \" + yearB);\n\t\tSystem.out.println(\"C: \" + yearC);\n\t\tSystem.out.println(\"D: \" + yearD);\n\t}\n\n}\n","Chapter":"Q16_10_Living_People"}