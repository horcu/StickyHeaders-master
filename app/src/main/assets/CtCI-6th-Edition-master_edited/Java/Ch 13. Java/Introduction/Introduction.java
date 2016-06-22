{"Id":"c4c1bb58-a99a-416e-a184-c4789d17a3cd","Topic":"Introduction.java","Question":"","Solution":"package Introduction;\r\n\r\npublic class Introduction {\r\n\tpublic static String lem() {\r\n\t\tSystem.out.println(\"lem\");\r\n\t\treturn \"return from lem\";\r\n\t}\r\n\t\r\n\tpublic static String foo() {\r\n\t\tint x = 0;\r\n\t\tint y = 5;\r\n\t\ttry\r\n\t\t{\r\n\t\t\tSystem.out.println(\"start try\");\r\n\t\t\tint b = y / x;\r\n\t\t\tSystem.out.println(\"end try\");\r\n\t\t\treturn \"returned from try\";\r\n\t\t} catch (Exception ex) {\r\n\t\t\tSystem.out.println(\"catch\");\r\n\t\t\treturn lem() + \" | returned from catch\";\r\n\t\t} finally {\r\n\t\t\tSystem.out.println(\"finally\");\t\r\n\t\t}\r\n\t}\r\n\t\r\n\tpublic static void bar() {\r\n\t\tSystem.out.println(\"start bar\");\r\n\t\tString v = foo();\r\n\t\tSystem.out.println(v);\r\n\t\tSystem.out.println(\"end bar\");\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tbar();\r\n\t}\r\n\r\n}\r\n","Chapter":"Introduction"}