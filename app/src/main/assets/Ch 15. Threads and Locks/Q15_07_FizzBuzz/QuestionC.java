{"Id":"a7066bee-22e7-4ca5-974c-04c6af909a46","Topic":"QuestionC.java","Question":"","Solution":"package Q15_07_FizzBuzz;\n\npublic class QuestionC {\n\n\tpublic static void main(String[] args) {\n\t\tint n = 100;\n\t\tThread[] threads = {new FBThread(i -> i % 3 == 0 && i % 5 == 0, i -> \"FizzBuzz\", n), \n\t\t\t\t\t\t\tnew FBThread(i -> i % 3 == 0 && i % 5 != 0, i -> \"Fizz\", n),\n\t\t\t\t\t\t\tnew FBThread(i -> i % 3 != 0 && i % 5 == 0, i -> \"Buzz\", n),\n\t\t\t\t\t\t\tnew FBThread(i -> i % 3 != 0 && i % 5 != 0, i -> Integer.toString(i), n)};\n\t\tfor (Thread thread : threads) {\n\t\t\tthread.start();\n\t\t}\n\t}\n\n}\n","Chapter":"Q15_07_FizzBuzz"}