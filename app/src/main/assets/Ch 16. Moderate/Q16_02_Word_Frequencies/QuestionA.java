{"Id":"04ae12b0-35d4-46d5-89cb-19f8b906aca3","Topic":"QuestionA.java","Question":"","Solution":"package Q16_02_Word_Frequencies;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\n\r\npublic class QuestionA {\r\n\tpublic static int getFrequency(String[] book, String word) {\r\n\t\tword = word.trim().toLowerCase();\r\n\t\tint count = 0;\r\n\t\tfor (String w : book) {\r\n\t\t\tif (w.trim().toLowerCase().equals(word)) {\r\n\t\t\t\tcount++;\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn count;\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tString[] wordlist = AssortedMethods.getLongTextBlobAsStringList();\r\n\t\t\r\n\t\tString[] words = {\"the\", \"Lara\", \"and\", \"outcropping\", \"career\", \"it\"};\r\n\t\tfor (String word : words) {\r\n\t\t\tSystem.out.println(word + \": \" + getFrequency(wordlist, word));\r\n\t\t}\r\n\t}\r\n\t\r\n}\r\n","Chapter":"Q16_02_Word_Frequencies"}