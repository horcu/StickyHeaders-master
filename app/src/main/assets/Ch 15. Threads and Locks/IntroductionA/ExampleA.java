{"Id":"c5edcd58-4e4d-4aa7-9388-1641cda76057","Topic":"ExampleA.java","Question":"","Solution":"package IntroductionA;\r\n\r\npublic class ExampleA {\r\n\r\n\tpublic static void main(String[] args) {\r\n\t\tRunnableThreadExample instance = new RunnableThreadExample();\r\n\t\tThread thread = new Thread(instance);\r\n\t\tthread.start();\r\n\t\t\r\n\t\t/* waits until earlier thread counts to 5 (slowly) */\r\n\t\twhile (instance.count != 5) {\t\t\r\n\t\t\ttry {\r\n\t\t\t\tThread.sleep(250);\r\n\t\t\t} catch (InterruptedException exc) {\r\n\t\t\t\texc.printStackTrace();\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\tSystem.out.println(\"Program Terminating.\");\r\n\t}\r\n}\r\n","Chapter":"IntroductionA"}