{"Id":"241d91ed-0fbe-460f-88bb-2702926ab5fe","Topic":"Motorcycle.java","Question":"","Solution":"package Q7_04_Parking_Lot;\r\n\r\npublic class Motorcycle extends Vehicle {\r\n\tpublic Motorcycle() {\r\n\t\tspotsNeeded = 1;\r\n\t\tsize = VehicleSize.Motorcycle;\r\n\t}\r\n\t\r\n\tpublic boolean canFitInSpot(ParkingSpot spot) {\r\n\t\treturn true;\r\n\t}\r\n\t\r\n\tpublic void print() {\r\n\t\tSystem.out.print(\"M\");\r\n\t}\t\r\n}\r\n","Chapter":"Q7_04_Parking_Lot"}