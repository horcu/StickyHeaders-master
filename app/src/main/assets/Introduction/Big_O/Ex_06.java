{"Id":"45f4f128-66a1-4454-b281-bae136a0ed97","Topic":"Ex_06.java","Question":"","Solution":"package Big_O;\n\npublic class Ex_06 {\n\tpublic static void foo(int[] array) {\n\t\tint sum = 0;\n\t\tint product = 1;\n\t\tfor (int i = 0; i < array.length; i++) {\n\t\t\tsum += array[i];\n\t\t}\n\t\tfor (int i = 0; i < array.length; i++) {\n\t\t\tproduct *= array[i];\n\t\t}\t\n\t\tSystem.out.println(sum + \", \" + product);\n\t}\n\t\n\tpublic static void main(String[] args) {\n\t\tint[] array = {1, 2, 5, 2, 2, 5, -1, 9, 3};\n\t\tfoo(array);\n\t}\t\t\n}\n","Chapter":"Big_O"}