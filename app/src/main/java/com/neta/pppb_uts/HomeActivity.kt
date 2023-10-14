package com.neta.pppb_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neta.pppb_uts.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    companion object{
        const val img = "img"
        const val titles = "titles"
        const val rate = "rate"
        const val director = "director"
        const val storyline = "storyline"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val interstellar = arrayOf(R.drawable.interstellar, "Interstellar", "4.6", "Christopher Nolan", "In 2067, as humanity is facing extinction following a global famine caused by ecocide, it has since abandoned scientific pursuits such as space exploration.[8] As a result, ex-NASA pilot Joseph Cooper is now forced to work as a farmer with his son Tom, daughter Murph and father-in-law Donald.")
        val batman = arrayOf(R.drawable.batman, "Batman", "4.3", "Matt Reeves", "Batman is a superhero appearing in American comic books published by DC Comics. The character was created by artist Bob Kane and writer Bill Finger, and debuted in the 27th issue of the comic book Detective Comics on March 30, 1939")
        val doraemon = arrayOf(R.drawable.doraemon, "Doraemon", "4.7", "Takumi Doyama", "Doraemon is a fictional character in the Japanese manga and anime series of the same name created by Fujiko F. Fujio. Doraemon is a male robotic earless cat that travels back in time from the 22nd century to aid a preteen boy named Nobita")
        val spiderman = arrayOf(R.drawable.spiderman, "Spiderman", "4.3", "Jon Watts", "When Spider-Man first appeared in the early 1960s, teenagers in superhero comic books were usually relegated to the role of sidekick to the protagonist. The Spider-Man comic series broke ground by featuring Peter Parker, a high school student from Queens, New York, as Spider-Man's secret identity, whose self-obsessions with rejection, inadequacy, and loneliness were issues to which young readers could relate.")
        val list = arrayOf("img", "titles", "rate", "director", "storyline")
        with(binding){
            val intentToDetailActivity = Intent(this@HomeActivity, DetailActivity::class.java)
            val username = intent.getStringExtra(LoginActivity.EXTRA_NAME)
            userLogin.text = username

            interstellarButton.setOnClickListener{
                for (i in 0..4){
                    intentToDetailActivity.putExtra(list[i], interstellar[i])
                }
                startActivity(intentToDetailActivity)
            }
            batmanButton.setOnClickListener{
                for (i in 0..4){
                    intentToDetailActivity.putExtra(list[i], batman[i])
                }
                startActivity(intentToDetailActivity)
            }
            doraemonButton.setOnClickListener{
                for (i in 0..4){
                    intentToDetailActivity.putExtra(list[i], doraemon[i])
                }
                startActivity(intentToDetailActivity)
            }
            spidermanButton.setOnClickListener{
                for (i in 0..4){
                    intentToDetailActivity.putExtra(list[i], spiderman[i])
                }
                startActivity(intentToDetailActivity)
            }
        }
    }
}
