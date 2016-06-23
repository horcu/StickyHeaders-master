{"Id":"0cef9170-d9a3-4863-b0db-2e5151c2f54e","Topic":"Question.java","Question":"","Solution":"package Q17_04_Missing_Number;\r\n\r\nimport java.util.ArrayList;\r\nimport java.util.Random;\r\n\r\npublic class Question {\r\n    /* Create a random array of numbers from 0 to n, but skip 'missing' */\r\n    public static ArrayList<BitInteger> initialize(int n, int missing) {\r\n        BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();\r\n        ArrayList<BitInteger> array = new ArrayList<BitInteger>();\r\n        \r\n        for (int i = 1; i <= n; i++) {\r\n        \tarray.add(new BitInteger(i == missing ? 0 : i));\r\n        }\r\n\r\n        // Shuffle the array once.\r\n        for (int i = 0; i < n; i++){\r\n            int rand = i + (int) (Math.random() * (n-i));\r\n            array.get(i).swapValues(array.get(rand));\r\n        }\r\n        \r\n        return array;\r\n    }\r\n\r\n\r\n    public static int findMissing(ArrayList<BitInteger> array) {\r\n       return findMissing(array, BitInteger.INTEGER_SIZE - 1);\r\n    }        \r\n\r\n    private static int findMissing(ArrayList<BitInteger> input, int column) {\r\n    \tif (column < 0) { // Base case and error condition\r\n    \t\treturn 0;\r\n    \t}\r\n    \tArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size()/2);\r\n    \tArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input.size()/2);\r\n        for (BitInteger t : input) {\r\n            if (t.fetch(column) == 0) {\r\n                zeroBits.add(t);\r\n            } else {\r\n                oneBits.add(t);\r\n            }\r\n        }\r\n        if (zeroBits.size() <= oneBits.size()) {\r\n        \tint v = findMissing(zeroBits, column - 1);\r\n        \tSystem.out.print(\"0\");\r\n            return (v << 1) | 0;\r\n        } else {\r\n        \tint v = findMissing(oneBits, column - 1);\r\n        \tSystem.out.print(\"1\");\r\n            return (v << 1) | 1;\r\n        }\r\n    }\r\n\r\n    public static void main(String[] args) {\r\n        Random rand = new Random(); \r\n        int n = rand.nextInt(300000) + 1;\r\n        int missing = rand.nextInt(n+1);\r\n        ArrayList<BitInteger> array = initialize(n, missing);\r\n        System.out.println(\"The array contains all numbers but one from 0 to \" + n + \", except for \" + missing);\r\n        \r\n        int result = findMissing(array);\r\n        if (result != missing) {\r\n            System.out.println(\"Error in the algorithm!\\n\" + \"The missing number is \" + missing + \", but the algorithm reported \" + result);\r\n        } else {\r\n            System.out.println(\"The missing number is \" + result);\r\n        }\r\n    }\r\n}\r\n","Chapter":"Q17_04_Missing_Number"}