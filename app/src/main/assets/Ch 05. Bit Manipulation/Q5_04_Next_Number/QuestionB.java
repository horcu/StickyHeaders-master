{"Id":"96a80809-171e-4e67-8668-f26de2995504","Topic":"QuestionB.java","Question":"","Solution":"package Q5_04_Next_Number;\r\n\r\npublic class QuestionB {\r\n\t\r\n\tpublic static int getNext(int n) {\r\n\t\tint c = n;\r\n\t\tint c0 = 0;\r\n\t\tint c1 = 0;\r\n\t\twhile (((c & 1) == 0) && (c != 0)) {\r\n\t\t\tc0++;\r\n\t\t\tc >>= 1;\r\n\t\t}\r\n\t\t\r\n\t\twhile ((c & 1) == 1) {\r\n\t\t\tc1++;\r\n\t\t\tc >>= 1;\r\n\t\t}\r\n\t\t\r\n\t\t/* If c is 0, then n is a sequence of 1s followed by a sequence of 0s. This is already the biggest\r\n\t\t * number with c1 ones. Return error.\r\n\t\t */\r\n\t\tif (c0 + c1 == 31 || c0 + c1 == 0) {\r\n\t\t\treturn -1;\r\n\t\t}\r\n\t\t\r\n\t\tint pos = c0 + c1; // position of right-most non-trailing zero (where the right most bit is bit 0)\r\n\t\t\r\n\t\t/* Flip the right-most non-trailing zero (which will be at position pos) */\r\n\t\tn |= (1 << pos); // Flip right-most non-trailing zero\r\n\t\t\t\t\r\n\t\t/* Clear all bits to the right of pos.\r\n\t\t * Example with pos = 5 \r\n\t\t * (1) Shift 1 over by 5 to create 0..0100000           [ mask = 1 << pos ]\r\n\t\t * (2) Subtract 1 to get 0..0011111                     [ mask = mask - 1 ]\r\n\t\t * (3) Flip all the bits by using '~' to get 1..1100000 [ mask = ~mask    ]\r\n\t\t * (4) AND with n\r\n\t\t */\r\n\t\tn &= ~((1 << pos) - 1); // Clear all bits to the right of pos\r\n\t\t\r\n\t\t/* Put (ones-1) 1s on the right by doing the following:\r\n\t\t * (1) Shift 1 over by (ones-1) spots. If ones = 3, this gets you 0..0100\r\n\t\t * (2) Subtract one from that to get 0..0011\r\n\t\t * (3) OR with n\r\n\t\t */\r\n\t\tn |= (1 << (c1 - 1)) - 1;\r\n\t\t\r\n\t\treturn n;\r\n\t}\r\n\t\r\n\tpublic static int getPrev(int n) {\r\n\t\tint temp = n;\r\n\t\tint c0 = 0;\r\n\t\tint c1 = 0;\r\n\t\twhile ((temp & 1) == 1) {\r\n\t\t\tc1++;\r\n\t\t\ttemp >>= 1;\r\n\t\t}\r\n\t\t\r\n\t\t/* If temp is 0, then the number is a sequence of 0s followed by a sequence of 1s. This is already\r\n\t\t * the smallest number with c1 ones. Return -1 for an error.\r\n\t\t */\r\n\t\tif (temp == 0) { \r\n\t\t\treturn -1;\r\n\t\t}\r\n\t\t\r\n\t\twhile (((temp & 1) == 0) && (temp != 0)) {\r\n\t\t\tc0++;\r\n\t\t\ttemp >>= 1;\r\n\t\t}\r\n\r\n\t\tint p = c0 + c1; // position of right-most non-trailing one (where the right most bit is bit 0)\r\n\r\n\t\t/* Flip right-most non-trailing one. \r\n\t\t * Example: n = 00011100011.\r\n\t\t * c1 = 2\r\n\t\t * c0 = 3\r\n\t\t * pos = 5\r\n\t\t * \r\n\t\t * Build up a mask as follows:\r\n\t\t * (1) ~0 will be a sequence of 1s\r\n\t\t * (2) shifting left by p + 1 will give you 11.111000000 (six 0s) \r\n\t\t * (3) ANDing with n will clear the last 6 bits\r\n\t\t * n is now 00011000000\r\n\t\t */\r\n\t\tn &= ((~0) << (p + 1)); // clears from bit p onwards (to the right)\r\n\t\t\r\n\t\t/* Create a sequence of (c1+1) 1s as follows\r\n\t\t * (1) Shift 1 to the left (c1+1) times. If c1 is 2, this will give you 0..001000\r\n\t\t * (2) Subtract one from that. This will give you 0..00111\r\n\t\t */\r\n\t\tint mask = (1 << (c1 + 1)) - 1; // Sequence of (c1+1) ones\r\n\t\t\r\n\t\t/* Move the ones to be right up next to bit p \r\n\t\t * Since this is a sequence of (c1+1) ones, and p = c1 + c0, we just need to\r\n\t\t * shift this over by (c0-1) spots.\r\n\t\t * If c0 = 3 and c1 = 2, then this will look like 00...0011100\r\n\t\t * \r\n\t\t * Then, finally, we OR this with n.\r\n\t\t */\r\n\t\tn |= mask << (c0 - 1);  \r\n\t\t\r\n\t\treturn n;\t\t\r\n\t}\t\r\n\t\r\n\tpublic static void binPrint(int i) {\r\n\t\tSystem.out.println(i + \": \" + Integer.toBinaryString(i));\t\t\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint i = 13948;\r\n\t\tint p1 = getPrev(i);\r\n\t\tint n1 = getNext(i);\r\n\t\tTester.binPrint(p1);\r\n\t\tTester.binPrint(n1);\r\n\t}\r\n\r\n}\r\n","Chapter":"Q5_04_Next_Number"}