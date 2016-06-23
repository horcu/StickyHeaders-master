{"Id":"29167412-a5d9-4b17-8986-1fa99df3e25c","Topic":"QuestionB.java","Question":"","Solution":"package Q6_10_Test_Strips;\n\nimport java.util.ArrayList;\nimport java.util.HashSet;\nimport java.util.Random;\n\npublic class QuestionB {\n\tpublic static ArrayList<Bottle> createBottles(int nBottles, int poisoned) {\n\t\tArrayList<Bottle> bottles = new ArrayList<Bottle>();\n\t\tfor (int i = 0; i < nBottles; i++) {\n\t\t\tbottles.add(new Bottle(i));\n\t\t}\n\t\t\n\t\tif (poisoned == -1) {\n\t\t\tRandom random = new Random();\n\t\t\tpoisoned = random.nextInt(nBottles);\n\t\t}\n\t\tbottles.get(poisoned).setAsPoisoned();\n\t\t\n\t\tSystem.out.println(\"Added poison to bottle \" + poisoned);\n\t\t\n\t\treturn bottles;\n\t}\n\n\tpublic static int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {\n\t\tif (bottles.size() > 1000 || strips.size() < 10) return -1;\n\t\t\n\t\tint tests = 4; // three digits, plus one extra\n\t\tint nTestStrips = strips.size();\n\t\t\n\t\t/* Run tests. */\n\t\tfor (int day = 0; day < tests; day++) {\n\t\t\trunTestSet(bottles, strips, day);\n\t\t}\n\t\t\n\t\t/* Get results. */\n\t\tHashSet<Integer> previousResults = new HashSet<Integer>();\n\t\tint[] digits = new int[tests];\n\t\tfor (int day = 0; day < tests; day++) {\n\t\t\tint resultDay = day + TestStrip.DAYS_FOR_RESULT;\n\t\t\tdigits[day] = getPositiveOnDay(strips, resultDay, previousResults);\n\t\t\tpreviousResults.add(digits[day]);\n\t\t}\n\t\t\n\t\t/* If day 1's results matched day 0's, update the digit. */\n\t\tif (digits[1] == -1) {\n\t\t\tdigits[1] = digits[0];\n\t\t}\n\t\t\n\t\t/* If day 2 matched day 0 or day 1, check day 3. Day 3 is\n\t\t * the same as day 2, but incremented by 1. */\n\t\tif (digits[2] == -1) { \n\t\t\tif (digits[3] == -1) { /* Day 3 didn't give new result */\n\t\t\t\t/* Digit 2 equals digit 0 or digit 1. But, digit 2, when incremented also matches \n\t\t\t\t * digit 0 or digit 1. This means that digit 0 incremented matches digit 1, or the\n\t\t\t\t * other way around. */\n\t\t\t\tdigits[2] = ((digits[0] + 1) % nTestStrips) == digits[1] ? digits[0] : digits[1];  \n\t\t\t} else {\n\t\t\t\tdigits[2] = (digits[3] - 1 + nTestStrips) % nTestStrips;\n\t\t\t}\n\t\t}\n\t\t\n\t\treturn digits[0] * 100 + digits[1] * 10 + digits[2];\n\t}\n\t\n\t/* Run set of tests for this day. */\n\tpublic static void runTestSet(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips, int day) {\n\t\tif (day > 3) return; // only works for 3 days (digits) + one extra\n\n\t\tfor (Bottle bottle : bottles) {\n\t\t\tint index = getTestStripIndexForDay(bottle, day, strips.size());\n\t\t\tTestStrip testStrip = strips.get(index);\n\t\t\ttestStrip.addDropOnDay(day, bottle);\n\t\t}\n\t}\n\t\n\t/* Get test strip index that should be used on this bottle on this day. */ \n\tpublic static int getTestStripIndexForDay(Bottle bottle, int day, int nTestStrips) {\n\t\tint id = bottle.getId();\n\t\tswitch (day) {\n\t\t\tcase 0: return id /100;\n\t\t\tcase 1: return (id % 100) / 10;\n\t\t\tcase 2: return id % 10;\n\t\t\tcase 3: return (id % 10 + 1) % nTestStrips;\n\t\t\tdefault: return -1;\n\t\t}\n\t}\t\n\t\n\t/* Get results that are positive for a particular day, excluding prior results. */\n\tpublic static int getPositiveOnDay(ArrayList<TestStrip> testStrips, int day, HashSet<Integer> previousResults) {\n\t\tfor (TestStrip testStrip : testStrips) {\n\t\t\tint id = testStrip.getId();\n\t\t\tif (testStrip.isPositiveOnDay(day) && !previousResults.contains(id)) {\n\t\t\t\treturn testStrip.getId();\n\t\t\t}\n\t\t}\n\t\treturn -1;\n\t}\t\n\t\n\tpublic static ArrayList<TestStrip> createTestStrips(int nTestStrips) {\n\t\tArrayList<TestStrip> testStrips = new ArrayList<TestStrip>();\n\t\tfor (int i = 0; i < nTestStrips; i++) {\n\t\t\ttestStrips.add(new TestStrip(i));\n\t\t}\n\t\treturn testStrips;\n\t}\n\t\n\tpublic static void main(String[] args) {\n\t\tint nBottles = 1000;\n\t\tint nTestStrips = 10;\n\t\tfor (int poisoned = 0; poisoned < nBottles; poisoned++) {\n\t\t\tArrayList<Bottle> bottles = createBottles(nBottles, poisoned);\n\t\t\tArrayList<TestStrip> testStrips = createTestStrips(nTestStrips);\n\t\t\tint poisonedId = findPoisonedBottle(bottles, testStrips);\n\t\t\tSystem.out.println(\"Suspected Bottle: \" + poisonedId);\n\t\t\tif (poisonedId != poisoned) {\n\t\t\t\tSystem.out.println(\"ERROR\");\n\t\t\t\tbreak;\n\t\t\t}\n\t\t}\n\t}\n}\n","Chapter":"Q6_10_Test_Strips"}