{"Id":"a0e74520-2dbd-4ba7-b021-95ce62138914","Topic":"MyThread.java","Question":"","Solution":"package Q15_05_Call_In_Order;\r\n\r\npublic class MyThread extends Thread {\r\n\tprivate String method;\r\n\tprivate FooBad foo;\r\n\t\r\n\tpublic MyThread(FooBad foo, String method) {\r\n\t\tthis.method = method;\r\n\t\tthis.foo = foo;\r\n\t}\r\n\t\r\n\tpublic void run() {\r\n\t\tif (method == \"first\") {\r\n\t\t\tfoo.first();\r\n\t\t} else if (method == \"second\") {\r\n\t\t\tfoo.second();\r\n\t\t} else if (method == \"third\") {\r\n\t\t\tfoo.third();\r\n\t\t}\r\n\t}\r\n}\r\n","Chapter":"Q15_05_Call_In_Order"}