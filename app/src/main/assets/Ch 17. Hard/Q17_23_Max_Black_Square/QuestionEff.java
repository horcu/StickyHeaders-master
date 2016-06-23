{"Id":"2a54c149-fd9e-4072-8474-a184a0284724","Topic":"QuestionEff.java","Question":"","Solution":"package Q17_23_Max_Black_Square;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\n\r\npublic class QuestionEff {\r\n\tpublic static Subsquare findSquareWithSize(SquareCell[][] processed, int square_size) {\r\n\t\t// On an edge of length N, there are (N - sz + 1) squares of length sz.\r\n\t\tint count = processed.length - square_size + 1; \r\n\t\t\r\n\t\t// Iterate through all squares with side length square_size.\r\n\t\tfor (int row = 0; row < count; row++) {\r\n\t\t\tfor (int col = 0; col < count; col++) {\r\n\t\t\t\tif (isSquare(processed, row, col, square_size)) {\r\n\t\t\t\t\treturn new Subsquare(row, col, square_size);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn null;\r\n\t}\r\n\t\r\n\tpublic static Subsquare findSquare(int[][] matrix){\r\n\t\tassert(matrix.length > 0);\r\n\t\tfor (int row = 0; row < matrix.length; row++){\r\n\t\t\tassert(matrix[row].length == matrix.length);\r\n\t\t}\r\n\t\t\r\n\t\tSquareCell[][] processed = processSquare(matrix);\r\n\t\t\r\n\t\tint N = matrix.length;\r\n\t\t\r\n\t\tfor (int i = N; i >= 1; i--) {\r\n\t\t\tSubsquare square = findSquareWithSize(processed, i);\r\n\t\t\tif (square != null) {\r\n\t\t\t\treturn square;\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn null;\r\n\t}\t\r\n\r\n\tprivate static boolean isSquare(SquareCell[][] matrix, int row, int col, int size) {\r\n\t\tSquareCell topLeft = matrix[row][col];\r\n\t\tSquareCell topRight = matrix[row][col + size - 1];\r\n\t\tSquareCell bottomRight = matrix[row + size - 1][col];\r\n\t\tif (topLeft.zerosRight < size) { // Check top edge\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tif (topLeft.zerosBelow < size) { // Check left edge\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tif (topRight.zerosBelow < size) { // Check right edge\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tif (bottomRight.zerosRight < size) { // Check bottom edge\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\treturn true;\r\n\t}\r\n\t\r\n\tpublic static SquareCell[][] processSquare(int[][] matrix) {\r\n\t\tSquareCell[][] processed = new SquareCell[matrix.length][matrix.length];\r\n\t\t\r\n\t\tfor (int r = matrix.length - 1; r >= 0; r--) {\r\n\t\t\tfor (int c = matrix.length - 1; c >= 0; c--) {\r\n\t\t\t\tint rightZeros = 0;\r\n\t\t\t\tint belowZeros = 0;\r\n\t\t\t\tif (matrix[r][c] == 0) { // only need to process if it's a black cell\r\n\t\t\t\t\trightZeros++;\r\n\t\t\t\t\tbelowZeros++;\r\n\t\t\t\t\tif (c + 1 < matrix.length) { // next column over is on same row\r\n\t\t\t\t\t\tSquareCell previous = processed[r][c + 1];\r\n\t\t\t\t\t\trightZeros += previous.zerosRight;\r\n\t\t\t\t\t}\r\n\t\t\t\t\tif (r + 1 < matrix.length) {\r\n\t\t\t\t\t\tSquareCell previous = processed[r + 1][c];\r\n\t\t\t\t\t\tbelowZeros += previous.zerosBelow;\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\tprocessed[r][c] = new SquareCell(rightZeros, belowZeros);\r\n\t\t\t}\r\n\t\t}\t\r\n\t\treturn processed;\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint[][] matrix = AssortedMethods.randomMatrix(7, 7, 0, 1);\r\n\t\tAssortedMethods.printMatrix(matrix);\r\n\t\tSubsquare square = findSquare(matrix);\r\n\t\tsquare.print();\r\n\t}\r\n}\r\n","Chapter":"Q17_23_Max_Black_Square"}