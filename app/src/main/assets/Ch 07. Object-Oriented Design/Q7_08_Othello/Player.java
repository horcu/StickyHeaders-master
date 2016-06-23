{"Id":"96ce5a7b-020e-400d-bb10-ee3f421fc46e","Topic":"Player.java","Question":"","Solution":"package Q7_08_Othello;\r\n\r\npublic class Player {\r\n\tprivate Color color;\r\n\tpublic Player(Color c) {\r\n\t\tcolor = c;\r\n\t}\r\n\t\r\n\tpublic int getScore() {\r\n\t\treturn Game.getInstance().getBoard().getScoreForColor(color);\r\n\t}\r\n\t\r\n\tpublic boolean playPiece(int row, int column) {\r\n\t\treturn Game.getInstance().getBoard().placeColor(row, column, color);\r\n\t}\r\n\t\r\n\tpublic Color getColor() {\r\n\t\treturn color;\r\n\t}\r\n}\r\n","Chapter":"Q7_08_Othello"}