{"Id":"0eb0b9e2-d397-4e71-a2df-dadcc237e230","Topic":"QuestionC.java","Question":"","Solution":"package Q16_04_Tic_Tac_Win;\r\n\r\nimport CtCILibrary.AssortedMethods;\r\n\r\npublic class QuestionC {\r\n\tpublic static boolean hasWinner(Piece p1, Piece p2, Piece p3) {\r\n\t\tif (p1 == Piece.Empty) {\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\treturn p1 == p2 && p2 == p3;\r\n\t}\r\n\t\r\n\tpublic static Piece hasWon(Piece[][] board) {\r\n\t\tfor (int i = 0; i < board.length; i++) {\r\n\t\t\t/* Check Rows */\r\n\t\t\tif (hasWinner(board[i][0], board[i][1], board[i][2])) {\r\n\t\t\t\treturn board[i][0];\r\n\t\t\t}\r\n\r\n\t\t\t/* Check Columns */\r\n\t\t\tif (hasWinner(board[0][i], board[1][i], board[2][i])) {\r\n\t\t\t\treturn board[0][i];\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\t/* Check Diagonal */\r\n\t\tif (hasWinner(board[0][0], board[1][1], board[2][2])) {\r\n\t\t\treturn board[0][0];\r\n\t\t}\r\n\t\t\r\n\t\tif (hasWinner(board[0][2], board[1][1], board[2][0])) {\r\n\t\t\treturn board[0][2];\r\n\t\t}\r\n\t\t\r\n\t\treturn Piece.Empty;\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint N = 3;\r\n\t\tint[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);\r\n\t\tPiece[][] board = new Piece[N][N];\r\n\t\tfor (int i = 0; i < N; i++) {\r\n\t\t\tfor (int j = 0; j < N; j++) {\r\n\t\t\t\tint x = board_t[i][j];\r\n\t\t\t\tboard[i][j] = Tester.convertIntToPiece(x);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\tPiece p1 = hasWon(board);\r\n\t\t\r\n\t\tSystem.out.println(p1);\r\n\t\tAssortedMethods.printMatrix(board_t);\r\n\t}\r\n\r\n}\r\n","Chapter":"Q16_04_Tic_Tac_Win"}