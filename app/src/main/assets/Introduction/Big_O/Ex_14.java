{"Id":"d9b63c7b-ef60-4716-8956-a4f416bab122","Topic":"Ex_14.java","Question":"","Solution":"package Big_O;\n\npublic class Ex_14 {\n\tpublic static boolean isPrime(int n) {\n\t    for (int x = 2; x * x <= n; x++) {\n\t        if (n % x == 0) {\n\t            return false;\n\t        }\n\t    }\n\t    return true;\n\t}\n\t\n\tpublic static void main(String[] args) {\n\t\tint[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10};\n\t\tfor (int x : array) {\n\t\t\tboolean isPrimeNumber = isPrime(x);\n\t\t\tif (isPrimeNumber) {\n\t\t\t\tSystem.out.println(x + \": prime\");\n\t\t\t} else {\n\t\t\t\tSystem.out.println(x + \": not prime\");\n\t\t\t}\n\t\t}\n\t}\t\n}\n","Chapter":"Big_O"}