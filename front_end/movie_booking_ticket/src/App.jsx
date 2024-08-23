import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
// import ProtectedRoute from './components/ProtectedRoute';
import MainLayout from './layouts/MainLayout';
import HomePage from './pages/HomePage';
import CurrentMoviePage from './pages/CurrentMoviePage';
import MovieDetailPage from './pages/MovieDetailPage';
import BookingPage from './pages/BookingPage';
import Login from './pages/Login';
import Register from './pages/Register';
import BookingSuccessPage from './pages/BookingSuccessPage';
import BookingHistoryPage from './pages/BookingHistoryPage';

function App() {
  return (
    
      <Router>
        <Routes>
          <Route path="/" element={<MainLayout />}>
            <Route index element={<HomePage />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/currentMovies" element={<CurrentMoviePage />} />
            <Route path="/movies/:id" element={<MovieDetailPage />} />
            <Route path="/booking/:id" element={<BookingPage />} />
            <Route path="/success" element={<BookingSuccessPage/>} />
            <Route path="bookingHistory" element={<BookingHistoryPage/>} />
            {/* <Route
              path="/user"
              element={
                <ProtectedRoute>
                  <UserPage />
                </ProtectedRoute>
              }
            /> */}
          </Route>
        </Routes>
      </Router>
  );
}

export default App;