{"Id":"2e83dfef-6f73-424c-94c5-5547180dbf58","Topic":"QuestionB.java","Question":"","Solution":"package Q10_11_Peaks_and_Valleys;\n\nimport CtCILibrary.AssortedMethods;\n\npublic class QuestionB {\n\tpublic static void swap(int[] array, int left, int right) {\n\t\tint temp = array[left];\n\t\tarray[left] = array[right];\n\t\tarray[right] = temp;\n\t}\n\t\n\tpublic static void sortValleyPeak(int[] array) {\n\t\tfor (int i = 1; i < array.length; i += 2) {\n\t\t\tint biggestIndex = maxIndex(array, i - 1, i, i + 1);\n\t\t\tif (i != biggestIndex) {\n\t\t\t\tswap(array, i, biggestIndex);\n\t\t\t}\n\t\t}\n\t}\t\n\t\n\tpublic static int maxIndex(int[] array, int a, int b, int c) {\n\t\tint len = array.length;\n\t\tint aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE; \n\t\tint bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE; \n\t\tint cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE; \n\t\t\n\t\tint max = Math.max(aValue, Math.max(bValue, cValue));\n\t\t\n\t\tif (aValue == max) {\n\t\t\treturn a;\n\t\t} else if (bValue == max) {\n\t\t \treturn b;\n\t\t} else {\n\t\t\treturn c;\n\t\t}\n\t}\n\n\tpublic static void main(String[] args) {\n\t\tint[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};\n\t\tSystem.out.println(AssortedMethods.arrayToString(array));\n\t\tsortValleyPeak(array);\n\t\tSystem.out.println(AssortedMethods.arrayToString(array));\n\t\tSystem.out.println(Tester.confirmValleyPeak(array));\n\t}\n\n}\n","Chapter":"Q10_11_Peaks_and_Valleys"}