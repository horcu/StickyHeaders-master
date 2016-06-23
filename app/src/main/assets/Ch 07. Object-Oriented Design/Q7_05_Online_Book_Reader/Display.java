{"Id":"81f79a6b-84d3-47de-9cc6-77a030d36ff9","Topic":"Display.java","Question":"","Solution":"package Q7_05_Online_Book_Reader;\r\n\r\npublic class Display {\r\n\tprivate Book activeBook;\r\n\tprivate User activeUser;\r\n\tprivate int pageNumber = 0;\r\n\t\r\n\tpublic void displayUser(User user) {\r\n\t\tactiveUser = user;\r\n\t\trefreshUsername();\r\n\t}\r\n\t\r\n\tpublic void displayBook(Book book) {\r\n\t\tpageNumber = 0;\r\n\t\tactiveBook = book;\r\n\t\t\r\n\t\trefreshTitle();\r\n\t\trefreshDetails();\r\n\t\trefreshPage();\r\n\t}\r\n\t\r\n\tpublic void refreshUsername() {\r\n\t\t/* updates username display */\r\n\t}\r\n\t\r\n\tpublic void refreshTitle() {\r\n\t\t/* updates title display */\r\n\t}\r\n\t\r\n\tpublic void refreshDetails() {\r\n\t\t/* updates details display */\r\n\t}\r\n\t\r\n\tpublic void refreshPage() {\r\n\t\t/* updated page display */\r\n\t}\r\n\t\r\n\tpublic void turnPageForward() {\r\n\t\tpageNumber++;\r\n\t\trefreshPage();\r\n\t}\r\n\t\r\n\tpublic void turnPageBackward() {\r\n\t\tpageNumber--;\r\n\t\trefreshPage();\r\n\t}\t\r\n}\r\n","Chapter":"Q7_05_Online_Book_Reader"}