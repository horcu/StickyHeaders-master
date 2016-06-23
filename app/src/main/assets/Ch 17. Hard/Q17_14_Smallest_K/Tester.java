{"Id":"5eb19598-b285-4bed-8732-8b79b508bf9d","Topic":"Tester.java","Question":"","Solution":"package Q17_14_Smallest_K;\r\n\r\nimport java.util.Arrays;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\n\r\npublic class Tester {\r\n\r\n\tpublic static int rankB(int[] array, int rank) {\r\n\t\tint[] cloned = array.clone();\r\n\t\tArrays.sort(cloned);\r\n\t\treturn cloned[rank];\r\n\t}\r\n\t\r\n\tpublic static void swap(int[] array, int i, int j) {\r\n\t\tint t = array[i];\r\n\t\tarray[i] = array[j];\r\n\t\tarray[j] = t;\r\n\t}\r\n\t\r\n\tpublic static boolean isUnique(int[] array) {\r\n\t\tint[] cloned = array.clone();\r\n\t\tArrays.sort(cloned);\r\n\t\tfor (int i = 1; i < cloned.length; i++) {\r\n\t\t\tif (cloned[i] == cloned[i - 1]) {\r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn true;\r\n\t}\r\n\t\r\n\tpublic static int max(int[] array, int left, int right) {\r\n\t\tint max = Integer.MIN_VALUE;\r\n\t\tfor (int i = left; i <= right; i++) {\r\n\t\t\tmax = Math.max(array[i], max);\r\n\t\t}\r\n\t\treturn max;\r\n\t}\r\n\t\r\n\tpublic static int randomInt(int n) {\r\n\t\treturn (int) (Math.random() * n);\r\n\t}\r\n\t\r\n\tpublic static int randomIntInRange(int min, int max) {\r\n\t\treturn randomInt(max + 1 - min) + min;\r\n\t}\r\n\t\r\n\tpublic static boolean isEqual(int[] array1, int[] array2) {\r\n\t\tif (array1.length != array2.length) {\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tfor (int i = 0; i < array1.length; i++) {\r\n\t\t\tif (array1[i] != array2[i]) {\r\n\t\t\t\treturn false;\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn true;\r\n\t}\r\n\t\r\n\tpublic static boolean isEquivalent(int[] array1, int[] array2) {\r\n\t\tArrays.sort(array1);\r\n\t\tArrays.sort(array2);\r\n\t\treturn isEqual(array1, array2);\r\n\t}\r\n\t\r\n\tpublic static boolean testArray(int[] array1) {\r\n\t\tint[] copy = array1.clone();\r\n\t\tint[] array2 = new int[array1.length];\r\n\t\tfor (int i = 0; i < array1.length; i++) {\r\n\t\t\tarray2[i] = QuestionD.rank(array1, i);\r\n\t\t}\r\n\t\t\r\n\t\tArrays.sort(array1);\r\n\t\tif (!isEqual(array1, array2)) {\r\n\t\t\tSystem.out.println(\"ERROR\");\r\n\t\t\tSystem.out.println(\"Original Array: \" + AssortedMethods.arrayToString(copy));\r\n\t\t\tSystem.out.println(\"Ranked Array:   \" + AssortedMethods.arrayToString(array2));\r\n\t\t\tSystem.out.println(\"Sorted Array:   \" + AssortedMethods.arrayToString(array1));\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\treturn true;\r\n\t}\t\r\n\r\n\tpublic static void main(String[] args) {\r\n\t\tint numberOfTests = 1000;\r\n\t\tint countWithC = 0;\r\n\t\tint countTotal = 0;\r\n\t\t\r\n\t\tfor (int i = 0; i < numberOfTests; i++) {\r\n\t\t\tint length = AssortedMethods.randomIntInRange(1, 10);\r\n\t\t\tint rank = AssortedMethods.randomIntInRange(1, length);\r\n\t\t\tint minRange = -1 * i;\r\n\t\t\tint maxRange = i;\r\n\t\t\t\r\n\t\t\t\r\n\t\t\tint[] array = AssortedMethods.randomArray(length, minRange, maxRange);\r\n\t\t\tint[] smallestA = QuestionA.smallestK(array.clone(), rank);\r\n\t\t\tint[] smallestB = QuestionB.smallestK(array.clone(), rank);\r\n\t\t\tint[] smallestD = QuestionD.smallestK(array.clone(), rank);\r\n\t\t\tint[] smallestC = smallestD;\r\n\t\t\tif (isUnique(array)) {\r\n\t\t\t\tsmallestC = QuestionC.smallestK(array.clone(), rank);\r\n\t\t\t\tcountWithC++;\r\n\t\t\t}\r\n\t\t\tcountTotal++;\r\n\t\t\tif (!isEquivalent(smallestA, smallestB) || !isEquivalent(smallestB, smallestD) || !isEquivalent(smallestD, smallestC)) {\r\n\t\t\t\tSystem.out.println(\"ERROR\");\r\n\t\t\t\tSystem.out.println(array);\r\n\t\t\t\tSystem.out.println(\"ArrayA: \" + AssortedMethods.arrayToString(smallestA));\r\n\t\t\t\tSystem.out.println(\"ArrayA: \" + AssortedMethods.arrayToString(smallestA));\r\n\t\t\t\tSystem.out.println(\"ArrayB: \" + AssortedMethods.arrayToString(smallestB));\r\n\t\t\t\tSystem.out.println(\"ArrayC: \" + AssortedMethods.arrayToString(smallestC));\r\n\t\t\t\tSystem.out.println(\"ArrayD: \" + AssortedMethods.arrayToString(smallestD));\r\n\t\t\t\t\r\n\t\t\t\tbreak;\r\n\t\t\t}\r\n\t\t}\r\n\t\tSystem.out.println(\"Completed \" + countTotal + \" runs, including \" + countWithC + \" with C\");\r\n\t}\r\n\r\n}\r\n","Chapter":"Q17_14_Smallest_K"}