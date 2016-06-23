{"Id":"464ba226-37c3-4ddc-8811-0c29eebd6dee","Topic":"QuestionA.java","Question":"","Solution":"package Q10_07_Missing_Int;\r\n\r\nimport java.io.FileNotFoundException;\r\nimport java.io.FileReader;\r\nimport java.io.IOException;\r\nimport java.util.Scanner;\r\n\r\npublic class QuestionA {\r\n\tpublic static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;\r\n\tpublic static byte[] bitfield = new byte [(int) (numberOfInts / 8)];\r\n\t\r\n\tpublic static void findOpenNumber() throws FileNotFoundException {\r\n\t\tScanner in = new Scanner(new FileReader(\"Ch 10. Sorting and Searching/Q10_07_Missing_Int/input.txt\"));\r\n\t\twhile (in.hasNextInt()) {\r\n\t\t\tint n = in.nextInt ();\r\n\t\t\t/* Finds the corresponding number in the bitfield by using\r\n\t\t\t * the OR operator to set the nth bit of a byte \r\n\t\t\t * (e.g., 10 would correspond to bit 2 of index 1 in\r\n\t\t\t * the byte array). */\r\n\t\t\tbitfield [n / 8] |= 1 << (n % 8);\r\n\t\t}\r\n\r\n\t\tfor (int i = 0; i < bitfield.length; i++) {\r\n\t\t\tfor (int j = 0; j < 8; j++) {\r\n\t\t\t\t/* Retrieves the individual bits of each byte. When 0 bit\r\n\t\t\t\t * is found, finds the corresponding value. */\r\n\t\t\t\tif ((bitfield[i] & (1 << j)) == 0) {\r\n\t\t\t\t\tSystem.out.println (i * 8 + j);\r\n\t\t\t\t\treturn;\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\t\t\r\n\t}\r\n\r\n\tpublic static void main(String[] args)  throws IOException {\r\n\t\tfindOpenNumber();\r\n\t}\r\n\r\n}\r\n","Chapter":"Q10_07_Missing_Int"}