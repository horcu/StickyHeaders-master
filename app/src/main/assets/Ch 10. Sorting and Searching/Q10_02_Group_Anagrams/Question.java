{"Id":"9031217c-c4e1-415c-9089-41347283ea31","Topic":"Question.java","Question":"","Solution":"package Q10_02_Group_Anagrams;\r\n\r\nimport java.util.Arrays;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\n\r\npublic class Question {\r\n\tpublic static void main(String[] args) {\r\n\t\tString[] array = {\"apple\", \"banana\", \"carrot\", \"ele\", \"duck\", \"papel\", \"tarroc\", \"cudk\", \"eel\", \"lee\"};\r\n\t\tSystem.out.println(AssortedMethods.stringArrayToString(array));\r\n\t\tArrays.sort(array, new AnagramComparator());\r\n\t\tSystem.out.println(AssortedMethods.stringArrayToString(array));\r\n\t}\r\n}\r\n","Chapter":"Q10_02_Group_Anagrams"}