import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css';
import HomePage from './Components/HomePage';
import Footer from './Components/Footer';
import AboutUs from './Components/AboutUs';
import ContactUs from './Components/ContactUs';

function App() {
  return (
    <div className="App">
          <BrowserRouter>
            <Routes>
              <Route path="/" element={<HomePage />} />
              <Route path="/aboutus" element={<AboutUs />} />
              <Route path="/contactus" element={<ContactUs />} />
            </Routes>
            



          </BrowserRouter>
        <Footer />
    </div>
  );
}

export default App;
