{"Id":"f09a708e-eb55-400a-a732-b63187b7373f","Topic":"Question.java","Question":"","Solution":"package Q7_06_Jigsaw;\n\nimport java.util.LinkedList;\nimport java.util.Random;\n\npublic class Question {\n\n\t\n\tpublic static Edge createRandomEdge(String code) {\n\t\tRandom random = new Random();\n\t\tShape type = Shape.INNER;\n\t\tif (random.nextBoolean()) {\n\t\t\ttype = Shape.OUTER;\n\t\t}\n\t\treturn new Edge(type, code);\n\t}\t\n\t\n\tpublic static Edge[] createEdges(Piece[][] puzzle, int column, int row) {\n\t\tString key = column + \":\" + row + \":\";\n\t\t/* Get left edge */\n\t\tEdge left = column == 0 ? new Edge(Shape.FLAT, key + \"h|e\") : puzzle[row][column - 1].getEdgeWithOrientation(Orientation.RIGHT)._createMatchingEdge();\n\t\t\n\t\t/* Get top edge */\n\t\tEdge top = row == 0 ? new Edge(Shape.FLAT, key + \"v|e\") : puzzle[row - 1][column].getEdgeWithOrientation(Orientation.BOTTOM)._createMatchingEdge();\n\t\t\n\t\t/* Get right edge */\n\t\tEdge right = column == puzzle[row].length - 1 ? new Edge(Shape.FLAT, key + \"h|e\") : createRandomEdge(key + \"h\");\n\t\t\n\t\t/* Get bottom edge */\n\t\tEdge bottom = row == puzzle.length - 1 ? new Edge(Shape.FLAT, key + \"v|e\") : createRandomEdge(key + \"v\");\n\t\t\n\t\tEdge[] edges = {left, top, right, bottom};\n\t\treturn edges;\n\t}\n\t\n\tpublic static LinkedList<Piece> initializePuzzle(int size) {\n\t\t/* Create completed puzzle. */\n\t\tPiece[][] puzzle = new Piece[size][size];\n\t\tfor (int row = 0; row < size; row++) {\n\t\t\tfor (int column = 0; column < size; column++) {\n\t\t\t\tEdge[] edges = createEdges(puzzle, column, row);\n\t\t\t\tpuzzle[row][column] = new Piece(edges);\n\t\t\t}\n\t\t}\n\n\t\t/* Shuffle and rotate pieces. */\n\t\tLinkedList<Piece> pieces = new LinkedList<Piece>();\n\t\tRandom r = new Random();\n\t\tfor (int row = 0; row < size; row++) {\n\t\t\tfor (int column = 0; column < size; column++) {\n\t\t\t\tint rotations = r.nextInt(4);\n\t\t\t\tPiece piece = puzzle[row][column];\n\t\t\t\tpiece.rotateEdgesBy(rotations);\n\t\t\t\tint index = pieces.size() == 0 ? 0 : r.nextInt(pieces.size());\n\t\t\t\tpieces.add(index, piece);\n\t\t\t}\n\t\t}\n\t\t\n\t\treturn pieces;\n\t}\t\n\t\n\tpublic static String solutionToString(Piece[][] solution) {\n\t\tStringBuilder sb = new StringBuilder();\n\t\tfor (int h = 0; h < solution.length; h++) {\n\t\t\tfor (int w = 0; w < solution[h].length; w++) {\n\t\t\t\tPiece p = solution[h][w];\n\t\t\t\tif (p == null) {\n\t\t\t\t\tsb.append(\"null\");\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tsb.append(p.toString());\n\t\t\t\t}\n\t\t\t}\n\t\t\tsb.append(\"\\n\");\n\t\t}\n\t\treturn sb.toString();\n\t}\t\n\t\n\t/* Used for testing. Check if puzzle is solved. */\t\n\tpublic static boolean validate(Piece[][] solution) {\n\t\tif (solution == null) return false;\n\t\tfor (int r = 0; r < solution.length; r++) {\n\t\t\tfor (int c = 0; c < solution[r].length; c++) {\n\t\t\t\tPiece piece = solution[r][c];\n\t\t\t\tif (piece == null) return false;\n\t\t\t\tif (c > 0) { /* match left */\n\t\t\t\t\tPiece left = solution[r][c-1];\n\t\t\t\t\tif (!left.getEdgeWithOrientation(Orientation.RIGHT).fitsWith(piece.getEdgeWithOrientation(Orientation.LEFT))) {\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif (c < solution[r].length - 1) { /* match right */\n\t\t\t\t\tPiece right = solution[r][c+1];\n\t\t\t\t\tif (!right.getEdgeWithOrientation(Orientation.LEFT).fitsWith(piece.getEdgeWithOrientation(Orientation.RIGHT))) {\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif (r > 0) { /* match top */\n\t\t\t\t\tPiece top = solution[r-1][c];\n\t\t\t\t\tif (!top.getEdgeWithOrientation(Orientation.BOTTOM).fitsWith(piece.getEdgeWithOrientation(Orientation.TOP))) {\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif (r < solution.length - 1) { /* match bottom */\n\t\t\t\t\tPiece bottom = solution[r+1][c];\n\t\t\t\t\tif (!bottom.getEdgeWithOrientation(Orientation.TOP).fitsWith(piece.getEdgeWithOrientation(Orientation.BOTTOM))) {\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn true;\n\t}\n\t\n\tpublic static boolean testSize(int size) {\n\t\tLinkedList<Piece> pieces = initializePuzzle(size);\n\t\tPuzzle puzzle = new Puzzle(size, pieces);\n\t\tpuzzle.solve();\n\t\tPiece[][] solution = puzzle.getCurrentSolution();\n\t\tSystem.out.println(solutionToString(solution));\n\t\tboolean result = validate(solution);\n\t\tSystem.out.println(result);\n\t\treturn result;\n\t}\n\t\n\t\n\tpublic static void main(String[] args) {\n\t\tfor (int size = 1; size < 10; size++) {\n\t\t\tif (!testSize(size)) {\n\t\t\t\tSystem.out.println(\"ERROR: \" + size);\n\t\t\t}\n\t\t}\n\t\t\n\t}\n\n}\n","Chapter":"Q7_06_Jigsaw"}