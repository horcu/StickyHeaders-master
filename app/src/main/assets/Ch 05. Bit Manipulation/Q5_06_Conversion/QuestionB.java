{"Id":"f4f1394e-1853-410f-8e6f-0eee25992e2a","Topic":"QuestionB.java","Question":"","Solution":"package Q5_06_Conversion;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\n\r\npublic class QuestionB {\r\n\tpublic static int bitSwapRequired(int a, int b){\r\n\t\tint count = 0;\r\n\t\tfor (int c = a ^ b; c != 0; c = c & (c-1)) {\r\n\t\t\tcount++;\r\n\t\t}\r\n\t\treturn count;\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint a = -23432;\r\n\t\tint b = 512132;\r\n\t\tSystem.out.println(a + \": \" + AssortedMethods.toFullBinaryString(a));\r\n\t\tSystem.out.println(b + \": \" + AssortedMethods.toFullBinaryString(b));\r\n\t\tSystem.out.println(\"Required number of bits: \" + bitSwapRequired(a, b));\r\n\t}\r\n}\r\n","Chapter":"Q5_06_Conversion"}