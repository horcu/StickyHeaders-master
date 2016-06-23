{"Id":"c8baaded-9971-4b83-a081-71ea7075b369","Topic":"FibonacciA.java","Question":"","Solution":"package Introduction;\r\n\r\npublic class FibonacciA {\r\n\tpublic static int fibonacci(int i) {\r\n\t\tif (i == 0) {\r\n\t\t\treturn 0;\r\n\t\t}\r\n\t\tif (i == 1) {\r\n\t\t\treturn 1;\r\n\t\t}\r\n\t\treturn fibonacci(i - 1) + fibonacci(i - 2);\r\n\t}\r\n\t\r\n\t/**\r\n\t * @param args\r\n\t */\r\n\tpublic static void main(String[] args) {\r\n\t\tint max = 35; // WARNING: If you make this above 40ish, your computer may serious slow down.\r\n\t\tint trials = 10; // Run code multiple times to compute average time.\r\n\t\tdouble[] times = new double[max]; // Store times\r\n\t\t\r\n\t\t\r\n\t\tfor (int j = 0; j < trials; j++) { // Run this 10 times to compute\r\n\t\t\tfor (int i = 0; i < max; i++) {\r\n\t\t\t\tlong start = System.currentTimeMillis();\r\n\t\t\t\tfibonacci(i);\r\n\t\t\t\tlong end = System.currentTimeMillis();\r\n\t\t\t\tlong time = end - start;\r\n\t\t\t\ttimes[i] += time; \r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\tfor (int j = 0; j < max; j++) {\r\n\t\t\tSystem.out.println(j + \": \" + times[j] / trials + \"ms\");\r\n\t\t}\r\n\t}\r\n\r\n}\r\n","Chapter":"Introduction"}