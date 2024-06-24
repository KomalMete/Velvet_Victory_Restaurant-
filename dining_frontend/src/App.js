import { BrowserRouter as Routes, Route, Router, BrowserRouter } from 'react-router-dom';
import './App.css';
import HomePage from './Components/HomePage';
import Footer from './Components/Footer';
import AboutUs from './Components/AboutUs';
import ContactUs from './Components/ContactUs';

function App() {
  return (
    <div className="App">
          <BrowserRouter>
            
            <ContactUs></ContactUs>



          </BrowserRouter>
        <Footer />
    </div>
  );
}

export default App;
