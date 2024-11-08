import java.util.Scanner;

public class Game {
    public static void main(String[] args){

        System.out.println("Shshsh! \nGranny is asleep! Get out of there! You only have five days! \nAll you need is in the house... and be quite!\nShe hears everything and Granny is crazy...\n...Good luck. \n\nType 'start' to start the game!");

        Map gameMap = new Map(3, 5);

        Position posOfPlayer = new Position(3, 3);
        
        Position posOfParking = new Position(1, 1);
        Position posOfGuillotine = new Position(1, 2);
        Position posOfKennel = new Position(1, 3);
        Position posOfStorageRoom = new Position(2, 1);
        Position posOfDiningRoom = new Position(2, 2);
        Position posOfLivingRoom = new Position(2, 3);
        Position posOfBedroom1 = new Position(2, 4);
        Position posOfRestroom = new Position(2, 5);
        Position posOfKitchen = new Position(3, 2);
        Position posOfFoyer = new Position(3, 3);
        Position posOfLibrary = new Position(3, 4);
        Position posOfBedroom2 = new Position(3, 5);

        Inventory inventory = new Inventory();
        Score score = new Score(1);

        // gameMap.placeRoom(posOfBedroom1, 'B');
        // gameMap.placeRoom(posOfBedroom2, 'B');
        // gameMap.placeRoom(posOfParking, 'P');
        // gameMap.placeRoom(posOfFoyer, 'F');
        // gameMap.placeRoom(posOfKitchen, 'K');
        // gameMap.placeRoom(posOfDiningRoom, 'D');
        // gameMap.placeRoom(posOfLivingRoom, 'L');
        // gameMap.placeRoom(posOfRestroom, 'R');
        // gameMap.placeRoom(posOfLibrary, 'L');
        // gameMap.placeRoom(posOfStorageRoom, 'S');
        // gameMap.placeRoom(posOfGuillotine, 'G');
        // gameMap.placeRoom(posOfKennel, 'K');
        // System.out.println(gameMap.display());

        Room foyer = new Room("Foyer", "This is the foyer of Granny's house. Watch out for the hidden traps as you explore the house and find things you need to break out of the house", 'F', posOfFoyer);
        Room kitchen = new Room("Kitchen", "This is Granny's kitchen where she cooks her favourite soup of human blood and freezes it in the fridge", 'K', posOfKitchen);
        Room diningRoom = new Room("Dining Room", "This is the dining room of Granny where she sips her blood soup", 'D', posOfDiningRoom);
        Room livingRoom = new Room("Living Room", "This is where Granny relaxes watching her favorite TV show called 'Torture'.", 'L', posOfLivingRoom);
        Room bedroom1 = new Room("Bedroom 1", "Granny is sleeping in this room on her bed that makes cracking noise every time she snores. There is something on her bed that she carries with her all the time.", 'B', posOfBedroom1);
        Room restroom = new Room("Restroom", "Granny occasionally vomits blood here, and the only way to get here is through your bedroom, so make sure you pretend to sleep whenever she passes by", 'R', posOfRestroom);
        Room bedroom2 = new Room("Bedroom 2", "This is the bedroom where Granny keeps her hostages in. ", 'B', posOfBedroom2);
        Room library = new Room("Library", "This is where Granny enjoys reading stories of horror incidents happened to innocent people", 'L', posOfLibrary);
        Room storageRoom = new Room("Storage Room", "Granny keeps here deadly weapons and other equipment on the shelves of the Storage Room", 'S', posOfStorageRoom);
        Room parking = new Room("Parking", "This is the parking where Granny keeps her broken car", 'P', posOfParking);
        Room guillotine = new Room("Guillotine Area", "This is the area where Granny beheads her hostages after 5 days of imprisoning them", 'G', posOfGuillotine);
        Room kennel = new Room("Kennel", "This area is for Granny's late rabid dog that passed away after overeating vicitim bones.", 'K', posOfKennel);

        Room[] rooms = {foyer, kitchen, diningRoom, livingRoom, bedroom1, restroom, bedroom2, library, storageRoom, parking, guillotine, kennel};

        String[] roomFeatures = {"fridge", "bed", "shelves"};
        String[] searchItems = {"mattress", "cracked jar"};

        Scanner scr = new Scanner(System.in);
        String start = scr.nextLine();
        
        if(start.equals("start")){
            System.out.println("You are in the foyer of the house. To the back, there is a locked door from which you need to escape. To your front, there is a living room. There are other rooms to your left and right.");
            gameMap.placeRoom(posOfFoyer, 'F');
        } else{
            System.out.println("Please type 'start' to start the game.");
        }
        
        while (true) {
            String userCommand = scr.nextLine();

            boolean isPlayerAtEastBoundary = (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 3) || (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 5) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 5);

            boolean isPlayerAtWestBoundary = (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 1) || (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 1) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 2);

            boolean isPlayerAtNorthBoundary = (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 1) || (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 2) || (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 3) || (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 4) || (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 5);

            boolean isPlayerAtSouthBoundary = (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 1) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 2) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 3) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 4) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 5);

            boolean hasFridge = false;
            // boolean hasBed = false;
            // boolean hasShelves = false;

            Room currentRoom;

            switch (userCommand) {
                // move <direction> commands
                case "move east":
                    if(!isPlayerAtEastBoundary){
                        int playerYPos = posOfPlayer.getY();
                        posOfPlayer.setY(playerYPos + 1);
                        
                        for(int i = 0; i < rooms.length; i++){
                            if(posOfPlayer.getX() == rooms[i].getPosition().getX() && posOfPlayer.getY() == rooms[i].getPosition().getY()){
                                System.out.println(">> You go to the " + rooms[i].getName());
                                gameMap.placeRoom(rooms[i].getPosition(), rooms[i].getSymbol());
                                score.visitRoom();

                                currentRoom = rooms[i];
                            }
                        }
                    }else{
                        System.out.println(">> Cannot move east any further!");
                    }
                    break;

                case "move west":
                    if(!isPlayerAtWestBoundary){
                        int playerYPos = posOfPlayer.getY();
                        posOfPlayer.setY(playerYPos - 1);
                        
                        for(int i = 0; i < rooms.length; i++){
                            if(posOfPlayer.getX() == rooms[i].getPosition().getX() && posOfPlayer.getY() == rooms[i].getPosition().getY()){
                                System.out.println(">> You go to the " + rooms[i].getName());
                                gameMap.placeRoom(rooms[i].getPosition(), rooms[i].getSymbol());
                                score.visitRoom();

                                currentRoom = rooms[i];
                            }
                        }
                    }else{
                        System.out.println(">> Cannot move west any further!");
                    }
                    break;

                case "move north":
                    if(!isPlayerAtNorthBoundary){
                        int playerXPos = posOfPlayer.getX();
                        posOfPlayer.setX(playerXPos - 1);
                        
                        for(int i = 0; i < rooms.length; i++){
                            if(posOfPlayer.getX() == rooms[i].getPosition().getX() && posOfPlayer.getY() == rooms[i].getPosition().getY()){
                                System.out.println(">> You go to the " + rooms[i].getName());
                                gameMap.placeRoom(rooms[i].getPosition(), rooms[i].getSymbol());
                                score.visitRoom();

                                currentRoom = rooms[i];
                            }
                        }
                    }else{
                        System.out.println(">> Cannot move north any further!");
                    }
                    break;

                case "move south":
                    if(!isPlayerAtSouthBoundary){
                        int playerXPos = posOfPlayer.getX();
                        posOfPlayer.setX(playerXPos + 1);
                        
                        for(int i = 0; i < rooms.length; i++){
                            if(posOfPlayer.getX() == rooms[i].getPosition().getX() && posOfPlayer.getY() == rooms[i].getPosition().getY()){
                                System.out.println(">> You go to the " + rooms[i].getName());
                                gameMap.placeRoom(rooms[i].getPosition(), rooms[i].getSymbol());
                                score.visitRoom();

                                currentRoom = rooms[i];
                            }
                        }
                    }else{
                        System.out.println(">> Cannot move south any further!");
                    }
                    break;

                case "look":                        
                    for(int i = 0; i < rooms.length; i++){
                        if(posOfPlayer.getX() == rooms[i].getPosition().getX() && posOfPlayer.getY() == rooms[i].getPosition().getY()){
                            System.out.println(">> " + rooms[i].getDescription());
                            break;
                        }
                    }

                    break;

                case "look fridge":                        
                    for(int i = 0; i < rooms.length; i++){
                        if(rooms[i].getDescription().contains("fridge")){
                            System.out.println(">> There is an old fridge with a worn and slightly rusted exterior with faded colors in the corner of the room. As you open the fridge, a sharp metallic smell of blood fills the air.");
                            hasFridge = true;
                            break;
                        }
                    }
                    
                    System.out.println("There is no fridge in the room!");
                    break;

                
                case "look bed":                        
                    for(int i = 0; i < rooms.length; i++){
                        if(rooms[i].getDescription().contains("bed")){
                            System.out.println(">> This is Granny's bed, and it has a bleak, unsettling appearance. It's old and made of wood that's chipped and splintered in places. On the thin, sagging, and discolored mattress, there lies a hidden item that Granny carries with her all the time.");
                            // hasBed = true;
                            break;
                        }
                    }
                    
                    System.out.println("There is no bed in the room!");
                    break;

                case "look shelves":                        
                    for(int i = 0; i < rooms.length; i++){
                        if(rooms[i].getDescription().contains("shelves")){
                            System.out.println(">> The Storage room shelves are made of rough, untreated wood, and they hold random ominous items, a cracked jar for example.");
                            // hasShelves = true;
                            break;
                        }
                    }

                    System.out.println(">> There are no shelves in the room!");
                    break;
                    
                    

                case "open fridge":                        
                    for(int i = 0; i < rooms.length; i++){
                        if(rooms[i].getDescription().contains("fridge")){
                            System.out.println(">> You found a watermelon! Now figure out what to do with it!\nP.S. Granny loves hiding important things inside other items.");
                            break;
                        }
                    }
                    System.out.println("There is no fridge in the room!");
                  
                    break;

                // case "search mattress":                        
                //     // for(int i = 0; i < rooms.length; i++){
                //     //     if(rooms[i].getDescription().contains("mattress")){
                //     //         System.out.println(">> You found a hammer! Now figure out why you may want to use it!");
                //     //         break;
                //     //     }
                //     // }
                //     // System.out.println("There is no mattress in the room!");
                //     if(hasBed)
                //         System.out.println(">> You found a hammer! Now figure out why you may want to use it!");
                //     break;

                // case "search cracked jar":                        
                //     // for(int i = 0; i < rooms.length; i++){
                //     //     if(rooms[i].getDescription().contains("cracked jar")){
                //     //         System.out.println(">> You found a screwdriver!\nHint: The kennel has a screw door.");
                //     //         break;
                //     //     }
                //     // }
                //     // System.out.println("There is no cracked jar in the room!");
                //     if(hasShelves)
                //         System.out.println(">> You found a screwdriver!\nHint: The kennel has a screw door.");
                //     break;

                case "inventory":
                    System.out.println(inventory.displayInventory());
                    break;
                
                case "score":
                    System.out.println(score.getScore());
                    break;

                case "map":
                    System.out.println(gameMap.display());
                    break;

                case "help":
                    System.out.println("The list of commands:\n1. move <north/south/east/west> - The player moves to a new room based on the direction.\n2. look - Displays a description of the room the player is in.\n3. look <feature> - Displays a more detailed description of a feature of a room.\n4. look <item> - Displays a description of an item.\n5. search <item> - Searches for the item and puts it into the player's inventory.\n6. open <item> - Opens the item.\n7. chop <item> - chops an item off\n8. inventory - Displays a list of all items the player has obtained.\n9. score - Displays the player's current score.\n10. map - Displays a text-based map of the current explored game world.\n11. help - Displays a help message.\n12. quit - Quits the game.");
                    break;
                
                case "quit": 
                    return;
                    
                default:
                    System.out.println("Incorrect command! Please type 'help' to see the list of commands.");
                    break;
            } 
        }
    }
}
