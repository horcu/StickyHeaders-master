{"Id":"411c678b-2f45-407e-a157-db5940fe6fe3","Topic":"PrivateChat.java","Question":"","Solution":"package Q7_07_Chat_Server;\r\n\r\npublic class PrivateChat extends Conversation {\r\n\tpublic PrivateChat(User user1, User user2) {\r\n\t\tparticipants.add(user1);\r\n\t\tparticipants.add(user2);\r\n\t}\r\n\t\r\n\tpublic User getOtherParticipant(User primary) {\r\n\t\tif (participants.get(0) == primary) {\r\n\t\t\treturn participants.get(1);\r\n\t\t} else if (participants.get(1) == primary) {\r\n\t\t\treturn participants.get(0);\r\n\t\t}\r\n\t\treturn null;\r\n\t}\r\n}\r\n","Chapter":"Q7_07_Chat_Server"}