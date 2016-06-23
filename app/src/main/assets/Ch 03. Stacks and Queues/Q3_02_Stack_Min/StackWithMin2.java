{"Id":"1ddcfba0-d03a-46a8-8540-51132f83286e","Topic":"StackWithMin2.java","Question":"","Solution":"package Q3_02_Stack_Min;\r\n\r\nimport java.util.Stack;\r\n\r\npublic class StackWithMin2 extends Stack<Integer> {\r\n\tStack<Integer> s2;\r\n\t\r\n\tpublic StackWithMin2() {\r\n\t\ts2 = new Stack<Integer>();\t\t\r\n\t}\r\n\t\r\n\tpublic void push(int value){\r\n\t\tif (value <= min()) {\r\n\t\t\ts2.push(value);\r\n\t\t}\r\n\t\tsuper.push(value);\r\n\t}\r\n\t\r\n\tpublic Integer pop() {\r\n\t\tint value = super.pop();\r\n\t\tif (value == min()) {\r\n\t\t\ts2.pop();\t\t\t\r\n\t\t}\r\n\t\treturn value;\r\n\t}\r\n\t\r\n\tpublic int min() {\r\n\t\tif (s2.isEmpty()) {\r\n\t\t\treturn Integer.MAX_VALUE;\r\n\t\t} else {\r\n\t\t\treturn s2.peek();\r\n\t\t}\r\n\t}\r\n}\r\n\r\n\r\n","Chapter":"Q3_02_Stack_Min"}