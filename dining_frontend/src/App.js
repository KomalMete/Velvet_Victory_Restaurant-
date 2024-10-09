import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css';
import HomePage from './Components/HomePage';
import Footer from './Components/Footer';
import AboutUs from './Components/AboutUs';
import ContactUs from './Components/ContactUs';
import RestaurantsByCategory from "./Components/RestaurantsByCategory";
import Restaurant from "./Components/Restaurant";
import Navbar from "./Components/Navbar";

function App() {
  return (
    <div className="App">
          <BrowserRouter>
            <Routes>
              <Route path="/" element={<Navbar />} />
              <Route path="/home" element={<HomePage />} />
              <Route path="/aboutus" element={<AboutUs />} />
              <Route path="/contactus" element={<ContactUs />} />
              <Route path="/restaurants_cat/:categoryId" element={<RestaurantsByCategory />} />
              <Route path="/restaurant/:restaurantId" element={<Restaurant />} />
            </Routes>
            



          </BrowserRouter>
        <Footer />
    </div>
  );
}

export default App;
