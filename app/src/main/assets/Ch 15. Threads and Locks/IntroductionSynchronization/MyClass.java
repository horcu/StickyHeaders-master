{"Id":"43b7cc4b-b01c-4700-9bf5-54b4e8d701ae","Topic":"MyClass.java","Question":"","Solution":"package IntroductionSynchronization;\r\n\r\npublic class MyClass extends Thread  {\r\n\tprivate String name;\r\n\tprivate MyObject myObj;\r\n\t\r\n\tpublic MyClass(MyObject obj, String n) {\r\n\t\tname = n;\r\n\t\tmyObj = obj;\r\n\t}\r\n\t\r\n\tpublic void run() {\r\n\t\tif (name.equals(\"1\")) {\r\n\t\t\tMyObject.foo(name);\r\n\t\t} else if (name.equals(\"2\")) {\r\n\t\t\tMyObject.bar(name);\r\n\t\t}\r\n\t}\r\n}\r\n","Chapter":"IntroductionSynchronization"}