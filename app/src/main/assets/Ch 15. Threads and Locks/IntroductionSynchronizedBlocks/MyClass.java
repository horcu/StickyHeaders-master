{"Id":"d6374d79-d984-49e6-bc5a-67deb52cf765","Topic":"MyClass.java","Question":"","Solution":"package IntroductionSynchronizedBlocks;\r\n\r\npublic class MyClass extends Thread  {\r\n\tprivate String name;\r\n\tprivate MyObject myObj;\r\n\t\r\n\tpublic MyClass(MyObject obj, String n) {\r\n\t\tname = n;\r\n\t\tmyObj = obj;\r\n\t}\r\n\t\r\n\tpublic void run() {\r\n\t\tmyObj.foo(name);\r\n\t}\r\n}\r\n","Chapter":"IntroductionSynchronizedBlocks"}