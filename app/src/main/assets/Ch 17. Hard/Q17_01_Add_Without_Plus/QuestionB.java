{"Id":"caaa45a9-6691-4975-b185-2f796ea9a693","Topic":"QuestionB.java","Question":"","Solution":"package Q17_01_Add_Without_Plus;\r\n\r\npublic class QuestionB {\r\n\r\n\tpublic static int add(int a, int b) {\r\n\t\twhile (b != 0) {\r\n\t\t\tint sum = a ^ b; // add without carrying\r\n\t\t\tint carry = (a & b) << 1; // carry, but don't add\t\t\t\r\n\t\t\ta = sum;\r\n\t\t\tb = carry;\r\n\t\t}\r\n\t\treturn a;\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint a = Integer.MAX_VALUE - 50;\r\n\t\tint b = 92;\r\n\t\tint sum = add(a, b);\r\n\t\tint intendedSum = a + b;\r\n\t\tif (sum != intendedSum) {\r\n\t\t\tSystem.out.println(\"ERROR\");\r\n\t\t} else {\r\n\t\t\tSystem.out.println(\"SUCCESS\");\r\n\t\t}\r\n\t\tSystem.out.println(a + \" + \" + b + \" = \" + sum + \" vs \" + intendedSum);\r\n\t}\r\n\r\n}\r\n","Chapter":"Q17_01_Add_Without_Plus"}