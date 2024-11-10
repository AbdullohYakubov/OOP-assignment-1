import java.util.Scanner;

public class Game {
    public static void main(String[] args){

        System.out.println("Shshsh! \nGranny is asleep! Get out of there! You only have five days! \nAll you need is in the house... and be quite!\nShe hears everything and Granny is crazy...\n...Good luck. \n\n");

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

        Room foyer = new Room("Foyer", "This is the foyer of Granny's house. This is the only exit in the house. The door is locked in three ways: door lock, padlock, and planks.", 'F', posOfFoyer);
        Room kitchen = new Room("Kitchen", "This is Granny's kitchen where she cooks her favourite human blood soup and keeps it in the fridge.", 'K', posOfKitchen);
        Room diningRoom = new Room("Dining Room", "This is Granny's dining room where she enjoys the soup. There is nothing really special about this room.", 'D', posOfDiningRoom);
        Room livingRoom = new Room("Living Room", "Dim, eerie room with cracked walls, dusty floors, shadowed corners, and a chilling, unsettling atmosphere throughout.", 'L', posOfLivingRoom);
        Room bedroom1 = new Room("Bedroom 1", "A dark, cramped bedroom with peeling wallpaper and creaky floors; Granny lies asleep on her bed, an object beside her.", 'B', posOfBedroom1);
        Room restroom = new Room("Restroom", "A claustrophobic, grimy restroom with dark stains on cracked tiles, echoing a faint stench of blood. Granny occasionally stumbles in, retching, and you're forced to feign sleep as she passes through your room.", 'R', posOfRestroom);
        Room bedroom2 = new Room("Bedroom 2", "A bleak, stifling room heavy with despair, where Granny confines her hostages. Shadows cling to every corner, amplifying the eerie silence.", 'B', posOfBedroom2);
        Room library = new Room("Library", "A dim, oppressive library filled with dust and silence, its air thick with age and forgotten secrets.", 'L', posOfLibrary);
        Room storageRoom = new Room("Storage Room", "A cramped, shadowy storage room with dusty shelves lining the walls, holding various objects shrouded in gloom and mystery.", 'S', posOfStorageRoom);
        Room parking = new Room("Parking", "This is the parking where Granny keeps her broken car", 'P', posOfParking);
        Room guillotine = new Room("Guillotine Area", "A chilling, oppressive space where a rusted guillotine stands, waiting for its grim purpose after days of captivity.", 'G', posOfGuillotine);
        Room kennel = new Room("Kennel Area", "A dark, grimy area with a kennel tucked in the corner, its door secured tightly with a screw lock.", 'K', posOfKennel);
        Room currentRoom = foyer;
        Room[] rooms = {foyer, kitchen, diningRoom, livingRoom, bedroom1, restroom, bedroom2, library, storageRoom, parking, guillotine, kennel};

        Scanner scr = new Scanner(System.in);

        while(true){
            System.out.println("Type 'start' to start the game!");
            String startCommand = scr.nextLine();

            if(startCommand.toLowerCase().trim().equals("start")){
                // scr.close();
                break;
            }
        }
        
        System.out.println(">> " + foyer.getDescription());
        gameMap.placeRoom(posOfFoyer, 'F');
        score.visitRoom();
        
        boolean hasWatermelon = false;
        boolean hasHammer = false;
        boolean hasScrewdriver = false;

        boolean hasMainKey = false;
        boolean brokePlanks = false;
        boolean hasPadlockKey = false;

        boolean usedMainKey = false;
        boolean usedPadlockKey = false;
        
        while (true) {
            String userCommand = scr.nextLine();

            boolean isPlayerAtEastBoundary = (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 3) || (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 5) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 5);

            boolean isPlayerAtWestBoundary = (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 1) || (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 1) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 2);

            boolean isPlayerAtNorthBoundary = (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 1) || (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 2) || (posOfPlayer.getX() == 1 && posOfPlayer.getY() == 3) || (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 4) || (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 5);

            boolean isPlayerAtSouthBoundary = (posOfPlayer.getX() == 2 && posOfPlayer.getY() == 1) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 2) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 3) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 4) || (posOfPlayer.getX() == 3 && posOfPlayer.getY() == 5);

            switch (userCommand.toLowerCase().trim()) {
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
                    } else
                        System.out.println(">> Cannot move east any further!");
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
                    } else
                        System.out.println(">> Cannot move west any further!");
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
                    } else
                        System.out.println(">> Cannot move north any further!");
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
                    } else
                        System.out.println(">> Cannot move south any further!");
                    break;

                case "look":                        
                    System.out.println(">> " + currentRoom.getDescription());
                    break;

                case "look fridge":                        
                    if(currentRoom.getName().equals("Kitchen"))
                        System.out.println(">> There is an old fridge with a worn and slightly rusted exterior with faded colors in the corner of the room. As you open the fridge, a sharp metallic smell of blood fills the air.");
                    else
                        System.out.println(">> There is no fridge in the room!");
                    break;

                
                case "look bed":                        
                    if(currentRoom.getName().equals("Bedroom 1"))
                        System.out.println(">> This is Granny's bed, and it has a bleak, unsettling appearance. It's old and made of wood that's chipped and splintered in places. On the thin, sagging, and discolored mattress, there lies a hidden item that Granny carries with her all the time.");
                    else
                        System.out.println(">> There is no bed in the room!");
                    break;

                case "look shelves":                        
                    if(currentRoom.getName().equals("Storage Room"))
                        System.out.println(">> The Storage room shelves are made of rough, untreated wood, and they hold random ominous items, a cracked jar for example.");
                    else
                        System.out.println(">> There are no shelves in the room!");
                    break;

                case "open fridge":    
                    if(hasWatermelon){
                        System.out.println(">> There is nothing in the fridge. You already took the watermelon!");
                        break; 
                    }
                                           
                    if(currentRoom.getName().equals("Kitchen")){
                        System.out.println(">> You found a watermelon! Now figure out what to do with it!\nP.S. Granny loves hiding important things inside other items.");
                        inventory.addItem("watermelon");
                        hasWatermelon = true;
                    }else
                        System.out.println(">> There is no fridge in the room!");
                    break;

                case "search mattress": 
                    if(hasHammer){
                        System.out.println(">> There is nothing on the bed. You already took the hammer!");
                        break; 
                    }      

                    if(currentRoom.getName().equals("Bedroom 1")){
                        System.out.println(">> You found a hammer! Now figure out why you may want to use it!");
                        inventory.addItem("hammer");
                        hasHammer = true;
                    }else
                        System.out.println(">> There is no mattress in the room!");
                    break;

                case "search jar":      
                    if(hasScrewdriver){
                        System.out.println(">> There is nothing in the jar. You already took the screwdriver!");
                        break; 
                    }          

                    if(currentRoom.getName().equals("Storage Room")){
                        System.out.println(">> You found a screwdriver!");
                        inventory.addItem("screwdriver");
                        hasScrewdriver = true;
                    }else
                        System.out.println(">> There is no jar in the room!");
                    break;
                
                case "chop watermelon": 
                    if(inventory.hasItem("watermelon") != -1 && currentRoom.getName().equals("Guillotine Area")){
                        inventory.removeItem("watermelon");
                        inventory.addItem("main key");
                        score.solvePuzzle();
                        hasMainKey = true;
                        if(brokePlanks && usedPadlockKey)
                            System.out.println(">> Whoa! You just found a Master Key! You are one step away from escape!");
                        else if(brokePlanks && hasPadlockKey)
                            System.out.println(">> Whoa! You just found a Master Key! Almost there...!");
                        else
                            System.out.println(">> Whoa! You just found a Master Key! You are one step closer to escape!");
                    }else if(inventory.hasItem("watermelon") == -1 && currentRoom.getName().equals("Guillotine Area"))
                        System.out.println(">> You do not have a watermelon in your inventory!");
                    else
                        System.out.println(">> You are not in the right place to chop the watermelon!");
                    break;

                case "break planks":
                    if(inventory.hasItem("hammer") != -1 && currentRoom.getName().equals("Foyer")){
                        score.solvePuzzle();
                        brokePlanks = true;
                        if(usedMainKey && usedPadlockKey)
                            System.out.println(">> You did it! You finally escaped the house! You got lucky man!");
                        else if(usedMainKey || usedPadlockKey)
                            System.out.println(">> Great! But careful...! She almost heard it! You are one step away from escape!");
                        else if((hasMainKey || hasPadlockKey) || (!hasMainKey && !hasPadlockKey))
                            System.out.println(">> Great! But careful...! She almost heard it! You are one step closer to escape!");
                    }else if(inventory.hasItem("hammer") == -1 && currentRoom.getName().equals("Foyer"))
                        System.out.println(">> You do not have a hammer in your inventory!");
                    else
                        System.out.println(">> You are not in the right place to use the hammer!");
                    break;

                case "open kennel":   
                    if(inventory.hasItem("screwdriver") != -1 && currentRoom.getName().equals("Kennel Area")){
                        inventory.addItem("padlock key");
                        score.solvePuzzle();
                        hasPadlockKey = true;
                        if(brokePlanks && usedMainKey)
                            System.out.println(">> Awesome! You just opened the kennel and earned a padlock key! You are one step away from escape!");
                        else if(brokePlanks && hasMainKey)
                            System.out.println(">> Awesome! You just opened the kennel and earned a padlock key! Almost there...!");
                        else
                            System.out.println(">> Awesome! You just opened the kennel and earned a padlock key! You are one step closer to escape!");
                    }else if(inventory.hasItem("screwdriver") == -1 && currentRoom.getName().equals("Kennel"))
                        System.out.println(">> You do not have the screwdriver in your inventory!");
                    else
                        System.out.println(">> You are not in the right place to use the screwdriver!");
                    break;

                case "unlock padlock":                        
                    if(hasPadlockKey && currentRoom.getName().equals("Foyer")){
                        inventory.removeItem("padlock key");
                        score.solvePuzzle();
                        usedPadlockKey = true;
                        if(brokePlanks && usedMainKey)
                            System.out.println(">> You did it! You finally escaped the house! You got lucky man!");
                        else if(brokePlanks && hasMainKey)
                            System.out.println(">> You just unlocked the padlock! You are one step away from escape!");
                        else
                            System.out.println(">> You just unlocked the padlock! You are one step closer to escape!");
                    }else if(!hasPadlockKey && currentRoom.getName().equals("Foyer"))
                        System.out.println(">> You do not have the padlock key in your inventory!");
                    else
                        System.out.println(">> You are not in the right place to unlock the padlock!");
                    break;
                
                case "unlock door":                        
                    if(hasMainKey && currentRoom.getName().equals("Foyer")){
                        inventory.removeItem("main key");
                        score.solvePuzzle();
                        usedMainKey = true;
                        if(brokePlanks && usedPadlockKey)
                            System.out.println(">> You did it! You finally escaped the house! You got lucky man!");
                        else if(brokePlanks && hasPadlockKey)
                            System.out.println(">> You just unlocked the door! Now you need to unlock the padlock!");
                        else
                            System.out.println(">> You just unlocked the door! But there is still something else you need to do!");
                    }else if(!usedMainKey && currentRoom.getName().equals("Foyer"))
                        System.out.println(">> You do not have the main key in your inventory!");
                    else
                        System.out.println(">> You are not in the right place to unlock the door!");
                    break;

                case "inventory":
                    System.out.println(inventory.displayInventory());
                    break;
                
                case "score":
                    System.out.println(">> Your current score is: " + score.getScore());
                    break;

                case "map":
                    System.out.println(gameMap.display());
                    break;

                case "help":
                    System.out.println(">> The list of commands:\n1. move <north/south/east/west> - The player moves to a new room based on the direction.\n2. look - Displays a description of the room the player is in.\n3. look <feature> - Displays a more detailed description of a feature of a room.\n4. look <item> - Displays a description of an item.\n5. search <item> - Searches for the item and puts it into the player's inventory.\n6. open <item> - Opens the item and puts what's found into the inventory.\n7. chop <item> - Chops an item off.\n8. break <item> - Breaks an item.\n9. unlock <item> - Unlocks a lock.\n10. inventory - Displays a list of all items the player has obtained.\n11. score - Displays the player's current score.\n12. map - Displays a text-based map of the current explored game world.\n13. help - Displays a help message.\n14. quit - Quits the game.");
                    break;
                
                case "quit": 
                    // scr.close();
                    return;
                    
                default:
                    System.out.println(">> Incorrect command! Please type 'help' to see the list of commands.");
                    break;
            } 
            
            if(usedMainKey && brokePlanks && usedPadlockKey)
                break;
        }   
    }
}
