{"Id":"ab96bea7-7516-42d4-b204-b14abeded1d6","Topic":"Question.java","Question":"","Solution":"package Q16_15_Master_Mind;\r\n\r\nimport java.util.Random;\r\n\r\npublic class Question {\r\n\r\n\tpublic static class Result {\r\n\t\tpublic int hits;\r\n\t\tpublic int pseudoHits;\r\n\t\t\r\n\t\tpublic Result(int h, int p) {\r\n\t\t\thits = h;\r\n\t\t\tpseudoHits = p;\r\n\t\t}\r\n\t\t\r\n\t\tpublic Result() {\r\n\t\t}\r\n\t\t\r\n\t\tpublic String toString() {\r\n\t\t\treturn \"(\" + hits + \", \" + pseudoHits + \")\";\r\n\t\t}\r\n\t};\r\n\t\r\n\tpublic static int code(char c) {\r\n\t\tswitch (c) {\r\n\t\tcase 'B':\r\n\t\t\treturn 0;\r\n\t\tcase 'G':\r\n\t\t\treturn 1;\r\n\t\tcase 'R':\r\n\t\t\treturn 2;\r\n\t\tcase 'Y':\r\n\t\t\treturn 3;\r\n\t\tdefault:\r\n\t\t\treturn -1;\r\n\t\t}\r\n\t}\r\n\t\r\n\tpublic static int MAX_COLORS = 4;\r\n\t\r\n\tpublic static Result estimate(String guess, String solution) {\r\n\t\tif (guess.length() != solution.length()) return null;\r\n\t\tResult res = new Result();\r\n\t\tint[] frequencies = new int[MAX_COLORS];\r\n\t\t    \r\n\t\t/* Compute hits and built frequency table */\r\n\t\tfor (int i = 0; i < guess.length(); i++) {\r\n\t\t\tif (guess.charAt(i) == solution.charAt(i)) {\r\n\t\t\t\tres.hits++;\r\n\t\t\t} else {\r\n\t\t\t\t/* Only increment the frequency table (which will be used for pseudo-hits) if\r\n\t\t\t\t * it's not a hit. If it's a hit, the slot has already been \"used.\" */\r\n\t\t\t\tint code = code(solution.charAt(i));\r\n\t\t\t\tif (code >= 0) {\r\n\t\t\t\t\tfrequencies[code]++;\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\t/* Compute pseudo-hits */\r\n\t\tfor (int i = 0; i < guess.length(); i++) {\r\n\t\t\tint code = code(guess.charAt(i));\r\n\t\t\tif (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {\r\n\t\t\t\tres.pseudoHits++;\r\n\t\t\t\tfrequencies[code]--;\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn res;\r\n\t}\r\n\r\n\t/************************** TEST CODE **********************************/\r\n\t\r\n\tpublic static char letterFromCode(int k) {\r\n\t\tswitch (k) {\r\n\t\tcase 0:\r\n\t\t\treturn 'B';\r\n\t\tcase 1:\r\n\t\t\treturn 'G';\r\n\t\tcase 2:\r\n\t\t\treturn 'R';\r\n\t\tcase 3:\r\n\t\t\treturn 'Y';\r\n\t\tdefault:\r\n\t\t\treturn '0';\r\n\t\t}\t\t\r\n\t}\r\n\t\r\n\tpublic static Result estimateBad(String g, String s) {\r\n\t\tchar[] guess = g.toCharArray();\r\n\t\tchar[] solution = s.toCharArray();\r\n\t\tint hits = 0;\r\n\t\tfor (int i = 0; i < guess.length; i++) {\r\n\t\t\tif (guess[i] == solution[i]) {\r\n\t\t\t\thits++;\r\n\t\t\t\tsolution[i] = '0';\r\n\t\t\t\tguess[i] = '0';\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\tint pseudohits = 0;\r\n\t\t\r\n\t\tfor (int i = 0; i < guess.length; i++) {\r\n\t\t\tif (guess[i] != '0') {\r\n\t\t\t\tfor (int j = 0; j < solution.length; j++) {\r\n\t\t\t\t\tif (solution[j] != '0') {\r\n\t\t\t\t\t\tif (solution[j] == guess[i]) {\r\n\t\t\t\t\t\t\tpseudohits++;\r\n\t\t\t\t\t\t\tsolution[j] = '0';\r\n\t\t\t\t\t\t\tbreak;\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\treturn new Result(hits, pseudohits);\r\n\t}\r\n\t\r\n\tpublic static String randomString() {\r\n\t\tint length = 4;\r\n\t\tchar[] str = new char[length];\r\n\t\tRandom generator = new Random();\r\n\t\t\r\n\t\tfor (int i = 0; i < length; i++) {\r\n\t\t\tint v = generator.nextInt(4);\r\n\t\t\tchar c = letterFromCode(v);\r\n\t\t\tstr[i] = c;\r\n\t\t}\r\n\t\t\r\n\t\treturn String.valueOf(str);\r\n\t}\r\n\t\r\n\tpublic static boolean test(String guess, String solution) {\r\n\t\tResult res1 = estimate(guess, solution);\r\n\t\tResult res2 = estimateBad(guess, solution);\r\n\t\tif (res1.hits == res2.hits && res1.pseudoHits == res2.pseudoHits) {\r\n\t\t\treturn true;\r\n\t\t} else {\r\n\t\t\tSystem.out.println(\"FAIL: (\" + guess + \", \" + solution + \"): \" + res1.toString() + \" | \" + res2.toString());\r\n\t\t\treturn false;\r\n\t\t}\r\n\t}\r\n\t\r\n\tpublic static boolean testRandom() {\r\n\t\tString guess = randomString();\r\n\t\tString solution = randomString();\r\n\t\treturn test(guess, solution);\r\n\t}\r\n\t\r\n\tpublic static boolean test(int count) {\r\n\t\tfor (int i = 0; i < count; i++) {\r\n\t\t\tif (!testRandom()) {\r\n\t\t\t\treturn true;\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn false;\r\n\t}\r\n\t\r\n\t/********************** END TEST CODE ************************/\r\n\t\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\ttest(1000);\r\n\t}\r\n}\r\n","Chapter":"Q16_15_Master_Mind"}