{"Id":"5224c84c-d5cc-4230-84c4-689c41416e10","Topic":"Question.java","Question":"","Solution":"package Q8_10_Paint_Fill;\r\n\r\npublic class Question {\r\n\r\n\tpublic enum Color {\r\n\t\tBlack, White, Red, Yellow, Green\r\n\t}\r\n\t\r\n\tpublic static String PrintColor(Color c) {\r\n\t\tswitch(c) {\r\n\t\tcase Black:\r\n\t\t\treturn \"B\";\r\n\t\tcase White:\r\n\t\t\treturn \"W\";\r\n\t\tcase Red:\r\n\t\t\treturn \"R\";\r\n\t\tcase Yellow:\r\n\t\t\treturn \"Y\";\r\n\t\tcase Green:\r\n\t\t\treturn \"G\";\r\n\t\t}\r\n\t\treturn \"X\";\r\n\t}\r\n\t\r\n\tpublic static void PrintScreen(Color[][] screen) {\r\n\t\tfor (int r = 0; r < screen.length; r++) {\r\n\t\t\tfor (int c = 0; c < screen[0].length; c++) {\r\n\t\t\t\tSystem.out.print(PrintColor(screen[r][c]));\r\n\t\t\t}\r\n\t\t\tSystem.out.println();\r\n\t\t}\r\n\t}\r\n\t\r\n\tpublic static int randomInt(int n) {\r\n\t\treturn (int) (Math.random() * n);\r\n\t}\r\n\t\r\n\tpublic static boolean PaintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {\r\n\t\tif (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tif (screen[r][c] == ocolor) {\r\n\t\t\tscreen[r][c] = ncolor;\r\n\t\t\tPaintFill(screen, r - 1, c, ocolor, ncolor); // up\r\n\t\t\tPaintFill(screen, r + 1, c, ocolor, ncolor); // down\r\n\t\t\tPaintFill(screen, r, c - 1, ocolor, ncolor); // left\r\n\t\t\tPaintFill(screen, r, c + 1, ocolor, ncolor); // right\r\n\t\t}\r\n\t\treturn true;\r\n\t}\r\n\t\r\n\tpublic static boolean PaintFill(Color[][] screen, int r, int c, Color ncolor) {\r\n\t\tif (screen[r][c] == ncolor) return false;\r\n\t\treturn PaintFill(screen, r, c, screen[r][c], ncolor);\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint N = 10;\r\n\t\tColor[][] screen = new Color[N][N];\r\n\t\tfor (int i = 0; i < N; i++) {\r\n\t\t\tfor (int j = 0; j < N; j++) {\r\n\t\t\t\tscreen[i][j] = Color.Black;\r\n\t\t\t}\t\t\t\r\n\t\t}\r\n\t\tfor (int i = 0; i < 100; i++) {\r\n\t\t\tscreen[randomInt(N)][randomInt(N)] = Color.Green;\r\n\t\t}\r\n\t\tPrintScreen(screen);\r\n\t\tPaintFill(screen, 2, 2, Color.White);\r\n\t\tSystem.out.println();\r\n\t\tPrintScreen(screen);\r\n\t}\r\n\r\n}\r\n","Chapter":"Q8_10_Paint_Fill"}