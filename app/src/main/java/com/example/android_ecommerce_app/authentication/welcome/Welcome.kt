import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun OnboardingScreen() {
    val pageCount = 3
    val pagerState = rememberPagerState { pageCount }

    Scaffold { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {


            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> OnboardingImage(
                        imagePath = TImages.onBoardingImage1, // Utiliser la constante de TImages
                        title = "Title 1",
                        subTitle = "Subtitle 1"
                    )
                    1 -> OnboardingImage(
                        imagePath = TImages.onBoardingImage2, // Utiliser la constante de TImages
                        title = "Title 2",
                        subTitle = "Subtitle 2"
                    )
                    2 -> OnboardingImage(
                        imagePath = TImages.onBoardingImage3, // Utiliser la constante de TImages
                        title = "Title 3",
                        subTitle = "Subtitle 3"
                    )
                }
            }

            // Bouton "Skip"
            TextButton(
                onClick = { /* Action de skip */ },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
            ) {
                Text("Skip", color = Color.Gray)
            }

            // Indicateur de page
            SmoothPageIndicator(
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)
            )

            // Bouton "Next"
            Button(
                onClick = {

                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun OnboardingImage(imagePath: String, title: String, subTitle: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Charge l'image GIF depuis les assets
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("file:///android_asset/$imagePath") // Ajoutez le préfixe android_asset/
                .crossfade(true) // Transition fluide pour l'animation du GIF
                .build(),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = subTitle, fontSize = 16.sp, color = Color.Gray)
    }
}
@Composable
fun SmoothPageIndicator(pagerState: PagerState, modifier: Modifier) {
    // Implémentez ici un indicateur de page pour afficher la position actuelle
    // Vous pouvez utiliser des bibliothèques de composables comme Accompanist ou en créer une simple
}
