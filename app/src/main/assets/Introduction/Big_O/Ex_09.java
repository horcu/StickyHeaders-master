{"Id":"b11b0c26-edbc-4dbf-bc6f-e32d92fdee7f","Topic":"Ex_09.java","Question":"","Solution":"package Big_O;\n\npublic class Ex_09 {\n\tpublic static void printUnorderedPairs(int[] arrayA, int[] arrayB) {\n\t\tfor (int i = 0; i < arrayA.length; i++) {\n\t\t\tfor (int j = 0; j < arrayB.length; j++) {\n\t\t\t\tif (arrayA[i] < arrayB[j]) {\n\t\t\t\t\tSystem.out.println(arrayA[i] + \",\" + arrayB[j]);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\t\n\tpublic static void main(String[] args) {\n\t\tint[] arrayA = {0, 1, 2, 3};\n\t\tint[] arrayB = {4, 5, 6};\n\t\tprintUnorderedPairs(arrayA, arrayB);\n\t}\t\t\n}\n","Chapter":"Big_O"}