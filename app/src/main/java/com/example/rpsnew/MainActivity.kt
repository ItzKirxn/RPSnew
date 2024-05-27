package com.example.rpsnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.enableEdgeToEdge
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        class MainActivity : AppCompatActivity() {

            private lateinit var resultTextView: TextView
            private lateinit var computerChoiceImageView: ImageView
            private lateinit var rockImageView: ImageView
            private lateinit var paperImageView: ImageView
            private lateinit var scissorsImageView: ImageView

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_main)

                resultTextView = findViewById(R.id.resulttextView)
                computerChoiceImageView = findViewById(R.id.computerChoiceImageView)
                rockImageView = findViewById(R.id.RockimageView)
                paperImageView = findViewById(R.id.PaperimageView)
                scissorsImageView = findViewById(R.id.ScissorsimageView)

                attachClickListener(rockImageView, "Rock")
                attachClickListener(paperImageView, "Paper")
                attachClickListener(scissorsImageView, "Scissors")
            }

            private fun attachClickListener(imageView: ImageView, choice: String) {
                imageView.setOnClickListener {
                    playGame(choice)
                }
            }

            private fun playGame(choice: String) {
                val choices = listOf("Rock", "Paper", "Scissors")
                val computerChoice = choices.random()

                setComputerChoiceImage(computerChoice)

                val result = when {
                    choice == computerChoice -> "It's a tie"
                    (choice == "Rock" && computerChoice == "Scissors") ||
                            (choice == "Paper" && computerChoice == "Rock") ||
                            (choice == "Scissors" && computerChoice == "Paper") -> "You win"

                    else -> "You lose"
                }

                resultTextView.text = result
            }

            private fun setComputerChoiceImage(computerChoice: String) {
                val imageResource = when (computerChoice) {
                    "Rock" -> R.drawable.img
                    "Paper" -> R.drawable.img_1
                    "Scissors" -> R.drawable.img_2
                    else -> throw IllegalArgumentException("Invalid choice")
                }
                computerChoiceImageView.setImageResource(imageResource)
            }
        }
    }
}

