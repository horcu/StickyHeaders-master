{"Id":"d4a1c78a-b8f4-4246-b7e0-c38ce3a96415","Topic":"Question.java","Question":"","Solution":"package Q10_01_Sorted_Merge;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\n\r\npublic class Question {\r\n\r\n\r\n\t/** Merges array\r\n\t * @param a first array\r\n\t * @param b second array\r\n\t * @param lastA number of \"real\" elements in a\r\n\t * @param lastB number of \"real\" elements in b\r\n\t */\r\n\tpublic static void merge(int[] a, int[] b, int lastA, int lastB) {\r\n\t\tint indexMerged = lastB + lastA - 1; /* Index of last location of merged array */\r\n\t\tint indexA = lastA - 1; /* Index of last element in array b */\r\n\t\tint indexB = lastB - 1; /* Index of last element in array a */\r\n\t\r\n\t\t/* Merge a and b, starting from the last element in each */\r\n\t\twhile (indexB >= 0) {\r\n\t\t\tif (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */\r\n\t\t\t\ta[indexMerged] = a[indexA]; // copy element\r\n\t\t\t\tindexA--; \r\n\t\t\t} else {\r\n\t\t\t\ta[indexMerged] = b[indexB]; // copy element\r\n\t\t\t\tindexB--;\r\n\t\t\t}\r\n\t\t\tindexMerged--; // move indices\t\t\t\r\n\t\t}\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};\r\n\t\tint[] b = {1, 4, 7, 6, 7, 7};\r\n\t\tmerge(a, b, 8, 6);\r\n\t\tSystem.out.println(AssortedMethods.arrayToString(a));\r\n\t}\r\n\r\n}\r\n","Chapter":"Q10_01_Sorted_Merge"}