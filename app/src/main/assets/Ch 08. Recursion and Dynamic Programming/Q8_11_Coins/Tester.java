{"Id":"a4c6ba4a-eca2-4ac8-bbc1-6b88e5dae27a","Topic":"Tester.java","Question":"","Solution":"package Q8_11_Coins;\n\npublic class Tester {\n\n\tpublic static void main(String[] args) {\n\t\tfor (int i = 0; i < 200; i++) {\n\t\t\tint[] denoms = {25, 10, 5, 1};\n\t\t\tint waysA = Question.makeChange(i, denoms);\n\t\t\tint waysB = QuestionB.makeChange(i, denoms);\n\t\t\tif (waysA != waysB) {\n\t\t\t\tSystem.out.println(\"Error: \" + i + \" : \" + waysA + \", \" + waysB);\n\t\t\t}\n\t\t}\n\n\t}\n\n}\n","Chapter":"Q8_11_Coins"}