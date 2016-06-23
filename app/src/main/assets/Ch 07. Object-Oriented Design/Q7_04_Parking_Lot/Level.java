{"Id":"01200e26-6f27-4def-8504-a1ec0708eaa4","Topic":"Level.java","Question":"","Solution":"package Q7_04_Parking_Lot;\r\n\r\n/* Represents a level in a parking garage */\r\npublic class Level {\r\n\tprivate int floor;\r\n\tprivate ParkingSpot[] spots;\r\n\tprivate int availableSpots = 0; // number of free spots\r\n\tprivate static final int SPOTS_PER_ROW = 10;\r\n\t\r\n\tpublic Level(int flr, int numberSpots) {\r\n\t\tfloor = flr;\r\n\t\tspots = new ParkingSpot[numberSpots];\r\n\t\tint largeSpots = numberSpots / 4;\r\n\t\tint bikeSpots = numberSpots / 4;\r\n\t\tint compactSpots = numberSpots - largeSpots - bikeSpots;\r\n\t\tfor (int i = 0; i < numberSpots; i++) {\r\n\t\t\tVehicleSize sz = VehicleSize.Motorcycle;\r\n\t\t\tif (i < largeSpots) {\r\n\t\t\t\tsz = VehicleSize.Large;\r\n\t\t\t} else if (i < largeSpots + compactSpots) {\r\n\t\t\t\tsz = VehicleSize.Compact;\r\n\t\t\t}\r\n\t\t\tint row = i / SPOTS_PER_ROW;\r\n\t\t\tspots[i] = new ParkingSpot(this, row, i, sz);\r\n\t\t}\r\n\t\tavailableSpots = numberSpots;\r\n\t}\r\n\t\r\n\tpublic int availableSpots() {\r\n\t\treturn availableSpots;\r\n\t}\r\n\t\r\n\t/* Try to find a place to park this vehicle. Return false if failed. */\r\n\tpublic boolean parkVehicle(Vehicle vehicle) {\r\n\t\tif (availableSpots() < vehicle.getSpotsNeeded()) {\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tint spotNumber = findAvailableSpots(vehicle);\r\n\t\tif (spotNumber < 0) {\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\treturn parkStartingAtSpot(spotNumber, vehicle);\r\n\t}\r\n\t\r\n\t/* Park a vehicle starting at the spot spotNumber, and continuing until vehicle.spotsNeeded. */\r\n\tprivate boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {\r\n\t\tvehicle.clearSpots();\r\n\t\tboolean success = true;\r\n\t\tfor (int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++) {\r\n\t\t\t success &= spots[i].park(vehicle);\r\n\t\t}\r\n\t\tavailableSpots -= vehicle.spotsNeeded;\r\n\t\treturn success;\r\n\t}\r\n\t\r\n\t/* find a spot to park this vehicle. Return index of spot, or -1 on failure. */\r\n\tprivate int findAvailableSpots(Vehicle vehicle) {\r\n\t\tint spotsNeeded = vehicle.getSpotsNeeded();\r\n\t\tint lastRow = -1;\r\n\t\tint spotsFound = 0;\r\n\t\tfor (int i = 0; i < spots.length; i++) {\r\n\t\t\tParkingSpot spot = spots[i];\r\n\t\t\tif (lastRow != spot.getRow()) {\r\n\t\t\t\tspotsFound = 0;\r\n\t\t\t\tlastRow = spot.getRow();\r\n\t\t\t}\r\n\t\t\tif (spot.canFitVehicle(vehicle)) {\r\n\t\t\t\tspotsFound++;\r\n\t\t\t} else {\r\n\t\t\t\tspotsFound = 0;\r\n\t\t\t}\r\n\t\t\tif (spotsFound == spotsNeeded) {\r\n\t\t\t\treturn i - (spotsNeeded - 1);\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn -1;\r\n\t}\r\n\t\r\n\tpublic void print() {\r\n\t\tint lastRow = -1;\r\n\t\tfor (int i = 0; i < spots.length; i++) {\r\n\t\t\tParkingSpot spot = spots[i];\r\n\t\t\tif (spot.getRow() != lastRow) {\r\n\t\t\t\tSystem.out.print(\"  \");\r\n\t\t\t\tlastRow = spot.getRow();\r\n\t\t\t}\r\n\t\t\tspot.print();\r\n\t\t}\r\n\t}\r\n\t\r\n\t/* When a car was removed from the spot, increment availableSpots */\r\n\tpublic void spotFreed() {\r\n\t\tavailableSpots++;\r\n\t}\r\n}\r\n","Chapter":"Q7_04_Parking_Lot"}