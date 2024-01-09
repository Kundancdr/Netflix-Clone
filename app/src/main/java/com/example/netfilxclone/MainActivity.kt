package com.example.netfilxclone


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//import com.example.netfilxclone.ui.theme.NetfilxCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ) {
              TopAppSection()
                NetFlixContentChooser()
                FeaturedMovieSection()
                AddMovieList(movieType = "Watch It Again ")
                AddMovieList(movieType = "Drama Movies")
                AddMovieList(movieType = "Action Movies")
                AddMovieList(movieType = "Romantic Movies")
                AddMovieList(movieType = "New Relese Movie")
                AddMovieList(movieType = " Horror Movied")
                AddMovieList(movieType = " Hollywood Movies")
                AddMovieList(movieType = "Bollywood Movies")
                AddMovieList(movieType = "Korean Drama")


            }



        }
    }
    @Preview
    @Composable
    fun TopAppSection(){
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(top = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,



        
        ) {
            Image(painter = painterResource(id = R.drawable.netflixoriginal),
                contentDescription ="icon",
                modifier = Modifier.size(50.dp)
            )

        Row {
            Image(painter = painterResource(id = R.drawable.ic_search_24),
                contentDescription ="search" ,
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(35.dp)


            )

            Image(painter = painterResource(id = R.drawable.ic_profile),
                contentDescription ="icon",
                modifier = Modifier
                    .padding(end = 6.dp)
                    .size(35.dp)
            )

        }
        }
        
    }
    @Composable
    @Preview
    fun NetFlixContentChooser(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(vertical = 12.dp),

        horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Tv shows", color =Color.Gray, fontSize = 20.sp,
                modifier = Modifier.padding(start = 25.dp)
            )

            Text(text = "Movies", color =Color.Gray, fontSize = 20.sp)
            Row() {
                Text(text = "Categories", color =Color.Gray, fontSize = 20.sp)
                Image(painter = painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24), contentDescription ="icon_drop",
                modifier = Modifier.padding(end = 10.dp)
                    )


            }

        }

    }

    @Preview
    @Composable
    fun FeaturedMovieSection(){
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(top = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.jawan),
                contentDescription = "marvel",
                modifier = Modifier.size(320.dp)
            )


            
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 60.dp, end = 60.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Adventure", color = Color.White)
                Text(text = "Thriller", color = Color.White)
                Text(text = "Drama", color = Color.White)
                Text(text = "Action", color = Color.White)
            }

                Row (modifier = Modifier
                    .padding(top = 40.dp, start = 80.dp, end = 80.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column (horizontalAlignment = Alignment.CenterHorizontally){

                        Image(painter = painterResource(id = R.drawable.ic_baseline_add_24),
                            contentDescription = "add",
                        )
                            Text(text = "My List", color = Color.White)

                    }
                    Button(onClick = { },
                    colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(4.dp)


                        ) {
                        Text(text = "Play", color = Color.Black, fontSize = 18.sp)

                    }
                    Column (horizontalAlignment = Alignment.CenterHorizontally){

                        Image(painter = painterResource(id = R.drawable.ic_baseline_info_24),
                            contentDescription = "add",
                        )
                        Text(text = "Info", color = Color.White)

                    }
                }
            }
        }

    @Composable

    fun AddMovieList(movieType: String){
        val listOfMovies = mutableListOf<MovieItemMode>()
        listOfMovies.add(MovieItemMode(R.drawable.movie2))
        listOfMovies.add(MovieItemMode(R.drawable.movie11))
        listOfMovies.add(MovieItemMode(R.drawable.movie10))
        listOfMovies.add(MovieItemMode(R.drawable.movie4))
        listOfMovies.add(MovieItemMode(R.drawable.movie9))
        listOfMovies.add(MovieItemMode(R.drawable.movie3))
        listOfMovies.add(MovieItemMode(R.drawable.movie5))
        listOfMovies.add(MovieItemMode(R.drawable.movie13))
        listOfMovies.add(MovieItemMode(R.drawable.movie7))
        listOfMovies.add(MovieItemMode(R.drawable.movie8))
        listOfMovies.add(MovieItemMode(R.drawable.movie6))



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        
        ) {
            Text(text = "movieType",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.padding(top = 20.dp, start = 12.dp)
            )
            LazyRow(
                modifier = Modifier.padding(top = 4.dp)
            ){
                itemsIndexed(listOfMovies){index, item ->
                    MovieItemsUiModel(imageRes = item.image)

                }

            }
        }
    }
    @Composable
   // @Preview
    fun MovieItemsUiModel(
        imageRes:Int
    ){
        Image(painter = painterResource(id = imageRes),
            contentDescription = "",
                modifier = Modifier
                    .height(180.dp)
                    .width(132.dp)
        )
    }

//fun getRandomMovieList():List<MovieItemMode>{
//        val listOfMovies = mutableListOf<MovieItemMode>()
//        listOfMovies.add(MovieItemMode(R.drawable.movie2))
//        listOfMovies.add(MovieItemMode(R.drawable.movie11))
//        listOfMovies.add(MovieItemMode(R.drawable.movie10))
//        listOfMovies.add(MovieItemMode(R.drawable.movie4))
//        listOfMovies.add(MovieItemMode(R.drawable.movie9))
//        listOfMovies.add(MovieItemMode(R.drawable.movie3))
//        listOfMovies.add(MovieItemMode(R.drawable.movie5))
//        listOfMovies.add(MovieItemMode(R.drawable.movie13))
//        listOfMovies.add(MovieItemMode(R.drawable.movie7))
//        listOfMovies.add(MovieItemMode(R.drawable.movie8))
//        listOfMovies.add(MovieItemMode(R.drawable.movie6))
//
//
//        listOfMovies.shuffle()
//        return listOfMovies
//
//   }
    }
 data class MovieItemMode(
     val image:Int
 )

        
    


