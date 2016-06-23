{"Id":"6de06505-720b-40a4-81da-0e05369230a0","Topic":"QuestionB.java","Question":"","Solution":"package Q8_01_Triple_Step;\r\n\r\nimport java.util.Arrays;\r\n\r\npublic class QuestionB {\r\n\r\n\tpublic static int countWays(int n) {\r\n\t\tint[] map = new int[n + 1];\r\n\t\tArrays.fill(map, -1);\r\n\t\treturn countWays(n, map);\r\n\t}\r\n\t\r\n\tpublic static int countWays(int n, int[] memo) {\r\n\t\tif (n < 0) {\r\n\t\t\treturn 0;\r\n\t\t} else if (n == 0) {\r\n\t\t\treturn 1;\r\n\t\t} else if (memo[n] > -1) {\r\n\t\t\treturn memo[n];\r\n\t\t} else {\r\n\t\t\tmemo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);\r\n\t\t\treturn memo[n];\r\n\t\t}\r\n\t}\r\n\t\r\n\tpublic static void main(String[] args) {\r\n\t\tint n = 50;\r\n\t\tint ways = countWays(n);\r\n\t\tSystem.out.println(ways);\r\n\t}\r\n\r\n}\r\n","Chapter":"Q8_01_Triple_Step"}