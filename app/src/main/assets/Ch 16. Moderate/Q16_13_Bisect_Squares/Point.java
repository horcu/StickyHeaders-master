{"Id":"386cb148-cdaf-4c98-8af8-fdd80f8e71d8","Topic":"Point.java","Question":"","Solution":"package Q16_13_Bisect_Squares;\r\n\r\npublic class Point {\r\n\tpublic double x;\r\n\tpublic double y;\r\n\tpublic Point(double x, double y) {\r\n\t\tthis.x = x;\r\n\t\tthis.y = y;\r\n\t}\r\n\t\r\n\tpublic boolean isEqual(Point p) {\r\n\t\treturn (p.x == x && p.y == y);\r\n\t}\r\n\t\r\n\tpublic String toString() {\r\n\t\treturn \"(\" + x + \", \" + y + \")\";\r\n\t}\r\n}\r\n","Chapter":"Q16_13_Bisect_Squares"}