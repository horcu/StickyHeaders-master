{"Id":"e52eec62-4554-4c31-92d0-4881ee0975d4","Topic":"User.java","Question":"","Solution":"package Q7_05_Online_Book_Reader;\r\n\r\npublic class User {\r\n\tprivate int userId;\r\n\tprivate String details;\r\n\tprivate int accountType;\r\n\t\r\n\tpublic void renewMembership() {  }\r\n\r\n\tpublic User(int id, String details, int accountType) {\r\n\t\tuserId = id;\r\n\t\tthis.details = details;\r\n\t\tthis.accountType = accountType;\r\n\t}\r\n\t\r\n\t/* getters and setters */\r\n\tpublic int getID() { return userId; }\r\n\tpublic void setID(int id) { userId = id; }\r\n\tpublic String getDetails() { return details; }\r\n\tpublic void setDetails(String details) { this.details = details; }\r\n\tpublic int getAccountType() { return accountType; }\r\n\tpublic void setAccountType(int accountType) { \r\n\t\tthis.accountType = accountType;\r\n\t}\r\n}\r\n\r\n","Chapter":"Q7_05_Online_Book_Reader"}