import MoviesHomePage from "../components/MoviesHomePage";
import Slider from "../components/Slider";


function HomePage() {
  return (
    <div className="sm:container mx-auto">
        <Slider />
        <MoviesHomePage />
    </div>
  );
}

export default HomePage;