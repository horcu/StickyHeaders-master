{"Id":"2f1d2338-a09d-4be9-8d9a-81a98c652a10","Topic":"Person.java","Question":"","Solution":"package Q9_02_Social_Network;\r\n\r\nimport java.util.ArrayList;\r\n\r\npublic class Person {\r\n\tprivate ArrayList<Integer> friends = new ArrayList<Integer>();\r\n\tprivate int personID;\r\n\tprivate String info;\r\n\t\r\n\tpublic String getInfo() { return info; }\r\n\tpublic void setInfo(String info) {\r\n\t\tthis.info = info;\r\n\t}\r\n\r\n\tpublic ArrayList<Integer> getFriends() {\r\n\t\treturn friends;\r\n\t}\r\n\t\r\n\tpublic int getID() { return personID; }\r\n\tpublic void addFriend(int id) { friends.add(id); }\r\n\t\r\n\tpublic Person(int id) {\r\n\t\tthis.personID = id;\r\n\t}\r\n}\r\n","Chapter":"Q9_02_Social_Network"}