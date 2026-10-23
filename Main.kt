
import kotlin.random.Random

fun main() {
    var health = 100
    var coins = 0
    var roomsCleared = 0

    println("================================")
    println("       SHADOW QUEST")
    println("      DUNGEON ESCAPE")
    println("================================")
    println("Escape from 3 dangerous rooms!")
    println("Health: $health | Coins: $coins")

    while (health > 0 && roomsCleared < 3) {
        println("\n--- ROOM ${roomsCleared + 1} ---")
        println("1. Enter the left passage")
        println("2. Enter the right passage")
        print("Choose your path (1 or 2): ")

        val choice = readLine()?.trim()

        if (choice != "1" && choice != "2") {
            println("Invalid choice! Enter 1 or 2.")
            continue
        }

        println("\nYou enter the passage...")
        
        when (Random.nextInt(1, 4)) {
            1 -> {
                val found = Random.nextInt(10, 31)
                coins += found
                println("TREASURE! You found $found coins!")
            }

            2 -> {
                val damage = Random.nextInt(10, 26)
                health -= damage
                println("TRAP! You lost $damage health.")
            }

            3 -> {
                val oldHealth = health
                health = minOf(100, health + 20)
                println("POTION! You recovered ${health - oldHealth} health.")
            }
        }

        roomsCleared++

        println("Health: $health | Coins: $coins")
        println("Rooms cleared: $roomsCleared / 3")
    }

    println("\n================================")

    if (health > 0 && roomsCleared == 3) {
        println("YOU ESCAPED THE DUNGEON!")
        println("Congratulations, adventurer!")
    } else {
        println("GAME OVER!")
        println("The dungeon defeated you.")
    }

    println("Final coins: $coins")
    println("Rooms cleared: $roomsCleared / 3")
    println("Thanks for playing SHADOW QUEST!")
    println("================================")
}
