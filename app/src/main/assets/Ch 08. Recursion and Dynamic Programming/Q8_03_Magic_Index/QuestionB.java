{"Id":"5ca66766-41d8-4bdb-9692-719b841b4733","Topic":"QuestionB.java","Question":"","Solution":"package Q8_03_Magic_Index;\r\n\r\nimport java.util.Arrays;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\n\r\npublic class QuestionB {\r\n\r\n\tpublic static int magicSlow(int[] array) {\r\n\t\tfor (int i = 0; i < array.length; i++) {\r\n\t\t\tif (array[i] == i) {\r\n\t\t\t\treturn i;\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn -1;\r\n\t}\r\n\t\r\n\tpublic static int magicFast(int[] array, int start, int end) {\r\n\t\tif (end < start) {\r\n\t\t\treturn -1;\r\n\t\t}\r\n\t\tint midIndex = (start + end) / 2;\r\n\t\tint midValue = array[midIndex];\r\n\t\tif (midValue == midIndex) {\r\n\t\t\treturn midIndex;\r\n\t\t}\r\n\t\t/* Search left */\r\n\t\tint leftIndex = Math.min(midIndex - 1, midValue);\r\n\t\tint left = magicFast(array, start, leftIndex);\r\n\t\tif (left >= 0) {\r\n\t\t\treturn left;\r\n\t\t}\r\n\t\t\r\n\t\t/* Search right */\r\n\t\tint rightIndex = Math.max(midIndex + 1, midValue);\r\n\t\tint right = magicFast(array, rightIndex, end);\r\n\t\t\r\n\t\treturn right;\r\n\t}\r\n\t\r\n\tpublic static int magicFast(int[] array) {\r\n\t\treturn magicFast(array, 0, array.length - 1);\r\n\t}\r\n\t\r\n\t/* Creates an array that is sorted */\r\n\tpublic static int[] getSortedArray(int size) {\r\n\t\tint[] array = AssortedMethods.randomArray(size, -1 * size, size);\r\n\t\tArrays.sort(array);\r\n\t\treturn array;\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tfor (int i = 0; i < 1000; i++) {\r\n\t\t\tint size = AssortedMethods.randomIntInRange(5, 20);\r\n\t\t\tint[] array = getSortedArray(size);\r\n\t\t\tint v2 = magicFast(array);\r\n\t\t\tif (v2 == -1 && magicSlow(array) != -1) {\r\n\t\t\t\tint v1 = magicSlow(array);\r\n\t\t\t\tSystem.out.println(\"Incorrect value: index = -1, actual = \" + v1 + \" \" + i);\r\n\t\t\t\tSystem.out.println(AssortedMethods.arrayToString(array));\r\n\t\t\t\tbreak;\r\n\t\t\t} else if (v2 > -1 && array[v2] != v2) {\r\n\t\t\t\tSystem.out.println(\"Incorrect values: index= \" + v2 + \", value \" + array[v2]);\r\n\t\t\t\tSystem.out.println(AssortedMethods.arrayToString(array));\r\n\t\t\t\tbreak;\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n\r\n}\r\n","Chapter":"Q8_03_Magic_Index"}