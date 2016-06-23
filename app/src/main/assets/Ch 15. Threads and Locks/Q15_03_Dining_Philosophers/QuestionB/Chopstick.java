{"Id":"b0612368-16a9-4e6b-a4b6-0af7bdea88d8","Topic":"Chopstick.java","Question":"","Solution":"package Q15_03_Dining_Philosophers.QuestionB;\r\n\r\nimport java.util.concurrent.locks.Lock;\r\nimport java.util.concurrent.locks.ReentrantLock;\r\n\r\npublic class Chopstick {\r\n\tprivate Lock lock;\r\n\tprivate int number;\r\n\t\r\n\tpublic Chopstick(int n) {\r\n\t\tlock = new ReentrantLock();\r\n\t\tthis.number = n;\r\n\t}\r\n\r\n\tpublic void pickUp() {\r\n\t\tlock.lock();\r\n\t}\r\n\t\r\n\tpublic void putDown() {\r\n\t\tlock.unlock();\t\r\n\t}\r\n\t\r\n\tpublic int getNumber() {\r\n\t\treturn number;\r\n\t}\r\n}\r\n","Chapter":"QuestionB"}